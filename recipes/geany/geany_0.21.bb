DESCRIPTION = "Text editor with some IDE functionality"
HOMEPAGE = "http://geany.sf.net"
SECTION = "editors"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+"
PR = "r0"
DEFAULT_PREFERENCE= "-1"
LIC_FILES_CHKSUM="file://COPYING;md5=c107cf754550e65755c42985a5d4e9c9"
SRC_URI = "http://download.geany.org/geany-0.21.tar.bz2 \
		   file://fix_checks.patch"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-plugins --disable-vte --disable-deprecated"

SRC_URI[md5sum] = "117d78ae5275c8c517686b6db9d71ef1"
SRC_URI[sha256sum] = "cc0609d4c4d3bd8cf772bc4994d51cb1f79a12da5a82f2335a381293c5123a8c"
