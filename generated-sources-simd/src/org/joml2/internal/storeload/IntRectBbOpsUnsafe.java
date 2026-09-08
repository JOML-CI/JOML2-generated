package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import static org.joml2.internal.unsafe.UnsafeOpsHolder.U;

public final class IntRectBbOpsUnsafe implements IntRectBbOps {

    private static final IntRectBbOpsApi API = new IntRectBbOpsApi();
    private static final IntRectRawOpsUnsafe RAW = new IntRectRawOpsUnsafe();

    private static final long BB_ADDRESS_OFFSET;
    static {
        try {
            BB_ADDRESS_OFFSET = U.objectFieldOffset(Buffer.class.getDeclaredField("address"));
        } catch (ReflectiveOperationException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public LongBuffer storeAbsolute(IntRectImpl self, int index, LongBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeAbsolute(self, index, buf);
        RAW.storeLongUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 8);
        return buf;
    }
    public IntRect loadAbsolute(IntRectImpl self, int index, LongBuffer buf) {
        if (!buf.isDirect()) return API.loadAbsolute(self, index, buf);
        return RAW.loadLongUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 8);
    }
    public ByteBuffer storeLongAbsolute(IntRectImpl self, int index, ByteBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeLongAbsolute(self, index, buf);
        RAW.storeLongUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
        return buf;
    }
    public IntRect loadLongAbsolute(IntRectImpl self, int index, ByteBuffer buf) {
        if (!buf.isDirect()) return API.loadLongAbsolute(self, index, buf);
        return RAW.loadLongUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
    }
}
