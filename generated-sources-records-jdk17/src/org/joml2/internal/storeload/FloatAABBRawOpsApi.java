package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class FloatAABBRawOpsApi implements FloatAABBRawOps {
    public FloatAABB storeUnsafe(FloatAABB self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatAABB loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatAABB storeDoubleUnsafe(FloatAABB self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatAABB loadDoubleUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
