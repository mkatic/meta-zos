SRC_URI = "http://download.savannah.gnu.org/releases-noredirect/sysvinit/sysvinit-${PV}.tar.bz2 \
	   file://install.patch \
	   file://crypt-lib.patch \
       file://need \
       file://provide \
       file://rcS-default \
       file://rc \
       file://rcS \
		"
		
do_install () {
	oe_runmake 'ROOT=${D}' install
	install -d ${D}${sysconfdir} \
		   ${D}${sysconfdir}/default \
		   ${D}${sysconfdir}/init.d
	install -m 0644    ${WORKDIR}/rcS-default	${D}${sysconfdir}/default/rcS
	install -m 0755    ${WORKDIR}/rc		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/rcS		${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/rcS.d
	for level in 2 3 4 5; do
		install -d ${D}${sysconfdir}/rc$level.d
	done
	mv                 ${D}${base_sbindir}/init               ${D}${base_sbindir}/init.${BPN}
	mv ${D}${base_bindir}/pidof ${D}${base_bindir}/pidof.${BPN}
	mv ${D}${base_sbindir}/halt ${D}${base_sbindir}/halt.${BPN}
	mv ${D}${base_sbindir}/reboot ${D}${base_sbindir}/reboot.${BPN}
	mv ${D}${base_sbindir}/shutdown ${D}${base_sbindir}/shutdown.${BPN}
	mv ${D}${base_sbindir}/poweroff ${D}${base_sbindir}/poweroff.${BPN}
	mv ${D}${bindir}/last ${D}${bindir}/last.${BPN}
	mv ${D}${bindir}/mesg ${D}${bindir}/mesg.${BPN}
	mv ${D}${bindir}/wall ${D}${bindir}/wall.${BPN}
}
