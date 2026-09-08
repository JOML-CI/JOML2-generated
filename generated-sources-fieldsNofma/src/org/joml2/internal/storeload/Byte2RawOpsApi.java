package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Byte2RawOpsApi implements Byte2RawOps {
    public Byte2 storeUnsafe(Byte2Impl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 2L));
        return self;
    }
    public Byte2 loadUnsafe(Byte2Impl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 2L));
        return self;
    }
    public Byte2 storeShortUnsafe(Byte2Impl self, long address) {
        self.storeShort(0L, VIRTUAL_MEMORY.asSlice(address, 4L));
        return self;
    }
    public Byte2 loadShortUnsafe(Byte2Impl self, long address) {
        self.loadShort(0L, VIRTUAL_MEMORY.asSlice(address, 4L));
        return self;
    }
}
