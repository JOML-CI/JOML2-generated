package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatTransformRawOpsApi implements FloatTransformRawOps {
    public FloatTransform storeUnsafe(FloatTransform self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 40L));
        return self;
    }
    public FloatTransform loadUnsafe(long address) {
        return FloatTransform.load(0L, VIRTUAL_MEMORY.asSlice(address, 40L));
    }
    public FloatTransform storeDoubleUnsafe(FloatTransform self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 80L));
        return self;
    }
    public FloatTransform loadDoubleUnsafe(long address) {
        return FloatTransform.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 80L));
    }
}
