SUMMARY = "Temurin JDK Binaries"

JAVA_TYPE = "jdk"
JAVA_SHA256:aarch64 = "8257de06bf37f0c8f19f8d542e2ab5a4e17db3ca5f29d041bd0b02ab265db021"
JAVA_SHA256:arm = "ce7873ebf40ed0eb1089941ead4d3af79a205b1264f3162860d26ae957572b74"
JAVA_SHA256:powerpc64le = "c97988e5a99b8ae0c47ba330b0883398c7433312db0051d8c5ff97911bae1605"
JAVA_SHA256:x86-64 = "9d4dd339bf7e6a9dcba8347661603b74c61ab2a5083ae67bf76da6285da8a778"

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
