package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Short4RawOpsApi implements Short4RawOps {
    public Short4 storeUnsafe(Short4 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Short4 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Short4 storeByteUnsafe(Short4 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Short4 loadByteUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
