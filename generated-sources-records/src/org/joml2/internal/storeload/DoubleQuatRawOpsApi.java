package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class DoubleQuatRawOpsApi implements DoubleQuatRawOps {
    public DoubleQuat storeUnsafe(DoubleQuat self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public DoubleQuat loadUnsafe(long address) {
        return DoubleQuat.load(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
    }
    public DoubleQuat storeFloatUnsafe(DoubleQuat self, long address) {
        self.storeFloat(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public DoubleQuat loadFloatUnsafe(long address) {
        return DoubleQuat.loadFloat(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
    }
}
