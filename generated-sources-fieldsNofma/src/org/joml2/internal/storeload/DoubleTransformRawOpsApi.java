package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class DoubleTransformRawOpsApi implements DoubleTransformRawOps {
    public DoubleTransform storeUnsafe(DoubleTransformImpl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 80L));
        return self;
    }
    public DoubleTransform loadUnsafe(DoubleTransformImpl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 80L));
        return self;
    }
    public DoubleTransform storeFloatUnsafe(DoubleTransformImpl self, long address) {
        self.storeFloat(0L, VIRTUAL_MEMORY.asSlice(address, 40L));
        return self;
    }
    public DoubleTransform loadFloatUnsafe(DoubleTransformImpl self, long address) {
        self.loadFloat(0L, VIRTUAL_MEMORY.asSlice(address, 40L));
        return self;
    }
}
