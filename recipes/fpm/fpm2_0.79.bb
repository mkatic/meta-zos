DESCRIPTION = "FPM2 is GTK2 port from Figaro's Password Manager"
SECTION = "X11/apps"
PRIORITY = "optional"
DEPENDS = "gtk+ libxml2"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
PR = "r0"
 
inherit autotools
 
SRC_URI="http://als.regnet.cz/fpm2/download/fpm2-0.79.tar.bz2"

SRC_URI[md5sum] = "a1f28d5e3fffc78bf5c70a99287ce443"
SRC_URI[sha256sum] = "d55e9ce6be38a44fc1053d82db2d117cf3991a51898bd86d7913bae769f04da7"
