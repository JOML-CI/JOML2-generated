package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class FloatTriangleRawOpsApi implements FloatTriangleRawOps {
    public FloatTriangle storeUnsafe(FloatTriangle self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatTriangle loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatTriangle storeDoubleUnsafe(FloatTriangle self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatTriangle loadDoubleUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
