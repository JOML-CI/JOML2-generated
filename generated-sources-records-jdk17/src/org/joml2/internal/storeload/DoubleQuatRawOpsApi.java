package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class DoubleQuatRawOpsApi implements DoubleQuatRawOps {
    public DoubleQuat storeUnsafe(DoubleQuat self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleQuat loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleQuat storeFloatUnsafe(DoubleQuat self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleQuat loadFloatUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
