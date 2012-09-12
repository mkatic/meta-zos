LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
DESCRIPTION = "procfs tools"
SECTION = "x11"
PRIORITY = "optional"
DEPENDS = "gtk+ gamin startup-notification"
PR = "r4"

SRC_URI = "${SOURCEFORGE_MIRROR}/pcmanfm-mod/pcmanfm-mod-1.2.3.tar.xz \
		   file://g_unref_null_test.patch \
		   file://remove_user_options.patch \
		   file://remove_columns.patch \
		   file://resize_desktop_on_rotate.patch \
		   "

#SELECTED_OPTIMIZATION="-O0 -g -fno-omit-frame-pointer"

inherit autotools pkgconfig
EXTRA_OECONF=" --disable-hal --disable-superuser-checks --disable-nls"


do_install_append () {
	install -d ${D}/${datadir}

}

SRC_URI[md5sum] = "d7a121c5d761775ddc455c4961b6283d"
SRC_URI[sha256sum] = "ea1833d4425ff2c6d70a0c3de0aff7d55c9f53c1a8bb3271e0bc9f9ef71734fe"
