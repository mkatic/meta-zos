DESCRIPTION = "FLTK is a cross-platform C++ GUI toolkit"
HOMEPAGE = "http://www.fltk.org"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
LIC_FILES_CHKSUM="file://COPYING;md5=f6b26344a24a941a01a5b0826e80b5ca"
DEPENDS = "alsa-lib zlib jpeg libpng libxext libxft"

PR = "r0"

inherit autotools

SRC_URI = "http://ftp.easysw.com/pub/fltk/1.3.0/fltk-${PV}-source.tar.gz \
	  "

EXTRA_OECONF="--disable-gl --disable-cairo --disable-largefile --disable-xinerama --disable-dbe"
EXTRA_OEMAKE =+ "-k"
SRC_URI[md5sum] = "44d5d7ba06afdd36ea17da6b4b703ca3"
SRC_URI[sha256sum] = "990676808294cea4cca3de833ad5a5de08073c11b665356d4ecf35d22535b21c"

