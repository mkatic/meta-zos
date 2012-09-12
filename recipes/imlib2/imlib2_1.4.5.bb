DESCRIPTION = "A graphic library for file loading, saving, rendering, and manipulation."
LICENSE = "MIT BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=344895f253c32f38e182dcaf30fe8a35"
# can also depend on tiff34, ungif or gif, z, bz2, id3tag
DEPENDS = "freetype libpng jpeg virtual/libx11 libxext"
PROVIDES = "virtual/imlib2"
PR = "r0"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/enlightenment/imlib2-src/1.4.5/imlib2-${PV}.tar.bz2 \
			file://remove_host_libdir.patch \
			"

EXTRA_OECONF = "--with-x \
				--without-tiff \
				--enable-visibility-hiding \
				"

do_install_append() {
    install -m 0755 imlib2-config ${STAGING_BINDIR_CROSS}
}

PACKAGES =+ "imlib2-loaders-dbg imlib2-filters-dbg imlib2-loaders imlib2-filters"
FILES_${PN} = "${libdir}/lib*.so.* ${libdir}/imlib2/*/*.so"
FILES_${PN}-dbg = "${libdir}/.debug/ ${bindir}/.debug/"
FILES_${PN}-dev += "${bindir}/imlib2-config ${libdir}/*.so ${includedir}"
FILES_${PN}-bin = "${bindir}"
FILES_imlib2-loaders = "${libdir}/imlib2/loaders/*.so"
FILES_imlib2-filters = "${libdir}/imlib2/filters/*.so"
FILES_imlib2-loaders-dbg += "${libdir}/imlib2/loaders/.debug"
FILES_imlib2-filters-dbg += "${libdir}/imlib2/filters/.debug"

SRC_URI[md5sum] = "859e5fede51ec819f4314eee11da3ea5"
SRC_URI[sha256sum] = "24700d93931838d2149cc2b4b58b9355cc81ec11d297f101a98dbb8d1c5c945a"
