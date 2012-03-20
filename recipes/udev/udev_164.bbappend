DEPENDS = "linux-libc-headers gperf-native libxslt-native"
RRECOMMENDS_${PN} = "usbutils"
EXTRA_OECONF = "--disable-introspection --disable-extras"

INITSCRIPT_PACKAGES = "udev"
INITSCRIPT_NAME_udev = "udev"
INITSCRIPT_NAME_udev-cache = ""
