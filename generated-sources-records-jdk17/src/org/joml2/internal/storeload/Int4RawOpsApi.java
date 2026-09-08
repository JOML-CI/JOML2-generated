package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Int4RawOpsApi implements Int4RawOps {
    public Int4 storeUnsafe(Int4 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Int4 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Int4 storeLongUnsafe(Int4 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Int4 loadLongUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
