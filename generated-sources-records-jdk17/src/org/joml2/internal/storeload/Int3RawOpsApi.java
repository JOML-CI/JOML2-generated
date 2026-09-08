package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Int3RawOpsApi implements Int3RawOps {
    public Int3 storeUnsafe(Int3 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Int3 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Int3 storeLongUnsafe(Int3 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Int3 loadLongUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
