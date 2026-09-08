package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class FloatTransformRawOpsApi implements FloatTransformRawOps {
    public FloatTransform storeUnsafe(FloatTransform self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatTransform loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatTransform storeDoubleUnsafe(FloatTransform self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatTransform loadDoubleUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
