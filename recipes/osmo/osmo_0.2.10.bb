SUMMARY = "Osmo is a handy personal organizer, which includes calendar, tasks manager, address book and notes modules."
DESCRIPTION = "X11/apps"
DEPENDS= "gtk+ libxml2"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=8ca43cbc842c2336e835926c2166c28b"

PR = "r0"

inherit autotools pkgconfig

SRC_URI = "http://netcologne.dl.sourceforge.net/project/osmo-pim/osmo-pim/osmo-0.2.10/osmo-0.2.10.tar.gz \
"

EXTRA_OECONF = "--enable-printing=no"

SRC_URI[md5sum] = "a774db748228efee96186158d553ade9"
SRC_URI[sha256sum] = "4e911c52ac64a088f8a812b354084e7adedd1b54cb0435995a2cdc1d194d0845"
