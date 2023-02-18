SUMMARY = "Temurin JRE Binaries"

JAVA_TYPE = "jre"
JAVA_SHA256:arm = "bf7ef7ba477dc278f913e64174e76be9ae7f014c767352eae83b3f9581494fce"
JAVA_SHA256:aarch64 = "3797815cb853616b6415e1b8875cda4eaa004887561ea4ea2090d726b8d8582f"
JAVA_SHA256:powerpc64le = "f11b86bfd7fa4d7a0d05040ea235102296f03eaf064253f76d7ab94baa0352e3"
JAVA_SHA256:x86-64 = "fe669935609086e76cb0b829e92808766cbf8cb7bda57a76b47813b08584bfd2"

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
