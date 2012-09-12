LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=44ac4678311254db62edf8fd39cb8124"
SECTION = "x11/utils"
DEPENDS = "libgsf gtk+ libxml2 goffice libglade intltool-native"
RDEPENDS="dbus-x11"
DESCRIPTION = "Gnumeric spreadsheet for GNOME"

PARALLEL_MAKE = ""

inherit autotools

SRC_URI = "http://ftp.acc.umu.se/pub/GNOME/sources/gnumeric/1.10/gnumeric-${PV}.tar.bz2 \
		   file://nodolt.patch "

SRC_URI[archive.md5sum] = "80daf446f299578d05e60e9b7d38900c"
SRC_URI[archive.sha256sum] = "91a0a9aa47ae82b14fe717e5d49d164cfe871add2bf71d0cb2f68cf3d383c9db"

EXTRA_OECONF=" --without-perl --disable-component --without-gnome"

PACKAGES_DYNAMIC += "gnumeric-plugin-*"

FILES_${PN}-dbg += "${libdir}/gnumeric/${PV}/plugins/*/.debug"
FILES_${PN} += "${libdir}/libspreadsheet-${PV}.so "
FILES_${PN} += "${datadir}/icons/*"

do_configure_prepend() {
	sed -i -e s:doc\ tools:tools: ${S}/Makefile.am
}

# We need native orbit-idl with target idl files. No way to say it in a clean way:
do_configure_append () {
	find -name Makefile -exec sed -i '/\/usr\/bin\/orbit-idl-2/{s:/usr/bin:${STAGING_BINDIR_NATIVE}:;s:/usr/share:${STAGING_DATADIR}:g}' {} \;
}

SRC_URI[md5sum] = "80daf446f299578d05e60e9b7d38900c"
SRC_URI[sha256sum] = "91a0a9aa47ae82b14fe717e5d49d164cfe871add2bf71d0cb2f68cf3d383c9db"

