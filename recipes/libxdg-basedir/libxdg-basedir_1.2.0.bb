DESCRIPTION = "This library implements functions to list the directories \
				according to the specification and provides a few higher-level functions."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = ""
LICENSE = ""
LIC_FILES_CHKSUM="file://COPYING;md5=3d22fbc68acb5ab83faba84c33e07d7e"
PR = "r0"
 
SRC_URI="http://n.ethz.ch/~nevillm/download/libxdg-basedir/libxdg-basedir-1.2.0.tar.gz"

inherit autotools

SRC_URI[md5sum] = "5a9eaaba2ec7f62253ecaed032af313b"
SRC_URI[sha256sum] = "2757a949618742d80ac59ee2f0d946adc6e71576406cdf798e6ced507708cdf4"
