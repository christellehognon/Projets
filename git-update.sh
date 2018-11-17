#!/bin/sh
date=`date "+%Y-%m-%d"`
git add *
git commit -m "Mise à jour du $date"
git push
chmod 777 * -R
