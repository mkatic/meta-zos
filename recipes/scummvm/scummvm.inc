DESCRIPTION = "Virtual Machine for several classic graphical point-and-click adventure games"
HOMEPAGE = "http://www.scummvm.org"
SECTION = "games"
PRIORITY = "optional"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=ebf4e8b49780ab187d51bd26aaa022c6"

INC_PR = "r7"

SRC_URI = "${SOURCEFORGE_MIRROR}/scummvm/scummvm-${PV}.tar.bz2 \
		   file://fix_strip_usage.patch"

inherit autotools 

EXTRA_OECONF = "--host=${HOST_SYS} \
		--backend=sdl \
		--disable-vorbis \
		--with-sdl-prefix=${STAGING_BINDIR_CROSS} \
		--prefix=${prefix} \
		--with-ogg-prefix=${STAGING_LIBDIR}/.. \
		--with-tremor-prefix=${STAGING_LIBDIR}/.. \
		${@base_conditional('ENTERPRISE_DISTRO', '1', '--disable-mpeg2', '--with-mpeg2-prefix=${STAGING_LIBDIR}/..', d)} \
		${@base_conditional('ENTERPRISE_DISTRO', '1', '--disable-mad', '--with-mad-prefix=${STAGING_LIBDIR}/..', d)} \
		"

EXTRA_OEMAKE = "MANDIR=${mandir}"

do_configure() {
	./configure ${EXTRA_OECONF}
}
