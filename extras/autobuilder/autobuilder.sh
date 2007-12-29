#!/bin/bash

# edit if necessary to reflect your setup
. $HOME/gumstix/gumstix-oe/extras/profile

# path to feed directory
OE_FEED="/var/www/feeds"

# list of libc variants to build
BUILD_LIBC=" \
                uclibc \
                glibc \
               "

# list of machines to build
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
                gumstix-x11-image \
                qtopia-core \
                dhcp \
                bridge-utils \
                iptables \
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

  for libc in $BUILD_LIBC
  do    
    echo "ANGSTROM_MODE = \"$libc\"" >> build/conf/local.conf
    for machine in $BUILD_MACHINES
    do
      echo "MACHINE = \"$machine\"" > build/conf/auto.conf

      for target in $BUILD_TARGETS
      do
        echo "Building $libc $target for $machine"
        bitbake $target
        echo "Completed $libc $target for $machine"
      done

      # hack to prevent link error on bluez-utils on subsequent machines
      bitbake -c clean gettext
      bitbake -c clean glib-2.0
      bitbake -c clean libiconv
    done
    svn revert build/conf/local.conf
  done

  svn revert build/conf/auto.conf

  mkdir -p $OE_FEED/archive/$REVISION
  cp -rf tmp/deploy/* $OE_FEED/archive/$REVISION

  # Cleanout stuff not needed in feed
  for libc in $BUILD_LIBC
  do
    rm     $OE_FEED/archive/$REVISION/$libc/ipk/Packages*
    rm -rf $OE_FEED/archive/$REVISION/$libc/ipk/i686
    for machine in $BUILD_MACHINES
    do
      rm     $OE_FEED/archive/$REVISION/$libc/images/$machine/modules*
    done
  done
  
  cd $OE_FEED
  rm -f current
  ln -s $OE_FEED/archive/$REVISION current
  
# use for syncing to remote server
  ftpsyncup

fi

