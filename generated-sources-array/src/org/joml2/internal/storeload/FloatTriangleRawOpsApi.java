package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatTriangleRawOpsApi implements FloatTriangleRawOps {
    public FloatTriangle storeUnsafe(FloatTriangleImpl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 36L));
        return self;
    }
    public FloatTriangle loadUnsafe(FloatTriangleImpl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 36L));
        return self;
    }
    public FloatTriangle storeDoubleUnsafe(FloatTriangleImpl self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 72L));
        return self;
    }
    public FloatTriangle loadDoubleUnsafe(FloatTriangleImpl self, long address) {
        self.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 72L));
        return self;
    }
}
