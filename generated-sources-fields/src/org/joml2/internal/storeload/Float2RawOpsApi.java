package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Float2RawOpsApi implements Float2RawOps {
    public Float2 storeUnsafe(Float2Impl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
        return self;
    }
    public Float2 loadUnsafe(Float2Impl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
        return self;
    }
    public Float2 storeDoubleUnsafe(Float2Impl self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public Float2 loadDoubleUnsafe(Float2Impl self, long address) {
        self.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
}
