#!/bin/bash

. extras/profile

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
               gumstix-basic-image \
               gumstix-directfb-image \
              "

cd $GUMSTIXTOP
echo "$GUMSTIXTOP is gumstix-oe root dir"

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
      bitbake $target && echo "$(date -u +%s) $target $BUILD_MODE $machine"
    done

  done

  mkdir -p $OE_FEED/archive/$REVISION
  cp -rf tmp/deploy/* $OE_FEED/archive/$REVISION
  
  cd $OE_FEED
  rm -f current
  ln -s $OE_FEED/archive/$REVISION current
  
  cd $GUMSTIXTOP
  svn revert build/conf/auto.conf
fi

