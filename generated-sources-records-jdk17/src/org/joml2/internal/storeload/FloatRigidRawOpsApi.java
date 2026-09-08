package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class FloatRigidRawOpsApi implements FloatRigidRawOps {
    public FloatRigid storeUnsafe(FloatRigid self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatRigid loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatRigid storeDoubleUnsafe(FloatRigid self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatRigid loadDoubleUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
