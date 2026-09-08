package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public final class Byte2RawOpsApi implements Byte2RawOps {
    public Byte2 storeUnsafe(Byte2 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Byte2 loadUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Byte2 storeShortUnsafe(Byte2 self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public Byte2 loadShortUnsafe(long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
