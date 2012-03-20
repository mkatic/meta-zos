DESCRIPTION = "A full-featured and high-performance event loop"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = ""
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://LICENSE;md5=24807593edf979ff7a67d1c443c2af29"
PR = "r0"
 
SRC_URI="http://dist.schmorp.de/libev/libev-4.11.tar.gz"

inherit autotools

SRC_URI[md5sum] = "cda69b858a1849dfe6ce17c930cf10cd"
SRC_URI[sha256sum] = "9f55f16ff6e4d60a1b1fa7f4962af69768468f0d7c362aab6387f52020938cdf"
