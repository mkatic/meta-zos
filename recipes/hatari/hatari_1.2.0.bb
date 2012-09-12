DESCRIPTION = "Hatari is an Atari ST/STE/TT/Falcon emulator for GNU/Linux"
SECTION = "console"
PRIORITY = "optional"
DEPENDS = "libsdl zlib"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://gpl.txt;md5=751419260aa954499f7abaabaa882bbe"
PR = "r0"

inherit autotools
 
SRC_URI="http://download.tuxfamily.org/hatari/1.2.0/hatari-1.2.0.tar.bz2"

SRC_URI[md5sum] = "4aecd42784fae8c5e8c9a9a341146fbb"
SRC_URI[sha256sum] = "f2ea252bf8095d357fbc3da66a5be9e988935970d8c3a36f680c1ceeaee15b43"

EXTRA_OECONF="--without-x"

CFLAGS+="-lm"
