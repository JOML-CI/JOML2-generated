package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Double4RawOpsApi implements Double4RawOps {
    public Double4 storeUnsafe(Double4Impl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public Double4 loadUnsafe(Double4Impl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public Double4 storeFloatUnsafe(Double4Impl self, long address) {
        self.storeFloat(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public Double4 loadFloatUnsafe(Double4Impl self, long address) {
        self.loadFloat(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
}
