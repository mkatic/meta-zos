DESCRIPTION = "Fuse (the Free Unix Spectrum Emulator) was originally, and somewhat unsurprisingly, a ZX Spectrum emulator for Unix"
SECTION = "console"
PRIORITY = "optional"
DEPENDS = "libsdl libspectrum libpng zlib libxml2"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
PR = "r0"

inherit autotools
 
SRC_URI="http://downloads.sourceforge.net/project/fuse-emulator/fuse/1.0.0.1a/fuse-1.0.0.1a.tar.gz \
		 file://remove_local_prefix.patch"

S="${WORKDIR}/fuse-${PV}"

EXTRA_OECONF="--without-joystick --without-gtk --with-sdl"

FILES_${PN}=+"/usr/share/fuse/*"


SRC_URI[md5sum] = "dfd5ef1d7b79ff7feb8c12c1399cf22d"
SRC_URI[sha256sum] = "a6c202679aa8d061929d21500522efeefd75746a3c9f1384085817c49aa6c872"

