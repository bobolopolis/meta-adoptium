HOMEPAGE = "https://adoptium.net"
LICENSE = "GPL-2.0-with-classpath-exception"
LIC_FILES_CHKSUM = "file://NOTICE;md5=0118abc27c1406bf05d7617cc4db30c9"

COMPATIBLE_HOST = "(aarch64|arm|powerpc64le|x86_64).*-linux"
# Binaries are linked with glibc
COMPATIBLE_HOST:libc-musl = "null"

JAVA_ARCH:aarch64 = "aarch64"
JAVA_ARCH:arm = "arm"
JAVA_ARCH:powerpc64le = "ppc64le"
JAVA_ARCH:x86-64 = "x64"

# Convert PV to forms needed to download the tarball
PV_MAJOR = "${@d.getVar('PV').split('.')[0]}"
PV_UNDER = "${@d.getVar('PV').replace('+', '_')}"

SRC_URI = "https://github.com/adoptium/temurin${PV_MAJOR}-binaries/releases/download/jdk-${PV}/OpenJDK${PV_MAJOR}U-${JAVA_TYPE}_${JAVA_ARCH}_linux_hotspot_${PV_UNDER}.tar.gz"
SRC_URI[sha256sum] = "${JAVA_SHA256}"

# Disable stuff not needed for packaging binaries
INHIBIT_DEFAULT_DEPS = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
EXCLUDE_FROM_SHLIBS = "1"
do_patch[noexec] = "1"
do_configure[noexec] = "1"
do_compile[noexec] = "1"

JAVA_HOME = "${libdir}/jvm/${BPN}"

do_install() {
    install -d ${D}${JAVA_HOME}
    cp -r ${S}/* ${D}${JAVA_HOME}
}

# The x86-64 binaries assume libraries are in /lib64, but a typical pure 64-bit
# Yocto image puts them in /lib. If not building a multilib image, add a
# symlink from /lib64 to /lib.
do_install:append:x86-64() {
    if [ -z "${MULTILIBS}" ]; then
        ln -s /lib ${D}/lib64
    fi
}

FILES:${PN} = "${JAVA_HOME}"
FILES:${PN}:append:x86-64 = " /lib64"

RDEPENDS:${PN} = " \
    alsa-lib \
    freetype \
    glibc \
    libx11 \
    libxext \
    libxi \
    libxrender \
    libxtst \
    zlib \
"

# Ignore "doesn't have GNU_HASH (didn't pass LDFLAGS?)" errors
INSANE_SKIP:${PN} += "ldflags"
