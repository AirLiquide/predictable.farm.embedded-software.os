LICENSE = "CLOSED"

SRC_URI = "file://bootstrap.sh \
           file://predictable-farm \
           file://logrotate.conf \
           file://hwrevision \
          "

S = "${WORKDIR}"

DEPENDS = "nodejs socket.io logrotate"

do_install () {
    mkdir -p ${D}/home/root/predictable-farm/logs/archives
    install -p -m 755 ${S}/bootstrap.sh ${D}/home/root/bootstrap.sh
    chmod +x ${D}/home/root/bootstrap.sh

    # Logrotate conf
    mkdir -p ${D}${sysconfdir}/logrotate.d
    install -m 0644 ${WORKDIR}/logrotate.conf ${D}${sysconfdir}/logrotate.d/predictable-farm

    mkdir -p ${D}${sysconfdir}
    install -p -m 755 ${S}/hwrevision ${D}${sysconfdir}/hwrevision

    if ${@bb.utils.contains('DISTRO_FEATURES','sysvinit','true','false',d)}; then
        install -d ${D}${sysconfdir}/init.d
        install ${S}/predictable-farm ${D}${sysconfdir}/init.d
    fi
}

inherit update-rc.d

INITSCRIPT_NAME = "predictable-farm"
INITSCRIPT_PARAMS = "defaults"

# pkg_postinst_* is run just after the *package* is installed
# in the image. If the execution of postint exits
# with success, the scripts are removed (since they had run already). If
# not, they are keeped and run again at first boot. People use this to
# defer the execution of post install script that need hardware to
# complete.

# password = sopredictable
pkg_postinst_${PN} () {
    #!/bin/sh -e
    if [ x"$D" = "x" ]; then
        ln -sf /usr/lib/node_modules/socket.io/node_modules/socket.io-client /usr/lib/node_modules/socket.io-client
        ln -sf /usr/lib/node_modules/forever/bin/forever /usr/bin/forever
        usermod -p $(openssl passwd -1 sopredictable) root
    else
        echo "Skipping postinst script, will do on first boot"
        exit 1
    fi
}

# It will cause your package to not own parent directories of the files you package.
# to prevent conflicts with the 'users' recipes
# See : https://stackoverflow.com/a/44763692/1741150
DIRFILES = "1"

FILES_${PN} += "/home/root/bootstrap.sh"
FILES_${PN} += "/home/root/predictable-farm/logs/archives"
FILES_${PN} += "/etc/hwrevision"

inherit extrausers
EXTRA_USERS_PARAMS = "usermod -p $(openssl passwd -1 sopredictable) root;"
