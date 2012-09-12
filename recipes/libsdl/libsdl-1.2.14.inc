DESCRIPTION = "Simple DirectMedia Layer (DirectFB and Framebuffer support)"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "alsa-lib virtual/libx11 libxext libxrandr libxrender"
PROVIDES = "virtual/libsdl"
INC_PR = "r5"

SRC_URI = "http://www.libsdl.org/release/SDL-${PV}.tar.gz \
			file://fix_tslib_rotation.patch \
			file://replace_mmap_malloc.patch \
			file://zaurus_res_hack.patch \
			file://screen_res_notify_tslib.patch \
			file://map_f_keys.patch \
			file://silkscreen_mouse_key_switching.patch\
			file://reverse_events_fix.patch \
			file://xgetrequest.patch \
			file://0001-SDL_fbvideo.c-check-for-SDL_NOMOUSE-before-calling-t.patch"
			
			
			
#			file://iwmmxt_rotation.patch"

SRC_URI[md5sum] = "e52086d1b508fa0b76c52ee30b55bec4"
SRC_URI[sha256sum] = "5d927e287034cb6bb0ebccfa382cb1d185cb113c8ab5115a0759798642eed9b6"

S = "${WORKDIR}/SDL-${PV}"

inherit autotools lib_package binconfig pkgconfig

EXTRA_AUTORECONF += "--include=acinclude --exclude=autoheader"
#CPPFLAGS_append ="-D FBCON_DEBUG"
do_configure_prepend () {
        # Remove old libtool macros.
        MACROS="libtool.m4 lt~obsolete.m4 ltoptions.m4 ltsugar.m4 ltversion.m4"
        for i in ${MACROS}; do
               rm -f acinclude/$i
        done
	export SYSROOT=$PKG_CONFIG_SYSROOT_DIR
}
