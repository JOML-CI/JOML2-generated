package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class DoubleRigidRawOpsApi implements DoubleRigidRawOps {
    public DoubleRigid storeUnsafe(DoubleRigid self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 56L));
        return self;
    }
    public DoubleRigid loadUnsafe(long address) {
        return DoubleRigid.load(0L, VIRTUAL_MEMORY.asSlice(address, 56L));
    }
    public DoubleRigid storeFloatUnsafe(DoubleRigid self, long address) {
        self.storeFloat(0L, VIRTUAL_MEMORY.asSlice(address, 28L));
        return self;
    }
    public DoubleRigid loadFloatUnsafe(long address) {
        return DoubleRigid.loadFloat(0L, VIRTUAL_MEMORY.asSlice(address, 28L));
    }
}
