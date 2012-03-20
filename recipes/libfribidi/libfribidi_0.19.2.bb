DESCRIPTION = "Fribidi library for bidirectional text"
SECTION = "libs"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"
inherit autotools pkgconfig

PR = "r0"

S = "${WORKDIR}/fribidi-${PV}"

SRC_URI = "http://fribidi.org/download/fribidi-0.19.2.tar.gz"

#PACKAGES += " ${PN}-bin"
FILES_${PN} = "${libdir}/lib*.so.*"
#FILES_${PN}-bin = "${libdir}/uu*"

SRC_URI[md5sum] = "626db17d2d99b43615ad9d12500f568a"
SRC_URI[sha256sum] = "49cf91586e48b52fe25872ff66c1da0dff0daac2593f9f300e2af12f44f64177"


