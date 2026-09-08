package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Long4RawOpsApi implements Long4RawOps {
    public Long4 storeUnsafe(Long4 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Long4 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Long4 storeIntUnsafe(Long4 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Long4 loadIntUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
