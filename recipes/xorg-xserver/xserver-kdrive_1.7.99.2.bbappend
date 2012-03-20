FILESEXTRAPATHS := "${THISDIR}/xserver-kdrive-1.7.99.2"
#SRC_URI += "file://fbdev_kshadow.patch \
#			file://remove_xfree_kshadow.patch"
			

#SELECTED_OPTIMIZATION="-O0 -g -fno-omit-frame-pointer"
TARGET_CC_ARCH = "-march=armv5te -mtune=xscale"
