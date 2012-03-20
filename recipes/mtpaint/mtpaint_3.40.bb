DESCRIPTION = "mtPaint is a simple painting program"
SECTION = "x11/graphics"
DEPENDS = "gtk+ jpeg"
LICENSE="GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
HOMEPAGE = "http://mtpaint.sf.net"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/mtpaint/mtpaint-${PV}.tar.bz2"

do_configure() {
	/bin/bash ./configure gtk2
	cat > _conf.txt <<EOF
CC = ${CC}
MT_VERSION=mtPaint 3.40
MT_DATE=2011-9-30
LDFLAG = ${LDFLAGS} `pkg-config --libs gtk+-2.0` -ljpeg -lpng -lX11 -lz -lm
CFLAG = ${CFLAGS} `pkg-config --cflags gtk+-2.0` -DMT_VERSION="\"mtPaint 3.40"\" -DU_JPEG -DU_FPICK_MTPAINT -DU_CPICK_MTPAINT
subdirs = src
BIN_INSTALL="/usr/local/bin"
EOF
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 src/mtpaint ${D}${bindir}
}

SRC_URI[md5sum] = "957c8035dd62c6bfdb594cd0a4467d22"
SRC_URI[sha256sum] = "ef321d2b404839c7b909bdf5283eb22a37fbdd35b4cc9e380ddc400573d7c890"

