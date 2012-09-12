DESCRIPTION = "a simple tool to login to root with no prompt"
PACKAGES ="${PN}"
PR="r0"
DEPENDS="sysvinit"
RDEPENDS="busybox"
LICENSE="GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "file://autologin.c \
		   file://autologin.profile \
		   file://COPYING \
          "

S = "${WORKDIR}"

do_compile () {
  ${CC} ${CFLAGS} ${LDFLAGS} -o autologin autologin.c
}

do_install () {
  install -d ${D}${base_sbindir}/
  install -d ${D}${sysconfdir}/
  install -m 0755 ${WORKDIR}/autologin ${D}${base_sbindir}/
  install -m 0755 ${WORKDIR}/autologin.profile ${D}${sysconfdir}/autologin.profile
}

pkg_postinst_${PN} () {
  sed 's_1:2345:respawn:/sbin/getty_1:2345:respawn:/sbin/getty -n -l /sbin/autologin_'  /etc/inittab > inittab.tmp
  mv inittab.tmp  /etc/inittab
}

pkg_prerm_${PN} () {
  sed 's_-n -l /sbin/autologin__' /etc/inittab > inittab.tmp
  mv inittab.tmp /etc/inittab
}


PACKAGES = "${PN}"
FILES_${PN} = "${base_sbindir}/autologin \
			   ${sysconfdir}/autologin.profile"
