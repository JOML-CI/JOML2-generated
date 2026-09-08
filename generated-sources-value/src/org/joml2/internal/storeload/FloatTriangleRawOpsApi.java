package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatTriangleRawOpsApi implements FloatTriangleRawOps {
    public FloatTriangle storeUnsafe(FloatTriangle self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 36L));
        return self;
    }
    public FloatTriangle loadUnsafe(long address) {
        return FloatTriangle.load(0L, VIRTUAL_MEMORY.asSlice(address, 36L));
    }
    public FloatTriangle storeDoubleUnsafe(FloatTriangle self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 72L));
        return self;
    }
    public FloatTriangle loadDoubleUnsafe(long address) {
        return FloatTriangle.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 72L));
    }
}
