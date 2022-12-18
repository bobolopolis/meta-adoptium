COMPATIBLE_HOST = "(aarch64|x86_64).*-linux"

PV_MAJOR = "${@d.getVar('PV').split('.')[0]}"
PV_UNDER = "${@d.getVar('PV').replace('+', '_')}"

JAVA_ARCH:aarch64 = "aarch64"
JAVA_ARCH:x86-64 = "x64"

do_configure[noexec] = "1"
do_compile[noexec] = "1"
