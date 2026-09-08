package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class IntRectRawOpsApi implements IntRectRawOps {
    public IntRect storeUnsafe(IntRect self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public IntRect loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public IntRect storeLongUnsafe(IntRect self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public IntRect loadLongUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
