package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Byte3RawOpsApi implements Byte3RawOps {
    public Byte3 storeUnsafe(Byte3Impl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 3L));
        return self;
    }
    public Byte3 loadUnsafe(Byte3Impl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 3L));
        return self;
    }
    public Byte3 storeShortUnsafe(Byte3Impl self, long address) {
        self.storeShort(0L, VIRTUAL_MEMORY.asSlice(address, 6L));
        return self;
    }
    public Byte3 loadShortUnsafe(Byte3Impl self, long address) {
        self.loadShort(0L, VIRTUAL_MEMORY.asSlice(address, 6L));
        return self;
    }
}
