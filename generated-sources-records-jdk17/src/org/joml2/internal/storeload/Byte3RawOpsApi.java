package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Byte3RawOpsApi implements Byte3RawOps {
    public Byte3 storeUnsafe(Byte3 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Byte3 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Byte3 storeShortUnsafe(Byte3 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Byte3 loadShortUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
