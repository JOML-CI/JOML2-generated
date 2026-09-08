package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Short3RawOpsApi implements Short3RawOps {
    public Short3 storeUnsafe(Short3Impl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 6L));
        return self;
    }
    public Short3 loadUnsafe(Short3Impl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 6L));
        return self;
    }
    public Short3 storeByteUnsafe(Short3Impl self, long address) {
        self.storeByte(0L, VIRTUAL_MEMORY.asSlice(address, 3L));
        return self;
    }
    public Short3 loadByteUnsafe(Short3Impl self, long address) {
        self.loadByte(0L, VIRTUAL_MEMORY.asSlice(address, 3L));
        return self;
    }
}
