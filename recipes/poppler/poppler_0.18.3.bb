require poppler.inc
LIC_FILES_CHKSUM="file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
PR = "r2"

PACKAGES=+ "poppler-apps"

EXTRA_OECONF = " --enable-xpdf-headers \
		 --disable-gtk-test \
		 --disable-poppler-qt --disable-poppler-qt4 \
		 --enable-zlib \
		 --enable-fixedpoint \
		 --disable-cms"

SRC_URI[md5sum] = "d70d2d63d8acd29c97185f7e5f09c9b4"
SRC_URI[sha256sum] = "d9019c403a36ee029bd90fee94a0793e63917646d7253ce24637de5194133462"

FILES_poppler-apps=" ${bindir}/*"
