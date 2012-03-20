#LEGACY HEADERS NEEDED FOR KDRIVE 1.2.0 COMPILATION
require xorg-proto-common.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI = "${XORG_MIRROR}/individual/proto/xextproto-7.0.5.tar.bz2;name=archive"

S="${WORKDIR}/xextproto-7.0.5"

DEST_DIR="/X11/extensions/legacy"

do_install () {

	install -d 0755 ${STAGING_INCDIR}${DEST_DIR}
	
	install -m 0755 ${S}/Xdbeproto.h ${STAGING_INCDIR}${DEST_DIR}/Xdbeproto.h
	install -m 0755 ${S}/mitmiscstr.h ${STAGING_INCDIR}${DEST_DIR}/mitmiscstr.h
	install -m 0755 ${S}/securstr.h ${STAGING_INCDIR}${DEST_DIR}/securstr.h
	install -m 0755 ${S}/Xagstr.h ${STAGING_INCDIR}${DEST_DIR}/Xagstr.h
	install -m 0755 ${S}/Xdbe.h ${STAGING_INCDIR}${DEST_DIR}/Xdbe.h
	install -m 0755 ${S}/XTest.h ${STAGING_INCDIR}${DEST_DIR}/XTest.h
	install -m 0755 ${S}/MITMisc.h ${STAGING_INCDIR}${DEST_DIR}/MITMisc.h
	install -m 0755 ${S}/xteststr.h ${STAGING_INCDIR}${DEST_DIR}/xteststr.h
	
}
	
do_cleanup() {
	if [ -d ${STAGING_INCDIR}${DEST_DIR} ]; then
	rm -r ${STAGING_INCDIR}${DEST_DIR}
	fi
}
addtask cleanup before do_clean

LIC_FILES_CHKSUM="file://COPYING;md5=86f273291759d0ba2a22585cd1c06c53"
SRC_URI[archive.md5sum] = "e6841018a7c64983b0954aa2c564d115"
SRC_URI[archive.sha256sum] = "d33e1f3c96daad78667b2dfc14a1ce2ee3bdce19409f82cd5ede6c696ca5b042"

