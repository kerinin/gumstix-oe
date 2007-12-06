#!/bin/bash

# edit line below for your setup
cd $HOME/gumstix/gumstix-oe

. extras/profile

svn update

rm -rf tmp

for i in gumstix-custom-connex gumstix-custom-verdex
        do
          echo "MACHINE = \"$i\"" > build/conf/auto.conf
          bitbake gumstix-basic-image
          bitbake gumstix-directfb-image
        done


