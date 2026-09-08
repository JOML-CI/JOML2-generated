package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class DoubleRectRawOpsApi implements DoubleRectRawOps {
    public DoubleRect storeUnsafe(DoubleRect self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public DoubleRect loadUnsafe(long address) {
        return DoubleRect.load(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
    }
    public DoubleRect storeFloatUnsafe(DoubleRect self, long address) {
        self.storeFloat(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public DoubleRect loadFloatUnsafe(long address) {
        return DoubleRect.loadFloat(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
    }
}
