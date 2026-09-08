package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Double2RawOpsApi implements Double2RawOps {
    public Double2 storeUnsafe(Double2 self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public Double2 loadUnsafe(long address) {
        return Double2.load(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
    }
    public Double2 storeFloatUnsafe(Double2 self, long address) {
        self.storeFloat(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
        return self;
    }
    public Double2 loadFloatUnsafe(long address) {
        return Double2.loadFloat(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
    }
}
