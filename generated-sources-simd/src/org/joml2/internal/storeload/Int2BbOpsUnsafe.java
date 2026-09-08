package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import static org.joml2.internal.unsafe.UnsafeOpsHolder.U;

public final class Int2BbOpsUnsafe implements Int2BbOps {

    private static final Int2BbOpsApi API = new Int2BbOpsApi();
    private static final Int2RawOpsUnsafe RAW = new Int2RawOpsUnsafe();

    private static final long BB_ADDRESS_OFFSET;
    static {
        try {
            BB_ADDRESS_OFFSET = U.objectFieldOffset(Buffer.class.getDeclaredField("address"));
        } catch (ReflectiveOperationException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public IntBuffer storeAbsolute(Int2Impl self, int index, IntBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeAbsolute(self, index, buf);
        RAW.storeUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 4);
        return buf;
    }
    public Int2 loadAbsolute(Int2Impl self, int index, IntBuffer buf) {
        if (!buf.isDirect()) return API.loadAbsolute(self, index, buf);
        return RAW.loadUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 4);
    }
    public ByteBuffer storeAbsolute(Int2Impl self, int index, ByteBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeAbsolute(self, index, buf);
        RAW.storeUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
        return buf;
    }
    public Int2 loadAbsolute(Int2Impl self, int index, ByteBuffer buf) {
        if (!buf.isDirect()) return API.loadAbsolute(self, index, buf);
        return RAW.loadUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
    }
    public LongBuffer storeAbsolute(Int2Impl self, int index, LongBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeAbsolute(self, index, buf);
        RAW.storeLongUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 8);
        return buf;
    }
    public Int2 loadAbsolute(Int2Impl self, int index, LongBuffer buf) {
        if (!buf.isDirect()) return API.loadAbsolute(self, index, buf);
        return RAW.loadLongUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 8);
    }
    public ByteBuffer storeLongAbsolute(Int2Impl self, int index, ByteBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeLongAbsolute(self, index, buf);
        RAW.storeLongUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
        return buf;
    }
    public Int2 loadLongAbsolute(Int2Impl self, int index, ByteBuffer buf) {
        if (!buf.isDirect()) return API.loadLongAbsolute(self, index, buf);
        return RAW.loadLongUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
    }
}
