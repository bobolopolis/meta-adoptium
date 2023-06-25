SUMMARY = "Temurin JDK Binaries"

JAVA_TYPE = "jdk"
JAVA_SHA256:aarch64 = "0084272404b89442871e0a1f112779844090532978ad4d4191b8d03fc6adfade"
JAVA_SHA256:arm = "e7a84c3e59704588510d7e6cce1f732f397b54a3b558c521912a18a1b4d0abdc"
JAVA_SHA256:powerpc64le = "8f4366ff1eddb548b1744cd82a1a56ceee60abebbcbad446bfb3ead7ac0f0f85"
JAVA_SHA256:x86-64 = "e9458b38e97358850902c2936a1bb5f35f6cffc59da9fcd28c63eab8dbbfbc3b"

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
