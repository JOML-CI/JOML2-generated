package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class FloatDualQuatRawOpsApi implements FloatDualQuatRawOps {
    public FloatDualQuat storeUnsafe(FloatDualQuat self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatDualQuat loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatDualQuat storeDoubleUnsafe(FloatDualQuat self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatDualQuat loadDoubleUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
