package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class DoubleOBBRawOpsApi implements DoubleOBBRawOps {
    public DoubleOBB storeUnsafe(DoubleOBB self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 120L));
        return self;
    }
    public DoubleOBB loadUnsafe(long address) {
        return DoubleOBB.load(0L, VIRTUAL_MEMORY.asSlice(address, 120L));
    }
    public DoubleOBB storeFloatUnsafe(DoubleOBB self, long address) {
        self.storeFloat(0L, VIRTUAL_MEMORY.asSlice(address, 60L));
        return self;
    }
    public DoubleOBB loadFloatUnsafe(long address) {
        return DoubleOBB.loadFloat(0L, VIRTUAL_MEMORY.asSlice(address, 60L));
    }
}
