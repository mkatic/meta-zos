DESCRIPTION = "Star Control 2 source port using SDL (see sc2.sourceforge.net)"
SECTION = "games"
PRIORITY = "optional"
DEPENDS = "virtual/libsdl libsdl-image libsdl-net libvorbis libogg zlib"
SECTION = "games"
PRIORITY = "optional"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=e66f32c002bc5957794e6eabb3f49f0b"

PR = "r2"

S = "${WORKDIR}/uqm-${PV}"

SRC_URI = "${SOURCEFORGE_MIRROR}/sc2/uqm-${PV}-source.tgz"


do_configure() {
 :
}

do_compile() {

	./build.sh uqm
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 uqm ${D}${bindir}
}

SRC_URI[md5sum] = "f9018ea0493d7dac6a9e1006b00af7df"
SRC_URI[sha256sum] = "a3695c5f7f0be7ec9c0f80ec569907b382023a1fee6e635532bd53b7b53bb221"
