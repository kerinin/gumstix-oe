# basic gumstix image

require gumstix-basic-image.bb

inherit distutils

IMAGE_INSTALL += " \
    uisp \
    "

