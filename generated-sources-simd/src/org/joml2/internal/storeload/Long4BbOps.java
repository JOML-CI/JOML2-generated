package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public interface Long4BbOps {
    IntBuffer storeAbsolute(Long4Impl self, int index, IntBuffer buf);
    Long4 loadAbsolute(Long4Impl self, int index, IntBuffer buf);
    ByteBuffer storeIntAbsolute(Long4Impl self, int index, ByteBuffer buf);
    Long4 loadIntAbsolute(Long4Impl self, int index, ByteBuffer buf);
}
