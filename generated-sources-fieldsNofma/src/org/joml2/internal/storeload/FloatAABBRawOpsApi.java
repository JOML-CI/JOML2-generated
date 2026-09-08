package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatAABBRawOpsApi implements FloatAABBRawOps {
    public FloatAABB storeUnsafe(FloatAABBImpl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
        return self;
    }
    public FloatAABB loadUnsafe(FloatAABBImpl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
        return self;
    }
    public FloatAABB storeDoubleUnsafe(FloatAABBImpl self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 48L));
        return self;
    }
    public FloatAABB loadDoubleUnsafe(FloatAABBImpl self, long address) {
        self.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 48L));
        return self;
    }
}
