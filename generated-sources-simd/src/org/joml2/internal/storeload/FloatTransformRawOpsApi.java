package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatTransformRawOpsApi implements FloatTransformRawOps {
    public FloatTransform storeUnsafe(FloatTransformImpl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 40L));
        return self;
    }
    public FloatTransform loadUnsafe(FloatTransformImpl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 40L));
        return self;
    }
    public FloatTransform storeDoubleUnsafe(FloatTransformImpl self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 80L));
        return self;
    }
    public FloatTransform loadDoubleUnsafe(FloatTransformImpl self, long address) {
        self.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 80L));
        return self;
    }
}
