#
# Copyright (C) 2007 OpenedHand Ltd.
#

inherit image
IMAGE_FEATURES += "package-management"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

VIRTUAL-RUNTIME_keymaps=""

IMAGE_INSTALL = "packagegroup-core-boot \ 
				 zaurusd-metan \
				 mtd-utils \ 
				 module-init-tools \ 
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
