DESCRIPTION = "GnGeo is a fast and powerful command line Neo Geo emulator"
SECTION = "console/games"
PRIORITY = "optional"
DEPENDS = "libsdl"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
PR = "r0"
 
SELECTED_OPTIMIZATION="-O0 -g -fno-omit-frame-pointer"

inherit autotools

SRC_URI="http://downloads.sourceforge.net/project/gngeo.berlios/gngeo-0.7.tar.gz \
		file://add_as_test.patch"

EXTRA_OECONF="--enable-cyclone --enable-drz80"

SRC_URI[md5sum] = "2797c20eb4a6dc40cddf93d7006c57a4"
SRC_URI[sha256sum] = "e9e52df576cd389f33422d9a1a31104e320d403c2b244c7ba1a6c6c74490df5f"
