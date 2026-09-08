package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import static org.joml2.internal.unsafe.UnsafeOpsHolder.U;

public final class Long4BbOpsUnsafe implements Long4BbOps {

    private static final Long4BbOpsApi API = new Long4BbOpsApi();
    private static final Long4RawOpsUnsafe RAW = new Long4RawOpsUnsafe();

    private static final long BB_ADDRESS_OFFSET;
    static {
        try {
            BB_ADDRESS_OFFSET = U.objectFieldOffset(Buffer.class.getDeclaredField("address"));
        } catch (ReflectiveOperationException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public IntBuffer storeAbsolute(Long4Impl self, int index, IntBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeAbsolute(self, index, buf);
        RAW.storeIntUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 4);
        return buf;
    }
    public Long4 loadAbsolute(Long4Impl self, int index, IntBuffer buf) {
        if (!buf.isDirect()) return API.loadAbsolute(self, index, buf);
        return RAW.loadIntUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 4);
    }
    public ByteBuffer storeIntAbsolute(Long4Impl self, int index, ByteBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeIntAbsolute(self, index, buf);
        RAW.storeIntUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
        return buf;
    }
    public Long4 loadIntAbsolute(Long4Impl self, int index, ByteBuffer buf) {
        if (!buf.isDirect()) return API.loadIntAbsolute(self, index, buf);
        return RAW.loadIntUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
    }
}
