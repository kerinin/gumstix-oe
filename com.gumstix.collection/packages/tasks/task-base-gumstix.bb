DESCRIPTION = "Use machine options to create a basic gumstix machine task/package"
PR = "r1"

inherit task

PROVIDES = "${PACKAGES}"
PACKAGES = " \
    task-boot-gumstix \
    task-base-gumstix \
    ${@base_contains('MACHINE_FEATURES', 'i2c',         'task-base-gumstix-i2c', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'spi',         'task-base-gumstix-spi', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'pcmcia',      'task-base-gumstix-pcmcia', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'mmc',         'task-base-gumstix-mmc', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'serial',      'task-base-gumstix-serial', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'bluetooth',   'task-base-gumstix-bluetooth', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'usbgadget',   'task-base-gumstix-usbgadget', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'usbhost',     'task-base-gumstix-usbhost', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'wifi',        'task-base-gumstix-wifi', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'ethernet',    'task-base-gumstix-ethernet', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'fat',         'task-base-gumstix-fat', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'ext2',        'task-base-gumstix-ext2', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'sound',       'task-base-gumstix-sound', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'touchscreen', 'task-base-gumstix-touchscreen', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'screen',		  'task-base-gumstix-screen', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'keyboard',	  'task-base-gumstix-keyboard', '',d)} \
    "

RDEPENDS_task-base-gumstix = " \
    task-boot-gumstix \
    ${@base_contains('MACHINE_FEATURES', 'i2c',         'task-base-gumstix-i2c', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'spi',         'task-base-gumstix-spi', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'pcmcia',      'task-base-gumstix-pcmcia', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'mmc',         'task-base-gumstix-mmc', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'serial',      'task-base-gumstix-serial', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'bluetooth',   'task-base-gumstix-bluetooth', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'usbgadget',   'task-base-gumstix-usbgadget', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'usbhost',     'task-base-gumstix-usbhost', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'wifi',        'task-base-gumstix-wifi', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'ethernet',    'task-base-gumstix-ethernet', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'fat',         'task-base-gumstix-fat', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'ext2',        'task-base-gumstix-ext2', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'sound',       'task-base-gumstix-sound', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'touchscreen',	'task-base-gumstix-touchscreen', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'screen',		  'task-base-gumstix-screen', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'keyboard',	  'task-base-gumstix-keyboard', '',d)} \
    "

PACKAGE_ARCH_task-boot-gumstix = "${MACHINE_ARCH}"
PACKAGE_ARCH_task-base-gumstix = "${MACHINE_ARCH}"
PACKAGE_ARCH_task-base-gumstix-i2c = "${MACHINE_ARCH}"
PACKAGE_ARCH_task-base-gumstix-spi = "${MACHINE_ARCH}"
PACKAGE_ARCH_task-base-gumstix-pcmcia = "${MACHINE_ARCH}"
PACKAGE_ARCH_task-base-gumstix-mmc = "${MACHINE_ARCH}"
PACKAGE_ARCH_task-base-gumstix-serial = "${MACHINE_ARCH}"
PACKAGE_ARCH_task-base-gumstix-bluetooth = "${MACHINE_ARCH}"
PACKAGE_ARCH_task-base-gumstix-usbgadget = "${MACHINE_ARCH}"
PACKAGE_ARCH_task-base-gumstix-usbhost = "${MACHINE_ARCH}"
PACKAGE_ARCH_task-base-gumstix-wifi = "${MACHINE_ARCH}"
PACKAGE_ARCH_task-base-gumstix-ethernet = "${MACHINE_ARCH}"
PACKAGE_ARCH_task-base-gumstix-sound = "${MACHINE_ARCH}"
PACKAGE_ARCH_task-base-gumstix-touchscreen = "${MACHINE_ARCH}"
PACKAGE_ARCH_task-base-gumstix-screen = "${MACHINE_ARCH}"

DISTRO_DEV_MANAGER   ?= "udev"
DISTRO_INIT_MANAGER  ?= "sysvinit sysvinit-pidof"
DISTRO_LOGIN_MANAGER ?= "tinylogin"
DISTRO_SSH_DAEMON    ?= "dropbear"

RDEPENDS_task-boot-gumstix = "\
    kernel \
    busybox \
    initscripts \
    netbase \
    base-files \
    base-passwd \
    modutils-initscripts \
    module-init-tools \
    update-alternatives \
    update-modules \
    sysfsutils \
    angstrom-version \
    ipkg ipkg-collateral \
    util-linux-mount util-linux-umount \
    pxaregs \
    ${DEBUG_APPS} \
    ${DISTRO_DEV_MANAGER} \
    ${DISTRO_INIT_MANAGER} \
    ${DISTRO_LOGIN_MANAGER} \
    ${DISTRO_SSH_DAEMON} \
    ${MACHINE_ESSENTIAL_EXTRA_RDEPENDS} \
    "

RRECOMMENDS_task-boot-gumstix = "\
    kernel-module-loop \
    kernel-module-proc-gpio \
    kernel-module-rtc-dev \
    kernel-module-rtc-proc \
    kernel-module-rtc-sysfs \
    kernel-module-rtc-sa1100 \
    kernel-module-sa1100-wdt \
    ${MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS} \
    "

RDEPENDS_task-base-gumstix-i2c = "\
    i2c \
    "

RRECOMMENDS_task-base-gumstix-i2c = "\
    kernel-module-i2c-core \
    kernel-module-i2c-dev \
    kernel-module-i2c-pxa \
    "

RDEPENDS_task-base-gumstix-spi = "\
    "

RRECOMMENDS_task-base-gumstix-spi = "\
    kernel-module-pxa2xx-spi \
    "

RDEPENDS_task-base-gumstix-pcmcia = "\
    pcmciautils \
    "

RRECOMMENDS_task-base-gumstix-pcmcia = "\
    kernel-module-pcmcia \
    kernel-module-pxa2xx-core \
    kernel-module-pxa2xx-cs \
    kernel-module-serial-cs \
    kernel-module-pcnet-cs \
    kernel-module-ide-cs \
    kernel-module-ide-disk \
    kernel-module-ide-generic \
    kernel-module-firmware-class \
    "

RDEPENDS_task-base-gumstix-mmc = "\
    "

RRECOMMENDS_task-base-gumstix-mmc = "\
    kernel-module-pxamci \
    kernel-module-mmc-block \
    "

RDEPENDS_task-base-gumstix-serial = "\
    setserial \
    lrzsz "

RDEPENDS_task-base-gumstix-bluetooth = "\ 
    bluez-utils \
    bluez-utils-compat \  
    "

RRECOMMENDS_task-base-gumstix-bluetooth = "\
    kernel-module-bluetooth \
    kernel-module-l2cap \
    kernel-module-rfcomm \
    kernel-module-bnep \
    kernel-module-hidp \
    kernel-module-sco \
    kernel-module-hci-vhci \
    kernel-module-hci-uart \
    ${@base_contains('MACHINE_FEATURES', 'usbhost', 'kernel-module-hci-usb', '',d)} \
    "

RRECOMMENDS_task-base-gumstix-usbgadget = "\
    kernel-module-gumstix-gadget \
    kernel-module-pxa2xx_udc \
    kernel-module-g-file-storage \
    kernel-module-g-serial \
    kernel-module-g-ether \
    usb-gadget-mode \
    "

RDEPENDS_task-base-gumstix-usbhost = "\
    usbutils "

RRECOMMENDS_task-base-gumstix-usbhost = "\
    kernel-module-ohci-hcd \
    kernel-module-usbcore \
    kernel-module-usbnet \
    kernel-module-sd-mod \
    kernel-module-scsi-mod \
    kernel-module-usbserial \
    kernel-module-usb-storage \
    kernel-module-usbhid \
    kernel-module-usbmouse \
    kernel-module-mousedev \
    "

RDEPENDS_task-base-gumstix-wifi = "\
    task-base-gumstix-pcmcia \
    wifistix-modules \
    wireless-tools \
    wpa-supplicant \
    "

RRECOMMENDS_task-base-gumstix-wifi = "\
    kernel-module-ieee80211 \
    kernel-module-ieee80211-crypt \
    kernel-module-ieee80211-crypt-ccmp \
    kernel-module-ieee80211-crypt-tkip \
    kernel-module-ieee80211-crypt-wep \
    kernel-module-ecb \
    kernel-module-arc4 \
    kernel-module-michael-mic \
    kernel-module-aes \
    ${@base_contains('MACHINE_FEATURES', 'usbhost', 'kernel-module-zd1201', '',d)} \
    ${@base_contains('MACHINE_FEATURES', 'usbhost', 'kernel-module-zd1211rw', '',d)} \
    "

RDEPENDS_task-base-gumstix-ethernet = "\
    "

RRECOMMENDS_task-base-gumstix-ethernet = "\
    kernel-module-smc91x \
    kernel-module-smc911x \
    "

RRECOMMENDS_task-base-gumstix-fat = "\
    kernel-module-vfat \
    kernel-module-nls-base \
    kernel-module-nls-cp437 \
    kernel-module-nls-iso8859-1 \
    "

RDEPENDS_task-base-gumstix-ext2 = "\
    hdparm \
    e2fsprogs \
    e2fsprogs-e2fsck \
    e2fsprogs-mke2fs \
    "

RRECOMMENDS_task-base-gumstix-ext2 = "\
    kernel-module-ext2 \
    "

RDEPENDS_task-base-gumstix-sound = "\
    alsa-utils-alsactl \
    alsa-utils-alsamixer \
    "

RRECOMMENDS_task-base-gumstix-sound = "\
    alsa-state \
    alsa-states \
    kernel-module-snd-soc-gumstix \
    kernel-module-snd-pcm-oss \
    kernel-module-snd-mixer-oss \
    "

RDEPENDS_task-base-gumstix-touchscreen = "\
    tslib \
    tslib-tests \
    tslib-calibrate \
    "

RRECOMMENDS_task-base-gumstix-touchscreen = "\
    kernel-module-tsc2003 \
    kernel-module-ucb1400-ts \
    kernel-module-evdev \
    "

RRECOMMENDS_task-base-gumstix-screen = "\    
    kernel-module-pxafb \
    "

RDEPENDS_task-base-gumstix-keyboard = "\
    keymaps \
    "



