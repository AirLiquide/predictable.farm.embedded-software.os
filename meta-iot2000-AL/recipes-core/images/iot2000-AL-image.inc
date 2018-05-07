WKS_FILE = "AL-image.${MACHINE}.wks"

DESCRIPTION = "Air Liquide image for the IOT2000 platform"

#example features
IMAGE_FEATURES += " package-management"
IMAGE_FEATURES += " dev-pkgs"
IMAGE_FEATURES += " eclipse-debug"
IMAGE_FEATURES += " tools-sdk"
IMAGE_INSTALL_append = " opkg"
IMAGE_INSTALL_append = " imageversionfile"
IMAGE_INSTALL_append = " modules-load-entries"
IMAGE_INSTALL_append = " dmidecode"
IMAGE_INSTALL_append = " openssh"
IMAGE_INSTALL_append = " screen minicom"
IMAGE_INSTALL_append = " mraa upm"
IMAGE_INSTALL_append = " parted e2fsprogs dosfstools"
IMAGE_INSTALL_append = " nodejs nodejs-npm"
IMAGE_INSTALL_append = " node-red node-red-dashboard node-mraa node-red-node-intel-gpio"
IMAGE_INSTALL_append = " node-red-node-serialport node-red-contrib-boolean-logic"
IMAGE_INSTALL_append = " socket.io"
IMAGE_INSTALL_append = " forever"
IMAGE_INSTALL_append = " lua libjson swupdate"
IMAGE_INSTALL_append = " logrotate watchdog ntpdate"
IMAGE_INSTALL_append = " remote-shell"
IMAGE_INSTALL_append = " predictable-farm"
IMAGE_INSTALL_append = " powertop"
IMAGE_INSTALL_append = " git"
IMAGE_INSTALL_append = " strace"
IMAGE_INSTALL_append = " curl"
IMAGE_INSTALL_append = " pciutils"
IMAGE_INSTALL_append = " iptables"
IMAGE_INSTALL_append = " cmake"
IMAGE_INSTALL_append = " nano tree"
IMAGE_INSTALL_append = " iw wpa-supplicant wireless-tools"
IMAGE_INSTALL_append = " galileo-target"
IMAGE_INSTALL_append = " iot2000setup"
IMAGE_INSTALL_append = " sqlite3"
IMAGE_INSTALL_append = " i2c-tools"
IMAGE_INSTALL_append = " linux-firmware-common"
IMAGE_INSTALL_append = " mosquitto mosquitto-clients"
IMAGE_INSTALL_append = " python3-pip python3-modules"
IMAGE_INSTALL_append = " setledcolor"
IMAGE_INSTALL_append = " tzcode tzdata tzdata-misc tzdata-posix tzdata-right"
IMAGE_INSTALL_append = " tzdata-africa tzdata-americas tzdata-antarctica"
IMAGE_INSTALL_append = " tzdata-arctic tzdata-asia tzdata-atlantic"
IMAGE_INSTALL_append = " tzdata-australia tzdata-europe tzdata-pacific"
IMAGE_INSTALL_append = " cronie"