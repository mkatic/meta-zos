DESCRIPTION = "VICE is a program that executes programs intended for the old 8-bit computers. "
SECTION = "console"
PRIORITY = "optional"
DEPENDS = "libsdl"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://doc/html/plain/COPYING;md5=c93c0550bd3173f4504b2cbd8991e50b"
PR = "r0"
 
inherit autotools 

SRC_URI="http://www.zimmers.net/anonftp/pub/cbm/crossplatform/emulators/VICE/vice-2.3.tar.gz"

EXTRA_OECONF="--enable-sdlui --enable-embedded"

SRC_URI[md5sum] = "b48d137874daad50c087a0686cbdde34"
SRC_URI[sha256sum] = "b1817c8dce023069d5c15234c2b4da0a152d297ee8ed01f0b361795c4beeb50e"
