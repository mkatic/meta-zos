DESCRIPTION = "GnGeo is a fast and powerful command line Neo Geo emulator"
SECTION = "console/games"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=15969273699440f9449cf74b98e9c05f"
PR = "r0"
SELECTED_OPTIMIZATION="-O0 -g -fno-omit-frame-pointer"
DEFAULT_PREFERENCE="-1"

inherit autotools

export SDL_CONFIG = "${STAGING_BINDIR_CROSS}/sdl-config"
SRC_URI="http://gngeo.googlecode.com/files/gngeo-0.8.tar.gz"

EXTRA_OECONF="--enable-embedded"

SRC_URI[md5sum] = "21055885694e9f6cdbaa20be069a4258"
SRC_URI[sha256sum] = "4955a36a978accbc13cc9d58be3dbbed8864f27c34446b2fea879ee27fd7c4b6"
