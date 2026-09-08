package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import static org.joml2.internal.unsafe.UnsafeOpsHolder.U;

public final class Byte4BbOpsUnsafe implements Byte4BbOps {

    private static final Byte4BbOpsApi API = new Byte4BbOpsApi();
    private static final Byte4RawOpsUnsafe RAW = new Byte4RawOpsUnsafe();

    private static final long BB_ADDRESS_OFFSET;
    static {
        try {
            BB_ADDRESS_OFFSET = U.objectFieldOffset(Buffer.class.getDeclaredField("address"));
        } catch (ReflectiveOperationException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public ByteBuffer storeAbsolute(Byte4Impl self, int index, ByteBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeAbsolute(self, index, buf);
        RAW.storeUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
        return buf;
    }
    public Byte4 loadAbsolute(Byte4Impl self, int index, ByteBuffer buf) {
        if (!buf.isDirect()) return API.loadAbsolute(self, index, buf);
        return RAW.loadUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
    }
    public ShortBuffer storeAbsolute(Byte4Impl self, int index, ShortBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeAbsolute(self, index, buf);
        RAW.storeShortUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 2);
        return buf;
    }
    public Byte4 loadAbsolute(Byte4Impl self, int index, ShortBuffer buf) {
        if (!buf.isDirect()) return API.loadAbsolute(self, index, buf);
        return RAW.loadShortUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 2);
    }
    public ByteBuffer storeShortAbsolute(Byte4Impl self, int index, ByteBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeShortAbsolute(self, index, buf);
        RAW.storeShortUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
        return buf;
    }
    public Byte4 loadShortAbsolute(Byte4Impl self, int index, ByteBuffer buf) {
        if (!buf.isDirect()) return API.loadShortAbsolute(self, index, buf);
        return RAW.loadShortUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
    }
}
