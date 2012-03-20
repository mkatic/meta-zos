DESCRIPTION = "zathura is a highly customizable and functional PDF viewer based on the poppler rendering library and the gtk+ toolkit"
SECTION = "apps"
PRIORITY = "optional"
DEPENDS = "gtk+ poppler"
LICENSE = "custom"
PR = "r0"
LIC_FILES_CHKSUM="file://LICENSE;md5=c84f307d92071b68393f0d10eedb81ee"
SRC_URI="git://pwmt.org/zathura.git;tag=0.0.8.5"

S="${WORKDIR}/git"

inherit autotools

do_compile () {
oe_runmake
}
