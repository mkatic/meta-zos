DESCRIPTION = "Evfilter is userspace library for filtering/modifying input events from the linux kernel input layer."
SECTION = "library"
PRIORITY = "optional"
DEPENDS = ""
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
PR = "r0"

inherit autotools 

SRC_URI="file://libevfilter.tar.bz2 \
		file://autotooled.patch \
		"

S="${WORKDIR}/libevfilter"

FILES_${PN} += "${libdir}/libevfilter*"

FILES_${PN}-dev = "${includedir}/* \
				${libdir}/pkgconfig/* \
				"
