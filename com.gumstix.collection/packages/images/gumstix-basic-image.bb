# basic gumstix image

require gumstix-minimal-image.bb

IMAGE_INSTALL += " \
    cron \
    ntp \
    ntpdate \
    boa \
    www-content \
    "


