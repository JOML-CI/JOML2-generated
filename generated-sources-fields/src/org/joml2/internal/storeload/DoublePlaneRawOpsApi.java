package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class DoublePlaneRawOpsApi implements DoublePlaneRawOps {
    public DoublePlane storeUnsafe(DoublePlaneImpl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public DoublePlane loadUnsafe(DoublePlaneImpl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public DoublePlane storeFloatUnsafe(DoublePlaneImpl self, long address) {
        self.storeFloat(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public DoublePlane loadFloatUnsafe(DoublePlaneImpl self, long address) {
        self.loadFloat(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
}
