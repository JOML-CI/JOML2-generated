package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;

public final class DoubleAABBRawOpsApi implements DoubleAABBRawOps {
    public DoubleAABB storeUnsafe(DoubleAABBImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleAABB loadUnsafe(DoubleAABBImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleAABB storeFloatUnsafe(DoubleAABBImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleAABB loadFloatUnsafe(DoubleAABBImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
