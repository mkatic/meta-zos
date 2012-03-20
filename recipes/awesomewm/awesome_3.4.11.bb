DESCRIPTION = "awesome is a highly configurable, next generation framework window manager for X."
SECTION = "window manager"
PRIORITY = "optional"
DEPENDS = "imlib2 xcb-util-wm xcb-util-image libev libxdg-basedir cairo luajit"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"
PR = "r0"
 
SRC_URI="http://awesome.naquadah.org/download/awesome-${PV}.tar.bz2 \
		file://add_luajit.patch \
		file://remove_check.patch \
		file://disable_dbus.patch \
		file://remove_debug.patch \
		"
		
inherit cmake

SRC_URI[md5sum] = "cca11acbe9252121b10e969fce66e641"
SRC_URI[sha256sum] = "83fc42d4ea71914d1b456023ce53b546e22e8ccc11a73c4a39a1152d2f30b628"
