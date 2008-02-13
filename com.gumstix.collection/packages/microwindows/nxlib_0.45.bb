DESCRIPTION = "NXLIB X11 Emulation Library for Nano-X"
PRIORITY = "optional"
DEPENDS = "microwindows-snapshot"
LICENSE = "GPL"

PR="r0"

SRC_URI = " \
  ftp://ftp.microwindows.org/pub/microwindows/nxlib-${PV}.tar.gz \
 "
EXTRA_OEMAKE = " \
  MWIN=${STAGING_DIR}/${HOSTSYS} \
  X11=${STAGING_DIR}/${HOSTSYS} \
"
