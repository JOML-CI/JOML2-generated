package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class DoubleAABBRawOpsApi implements DoubleAABBRawOps {
    public DoubleAABB storeUnsafe(DoubleAABB self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleAABB loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleAABB storeFloatUnsafe(DoubleAABB self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleAABB loadFloatUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
