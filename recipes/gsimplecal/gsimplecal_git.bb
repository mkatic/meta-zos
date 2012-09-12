DESCRIPTION = "Gsimplecal is a lightweight calendar applet written in C++ using GTK2."
SECTION = "X11/apps"
PRIORITY = "optional"
DEPENDS = "gtk+"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=cbf8d5c431cb4d4d37667775df922a1d"
PR = "r0"
 
inherit autotools
 
SRC_URI="git://github.com/dmedvinsky/gsimplecal.git;tag=master"

S="${WORKDIR}/git"
