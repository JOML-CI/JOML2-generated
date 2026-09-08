package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class DoubleTriangleRawOpsApi implements DoubleTriangleRawOps {
    public DoubleTriangle storeUnsafe(DoubleTriangle self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 72L));
        return self;
    }
    public DoubleTriangle loadUnsafe(long address) {
        return DoubleTriangle.load(0L, VIRTUAL_MEMORY.asSlice(address, 72L));
    }
    public DoubleTriangle storeFloatUnsafe(DoubleTriangle self, long address) {
        self.storeFloat(0L, VIRTUAL_MEMORY.asSlice(address, 36L));
        return self;
    }
    public DoubleTriangle loadFloatUnsafe(long address) {
        return DoubleTriangle.loadFloat(0L, VIRTUAL_MEMORY.asSlice(address, 36L));
    }
}
