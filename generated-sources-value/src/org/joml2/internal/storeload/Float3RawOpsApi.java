package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Float3RawOpsApi implements Float3RawOps {
    public Float3 storeUnsafe(Float3 self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 12L));
        return self;
    }
    public Float3 loadUnsafe(long address) {
        return Float3.load(0L, VIRTUAL_MEMORY.asSlice(address, 12L));
    }
    public Float3 storeDoubleUnsafe(Float3 self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
        return self;
    }
    public Float3 loadDoubleUnsafe(long address) {
        return Float3.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
    }
}
