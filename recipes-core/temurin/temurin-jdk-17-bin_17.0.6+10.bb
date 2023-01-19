SUMMARY = "Temurin JDK Binaries"
HOMEPAGE = "https://adoptium.net"
LICENSE = "GPL-2.0-with-classpath-exception"
LIC_FILES_CHKSUM = "file://NOTICE;md5=8fa9e85281110769de025562c085b3a4"

COMPATIBLE_HOST = "x86_64.*-linux"

PV_MAJOR = "${@d.getVar('PV').split('.')[0]}"
PV_UNDER = "${@d.getVar('PV').replace('+', '_')}"

SRC_URI = "https://github.com/adoptium/temurin${PV_MAJOR}-binaries/releases/download/jdk-${PV}/OpenJDK${PV_MAJOR}U-jdk_x64_linux_hotspot_${PV_UNDER}.tar.gz"
SRC_URI[sha256sum] = "a0b1b9dd809d51a438f5fa08918f9aca7b2135721097f0858cf29f77a35d4289"

S = "${WORKDIR}/jdk-${PV}"

inherit update-alternatives

do_configure[noexec] = "1"
do_compile[noexec] = "1"

JDK_HOME = "${libdir}/jvm/${BPN}"

ALTERNATIVE_PRIORITY = "100"
ALTERNATIVE:${PN} = "java javac keytool"

ALTERNATIVE_LINK_NAME[java] = "${bindir}/java"
ALTERNATIVE_TARGET[java] = "${JDK_HOME}/bin/java"

ALTERNATIVE_LINK_NAME[javac] = "${bindir}/javac"
ALTERNATIVE_TARGET[javac] = "${JDK_HOME}/bin/javac"

ALTERNATIVE_LINK_NAME[keytool] = "${bindir}/keytool"
ALTERNATIVE_TARGET[keytool] = "${JDK_HOME}/bin/keytool"

do_install() {
    install -d ${D}${JDK_HOME}
    cp -r ${S}/* ${D}${JDK_HOME}
}

FILES:${PN} = "${JDK_HOME}"
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
