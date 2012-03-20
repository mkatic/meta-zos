LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
DESCRIPTION = "File manager"
SECTION = "x11"
PRIORITY = "optional"
DEPENDS = "gtk+ gamin libfm startup-notification"
PR = "r1"

SRC_URI = "git://pcmanfm.git.sourceforge.net/gitroot/pcmanfm/pcmanfm;tag=0.9.7-rc1"

S="${WORKDIR}/git"

#TARGET_CC_ARCH = "-march=armv5te -mtune=xscale"

inherit autotools pkgconfig
EXTRA_OECONF="--disable-nls"


do_install_append () {
	install -d ${D}/${datadir}

}

SRC_URI[md5sum] = "d7a121c5d761775ddc455c4961b6283d"
SRC_URI[sha256sum] = "ea1833d4425ff2c6d70a0c3de0aff7d55c9f53c1a8bb3271e0bc9f9ef71734fe"
