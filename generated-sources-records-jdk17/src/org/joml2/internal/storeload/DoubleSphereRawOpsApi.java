package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class DoubleSphereRawOpsApi implements DoubleSphereRawOps {
    public DoubleSphere storeUnsafe(DoubleSphere self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleSphere loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleSphere storeFloatUnsafe(DoubleSphere self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleSphere loadFloatUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
