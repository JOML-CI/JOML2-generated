package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatSphereRawOpsApi implements FloatSphereRawOps {
    public FloatSphere storeUnsafe(FloatSphereImpl self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public FloatSphere loadUnsafe(FloatSphereImpl self, long address) {
        self.load(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public FloatSphere storeDoubleUnsafe(FloatSphereImpl self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public FloatSphere loadDoubleUnsafe(FloatSphereImpl self, long address) {
        self.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
}
