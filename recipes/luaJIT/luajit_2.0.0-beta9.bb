DESCRIPTION = "a Just-In-Time Compiler for Lua."
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM="file://COPYRIGHT;md5=e591ac54022d729e190c3465c191c2b6"
PR = "r0"

inherit pkgconfig autotools

SRC_URI="http://luajit.org/download/LuaJIT-2.0.0-beta9.tar.gz \
		file://beta9_hotfix1.patch \
		"

SRC_URI[md5sum] = "e7e03e67e2550817358bc28b44270c6d"
SRC_URI[sha256sum] = "da3793b4364a17c3700d39d13eae799b82ff23da1f61631d735de05333f46240"

S="${WORKDIR}/LuaJIT-2.0.0-beta9"

EXTRA_OEMAKE ="HOST_CC="gcc -m32" CROSS=arm-oe-linux-gnueabi- TARGET=arm"

do_configure () {
	:
}

do_compile () {

oe_runmake 

}

do_install () {

oe_runmake PREFIX="/usr" DESTDIR=${D} install
cd ${D}/usr/bin
ln -s ${PN}-${PV} lua
}

#FILES_${PN} = "${bindir}/*"

