#pragma once

// The original project appears to use an obfuscation helper here. This stub
// keeps native/JNI symbol lookup working in environments where that module is
// absent from the repository.
#define skCrypt(value) value
