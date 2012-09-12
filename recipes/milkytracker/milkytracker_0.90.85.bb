DESCRIPTION="MilkyTracker is an open source, multi-platform music application for creating .MOD and .XM module files."
SECTION="multimedia"
LICENSE="gplv2"
LIC_FILES_CHKSUM="file://COPYING;md5=32da7ae1c26cc5f2486e989afeaf9e18"
DEPENDS="virtual/libsdl"
SRC_URI= "http://milkytracker.org/files/${PN}-${PV}.tar.bz2 \
		  file://various_fixes.patch \
		 "

inherit autotools 

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"

TARGET_CXXFLAGS += "-fpermissive -D__LOWRES__"
TARGET_CFLAGS += "-fpermissive -D__LOWRES__"

SRC_URI[md5sum] = "2e6795b0bff18b087bd7e4c658f512f3"
SRC_URI[sha256sum] = "59a0d294d63752be74b157e07b0c70252c9198c312d9b1ad0ca460129fe5bd80"
