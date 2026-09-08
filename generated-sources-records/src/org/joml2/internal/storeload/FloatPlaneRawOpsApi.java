package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatPlaneRawOpsApi implements FloatPlaneRawOps {
    public FloatPlane storeUnsafe(FloatPlane self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public FloatPlane loadUnsafe(long address) {
        return FloatPlane.load(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
    }
    public FloatPlane storeDoubleUnsafe(FloatPlane self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public FloatPlane loadDoubleUnsafe(long address) {
        return FloatPlane.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
    }
}
