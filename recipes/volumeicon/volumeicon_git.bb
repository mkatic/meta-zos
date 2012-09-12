DESCRIPTION = "Volume Icon aims to be a lightweight volume control that sits in your systray."
SECTION = "X11/apps"
PRIORITY = "optional"
DEPENDS = "gtk+"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
PR = "r0"

inherit autotools
 
SRC_URI="git://github.com/Maato/volumeicon.git;tag=master \
		file://ripout_keybinding.patch \
		"

S="${WORKDIR}/git"
