require gtk+.inc
SELECTED_OPTIMIZATION := "${@'${SELECTED_OPTIMIZATION}'.replace('-O2', '-O3')}"
PR = "r11"

SRC_URI = "http://download.gnome.org/sources/gtk+/2.16/gtk+-${PV}.tar.bz2 \
           file://xsettings.patch \
           file://run-iconcache.patch \
           file://hardcoded_libtool.patch \
           file://no-demos.patch \
           file://cellrenderer-cairo.patch;striplevel=0 \
           file://toggle-font.diff;striplevel=0 \
		   file://0001-bgo-584832-Duplicate-the-exec-string-returned-by-gtk.patch \
           file://disable-gio-png-sniff-test.diff \
           file://fix_selection_streak.patch \
           file://add_gdk_cairo_reset_clip.patch \
		"
# TO MERGE
#           file://entry-cairo.patch;striplevel=0
#           file://filesystem-volumes.patch
#           file://filechooser-props.patch
#           file://filechooser-default.patch
#           file://filechooser-sizefix.patch
# temporary
#           file://gtklabel-resize-patch
#           file://menu-deactivate.patch
#        file://combo-arrow-size.patch;striplevel=0



EXTRA_OECONF = "--without-libtiff --without-libjasper --disable-xkb \
				--disable-glibtest --disable-cups --disable-papi \
				--disable-xinerama --enable-debug=no"

LIBV = "2.10.0"

PACKAGES_DYNAMIC += "gdk-pixbuf-loader-* gtk-immodule-* gtk-printbackend-*"

python populate_packages_prepend () {
	import os.path

	prologue = d.getVar("postinst_prologue", 1)
	postinst_pixbufloader = d.getVar("postinst_pixbufloader", 1)

	gtk_libdir = bb.data.expand('${libdir}/gtk-2.0/${LIBV}', d)
	loaders_root = os.path.join(gtk_libdir, 'loaders')
	immodules_root = os.path.join(gtk_libdir, 'immodules')
	printmodules_root = os.path.join(gtk_libdir, 'printbackends');

	do_split_packages(d, loaders_root, '^libpixbufloader-(.*)\.so$', 'gdk-pixbuf-loader-%s', 'GDK pixbuf loader for %s', postinst_pixbufloader)
	do_split_packages(d, immodules_root, '^im-(.*)\.so$', 'gtk-immodule-%s', 'GTK input module for %s', prologue + 'gtk-query-immodules-2.0 > /etc/gtk-2.0/gtk.immodules')
	do_split_packages(d, printmodules_root, '^libprintbackend-(.*)\.so$', 'gtk-printbackend-%s', 'GTK printbackend module for %s')

        if (d.getVar('DEBIAN_NAMES', 1)):
                d.setVar('PKG_${PN}', '${MLPREFIX}libgtk-2.0')
}
SRC_URI[md5sum] = "416412b336d9f3b6b78ca887395d1726"
SRC_URI[sha256sum] = "18e0f9792028e6cc5108447678f17d396f9a2cdfec1e6ab5dca98cb844f954af"
