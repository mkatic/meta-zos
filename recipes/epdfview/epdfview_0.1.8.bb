DESCRIPTION = "A minimal PDF viewer based on gtk and poppler"
HOMEPAGE = "http://www.emma-soft.com/projects/epdfview/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM="file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
SECTION = "x11/applications"
DEPENDS = "poppler gtk+ cups virtual/gettext"

SRC_URI = "http://www.emma-soft.com/projects/epdfview/chrome/site/releases/epdfview-${PV}.tar.bz2 \
		   file://minimise_scrollbar_size.patch \
		   file://hack_mkinstalldirs.patch \
		   file://remove_pageview_padding.patch \
		   file://remove_border_page_change.patch \
          "

SRC_URI_append_shr = "file://acroread.png \
                     "

inherit autotools

do_compile_append () {
	sed -i 's|\$.*prefix./|/usr/|' data/epdfview.desktop
}

do_compile_append_shr () {
	sed -i 's/Icon=.*/Icon=acroread/' data/epdfview.desktop
}

do_install_append_shr () {
	install -d ${D}${datadir}/pixmaps/
	install -m 0644 ${WORKDIR}/acroread.png ${D}${datadir}/pixmaps/
}

FILES_${PN}_append_shr = "${datadir}/pixmaps/acroread.png"

SRC_URI[md5sum] = "e50285b01612169b2594fea375f53ae4"
SRC_URI[sha256sum] = "948648ae7c9d7b3b408d738bd4f48d87375b1196cae1129d6b846a8de0f2f8f0"
