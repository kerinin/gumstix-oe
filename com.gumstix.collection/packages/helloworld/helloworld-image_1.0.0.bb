# hello world image - inherits from gumstix-basic-image

PR="r0"

require ${GUMSTIXTOP}/com.gumstix.collection/packages/images/gumstix-basic-image.bb

IMAGE_INSTALL += " \
    helloworld \
    "


