DESCRIPTION = "Microwindows Graphical Engine"
SECTION = "x11/wm"
PRIORITY = "optional"
DEPENDS = "libpng jpeg zlib"
LICENSE = "GPL"

PR="r0"

SRC_URI = " \
  ftp://ftp.microwindows.org/pub/microwindows/microwindows-${PV}.tar.gz \
  file://defconfig \
  file://pagesize.patch;patch=1 \
  file://nochown.patch;patch=1 \
 "

EXTRA_OEMAKE = " \
  -C ${S}/src \
  VERBOSE=Y \
  CONFIG=${WORKDIR}/defconfig \
  ARMTOOLSPREFIX=${TARGET_PREFIX}	\
  INCJPEG=${STAGING_INCDIR} \
  LIBJPEG=${STAGING_LIBDIR}/libjpeg.so \
  INCPNG=${STAGING_INCDIR} \
  LIBPNG=${STAGING_LIBDIR}/libpng.so \
  LIBZ=${STAGING_LIBDIR}/libz.so \
  INSTALL_PREFIX=${D}${prefix} \
 "

do_compile() {
  oe_runmake
}

do_stage() {
	install -m 0644 src/include/nano-X.h ${STAGING_INCDIR}/
	install -m 0644 src/include/mwtypes.h ${STAGING_INCDIR}/
	install -m 0644 src/include/nxcolors.h ${STAGING_INCDIR}/
	install -m 0644 src/include/nxdraw.h ${STAGING_INCDIR}/
	install -m 0755 src/lib/*.so ${STAGING_LIBDIR}/
	install -m 0644 src/lib/*.a ${STAGING_LIBDIR}/
}

do_install() {
  oe_runmake  install
	install -d ${D}${bindir} ${D}${libdir}
	install -m 0755 src/lib/* ${D}${libdir}
	install -m 0755 src/bin/* ${D}${bindir}/
}

FILES_${PN}="${bindir}/* ${libdir}/*"
