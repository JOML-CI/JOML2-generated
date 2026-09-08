package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Long3RawOpsApi implements Long3RawOps {
    public Long3 storeUnsafe(Long3 self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
        return self;
    }
    public Long3 loadUnsafe(long address) {
        return Long3.load(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
    }
    public Long3 storeIntUnsafe(Long3 self, long address) {
        self.storeInt(0L, VIRTUAL_MEMORY.asSlice(address, 12L));
        return self;
    }
    public Long3 loadIntUnsafe(long address) {
        return Long3.loadInt(0L, VIRTUAL_MEMORY.asSlice(address, 12L));
    }
}
