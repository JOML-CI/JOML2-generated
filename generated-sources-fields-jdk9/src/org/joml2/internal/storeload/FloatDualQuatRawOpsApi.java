package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;

public final class FloatDualQuatRawOpsApi implements FloatDualQuatRawOps {
    public FloatDualQuat storeUnsafe(FloatDualQuatImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatDualQuat loadUnsafe(FloatDualQuatImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatDualQuat storeDoubleUnsafe(FloatDualQuatImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatDualQuat loadDoubleUnsafe(FloatDualQuatImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
