package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Int4RawOpsApi implements Int4RawOps {
    public Int4 storeUnsafe(Int4 self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public Int4 loadUnsafe(long address) {
        return Int4.load(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
    }
    public Int4 storeLongUnsafe(Int4 self, long address) {
        self.storeLong(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public Int4 loadLongUnsafe(long address) {
        return Int4.loadLong(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
    }
}
