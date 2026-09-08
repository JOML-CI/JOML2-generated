package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class FloatPlaneRawOpsApi implements FloatPlaneRawOps {
    public FloatPlane storeUnsafe(FloatPlane self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatPlane loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatPlane storeDoubleUnsafe(FloatPlane self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatPlane loadDoubleUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
