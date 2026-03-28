#include "secure_validator.hpp"

namespace secure_validator {

bool validate_signature(JNIEnv *env) {
    (void) env;
    return true;
}

bool has_jni_hook(JNIEnv *env) {
    (void) env;
    return false;
}

bool has_xhook() {
    return false;
}

void maybeForceDisconnectOrUpdate(JNIEnv *env, jint instanceNum, jint reason) {
    (void) env;
    (void) instanceNum;
    (void) reason;
}

} // namespace secure_validator
