package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Int2RawOpsApi implements Int2RawOps {
    public Int2 storeUnsafe(Int2Impl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
        return self;
    }
    public Int2 loadUnsafe(Int2Impl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
        return self;
    }
    public Int2 storeLongUnsafe(Int2Impl self, long address) {
        self.storeLong(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public Int2 loadLongUnsafe(Int2Impl self, long address) {
        self.loadLong(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
}
