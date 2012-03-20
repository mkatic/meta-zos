DESCRIPTION = "openbox Window Manager"
SECTION = "x11/wm"
DEPENDS = ""
LICENSE="GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
SRC_URI = "http://icculus.org/openbox/releases/openbox-${PV}.tar.gz"

inherit autotools gettext update-alternatives

EXTRA_OECONF += "--disable-xcursor --disable-session-management --disable-xinerama --disable-xsync --disable-nls"

PACKAGES += "lxde-icon-theme"
FILES_${PN} += "${datadir}/lxde/ ${datadir}/lxpanel ${datadir}/xsessions"
FILES_lxde-icon-theme = "${datadir}/icons"

PACKAGES_DYNAMIC += "${PN}-theme-*"

python populate_packages_prepend() {
	theme_dir = bb.data.expand('${datadir}/themes/', d)
	theme_name = bb.data.expand('${PN}-theme-%s', d)
	do_split_packages(d, theme_dir, '(.*)', theme_name, '${PN} theme for %s', extra_depends='', allow_dirs=True)
}

ALTERNATIVE_PATH = "${bindir}/openbox"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "10"

SRC_URI[md5sum] = "00441b53cf14c03566c8e82643544ff9"
SRC_URI[sha256sum] = "6fa90016530b3aa6102e254079461977439398531fb23e7ec076ff2c140fea0a"
