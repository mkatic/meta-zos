DESCRIPTION = "Miscellaneous files for the base system."
SECTION = "base"
PRIORITY = "required"
PR = "r98"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://licenses/GPL-2;md5=94d55d512a9ba36caa9b7df079bae19f"
SRC_URI = " \
           file://bl \
           file://host.conf \
           file://profile \
           file://fstab \
           file://inputrc \
           file://issue  \
           file://Cxx0_binary_keymap_pdaxrom_r198 \
           file://licenses/BSD \
           file://licenses/GPL-2 \
           file://licenses/GPL-3 \
           file://licenses/LGPL-2 \
           file://licenses/LGPL-2.1 \
           file://licenses/LGPL-3 \
           file://licenses/GFDL-1.2 \
           file://usb-auto \
           file://licenses/Artistic"

S = "${WORKDIR}"

docdir_append = "/${P}"
dirs1777 = "/tmp ${localstatedir}/volatile/lock ${localstatedir}/volatile/tmp"
dirs2775 = "/home ${prefix}/src ${localstatedir}/local"
dirs755 = "/bin /boot /dev /proc /sys ${sysconfdir} ${sysconfdir}/default ${sysconfdir}/init.d \
		/lib /mnt /proc /home/root /sbin \
	   ${prefix} ${bindir} ${docdir} ${includedir} \
	   ${libdir} ${sbindir} ${datadir} \
	    ${infodir} \
	   ${mandir} ${datadir}/misc ${localstatedir} \
	   ${localstatedir}/lib \
	   /sys ${localstatedir}/lib/misc ${localstatedir}/spool \
	   ${localstatedir}/volatile ${localstatedir}/volatile/cache \
	   ${localstatedir}/volatile/lock/subsys \
	   ${localstatedir}/volatile/log \
	   ${localstatedir}/volatile/run \
	   /mnt /media /media/card /media/cf /media/net \
	    /media/hdd \
	   /media/mmc1"

media = "card cf net ram"


volatiles = "cache run log lock tmp"
conffiles = "${sysconfdir}/debian_version ${sysconfdir}/host.conf \
	     ${sysconfdir}/inputrc ${sysconfdir}/issue /${sysconfdir}/issue.net \
	     ${sysconfdir}/nsswitch.conf ${sysconfdir}/profile \
	     ${sysconfdir}/default"

#
# set standard hostname, might be a candidate for a DISTRO variable? :M:
#
hostname = "Zos"

do_install_basefilesissue () {
	if [ -n "${MACHINE}" -a "${hostname}" = "openembedded" ]; then
		echo ${MACHINE} > ${D}${sysconfdir}/hostname
	else
		echo ${hostname} > ${D}${sysconfdir}/hostname
	fi

	install -m 644 ${WORKDIR}/issue*  ${D}${sysconfdir}
		echo 	"^[[H^[[2J" >> ${D}${sysconfdir}/issue
        if [ -n "${DISTRO_NAME}" ]; then
		echo -n "${DISTRO_NAME} " >> ${D}${sysconfdir}/issue
		if [ -n "${DISTRO_VERSION}" ]; then
			echo -n "${DISTRO_VERSION} " >> ${D}${sysconfdir}/issue
		fi
		echo "\n \l" >> ${D}${sysconfdir}/issue
		echo >> ${D}${sysconfdir}/issue
 	fi
}

do_install () {
	for d in ${dirs755}; do
		install -m 0755 -d ${D}$d
	done
	for d in ${dirs1777}; do
		install -m 1777 -d ${D}$d
	done
	for d in ${dirs2775}; do
		install -m 2755 -d ${D}$d
	done
	for d in ${volatiles}; do
                if [ -d ${D}${localstatedir}/volatile/$d ]; then
                        ln -sf volatile/$d ${D}/${localstatedir}/$d
                fi
	done
	for d in ${media}; do
		ln -sf /media/$d ${D}/mnt/$d
	done

	if [ -n "${MACHINE}" -a "${hostname}" = "openembedded" ]; then
		echo ${MACHINE} > ${D}${sysconfdir}/hostname
	else
		echo ${hostname} > ${D}${sysconfdir}/hostname
	fi      
			install -m 0755 ${WORKDIR}/bl ${D}${bindir}/bl
			install -m 0644 ${WORKDIR}/Cxx0_binary_keymap_pdaxrom_r198 ${D}${sysconfdir}/Cxx0_binary_keymap_pdaxrom_r198
            install -m 0644 ${WORKDIR}/fstab ${D}${sysconfdir}/fstab
			install -m 0644 ${WORKDIR}/profile ${D}${sysconfdir}/profile
        	install -m 0644 ${WORKDIR}/inputrc ${D}${sysconfdir}/inputrc
	        ln -sf /proc/mounts ${D}${sysconfdir}/mtab
        	install -m 0644 ${WORKDIR}/host.conf ${D}${sysconfdir}/host.conf
        	install -m 0755 ${WORKDIR}/usb-auto ${D}${bindir}/usb-auto
        	
	do_install_basefilesissue
}




PACKAGES = "${PN}-dbg ${PN}-doc ${PN}"
FILES_${PN} = "/*"
FILES_${PN}-doc = "${docdir} ${datadir}/common-licenses"

# M&N specific packaging

PACKAGE_ARCH = "${MACHINE_ARCH}"

CONFFILES_${PN} = "${sysconfdir}/fstab ${sysconfdir}/hostname"


