HOMEPAGE = "https://adoptium.net"
LICENSE = "GPL-2.0-with-classpath-exception"
LIC_FILES_CHKSUM = "file://NOTICE;md5=8fa9e85281110769de025562c085b3a4"

COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"

PV_MAJOR = "${@d.getVar('PV').split('.')[0]}"
PV_UNDER = "${@d.getVar('PV').replace('+', '_')}"

JAVA_ARCH:aarch64 = "aarch64"
JAVA_ARCH:x86-64 = "x64"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

JAVA_HOME = "${libdir}/jvm/${BPN}"

do_install() {
    install -d ${D}${JAVA_HOME}
    cp -r ${S}/* ${D}${JAVA_HOME}
}

FILES:${PN} = "${JAVA_HOME}"

RDEPENDS:${PN} = " \
    alsa-lib \
    freetype \
    libx11 \
    libxext \
    libxi \
    libxrender \
    libxtst \
    zlib \
"
