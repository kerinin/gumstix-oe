DESCRIPTION = "udev is a daemon which dynamically creates and removes device nodes from \
/dev/, handles hotplug events and loads drivers at boot time."
SECTION = "base"
PRIORITY = "required"
LICENSE = "GPL"
PR = "r4"

RPROVIDES_${PN} = "hotplug"

SRC_URI = "http://kernel.org/pub/linux/utils/kernel/hotplug/udev-${PV}.tar.gz \
	   file://noasmlinkage.patch;patch=1 \
	   file://flags.patch;patch=1 \
	   file://vol_id_ld.patch;patch=1 \
	   file://udevtrigger_add_devname_filtering.patch;patch=1 \
     file://init \
     file://20-sound.rules \
     file://85-sdmod.rules \
     file://86-touchscreen.rules \
    "

inherit update-rc.d autotools pkgconfig

PARALLEL_MAKE = ""
PKG_libvolume-id-dev = "libvolume-id-dev"

INITSCRIPT_NAME = "udev"
INITSCRIPT_PARAMS = "start 03 S ."

export CROSS = "${TARGET_PREFIX}"
export HOSTCC = "${BUILD_CC}"
export udevdir ?= "/dev"
export usrbindir := "${bindir}"
export usrsbindir := "${sbindir}"
export etcdir = "${sysconfdir}"
LD = "${CC}"
bindir = "/bin"
sbindir = "/sbin"

UDEV_EXTRAS = "extras/firmware/ extras/scsi_id/ extras/volume_id/"
EXTRA_OEMAKE = "-e 'EXTRAS=${UDEV_EXTRAS}' 'STRIP=echo'"
EXTRA_OEMAKE += "libudevdir=/lib/udev libdir=${base_libdir} prefix="

do_install () {
	install -d ${D}${usrsbindir} ${D}${sysconfdir} ${D}${sbindir}
	oe_runmake 'DESTDIR=${D}' INSTALL=install install

	install -d ${D}${sysconfdir}/udev/rules.d/
	install -m 0644 ${WORKDIR}/85-sdmod.rules       ${D}${sysconfdir}/udev/rules.d/
	install -m 0644 ${WORKDIR}/86-touchscreen.rules ${D}${sysconfdir}/udev/rules.d/

	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/udev
}

do_stage () {
	autotools_stage_all
        install -m 0644 ${S}/extras/volume_id/lib/libvolume_id.h ${STAGING_INCDIR}
        oe_libinstall -C extras/volume_id/lib -so libvolume_id ${STAGING_LIBDIR}
}

PACKAGES =+ "udev-utils libvolume-id libvolume-id-dev"

FILES_${PN} += "${usrbindir}/* ${usrsbindir}/* ${base_libdir}/udev/*"
FILES_${PN}-dbg += "${base_libdir}/udev/.debug ${usrbindir}/.debug ${usrsbindir}/.debug"

FILES_udev-utils = "${usrbindir}/udevinfo ${usrbindir}/udevtest"

FILES_libvolume-id = "${base_libdir}/libvolume_id.so.*"
FILES_libvolume-id-dev = "${includedir}/libvolume_id.h ${libdir}/libvolume_id.a ${libdir}/libvolume_id.so ${libdir}/pkgconfig/libvolume_id.pc"


