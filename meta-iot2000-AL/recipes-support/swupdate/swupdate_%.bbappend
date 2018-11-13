DESCRIPTION = "This configures the swupdate package"
LICENSE = "MIT"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRCREV = "master"

SRC_URI += "file://defconfig"

