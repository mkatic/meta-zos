#
# Copyright (C) 2007 OpenedHand Ltd.
#

inherit image

LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
ALSA_UTILS = "alsa-utils-alsamixer \
             alsa-utils-midi \
             alsa-utils-aplay \
             alsa-utils-aconnect \
             alsa-utils-alsactl \
             alsa-utils-alsaloop \
            "
X11_ENV = "awesome \
			xserver-kdrive-fbdev \
			mrxvt \
			pcmanfm-mod \
			leafpad \
			epdfview \
			"

IMAGE_INSTALL = "task-zos-boot \ 
				 zaurusd \
				 mtd-utils \ 
				 module-init-tools \ 
				 alsa-lib \
				 ${ALSA_UTILS} \
				 ${X11_ENV} \
				 bash \
				 opkg \
				 oprofile \
				 pxaregs \
				 file \
				 strace \
				 dropbear \
				 binutils \
				 gdb \
				 "

IMAGE_LINGUAS = " "

LICENSE = "MIT"

IMAGE_ROOTFS_SIZE = "8192"

# remove not needed ipkg informations
ROOTFS_POSTPROCESS_COMMAND += "remove_packaging_data_files ; "
