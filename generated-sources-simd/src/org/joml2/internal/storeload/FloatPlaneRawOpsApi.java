package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatPlaneRawOpsApi implements FloatPlaneRawOps {
    public FloatPlane storeUnsafe(FloatPlaneImpl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public FloatPlane loadUnsafe(FloatPlaneImpl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public FloatPlane storeDoubleUnsafe(FloatPlaneImpl self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public FloatPlane loadDoubleUnsafe(FloatPlaneImpl self, long address) {
        self.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
}
