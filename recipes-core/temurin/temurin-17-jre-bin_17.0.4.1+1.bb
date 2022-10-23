SUMMARY = "Adoptium"
HOMEPAGE = "https://adoptium.net"
LICENSE = "GPL-2.0-with-classpath-exception"
LIC_FILES_CHKSUM = "file://NOTICE;md5=8fa9e85281110769de025562c085b3a4"

SRC_URI = "https://github.com/adoptium/temurin17-binaries/releases/download/jdk-${PV}/OpenJDK17U-jre_x64_linux_hotspot_17.0.4.1_1.tar.gz"
SRC_URI[sha256sum] = "e96814ee145a599397d91e16831d2dddc3c6b8e8517a8527e28e727649aaa2d1"

S = "${WORKDIR}/jdk-${PV}-jre"

inherit update-alternatives

do_configure[noexec] = "1"
do_compile[noexec] = "1"

JRE_HOME = "${libdir}/jvm/temurin-17-jre"

ALTERNATIVE_PRIORITY = "100"

ALTERNATIVE:${PN} = "java keytool"
ALTERNATIVE_LINK_NAME[java] = "${bindir}/java"
ALTERNATIVE_TARGET[java] = "${JRE_HOME}/bin/java"

ALTERNATIVE_LINK_NAME[keytool] = "${bindir}/keytool"
ALTERNATIVE_TARGET[keytool] = "${JRE_HOME}/bin/keytool"

do_install() {
    install -d ${D}${JRE_HOME}
    cp -a ${S}/* ${D}${JRE_HOME}
    chown -R root:root ${D}${JRE_HOME}
}

FILES:${PN} = "${JRE_HOME}"
RDEPENDS:${PN}:append = " \
    alsa-lib \
    freetype \
    libx11 \
    libxext \
    libxi \
    libxrender \
    libxtst \
    zlib \
"

INSANE_SKIP:${PN} += "ldflags"
