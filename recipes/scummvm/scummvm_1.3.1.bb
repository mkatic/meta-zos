require scummvm.inc

DEPENDS = "virtual/libsdl libvorbis libogg zlib \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'libmad mpeg2dec', d)}"

PR = "${INC_PR}.1"

SRC_URI_append_openmoko = " file://openmoko-scummvm "
SRC_URI_append_shr = " file://openmoko-scummvm "

SRC_URI_OVERRIDES_PACKAGE_ARCH = "1"

# Make this a plugin enabled build. Bigger binary, less memory usage. Makes more games run on lower end platforms.
# These plugins are not normal Linux shared libs so will fall foul of the sanity checker.
INSANE_SKIP_${PN} = "True"
EXTRA_OECONF += " --enable-plugins --enable-release --default-dynamic \
				  --disable-hq-scalers --disable-translation"

# Workaround, because some env variables aren't recognised correctly
do_configure_append() {
	sed -i "s/AS := as/AS := ${AS}/" ${S}/config.mk
	sed -i "s/AR := ar cru/AR := ${AR} cru/" ${S}/config.mk
	sed -i "s/STRIP := strip/STRIP := ${STRIP}/" ${S}/config.mk
	sed -i "s/RANLIB := ranlib/RANLIB := ${RANLIB}/" ${S}/config.mk
}

do_install_append() {
	if [ -f ${WORKDIR}/openmoko-scummvm ]; then
		install -d ${D}${bindir}
		install -m 0755 ${WORKDIR}/openmoko-scummvm ${D}${bindir}/openmoko-scummvm
	fi
	if  [ -f ${WORKDIR}/scummvm.desktop ]; then
		install -d ${D}${datadir}/applications
		install -m 0644 ${WORKDIR}/scummvm.desktop ${D}${datadir}/applications
	fi
}

SRC_URI[md5sum] = "87e5076e93bfa762f1c5d7f45b41d4e2"
SRC_URI[sha256sum] = "b25dc7f7e26ed6df3d901043efb2337a525df4dd3cd1589e772733cfa90037f6"
