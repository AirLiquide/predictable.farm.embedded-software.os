FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://logrotate.conf"

do_install_append() {
    install -m 0644 ${WORKDIR}/logrotate.conf ${D}${sysconfdir}/logrotate.d/general
}
