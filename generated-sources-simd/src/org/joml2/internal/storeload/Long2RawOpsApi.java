package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Long2RawOpsApi implements Long2RawOps {
    public Long2 storeUnsafe(Long2Impl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public Long2 loadUnsafe(Long2Impl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public Long2 storeIntUnsafe(Long2Impl self, long address) {
        self.storeInt(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
        return self;
    }
    public Long2 loadIntUnsafe(Long2Impl self, long address) {
        self.loadInt(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
        return self;
    }
}
