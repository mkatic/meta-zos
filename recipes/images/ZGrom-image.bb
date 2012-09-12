DESCRIPTION = "A gaming rom for Sharp Zaurii devices."

ALSA_UTILS = "alsa-utils-alsamixer \
              alsa-utils-alsactl \
              alsa-utils-amixer \
            "
#most emulators are manually added to the final image
EMULATORS="scummvm fuse-emu gngeo"
APPS="milkytracker mc gmenu2x nano"        
GAMES="prboom"
IMAGE_FEATURES += "package-management"

IMAGE_INSTALL = "packagegroup-core-boot \
				${ROOTFS_PKGMANAGE_BOOTSTRAP} \
				autologin \
				apm \
				bash \
				psplash \
				fbrestore \
				module-init-tools \ 
				alsa-lib \
				libsdl-net \
				libsdl-image \
				libsdl-mixer \
				libsdl-ttf \
				libvorbis \
				freetype \
				zaurusd-metan \
				${ALSA_UTILS} \
				${EMULATORS} \
				${GAMES} \
				${APPS} \
				opkg \
				jpeg \
				tiff \
				udev-utils \
				tslib-calibrate \
				"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

SERIAL_CONSOLE=""

inherit core-image

IMAGE_ROOTFS_SIZE = "8192"

