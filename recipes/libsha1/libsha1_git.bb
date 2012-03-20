DESCRIPTION = "libsha1 is a tiny library providing SHA1 implementation"
SECTION = "misc"
PRIORITY = "required"
DEPENDS = ""
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=459a4c16ab4a1152888d3909d4205c6f"
PR = "r0"

inherit autotools pkgconfig 
 
SRC_URI="git://github.com/dottedmag/libsha1.git;protocol=git;tag=0.3"

S="${WORKDIR}/git"
