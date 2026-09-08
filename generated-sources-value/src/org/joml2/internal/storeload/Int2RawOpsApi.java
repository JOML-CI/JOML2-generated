package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Int2RawOpsApi implements Int2RawOps {
    public Int2 storeUnsafe(Int2 self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
        return self;
    }
    public Int2 loadUnsafe(long address) {
        return Int2.load(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
    }
    public Int2 storeLongUnsafe(Int2 self, long address) {
        self.storeLong(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public Int2 loadLongUnsafe(long address) {
        return Int2.loadLong(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
    }
}
