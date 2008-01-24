DESCRIPTION = "hello world sample program"

PR = "r0"

DEPENDS = ""

SRC_URI = " \
   file://hello.c \
  "

CMD_NAME=hello

S = "${WORKDIR}"

do_compile () {
	${CC} ${CFLAGS} ${LDFLAGS} -o ${CMD_NAME} *.c
}

do_install () {
  install -d ${D}${bindir}/
	install -m 0755 ${WORKDIR}/${CMD_NAME} ${D}${bindir}/
}

PACKAGES = "${PN}"
FILES_${PN} = "${bindir}/*"

