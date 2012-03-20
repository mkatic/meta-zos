DESCRIPTION = " a very good alternative sdl based GUI"
SECTION = "applications"
PRIORITY = "optional"
DEPENDS = "libsdl libsdl-ttf libsdl-image libsdl-gfx sparsehash libpng"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=393a5ca445f6965873eca0259a17f833"
PR = "r0"
 
SRC_URI="git://projects.qi-hardware.com/gmenu2x.git;tag=master;protocol=git \
		 file://zaurus_specific.patch"
S="${WORKDIR}/git"

EXTRA_OECONF=" --enable-platform=nanonote"
TARGET_CFLAGS_append =" -DPLATFORM_ZAURUS"
inherit autotools
