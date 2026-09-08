package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatRayRawOpsApi implements FloatRayRawOps {
    public FloatRay storeUnsafe(FloatRayImpl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
        return self;
    }
    public FloatRay loadUnsafe(FloatRayImpl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
        return self;
    }
    public FloatRay storeDoubleUnsafe(FloatRayImpl self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 48L));
        return self;
    }
    public FloatRay loadDoubleUnsafe(FloatRayImpl self, long address) {
        self.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 48L));
        return self;
    }
}
