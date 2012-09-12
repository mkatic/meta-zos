DESCRIPTION = "PNMixer is a simple mixer application designed to run in your system tray."
SECTION = "X11/apps"
PRIORITY = "optional"
DEPENDS = "alsa-lib gtk+"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
PR = "r0"
 
inherit autotools pkgconfig
 
SRC_URI="git://github.com/nicklan/pnmixer.git;tag=master"

S="${WORKDIR}/git"
