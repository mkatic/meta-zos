DESCRIPTION = "Zos default Awesome rc.lua"
SECTION = "X11/apps"
PRIORITY = "optional"
DEPENDS = "awesome awesome-cal-widget awesome-obvious-widgets"
LICENSE = ""
PR = "r0"
 
SRC_URI="file://rc.lua"

S="${WORKDIR}"

do_configure () {
:
}

do_qa_configure () {
:
}

do_install () {

install -d ${D}/etc/xdg/awesome/
install ${S}/rc.lua ${D}/etc/xdg/awesome/rc.lua

}

pkg_preinst_${PN} () {

	if [ -e "/etc/xdg/awesome/rc.lua" ] then
		echo "Found existing rc.lua. Renaming it to rc.lua_old."
		mv /etc/xdg/awesome/rc.lua /etc/xdg/awesome/rc.lua_old
	fi
	
}

pkg_postrm_${PN} () {
	
	if [ -e "/etc/xdg/awesome/rc.lua_old" ] then
		echo "Restoring previously saved rc.lua."
		mv /etc/xdg/awesome/rc.lua_old /etc/xdg/awesome/rc.lua
	fi
	
}

PACKAGES = "${PN}"

FILES_${PN} = "/etc/*"
