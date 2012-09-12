DESCRIPTION = "small app that cleans up the framebuffer after console program crash"
PACKAGES ="${PN}"
PR="r0"
DEPENDS="sysvinit"
RDEPENDS="busybox"
LICENSE="GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "file://fbrestore.c \
		   file://COPYING \
          "

S = "${WORKDIR}"

do_compile () {
  ${CC} ${CFLAGS} ${LDFLAGS} -o fbrestore fbrestore.c
}

do_install () {
  install -d ${D}${bindir}/
  install -m 0755 ${WORKDIR}/fbrestore ${D}${bindir}/
}

PACKAGES = "${PN}"
FILES_${PN} = "${bindir}/fbrestore"

