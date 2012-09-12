DESCRIPTION = "Calendar popup for Awesome widgets"
SECTION = "X11/apps"
PRIORITY = "optional"
DEPENDS = "awesome"
LICENSE = ""
PR = "r0"
 
SRC_URI="git://github.com/Mic92/awesome-dotfiles.git;tag=master"

S="${WORKDIR}/git"


do_configure () {
:
}

do_qa_configure () {
:
}

do_install () {

install -d ${D}/usr/share/awesome/lib/
install ${S}/cal.lua ${D}/usr/share/awesome/lib/cal.lua
}
PACKAGES = "${PN}"
FILES_${PN} ="/usr/share/*"
