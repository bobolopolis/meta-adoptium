SUMMARY = "Temurin JRE Binaries"

JAVA_TYPE = "jre"
JAVA_SHA256:aarch64 = "9dfe4c56463690ae67d22268980d8861eb46b907d7914f8f2e6fc7b25778c8ec"
JAVA_SHA256:arm = "f093094abe0cb2bb5a255d8180810030321073520541f289926c4682eda76136"
JAVA_SHA256:powerpc64le = "2759c48e1e56117871b04c851af18b92b6992cf67590f602949b96c3cff15c73"
JAVA_SHA256:x86-64 = "0e8088d7a3a7496faba7ac8787db09dc0264c2bc6f568ea8024fd775a783e13c"

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
