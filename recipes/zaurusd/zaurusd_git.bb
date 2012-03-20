DESCRIPTION = "backlight and suspend daemon for zaurusd pda"
SECTION = "daemon"
PRIORITY = "optional"
DEPENDS = "libevfilter"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://README;md5=68ecae10625b0a9ecb98f7f27a6fac06"
PR = "r0"

inherit autotools update-rc.d

SRC_URI="git://metan.lindevdoc.org:git/zaurusd.git/.git;tag=master \
		file://autotooled.patch \		
		file://find_evdev.patch \
		file://usb_switching.patch \
		file://x_rotation.patch \
		"
S="${WORKDIR}/git"

#SELECTED_OPTIMIZATION="-O0 -g -fno-omit-frame-pointer"

EXTRA_OECONF = "--enable-usb-switching --enable-kdrive-rotation"

INITSCRIPT_NAME = "zaurusd"
INITSCRIPT_PARAMS = "start 30 3 5 . stop 30 0 1 6 ."
