SUMMARY = "scrot (SCReen shOT) is a simple commandline screen capture utility that uses imlib2 to grab and save images."
SECTION = "console"
LICENSE = ""
DEPENDS ="giblib"
LIC_FILES_CHKSUM = "file://COPYING;md5=dd3cb8d7a69f3d0b2a52a46c92389011"
PR = "r0"

inherit autotools

SRC_URI = "http://linuxbrit.co.uk/downloads/scrot-0.8.tar.gz \
"

SRC_URI[md5sum] = "ccae904d225609571bdd3b03445c1e88"
SRC_URI[sha256sum] = "613d1cf524c2b62ce3c65f1232ea4f05c7daf248d5e82ff2a6892c98093994f2"
