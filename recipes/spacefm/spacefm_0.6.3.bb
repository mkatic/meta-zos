DESCRIPTION = "SpaceFM is a multi-panel tabbed file manager "
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
SECTION = "x11"
PRIORITY = "optional"
DEPENDS = "gtk+ startup-notification"
PR = "r4"

SRC_URI = "${SOURCEFORGE_MIRROR}/spacefm/spacefm-${PV}.tar.xz \
		   "

#SELECTED_OPTIMIZATION="-O0 -g -fno-omit-frame-pointer"
#TARGET_CC_ARCH = "-march=armv5te -mtune=xscale"


inherit autotools pkgconfig
EXTRA_OECONF=" --disable-superuser-checks --disable-nls"


do_install_append () {
	install -d ${D}/${datadir}

}

SRC_URI[md5sum] = "d59127cfaebb231bc361f5244efed9cf"
SRC_URI[sha256sum] = "29479244293fcba41c7f0c989dc5fa83175f7a1869b6982cb675cfc4ec4918cf"


