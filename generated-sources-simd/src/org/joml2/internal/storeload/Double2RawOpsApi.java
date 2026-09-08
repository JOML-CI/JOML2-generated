package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Double2RawOpsApi implements Double2RawOps {
    public Double2 storeUnsafe(Double2Impl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public Double2 loadUnsafe(Double2Impl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public Double2 storeFloatUnsafe(Double2Impl self, long address) {
        self.storeFloat(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
        return self;
    }
    public Double2 loadFloatUnsafe(Double2Impl self, long address) {
        self.loadFloat(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
        return self;
    }
}
