package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class DoubleOBBRawOpsApi implements DoubleOBBRawOps {
    public DoubleOBB storeUnsafe(DoubleOBB self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleOBB loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleOBB storeFloatUnsafe(DoubleOBB self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleOBB loadFloatUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
