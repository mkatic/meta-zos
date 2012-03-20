DESCRIPTION = "A lightweight PDF viewer and toolkit written in portable C."
HOMEPAGE = "http://www.mupdf.com"
SECTION = "x11/applications"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM="file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
PR = "r0"

DEPENDS = "openjpeg-native jbig2dec-native jpeg-native freetype-native libpng-native openjpeg jbig2dec jpeg zlib virtual/libx11 libxext freetype"

SRC_URI = "git://git.ghostscript.com/mupdf.git;tag=master \
           file://Makerules \
		   "

SRC_URI_append_jlime = " file://keybindings.patch file://mupdf.desktop "

S = "${WORKDIR}/git"

PACKAGES =+ "${PN}-tools ${PN}-tools-doc "
FILES_${PN}-tools = "${bindir}/pdfclean ${bindir}/pdfdraw ${bindir}/pdfshow \
                     ${bindir}/pdfextract ${bindir}/pdfinfo"
FILES_${PN}-tools-doc = "${mandir}/man1/pdfclean.1 ${mandir}/man1/pdfdraw.1 \
                         ${mandir}/man1/pdfshow.1"

# mupdf crashes (at least on arm) when built with high level of optimization
# so we need to provide some safe settings
# FULL_OPTIMIZATION = "-O2"

# Compilation is broken with ccache so we disable it.
CCACHE = ""

do_configure() {
    cp ${WORKDIR}/Makerules ${S}/Makerules

    # we don't include CJK fonts to make binary more slim
    # comment out following two lines if you need support for CJK
    sed -i 's:^\t\$.GENDIR./font_cjk.c::g' ${S}/Makefile
    echo "CFLAGS += -DNOCJK" >> ${S}/Makerules
}

do_configure_append_jlime() {
    mv ${WORKDIR}/mupdf.desktop ${S}/debian/
}

do_compile() {
    # mupdf uses couple of tools for code generation during build process
    # so we need to compile them first with host compiler
    unset CFLAGS LDFLAGS
    export PKG_CONFIG_PATH=${STAGING_LIBDIR_NATIVE}/pkgconfig

    oe_runmake CC=${BUILD_CC} LDFLAGS+="-L${STAGING_LIBDIR_NATIVE} -Wl,-rpath,${STAGING_LIBDIR_NATIVE}" build=release verbose=1 build/release
    oe_runmake CC=${BUILD_CC} LDFLAGS+="-L${STAGING_LIBDIR_NATIVE} -Wl,-rpath,${STAGING_LIBDIR_NATIVE}" build=release verbose=1 build/release/cmapdump
    oe_runmake CC=${BUILD_CC} LDFLAGS+="-L${STAGING_LIBDIR_NATIVE} -Wl,-rpath,${STAGING_LIBDIR_NATIVE}" build=release verbose=1 build/release/fontdump
	
	
    export PKG_CONFIG_PATH=${STAGING_LIBDIR}/pkgconfig
    # ...and then we fire 'make', feeding proper
    # cross-compilation flags through Makerules file
    echo "CFLAGS += ${CFLAGS}" >> ${S}/Makerules
    echo "LDFLAGS += ${LDFLAGS}" >> ${S}/Makerules
    oe_runmake verbose=1 build=release LD="${CC}"
}

do_install() {
    oe_runmake install prefix="${D}/usr"
    install -d ${D}/${datadir}/applications
    install -d ${D}/${datadir}/pixmaps
    install -d ${D}/${mandir}/man1
    install -m 0644 ${S}/debian/mupdf.xpm ${D}/${datadir}/pixmaps/
    install -m 0644 ${S}/debian/mupdf.desktop ${D}/${datadir}/applications/
    install -m 0644 ${S}/debian/*.1 ${D}/${mandir}/man1/
}
