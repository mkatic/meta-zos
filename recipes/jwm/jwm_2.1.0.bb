DESCRIPTION = "JWM is a window manager for the X11 Window System. JWM is written in C and uses only Xlib at a minimum."
SECTION = "X11/apps"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 jpeg libpng"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"
PR = "r0"

inherit autotools
 
SRC_URI="http://joewing.net/programs/jwm/releases/jwm-2.1.0.tar.bz2"

SRC_URI[md5sum] = "e8fab21b2410eb82032b7c3472af642c"
SRC_URI[sha256sum] = "5c99f9023dc8c2597effdaacc240ff4c2e07e77c8244f3bf1de5cc483bcf08ab"
