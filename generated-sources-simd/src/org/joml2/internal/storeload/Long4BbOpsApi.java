package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class Long4BbOpsApi implements Long4BbOps {
    public IntBuffer storeAbsolute(Long4Impl self, int index, IntBuffer buf) {
        buf.put(index + 0, (int) self.data[0]);
        buf.put(index + 1, (int) self.data[1]);
        buf.put(index + 2, (int) self.data[2]);
        buf.put(index + 3, (int) self.data[3]);
        return buf;
    }
    public Long4 loadAbsolute(Long4Impl self, int index, IntBuffer buf) {
        self.data[0] = buf.get(index + 0);
        self.data[1] = buf.get(index + 1);
        self.data[2] = buf.get(index + 2);
        self.data[3] = buf.get(index + 3);
        return self;
    }
    public ByteBuffer storeIntAbsolute(Long4Impl self, int index, ByteBuffer buf) {
        buf.putInt(index + 0, (int) self.data[0]);
        buf.putInt(index + 4, (int) self.data[1]);
        buf.putInt(index + 8, (int) self.data[2]);
        buf.putInt(index + 12, (int) self.data[3]);
        return buf;
    }
    public Long4 loadIntAbsolute(Long4Impl self, int index, ByteBuffer buf) {
        self.data[0] = buf.getInt(index + 0);
        self.data[1] = buf.getInt(index + 4);
        self.data[2] = buf.getInt(index + 8);
        self.data[3] = buf.getInt(index + 12);
        return self;
    }
}
