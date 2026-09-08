package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class DoubleRectRawOpsApi implements DoubleRectRawOps {
    public DoubleRect storeUnsafe(DoubleRect self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleRect loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleRect storeFloatUnsafe(DoubleRect self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleRect loadFloatUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
