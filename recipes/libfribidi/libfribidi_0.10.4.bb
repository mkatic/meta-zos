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

