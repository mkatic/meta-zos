DESCRIPTION = "IceWM Window Manager"
SECTION = "x11/wm"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=4a26952467ef79a7efca4a9cf52d417b"
DEPENDS = "virtual/libx11 libxext libxcomposite libxfixes libxdamage libxrender libxinerama libxpm xrandr libxft mkfontdir-native"
RRECOMMENDS_${PN} = ""
PR = "r3"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/icewm/icewm-${PV}.tar.gz \
  file://makefile.patch \
  file://configure.patch \
"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-i18n --without-imlib --with-xpm --with-gnome-menus \
	--x-includes=${STAGING_INCDIR} --x-libraries=${STAGING_LIBDIR} \
	--with-mkfontdir=${STAGING_BINDIR_NATIVE}/mkfontdir"

pkg_postinst() {
update-alternatives --install /usr/bin/x-window-manager x-window-manager /usr/bin/icewm-session 10
}

pkg_postrm() {
update-alternatives --remove x-window-manager /usr/bin/icewm-session
}

SRC_URI[md5sum] = "8a302c5e629bb81d87cc02004a694ece"
SRC_URI[sha256sum] = "4b802cf77ecf09bc44345f8fba3c11fd08dca0e8272e628b447ecf7289637e1d"
