package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Int3RawOpsApi implements Int3RawOps {
    public Int3 storeUnsafe(Int3Impl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 12L));
        return self;
    }
    public Int3 loadUnsafe(Int3Impl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 12L));
        return self;
    }
    public Int3 storeLongUnsafe(Int3Impl self, long address) {
        self.storeLong(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
        return self;
    }
    public Int3 loadLongUnsafe(Int3Impl self, long address) {
        self.loadLong(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
        return self;
    }
}
