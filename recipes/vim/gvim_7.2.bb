VIMGUI = "gtk2"
VIMX = "--with-x"
LIC_FILES_CHKSUM="file://README.txt;md5=72c4840d07b65659b60b3fa405c7da36"
require vim_${PV}.bb

DEPENDS += "gtk+ libxt"

EXTRA_OECONF += "--enable-gui=gtk2 --disable-gtktest --disable-nls"

#might needs RREPLACES_${PN} as well
RCONFLICTS_${PN} = "vim vim-tiny"
