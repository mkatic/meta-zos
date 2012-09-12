DESCRIPTION = "libspectrum is a library designed to make the input and output of some ZX Spectrum emulator files slightly easier."
SECTION = "console/libs"
PRIORITY = "optional"
DEPENDS = "zlib glib-2.0"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
PR = "r0"

inherit autotools
 
SRC_URI="http://downloads.sourceforge.net/project/fuse-emulator/libspectrum/1.0.0/libspectrum-1.0.0.tar.gz \
		 file://remove_local_prefix.patch"

SRC_URI[md5sum] = "ed4533cf6a2883ba0a2829de429638fa"
SRC_URI[sha256sum] = "cdf8f5006676c0f68939e331eeadeda5d608d777f1234b080b97f677f1dd287c"

EXTRA_OECONF="--without-libaudiofile --without-libgcrypt"
