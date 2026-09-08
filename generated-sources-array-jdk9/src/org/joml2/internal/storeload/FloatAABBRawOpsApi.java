package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;

public final class FloatAABBRawOpsApi implements FloatAABBRawOps {
    public FloatAABB storeUnsafe(FloatAABBImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatAABB loadUnsafe(FloatAABBImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatAABB storeDoubleUnsafe(FloatAABBImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatAABB loadDoubleUnsafe(FloatAABBImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
