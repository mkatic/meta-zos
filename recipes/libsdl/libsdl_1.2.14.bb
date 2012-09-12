require libsdl-1.2.14.inc

DEPENDS += "virtual/libgl virtual/libx11 libxext tslib"
DEPENDS_avr32 += "alsa-lib virtual/libx11 libxext tslib"
LIC_FILES_CHKSUM="file://COPYING;md5=27818cd7fd83877a8e3ef82b82798ef4"
PR = "${INC_PR}.8"

#SELECTED_OPTIMIZATION="-O0 -g -fno-omit-frame-pointer"


EXTRA_OECONF = " \
  --disable-debug --disable-cdrom --enable-threads --enable-timers --enable-endian \
  --enable-file --enable-oss --enable-alsa --disable-esd --disable-arts \
  --disable-diskaudio --disable-nas --disable-esd-shared --disable-esdtest \
  --disable-mintaudio --disable-nasm --enable-video-x11 --disable-video-dga \
  --enable-video-fbcon --disable-video-directfb --disable-video-ps2gs \
  --disable-video-xbios --disable-video-gem --disable-video-dummy \
  --enable-video-opengl --enable-input-events --enable-pthreads \
  --disable-video-picogui --disable-video-qtopia --enable-dlopen \
  --enable-input-tslib --disable-video-ps3 --disable-rpath \
"
