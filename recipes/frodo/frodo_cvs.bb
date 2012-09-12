DESCRIPTION = "C64 Emulator based on SDL"
SECTION = "console"
PRIORITY = "optional"
DEPENDS = "libsdl"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"
PR = "r2"
SRCDATE = "20040801"

SRC_URI = "cvs://anoncvs:anoncvs@cvs.cebix.net/home/cvs/cebix;module=Frodo4 \
           file://configure.patch \
           file://frodorc \
           file://Frodo.png \
           file://frodo.desktop"

S = "${WORKDIR}/Frodo4/Src"

inherit autotools

EXTRA_OECONF = "--disable-sdltest"

#FIXME: Add postinst which copies /etc/frodorc into $HOME/.frodorc
