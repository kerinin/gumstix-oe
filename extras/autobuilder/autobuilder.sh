#!/bin/bash

# edit if necessary to reflect your setup
. $HOME/gumstix/gumstix-oe/extras/profile

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
               gumstix-perl-image \
               gpsd \
               madplay \
              "
              
cd $GUMSTIXTOP
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
      bitbake $target && echo "Completed $target for $machine"
    done
# hack to prevent link error on bluez-utils on subsequent machines
    bitbake -c clean gettext
    bitbake -c clean glib-2.0
    bitbake -c clean libiconv
  done

  svn revert build/conf/auto.conf

  mkdir -p $OE_FEED/archive/$REVISION
  cp -rf tmp/deploy/* $OE_FEED/archive/$REVISION
  
  cd $OE_FEED
  rm -f current
  ln -s $OE_FEED/archive/$REVISION current
  
# use for syncing to remote server
  ftpsyncup

fi

