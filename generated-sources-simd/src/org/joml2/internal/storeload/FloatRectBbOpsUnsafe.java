package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import static org.joml2.internal.unsafe.UnsafeOpsHolder.U;

public final class FloatRectBbOpsUnsafe implements FloatRectBbOps {

    private static final FloatRectBbOpsApi API = new FloatRectBbOpsApi();
    private static final FloatRectRawOpsUnsafe RAW = new FloatRectRawOpsUnsafe();

    private static final long BB_ADDRESS_OFFSET;
    static {
        try {
            BB_ADDRESS_OFFSET = U.objectFieldOffset(Buffer.class.getDeclaredField("address"));
        } catch (ReflectiveOperationException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public DoubleBuffer storeAbsolute(FloatRectImpl self, int index, DoubleBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeAbsolute(self, index, buf);
        RAW.storeDoubleUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 8);
        return buf;
    }
    public FloatRect loadAbsolute(FloatRectImpl self, int index, DoubleBuffer buf) {
        if (!buf.isDirect()) return API.loadAbsolute(self, index, buf);
        return RAW.loadDoubleUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 8);
    }
    public ByteBuffer storeDoubleAbsolute(FloatRectImpl self, int index, ByteBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeDoubleAbsolute(self, index, buf);
        RAW.storeDoubleUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
        return buf;
    }
    public FloatRect loadDoubleAbsolute(FloatRectImpl self, int index, ByteBuffer buf) {
        if (!buf.isDirect()) return API.loadDoubleAbsolute(self, index, buf);
        return RAW.loadDoubleUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
    }
}
