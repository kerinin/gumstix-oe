# gumstix x11 image + midori

require gumstix-basic-image.bb

PR="r0"

IMAGE_INSTALL += " \
  angstrom-gpe-task-apps \
  angstrom-gpe-task-base \
  angstrom-gpe-task-game \
  angstrom-gpe-task-pim \
  angstrom-gpe-task-settings \
  angstrom-x11-base-depends \
  midori \
 "

#ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'

