DESCRIPTION = "Elf2flt is a wrapper around the linker for uclinux platforms"
DEPENDS = "binutils-cross"

PV = "0.0+svnr${SRCREV}"

inherit autotools cross

SRC_URI = "svn://sources.blackfin.uclinux.org/toolchain/trunk;module=${PN}"

S = "${WORKDIR}/${PN}"

EXTRA_OECONF = " --with-libbfd=${CROSS_DIR}/${TARGET_SYS}/lib/libbfd.a \
                 --with-libiberty=${CROSS_DIR}/${TARGET_SYS}/lib/libiberty.a \
                 --with-bfd-include-dir=${CROSS_DIR}/${TARGET_SYS}/include \
               "
