SUMMARY = "Temurin JRE Binaries"
HOMEPAGE = "https://adoptium.net"
LICENSE = "GPL-2.0-with-classpath-exception"
LIC_FILES_CHKSUM = "file://NOTICE;md5=8fa9e85281110769de025562c085b3a4"

COMPATIBLE_HOST = "x86_64.*-linux"

PV_MAJOR = "${@d.getVar('PV').split('.')[0]}"
PV_UNDER = "${@d.getVar('PV').replace('+', '_')}"

SRC_URI = "https://github.com/adoptium/temurin${PV_MAJOR}-binaries/releases/download/jdk-${PV}/OpenJDK${PV_MAJOR}U-jre_x64_linux_hotspot_${PV_UNDER}.tar.gz"
SRC_URI[sha256sum] = "11326464a14b63e6328d1d2088a23fb559c0e36b3f380e4c1f8dcbe160a8b95e"

S = "${WORKDIR}/jdk-${PV}-jre"

inherit update-alternatives

do_configure[noexec] = "1"
do_compile[noexec] = "1"

JRE_HOME = "${libdir}/jvm/${BPN}"

ALTERNATIVE_PRIORITY = "100"

ALTERNATIVE:${PN} = "java keytool"
ALTERNATIVE_LINK_NAME[java] = "${bindir}/java"
ALTERNATIVE_TARGET[java] = "${JRE_HOME}/bin/java"

ALTERNATIVE_LINK_NAME[keytool] = "${bindir}/keytool"
ALTERNATIVE_TARGET[keytool] = "${JRE_HOME}/bin/keytool"

do_install() {
    install -d ${D}${JRE_HOME}
    cp -r ${S}/* ${D}${JRE_HOME}
}

FILES:${PN} = "${JRE_HOME}"
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
