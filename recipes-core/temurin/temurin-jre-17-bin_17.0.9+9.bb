SUMMARY = "Temurin JRE Binaries"

JAVA_TYPE = "jre"
JAVA_SHA256:arm = "5ae1f8cae358e41083a6b44f53c6f0daeb657f83c293da6c8733f68278e13703"
JAVA_SHA256:aarch64 = "05b192f81ed478178ba953a2a779b67fc5a810acadb633ad69f8c4412399edb8"
JAVA_SHA256:powerpc64le = "79c85ecf1320c67b828310167e1ced62e402bc86a5d47ca9cc7bfa3b708cb07a"
JAVA_SHA256:x86-64 = "c37f729200b572884b8f8e157852c739be728d61d9a1da0f920104876d324733"

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
