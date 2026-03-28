#pragma once

#include <jni.h>

namespace secure_validator {

bool validate_signature(JNIEnv *env);
bool has_jni_hook(JNIEnv *env);
bool has_xhook();
void maybeForceDisconnectOrUpdate(JNIEnv *env, jint instanceNum, jint reason);

} // namespace secure_validator
