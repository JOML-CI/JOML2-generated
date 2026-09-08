package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Long2RawOpsApi implements Long2RawOps {
    public Long2 storeUnsafe(Long2 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Long2 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Long2 storeIntUnsafe(Long2 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Long2 loadIntUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
