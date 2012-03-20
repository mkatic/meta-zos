FILESEXTRAPATHS := "${THISDIR}/linux-3.2"

SRC_URI  =+ " \
			file://0001-Pxafb-A-different-way-of-allocating-fb-memory.patch \
			file://0002-Add-spitz-battery-driver.-This-finally-enables-onlin.patch \
			file://0003-Disable-SPITZ_SCP_CF_POWER-during-suspend.-Otherwise.patch \
			file://0004-fix-touchscreen-jitter-and-regulator-issues.patch \
			file://0005-fix-wm8750-frequency-issues.patch \
			file://0006-Revert-fix-touchscreen-jitter-and-regulator-issues.patch \
			file://0007-Prevent-mousedev-from-enumerating-the-touchscreen.patch \
			file://0008-touchscreen-jitter-and-regulator-fix-again.patch \
			file://0009-Revert-Prevent-mousedev-from-enumerating-the-touchsc.patch \
			file://0010-Force-mousedev-to-ignore-the-ads7846-touchscreen.-I-.patch \
			file://0011-remove-in-kernel-ts-filtering-reduce-clock-for-ads78.patch \
			file://0012-Add-two-more-buttons-to-gpio-keys-for-spitz.-These-a.patch \
			file://0013-Hack-enable-internal-sram-clock-at-device-init.-This.patch \
			file://0014-invert-usb-host-gpio.patch \
			file://0015-Add-debouncing-to-all-gpio-s-in-gpio-keys.patch \
			file://0016-Sharpsl_pm.c-Quick-fix-that-enables-offline-charging.patch \
			"
