package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;

public final class FloatPlaneRawOpsApi implements FloatPlaneRawOps {
    public FloatPlane storeUnsafe(FloatPlaneImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatPlane loadUnsafe(FloatPlaneImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatPlane storeDoubleUnsafe(FloatPlaneImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatPlane loadDoubleUnsafe(FloatPlaneImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
