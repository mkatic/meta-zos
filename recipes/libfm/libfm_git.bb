DESCRIPTION = "Library for file management"
HOMEPAGE = "http://pcmanfm.sourceforge.net/"
BUGTRACKER = ""

LICENSE = "GPLv2 & GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
#SELECTED_OPTIMIZATION="-O0 -g -fno-omit-frame-pointer"				
SECTION = "x11/libs"
DEPENDS = "gtk+ menu-cache intltool-native"

PR = "r1"

EXTRA_OECONF="--enable-demo"

S="${WORKDIR}/git"

SRC_URI = "git://pcmanfm.git.sourceforge.net/gitroot/pcmanfm/libfm;tag=0.1.15 \
		   file://remove_xml-purge.patch \
		   file://null_pointer_fix.patch"
		  
do_configure_prepend () {

gtkdocize

}

SRC_URI[md5sum] = "a97e03d973e6ac727f28d0934d6c9ad5"
SRC_URI[sha256sum] = "1740681cff4cd4c5a2eaa9805d8898269cfb6a49a0bda0acb242def15bc7131b"

inherit autotools pkgconfig
