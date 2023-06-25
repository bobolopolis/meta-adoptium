SUMMARY = "Temurin JRE Binaries"

JAVA_TYPE = "jre"
JAVA_SHA256:arm = "5b0401199c7c9163b8395ebf25195ed395fec7b7ef7158c36302420cf993825a"
JAVA_SHA256:aarch64 = "2ff6a4fd1fa354047c93ba8c3179967156162f27bd683aee1f6e52a480bcbe6a"
JAVA_SHA256:powerpc64le = "cc25e74c0817cd4d943bba056b256b86e0e9148bf41d7600c5ec2e1eadb2e470"
JAVA_SHA256:x86-64 = "bb025133b96266f6415d5084bb9b260340a813968007f1d2d14690f20bd021ca"

require temurin.inc

S = "${WORKDIR}/jdk-${PV}-jre"

inherit update-alternatives

# Lower than corresponding JDK
ALTERNATIVE_PRIORITY = "90"

ALTERNATIVE:${PN} = "java keytool"
ALTERNATIVE_LINK_NAME[java] = "${bindir}/java"
ALTERNATIVE_TARGET[java] = "${JAVA_HOME}/bin/java"

ALTERNATIVE_LINK_NAME[keytool] = "${bindir}/keytool"
ALTERNATIVE_TARGET[keytool] = "${JAVA_HOME}/bin/keytool"
