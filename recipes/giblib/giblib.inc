SECTION = "libs"
DESCRIPTION = "giblib is a utility library that incorporates doubly linked \
lists, some string functions, and a wrapper for imlib2."
LICENSE = "BSD"
LIC_FILES_CHKSUM="file://COPYING;md5=dd3cb8d7a69f3d0b2a52a46c92389011"
DEPENDS = "virtual/imlib2"

SRC_URI = "http://linuxbrit.co.uk/downloads/giblib-${PV}.tar.gz \
	   file://binconfig.patch"
S = "${WORKDIR}/giblib-${PV}"

inherit autotools pkgconfig binconfig

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir}/giblib-config"
