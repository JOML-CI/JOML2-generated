package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import static org.joml2.internal.unsafe.UnsafeOpsHolder.U;

public final class Short4BbOpsUnsafe implements Short4BbOps {

    private static final Short4BbOpsApi API = new Short4BbOpsApi();
    private static final Short4RawOpsUnsafe RAW = new Short4RawOpsUnsafe();

    private static final long BB_ADDRESS_OFFSET;
    static {
        try {
            BB_ADDRESS_OFFSET = U.objectFieldOffset(Buffer.class.getDeclaredField("address"));
        } catch (ReflectiveOperationException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public ByteBuffer storeByteAbsolute(Short4Impl self, int index, ByteBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeByteAbsolute(self, index, buf);
        RAW.storeByteUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
        return buf;
    }
    public Short4 loadByteAbsolute(Short4Impl self, int index, ByteBuffer buf) {
        if (!buf.isDirect()) return API.loadByteAbsolute(self, index, buf);
        return RAW.loadByteUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
    }
}
