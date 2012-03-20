DESCRIPTION = "Bluefish is a powerful editor targeted towards programmers and webdesigners"
SECTION = "editors"
PRIORITY = "optional"
DEPENDS = "gtk+ libpcre"
LICENSE = "GPLv2"
PR = "r0"
LIC_FILES_CHKSUM="file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI="http://www.bennewitz.com/bluefish/stable/source/bluefish-2.2.1.tar.bz2"

EXTRA_OECONF=" --disable-nls --disable-spell-check"
inherit autotools gettext

SRC_URI[md5sum] = "991ac54a6067281017ccbced5b43f2b6"
SRC_URI[sha256sum] = "4366133f3ff6b9c51943b1498188262b94a3fe2d4cf9118b6b42aac599634921"
