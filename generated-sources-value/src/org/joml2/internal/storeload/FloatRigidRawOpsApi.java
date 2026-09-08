package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import static org.joml2.internal.unsafe.VirtualMemoryHolder.VIRTUAL_MEMORY;

public final class FloatRigidRawOpsApi implements FloatRigidRawOps {
    public FloatRigid storeUnsafe(FloatRigid self, long address) {
        self.store(0L, VIRTUAL_MEMORY.asSlice(address, 28L));
        return self;
    }
    public FloatRigid loadUnsafe(long address) {
        return FloatRigid.load(0L, VIRTUAL_MEMORY.asSlice(address, 28L));
    }
    public FloatRigid storeDoubleUnsafe(FloatRigid self, long address) {
        self.storeDouble(0L, VIRTUAL_MEMORY.asSlice(address, 56L));
        return self;
    }
    public FloatRigid loadDoubleUnsafe(long address) {
        return FloatRigid.loadDouble(0L, VIRTUAL_MEMORY.asSlice(address, 56L));
    }
}
