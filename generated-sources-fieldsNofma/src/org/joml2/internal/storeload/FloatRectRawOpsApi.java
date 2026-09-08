package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatRectRawOpsApi implements FloatRectRawOps {
    public FloatRect storeUnsafe(FloatRectImpl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public FloatRect loadUnsafe(FloatRectImpl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public FloatRect storeDoubleUnsafe(FloatRectImpl self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public FloatRect loadDoubleUnsafe(FloatRectImpl self, long address) {
        self.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
}
