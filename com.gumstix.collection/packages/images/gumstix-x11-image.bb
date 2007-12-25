# basic gumstix image

inherit image

BASE_URI = "http://www.sakoman.net/feeds/gumstix-uclibc"

FEED_URIS = " \
		no-arch##${BASE_URI}/all \
		base##${BASE_URI}/${FEED_ARCH} \
		${MACHINE}##${BASE_URI}/${MACHINE} \
    "

IMAGE_INSTALL = " \
    task-base-gumstix \
#    cron \
#    ntp \
#    ntpdate \
#    boa \
    gdk-pixbuf-loader-png \
    gdk-pixbuf-loader-gif \
    gdk-pixbuf-loader-xpm \
    gdk-pixbuf-loader-jpeg \
    gtk+ \
    matchbox-common \
    matchbox-wm \
    matchbox-panel \
    matchbox-desktop \
    xserver-kdrive-fbdev \
    xserver-kdrive-common \
    xserver-nodm-init \
    ttf-bitstream-vera \
    "

