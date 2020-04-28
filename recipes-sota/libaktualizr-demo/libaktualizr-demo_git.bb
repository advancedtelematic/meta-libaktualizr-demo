SUMMARY = "Demo libaktualizr application"
HOMEPAGE = "https://github.com/advancedtelematic/libaktualizr-demo"
SECTION = "base"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MPL-2.0;md5=815ca599c9df247a0c7f619bab123dad"

PV = "1.0+git${SRCPV}"
PR = "9"

DEPENDS = "boost curl openssl libarchive libsodium sqlite3 asn1c-native"
RDEPENDS_${PN} = "aktualizr-lib aktualizr-secondary-lib"

SRC_URI = " \
  gitsm://github.com/advancedtelematic/libaktualizr-demo-app;protocol=https \
  "

SRCREV = "${AUTOREV}"
BRANCH = "master"

S = "${WORKDIR}/git"

inherit cmake

# For find_package(Git)
OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "BOTH"

do_install_append () {
  rm ${D}/${bindir}/aktualizr-get
  rm ${D}/${bindir}/uptane-generator
  rm ${D}/${bindir}/aktualizr-info
  rm ${D}/${bindir}/aktualizr-secondary
  rm ${D}/${bindir}/aktualizr-cert-provider
  rm ${D}/${bindir}/aktualizr
  rm -r ${D}${libdir}
}

FILES_${PN} = "${bindir}/libaktualizr-demo-app"
FILES_${PN}-dev = ""
