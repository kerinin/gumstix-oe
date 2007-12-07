#!/bin/bash

# edit line below for your setup
export GUMSTIXTOP="/home/oe/gumstix/gumstix-oe"

# path to feed archives directory
export OE_FEED="/var/www/feeds/archives"

cd $GUMSTIXTOP

. extras/profile

svn update

export REVISION=`svnversion`

if [ ! -e $OE_FEED/$REVISION ];
then
  echo "Building revision $REVISION"

  rm -rf tmp

  for i in gumstix-custom-connex gumstix-custom-verdex
    do
      echo "MACHINE = \"$i\"" > build/conf/auto.conf
      bitbake gumstix-basic-image
      bitbake gumstix-directfb-image
    done

  mkdir -p $OE_FEED/$REVISION
  cp -rf tmp/deploy/* $OE_FEED/$REVISION

  svn revert build/conf/auto.conf
fi

