package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Int3RawOpsApi implements Int3RawOps {
    public Int3 storeUnsafe(Int3 self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 12L));
        return self;
    }
    public Int3 loadUnsafe(long address) {
        return Int3.load(0L, VIRTUAL_MEMORY.asSlice(address, 12L));
    }
    public Int3 storeLongUnsafe(Int3 self, long address) {
        self.storeLong(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
        return self;
    }
    public Int3 loadLongUnsafe(long address) {
        return Int3.loadLong(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
    }
}
