package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;

public final class DoubleSphereRawOpsApi implements DoubleSphereRawOps {
    public DoubleSphere storeUnsafe(DoubleSphereImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleSphere loadUnsafe(DoubleSphereImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleSphere storeFloatUnsafe(DoubleSphereImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
    public DoubleSphere loadFloatUnsafe(DoubleSphereImpl self, long address) {
        throw new UnsupportedOperationException("raw-address store/load requires storeLoadBackend=UNSAFE");
    }
}
