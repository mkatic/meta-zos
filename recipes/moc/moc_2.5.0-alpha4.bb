DESCRIPTION = "MOC is a ncurses based music player"
AUTHOR = "Damian Pietras <daper@daper.net>"
HOMEPAGE = "http://moc.daper.net/"
SECTION = "console/multimedia"
LICENSE = "GPL"
LIC_FILES_CHKSUM="file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
DEPENDS = "ncurses flac libmad libsndfile1 tremor speex"
PR = "r0"

SRC_URI = "ftp://ftp.daper.net/pub/soft/moc/unstable/moc-2.5.0-alpha4.tar.bz2"

inherit autotools

EXTRA_OECONF = "--without-curl"

SRC_URI[md5sum] = "2dd0cb6481d77fda09c58ec3154a21c0"
SRC_URI[sha256sum] = "a1ece00c17ce0ebbd387c0412b08f038dd07cf226726c26367cbc982ce3363b4"
