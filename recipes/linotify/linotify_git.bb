DESCRIPTION = "Inotify bindings for Lua"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "luajit"
LICENSE = "MIT"
PR = "r0"
LIC_FILES_CHKSUM="file://COPYRIGHT;md5=d0512ff414335941a87e86b424ec288f"

inherit pkgconfig

SRC_URI="git://github.com/hoelzro/linotify.git;tag=master"

S="${WORKDIR}/git"

do_install () {

install -D ${S}/inotify.so ${D}/${prefix}/local/${baselib}/lua/5.1/inotify.so

}

FILES_${PN} = "${prefix}/local/${baselib}/lua/5.1/inotify.so"
FILES_${PN}-dbg = "${prefix}/local/${baselib}/lua/5.1/.debug/"
