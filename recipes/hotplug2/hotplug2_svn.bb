# Copyright (C) 2010, O.S. Systems Software Ltda. All Rights Reserved
# Released under the MIT license

DESCRIPTION = "Hotplug2 is a lightweight udev replacement"
HOMEPAGE = "http://code.google.com/p/hotplug2/"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

RRECOMMENDS += "udev-utils"
RPROVIDES_${PN} = "hotplug"
RREPLACES_${PN} = "udev"
PV = "1.0+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://hotplug2.googlecode.com/svn;module=trunk;protocol=http"

SRCREV = "4"
S = "${WORKDIR}/trunk"

inherit autotools

do_install_append () {

install -d ${D}${sysconfdir}/hotplug2

install -m 0644 ${S}/docs/rules/hotplug2.rules ${D}${sysconfdir}/hotplug2/hotplug2.rules
install -m 0644 ${S}/docs/rules/automount.rules ${D}${sysconfdir}/hotplug2/automount.rules

}

FILES_${PN} += "/lib/* /etc/*"
FILES_${PN}-dbg += "${base_libdir}/hotplug2/.debug"

