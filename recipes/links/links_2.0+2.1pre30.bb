require links.inc

DEPENDS += ""
RCONFLICTS_${PN} = "links-x11"
PR = "r2"
LIC_FILES_CHKSUM="file://COPYING;md5=b0c80473f97008e42e29a9f80fcc55ff"

EXTRA_OECONF = "--enable-javascript --with-libfl --enable-graphics \
	        --with-ssl=${STAGING_LIBDIR}/.. --with-libjpeg \
	        --without-libtiff --without-svgalib --with-fb \
	        --without-directfb --without-gpm --without-pmshell --without-atheos \
	        --without-x --with-sdl"

SRC_URI[md5sum] = "f0f107cc824b71e43f0c6ab620209daf"
SRC_URI[sha256sum] = "f32314d851e86ec463967ddce78d051e3953b529878cbaeecf882c625ad29c75"
