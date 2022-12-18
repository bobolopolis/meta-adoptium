SUMMARY = "Temurin JDK Binaries"

include temurin.inc

SRC_URI = "https://github.com/adoptium/temurin${PV_MAJOR}-binaries/releases/download/jdk-${PV}/OpenJDK${PV_MAJOR}U-jdk_${JAVA_ARCH}_linux_hotspot_${PV_UNDER}.tar.gz"
JDK_SHA256:aarch64 = "1c26c0e09f1641a666d6740d802beb81e12180abaea07b47c409d30c7f368109"
JDK_SHA256:x86-64 = "482180725ceca472e12a8e6d1a4af23d608d78287a77d963335e2a0156a020af"
SRC_URI[sha256sum] = "${JDK_SHA256}"

S = "${WORKDIR}/jdk-${PV}"

inherit update-alternatives

ALTERNATIVE_PRIORITY = "100"
ALTERNATIVE:${PN} = "java javac keytool"

ALTERNATIVE_LINK_NAME[java] = "${bindir}/java"
ALTERNATIVE_TARGET[java] = "${JAVA_HOME}/bin/java"

ALTERNATIVE_LINK_NAME[javac] = "${bindir}/javac"
ALTERNATIVE_TARGET[javac] = "${JAVA_HOME}/bin/javac"

ALTERNATIVE_LINK_NAME[keytool] = "${bindir}/keytool"
ALTERNATIVE_TARGET[keytool] = "${JAVA_HOME}/bin/keytool"
