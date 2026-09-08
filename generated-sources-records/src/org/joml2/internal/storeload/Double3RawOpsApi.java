package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Double3RawOpsApi implements Double3RawOps {
    public Double3 storeUnsafe(Double3 self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
        return self;
    }
    public Double3 loadUnsafe(long address) {
        return Double3.load(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
    }
    public Double3 storeFloatUnsafe(Double3 self, long address) {
        self.storeFloat(0L, VIRTUAL_MEMORY.asSlice(address, 12L));
        return self;
    }
    public Double3 loadFloatUnsafe(long address) {
        return Double3.loadFloat(0L, VIRTUAL_MEMORY.asSlice(address, 12L));
    }
}
