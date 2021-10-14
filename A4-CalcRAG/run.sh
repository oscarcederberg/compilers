#!/bin/bash
set -eu
DRAST_HOME="$HOME/.drast"
if test -d "$DRAST_HOME"; then
  echo "DrAST is already installed in $DRAST_HOME"
  if test -d "$DRAST_HOME/.git"; then
    echo "Updating to latest version..."
    (cd $DRAST_HOME; git pull)
  fi
else
  echo "Installing DrAST to $DRAST_HOME"
  git clone https://bitbucket.org/jastadd/drast "$DRAST_HOME"
fi
(cd "$DRAST_HOME"; ./gradlew run)