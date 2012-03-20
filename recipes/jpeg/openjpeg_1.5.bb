DESCRIPTION = "Open-source JPEG 2000 codec written in C language"
HOMEPAGE = "http://www.openjpeg.org"
SECTION = "libs"
LICENSE = "BSD"
PR = "r0"
BBCLASSEXTEND = "native"
LIC_FILES_CHKSUM="file://LICENSE;md5=1153c321aaa5ae2733736b49673563d9"
SRC_URI = "http://openjpeg.googlecode.com/files/openjpeg-1.5.0.tar.gz"

S = "${WORKDIR}/openjpeg-1.5.0"
#tiff support disable, qa_configure complains
EXTRA_OECONF="--disable-tiff"
inherit autotools

PACKAGES =+ "openjpeg-tools "
FILES_openjpeg-tools = "${bindir}/*"

SRC_URI[md5sum] = "e5d66193ddfa59a87da1eb08ea86293b"
SRC_URI[sha256sum] = "c9908fab44432a2ed2550c457cb7e736da6d7c326f1203d23d1082d992364ace"

