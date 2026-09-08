package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class DoubleRectRawOpsApi implements DoubleRectRawOps {
    public DoubleRect storeUnsafe(DoubleRectImpl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public DoubleRect loadUnsafe(DoubleRectImpl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public DoubleRect storeFloatUnsafe(DoubleRectImpl self, long address) {
        self.storeFloat(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public DoubleRect loadFloatUnsafe(DoubleRectImpl self, long address) {
        self.loadFloat(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
}
