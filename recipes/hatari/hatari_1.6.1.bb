DESCRIPTION = "Hatari is an Atari ST/STE/TT/Falcon emulator for GNU/Linux"
SECTION = "console"
PRIORITY = "optional"
DEPENDS = "libsdl zlib"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://gpl.txt;md5=751419260aa954499f7abaabaa882bbe"
PR = "r0"
DEFAULT_PREFERENCE="-1"

inherit cmake
 
SRC_URI="http://download.tuxfamily.org/hatari/1.6.1/hatari-1.6.1.tar.bz2"

SRC_URI[md5sum] = "14f6af33734c971cb4f349a38c6981a1"
SRC_URI[sha256sum] = "f6142b4d0c8f1731f990fcc4cf125d9b7a1822384c46e6af79058a461443e853"
