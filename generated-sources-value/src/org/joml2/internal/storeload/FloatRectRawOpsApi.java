package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatRectRawOpsApi implements FloatRectRawOps {
    public FloatRect storeUnsafe(FloatRect self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public FloatRect loadUnsafe(long address) {
        return FloatRect.load(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
    }
    public FloatRect storeDoubleUnsafe(FloatRect self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public FloatRect loadDoubleUnsafe(long address) {
        return FloatRect.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
    }
}
