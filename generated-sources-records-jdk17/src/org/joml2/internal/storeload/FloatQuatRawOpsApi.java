package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class FloatQuatRawOpsApi implements FloatQuatRawOps {
    public FloatQuat storeUnsafe(FloatQuat self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatQuat loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatQuat storeDoubleUnsafe(FloatQuat self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatQuat loadDoubleUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
