package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import static org.joml2.internal.unsafe.UnsafeOpsHolder.U;

public final class Float4BbOpsUnsafe implements Float4BbOps {

    private static final Float4BbOpsApi API = new Float4BbOpsApi();
    private static final Float4RawOpsUnsafe RAW = new Float4RawOpsUnsafe();

    private static final long BB_ADDRESS_OFFSET;
    static {
        try {
            BB_ADDRESS_OFFSET = U.objectFieldOffset(Buffer.class.getDeclaredField("address"));
        } catch (ReflectiveOperationException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public DoubleBuffer storeAbsolute(Float4Impl self, int index, DoubleBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeAbsolute(self, index, buf);
        RAW.storeDoubleUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 8);
        return buf;
    }
    public Float4 loadAbsolute(Float4Impl self, int index, DoubleBuffer buf) {
        if (!buf.isDirect()) return API.loadAbsolute(self, index, buf);
        return RAW.loadDoubleUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 8);
    }
    public ByteBuffer storeDoubleAbsolute(Float4Impl self, int index, ByteBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeDoubleAbsolute(self, index, buf);
        RAW.storeDoubleUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
        return buf;
    }
    public Float4 loadDoubleAbsolute(Float4Impl self, int index, ByteBuffer buf) {
        if (!buf.isDirect()) return API.loadDoubleAbsolute(self, index, buf);
        return RAW.loadDoubleUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
    }
}
