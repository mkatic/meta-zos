FILESEXTRAPATHS := "${THISDIR}/files"
inherit update-rc.d
INITSCRIPT_NAME= "alsactl-restore"
#Since we have alsa-conf-base and alsa-conf, we have to remove both
#to remove alsa-conf, then readd alsa-conf-base

PACKAGES := "${@'${PACKAGES}'.replace('alsa-conf-base', '')}"
PACKAGES := "${@'${PACKAGES}'.replace('alsa-conf', '')}"
PACKAGES =+ "alsa-conf-base"

SRC_URI += "file://asound.conf \
			file://asound.state \
			file://alsactl-store \
			file://alsactl-restore"
                      
FILES_alsa-conf-base =+ "\
${sysconfdir}/asound.conf \
${sysconfdir}/asound.state \
${datadir}/alsa/pcm/dsnoop.conf \
${datadir}/alsa/cards/aliases.conf"
             
do_install_append () {
install -d 0644 ${D}${sysconfdir}/init.d
install -m 0644 ${WORKDIR}/asound.conf ${D}${sysconfdir}/asound.conf
install -m 0644 ${WORKDIR}/asound.state ${D}${sysconfdir}/asound.state
install -m 0755 ${WORKDIR}/alsactl-store ${D}${sysconfdir}/init.d/alsactl-store
install -m 0755 ${WORKDIR}/alsactl-restore ${D}${sysconfdir}/init.d/alsactl-restore

}


