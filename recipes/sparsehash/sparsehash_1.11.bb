DESCRIPTION = "An extremely memory-efficient hash_map implementation."
SECTION = ""
PRIORITY = "optional"
DEPENDS = ""
LICENSE = "BSD"
LIC_FILES_CHKSUM="file://COPYING;md5=762732742c73dc6c7fbe8632f06c059a"
PR = "r0"
 
SRC_URI="http://google-sparsehash.googlecode.com/files/sparsehash-1.11.tar.gz"

inherit autotools pkgconfig

SRC_URI[md5sum] = "53a9bb4b3fb11fc6fca9bf938c1b1ce9"
SRC_URI[sha256sum] = "1934d7b0ae76d24518c1520fc1cc424eb4788f9bd4618a8e9b0f19a9f8489cd4"
