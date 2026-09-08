package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class DoubleDualQuatRawOpsApi implements DoubleDualQuatRawOps {
    public DoubleDualQuat storeUnsafe(DoubleDualQuatImpl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 64L));
        return self;
    }
    public DoubleDualQuat loadUnsafe(DoubleDualQuatImpl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 64L));
        return self;
    }
    public DoubleDualQuat storeFloatUnsafe(DoubleDualQuatImpl self, long address) {
        self.storeFloat(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public DoubleDualQuat loadFloatUnsafe(DoubleDualQuatImpl self, long address) {
        self.loadFloat(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
}
