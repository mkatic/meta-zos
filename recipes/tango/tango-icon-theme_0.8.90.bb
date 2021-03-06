SECTION = "unknown"

LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=b66026716fdf499434f80b11851a6cdd"

inherit gnome

SRC_URI = "http://tango.freedesktop.org/releases/${PN}-${PV}.tar.gz \
		   file://no-icon-naming-utils.patch"
EXTRA_OECONF = "--disable-icon-framing"

PACKAGE_ARCH = "all"
FILES_${PN} += "${datadir}/icons"

SRC_URI[md5sum] = "0795895d2f20eddcbd2bffe94ed431a6"
SRC_URI[sha256sum] = "6e98d8032d57d818acc907ec47e6a718851ff251ae7c29aafb868743eb65c88e"
