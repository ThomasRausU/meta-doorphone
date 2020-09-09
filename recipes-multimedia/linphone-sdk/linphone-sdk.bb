DESCRIPTION = "Audio/video SIP-based IP phone sdk"
LICENSE = "GPLv3"
HOMEPAGE = "http://www.linphone.org/technical-corner/linphone/overview"
SECTION = "network"
SECTION_linphonec =  "console/network"

python () {
    if d.getVar('LATEST_REVISIONS', True) == "1":
        d.setVar('SRCREV', '${AUTOREV}')
    else:
        d.setVar('SRCREV', 'a858005cab82ff270eeb4104637abc52d10c1441')
}

# For visualisation
python () {
    print("")
    print("linphone")
    print(d.getVar('SRCREV', True))
}

SRC_URI = "gitsm://gitlab.linphone.org/BC/public/linphone-sdk.git;protocol=https"
PV = "git_${SRCREV}"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ff3103b5db8ba4e2c66c511b7a73e407"

PROVIDES = "liblinphone"

DEPENDS = "python-pip python-pystache-native python-six-native doxygen-native nasm-native yasm-native"

S = "${WORKDIR}/git"


EXTRA_OECMAKE += " -DENABLE_VIDEO=ON -DLINPHONESDK_PLATFORM=Raspberry -DENABLE_GPL_THIRD_PARTIES=ON -DCMAKE_INSTALL_PREFIX=${prefix}"
inherit cmake pythonnative

EXTRA_OECMAKE += " -DENABLE_CONSOLE_UI=NO -DENABLE_GTK_UI=NO -DCMAKE_SKIP_INSTALL_RPATH=ON -DENABLE_CXX_WRAPPER=NO -DENABLE_VCARD=ON "
EXTRA_OECMAKE += "-DCMAKE_INSTALL_DATAROOTDIR=share -DCMAKE_INSTALL_LIBDIR=lib "

# INSANE_SKIP_${PN} += "dev-deps"

#PACKAGES += " ${PN}c ${PN}-common ${PN}-tester ${PN}-utils ${PN}-rings"
