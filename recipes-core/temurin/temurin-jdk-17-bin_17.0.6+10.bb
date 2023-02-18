SUMMARY = "Temurin JDK Binaries"

JAVA_TYPE = "jdk"
JAVA_SHA256:aarch64 = "9e0e88bbd9fa662567d0c1e22d469268c68ac078e9e5fe5a7244f56fec71f55f"
JAVA_SHA256:arm = "fe4d0c6d5bb8cf7f59f7ff82c0c1fd988bbe5cccf3bc7377dc8ae50740b46c82"
JAVA_SHA256:powerpc64le = "cb772c3fdf3f9fed56f23a37472acf2b80de20a7113fe09933891c6ef0ecde95"
JAVA_SHA256:x86-64 = "a0b1b9dd809d51a438f5fa08918f9aca7b2135721097f0858cf29f77a35d4289"

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
