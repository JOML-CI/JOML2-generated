package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Double2RawOpsApi implements Double2RawOps {
    public Double2 storeUnsafe(Double2 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Double2 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Double2 storeFloatUnsafe(Double2 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Double2 loadFloatUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
