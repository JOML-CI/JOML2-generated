package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatSphereRawOpsApi implements FloatSphereRawOps {
    public FloatSphere storeUnsafe(FloatSphere self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
        return self;
    }
    public FloatSphere loadUnsafe(long address) {
        return FloatSphere.load(0L, VIRTUAL_MEMORY.asSlice(address, 16L));
    }
    public FloatSphere storeDoubleUnsafe(FloatSphere self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
        return self;
    }
    public FloatSphere loadDoubleUnsafe(long address) {
        return FloatSphere.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 32L));
    }
}
