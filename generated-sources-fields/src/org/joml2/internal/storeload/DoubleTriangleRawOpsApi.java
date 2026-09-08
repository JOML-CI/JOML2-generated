package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class DoubleTriangleRawOpsApi implements DoubleTriangleRawOps {
    public DoubleTriangle storeUnsafe(DoubleTriangleImpl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 72L));
        return self;
    }
    public DoubleTriangle loadUnsafe(DoubleTriangleImpl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 72L));
        return self;
    }
    public DoubleTriangle storeFloatUnsafe(DoubleTriangleImpl self, long address) {
        self.storeFloat(0L, VIRTUAL_MEMORY.asSlice(address, 36L));
        return self;
    }
    public DoubleTriangle loadFloatUnsafe(DoubleTriangleImpl self, long address) {
        self.loadFloat(0L, VIRTUAL_MEMORY.asSlice(address, 36L));
        return self;
    }
}
