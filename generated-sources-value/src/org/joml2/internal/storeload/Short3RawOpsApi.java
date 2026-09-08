package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Short3RawOpsApi implements Short3RawOps {
    public Short3 storeUnsafe(Short3 self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 6L));
        return self;
    }
    public Short3 loadUnsafe(long address) {
        return Short3.load(0L, VIRTUAL_MEMORY.asSlice(address, 6L));
    }
    public Short3 storeByteUnsafe(Short3 self, long address) {
        self.storeByte(0L, VIRTUAL_MEMORY.asSlice(address, 3L));
        return self;
    }
    public Short3 loadByteUnsafe(long address) {
        return Short3.loadByte(0L, VIRTUAL_MEMORY.asSlice(address, 3L));
    }
}
