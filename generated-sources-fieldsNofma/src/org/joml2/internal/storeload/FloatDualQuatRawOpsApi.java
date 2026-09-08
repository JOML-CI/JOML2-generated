package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatDualQuatRawOpsApi implements FloatDualQuatRawOps {
    public FloatDualQuat storeUnsafe(FloatDualQuatImpl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public FloatDualQuat loadUnsafe(FloatDualQuatImpl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public FloatDualQuat storeDoubleUnsafe(FloatDualQuatImpl self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 64L));
        return self;
    }
    public FloatDualQuat loadDoubleUnsafe(FloatDualQuatImpl self, long address) {
        self.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 64L));
        return self;
    }
}
