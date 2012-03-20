# Do not use the include in 1.2.14 as it has a lot of unneeded munging that applies to old versions.
#require libsdl.inc

DESCRIPTION = "Simple DirectMedia Layer (X11 and Framebuffer support)"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
LIC_FILES_CHKSUM="file://COPYING;md5=77604414711055c1393ef261e94e5855"
DEPENDS = "alsa-lib virtual/libx11 libxext tslib"
DEPENDS_avr32 = "alsa-lib virtual/libx11 libxext tslib"
PR = "r4"
CFLAGS := "${@'${CFLAGS}'.replace('-O2', '-O0')}"
SRC_URI = "http://www.libsdl.org/release/SDL-${PV}.tar.gz \
			file://sdl.m4"

S = "${WORKDIR}/SDL-${PV}/test"

inherit autotools binconfig pkgconfig
EXTRA_OECONF += "SDL_CONFIG=${STAGING_BINDIR_CROSS}/sdl-config"
do_configure() {

  oe_runconf
}

do_configure_append () {
  cd ${S}

  # prevent libtool from linking libs against libstdc++, libgcc, ...
  cat ${TARGET_PREFIX}libtool | sed -e 's/postdeps=".*"/postdeps=""/' > ${TARGET_PREFIX}libtool.tmp
  mv ${TARGET_PREFIX}libtool.tmp ${TARGET_PREFIX}libtool

  # copy new sdl.m4 macrofile to the dir for installing
  cp ${WORKDIR}/sdl.m4 ${S}/
}

do_install_append() {
  rm ${D}${libdir}/libSDL.la
}

#FILES_${PN} = "${libdir}/lib*.so.*"


SRC_URI[md5sum] = "e52086d1b508fa0b76c52ee30b55bec4"
SRC_URI[sha256sum] = "5d927e287034cb6bb0ebccfa382cb1d185cb113c8ab5115a0759798642eed9b6"
