require abiword-2.5.inc

PR = "r1"
LIC_FILES_CHKSUM="file://COPYING;md5=ecd3ac329fca77e2d0e412bec38e1c20"
EXTRA_OECONF += "--enable-embedded"

S = "${WORKDIR}/abiword-${PV}"

RCONFLICTS = "abiword"
RPROVIDES += "abiword"


