DESCRIPTION = "awesome is a highly configurable, next generation framework window manager for X."
SECTION = "window manager"
PRIORITY = "optional"
DEPENDS = "imlib2 xcb-util-wm xcb-util-image xcb-util-keysyms libev libxdg-basedir libev libxdg-basedir cairo luajit oopango oocairo"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"
PR = "r0"

DEFAULT_PREFERENCE ="-1"

SRC_URI="git://git.naquadah.org/awesome.git;tag=master \
		file://add_luajit.patch \
		file://disable_dbus.patch \
		"
		
inherit cmake

S="${WORKDIR}/git"

do_install_append () {

install -d ${D}/${sysconfdir}/xdg/awesome
install -m 0644 ${D}/usr/etc/xdg/awesome/rc.lua ${D}/${sysconfdir}/xdg/awesome/rc.lua

}


FILES_${PN} +="/etc/*"

SRC_URI[md5sum] = "cca11acbe9252121b10e969fce66e641"
SRC_URI[sha256sum] = "83fc42d4ea71914d1b456023ce53b546e22e8ccc11a73c4a39a1152d2f30b628"
