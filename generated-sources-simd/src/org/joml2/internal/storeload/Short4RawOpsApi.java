package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Short4RawOpsApi implements Short4RawOps {
    public Short4 storeUnsafe(Short4Impl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
        return self;
    }
    public Short4 loadUnsafe(Short4Impl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
        return self;
    }
    public Short4 storeByteUnsafe(Short4Impl self, long address) {
        self.storeByte(0L, VIRTUAL_MEMORY.asSlice(address, 4L));
        return self;
    }
    public Short4 loadByteUnsafe(Short4Impl self, long address) {
        self.loadByte(0L, VIRTUAL_MEMORY.asSlice(address, 4L));
        return self;
    }
}
