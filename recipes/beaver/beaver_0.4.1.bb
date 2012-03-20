DESCRIPTION = "Beaver is a Gtk2+ Early AdVanced EditoR."
SECTION = "editors"
PRIORITY = "optional"
DEPENDS = "gtk+"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=7da7f00991fa031ee715131be3f671ce"
PR = "r0"
 
SRC_URI="http://dfn.dl.sourceforge.net/project/beaver-editor/0.4/beaver-0.4.1.tar.bz2"

inherit autotools

FILES_${PN}-dbg +="${libdir}/beaver/plugins/.debug/*"
