package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Long3RawOpsApi implements Long3RawOps {
    public Long3 storeUnsafe(Long3Impl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
        return self;
    }
    public Long3 loadUnsafe(Long3Impl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
        return self;
    }
    public Long3 storeIntUnsafe(Long3Impl self, long address) {
        self.storeInt(0L, VIRTUAL_MEMORY.asSlice(address, 12L));
        return self;
    }
    public Long3 loadIntUnsafe(Long3Impl self, long address) {
        self.loadInt(0L, VIRTUAL_MEMORY.asSlice(address, 12L));
        return self;
    }
}
