package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class DoubleTransformRawOpsApi implements DoubleTransformRawOps {
    public DoubleTransform storeUnsafe(DoubleTransform self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleTransform loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleTransform storeFloatUnsafe(DoubleTransform self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleTransform loadFloatUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
