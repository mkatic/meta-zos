DESCRIPTION = "Cairo bindings for lua"
SECTION = "X11/libs"
PRIORITY = "optional"
DEPENDS = "cairo gtk+ luajit"
LICENSE = ""
LIC_FILES_CHKSUM="file://COPYRIGHT;md5=bdaa0c8d6486f931eee981a60edcf914"
PR = "r0"

inherit autotools 

SRC_URI="git://git.naquadah.org/oocairo.git;tag=master \
		file://add_luajit.patch \
		"

S="${WORKDIR}/git"
