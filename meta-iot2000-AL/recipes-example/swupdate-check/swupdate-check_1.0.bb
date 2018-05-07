SUMMARY = "Start swupdate at boot to check for updates"
LICENSE = "CLOSED"
PR = "r1"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://swupdate-check"

S = "${WORKDIR}"

DEPENDS = "swupdate"
RDEPENDS_${PN} = "swupdate"

do_install() {
    if ${@bb.utils.contains('DISTRO_FEATURES','sysvinit','true','false',d)}; then
        install -d ${D}${sysconfdir}/init.d
        install ${S}/swupdate-check ${D}${sysconfdir}/init.d
    fi
}

inherit update-rc.d

INITSCRIPT_NAME = "swupdate-check"
INITSCRIPT_PARAMS = "defaults"
