package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatRayRawOpsApi implements FloatRayRawOps {
    public FloatRay storeUnsafe(FloatRay self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
        return self;
    }
    public FloatRay loadUnsafe(long address) {
        return FloatRay.load(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
    }
    public FloatRay storeDoubleUnsafe(FloatRay self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 48L));
        return self;
    }
    public FloatRay loadDoubleUnsafe(long address) {
        return FloatRay.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 48L));
    }
}
