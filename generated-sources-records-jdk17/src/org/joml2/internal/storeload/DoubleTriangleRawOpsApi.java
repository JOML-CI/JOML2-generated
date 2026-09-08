package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class DoubleTriangleRawOpsApi implements DoubleTriangleRawOps {
    public DoubleTriangle storeUnsafe(DoubleTriangle self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleTriangle loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleTriangle storeFloatUnsafe(DoubleTriangle self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleTriangle loadFloatUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
