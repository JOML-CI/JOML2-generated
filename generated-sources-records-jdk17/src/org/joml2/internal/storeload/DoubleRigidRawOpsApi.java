package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class DoubleRigidRawOpsApi implements DoubleRigidRawOps {
    public DoubleRigid storeUnsafe(DoubleRigid self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleRigid loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleRigid storeFloatUnsafe(DoubleRigid self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleRigid loadFloatUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
