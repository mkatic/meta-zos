DESCRIPTION = "The Obvious Repository is a set of widgets for your Awesome desktop."
SECTION = "X11/libs"
PRIORITY = "optional"
DEPENDS = "awesome"
LICENSE = "MIT"
LIC_FILES_CHKSUM="file://LICENSE;md5=e7a3538deb54c4768a321b30de5ae20c"
PR = "r0"
 
SRC_URI="git://git.mercenariesguild.net/obvious.git;tag=v3.4.10 \
		 file://prompt_slide_from_top.patch \
		"

S="${WORKDIR}/git"

do_configure () { 
:
}

do_install () {

install -d ${D}/usr/share/awesome/lib/obvious
cp -R ${WORKDIR}/git/* ${D}/usr/share/awesome/lib/obvious

}

FILES_${PN} = "/usr/share/*"
