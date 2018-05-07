FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://logrotate.conf"

do_install_append() {
    mkdir -p ${D}${localstatedir}/log/archives
    mkdir -p ${D}/home/root/predictable-farm/logs/archives
    install -m 0644 ${WORKDIR}/logrotate.conf ${D}${sysconfdir}/logrotate.conf
}


FILES_${PN} += "/var/log/archives"
FILES_${PN} += "/home/root/predictable-farm/logs/archives"