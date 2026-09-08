package org.joml2.internal.unsafe;

import java.nio.Buffer;

import static org.joml2.internal.unsafe.UnsafeOpsHolder.U;

public final class UnsafeCopy {
    private UnsafeCopy() {}
    public static final long FLOAT_ARRAY_BASE  = U.arrayBaseOffset(float[].class);
    public static final long DOUBLE_ARRAY_BASE = U.arrayBaseOffset(double[].class);
    public static final long INT_ARRAY_BASE    = U.arrayBaseOffset(int[].class);
    public static final long LONG_ARRAY_BASE   = U.arrayBaseOffset(long[].class);
    public static final long SHORT_ARRAY_BASE  = U.arrayBaseOffset(short[].class);
    public static final long BYTE_ARRAY_BASE   = U.arrayBaseOffset(byte[].class);
    public static final long BB_ADDRESS_OFFSET;
    static {
        try {
            BB_ADDRESS_OFFSET = U.objectFieldOffset(Buffer.class.getDeclaredField("address"));
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
