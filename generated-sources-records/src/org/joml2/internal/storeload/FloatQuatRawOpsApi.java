package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatQuatRawOpsApi implements FloatQuatRawOps {
    public FloatQuat storeUnsafe(FloatQuat self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public FloatQuat loadUnsafe(long address) {
        return FloatQuat.load(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
    }
    public FloatQuat storeDoubleUnsafe(FloatQuat self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public FloatQuat loadDoubleUnsafe(long address) {
        return FloatQuat.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
    }
}
