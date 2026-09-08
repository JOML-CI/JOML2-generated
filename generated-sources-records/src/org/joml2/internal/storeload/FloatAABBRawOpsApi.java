package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatAABBRawOpsApi implements FloatAABBRawOps {
    public FloatAABB storeUnsafe(FloatAABB self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
        return self;
    }
    public FloatAABB loadUnsafe(long address) {
        return FloatAABB.load(0L, VIRTUAL_MEMORY.asSlice(address, 24L));
    }
    public FloatAABB storeDoubleUnsafe(FloatAABB self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 48L));
        return self;
    }
    public FloatAABB loadDoubleUnsafe(long address) {
        return FloatAABB.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 48L));
    }
}
