package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class IntRectRawOpsApi implements IntRectRawOps {
    public IntRect storeUnsafe(IntRectImpl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public IntRect loadUnsafe(IntRectImpl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public IntRect storeLongUnsafe(IntRectImpl self, long address) {
        self.storeLong(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public IntRect loadLongUnsafe(IntRectImpl self, long address) {
        self.loadLong(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
}
