package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Short4RawOpsApi implements Short4RawOps {
    public Short4 storeUnsafe(Short4 self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
        return self;
    }
    public Short4 loadUnsafe(long address) {
        return Short4.load(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
    }
    public Short4 storeByteUnsafe(Short4 self, long address) {
        self.storeByte(0L, VIRTUAL_MEMORY.asSlice(address, 4L));
        return self;
    }
    public Short4 loadByteUnsafe(long address) {
        return Short4.loadByte(0L, VIRTUAL_MEMORY.asSlice(address, 4L));
    }
}
