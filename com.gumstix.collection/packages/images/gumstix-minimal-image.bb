# minimal gumstix image

inherit image

BASE_URI = "http://www.sakoman.net/feeds/current/uclibc/ipkg"

FEED_URIS = " \
		no-arch##${BASE_URI}/all \
		base##${BASE_URI}/${FEED_ARCH} \
		${MACHINE}##${BASE_URI}/${MACHINE} \
    "

IMAGE_INSTALL = " \
    task-base-gumstix \
    "


