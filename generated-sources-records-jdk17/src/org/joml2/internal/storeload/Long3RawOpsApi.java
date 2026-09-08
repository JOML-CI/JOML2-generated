package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Long3RawOpsApi implements Long3RawOps {
    public Long3 storeUnsafe(Long3 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Long3 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Long3 storeIntUnsafe(Long3 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Long3 loadIntUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
