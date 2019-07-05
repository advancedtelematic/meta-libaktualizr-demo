SUMMARY = "Demo libaktualizr application"
HOMEPAGE = "https://github.com/advancedtelematic/libaktualizr-demo"
SECTION = "base"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MPL-2.0;md5=815ca599c9df247a0c7f619bab123dad"

PV = "1.0+git${SRCPV}"
PR = "9"

DEPENDS = "boost curl openssl libarchive libsodium sqlite3 asn1c-native"

SRC_URI = " \
  gitsm://github.com/prateek-khatri/libaktualizr-demo;protocol=https;branch=LucidTest \
  file://10-defaults.toml \
  "
#https://github.com/prateek-khatri/libaktualizr-demo.git

SRC_URI_append = "${@('file://' + d.getVar('SOTA_PACKED_CREDENTIALS', True)) if d.getVar('SOTA_PACKED_CREDENTIALS', True) else ''}"

SRCREV = "${AUTOREV}"
BRANCH = "master"

S = "${WORKDIR}/git/demo-app"

inherit cmake

EXTRA_OECMAKE = " -DBUILD_SYSTEMD=OFF"

do_install_append () {
  install -m 0700 -d ${D}${libdir}/sota/conf.d
  install -m 0644 ${WORKDIR}/10-defaults.toml ${D}/${libdir}/sota/conf.d/10-defaults.toml
  if [ -n "${SOTA_PACKED_CREDENTIALS}" ]; then
      install -m 0700 -d ${D}${localstatedir}/sota
      cp "${SOTA_PACKED_CREDENTIALS}" ${D}${localstatedir}/sota/sota_provisioning_credentials.zip
  fi
}

FILES_${PN} += " \
  ${bindir}/libaktualizr-demo-app \
  ${libdir}/sota/sota.toml \
  ${libdir}/sota/conf.d \
  ${localstatedir}/sota/sota_provisioning_credentials.zip \
  "
