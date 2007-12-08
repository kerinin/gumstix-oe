DESCRIPTION = "program to read/write from i2c devices"
SECTION = "base"
PRIORITY = "required"
PR = "r1"

SRC_URI = " \
  file://Config.h \   
  file://Crc8.h \   
  file://Crc8.c \   
  file://DumpMem.h \   
  file://DumpMem.c \   
  file://Log.h \   
  file://Log.c \   
  file://i2c-api.h \   
  file://i2c-api.c \   
  file://i2c-dev.h \   
  file://i2c-io.h \   
  file://i2c-io-api.h \   
  file://i2c.h \   
  file://i2c.c \   
  "

S = "${WORKDIR}"

do_compile () {
	${CC} -o i2c *.c
}

do_install () {
  install -d ${D}${bindir}/
	install -m 0755 ${WORKDIR}/i2c ${D}${bindir}/
}

PACKAGES = "${PN}"
FILES_${PN} = "${bindir}/*"

