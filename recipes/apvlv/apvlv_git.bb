DESCRIPTION = "Apvlv is a PDF viewer which behaves like Vim."
SECTION = "X11/apps"
PRIORITY = "optional"
DEPENDS = "gtk+ poppler"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
PR = "r0"

inherit cmake
 
SRC_URI="git://github.com/naihe2010/apvlv.git;tag=master \
		 file://add_missing_ifdef.patch \
		 "

S="${WORKDIR}/git"
