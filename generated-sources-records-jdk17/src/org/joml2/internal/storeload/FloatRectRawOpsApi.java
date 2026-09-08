package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class FloatRectRawOpsApi implements FloatRectRawOps {
    public FloatRect storeUnsafe(FloatRect self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatRect loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatRect storeDoubleUnsafe(FloatRect self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public FloatRect loadDoubleUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
