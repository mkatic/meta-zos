require xserver-kdrive-common.inc

DEPENDS += "libxkbfile libxcalibrate xcmiscproto bigreqsproto xextproto-legacy randrproto-legacy"
EXTRA_OECONF +="--disable-xevie --disable-evi --disable-appgroup"
PE = "1"
PR = "r11"
SELECTED_OPTIMIZATION="-O2 -march=iwmmxt -mtune=iwmmxt -fomit-frame-pointer"
SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
	${KDRIVE_COMMON_PATCHES} \
	file://enable-builtin-fonts.patch \
	file://disable-xf86-dga-xorgcfg.patch \
	file://enable-xcalibrate.patch \
    file://fbcompositesrc8888revnpx0565.patch \
    file://xcalibrate_coords.patch \
    file://pxafb_ioctl.patch \
	file://split_multiple_AC_SUBST.patch \
	file://remove_mouse_rotation.patch \
	file://change_api.patch \
	file://wheel_emu.patch \
	file://shadowfb_iwmmxt_rotate_copy.patch \
	file://fbsolid_asm.patch \
	file://reduce_fbsolid_api.patch \
	file://refactor_fbsolid.patch \
	file://remove_branch.patch \
	file://remove_24bit.patch \
	file://xrandr_from_1300.patch \
	file://fix_headers.patch \
	file://maemo_asm.patch \
	"

S = "${WORKDIR}/xorg-server-${PV}"

CFLAGS =+ "-DFBNO24BIT"

W100_OECONF = "--disable-w100"
W100_OECONF_arm = "--enable-w100"


SRC_URI[md5sum] = "ea291c89e68832d570d9d5e007218bd6"
SRC_URI[sha256sum] = "e3e56b35ee13098f4ee79948beb20bfc9a06d1a7a35fb906405ff1531b92bb85"
