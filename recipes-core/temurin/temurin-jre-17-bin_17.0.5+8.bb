SUMMARY = "Temurin JRE Binaries"

include temurin.inc

SRC_URI = "https://github.com/adoptium/temurin${PV_MAJOR}-binaries/releases/download/jdk-${PV}/OpenJDK${PV_MAJOR}U-jre_${JAVA_ARCH}_linux_hotspot_${PV_UNDER}.tar.gz"
JRE_SHA256:aarch64 = "34d6414710db27cd7760fe369135f3b9927ccc81410280606613166d4106d60a"
JRE_SHA256:x86-64 = "11326464a14b63e6328d1d2088a23fb559c0e36b3f380e4c1f8dcbe160a8b95e"
SRC_URI[sha256sum] = "${JRE_SHA256}"

S = "${WORKDIR}/jdk-${PV}-jre"

inherit update-alternatives

ALTERNATIVE_PRIORITY = "100"

ALTERNATIVE:${PN} = "java keytool"
ALTERNATIVE_LINK_NAME[java] = "${bindir}/java"
ALTERNATIVE_TARGET[java] = "${JAVA_HOME}/bin/java"

ALTERNATIVE_LINK_NAME[keytool] = "${bindir}/keytool"
ALTERNATIVE_TARGET[keytool] = "${JAVA_HOME}/bin/keytool"
