package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class FloatRayRawOpsApi implements FloatRayRawOps {
    public FloatRay storeUnsafe(FloatRay self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatRay loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatRay storeDoubleUnsafe(FloatRay self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatRay loadDoubleUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
