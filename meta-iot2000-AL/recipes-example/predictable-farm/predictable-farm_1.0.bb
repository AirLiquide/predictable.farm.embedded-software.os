LICENSE = "CLOSED"

SRC_URI = "file://bootstrap.sh"

S = "${WORKDIR}"

do_install () {
    mkdir -p ${D}/home/root/
    install -p -m 755 ${S}/bootstrap.sh ${D}/home/root/bootstrap.sh
    chmod +x ${D}/home/root/bootstrap.sh
}


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

inherit extrausers
EXTRA_USERS_PARAMS = "usermod -p $(openssl passwd -1 sopredictable) root;"
