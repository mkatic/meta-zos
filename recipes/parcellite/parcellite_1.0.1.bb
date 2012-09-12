DESCRIPTION = "Parcellite is a lightweight GTK+ clipboard manager"
SECTION = "X11/apps"
PRIORITY = "optional"
DEPENDS = "gtk+ virtual/gettext"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=8f0e2cd40e05189ec81232da84bd6e1a"
PR = "r0"

inherit autotools pkgconfig

SRC_URI="${SOURCEFORGE_MIRROR}/parcellite/parcellite-${PV}.tar.gz"

SRC_URI[md5sum] = "b2f1de2a424996c0eb2ff3a728a12cfc"
SRC_URI[sha256sum] = "a4e7a1bd0616683b7eb4b08350cdaa355b1c9d5c93a4caa0cef4a813cf4cc526"

LDFLAGS += "-lX11"
