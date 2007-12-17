PV = "1.0"
PR = "r1"
PE = "1"

PACKAGES = "${PN}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
	mkdir -p ${D}${sysconfdir}
	echo "Angstrom ${DISTRO_VERSION}"          > ${D}${sysconfdir}/gumstix-version
	echo "Revision `svnversion ${GUMSTIXTOP}`" >> ${D}${sysconfdir}/gumstix-version
  echo `date`                                >> ${D}${sysconfdir}/gumstix-version
  echo "Buid machine: `hostname`"            >> ${D}${sysconfdir}/gumstix-version
}
