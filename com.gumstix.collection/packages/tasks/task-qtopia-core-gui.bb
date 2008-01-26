HOMEPAGE = "http://www.trolltech.com"
LICENSE = "MIT"

inherit task

DESCRIPTION_task-qtopia-core-gui = "QtopiaCore Core GUI libraries with LinuxFB graphics driver"
RDEPENDS_task-qtopia-core-gui = "\
    task-qtopia-core-console \
    libqtopiacoregui4 \
    libqtopiacoresvg4 \
    libqtopiacoredbus4 \
    libqtopiacorescript4 \
    qtopiacore-plugins-imageformats \
    qtopiacore-plugins-sqldrivers \
    qtopiacore-plugins-inputmethods \
    qtopiacore-plugins-iconengines \
    qtopiacore-fonts"

    
