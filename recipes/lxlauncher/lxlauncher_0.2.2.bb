DESCRIPTION = "LXLauncher is an open source clone of Asus launcher for EeePC."
SECTION = "apps"
PRIORITY = "optional"
DEPENDS = "menu-cache gtk+ startup-notification"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
PR = "r0"

inherit autotools
 
SRC_URI="http://pkgs.fedoraproject.org/repo/pkgs/lxlauncher/lxlauncher-0.2.2.tar.gz/16df627447838b170a72cc3a9ee21497/lxlauncher-0.2.2.tar.gz"

SRC_URI[md5sum] = "16df627447838b170a72cc3a9ee21497"
SRC_URI[sha256sum] = "ad586e3a2668f98bbf0217ec1be1f8f1be4ff876b180a407c7db2fe354303cbc"

