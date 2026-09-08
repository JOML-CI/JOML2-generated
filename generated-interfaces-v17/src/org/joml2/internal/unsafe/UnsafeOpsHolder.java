package org.joml2.internal.unsafe;

public final class UnsafeOpsHolder {
    private UnsafeOpsHolder() {}
    public static final UnsafeOps U = resolve();
    private static UnsafeOps resolve() {
        try {
            return new JdkInternalUnsafeOps();
        } catch (Throwable t) {
            return new SunMiscUnsafeOps();
        }
    }
}
