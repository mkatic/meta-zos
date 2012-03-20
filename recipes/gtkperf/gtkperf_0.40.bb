DESCRIPTION = "GtkPerf is an application designed to test GTK+ performance."
SECTION = "misc"
PRIORITY = "optional"
DEPENDS = "glib-2.0 atk pango gtk+"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
PR = "r0"
 
SRC_URI="${SOURCEFORGE_MIRROR}/gtkperf/gtkperf_${PV}.tar.gz"
S= "${WORKDIR}/gtkperf"
inherit autotools gettext



SRC_URI[md5sum] = "4331dde4bb83865e15482885fcb0cc53"
SRC_URI[sha256sum] = "9704344e732038eecbd007dd996a56293a6b027b5b76f3f036273a3fae1ab27b"

