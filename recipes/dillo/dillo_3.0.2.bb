DESCRIPTION = "Dillo is a multi-platform graphical web browser known for its speed and small footprint."
SECTION = "X11/apps"
PRIORITY = "optional"
DEPENDS = "jpeg zlib libpng fltk"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
PR = "r0"

inherit autotools

SRC_URI="http://www.dillo.org/download/dillo-3.0.2.tar.bz2 \
		file://remove_cpp_check.patch"

SRC_URI[md5sum] = "81b82112cefcc7d54fe2972a21f42930"
SRC_URI[sha256sum] = "b4f2cd7c1be9f09e705f68c095813ea5bb9d72870338fc36c61d687e042950d6"


DPI_BASE="${libdir}/dillo/dpi"

FILES_${PN} =+ "	${DPI_BASE}/bookmarks/bookmarks.dpi \
					${DPI_BASE}/cookies/cookies.dpi \
					${DPI_BASE}/datauri/datauri.filter.dpi \
					${DPI_BASE}/downloads/downloads.dpi \ 
					${DPI_BASE}/file/file.dpi \
					${DPI_BASE}/ftp/ftp.filter.dpi \
					${DPI_BASE}/hello/hello.filter.dpi \ 
					${DPI_BASE}/https/https.filter.dpi \
					${DPI_BASE}/vsource/vsource.filter.dpi \
					"

FILES_${PN}-dbg =+ "${DPI_BASE}/bookmarks/.debug/* \
					${DPI_BASE}/cookies/.debug/* \
					${DPI_BASE}/datauri/.debug/* \
					${DPI_BASE}/downloads/.debug/* \ 
					${DPI_BASE}/file/.debug/* \
					${DPI_BASE}/ftp/.debug/* \
					${DPI_BASE}/hello/.debug/* \ 
					${DPI_BASE}/https/.debug/* \
					${DPI_BASE}/vsource/.debug/* \
					"
					 
