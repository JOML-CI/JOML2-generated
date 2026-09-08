package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;

public interface IntRectRawOps {
    IntRect storeUnsafe(IntRect self, long address);
    IntRect loadUnsafe(long address);
    IntRect storeLongUnsafe(IntRect self, long address);
    IntRect loadLongUnsafe(long address);
}
