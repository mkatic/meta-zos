DESCRIPTION = "desktop eyecandy bar"
SECTION = "misc"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
HOMEPAGE = "http://code.google.com/p/wbar/"
DEPENDS = "libglade imlib2 gtk+"
PR = "r1" 

SRC_URI="svn://wbar.googlecode.com/svn/;module=trunk;proto=http;rev=41"

S="${WORKDIR}/trunk"

inherit autotools
