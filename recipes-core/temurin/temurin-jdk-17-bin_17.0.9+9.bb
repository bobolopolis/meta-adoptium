SUMMARY = "Temurin JDK Binaries"

JAVA_TYPE = "jdk"
JAVA_SHA256:aarch64 = "e2c5e26f8572544b201bc22a9b28f2b1a3147ab69be111cea07c7f52af252e75"
JAVA_SHA256:arm = "626b2375b08554ad4cbad440a7ff490277bc196852589dd48cab514a7428fa8b"
JAVA_SHA256:powerpc64le = "3ae4b254d5b720f94f986481e787fbd67f0667571140ba2e2ae5020ceddbc826"
JAVA_SHA256:x86-64 = "7b175dbe0d6e3c9c23b6ed96449b018308d8fc94a5ecd9c0df8b8bc376c3c18a"

require temurin.inc

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
