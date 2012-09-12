DESCRIPTION = "SpaceFM is a multi-panel tabbed file manager "
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
SECTION = "x11"
PRIORITY = "optional"
DEPENDS = "gtk+ startup-notification"
PR = "r0"
DEFAULT_PREFERENCE="-1"
SRC_URI = "git://github.com/IgnorantGuru/spacefm.git;tag=master \
		   file://remove_new_api.patch \
		   "
S="${WORKDIR}/git"

#SELECTED_OPTIMIZATION="-O0 -g -fno-omit-frame-pointer"
#TARGET_CC_ARCH = "-march=armv5te -mtune=xscale"


inherit autotools pkgconfig
EXTRA_OECONF=" --disable-superuser-checks --disable-nls"


do_install_append () {
	install -d ${D}/${datadir}

}




