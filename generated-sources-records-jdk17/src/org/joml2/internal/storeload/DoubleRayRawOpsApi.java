package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class DoubleRayRawOpsApi implements DoubleRayRawOps {
    public DoubleRay storeUnsafe(DoubleRay self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleRay loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleRay storeFloatUnsafe(DoubleRay self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleRay loadFloatUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
