DESCRIPTION = "Zos default keymap"
SECTION = "X11/base"
DEPENDS = "xmodmap"
LICENSE = ""
PR = "r0"
 
PACKAGES = "${PN}"
 
SRC_URI="file://Zos.Xmodmap"

do_configure () {
 :
}

do_qa_configure () {
 :
}

do_install () {

	install -D ${WORKDIR}/Zos.Xmodmap ${D}/${libdir}/X11/xinit/.Xmodmap
	
}

FILES_${PN} = "${libdir}"
