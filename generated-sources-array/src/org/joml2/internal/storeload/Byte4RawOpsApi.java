package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class Byte4RawOpsApi implements Byte4RawOps {
    public Byte4 storeUnsafe(Byte4Impl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 4L));
        return self;
    }
    public Byte4 loadUnsafe(Byte4Impl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 4L));
        return self;
    }
    public Byte4 storeShortUnsafe(Byte4Impl self, long address) {
        self.storeShort(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
        return self;
    }
    public Byte4 loadShortUnsafe(Byte4Impl self, long address) {
        self.loadShort(0L, VIRTUAL_MEMORY.asSlice(address, 8L));
        return self;
    }
}
