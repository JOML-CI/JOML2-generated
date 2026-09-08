package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import static org.joml2.internal.unsafe.UnsafeOpsHolder.U;

public final class DoubleSphereBbOpsUnsafe implements DoubleSphereBbOps {

    private static final DoubleSphereBbOpsApi API = new DoubleSphereBbOpsApi();
    private static final DoubleSphereRawOpsUnsafe RAW = new DoubleSphereRawOpsUnsafe();

    private static final long BB_ADDRESS_OFFSET;
    static {
        try {
            BB_ADDRESS_OFFSET = U.objectFieldOffset(Buffer.class.getDeclaredField("address"));
        } catch (ReflectiveOperationException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public FloatBuffer storeAbsolute(DoubleSphereImpl self, int index, FloatBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeAbsolute(self, index, buf);
        RAW.storeFloatUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 4);
        return buf;
    }
    public DoubleSphere loadAbsolute(DoubleSphereImpl self, int index, FloatBuffer buf) {
        if (!buf.isDirect()) return API.loadAbsolute(self, index, buf);
        return RAW.loadFloatUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + (long) index * 4);
    }
    public ByteBuffer storeFloatAbsolute(DoubleSphereImpl self, int index, ByteBuffer buf) {
        if (!buf.isDirect() || buf.isReadOnly()) return API.storeFloatAbsolute(self, index, buf);
        RAW.storeFloatUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
        return buf;
    }
    public DoubleSphere loadFloatAbsolute(DoubleSphereImpl self, int index, ByteBuffer buf) {
        if (!buf.isDirect()) return API.loadFloatAbsolute(self, index, buf);
        return RAW.loadFloatUnsafe(self, U.getLong(buf, BB_ADDRESS_OFFSET) + index);
    }
}
