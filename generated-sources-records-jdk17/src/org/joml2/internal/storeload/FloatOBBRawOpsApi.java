package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class FloatOBBRawOpsApi implements FloatOBBRawOps {
    public FloatOBB storeUnsafe(FloatOBB self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatOBB loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatOBB storeDoubleUnsafe(FloatOBB self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatOBB loadDoubleUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
