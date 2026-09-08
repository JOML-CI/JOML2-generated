package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class DoubleRayRawOpsApi implements DoubleRayRawOps {
    public DoubleRay storeUnsafe(DoubleRay self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 48L));
        return self;
    }
    public DoubleRay loadUnsafe(long address) {
        return DoubleRay.load(0L, VIRTUAL_MEMORY.asSlice(address, 48L));
    }
    public DoubleRay storeFloatUnsafe(DoubleRay self, long address) {
        self.storeFloat(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
        return self;
    }
    public DoubleRay loadFloatUnsafe(long address) {
        return DoubleRay.loadFloat(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
    }
}
