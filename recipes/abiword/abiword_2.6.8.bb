require abiword-2.5.inc
RCONFLICTS_${PN} = "abiword-embedded"

DEPENDS+="librsvg"

PR = "r2"

SRC_URI = "http://www.abisource.com/downloads/abiword/${PV}/source/abiword-${PV}.tar.gz;name=abiword \
           file://autogen-common.sh \
           "

LIC_FILES_CHKSUM = "file://COPYING;md5=ecd3ac329fca77e2d0e412bec38e1c20"

EXTRA_OECONF = " --disable-static  \
                 --without-gnomevfs \
                 --disable-printing \
                 --disable-spellcheck \
                 --enable-extra-optimization \
                 "

do_configure() {
    install -m 0755 ${WORKDIR}/autogen-common.sh ${S}/autogen-common.sh
    cd ${S}
    ./autogen-common.sh
    autotools_do_configure
}

FILES_${PN} 			+= "${libdir}/libabiword-*.so ${datadir}/mime-info ${datadir}/abiword-${SHRT_VER}/certs ${datadir}/abiword-${SHRT_VER}/ui ${datadir}/abiword-${SHRT_VER}/xsl* ${datadir}/abiword-${SHRT_VER}/mime-info ${datadir}/abiword-${SHRT_VER}/Pr*.xml"
FILES_abiword-strings           += "${datadir}/abiword-${SHRT_VER}/strings"
FILES_abiword-systemprofiles    += "${datadir}/abiword-${SHRT_VER}/system.profile*"

FILES_${PN}-dev += "${libdir}/abiword-${SHRT_VER}/plugins/*.la"
FILES_${PN}-dbg += "${libdir}/abiword-${SHRT_VER}/plugins/.debug"
FILES_${PN}-doc += "${datadir}/abiword-*/readme*"

SRC_URI[abiword.md5sum] = "fab04d8ef999c303f720197adf261310"
SRC_URI[abiword.sha256sum] = "b6656a0da13d94b334f02637c89d8fe13aa54752040ad1b8f14f668d8cb96e93"

