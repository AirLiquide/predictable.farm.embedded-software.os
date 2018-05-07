FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://watchdog.conf"

do_install_append() {
    install -m 0755 ${WORKDIR}/watchdog.conf ${D}${sysconfdir}/watchdog.conf
}
