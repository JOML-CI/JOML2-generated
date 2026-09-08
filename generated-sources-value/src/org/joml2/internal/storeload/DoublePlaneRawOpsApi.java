package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class DoublePlaneRawOpsApi implements DoublePlaneRawOps {
    public DoublePlane storeUnsafe(DoublePlane self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public DoublePlane loadUnsafe(long address) {
        return DoublePlane.load(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
    }
    public DoublePlane storeFloatUnsafe(DoublePlane self, long address) {
        self.storeFloat(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public DoublePlane loadFloatUnsafe(long address) {
        return DoublePlane.loadFloat(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
    }
}
