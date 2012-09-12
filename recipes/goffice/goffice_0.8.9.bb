DESCRIPTION="Gnome Office Library"
LICENSE="GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=fa1348b178f4a7322170203c6c36f4c3"
DEPENDS="glib-2.0 gtk+ pango cairo libgsf libglade libpcre libxml2 libart-lgpl"

inherit autotools pkgconfig

SRC_URI += "http://ftp.gnome.org/pub/GNOME/sources/goffice/0.8/goffice-${PV}.tar.gz  \
			file://c99math.patch \
            file://nodolt.patch "

SRC_URI[md5sum] = "d161492ffd403e0c7108c2d077aa9ba5"
SRC_URI[sha256sum] = "87d16ae88c55a240ca8d579cc45e723a9cab40868aa80559637c90137d8bc3d6"


FILES_${PN}-dbg += "${libdir}/goffice/${PV}/plugins/*/.debug"

FILES_${PN} = "${bindir}/* ${sbindir}/* ${libexecdir}/* ${libdir}/lib*${SOLIBS} \
            ${sysconfdir} ${sharedstatedir} ${localstatedir} \
            ${base_bindir}/* ${base_sbindir}/* \
            ${base_libdir}/*${SOLIBS} \
            ${datadir}/${PN} \
            ${datadir}/pixmaps ${datadir}/applications \
            ${datadir}/idl ${datadir}/omf ${datadir}/sounds \
            ${libdir}/bonobo/servers"

PACKAGES_DYNAMIC = "goffice-plugin-*"


