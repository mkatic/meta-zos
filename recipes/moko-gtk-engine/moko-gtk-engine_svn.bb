DESCRIPTION = "Lightweight gtk engine based on Sato engine"
SECTION = "misc"
PRIORITY = "optional"
DEPENDS = "gtk+"
LICENSE = ""
LIC_FILES_CHKSUM="file://src/moko-main.c;startline=7;endline=23;md5=8749668c3d942642f19761712e95d818"
PR = "r0"

inherit autotools
 
SRC_URI="file://moko-gtk-engine.tar.gz"

S="${WORKDIR}/${PN}"

FILES_${PN}="/usr/lib/gtk-2.0/2.10.0/engines/libmoko-engine.so"
FILES_${PN}-dbg = "/usr/lib/gtk-2.0/2.10.0/engines/.debug/*"
FILES_${PN}-dev ="/usr/src/*"
