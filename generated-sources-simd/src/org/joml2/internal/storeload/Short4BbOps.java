package org.joml2.internal.storeload;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.internal.types.*;
import java.nio.ByteBuffer;

public interface Short4BbOps {
    ByteBuffer storeByteAbsolute(Short4Impl self, int index, ByteBuffer buf);
    Short4 loadByteAbsolute(Short4Impl self, int index, ByteBuffer buf);
}
