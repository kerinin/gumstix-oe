RPROVIDES_${PN} = "hotplug"

PR = "r1"

SRC_URI = "http://kernel.org/pub/linux/utils/kernel/hotplug/udev-${PV}.tar.gz \
	   file://noasmlinkage.patch;patch=1 \
	   file://flags.patch;patch=1 \
	   file://vol_id_ld.patch;patch=1 \
	   file://udevtrigger_add_devname_filtering.patch;patch=1 \
	   "

require udev.inc



