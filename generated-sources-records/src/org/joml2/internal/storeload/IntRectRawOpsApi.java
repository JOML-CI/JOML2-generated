package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class IntRectRawOpsApi implements IntRectRawOps {
    public IntRect storeUnsafe(IntRect self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public IntRect loadUnsafe(long address) {
        return IntRect.load(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
    }
    public IntRect storeLongUnsafe(IntRect self, long address) {
        self.storeLong(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public IntRect loadLongUnsafe(long address) {
        return IntRect.loadLong(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
    }
}
