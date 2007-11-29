#@TYPE: Machine
#@Name: Gumstix pxa2xx boards
#@DESCRIPTION:  Gumstix pxa2xx boards

# Don't edit this file unless you *really* know what you are doing!

TARGET_ARCH = "arm"
PACKAGE_EXTRA_ARCHS = "armv4 armv4t armv5e armv5te "

PREFERRED_PROVIDER_virtual/kernel = "gumstix-kernel"
KERNEL_IMAGETYPE = "uImage"
RDEPENDS_kernel-base = ""

UBOOT_ENTRYPOINT = "a0008000"

MACHINE_FEATURES += "kernel26 "
COMBINED_FEATURES ?= ""

IMAGE_FSTYPES = "jffs2"
EXTRA_IMAGECMD_jffs2 = "--little-endian --eraseblock=0x20000 --squash-uids"

SERIAL_CONSOLE = "115200 ttyS0 vt100"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS =     " \
                                       "

MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= " \
                                       "

