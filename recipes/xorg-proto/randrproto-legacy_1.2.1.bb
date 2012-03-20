#NEEDED FOR KDRIVE 1.2.0 COMPILATION
require xorg-proto-common.inc
PE = "1"
PR = "${INC_PR}.0"
LIC_FILES_CHKSUM="file://COPYING;md5=5fa3f85d9eefaa3a945071485be11343"

SRC_URI = "${XORG_MIRROR}/individual/proto/randrproto-1.2.1.tar.bz2"

SRC_URI[archive.md5sum] = "e2e45564f8ce22e00e1360e79c8ccdeb"
SRC_URI[archive.sha256sum] = "102fd42f8f2562450f4e45c28bfb0390c2d30ffa6a805eead15d67018930f654"

S="${WORKDIR}/randrproto-1.2.1"

DEST_DIR="/X11/extensions/legacy"

do_install () {

	install -d 0755 ${STAGING_INCDIR}${DEST_DIR}
	
	install -m 0755 ${S}/randr.h ${STAGING_INCDIR}${DEST_DIR}/randr.h
	install -m 0755 ${S}/randrproto.h ${STAGING_INCDIR}${DEST_DIR}/randrproto.h
	
}
	
do_cleanup() {
	if [ -d ${STAGING_INCDIR}${DEST_DIR} ]; then
	rm -r ${STAGING_INCDIR}${DEST_DIR}
	fi
}
addtask cleanup before do_clean
