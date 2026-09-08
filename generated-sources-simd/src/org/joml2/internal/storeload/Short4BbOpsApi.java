package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.ByteBuffer;

public final class Short4BbOpsApi implements Short4BbOps {
    public ByteBuffer storeByteAbsolute(Short4Impl self, int index, ByteBuffer buf) {
        buf.put(index + 0, (byte) self.data[0]);
        buf.put(index + 1, (byte) self.data[1]);
        buf.put(index + 2, (byte) self.data[2]);
        buf.put(index + 3, (byte) self.data[3]);
        return buf;
    }
    public Short4 loadByteAbsolute(Short4Impl self, int index, ByteBuffer buf) {
        self.data[0] = buf.get(index + 0);
        self.data[1] = buf.get(index + 1);
        self.data[2] = buf.get(index + 2);
        self.data[3] = buf.get(index + 3);
        return self;
    }
}
