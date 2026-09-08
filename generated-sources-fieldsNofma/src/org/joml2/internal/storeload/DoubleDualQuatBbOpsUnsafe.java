package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import static org.joml2.internal.unsafe.UnsafeOpsHolder.U;

public final class DoubleDualQuatBbOpsUnsafe implements DoubleDualQuatBbOps {

    private static final DoubleDualQuatBbOpsApi API = new DoubleDualQuatBbOpsApi();
    private static final DoubleDualQuatRawOpsUnsafe RAW = new DoubleDualQuatRawOpsUnsafe();

    private static final long BB_ADDRESS_OFFSET;
    static {
        try {
            BB_ADDRESS_OFFSET = U.objectFieldOffset(Buffer.class.getDeclaredField("address"));
        } catch (ReflectiveOperationException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public DoubleBuffer storeAbsolute(DoubleDualQuatImpl self, int index, DoubleBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeAbsolute(self, index, buf);
        RAW.storeUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 8);
        return buf;
    }
    public DoubleDualQuat loadAbsolute(DoubleDualQuatImpl self, int index, DoubleBuffer buf) {
        if (!buf.isDirect()) return API.loadAbsolute(self, index, buf);
        return RAW.loadUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 8);
    }
    public ByteBuffer storeAbsolute(DoubleDualQuatImpl self, int index, ByteBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeAbsolute(self, index, buf);
        RAW.storeUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
        return buf;
    }
    public DoubleDualQuat loadAbsolute(DoubleDualQuatImpl self, int index, ByteBuffer buf) {
        if (!buf.isDirect()) return API.loadAbsolute(self, index, buf);
        return RAW.loadUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
    }
    public FloatBuffer storeAbsolute(DoubleDualQuatImpl self, int index, FloatBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeAbsolute(self, index, buf);
        RAW.storeFloatUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 4);
        return buf;
    }
    public DoubleDualQuat loadAbsolute(DoubleDualQuatImpl self, int index, FloatBuffer buf) {
        if (!buf.isDirect()) return API.loadAbsolute(self, index, buf);
        return RAW.loadFloatUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 4);
    }
    public ByteBuffer storeFloatAbsolute(DoubleDualQuatImpl self, int index, ByteBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeFloatAbsolute(self, index, buf);
        RAW.storeFloatUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
        return buf;
    }
    public DoubleDualQuat loadFloatAbsolute(DoubleDualQuatImpl self, int index, ByteBuffer buf) {
        if (!buf.isDirect()) return API.loadFloatAbsolute(self, index, buf);
        return RAW.loadFloatUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
    }
}
