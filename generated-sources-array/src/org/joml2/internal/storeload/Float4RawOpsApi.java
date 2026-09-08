package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Float4RawOpsApi implements Float4RawOps {
    public Float4 storeUnsafe(Float4Impl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public Float4 loadUnsafe(Float4Impl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public Float4 storeDoubleUnsafe(Float4Impl self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public Float4 loadDoubleUnsafe(Float4Impl self, long address) {
        self.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
}
