#!/bin/bash

# edit line below for your setup
GUMSTIXTOP="/home/oe/gumstix/gumstix-oe"

# path to feed directory
OE_FEED="/var/www/feeds"

# list of machines to build for
BUILD_MACHINES=" \
                gumstix-custom-verdex \
                gumstix-custom-connex \
               "

# list of build targets
BUILD_TARGETS=" \
               gumstix-minimal-image \
               gumsix-basic-image \
               gumstix-directfb-image \
              "

cd $GUMSTIXTOP

. extras/profile

svn update

REVISION=`svnversion`

if [ ! -e $OE_FEED/archive/$REVISION ];
then
  echo "Building revision $REVISION"

  rm -rf tmp

  for machine in $BUILD_MACHINES
  do

    echo "MACHINE = \"$machine\"" > build/conf/auto.conf

    for target in $BUILD_TARGETS
    do
      bitbake $target
    done

  done

  mkdir -p $OE_FEED/archive/$REVISION
  cp -rf tmp/deploy/* $OE_FEED/archive/$REVISION
  
  svn revert build/conf/auto.conf
fi

