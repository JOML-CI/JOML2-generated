package org.joml2.internal.kernels;

import org.joml2.*;
import org.joml2.Math;
import org.joml2.ops.*;
import org.joml2.internal.unsafe.*;

/**
 * Scalar/Unsafe kernel leaves of {@link Float4x4Ops} whose leading storage
 * parameter is a {@code float[]} array. Split into a sibling compilation unit purely
 * to keep generated sources IDE-sized; package-private, called only from
 * {@code Float4x4Ops} and its sibling kernel units. Not public API.
 */
public final class Float4x4OpsKernelsArray {
    private Float4x4OpsKernelsArray() {}

    public static float[] frustumAabb_no(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t1 = -_self01;
        float _t2 = -_self00;
        float _t3 = -_self10;
        float _t40 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t41 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t42 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t43 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t44 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t45 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t46 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t47 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t48 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t49 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t50 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t51 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t52 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t53 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t54 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t55 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t56 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t57 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t142 = Math.fma(_self01, _t40, Math.fma(_self03, _t41, -(_self02 * _t42)));
        float _t143 = Math.fma(_self00, _t45, Math.fma(_self02, _t49, -(_self01 * _t50)));
        float _t144 = Math.fma(_self10, _t41, Math.fma(_self12, _t51, -(_self11 * _t52)));
        float _t145 = Math.fma(_self00, _t48, Math.fma(_self02, _t53, -(_self01 * _t54)));
        float _t146 = Math.fma(_self11, _t40, Math.fma(_self13, _t41, -(_self12 * _t42)));
        float _t147 = Math.fma(_self00, _t41, Math.fma(_self02, _t51, -(_self01 * _t52)));
        float _t148 = Math.fma(_self01, _t43, Math.fma(_self03, _t45, -(_self02 * _t44)));
        float _t149 = Math.fma(_self00, _t43, Math.fma(_self03, _t50, -(_self02 * _t55)));
        float _t150 = Math.fma(_self10, _t40, Math.fma(_self13, _t52, -(_self12 * _t56)));
        float _t151 = Math.fma(_self00, _t46, Math.fma(_self03, _t54, -(_self02 * _t57)));
        float _t152 = Math.fma(_self00, _t40, Math.fma(_self03, _t52, -(_self02 * _t56)));
        float _t153 = Math.fma(_self00, _t42, Math.fma(_self03, _t51, -(_self01 * _t56)));
        float _t154 = Math.fma(_self10, _t42, Math.fma(_self13, _t51, -(_self11 * _t56)));
        float _t155 = Math.fma(_self00, _t44, Math.fma(_self03, _t49, -(_self01 * _t55)));
        float _t156 = Math.fma(-_self11, _t40, Math.fma(_self12, _t42, -(_self13 * _t41)));
        float _t158 = Math.fma(_t1, _t46, Math.fma(_self02, _t47, -(_self03 * _t48)));
        float _t159 = Math.fma(_t2, _t41, Math.fma(_self01, _t52, -(_self02 * _t51)));
        float _t160 = Math.fma(_t3, _t41, Math.fma(_self11, _t52, -(_self12 * _t51)));
        float _t161 = Math.fma(_t1, _t40, Math.fma(_self02, _t42, -(_self03 * _t41)));
        float _t162 = Math.fma(_t2, _t45, Math.fma(_self01, _t50, -(_self02 * _t49)));
        float _t163 = Math.fma(_t2, _t40, Math.fma(_self02, _t56, -(_self03 * _t52)));
        float _t164 = Math.fma(_t3, _t40, Math.fma(_self12, _t56, -(_self13 * _t52)));
        float _t165 = Math.fma(_t2, _t43, Math.fma(_self02, _t55, -(_self03 * _t50)));
        float _t166 = Math.fma(_t3, _t42, Math.fma(_self11, _t56, -(_self13 * _t51)));
        float _t168 = Math.fma(_t2, _t47, Math.fma(_self01, _t57, -(_self03 * _t53)));
        float _t169 = Math.fma(_t2, _t42, Math.fma(_self01, _t56, -(_self03 * _t51)));
        float _t171 = _t142 + _t146;
        float _t178 = _t145 + _t147;
        float _t184 = _t151 + _t152;
        float _t185 = _t153 + _t154;
        float _t189 = _t159 + _t145;
        float _t197 = _t163 + _t151;
        float _t206 = Math.fma(_t1, _t43, Math.fma(_self02, _t44, -(_self03 * _t45))) + _t158;
        float _t209 = _t159 + _t162;
        float _t210 = _t161 + _t158;
        float _t212 = _t163 + _t165;
        float _t214 = Math.fma(_t2, _t44, Math.fma(_self01, _t55, -(_self03 * _t49))) + _t168;
        float _t217 = _t169 + _t168;
        float _t218 = _t147 + _t144 + (_t143 + _t145);
        float _t218_inv = 1.0f / _t218;
        float _t220 = _t143 + _t144 + _t189;
        float _t220_inv = 1.0f / _t220;
        float _t221 = _t143 + _t147 + (_t160 + _t145);
        float _t221_inv = 1.0f / _t221;
        float _t223 = _t178 + (_t144 + _t162);
        float _t223_inv = 1.0f / _t223;
        float _t229 = _t143 + _t160 + _t189;
        float _t229_inv = 1.0f / _t229;
        float _t231 = _t145 + _t144 + _t209;
        float _t231_inv = 1.0f / _t231;
        float _t233 = _t178 + (_t160 + _t162);
        float _t233_inv = 1.0f / _t233;
        float _t242 = _t145 + _t160 + _t209;
        float _t242_inv = 1.0f / _t242;
        float _t250 = (_t152 + _t150 + (_t149 + _t151)) * _t218_inv;
        float _t251 = (_t149 + _t150 + _t197) * _t220_inv;
        float _t252 = (_t149 + _t152 + (_t164 + _t151)) * _t221_inv;
        float _t253 = (_t184 + (_t150 + _t165)) * _t223_inv;
        float _t254 = (_t142 + _t156 + _t206) * _t220_inv;
        float _t255 = (_t171 + _t206) * _t229_inv;
        float _t256 = (_t146 + _t161 + _t206) * _t221_inv;
        float _t257 = (_t156 + _t161 + _t206) * _t218_inv;
        float _t258 = (_t148 + _t142 + (_t156 + _t158)) * _t231_inv;
        float _t259 = (_t171 + (_t148 + _t158)) * _t242_inv;
        float _t260 = (_t148 + _t146 + _t210) * _t233_inv;
        float _t261 = (_t148 + _t156 + _t210) * _t223_inv;
        float _t262 = (_t149 + _t164 + _t197) * _t229_inv;
        float _t263 = (_t151 + _t150 + _t212) * _t231_inv;
        float _t264 = (_t184 + (_t164 + _t165)) * _t233_inv;
        float _t265 = (_t153 + _t166 + _t214) * _t220_inv;
        float _t266 = (_t185 + _t214) * _t229_inv;
        float _t267 = (_t154 + _t169 + _t214) * _t221_inv;
        float _t268 = (_t166 + _t169 + _t214) * _t218_inv;
        float _t269 = (_t155 + _t153 + (_t166 + _t168)) * _t231_inv;
        float _t270 = (_t185 + (_t155 + _t168)) * _t242_inv;
        float _t271 = (_t155 + _t154 + _t217) * _t233_inv;
        float _t272 = (_t155 + _t166 + _t217) * _t223_inv;
        float _t273 = (_t151 + _t164 + _t212) * _t242_inv;
        dest[destOffset + 0] = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t254, _t255), _t256), _t257), _t258), _t259), _t260), _t261);
        dest[destOffset + 1] = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t251, _t262), _t252), _t250), _t263), _t273), _t264), _t253);
        dest[destOffset + 2] = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t265, _t266), _t267), _t268), _t269), _t270), _t271), _t272);
        dest[destOffset + 3] = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t254, _t255), _t256), _t257), _t258), _t259), _t260), _t261);
        dest[destOffset + 4] = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t251, _t262), _t252), _t250), _t263), _t273), _t264), _t253);
        dest[destOffset + 5] = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t265, _t266), _t267), _t268), _t269), _t270), _t271), _t272);
        return dest;
    }

    public static float[] frustumAabb_zo(float[] dest, int destOffset, float[] src, int srcOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = -_self01;
        float _t1 = -_self00;
        float _t2 = -_self10;
        float _t40 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t41 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t42 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t43 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t44 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t45 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t46 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t47 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t48 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t49 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t50 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t51 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t52 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t53 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t54 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t55 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t56 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t57 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t59 = _self11 * _t40;
        float _t63 = _self10 * _t42;
        float _t75 = _self10 * _t40;
        float _t83 = _self10 * _t41;
        float _t90 = -(_self02 * _t41);
        float _t91 = -_t59;
        float _t92 = -(_self13 * _t42);
        float _t94 = -(_self01 * _t46);
        float _t97 = -(_self12 * _t41);
        float _t102 = -(_self01 * _t49);
        float _t105 = -(_self02 * _t55);
        float _t110 = -(_self02 * _t56);
        float _t112 = -(_self01 * _t56);
        float _t113 = -_t83;
        float _t114 = -(_self13 * _t48);
        float _t116 = -(_self11 * _t56);
        float _t128 = Math.fma(_self01, _t40, _t90);
        float _t130 = Math.fma(_self12, _t41, _t92);
        float _t132 = Math.fma(_self00, _t45, _t94);
        float _t133 = Math.fma(_self12, _t48, -(_self11 * _t49));
        float _t135 = Math.fma(_self13, _t42, _t97);
        float _t137 = Math.fma(_self11, _t49, -(_self12 * _t48));
        float _t140 = Math.fma(_self02, _t41, -(_self03 * _t42));
        float _t141 = Math.fma(_self02, _t48, _t102);
        float _t148 = Math.fma(_self00, _t43, _t105);
        float _t149 = Math.fma(_self13, _t49, -(_self12 * _t56));
        float _t152 = Math.fma(_self12, _t56, -(_self13 * _t49));
        float _t153 = Math.fma(_self03, _t49, _t110);
        float _t157 = Math.fma(_self00, _t41, _t112);
        float _t159 = Math.fma(_self11, _t56, _t114);
        float _t161 = Math.fma(_self13, _t48, _t116);
        float _t164 = Math.fma(_self01, _t56, -(_self03 * _t48));
        float _t170 = Math.fma(_self00, _t45, Math.fma(_self02, _t47, _t94));
        float _t171 = Math.fma(_self01, _t50, Math.fma(_self03, _t51, -(_self02 * _t52)));
        float _t172 = Math.fma(_self01, _t40, Math.fma(_self03, _t42, _t90));
        float _t173 = Math.fma(_self10, _t42, _t133);
        float _t174 = Math.fma(_self11, _t40, _t135);
        float _t176 = Math.fma(_self00, _t43, Math.fma(_self03, _t46, _t105));
        float _t177 = Math.fma(_self10, _t40, _t149);
        float _t179 = Math.fma(_self00, _t52, Math.fma(_self03, _t54, -(_self01 * _t57)));
        float _t180 = Math.fma(_self00, _t41, Math.fma(_self03, _t48, _t112));
        float _t181 = Math.fma(_self10, _t41, _t161);
        float _t182 = Math.fma(_t0, _t43, Math.fma(_self02, _t44, -(_self03 * _t45)));
        float _t183 = Math.fma(_t1, _t42, Math.fma(_self01, _t49, -(_self02 * _t48)));
        float _t184 = Math.fma(_t2, _t42, _t137);
        float _t185 = Math.fma(-_self11, _t40, _t130);
        float _t186 = Math.fma(_t1, _t51, Math.fma(_self01, _t53, -(_self02 * _t54)));
        float _t188 = Math.fma(_t1, _t40, Math.fma(_self02, _t56, -(_self03 * _t49)));
        float _t189 = Math.fma(_t2, _t40, _t152);
        float _t190 = Math.fma(_t1, _t50, Math.fma(_self02, _t57, -(_self03 * _t53)));
        float _t191 = Math.fma(_t1, _t44, Math.fma(_self01, _t55, -(_self03 * _t47)));
        float _t192 = Math.fma(_t2, _t41, _t159);
        float _t216 = _t140 + _t182;
        float _t223 = _t164 + _t191;
        float _t228 = _t170 + Math.fma(_self00, _t42, _t141);
        float _t230 = _t176 + Math.fma(_self00, _t40, _t153);
        float _t243 = _t183 + _t186;
        float _t244 = Math.fma(_t0, _t40, _t140) + _t182;
        float _t246 = _t188 + _t190;
        float _t249 = Math.fma(_t1, _t41, _t164) + _t191;
        float _t250 = Math.fma(_self00, _t42, _t102) + Math.fma(_self02, _t48, _t63) + (_t133 + _t170);
        float _t250_inv = 1.0f / _t250;
        float _t252 = _t132 + Math.fma(_self02, _t47, _t63) + (_t133 + _t183);
        float _t252_inv = 1.0f / _t252;
        float _t254 = _t132 + Math.fma(_self02, _t47, _self00 * _t42) + (_t141 + _t184);
        float _t254_inv = 1.0f / _t254;
        float _t259 = _t132 + Math.fma(_self02, _t47, -_t63) + (_t137 + _t183);
        float _t259_inv = 1.0f / _t259;
        float _t267 = _t228 + (_t173 + _t186);
        float _t267_inv = 1.0f / _t267;
        float _t271 = _t170 + _t173 + _t243;
        float _t271_inv = 1.0f / _t271;
        float _t273 = _t228 + (_t184 + _t186);
        float _t273_inv = 1.0f / _t273;
        float _t278 = _t170 + _t184 + _t243;
        float _t278_inv = 1.0f / _t278;
        float _t282 = (Math.fma(_self00, _t40, _t110) + Math.fma(_self03, _t49, _t75) + (_t149 + _t176)) * _t250_inv;
        float _t283 = (_t148 + Math.fma(_self03, _t46, _t75) + (_t149 + _t188)) * _t252_inv;
        float _t284 = (_t148 + Math.fma(_self03, _t46, _self00 * _t40) + (_t153 + _t189)) * _t254_inv;
        float _t285 = (_t128 + Math.fma(_self03, _t42, _t91) + (_t130 + _t182)) * _t252_inv;
        float _t286 = (_t128 + Math.fma(_self03, _t42, _t59) + (_t135 + _t182)) * _t259_inv;
        float _t287 = (Math.fma(_self11, _t40, _t97) + Math.fma(_self13, _t42, -(_self01 * _t40)) + _t216) * _t254_inv;
        float _t288 = (Math.fma(_self12, _t41, _t91) + Math.fma(_t0, _t40, _t92) + _t216) * _t250_inv;
        float _t289 = (_t157 + Math.fma(_self03, _t48, _t113) + (_t159 + _t191)) * _t252_inv;
        float _t290 = (_t157 + Math.fma(_self03, _t48, _t83) + (_t161 + _t191)) * _t259_inv;
        float _t291 = (Math.fma(_self10, _t41, _t116) + Math.fma(_self13, _t48, -(_self00 * _t41)) + _t223) * _t254_inv;
        float _t292 = (Math.fma(_self11, _t56, _t113) + Math.fma(_t1, _t41, _t114) + _t223) * _t250_inv;
        float _t293 = (_t148 + Math.fma(_self03, _t46, -_t75) + (_t152 + _t188)) * _t259_inv;
        float _t294 = (_t230 + (_t177 + _t190)) * _t267_inv;
        float _t295 = (_t171 + _t172 + (_t185 + _t182)) * _t271_inv;
        float _t296 = (_t172 + _t174 + (_t171 + _t182)) * _t278_inv;
        float _t297 = (_t171 + _t174 + _t244) * _t273_inv;
        float _t298 = (_t171 + _t185 + _t244) * _t267_inv;
        float _t299 = (_t176 + _t177 + _t246) * _t271_inv;
        float _t300 = (_t230 + (_t189 + _t190)) * _t273_inv;
        float _t301 = (_t179 + _t180 + (_t192 + _t191)) * _t271_inv;
        float _t302 = (_t180 + _t181 + (_t179 + _t191)) * _t278_inv;
        float _t303 = (_t179 + _t181 + _t249) * _t273_inv;
        float _t304 = (_t179 + _t192 + _t249) * _t267_inv;
        float _t305 = (_t176 + _t189 + _t246) * _t278_inv;
        dest[destOffset + 0] = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t285, _t286), _t287), _t288), _t295), _t296), _t297), _t298);
        dest[destOffset + 1] = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t283, _t293), _t284), _t282), _t299), _t305), _t300), _t294);
        dest[destOffset + 2] = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t289, _t290), _t291), _t292), _t301), _t302), _t303), _t304);
        dest[destOffset + 3] = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t285, _t286), _t287), _t288), _t295), _t296), _t297), _t298);
        dest[destOffset + 4] = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t283, _t293), _t284), _t282), _t299), _t305), _t300), _t294);
        dest[destOffset + 5] = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t289, _t290), _t291), _t292), _t301), _t302), _t303), _t304);
        return dest;
    }

    public static float[] frustumCorner_no(float[] dest, int destOffset, float[] src, int srcOffset, FrustumCorner corner) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t1 = -_self01;
        float _t2 = -_self00;
        float _t3 = -_self10;
        float _t40 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t41 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t42 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t43 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t44 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t45 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t46 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t47 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t48 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t49 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t50 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t51 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t52 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t53 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t54 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t55 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t56 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t57 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t142 = Math.fma(_self01, _t40, Math.fma(_self03, _t41, -(_self02 * _t42)));
        float _t143 = Math.fma(_self00, _t45, Math.fma(_self02, _t49, -(_self01 * _t50)));
        float _t144 = Math.fma(_self10, _t41, Math.fma(_self12, _t51, -(_self11 * _t52)));
        float _t145 = Math.fma(_self00, _t48, Math.fma(_self02, _t53, -(_self01 * _t54)));
        float _t146 = Math.fma(_self11, _t40, Math.fma(_self13, _t41, -(_self12 * _t42)));
        float _t147 = Math.fma(_self00, _t41, Math.fma(_self02, _t51, -(_self01 * _t52)));
        float _t148 = Math.fma(_self01, _t43, Math.fma(_self03, _t45, -(_self02 * _t44)));
        float _t149 = Math.fma(_self00, _t43, Math.fma(_self03, _t50, -(_self02 * _t55)));
        float _t150 = Math.fma(_self10, _t40, Math.fma(_self13, _t52, -(_self12 * _t56)));
        float _t151 = Math.fma(_self00, _t46, Math.fma(_self03, _t54, -(_self02 * _t57)));
        float _t152 = Math.fma(_self00, _t40, Math.fma(_self03, _t52, -(_self02 * _t56)));
        float _t153 = Math.fma(_self00, _t42, Math.fma(_self03, _t51, -(_self01 * _t56)));
        float _t154 = Math.fma(_self10, _t42, Math.fma(_self13, _t51, -(_self11 * _t56)));
        float _t155 = Math.fma(_self00, _t44, Math.fma(_self03, _t49, -(_self01 * _t55)));
        float _t156 = Math.fma(-_self11, _t40, Math.fma(_self12, _t42, -(_self13 * _t41)));
        float _t158 = Math.fma(_t1, _t46, Math.fma(_self02, _t47, -(_self03 * _t48)));
        float _t159 = Math.fma(_t2, _t41, Math.fma(_self01, _t52, -(_self02 * _t51)));
        float _t160 = Math.fma(_t3, _t41, Math.fma(_self11, _t52, -(_self12 * _t51)));
        float _t161 = Math.fma(_t1, _t40, Math.fma(_self02, _t42, -(_self03 * _t41)));
        float _t162 = Math.fma(_t2, _t45, Math.fma(_self01, _t50, -(_self02 * _t49)));
        float _t163 = Math.fma(_t2, _t40, Math.fma(_self02, _t56, -(_self03 * _t52)));
        float _t164 = Math.fma(_t3, _t40, Math.fma(_self12, _t56, -(_self13 * _t52)));
        float _t165 = Math.fma(_t2, _t43, Math.fma(_self02, _t55, -(_self03 * _t50)));
        float _t166 = Math.fma(_t3, _t42, Math.fma(_self11, _t56, -(_self13 * _t51)));
        float _t168 = Math.fma(_t2, _t47, Math.fma(_self01, _t57, -(_self03 * _t53)));
        float _t169 = Math.fma(_t2, _t42, Math.fma(_self01, _t56, -(_self03 * _t51)));
        float _t171 = _t142 + _t146;
        float _t176 = _t145 + _t147;
        float _t177 = _t151 + _t152;
        float _t178 = _t153 + _t154;
        float _t179 = _t159 + _t145;
        float _t184 = _t163 + _t151;
        float _t185 = Math.fma(_t1, _t43, Math.fma(_self02, _t44, -(_self03 * _t45))) + _t158;
        float _t186 = _t159 + _t162;
        float _t187 = _t161 + _t158;
        float _t189 = _t163 + _t165;
        float _t190 = Math.fma(_t2, _t44, Math.fma(_self01, _t55, -(_self03 * _t49))) + _t168;
        float _t191 = _t169 + _t168;
        float _t192 = _t147 + _t144 + (_t143 + _t145);
        float _t192_inv = 1.0f / _t192;
        float _t193 = _t143 + _t144 + _t179;
        float _t193_inv = 1.0f / _t193;
        float _t194 = _t143 + _t147 + (_t160 + _t145);
        float _t194_inv = 1.0f / _t194;
        float _t195 = _t176 + (_t144 + _t162);
        float _t195_inv = 1.0f / _t195;
        float _t196 = _t143 + _t160 + _t179;
        float _t196_inv = 1.0f / _t196;
        float _t197 = _t145 + _t144 + _t186;
        float _t197_inv = 1.0f / _t197;
        float _t198 = _t176 + (_t160 + _t162);
        float _t198_inv = 1.0f / _t198;
        float _t199 = _t145 + _t160 + _t186;
        float _t199_inv = 1.0f / _t199;
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        switch (corner) {
            case NXNYNZ: _idxSw0 = (_t142 + _t156 + _t185) * _t193_inv; _idxSw1 = (_t149 + _t150 + _t184) * _t193_inv; _idxSw2 = (_t153 + _t166 + _t190) * _t193_inv; break;
            case PXNYNZ: _idxSw0 = (_t171 + _t185) * _t196_inv; _idxSw1 = (_t149 + _t164 + _t184) * _t196_inv; _idxSw2 = (_t178 + _t190) * _t196_inv; break;
            case PXPYNZ: _idxSw0 = (_t146 + _t161 + _t185) * _t194_inv; _idxSw1 = (_t149 + _t152 + (_t164 + _t151)) * _t194_inv; _idxSw2 = (_t154 + _t169 + _t190) * _t194_inv; break;
            case NXPYNZ: _idxSw0 = (_t156 + _t161 + _t185) * _t192_inv; _idxSw1 = (_t152 + _t150 + (_t149 + _t151)) * _t192_inv; _idxSw2 = (_t166 + _t169 + _t190) * _t192_inv; break;
            case NXNYPZ: _idxSw0 = (_t148 + _t142 + (_t156 + _t158)) * _t197_inv; _idxSw1 = (_t151 + _t150 + _t189) * _t197_inv; _idxSw2 = (_t155 + _t153 + (_t166 + _t168)) * _t197_inv; break;
            case PXNYPZ: _idxSw0 = (_t171 + (_t148 + _t158)) * _t199_inv; _idxSw1 = (_t151 + _t164 + _t189) * _t199_inv; _idxSw2 = (_t178 + (_t155 + _t168)) * _t199_inv; break;
            case PXPYPZ: _idxSw0 = (_t148 + _t146 + _t187) * _t198_inv; _idxSw1 = (_t177 + (_t164 + _t165)) * _t198_inv; _idxSw2 = (_t155 + _t154 + _t191) * _t198_inv; break;
            case NXPYPZ: _idxSw0 = (_t148 + _t156 + _t187) * _t195_inv; _idxSw1 = (_t177 + (_t150 + _t165)) * _t195_inv; _idxSw2 = (_t155 + _t166 + _t191) * _t195_inv; break;
            default: throw new IllegalArgumentException("Unknown FrustumCorner: " + corner);
        }
        dest[destOffset + 0] = _idxSw0;
        dest[destOffset + 1] = _idxSw1;
        dest[destOffset + 2] = _idxSw2;
        return dest;
    }

    public static float[] frustumCorner_zo(float[] dest, int destOffset, float[] src, int srcOffset, FrustumCorner corner) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = -_self01;
        float _t1 = -_self00;
        float _t2 = -_self10;
        float _t40 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t41 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t42 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t43 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t44 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t45 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t46 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t47 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t48 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t49 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t50 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t51 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t52 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t53 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t54 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t55 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t56 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t57 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t59 = _self11 * _t40;
        float _t63 = _self10 * _t42;
        float _t74 = _self10 * _t40;
        float _t81 = _self10 * _t41;
        float _t87 = -(_self02 * _t41);
        float _t88 = -_t59;
        float _t89 = -(_self13 * _t42);
        float _t91 = -(_self01 * _t46);
        float _t94 = -(_self12 * _t41);
        float _t98 = -(_self01 * _t49);
        float _t101 = -(_self02 * _t55);
        float _t105 = -(_self02 * _t56);
        float _t107 = -(_self01 * _t56);
        float _t108 = -_t81;
        float _t109 = -(_self13 * _t48);
        float _t111 = -(_self11 * _t56);
        float _t117 = Math.fma(_self01, _t40, _t87);
        float _t118 = Math.fma(_self12, _t41, _t89);
        float _t120 = Math.fma(_self00, _t45, _t91);
        float _t121 = Math.fma(_self12, _t48, -(_self11 * _t49));
        float _t123 = Math.fma(_self13, _t42, _t94);
        float _t125 = Math.fma(_self11, _t49, -(_self12 * _t48));
        float _t126 = Math.fma(_self02, _t41, -(_self03 * _t42));
        float _t127 = Math.fma(_self02, _t48, _t98);
        float _t133 = Math.fma(_self00, _t43, _t101);
        float _t134 = Math.fma(_self13, _t49, -(_self12 * _t56));
        float _t136 = Math.fma(_self12, _t56, -(_self13 * _t49));
        float _t137 = Math.fma(_self03, _t49, _t105);
        float _t140 = Math.fma(_self00, _t41, _t107);
        float _t141 = Math.fma(_self11, _t56, _t109);
        float _t143 = Math.fma(_self13, _t48, _t111);
        float _t144 = Math.fma(_self01, _t56, -(_self03 * _t48));
        float _t147 = Math.fma(_self00, _t45, Math.fma(_self02, _t47, _t91));
        float _t148 = Math.fma(_self01, _t50, Math.fma(_self03, _t51, -(_self02 * _t52)));
        float _t149 = Math.fma(_self01, _t40, Math.fma(_self03, _t42, _t87));
        float _t150 = Math.fma(_self10, _t42, _t121);
        float _t151 = Math.fma(_self11, _t40, _t123);
        float _t153 = Math.fma(_self00, _t43, Math.fma(_self03, _t46, _t101));
        float _t154 = Math.fma(_self10, _t40, _t134);
        float _t156 = Math.fma(_self00, _t52, Math.fma(_self03, _t54, -(_self01 * _t57)));
        float _t157 = Math.fma(_self00, _t41, Math.fma(_self03, _t48, _t107));
        float _t158 = Math.fma(_self10, _t41, _t143);
        float _t159 = Math.fma(_t0, _t43, Math.fma(_self02, _t44, -(_self03 * _t45)));
        float _t160 = Math.fma(_t1, _t42, Math.fma(_self01, _t49, -(_self02 * _t48)));
        float _t161 = Math.fma(_t2, _t42, _t125);
        float _t162 = Math.fma(-_self11, _t40, _t118);
        float _t163 = Math.fma(_t1, _t51, Math.fma(_self01, _t53, -(_self02 * _t54)));
        float _t165 = Math.fma(_t1, _t40, Math.fma(_self02, _t56, -(_self03 * _t49)));
        float _t166 = Math.fma(_t2, _t40, _t136);
        float _t167 = Math.fma(_t1, _t50, Math.fma(_self02, _t57, -(_self03 * _t53)));
        float _t168 = Math.fma(_t1, _t44, Math.fma(_self01, _t55, -(_self03 * _t47)));
        float _t169 = Math.fma(_t2, _t41, _t141);
        float _t178 = _t126 + _t159;
        float _t180 = _t144 + _t168;
        float _t182 = _t147 + Math.fma(_self00, _t42, _t127);
        float _t183 = _t153 + Math.fma(_self00, _t40, _t137);
        float _t186 = _t160 + _t163;
        float _t187 = Math.fma(_t0, _t40, _t126) + _t159;
        float _t189 = _t165 + _t167;
        float _t190 = Math.fma(_t1, _t41, _t144) + _t168;
        float _t191 = Math.fma(_self00, _t42, _t98) + Math.fma(_self02, _t48, _t63) + (_t121 + _t147);
        float _t191_inv = 1.0f / _t191;
        float _t192 = _t120 + Math.fma(_self02, _t47, _t63) + (_t121 + _t160);
        float _t192_inv = 1.0f / _t192;
        float _t193 = _t120 + Math.fma(_self02, _t47, _self00 * _t42) + (_t127 + _t161);
        float _t193_inv = 1.0f / _t193;
        float _t194 = _t120 + Math.fma(_self02, _t47, -_t63) + (_t125 + _t160);
        float _t194_inv = 1.0f / _t194;
        float _t195 = _t182 + (_t150 + _t163);
        float _t195_inv = 1.0f / _t195;
        float _t196 = _t147 + _t150 + _t186;
        float _t196_inv = 1.0f / _t196;
        float _t197 = _t182 + (_t161 + _t163);
        float _t197_inv = 1.0f / _t197;
        float _t198 = _t147 + _t161 + _t186;
        float _t198_inv = 1.0f / _t198;
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        switch (corner) {
            case NXNYNZ: _idxSw0 = (_t117 + Math.fma(_self03, _t42, _t88) + (_t118 + _t159)) * _t192_inv; _idxSw1 = (_t133 + Math.fma(_self03, _t46, _t74) + (_t134 + _t165)) * _t192_inv; _idxSw2 = (_t140 + Math.fma(_self03, _t48, _t108) + (_t141 + _t168)) * _t192_inv; break;
            case PXNYNZ: _idxSw0 = (_t117 + Math.fma(_self03, _t42, _t59) + (_t123 + _t159)) * _t194_inv; _idxSw1 = (_t133 + Math.fma(_self03, _t46, -_t74) + (_t136 + _t165)) * _t194_inv; _idxSw2 = (_t140 + Math.fma(_self03, _t48, _t81) + (_t143 + _t168)) * _t194_inv; break;
            case PXPYNZ: _idxSw0 = (Math.fma(_self11, _t40, _t94) + Math.fma(_self13, _t42, -(_self01 * _t40)) + _t178) * _t193_inv; _idxSw1 = (_t133 + Math.fma(_self03, _t46, _self00 * _t40) + (_t137 + _t166)) * _t193_inv; _idxSw2 = (Math.fma(_self10, _t41, _t111) + Math.fma(_self13, _t48, -(_self00 * _t41)) + _t180) * _t193_inv; break;
            case NXPYNZ: _idxSw0 = (Math.fma(_self12, _t41, _t88) + Math.fma(_t0, _t40, _t89) + _t178) * _t191_inv; _idxSw1 = (Math.fma(_self00, _t40, _t105) + Math.fma(_self03, _t49, _t74) + (_t134 + _t153)) * _t191_inv; _idxSw2 = (Math.fma(_self11, _t56, _t108) + Math.fma(_t1, _t41, _t109) + _t180) * _t191_inv; break;
            case NXNYPZ: _idxSw0 = (_t148 + _t149 + (_t162 + _t159)) * _t196_inv; _idxSw1 = (_t153 + _t154 + _t189) * _t196_inv; _idxSw2 = (_t156 + _t157 + (_t169 + _t168)) * _t196_inv; break;
            case PXNYPZ: _idxSw0 = (_t149 + _t151 + (_t148 + _t159)) * _t198_inv; _idxSw1 = (_t153 + _t166 + _t189) * _t198_inv; _idxSw2 = (_t157 + _t158 + (_t156 + _t168)) * _t198_inv; break;
            case PXPYPZ: _idxSw0 = (_t148 + _t151 + _t187) * _t197_inv; _idxSw1 = (_t183 + (_t166 + _t167)) * _t197_inv; _idxSw2 = (_t156 + _t158 + _t190) * _t197_inv; break;
            case NXPYPZ: _idxSw0 = (_t148 + _t162 + _t187) * _t195_inv; _idxSw1 = (_t183 + (_t154 + _t167)) * _t195_inv; _idxSw2 = (_t156 + _t169 + _t190) * _t195_inv; break;
            default: throw new IllegalArgumentException("Unknown FrustumCorner: " + corner);
        }
        dest[destOffset + 0] = _idxSw0;
        dest[destOffset + 1] = _idxSw1;
        dest[destOffset + 2] = _idxSw2;
        return dest;
    }

    public static float[] frustumPlane_no(float[] dest, int destOffset, float[] src, int srcOffset, FrustumPlane plane) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        float _idxSw3;
        switch (plane) {
            case NX: _idxSw0 = _self00 + _self30; _idxSw1 = _self01 + _self31; _idxSw2 = _self02 + _self32; _idxSw3 = _self03 + _self33; break;
            case PX: _idxSw0 = _self30 - _self00; _idxSw1 = _self31 - _self01; _idxSw2 = _self32 - _self02; _idxSw3 = _self33 - _self03; break;
            case NY: _idxSw0 = _self10 + _self30; _idxSw1 = _self11 + _self31; _idxSw2 = _self12 + _self32; _idxSw3 = _self13 + _self33; break;
            case PY: _idxSw0 = _self30 - _self10; _idxSw1 = _self31 - _self11; _idxSw2 = _self32 - _self12; _idxSw3 = _self33 - _self13; break;
            case NZ: _idxSw0 = _self20 + _self30; _idxSw1 = _self21 + _self31; _idxSw2 = _self22 + _self32; _idxSw3 = _self23 + _self33; break;
            case PZ: _idxSw0 = _self30 - _self20; _idxSw1 = _self31 - _self21; _idxSw2 = _self32 - _self22; _idxSw3 = _self33 - _self23; break;
            default: throw new IllegalArgumentException("Unknown FrustumPlane: " + plane);
        }
        dest[destOffset + 0] = _idxSw0;
        dest[destOffset + 1] = _idxSw1;
        dest[destOffset + 2] = _idxSw2;
        dest[destOffset + 3] = _idxSw3;
        return dest;
    }

    public static float[] frustumPlane_zo(float[] dest, int destOffset, float[] src, int srcOffset, FrustumPlane plane) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _idxSw0;
        float _idxSw1;
        float _idxSw2;
        float _idxSw3;
        switch (plane) {
            case NX: _idxSw0 = _self00 + _self30; _idxSw1 = _self01 + _self31; _idxSw2 = _self02 + _self32; _idxSw3 = _self03 + _self33; break;
            case PX: _idxSw0 = _self30 - _self00; _idxSw1 = _self31 - _self01; _idxSw2 = _self32 - _self02; _idxSw3 = _self33 - _self03; break;
            case NY: _idxSw0 = _self10 + _self30; _idxSw1 = _self11 + _self31; _idxSw2 = _self12 + _self32; _idxSw3 = _self13 + _self33; break;
            case PY: _idxSw0 = _self30 - _self10; _idxSw1 = _self31 - _self11; _idxSw2 = _self32 - _self12; _idxSw3 = _self33 - _self13; break;
            case NZ: _idxSw0 = _self20; _idxSw1 = _self21; _idxSw2 = _self22; _idxSw3 = _self23; break;
            case PZ: _idxSw0 = _self30 - _self20; _idxSw1 = _self31 - _self21; _idxSw2 = _self32 - _self22; _idxSw3 = _self33 - _self23; break;
            default: throw new IllegalArgumentException("Unknown FrustumPlane: " + plane);
        }
        dest[destOffset + 0] = _idxSw0;
        dest[destOffset + 1] = _idxSw1;
        dest[destOffset + 2] = _idxSw2;
        dest[destOffset + 3] = _idxSw3;
        return dest;
    }

    public static float[] frustumRayDir_no(float[] dest, int destOffset, float[] src, int srcOffset, float x, float y) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = -_self01;
        float _t1 = -_self00;
        float _t8 = Math.fma(2.0f, x, -1.0f);
        float _t10 = Math.fma(2.0f, y, -1.0f);
        float _t40 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t41 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t42 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t43 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t44 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t45 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t46 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t47 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t48 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t49 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t50 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t51 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t52 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t53 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t54 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t55 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t56 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t57 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t74 = -(_self03 * _t48);
        float _t75 = -(_self01 * _t49);
        float _t80 = -(_self02 * _t55);
        float _t85 = -(_self03 * _t50);
        float _t98 = Math.fma(_self13, _t43, Math.fma(_self11, _t44, -(_self12 * _t45)));
        float _t104 = Math.fma(_self13, _t51, Math.fma(_self10, _t45, -(_self11 * _t56)));
        float _t107 = Math.fma(_self02, _t51, Math.fma(_self00, _t43, -(_self01 * _t52))) * _t10;
        float _t109 = Math.fma(_self03, _t52, Math.fma(_self00, _t44, -(_self02 * _t56))) * _t10;
        float _t112 = -(Math.fma(_self03, _t43, Math.fma(_self01, _t44, -(_self02 * _t45))) * _t10);
        float _t113 = -(Math.fma(_self12, _t51, Math.fma(_self10, _t43, -(_self11 * _t52))) * _t8);
        float _t114 = -(Math.fma(_self13, _t52, Math.fma(_self10, _t44, -(_self12 * _t56))) * _t8);
        float _t115 = -(Math.fma(_self03, _t51, Math.fma(_self00, _t45, -(_self01 * _t56))) * _t10);
        float _t124 = Math.fma(_self00, _t42, -(_self01 * _t53)) + Math.fma(_self02, _t54, _t107) + (Math.fma(_self00, _t48, _t113) + Math.fma(_self02, _t50, _t75));
        float _t124_inv = 1.0f / _t124;
        float _t125 = Math.fma(_self00, _t48, _t75) + Math.fma(_self02, _t50, _t107) + (Math.fma(_t1, _t42, _t113) + Math.fma(_self01, _t53, -(_self02 * _t54)));
        float _t129 = Math.abs(_t125) <= Math.abs(_t124) * 9.536743E-7f ? _t124 : _t125;
        float _t129_inv = 1.0f / _t129;
        dest[destOffset + 0] = (Math.fma(_self01, _t40, -(_self02 * _t41)) + Math.fma(_self03, _t42, _t98 * _t8) + (Math.fma(_t0, _t46, _t112) + Math.fma(_self02, _t47, _t74 - _t125 * (Math.fma(_t98, _t8, _t112) + Math.fma(_self02, _t41, -(_self01 * _t40)) + (Math.fma(_t0, _t46, -(_self03 * _t42)) + Math.fma(_self02, _t47, _t74))) * _t124_inv))) * _t129_inv;
        dest[destOffset + 1] = (Math.fma(_self00, _t46, _t80) + Math.fma(_self03, _t49, _t109) + (Math.fma(_t1, _t40, _t114) + Math.fma(_self02, _t57, -(_self03 * _t53) - (Math.fma(_self00, _t40, -(_self02 * _t57)) + Math.fma(_self03, _t53, _t109) + (Math.fma(_self00, _t46, _t114) + Math.fma(_self03, _t49, _t80))) * _t125 * _t124_inv))) * _t129_inv;
        dest[destOffset + 2] = (Math.fma(_self00, _t41, -(_self01 * _t57)) + Math.fma(_self03, _t54, _t104 * _t8) + (Math.fma(_t1, _t47, _t115) + Math.fma(_self01, _t55, _t85 - _t125 * (Math.fma(_t104, _t8, _t115) + Math.fma(_self01, _t57, -(_self00 * _t41)) + (Math.fma(_t1, _t47, -(_self03 * _t54)) + Math.fma(_self01, _t55, _t85))) * _t124_inv))) * _t129_inv;
        return dest;
    }

    public static float[] frustumRayDir_zo(float[] dest, int destOffset, float[] src, int srcOffset, float x, float y) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = -_self00;
        float _t7 = Math.fma(2.0f, x, -1.0f);
        float _t9 = Math.fma(2.0f, y, -1.0f);
        float _t39 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t40 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t41 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t42 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t43 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t44 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t45 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t46 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t47 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t48 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t49 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t50 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t51 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t52 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t53 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t54 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t55 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t56 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t81 = Math.fma(_self00, _t47, -(_self01 * _t48));
        float _t85 = Math.fma(_self00, _t45, -(_self02 * _t54));
        float _t90 = Math.fma(_self13, _t42, Math.fma(_self11, _t43, -(_self12 * _t44)));
        float _t92 = Math.fma(_self02, _t50, Math.fma(_self00, _t42, -(_self01 * _t51)));
        float _t95 = Math.fma(_self03, _t51, Math.fma(_self00, _t43, -(_self02 * _t55)));
        float _t97 = Math.fma(_self13, _t50, Math.fma(_self10, _t44, -(_self11 * _t55)));
        float _t104 = -(Math.fma(_self03, _t42, Math.fma(_self01, _t43, -(_self02 * _t44))) * _t9);
        float _t105 = -(Math.fma(_self12, _t50, Math.fma(_self10, _t42, -(_self11 * _t51))) * _t7);
        float _t106 = -(Math.fma(_self13, _t51, Math.fma(_self10, _t43, -(_self12 * _t55))) * _t7);
        float _t107 = -(Math.fma(_self03, _t50, Math.fma(_self00, _t44, -(_self01 * _t55))) * _t9);
        float _t113 = Math.fma(_self02, _t49, _t81) + Math.fma(_t92, _t9, _t105);
        float _t113_inv = 1.0f / _t113;
        float _t116 = _t81 + Math.fma(_self02, _t49, _t92 * _t9) + (Math.fma(_t0, _t41, _t105) + Math.fma(_self01, _t52, -(_self02 * _t53)));
        float _t118 = Math.abs(_t116) <= Math.abs(_t113) * 9.536743E-7f ? _t113 : _t116;
        float _t118_inv = 1.0f / _t118;
        dest[destOffset + 0] = (Math.fma(_self01, _t39, -(_self02 * _t40)) + Math.fma(_self03, _t41, _t90 * _t7) + (Math.fma(-_self01, _t45, _t104) + Math.fma(_self02, _t46, -(_self03 * _t47) - _t116 * (Math.fma(_t90, _t7, _t104) - Math.fma(_self03, _t47, Math.fma(_self01, _t45, -(_self02 * _t46)))) * _t113_inv))) * _t118_inv;
        dest[destOffset + 1] = (_t85 + Math.fma(_self03, _t48, _t95 * _t9) + (Math.fma(_t0, _t39, _t106) + Math.fma(_self02, _t56, -(_self03 * _t52) - _t116 * (Math.fma(_self03, _t48, _t85) + Math.fma(_t95, _t9, _t106)) * _t113_inv))) * _t118_inv;
        dest[destOffset + 2] = (Math.fma(_self00, _t40, -(_self01 * _t56)) + Math.fma(_self03, _t53, _t97 * _t7) + (Math.fma(_t0, _t46, _t107) + Math.fma(_self01, _t54, -(_self03 * _t49) - _t116 * (Math.fma(_t97, _t7, _t107) - Math.fma(_self03, _t49, Math.fma(_self00, _t46, -(_self01 * _t54)))) * _t113_inv))) * _t118_inv;
        return dest;
    }

    public static float testAabb_no(float[] src, int srcOffset, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = _self00 + _self30;
        float _t1 = _self01 + _self31;
        float _t2 = _self02 + _self32;
        float _t3 = _self30 - _self00;
        float _t4 = _self31 - _self01;
        float _t5 = _self32 - _self02;
        float _t6 = _self10 + _self30;
        float _t7 = _self11 + _self31;
        float _t8 = _self12 + _self32;
        float _t9 = _self30 - _self10;
        float _t10 = _self31 - _self11;
        float _t11 = _self32 - _self12;
        float _t12 = _self20 + _self30;
        float _t13 = _self21 + _self31;
        float _t14 = _self22 + _self32;
        float _t15 = _self30 - _self20;
        float _t16 = _self31 - _self21;
        float _t17 = _self32 - _self22;
        return Math.fma(_t0, _t0 >= 0.0f ? maxX : minX, Math.fma(_t1, _t1 >= 0.0f ? maxY : minY, Math.fma(_t2, _t2 >= 0.0f ? maxZ : minZ, _self03 + _self33))) < 0.0f ? 0.0f : Math.fma(_t3, _t3 >= 0.0f ? maxX : minX, Math.fma(_t4, _t4 >= 0.0f ? maxY : minY, Math.fma(_t5, _t5 >= 0.0f ? maxZ : minZ, _self33 - _self03))) < 0.0f ? 0.0f : Math.fma(_t6, _t6 >= 0.0f ? maxX : minX, Math.fma(_t7, _t7 >= 0.0f ? maxY : minY, Math.fma(_t8, _t8 >= 0.0f ? maxZ : minZ, _self13 + _self33))) < 0.0f ? 0.0f : Math.fma(_t9, _t9 >= 0.0f ? maxX : minX, Math.fma(_t10, _t10 >= 0.0f ? maxY : minY, Math.fma(_t11, _t11 >= 0.0f ? maxZ : minZ, _self33 - _self13))) < 0.0f ? 0.0f : Math.fma(_t12, _t12 >= 0.0f ? maxX : minX, Math.fma(_t13, _t13 >= 0.0f ? maxY : minY, Math.fma(_t14, _t14 >= 0.0f ? maxZ : minZ, _self23 + _self33))) < 0.0f ? 0.0f : Math.fma(_t15, _t15 >= 0.0f ? maxX : minX, Math.fma(_t16, _t16 >= 0.0f ? maxY : minY, Math.fma(_t17, _t17 >= 0.0f ? maxZ : minZ, _self33 - _self23))) < 0.0f ? 0.0f : 1.0f;
    }

    public static float testAabb_zo(float[] src, int srcOffset, float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = _self00 + _self30;
        float _t1 = _self01 + _self31;
        float _t2 = _self02 + _self32;
        float _t3 = _self30 - _self00;
        float _t4 = _self31 - _self01;
        float _t5 = _self32 - _self02;
        float _t6 = _self10 + _self30;
        float _t7 = _self11 + _self31;
        float _t8 = _self12 + _self32;
        float _t9 = _self30 - _self10;
        float _t10 = _self31 - _self11;
        float _t11 = _self32 - _self12;
        float _t12 = _self30 - _self20;
        float _t13 = _self31 - _self21;
        float _t14 = _self32 - _self22;
        return Math.fma(_t0, _t0 >= 0.0f ? maxX : minX, Math.fma(_t1, _t1 >= 0.0f ? maxY : minY, Math.fma(_t2, _t2 >= 0.0f ? maxZ : minZ, _self03 + _self33))) < 0.0f ? 0.0f : Math.fma(_t3, _t3 >= 0.0f ? maxX : minX, Math.fma(_t4, _t4 >= 0.0f ? maxY : minY, Math.fma(_t5, _t5 >= 0.0f ? maxZ : minZ, _self33 - _self03))) < 0.0f ? 0.0f : Math.fma(_t6, _t6 >= 0.0f ? maxX : minX, Math.fma(_t7, _t7 >= 0.0f ? maxY : minY, Math.fma(_t8, _t8 >= 0.0f ? maxZ : minZ, _self13 + _self33))) < 0.0f ? 0.0f : Math.fma(_t9, _t9 >= 0.0f ? maxX : minX, Math.fma(_t10, _t10 >= 0.0f ? maxY : minY, Math.fma(_t11, _t11 >= 0.0f ? maxZ : minZ, _self33 - _self13))) < 0.0f ? 0.0f : Math.fma(_self20, _self20 >= 0.0f ? maxX : minX, Math.fma(_self21, _self21 >= 0.0f ? maxY : minY, Math.fma(_self22, _self22 >= 0.0f ? maxZ : minZ, _self23))) < 0.0f ? 0.0f : Math.fma(_t12, _t12 >= 0.0f ? maxX : minX, Math.fma(_t13, _t13 >= 0.0f ? maxY : minY, Math.fma(_t14, _t14 >= 0.0f ? maxZ : minZ, _self33 - _self23))) < 0.0f ? 0.0f : 1.0f;
    }

    public static float testAabb_no(float[] src, int srcOffset, float[] min, int minOffset, float[] max, int maxOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _minx = min[minOffset + 0];
        float _miny = min[minOffset + 1];
        float _minz = min[minOffset + 2];
        float _maxx = max[maxOffset + 0];
        float _maxy = max[maxOffset + 1];
        float _maxz = max[maxOffset + 2];
        float _t0 = _self00 + _self30;
        float _t1 = _self01 + _self31;
        float _t2 = _self02 + _self32;
        float _t3 = _self30 - _self00;
        float _t4 = _self31 - _self01;
        float _t5 = _self32 - _self02;
        float _t6 = _self10 + _self30;
        float _t7 = _self11 + _self31;
        float _t8 = _self12 + _self32;
        float _t9 = _self30 - _self10;
        float _t10 = _self31 - _self11;
        float _t11 = _self32 - _self12;
        float _t12 = _self20 + _self30;
        float _t13 = _self21 + _self31;
        float _t14 = _self22 + _self32;
        float _t15 = _self30 - _self20;
        float _t16 = _self31 - _self21;
        float _t17 = _self32 - _self22;
        return Math.fma(_t0, _t0 >= 0.0f ? _maxx : _minx, Math.fma(_t1, _t1 >= 0.0f ? _maxy : _miny, Math.fma(_t2, _t2 >= 0.0f ? _maxz : _minz, _self03 + _self33))) < 0.0f ? 0.0f : Math.fma(_t3, _t3 >= 0.0f ? _maxx : _minx, Math.fma(_t4, _t4 >= 0.0f ? _maxy : _miny, Math.fma(_t5, _t5 >= 0.0f ? _maxz : _minz, _self33 - _self03))) < 0.0f ? 0.0f : Math.fma(_t6, _t6 >= 0.0f ? _maxx : _minx, Math.fma(_t7, _t7 >= 0.0f ? _maxy : _miny, Math.fma(_t8, _t8 >= 0.0f ? _maxz : _minz, _self13 + _self33))) < 0.0f ? 0.0f : Math.fma(_t9, _t9 >= 0.0f ? _maxx : _minx, Math.fma(_t10, _t10 >= 0.0f ? _maxy : _miny, Math.fma(_t11, _t11 >= 0.0f ? _maxz : _minz, _self33 - _self13))) < 0.0f ? 0.0f : Math.fma(_t12, _t12 >= 0.0f ? _maxx : _minx, Math.fma(_t13, _t13 >= 0.0f ? _maxy : _miny, Math.fma(_t14, _t14 >= 0.0f ? _maxz : _minz, _self23 + _self33))) < 0.0f ? 0.0f : Math.fma(_t15, _t15 >= 0.0f ? _maxx : _minx, Math.fma(_t16, _t16 >= 0.0f ? _maxy : _miny, Math.fma(_t17, _t17 >= 0.0f ? _maxz : _minz, _self33 - _self23))) < 0.0f ? 0.0f : 1.0f;
    }

    public static float testAabb_zo(float[] src, int srcOffset, float[] min, int minOffset, float[] max, int maxOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _minx = min[minOffset + 0];
        float _miny = min[minOffset + 1];
        float _minz = min[minOffset + 2];
        float _maxx = max[maxOffset + 0];
        float _maxy = max[maxOffset + 1];
        float _maxz = max[maxOffset + 2];
        float _t0 = _self00 + _self30;
        float _t1 = _self01 + _self31;
        float _t2 = _self02 + _self32;
        float _t3 = _self30 - _self00;
        float _t4 = _self31 - _self01;
        float _t5 = _self32 - _self02;
        float _t6 = _self10 + _self30;
        float _t7 = _self11 + _self31;
        float _t8 = _self12 + _self32;
        float _t9 = _self30 - _self10;
        float _t10 = _self31 - _self11;
        float _t11 = _self32 - _self12;
        float _t12 = _self30 - _self20;
        float _t13 = _self31 - _self21;
        float _t14 = _self32 - _self22;
        return Math.fma(_t0, _t0 >= 0.0f ? _maxx : _minx, Math.fma(_t1, _t1 >= 0.0f ? _maxy : _miny, Math.fma(_t2, _t2 >= 0.0f ? _maxz : _minz, _self03 + _self33))) < 0.0f ? 0.0f : Math.fma(_t3, _t3 >= 0.0f ? _maxx : _minx, Math.fma(_t4, _t4 >= 0.0f ? _maxy : _miny, Math.fma(_t5, _t5 >= 0.0f ? _maxz : _minz, _self33 - _self03))) < 0.0f ? 0.0f : Math.fma(_t6, _t6 >= 0.0f ? _maxx : _minx, Math.fma(_t7, _t7 >= 0.0f ? _maxy : _miny, Math.fma(_t8, _t8 >= 0.0f ? _maxz : _minz, _self13 + _self33))) < 0.0f ? 0.0f : Math.fma(_t9, _t9 >= 0.0f ? _maxx : _minx, Math.fma(_t10, _t10 >= 0.0f ? _maxy : _miny, Math.fma(_t11, _t11 >= 0.0f ? _maxz : _minz, _self33 - _self13))) < 0.0f ? 0.0f : Math.fma(_self20, _self20 >= 0.0f ? _maxx : _minx, Math.fma(_self21, _self21 >= 0.0f ? _maxy : _miny, Math.fma(_self22, _self22 >= 0.0f ? _maxz : _minz, _self23))) < 0.0f ? 0.0f : Math.fma(_t12, _t12 >= 0.0f ? _maxx : _minx, Math.fma(_t13, _t13 >= 0.0f ? _maxy : _miny, Math.fma(_t14, _t14 >= 0.0f ? _maxz : _minz, _self33 - _self23))) < 0.0f ? 0.0f : 1.0f;
    }

    public static float testPoint_no(float[] src, int srcOffset, float pointX, float pointY, float pointZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        return Math.fma(pointX, _self00 + _self30, Math.fma(pointY, _self01 + _self31, Math.fma(pointZ, _self02 + _self32, _self03 + _self33))) < 0.0f ? 0.0f : Math.fma(pointX, _self30 - _self00, Math.fma(pointY, _self31 - _self01, Math.fma(pointZ, _self32 - _self02, _self33 - _self03))) < 0.0f ? 0.0f : Math.fma(pointX, _self10 + _self30, Math.fma(pointY, _self11 + _self31, Math.fma(pointZ, _self12 + _self32, _self13 + _self33))) < 0.0f ? 0.0f : Math.fma(pointX, _self30 - _self10, Math.fma(pointY, _self31 - _self11, Math.fma(pointZ, _self32 - _self12, _self33 - _self13))) < 0.0f ? 0.0f : Math.fma(pointX, _self20 + _self30, Math.fma(pointY, _self21 + _self31, Math.fma(pointZ, _self22 + _self32, _self23 + _self33))) < 0.0f ? 0.0f : Math.fma(pointX, _self30 - _self20, Math.fma(pointY, _self31 - _self21, Math.fma(pointZ, _self32 - _self22, _self33 - _self23))) < 0.0f ? 0.0f : 1.0f;
    }

    public static float testPoint_zo(float[] src, int srcOffset, float pointX, float pointY, float pointZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        return Math.fma(pointX, _self00 + _self30, Math.fma(pointY, _self01 + _self31, Math.fma(pointZ, _self02 + _self32, _self03 + _self33))) < 0.0f ? 0.0f : Math.fma(pointX, _self30 - _self00, Math.fma(pointY, _self31 - _self01, Math.fma(pointZ, _self32 - _self02, _self33 - _self03))) < 0.0f ? 0.0f : Math.fma(pointX, _self10 + _self30, Math.fma(pointY, _self11 + _self31, Math.fma(pointZ, _self12 + _self32, _self13 + _self33))) < 0.0f ? 0.0f : Math.fma(pointX, _self30 - _self10, Math.fma(pointY, _self31 - _self11, Math.fma(pointZ, _self32 - _self12, _self33 - _self13))) < 0.0f ? 0.0f : Math.fma(pointX, _self20, Math.fma(pointY, _self21, Math.fma(pointZ, _self22, _self23))) < 0.0f ? 0.0f : Math.fma(pointX, _self30 - _self20, Math.fma(pointY, _self31 - _self21, Math.fma(pointZ, _self32 - _self22, _self33 - _self23))) < 0.0f ? 0.0f : 1.0f;
    }

    public static float testPoint_no(float[] src, int srcOffset, float[] point, int pointOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _pointx = point[pointOffset + 0];
        float _pointy = point[pointOffset + 1];
        float _pointz = point[pointOffset + 2];
        return Math.fma(_pointx, _self00 + _self30, Math.fma(_pointy, _self01 + _self31, Math.fma(_pointz, _self02 + _self32, _self03 + _self33))) < 0.0f ? 0.0f : Math.fma(_pointx, _self30 - _self00, Math.fma(_pointy, _self31 - _self01, Math.fma(_pointz, _self32 - _self02, _self33 - _self03))) < 0.0f ? 0.0f : Math.fma(_pointx, _self10 + _self30, Math.fma(_pointy, _self11 + _self31, Math.fma(_pointz, _self12 + _self32, _self13 + _self33))) < 0.0f ? 0.0f : Math.fma(_pointx, _self30 - _self10, Math.fma(_pointy, _self31 - _self11, Math.fma(_pointz, _self32 - _self12, _self33 - _self13))) < 0.0f ? 0.0f : Math.fma(_pointx, _self20 + _self30, Math.fma(_pointy, _self21 + _self31, Math.fma(_pointz, _self22 + _self32, _self23 + _self33))) < 0.0f ? 0.0f : Math.fma(_pointx, _self30 - _self20, Math.fma(_pointy, _self31 - _self21, Math.fma(_pointz, _self32 - _self22, _self33 - _self23))) < 0.0f ? 0.0f : 1.0f;
    }

    public static float testPoint_zo(float[] src, int srcOffset, float[] point, int pointOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _pointx = point[pointOffset + 0];
        float _pointy = point[pointOffset + 1];
        float _pointz = point[pointOffset + 2];
        return Math.fma(_pointx, _self00 + _self30, Math.fma(_pointy, _self01 + _self31, Math.fma(_pointz, _self02 + _self32, _self03 + _self33))) < 0.0f ? 0.0f : Math.fma(_pointx, _self30 - _self00, Math.fma(_pointy, _self31 - _self01, Math.fma(_pointz, _self32 - _self02, _self33 - _self03))) < 0.0f ? 0.0f : Math.fma(_pointx, _self10 + _self30, Math.fma(_pointy, _self11 + _self31, Math.fma(_pointz, _self12 + _self32, _self13 + _self33))) < 0.0f ? 0.0f : Math.fma(_pointx, _self30 - _self10, Math.fma(_pointy, _self31 - _self11, Math.fma(_pointz, _self32 - _self12, _self33 - _self13))) < 0.0f ? 0.0f : Math.fma(_pointx, _self20, Math.fma(_pointy, _self21, Math.fma(_pointz, _self22, _self23))) < 0.0f ? 0.0f : Math.fma(_pointx, _self30 - _self20, Math.fma(_pointy, _self31 - _self21, Math.fma(_pointz, _self32 - _self22, _self33 - _self23))) < 0.0f ? 0.0f : 1.0f;
    }

    public static float testSphere_no(float[] src, int srcOffset, float centerX, float centerY, float centerZ, float radius) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = radius * radius;
        float _t1 = _self00 + _self30;
        float _t2 = _self01 + _self31;
        float _t3 = _self02 + _self32;
        float _t5 = _self30 - _self00;
        float _t6 = _self31 - _self01;
        float _t7 = _self32 - _self02;
        float _t9 = _self10 + _self30;
        float _t10 = _self11 + _self31;
        float _t11 = _self12 + _self32;
        float _t13 = _self30 - _self10;
        float _t14 = _self31 - _self11;
        float _t15 = _self32 - _self12;
        float _t17 = _self20 + _self30;
        float _t18 = _self21 + _self31;
        float _t19 = _self22 + _self32;
        float _t21 = _self30 - _self20;
        float _t22 = _self31 - _self21;
        float _t23 = _self32 - _self22;
        float _t47 = Math.fma(centerX, _t1, Math.fma(centerY, _t2, Math.fma(centerZ, _t3, _self03 + _self33)));
        float _t48 = Math.fma(centerX, _t5, Math.fma(centerY, _t6, Math.fma(centerZ, _t7, _self33 - _self03)));
        float _t49 = Math.fma(centerX, _t9, Math.fma(centerY, _t10, Math.fma(centerZ, _t11, _self13 + _self33)));
        float _t50 = Math.fma(centerX, _t13, Math.fma(centerY, _t14, Math.fma(centerZ, _t15, _self33 - _self13)));
        float _t51 = Math.fma(centerX, _t17, Math.fma(centerY, _t18, Math.fma(centerZ, _t19, _self23 + _self33)));
        float _t52 = Math.fma(centerX, _t21, Math.fma(centerY, _t22, Math.fma(centerZ, _t23, _self33 - _self23)));
        float _t69 = _t52 < 0.0f ? _t52 * _t52 > Math.fma(_t23, _t23, Math.fma(_t21, _t21, _t22 * _t22)) * _t0 ? 0.0f : 1.0f : 1.0f;
        float _t71 = _t51 < 0.0f ? _t51 * _t51 > Math.fma(_t19, _t19, Math.fma(_t17, _t17, _t18 * _t18)) * _t0 ? 0.0f : _t69 : _t69;
        float _t73 = _t50 < 0.0f ? _t50 * _t50 > Math.fma(_t15, _t15, Math.fma(_t13, _t13, _t14 * _t14)) * _t0 ? 0.0f : _t71 : _t71;
        float _t75 = _t49 < 0.0f ? _t49 * _t49 > Math.fma(_t11, _t11, Math.fma(_t9, _t9, _t10 * _t10)) * _t0 ? 0.0f : _t73 : _t73;
        float _t77 = _t48 < 0.0f ? _t48 * _t48 > Math.fma(_t7, _t7, Math.fma(_t5, _t5, _t6 * _t6)) * _t0 ? 0.0f : _t75 : _t75;
        return _t47 < 0.0f ? _t47 * _t47 > Math.fma(_t3, _t3, Math.fma(_t1, _t1, _t2 * _t2)) * _t0 ? 0.0f : _t77 : _t77;
    }

    public static float testSphere_zo(float[] src, int srcOffset, float centerX, float centerY, float centerZ, float radius) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = radius * radius;
        float _t1 = _self00 + _self30;
        float _t2 = _self01 + _self31;
        float _t3 = _self02 + _self32;
        float _t5 = _self30 - _self00;
        float _t6 = _self31 - _self01;
        float _t7 = _self32 - _self02;
        float _t9 = _self10 + _self30;
        float _t10 = _self11 + _self31;
        float _t11 = _self12 + _self32;
        float _t13 = _self30 - _self10;
        float _t14 = _self31 - _self11;
        float _t15 = _self32 - _self12;
        float _t18 = _self30 - _self20;
        float _t19 = _self31 - _self21;
        float _t20 = _self32 - _self22;
        float _t35 = Math.fma(centerX, _self20, Math.fma(centerY, _self21, Math.fma(centerZ, _self22, _self23)));
        float _t46 = Math.fma(centerX, _t1, Math.fma(centerY, _t2, Math.fma(centerZ, _t3, _self03 + _self33)));
        float _t47 = Math.fma(centerX, _t5, Math.fma(centerY, _t6, Math.fma(centerZ, _t7, _self33 - _self03)));
        float _t48 = Math.fma(centerX, _t9, Math.fma(centerY, _t10, Math.fma(centerZ, _t11, _self13 + _self33)));
        float _t49 = Math.fma(centerX, _t13, Math.fma(centerY, _t14, Math.fma(centerZ, _t15, _self33 - _self13)));
        float _t50 = Math.fma(centerX, _t18, Math.fma(centerY, _t19, Math.fma(centerZ, _t20, _self33 - _self23)));
        float _t65 = _t50 < 0.0f ? _t50 * _t50 > Math.fma(_t20, _t20, Math.fma(_t18, _t18, _t19 * _t19)) * _t0 ? 0.0f : 1.0f : 1.0f;
        float _t67 = _t35 < 0.0f ? _t35 * _t35 > Math.fma(_self22, _self22, Math.fma(_self20, _self20, _self21 * _self21)) * _t0 ? 0.0f : _t65 : _t65;
        float _t69 = _t49 < 0.0f ? _t49 * _t49 > Math.fma(_t15, _t15, Math.fma(_t13, _t13, _t14 * _t14)) * _t0 ? 0.0f : _t67 : _t67;
        float _t71 = _t48 < 0.0f ? _t48 * _t48 > Math.fma(_t11, _t11, Math.fma(_t9, _t9, _t10 * _t10)) * _t0 ? 0.0f : _t69 : _t69;
        float _t73 = _t47 < 0.0f ? _t47 * _t47 > Math.fma(_t7, _t7, Math.fma(_t5, _t5, _t6 * _t6)) * _t0 ? 0.0f : _t71 : _t71;
        return _t46 < 0.0f ? _t46 * _t46 > Math.fma(_t3, _t3, Math.fma(_t1, _t1, _t2 * _t2)) * _t0 ? 0.0f : _t73 : _t73;
    }

    public static float testSphere_no(float[] src, int srcOffset, float[] center, int centerOffset, float radius) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _centerx = center[centerOffset + 0];
        float _centery = center[centerOffset + 1];
        float _centerz = center[centerOffset + 2];
        float _t0 = radius * radius;
        float _t1 = _self00 + _self30;
        float _t2 = _self01 + _self31;
        float _t3 = _self02 + _self32;
        float _t5 = _self30 - _self00;
        float _t6 = _self31 - _self01;
        float _t7 = _self32 - _self02;
        float _t9 = _self10 + _self30;
        float _t10 = _self11 + _self31;
        float _t11 = _self12 + _self32;
        float _t13 = _self30 - _self10;
        float _t14 = _self31 - _self11;
        float _t15 = _self32 - _self12;
        float _t17 = _self20 + _self30;
        float _t18 = _self21 + _self31;
        float _t19 = _self22 + _self32;
        float _t21 = _self30 - _self20;
        float _t22 = _self31 - _self21;
        float _t23 = _self32 - _self22;
        float _t47 = Math.fma(_centerx, _t1, Math.fma(_centery, _t2, Math.fma(_centerz, _t3, _self03 + _self33)));
        float _t48 = Math.fma(_centerx, _t5, Math.fma(_centery, _t6, Math.fma(_centerz, _t7, _self33 - _self03)));
        float _t49 = Math.fma(_centerx, _t9, Math.fma(_centery, _t10, Math.fma(_centerz, _t11, _self13 + _self33)));
        float _t50 = Math.fma(_centerx, _t13, Math.fma(_centery, _t14, Math.fma(_centerz, _t15, _self33 - _self13)));
        float _t51 = Math.fma(_centerx, _t17, Math.fma(_centery, _t18, Math.fma(_centerz, _t19, _self23 + _self33)));
        float _t52 = Math.fma(_centerx, _t21, Math.fma(_centery, _t22, Math.fma(_centerz, _t23, _self33 - _self23)));
        float _t69 = _t52 < 0.0f ? _t52 * _t52 > Math.fma(_t23, _t23, Math.fma(_t21, _t21, _t22 * _t22)) * _t0 ? 0.0f : 1.0f : 1.0f;
        float _t71 = _t51 < 0.0f ? _t51 * _t51 > Math.fma(_t19, _t19, Math.fma(_t17, _t17, _t18 * _t18)) * _t0 ? 0.0f : _t69 : _t69;
        float _t73 = _t50 < 0.0f ? _t50 * _t50 > Math.fma(_t15, _t15, Math.fma(_t13, _t13, _t14 * _t14)) * _t0 ? 0.0f : _t71 : _t71;
        float _t75 = _t49 < 0.0f ? _t49 * _t49 > Math.fma(_t11, _t11, Math.fma(_t9, _t9, _t10 * _t10)) * _t0 ? 0.0f : _t73 : _t73;
        float _t77 = _t48 < 0.0f ? _t48 * _t48 > Math.fma(_t7, _t7, Math.fma(_t5, _t5, _t6 * _t6)) * _t0 ? 0.0f : _t75 : _t75;
        return _t47 < 0.0f ? _t47 * _t47 > Math.fma(_t3, _t3, Math.fma(_t1, _t1, _t2 * _t2)) * _t0 ? 0.0f : _t77 : _t77;
    }

    public static float testSphere_zo(float[] src, int srcOffset, float[] center, int centerOffset, float radius) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _centerx = center[centerOffset + 0];
        float _centery = center[centerOffset + 1];
        float _centerz = center[centerOffset + 2];
        float _t0 = radius * radius;
        float _t1 = _self00 + _self30;
        float _t2 = _self01 + _self31;
        float _t3 = _self02 + _self32;
        float _t5 = _self30 - _self00;
        float _t6 = _self31 - _self01;
        float _t7 = _self32 - _self02;
        float _t9 = _self10 + _self30;
        float _t10 = _self11 + _self31;
        float _t11 = _self12 + _self32;
        float _t13 = _self30 - _self10;
        float _t14 = _self31 - _self11;
        float _t15 = _self32 - _self12;
        float _t18 = _self30 - _self20;
        float _t19 = _self31 - _self21;
        float _t20 = _self32 - _self22;
        float _t35 = Math.fma(_centerx, _self20, Math.fma(_centery, _self21, Math.fma(_centerz, _self22, _self23)));
        float _t46 = Math.fma(_centerx, _t1, Math.fma(_centery, _t2, Math.fma(_centerz, _t3, _self03 + _self33)));
        float _t47 = Math.fma(_centerx, _t5, Math.fma(_centery, _t6, Math.fma(_centerz, _t7, _self33 - _self03)));
        float _t48 = Math.fma(_centerx, _t9, Math.fma(_centery, _t10, Math.fma(_centerz, _t11, _self13 + _self33)));
        float _t49 = Math.fma(_centerx, _t13, Math.fma(_centery, _t14, Math.fma(_centerz, _t15, _self33 - _self13)));
        float _t50 = Math.fma(_centerx, _t18, Math.fma(_centery, _t19, Math.fma(_centerz, _t20, _self33 - _self23)));
        float _t65 = _t50 < 0.0f ? _t50 * _t50 > Math.fma(_t20, _t20, Math.fma(_t18, _t18, _t19 * _t19)) * _t0 ? 0.0f : 1.0f : 1.0f;
        float _t67 = _t35 < 0.0f ? _t35 * _t35 > Math.fma(_self22, _self22, Math.fma(_self20, _self20, _self21 * _self21)) * _t0 ? 0.0f : _t65 : _t65;
        float _t69 = _t49 < 0.0f ? _t49 * _t49 > Math.fma(_t15, _t15, Math.fma(_t13, _t13, _t14 * _t14)) * _t0 ? 0.0f : _t67 : _t67;
        float _t71 = _t48 < 0.0f ? _t48 * _t48 > Math.fma(_t11, _t11, Math.fma(_t9, _t9, _t10 * _t10)) * _t0 ? 0.0f : _t69 : _t69;
        float _t73 = _t47 < 0.0f ? _t47 * _t47 > Math.fma(_t7, _t7, Math.fma(_t5, _t5, _t6 * _t6)) * _t0 ? 0.0f : _t71 : _t71;
        return _t46 < 0.0f ? _t46 * _t46 > Math.fma(_t3, _t3, Math.fma(_t1, _t1, _t2 * _t2)) * _t0 ? 0.0f : _t73 : _t73;
    }

    public static float[] frustum_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = 2.0f * zNear;
        float _t1 = right - left;
        float _t1_inv = 1.0f / _t1;
        float _t2 = top - bottom;
        float _t2_inv = 1.0f / _t2;
        float _t4 = zNear - zFar;
        float _t4_inv = 1.0f / _t4;
        float _t5 = left + right;
        float _t6 = bottom + top;
        float _t16, _t17;
        if (zFar == Float.POSITIVE_INFINITY) {
            _t16 = 1.0f;
            _t17 = -_t0;
        } else {
            if (zNear == Float.POSITIVE_INFINITY) {
                _t16 = -1.0f;
                _t17 = 2.0f * zFar;
            } else {
                _t16 = -((zFar + zNear) * _t4_inv);
                _t17 = 2.0f * zFar * zNear * _t4_inv;
            }
        }
        dest[destOffset + 0] = _self00 * _t0 * _t1_inv;
        dest[destOffset + 1] = _self10 * _t0 * _t1_inv;
        dest[destOffset + 2] = _self20 * _t0 * _t1_inv;
        dest[destOffset + 3] = _self30 * _t0 * _t1_inv;
        dest[destOffset + 4] = _self01 * _t0 * _t2_inv;
        dest[destOffset + 5] = _self11 * _t0 * _t2_inv;
        dest[destOffset + 6] = _self21 * _t0 * _t2_inv;
        dest[destOffset + 7] = _self31 * _t0 * _t2_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t16, _self03 - _self00 * _t5 * _t1_inv - _self01 * _t6 * _t2_inv);
        dest[destOffset + 9] = Math.fma(_self12, _t16, _self13 - _self10 * _t5 * _t1_inv - _self11 * _t6 * _t2_inv);
        dest[destOffset + 10] = Math.fma(_self22, _t16, _self23 - _self20 * _t5 * _t1_inv - _self21 * _t6 * _t2_inv);
        dest[destOffset + 11] = Math.fma(_self32, _t16, _self33 - _self30 * _t5 * _t1_inv - _self31 * _t6 * _t2_inv);
        dest[destOffset + 12] = _self02 * _t17;
        dest[destOffset + 13] = _self12 * _t17;
        dest[destOffset + 14] = _self22 * _t17;
        dest[destOffset + 15] = _self32 * _t17;
        return dest;
    }

    public static float[] frustum_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = 2.0f * zNear;
        float _t1 = right - left;
        float _t1_inv = 1.0f / _t1;
        float _t2 = top - bottom;
        float _t2_inv = 1.0f / _t2;
        float _t4 = zNear - zFar;
        float _t4_inv = 1.0f / _t4;
        float _t5 = left + right;
        float _t6 = bottom + top;
        float _t14, _t16;
        if (zFar == Float.POSITIVE_INFINITY) {
            _t14 = -1.0f;
            _t16 = -_t0;
        } else {
            if (zNear == Float.POSITIVE_INFINITY) {
                _t14 = 1.0f;
                _t16 = 2.0f * zFar;
            } else {
                _t14 = (zFar + zNear) * _t4_inv;
                _t16 = 2.0f * zFar * zNear * _t4_inv;
            }
        }
        dest[destOffset + 0] = _self00 * _t0 * _t1_inv;
        dest[destOffset + 1] = _self10 * _t0 * _t1_inv;
        dest[destOffset + 2] = _self20 * _t0 * _t1_inv;
        dest[destOffset + 3] = _self30 * _t0 * _t1_inv;
        dest[destOffset + 4] = _self01 * _t0 * _t2_inv;
        dest[destOffset + 5] = _self11 * _t0 * _t2_inv;
        dest[destOffset + 6] = _self21 * _t0 * _t2_inv;
        dest[destOffset + 7] = _self31 * _t0 * _t2_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t14, _self00 * _t5 * _t1_inv + _self01 * _t6 * _t2_inv - _self03);
        dest[destOffset + 9] = Math.fma(_self12, _t14, _self10 * _t5 * _t1_inv + _self11 * _t6 * _t2_inv - _self13);
        dest[destOffset + 10] = Math.fma(_self22, _t14, _self20 * _t5 * _t1_inv + _self21 * _t6 * _t2_inv - _self23);
        dest[destOffset + 11] = Math.fma(_self32, _t14, _self30 * _t5 * _t1_inv + _self31 * _t6 * _t2_inv - _self33);
        dest[destOffset + 12] = _self02 * _t16;
        dest[destOffset + 13] = _self12 * _t16;
        dest[destOffset + 14] = _self22 * _t16;
        dest[destOffset + 15] = _self32 * _t16;
        return dest;
    }

    public static float[] frustum_no(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.frustum_no_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsArray.frustum_no_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static float[] frustum_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = 2.0f * zNear;
        float _t1 = right - left;
        float _t1_inv = 1.0f / _t1;
        float _t2 = top - bottom;
        float _t2_inv = 1.0f / _t2;
        float _t3 = zNear - zFar;
        float _t3_inv = 1.0f / _t3;
        float _t4 = left + right;
        float _t5 = bottom + top;
        float _t12, _t13;
        if (zFar == Float.POSITIVE_INFINITY) {
            _t12 = 1.0f;
            _t13 = -zNear;
        } else {
            if (zNear == Float.POSITIVE_INFINITY) {
                _t12 = 0.0f;
                _t13 = zFar;
            } else {
                _t12 = -(zFar * _t3_inv);
                _t13 = zFar * zNear * _t3_inv;
            }
        }
        dest[destOffset + 0] = _self00 * _t0 * _t1_inv;
        dest[destOffset + 1] = _self10 * _t0 * _t1_inv;
        dest[destOffset + 2] = _self20 * _t0 * _t1_inv;
        dest[destOffset + 3] = _self30 * _t0 * _t1_inv;
        dest[destOffset + 4] = _self01 * _t0 * _t2_inv;
        dest[destOffset + 5] = _self11 * _t0 * _t2_inv;
        dest[destOffset + 6] = _self21 * _t0 * _t2_inv;
        dest[destOffset + 7] = _self31 * _t0 * _t2_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t12, _self03 - _self00 * _t4 * _t1_inv - _self01 * _t5 * _t2_inv);
        dest[destOffset + 9] = Math.fma(_self12, _t12, _self13 - _self10 * _t4 * _t1_inv - _self11 * _t5 * _t2_inv);
        dest[destOffset + 10] = Math.fma(_self22, _t12, _self23 - _self20 * _t4 * _t1_inv - _self21 * _t5 * _t2_inv);
        dest[destOffset + 11] = Math.fma(_self32, _t12, _self33 - _self30 * _t4 * _t1_inv - _self31 * _t5 * _t2_inv);
        dest[destOffset + 12] = _self02 * _t13;
        dest[destOffset + 13] = _self12 * _t13;
        dest[destOffset + 14] = _self22 * _t13;
        dest[destOffset + 15] = _self32 * _t13;
        return dest;
    }

    public static float[] frustum_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = 2.0f * zNear;
        float _t1 = right - left;
        float _t1_inv = 1.0f / _t1;
        float _t2 = top - bottom;
        float _t2_inv = 1.0f / _t2;
        float _t3 = zNear - zFar;
        float _t3_inv = 1.0f / _t3;
        float _t4 = left + right;
        float _t5 = bottom + top;
        float _t11, _t12;
        if (zFar == Float.POSITIVE_INFINITY) {
            _t11 = -1.0f;
            _t12 = -zNear;
        } else {
            if (zNear == Float.POSITIVE_INFINITY) {
                _t11 = 0.0f;
                _t12 = zFar;
            } else {
                _t11 = zFar * _t3_inv;
                _t12 = zFar * zNear * _t3_inv;
            }
        }
        dest[destOffset + 0] = _self00 * _t0 * _t1_inv;
        dest[destOffset + 1] = _self10 * _t0 * _t1_inv;
        dest[destOffset + 2] = _self20 * _t0 * _t1_inv;
        dest[destOffset + 3] = _self30 * _t0 * _t1_inv;
        dest[destOffset + 4] = _self01 * _t0 * _t2_inv;
        dest[destOffset + 5] = _self11 * _t0 * _t2_inv;
        dest[destOffset + 6] = _self21 * _t0 * _t2_inv;
        dest[destOffset + 7] = _self31 * _t0 * _t2_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t11, _self00 * _t4 * _t1_inv + _self01 * _t5 * _t2_inv - _self03);
        dest[destOffset + 9] = Math.fma(_self12, _t11, _self10 * _t4 * _t1_inv + _self11 * _t5 * _t2_inv - _self13);
        dest[destOffset + 10] = Math.fma(_self22, _t11, _self20 * _t4 * _t1_inv + _self21 * _t5 * _t2_inv - _self23);
        dest[destOffset + 11] = Math.fma(_self32, _t11, _self30 * _t4 * _t1_inv + _self31 * _t5 * _t2_inv - _self33);
        dest[destOffset + 12] = _self02 * _t12;
        dest[destOffset + 13] = _self12 * _t12;
        dest[destOffset + 14] = _self22 * _t12;
        dest[destOffset + 15] = _self32 * _t12;
        return dest;
    }

    public static float[] frustum_zo(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.frustum_zo_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsArray.frustum_zo_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static float[] lookAt_lh(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = centerZ - eyeZ;
        float _t1 = centerX - eyeX;
        float _t2 = centerY - eyeY;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t21 = Math.fma(upX, _t11, -(upY * _t10));
        float _t22 = Math.fma(upY, _t12, -(upZ * _t11));
        float _t23 = Math.fma(upZ, _t10, -(upX * _t12));
        float _t24 = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        float _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32, _t33, _t34;
        if (_t27 > 0.0f) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0f;
            _t33 = 0.0f;
            _t34 = 0.0f;
        }
        float _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        float _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        float _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        float _t47 = Math.fma(eyeZ, _t33, Math.fma(eyeX, _t32, eyeY * _t34));
        float _t49 = Math.fma(eyeZ, _t45, Math.fma(eyeX, _t43, eyeY * _t44));
        dest[destOffset + 0] = Math.fma(_self02, _t10, Math.fma(_self00, _t32, _self01 * _t43));
        dest[destOffset + 1] = Math.fma(_self12, _t10, Math.fma(_self10, _t32, _self11 * _t43));
        dest[destOffset + 2] = Math.fma(_self22, _t10, Math.fma(_self20, _t32, _self21 * _t43));
        dest[destOffset + 3] = Math.fma(_self32, _t10, Math.fma(_self30, _t32, _self31 * _t43));
        dest[destOffset + 4] = Math.fma(_self02, _t11, Math.fma(_self00, _t34, _self01 * _t44));
        dest[destOffset + 5] = Math.fma(_self12, _t11, Math.fma(_self10, _t34, _self11 * _t44));
        dest[destOffset + 6] = Math.fma(_self22, _t11, Math.fma(_self20, _t34, _self21 * _t44));
        dest[destOffset + 7] = Math.fma(_self32, _t11, Math.fma(_self30, _t34, _self31 * _t44));
        dest[destOffset + 8] = Math.fma(_self02, _t12, Math.fma(_self00, _t33, _self01 * _t45));
        dest[destOffset + 9] = Math.fma(_self12, _t12, Math.fma(_self10, _t33, _self11 * _t45));
        dest[destOffset + 10] = Math.fma(_self22, _t12, Math.fma(_self20, _t33, _self21 * _t45));
        dest[destOffset + 11] = Math.fma(_self32, _t12, Math.fma(_self30, _t33, _self31 * _t45));
        dest[destOffset + 12] = Math.fma(-_self00, _t47, Math.fma(-_self01, _t49, Math.fma(-_self02, _t24, _self03)));
        dest[destOffset + 13] = Math.fma(-_self10, _t47, Math.fma(-_self11, _t49, Math.fma(-_self12, _t24, _self13)));
        dest[destOffset + 14] = Math.fma(-_self20, _t47, Math.fma(-_self21, _t49, Math.fma(-_self22, _t24, _self23)));
        dest[destOffset + 15] = Math.fma(-_self30, _t47, Math.fma(-_self31, _t49, Math.fma(-_self32, _t24, _self33)));
        return dest;
    }

    public static float[] lookAt_rh(float[] dest, int destOffset, float[] src, int srcOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = -_self02;
        float _t1 = -_self12;
        float _t2 = -_self22;
        float _t3 = -_self32;
        float _t4 = centerZ - eyeZ;
        float _t5 = centerX - eyeX;
        float _t6 = centerY - eyeY;
        float _t9 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, _t6 * _t6));
        float _t10 = (1.0f / (float) Math.sqrt(_t9));
        float _t14, _t15, _t16;
        if (_t9 > 0.0f) {
            _t14 = _t5 * _t10;
            _t15 = _t6 * _t10;
            _t16 = _t4 * _t10;
        } else {
            _t14 = 0.0f;
            _t15 = 0.0f;
            _t16 = 0.0f;
        }
        float _t25 = Math.fma(upY, _t14, -(upX * _t15));
        float _t26 = Math.fma(upX, _t16, -(upZ * _t14));
        float _t27 = Math.fma(upZ, _t15, -(upY * _t16));
        float _t28 = Math.fma(eyeZ, _t16, Math.fma(eyeX, _t14, eyeY * _t15));
        float _t31 = Math.fma(_t25, _t25, Math.fma(_t26, _t26, _t27 * _t27));
        float _t32 = (1.0f / (float) Math.sqrt(_t31));
        float _t36, _t37, _t38;
        if (_t31 > 0.0f) {
            _t36 = _t27 * _t32;
            _t37 = _t26 * _t32;
            _t38 = _t25 * _t32;
        } else {
            _t36 = 0.0f;
            _t37 = 0.0f;
            _t38 = 0.0f;
        }
        float _t47 = Math.fma(_t16, _t37, -(_t15 * _t38));
        float _t48 = Math.fma(_t14, _t38, -(_t16 * _t36));
        float _t49 = Math.fma(_t15, _t36, -(_t14 * _t37));
        float _t51 = Math.fma(eyeZ, _t38, Math.fma(eyeX, _t36, eyeY * _t37));
        float _t53 = Math.fma(eyeZ, _t49, Math.fma(eyeX, _t47, eyeY * _t48));
        dest[destOffset + 0] = Math.fma(_t0, _t14, Math.fma(_self00, _t36, _self01 * _t47));
        dest[destOffset + 1] = Math.fma(_t1, _t14, Math.fma(_self10, _t36, _self11 * _t47));
        dest[destOffset + 2] = Math.fma(_t2, _t14, Math.fma(_self20, _t36, _self21 * _t47));
        dest[destOffset + 3] = Math.fma(_t3, _t14, Math.fma(_self30, _t36, _self31 * _t47));
        dest[destOffset + 4] = Math.fma(_t0, _t15, Math.fma(_self00, _t37, _self01 * _t48));
        dest[destOffset + 5] = Math.fma(_t1, _t15, Math.fma(_self10, _t37, _self11 * _t48));
        dest[destOffset + 6] = Math.fma(_t2, _t15, Math.fma(_self20, _t37, _self21 * _t48));
        dest[destOffset + 7] = Math.fma(_t3, _t15, Math.fma(_self30, _t37, _self31 * _t48));
        dest[destOffset + 8] = Math.fma(_t0, _t16, Math.fma(_self00, _t38, _self01 * _t49));
        dest[destOffset + 9] = Math.fma(_t1, _t16, Math.fma(_self10, _t38, _self11 * _t49));
        dest[destOffset + 10] = Math.fma(_t2, _t16, Math.fma(_self20, _t38, _self21 * _t49));
        dest[destOffset + 11] = Math.fma(_t3, _t16, Math.fma(_self30, _t38, _self31 * _t49));
        dest[destOffset + 12] = Math.fma(-_self00, _t51, Math.fma(-_self01, _t53, Math.fma(_self02, _t28, _self03)));
        dest[destOffset + 13] = Math.fma(-_self10, _t51, Math.fma(-_self11, _t53, Math.fma(_self12, _t28, _self13)));
        dest[destOffset + 14] = Math.fma(-_self20, _t51, Math.fma(-_self21, _t53, Math.fma(_self22, _t28, _self23)));
        dest[destOffset + 15] = Math.fma(-_self30, _t51, Math.fma(-_self31, _t53, Math.fma(_self32, _t28, _self33)));
        return dest;
    }

    public static float[] lookAt_lh(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _centerx = center[centerOffset + 0];
        float _centery = center[centerOffset + 1];
        float _centerz = center[centerOffset + 2];
        float _upx = up[upOffset + 0];
        float _upy = up[upOffset + 1];
        float _upz = up[upOffset + 2];
        float _t0 = _centerz - _eyez;
        float _t1 = _centerx - _eyex;
        float _t2 = _centery - _eyey;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t21 = Math.fma(_upx, _t11, -(_upy * _t10));
        float _t22 = Math.fma(_upy, _t12, -(_upz * _t11));
        float _t23 = Math.fma(_upz, _t10, -(_upx * _t12));
        float _t24 = Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11));
        float _t27 = Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23));
        float _t28 = (1.0f / (float) Math.sqrt(_t27));
        float _t32, _t33, _t34;
        if (_t27 > 0.0f) {
            _t32 = _t22 * _t28;
            _t33 = _t21 * _t28;
            _t34 = _t23 * _t28;
        } else {
            _t32 = 0.0f;
            _t33 = 0.0f;
            _t34 = 0.0f;
        }
        float _t43 = Math.fma(_t11, _t33, -(_t12 * _t34));
        float _t44 = Math.fma(_t12, _t32, -(_t10 * _t33));
        float _t45 = Math.fma(_t10, _t34, -(_t11 * _t32));
        float _t47 = Math.fma(_eyez, _t33, Math.fma(_eyex, _t32, _eyey * _t34));
        float _t49 = Math.fma(_eyez, _t45, Math.fma(_eyex, _t43, _eyey * _t44));
        dest[destOffset + 0] = Math.fma(_self02, _t10, Math.fma(_self00, _t32, _self01 * _t43));
        dest[destOffset + 1] = Math.fma(_self12, _t10, Math.fma(_self10, _t32, _self11 * _t43));
        dest[destOffset + 2] = Math.fma(_self22, _t10, Math.fma(_self20, _t32, _self21 * _t43));
        dest[destOffset + 3] = Math.fma(_self32, _t10, Math.fma(_self30, _t32, _self31 * _t43));
        dest[destOffset + 4] = Math.fma(_self02, _t11, Math.fma(_self00, _t34, _self01 * _t44));
        dest[destOffset + 5] = Math.fma(_self12, _t11, Math.fma(_self10, _t34, _self11 * _t44));
        dest[destOffset + 6] = Math.fma(_self22, _t11, Math.fma(_self20, _t34, _self21 * _t44));
        dest[destOffset + 7] = Math.fma(_self32, _t11, Math.fma(_self30, _t34, _self31 * _t44));
        dest[destOffset + 8] = Math.fma(_self02, _t12, Math.fma(_self00, _t33, _self01 * _t45));
        dest[destOffset + 9] = Math.fma(_self12, _t12, Math.fma(_self10, _t33, _self11 * _t45));
        dest[destOffset + 10] = Math.fma(_self22, _t12, Math.fma(_self20, _t33, _self21 * _t45));
        dest[destOffset + 11] = Math.fma(_self32, _t12, Math.fma(_self30, _t33, _self31 * _t45));
        dest[destOffset + 12] = Math.fma(-_self00, _t47, Math.fma(-_self01, _t49, Math.fma(-_self02, _t24, _self03)));
        dest[destOffset + 13] = Math.fma(-_self10, _t47, Math.fma(-_self11, _t49, Math.fma(-_self12, _t24, _self13)));
        dest[destOffset + 14] = Math.fma(-_self20, _t47, Math.fma(-_self21, _t49, Math.fma(-_self22, _t24, _self23)));
        dest[destOffset + 15] = Math.fma(-_self30, _t47, Math.fma(-_self31, _t49, Math.fma(-_self32, _t24, _self33)));
        return dest;
    }

    public static float[] lookAt_rh(float[] dest, int destOffset, float[] src, int srcOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _centerx = center[centerOffset + 0];
        float _centery = center[centerOffset + 1];
        float _centerz = center[centerOffset + 2];
        float _upx = up[upOffset + 0];
        float _upy = up[upOffset + 1];
        float _upz = up[upOffset + 2];
        float _t0 = -_self02;
        float _t1 = -_self12;
        float _t2 = -_self22;
        float _t3 = -_self32;
        float _t4 = _centerz - _eyez;
        float _t5 = _centerx - _eyex;
        float _t6 = _centery - _eyey;
        float _t9 = Math.fma(_t4, _t4, Math.fma(_t5, _t5, _t6 * _t6));
        float _t10 = (1.0f / (float) Math.sqrt(_t9));
        float _t14, _t15, _t16;
        if (_t9 > 0.0f) {
            _t14 = _t5 * _t10;
            _t15 = _t6 * _t10;
            _t16 = _t4 * _t10;
        } else {
            _t14 = 0.0f;
            _t15 = 0.0f;
            _t16 = 0.0f;
        }
        float _t25 = Math.fma(_upy, _t14, -(_upx * _t15));
        float _t26 = Math.fma(_upx, _t16, -(_upz * _t14));
        float _t27 = Math.fma(_upz, _t15, -(_upy * _t16));
        float _t28 = Math.fma(_eyez, _t16, Math.fma(_eyex, _t14, _eyey * _t15));
        float _t31 = Math.fma(_t25, _t25, Math.fma(_t26, _t26, _t27 * _t27));
        float _t32 = (1.0f / (float) Math.sqrt(_t31));
        float _t36, _t37, _t38;
        if (_t31 > 0.0f) {
            _t36 = _t27 * _t32;
            _t37 = _t26 * _t32;
            _t38 = _t25 * _t32;
        } else {
            _t36 = 0.0f;
            _t37 = 0.0f;
            _t38 = 0.0f;
        }
        float _t47 = Math.fma(_t16, _t37, -(_t15 * _t38));
        float _t48 = Math.fma(_t14, _t38, -(_t16 * _t36));
        float _t49 = Math.fma(_t15, _t36, -(_t14 * _t37));
        float _t51 = Math.fma(_eyez, _t38, Math.fma(_eyex, _t36, _eyey * _t37));
        float _t53 = Math.fma(_eyez, _t49, Math.fma(_eyex, _t47, _eyey * _t48));
        dest[destOffset + 0] = Math.fma(_t0, _t14, Math.fma(_self00, _t36, _self01 * _t47));
        dest[destOffset + 1] = Math.fma(_t1, _t14, Math.fma(_self10, _t36, _self11 * _t47));
        dest[destOffset + 2] = Math.fma(_t2, _t14, Math.fma(_self20, _t36, _self21 * _t47));
        dest[destOffset + 3] = Math.fma(_t3, _t14, Math.fma(_self30, _t36, _self31 * _t47));
        dest[destOffset + 4] = Math.fma(_t0, _t15, Math.fma(_self00, _t37, _self01 * _t48));
        dest[destOffset + 5] = Math.fma(_t1, _t15, Math.fma(_self10, _t37, _self11 * _t48));
        dest[destOffset + 6] = Math.fma(_t2, _t15, Math.fma(_self20, _t37, _self21 * _t48));
        dest[destOffset + 7] = Math.fma(_t3, _t15, Math.fma(_self30, _t37, _self31 * _t48));
        dest[destOffset + 8] = Math.fma(_t0, _t16, Math.fma(_self00, _t38, _self01 * _t49));
        dest[destOffset + 9] = Math.fma(_t1, _t16, Math.fma(_self10, _t38, _self11 * _t49));
        dest[destOffset + 10] = Math.fma(_t2, _t16, Math.fma(_self20, _t38, _self21 * _t49));
        dest[destOffset + 11] = Math.fma(_t3, _t16, Math.fma(_self30, _t38, _self31 * _t49));
        dest[destOffset + 12] = Math.fma(-_self00, _t51, Math.fma(-_self01, _t53, Math.fma(_self02, _t28, _self03)));
        dest[destOffset + 13] = Math.fma(-_self10, _t51, Math.fma(-_self11, _t53, Math.fma(_self12, _t28, _self13)));
        dest[destOffset + 14] = Math.fma(-_self20, _t51, Math.fma(-_self21, _t53, Math.fma(_self22, _t28, _self23)));
        dest[destOffset + 15] = Math.fma(-_self30, _t51, Math.fma(-_self31, _t53, Math.fma(_self32, _t28, _self33)));
        return dest;
    }

    public static float[] makeFrustum_no_lh(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = 2.0f * zNear;
        float _t1 = right - left;
        float _t1_inv = 1.0f / _t1;
        float _t2 = top - bottom;
        float _t2_inv = 1.0f / _t2;
        float _t3 = zNear - zFar;
        float _t3_inv = 1.0f / _t3;
        if (zFar == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -_t0;
        } else {
            if (zNear == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = -1.0f;
                dest[destOffset + 14] = 2.0f * zFar;
            } else {
                dest[destOffset + 10] = -((zFar + zNear) * _t3_inv);
                dest[destOffset + 14] = 2.0f * zFar * zNear * _t3_inv;
            }
        }
        dest[destOffset + 0] = _t0 * _t1_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t0 * _t2_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = -((left + right) * _t1_inv);
        dest[destOffset + 9] = -((bottom + top) * _t2_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makeFrustum_no_rh(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = 2.0f * zNear;
        float _t1 = right - left;
        float _t1_inv = 1.0f / _t1;
        float _t2 = top - bottom;
        float _t2_inv = 1.0f / _t2;
        float _t3 = zNear - zFar;
        float _t3_inv = 1.0f / _t3;
        if (zFar == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -_t0;
        } else {
            if (zNear == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 1.0f;
                dest[destOffset + 14] = 2.0f * zFar;
            } else {
                dest[destOffset + 10] = (zFar + zNear) * _t3_inv;
                dest[destOffset + 14] = 2.0f * zFar * zNear * _t3_inv;
            }
        }
        dest[destOffset + 0] = _t0 * _t1_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t0 * _t2_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = (left + right) * _t1_inv;
        dest[destOffset + 9] = (bottom + top) * _t2_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makeFrustum_no(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makeFrustum_no_lh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsArray.makeFrustum_no_rh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static float[] makeFrustum_zo_lh(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = 2.0f * zNear;
        float _t1 = right - left;
        float _t1_inv = 1.0f / _t1;
        float _t2 = top - bottom;
        float _t2_inv = 1.0f / _t2;
        float _t3 = zNear - zFar;
        float _t3_inv = 1.0f / _t3;
        if (zFar == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -zNear;
        } else {
            if (zNear == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = zFar;
            } else {
                dest[destOffset + 10] = -(zFar * _t3_inv);
                dest[destOffset + 14] = zFar * zNear * _t3_inv;
            }
        }
        dest[destOffset + 0] = _t0 * _t1_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t0 * _t2_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = -((left + right) * _t1_inv);
        dest[destOffset + 9] = -((bottom + top) * _t2_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makeFrustum_zo_rh(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = 2.0f * zNear;
        float _t1 = right - left;
        float _t1_inv = 1.0f / _t1;
        float _t2 = top - bottom;
        float _t2_inv = 1.0f / _t2;
        float _t3 = zNear - zFar;
        float _t3_inv = 1.0f / _t3;
        if (zFar == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -zNear;
        } else {
            if (zNear == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = zFar;
            } else {
                dest[destOffset + 10] = zFar * _t3_inv;
                dest[destOffset + 14] = zFar * zNear * _t3_inv;
            }
        }
        dest[destOffset + 0] = _t0 * _t1_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t0 * _t2_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = (left + right) * _t1_inv;
        dest[destOffset + 9] = (bottom + top) * _t2_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makeFrustum_zo(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makeFrustum_zo_lh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsArray.makeFrustum_zo_rh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static float[] makeLookAt_lh(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = centerZ - eyeZ;
        float _t1 = centerX - eyeX;
        float _t2 = centerY - eyeY;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t2 * _t6;
            _t11 = _t1 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t19 = Math.fma(upX, _t10, -(upY * _t11));
        float _t20 = Math.fma(upY, _t12, -(upZ * _t10));
        float _t21 = Math.fma(upZ, _t11, -(upX * _t12));
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t20 * _t25;
            _t30 = _t21 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        float _t38 = Math.fma(_t10, _t31, -(_t12 * _t30));
        float _t39 = Math.fma(_t12, _t29, -(_t11 * _t31));
        float _t40 = Math.fma(_t11, _t30, -(_t10 * _t29));
        dest[destOffset + 0] = _t29;
        dest[destOffset + 1] = _t38;
        dest[destOffset + 2] = _t11;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _t30;
        dest[destOffset + 5] = _t39;
        dest[destOffset + 6] = _t10;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _t31;
        dest[destOffset + 9] = _t40;
        dest[destOffset + 10] = _t12;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30));
        dest[destOffset + 13] = -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39));
        dest[destOffset + 14] = -Math.fma(eyeZ, _t12, Math.fma(eyeX, _t11, eyeY * _t10));
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeLookAt_rh(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
        float _t0 = centerZ - eyeZ;
        float _t1 = centerX - eyeX;
        float _t2 = centerY - eyeY;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t19 = Math.fma(upY, _t10, -(upX * _t11));
        float _t20 = Math.fma(upX, _t12, -(upZ * _t10));
        float _t21 = Math.fma(upZ, _t11, -(upY * _t12));
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t21 * _t25;
            _t30 = _t20 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        float _t38 = Math.fma(_t12, _t30, -(_t11 * _t31));
        float _t39 = Math.fma(_t10, _t31, -(_t12 * _t29));
        float _t40 = Math.fma(_t11, _t29, -(_t10 * _t30));
        dest[destOffset + 0] = _t29;
        dest[destOffset + 1] = _t38;
        dest[destOffset + 2] = -_t10;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _t30;
        dest[destOffset + 5] = _t39;
        dest[destOffset + 6] = -_t11;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _t31;
        dest[destOffset + 9] = _t40;
        dest[destOffset + 10] = -_t12;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30));
        dest[destOffset + 13] = -Math.fma(eyeZ, _t40, Math.fma(eyeX, _t38, eyeY * _t39));
        dest[destOffset + 14] = Math.fma(eyeZ, _t12, Math.fma(eyeX, _t10, eyeY * _t11));
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeLookAt_lh(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _centerx = center[centerOffset + 0];
        float _centery = center[centerOffset + 1];
        float _centerz = center[centerOffset + 2];
        float _upx = up[upOffset + 0];
        float _upy = up[upOffset + 1];
        float _upz = up[upOffset + 2];
        float _t0 = _centerz - _eyez;
        float _t1 = _centerx - _eyex;
        float _t2 = _centery - _eyey;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t2 * _t6;
            _t11 = _t1 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t19 = Math.fma(_upx, _t10, -(_upy * _t11));
        float _t20 = Math.fma(_upy, _t12, -(_upz * _t10));
        float _t21 = Math.fma(_upz, _t11, -(_upx * _t12));
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t20 * _t25;
            _t30 = _t21 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        float _t38 = Math.fma(_t10, _t31, -(_t12 * _t30));
        float _t39 = Math.fma(_t12, _t29, -(_t11 * _t31));
        float _t40 = Math.fma(_t11, _t30, -(_t10 * _t29));
        dest[destOffset + 0] = _t29;
        dest[destOffset + 1] = _t38;
        dest[destOffset + 2] = _t11;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _t30;
        dest[destOffset + 5] = _t39;
        dest[destOffset + 6] = _t10;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _t31;
        dest[destOffset + 9] = _t40;
        dest[destOffset + 10] = _t12;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -Math.fma(_eyez, _t31, Math.fma(_eyex, _t29, _eyey * _t30));
        dest[destOffset + 13] = -Math.fma(_eyez, _t40, Math.fma(_eyex, _t38, _eyey * _t39));
        dest[destOffset + 14] = -Math.fma(_eyez, _t12, Math.fma(_eyex, _t11, _eyey * _t10));
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeLookAt_rh(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] center, int centerOffset, float[] up, int upOffset) {
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _centerx = center[centerOffset + 0];
        float _centery = center[centerOffset + 1];
        float _centerz = center[centerOffset + 2];
        float _upx = up[upOffset + 0];
        float _upy = up[upOffset + 1];
        float _upz = up[upOffset + 2];
        float _t0 = _centerz - _eyez;
        float _t1 = _centerx - _eyex;
        float _t2 = _centery - _eyey;
        float _t5 = Math.fma(_t0, _t0, Math.fma(_t1, _t1, _t2 * _t2));
        float _t6 = (1.0f / (float) Math.sqrt(_t5));
        float _t10, _t11, _t12;
        if (_t5 > 0.0f) {
            _t10 = _t1 * _t6;
            _t11 = _t2 * _t6;
            _t12 = _t0 * _t6;
        } else {
            _t10 = 0.0f;
            _t11 = 0.0f;
            _t12 = 0.0f;
        }
        float _t19 = Math.fma(_upy, _t10, -(_upx * _t11));
        float _t20 = Math.fma(_upx, _t12, -(_upz * _t10));
        float _t21 = Math.fma(_upz, _t11, -(_upy * _t12));
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t21 * _t25;
            _t30 = _t20 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        float _t38 = Math.fma(_t12, _t30, -(_t11 * _t31));
        float _t39 = Math.fma(_t10, _t31, -(_t12 * _t29));
        float _t40 = Math.fma(_t11, _t29, -(_t10 * _t30));
        dest[destOffset + 0] = _t29;
        dest[destOffset + 1] = _t38;
        dest[destOffset + 2] = -_t10;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _t30;
        dest[destOffset + 5] = _t39;
        dest[destOffset + 6] = -_t11;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _t31;
        dest[destOffset + 9] = _t40;
        dest[destOffset + 10] = -_t12;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -Math.fma(_eyez, _t31, Math.fma(_eyex, _t29, _eyey * _t30));
        dest[destOffset + 13] = -Math.fma(_eyez, _t40, Math.fma(_eyex, _t38, _eyey * _t39));
        dest[destOffset + 14] = Math.fma(_eyez, _t12, Math.fma(_eyex, _t10, _eyey * _t11));
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho_no_lh(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        dest[destOffset + 0] = 2.0f * _t0_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t1_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = 2.0f * _t2_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((left + right) * _t0_inv);
        dest[destOffset + 13] = -((bottom + top) * _t1_inv);
        dest[destOffset + 14] = -((zFar + zNear) * _t2_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho_no_rh(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        dest[destOffset + 0] = 2.0f * _t0_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t1_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = -2.0f * _t2_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((left + right) * _t0_inv);
        dest[destOffset + 13] = -((bottom + top) * _t1_inv);
        dest[destOffset + 14] = -((zFar + zNear) * _t2_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho_no(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makeOrtho_no_lh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsArray.makeOrtho_no_rh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static float[] makeOrtho_zo_lh(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        dest[destOffset + 0] = 2.0f * _t0_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t1_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = 1.0f * _t2_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((left + right) * _t0_inv);
        dest[destOffset + 13] = -((bottom + top) * _t1_inv);
        dest[destOffset + 14] = -(zNear * _t2_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho_zo_rh(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        dest[destOffset + 0] = 2.0f * _t0_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t1_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = -1.0f * _t2_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((left + right) * _t0_inv);
        dest[destOffset + 13] = -((bottom + top) * _t1_inv);
        dest[destOffset + 14] = -(zNear * _t2_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho_zo(float[] dest, int destOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makeOrtho_zo_lh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsArray.makeOrtho_zo_rh(dest, destOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static float[] makeOrtho2D_no_lh(float[] dest, int destOffset, float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        dest[destOffset + 0] = 2.0f * _t0_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t1_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = 1.0f;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((left + right) * _t0_inv);
        dest[destOffset + 13] = -((bottom + top) * _t1_inv);
        dest[destOffset + 14] = 0.0f;
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho2D_no_rh(float[] dest, int destOffset, float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        dest[destOffset + 0] = 2.0f * _t0_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t1_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = -1.0f;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((left + right) * _t0_inv);
        dest[destOffset + 13] = -((bottom + top) * _t1_inv);
        dest[destOffset + 14] = 0.0f;
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho2D_no(float[] dest, int destOffset, float left, float right, float bottom, float top, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makeOrtho2D_no_lh(dest, destOffset, left, right, bottom, top); }
            default -> { return Float4x4OpsKernelsArray.makeOrtho2D_no_rh(dest, destOffset, left, right, bottom, top); }
        }
    }

    public static float[] makeOrtho2D_zo_lh(float[] dest, int destOffset, float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        dest[destOffset + 0] = 2.0f * _t0_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t1_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = 0.5f;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((left + right) * _t0_inv);
        dest[destOffset + 13] = -((bottom + top) * _t1_inv);
        dest[destOffset + 14] = 0.5f;
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho2D_zo_rh(float[] dest, int destOffset, float left, float right, float bottom, float top) {
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        dest[destOffset + 0] = 2.0f * _t0_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t1_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = -0.5f;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((left + right) * _t0_inv);
        dest[destOffset + 13] = -((bottom + top) * _t1_inv);
        dest[destOffset + 14] = 0.5f;
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makeOrtho2D_zo(float[] dest, int destOffset, float left, float right, float bottom, float top, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makeOrtho2D_zo_lh(dest, destOffset, left, right, bottom, top); }
            default -> { return Float4x4OpsKernelsArray.makeOrtho2D_zo_rh(dest, destOffset, left, right, bottom, top); }
        }
    }

    public static float[] makePerspective_no_lh(float[] dest, int destOffset, float fovy, float aspect, float near, float far) {
        float _t1 = near - far;
        float _t1_inv = 1.0f / _t1;
        float _t2 = (float) Math.tan(0.5f * fovy);
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = -1.0f;
                dest[destOffset + 14] = 2.0f * far;
            } else {
                dest[destOffset + 10] = -((far + near) * _t1_inv);
                dest[destOffset + 14] = 2.0f * far * near * _t1_inv;
            }
        }
        dest[destOffset + 0] = 1.0f / (aspect * _t2);
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 1.0f / _t2;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspective_no_rh(float[] dest, int destOffset, float fovy, float aspect, float near, float far) {
        float _t1 = near - far;
        float _t1_inv = 1.0f / _t1;
        float _t2 = (float) Math.tan(0.5f * fovy);
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 1.0f;
                dest[destOffset + 14] = 2.0f * far;
            } else {
                dest[destOffset + 10] = (far + near) * _t1_inv;
                dest[destOffset + 14] = 2.0f * far * near * _t1_inv;
            }
        }
        dest[destOffset + 0] = 1.0f / (aspect * _t2);
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 1.0f / _t2;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspective_no(float[] dest, int destOffset, float fovy, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspective_no_lh(dest, destOffset, fovy, aspect, near, far); }
            default -> { return Float4x4OpsKernelsArray.makePerspective_no_rh(dest, destOffset, fovy, aspect, near, far); }
        }
    }

    public static float[] makePerspective_zo_lh(float[] dest, int destOffset, float fovy, float aspect, float near, float far) {
        float _t1 = near - far;
        float _t1_inv = 1.0f / _t1;
        float _t2 = (float) Math.tan(0.5f * fovy);
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = far;
            } else {
                dest[destOffset + 10] = -(far * _t1_inv);
                dest[destOffset + 14] = far * near * _t1_inv;
            }
        }
        dest[destOffset + 0] = 1.0f / (aspect * _t2);
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 1.0f / _t2;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspective_zo_rh(float[] dest, int destOffset, float fovy, float aspect, float near, float far) {
        float _t1 = near - far;
        float _t1_inv = 1.0f / _t1;
        float _t2 = (float) Math.tan(0.5f * fovy);
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = far;
            } else {
                dest[destOffset + 10] = far * _t1_inv;
                dest[destOffset + 14] = far * near * _t1_inv;
            }
        }
        dest[destOffset + 0] = 1.0f / (aspect * _t2);
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 1.0f / _t2;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspective_zo(float[] dest, int destOffset, float fovy, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspective_zo_lh(dest, destOffset, fovy, aspect, near, far); }
            default -> { return Float4x4OpsKernelsArray.makePerspective_zo_rh(dest, destOffset, fovy, aspect, near, far); }
        }
    }

    public static float[] makePerspectiveFovRange_no_lh(float[] dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t2 = near - far;
        float _t2_inv = 1.0f / _t2;
        float _t3 = _t0 - _t1;
        float _t3_inv = 1.0f / _t3;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = -1.0f;
                dest[destOffset + 14] = 2.0f * far;
            } else {
                dest[destOffset + 10] = -((far + near) * _t2_inv);
                dest[destOffset + 14] = 2.0f * far * near * _t2_inv;
            }
        }
        dest[destOffset + 0] = 2.0f / (aspect * _t3);
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t3_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = -((_t0 + _t1) * _t3_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveFovRange_no_rh(float[] dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t2 = near - far;
        float _t2_inv = 1.0f / _t2;
        float _t3 = _t0 - _t1;
        float _t3_inv = 1.0f / _t3;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 1.0f;
                dest[destOffset + 14] = 2.0f * far;
            } else {
                dest[destOffset + 10] = (far + near) * _t2_inv;
                dest[destOffset + 14] = 2.0f * far * near * _t2_inv;
            }
        }
        dest[destOffset + 0] = 2.0f / (aspect * _t3);
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t3_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = (_t0 + _t1) * _t3_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveFovRange_no(float[] dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspectiveFovRange_no_lh(dest, destOffset, angleMin, angleMax, aspect, near, far); }
            default -> { return Float4x4OpsKernelsArray.makePerspectiveFovRange_no_rh(dest, destOffset, angleMin, angleMax, aspect, near, far); }
        }
    }

    public static float[] makePerspectiveFovRange_zo_lh(float[] dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t2 = near - far;
        float _t2_inv = 1.0f / _t2;
        float _t3 = _t0 - _t1;
        float _t3_inv = 1.0f / _t3;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = far;
            } else {
                dest[destOffset + 10] = -(far * _t2_inv);
                dest[destOffset + 14] = far * near * _t2_inv;
            }
        }
        dest[destOffset + 0] = 2.0f / (aspect * _t3);
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t3_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = -((_t0 + _t1) * _t3_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveFovRange_zo_rh(float[] dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t2 = near - far;
        float _t2_inv = 1.0f / _t2;
        float _t3 = _t0 - _t1;
        float _t3_inv = 1.0f / _t3;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = far;
            } else {
                dest[destOffset + 10] = far * _t2_inv;
                dest[destOffset + 14] = far * near * _t2_inv;
            }
        }
        dest[destOffset + 0] = 2.0f / (aspect * _t3);
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t3_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = (_t0 + _t1) * _t3_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveFovRange_zo(float[] dest, int destOffset, float angleMin, float angleMax, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspectiveFovRange_zo_lh(dest, destOffset, angleMin, angleMax, aspect, near, far); }
            default -> { return Float4x4OpsKernelsArray.makePerspectiveFovRange_zo_rh(dest, destOffset, angleMin, angleMax, aspect, near, far); }
        }
    }

    public static float[] makePerspectiveOffCenterFov_no_lh(float[] dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t4 = near - far;
        float _t4_inv = 1.0f / _t4;
        float _t5 = _t0 - _t1;
        float _t5_inv = 1.0f / _t5;
        float _t6 = _t2 - _t3;
        float _t6_inv = 1.0f / _t6;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = -1.0f;
                dest[destOffset + 14] = 2.0f * far;
            } else {
                dest[destOffset + 10] = -((far + near) * _t4_inv);
                dest[destOffset + 14] = 2.0f * far * near * _t4_inv;
            }
        }
        dest[destOffset + 0] = 2.0f * _t5_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t6_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = -((_t1 + _t0) * _t5_inv);
        dest[destOffset + 9] = -((_t3 + _t2) * _t6_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterFov_no_rh(float[] dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t4 = near - far;
        float _t4_inv = 1.0f / _t4;
        float _t5 = _t0 - _t1;
        float _t5_inv = 1.0f / _t5;
        float _t6 = _t2 - _t3;
        float _t6_inv = 1.0f / _t6;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 1.0f;
                dest[destOffset + 14] = 2.0f * far;
            } else {
                dest[destOffset + 10] = (far + near) * _t4_inv;
                dest[destOffset + 14] = 2.0f * far * near * _t4_inv;
            }
        }
        dest[destOffset + 0] = 2.0f * _t5_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t6_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = (_t1 + _t0) * _t5_inv;
        dest[destOffset + 9] = (_t3 + _t2) * _t6_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterFov_no(float[] dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterFov_no_lh(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
            default -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterFov_no_rh(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
        }
    }

    public static float[] makePerspectiveOffCenterFov_zo_lh(float[] dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t4 = near - far;
        float _t4_inv = 1.0f / _t4;
        float _t5 = _t0 - _t1;
        float _t5_inv = 1.0f / _t5;
        float _t6 = _t2 - _t3;
        float _t6_inv = 1.0f / _t6;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = far;
            } else {
                dest[destOffset + 10] = -(far * _t4_inv);
                dest[destOffset + 14] = far * near * _t4_inv;
            }
        }
        dest[destOffset + 0] = 2.0f * _t5_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t6_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = -((_t1 + _t0) * _t5_inv);
        dest[destOffset + 9] = -((_t3 + _t2) * _t6_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterFov_zo_rh(float[] dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t4 = near - far;
        float _t4_inv = 1.0f / _t4;
        float _t5 = _t0 - _t1;
        float _t5_inv = 1.0f / _t5;
        float _t6 = _t2 - _t3;
        float _t6_inv = 1.0f / _t6;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = far;
            } else {
                dest[destOffset + 10] = far * _t4_inv;
                dest[destOffset + 14] = far * near * _t4_inv;
            }
        }
        dest[destOffset + 0] = 2.0f * _t5_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t6_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = (_t1 + _t0) * _t5_inv;
        dest[destOffset + 9] = (_t3 + _t2) * _t6_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterFov_zo(float[] dest, int destOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterFov_zo_lh(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
            default -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterFov_zo_rh(dest, destOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
        }
    }

    public static float[] makePerspectiveOffCenterRectangleProj_no_lh(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        float _t0 = -eyeZ;
        float _t1 = -pY;
        float _t14 = Math.fma(xY, yX, -(xX * yY));
        float _t15 = Math.fma(xZ, yY, -(xY * yZ));
        float _t16 = Math.fma(xX, yZ, -(xZ * yX));
        float _t19 = Math.fma(pZ - eyeZ, _t14, Math.fma(pX - eyeX, _t15, (pY - eyeY) * _t16));
        float _t20 = _t19 >= 0.0f ? 1.0f : -1.0f;
        float _t21 = _t14 * _t20;
        float _t22 = _t16 * _t20;
        float _t23 = _t15 * _t20;
        float _t24 = Math.fma(_t14, _t20, eyeZ - eyeZ);
        float _t25 = Math.fma(_t15, _t20, eyeX - eyeX);
        float _t26 = Math.fma(_t16, _t20, eyeY - eyeY);
        float _t27 = _t19 * _t20;
        float _t34 = (1.0f / (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23))));
        float _t35 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t40 = _t27 * _t34;
        float _t41 = Math.fma(_t27, _t34, nearFarDist);
        float _t42 = 2.0f * _t40;
        float _t44, _t45, _t46;
        if (_t35 > 0.0f) {
            _t44 = _t26 * _t36;
            _t45 = _t25 * _t36;
            _t46 = _t24 * _t36;
        } else {
            _t44 = 0.0f;
            _t45 = 0.0f;
            _t46 = 0.0f;
        }
        float _t53 = Math.fma(_t27, _t34, Math.fma(-_t27, _t34, -nearFarDist));
        float _t53_inv = 1.0f / _t53;
        float _t54 = Math.fma(yX, _t44, -(yY * _t45));
        float _t55 = Math.fma(yY, _t46, -(yZ * _t44));
        float _t56 = Math.fma(yZ, _t45, -(yX * _t46));
        float _t59 = Math.fma(_t54, _t54, Math.fma(_t55, _t55, _t56 * _t56));
        float _t60 = (1.0f / (float) Math.sqrt(_t59));
        float _t64, _t65, _t66;
        if (_t59 > 0.0f) {
            _t64 = _t55 * _t60;
            _t65 = _t56 * _t60;
            _t66 = _t54 * _t60;
        } else {
            _t64 = 0.0f;
            _t65 = 0.0f;
            _t66 = 0.0f;
        }
        float _t85 = Math.fma(pX, _t64, pY * _t65);
        float _t87 = Math.fma(pZ, _t66, -(eyeX * _t64));
        float _t89 = Math.fma(_t0, _t66, -(eyeY * _t65));
        float _t91 = Math.fma(_t44, _t66, -(_t46 * _t65));
        float _t92 = Math.fma(_t46, _t64, -(_t45 * _t66));
        float _t93 = Math.fma(_t45, _t65, -(_t44 * _t64));
        float _t110 = Math.fma(pX, _t91, pY * _t92);
        float _t112 = Math.fma(pZ, _t93, -(eyeX * _t91));
        float _t114 = Math.fma(_t0, _t93, -(eyeY * _t92));
        float _t117 = Math.fma(xX, _t64, Math.fma(xY, _t65, xZ * _t66)) + (_t85 + _t87);
        float _t122 = Math.fma(yX, _t91, Math.fma(yY, _t92, yZ * _t93)) + (_t110 + _t112);
        float _t123 = _t117 + (_t89 + Math.fma(_t1, _t65, -(pX * _t64)) + (Math.fma(eyeX, _t64, -(pZ * _t66)) + Math.fma(eyeY, _t65, eyeZ * _t66)));
        float _t123_inv = 1.0f / _t123;
        float _t125 = _t122 + (_t114 + Math.fma(_t1, _t92, -(pX * _t91)) + (Math.fma(eyeX, _t91, -(pZ * _t93)) + Math.fma(eyeY, _t92, eyeZ * _t93)));
        float _t125_inv = 1.0f / _t125;
        if (_t41 == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -_t42;
        } else {
            if (_t40 == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = -1.0f;
                dest[destOffset + 14] = 2.0f * _t41;
            } else {
                dest[destOffset + 10] = -(Math.fma(_t27, _t34, _t41) * _t53_inv);
                dest[destOffset + 14] = 2.0f * _t41 * _t40 * _t53_inv;
            }
        }
        dest[destOffset + 0] = _t42 * _t123_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t42 * _t125_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = -((_t117 + (_t89 + _t85 + (_t87 + _t89))) * _t123_inv);
        dest[destOffset + 9] = -((_t122 + (_t114 + _t110 + (_t112 + _t114))) * _t125_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleProj_no_rh(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        float _t0 = -eyeZ;
        float _t1 = -pY;
        float _t14 = Math.fma(xY, yX, -(xX * yY));
        float _t15 = Math.fma(xZ, yY, -(xY * yZ));
        float _t16 = Math.fma(xX, yZ, -(xZ * yX));
        float _t19 = Math.fma(pZ - eyeZ, _t14, Math.fma(pX - eyeX, _t15, (pY - eyeY) * _t16));
        float _t20 = _t19 >= 0.0f ? 1.0f : -1.0f;
        float _t21 = _t14 * _t20;
        float _t22 = _t16 * _t20;
        float _t23 = _t15 * _t20;
        float _t24 = Math.fma(_t14, _t20, eyeZ - eyeZ);
        float _t25 = Math.fma(_t15, _t20, eyeX - eyeX);
        float _t26 = Math.fma(_t16, _t20, eyeY - eyeY);
        float _t27 = _t19 * _t20;
        float _t34 = (1.0f / (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23))));
        float _t35 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t40 = _t27 * _t34;
        float _t41 = Math.fma(_t27, _t34, nearFarDist);
        float _t42 = 2.0f * _t40;
        float _t44, _t45, _t46;
        if (_t35 > 0.0f) {
            _t44 = _t25 * _t36;
            _t45 = _t26 * _t36;
            _t46 = _t24 * _t36;
        } else {
            _t44 = 0.0f;
            _t45 = 0.0f;
            _t46 = 0.0f;
        }
        float _t53 = Math.fma(_t27, _t34, Math.fma(-_t27, _t34, -nearFarDist));
        float _t53_inv = 1.0f / _t53;
        float _t54 = Math.fma(yY, _t44, -(yX * _t45));
        float _t55 = Math.fma(yX, _t46, -(yZ * _t44));
        float _t56 = Math.fma(yZ, _t45, -(yY * _t46));
        float _t59 = Math.fma(_t54, _t54, Math.fma(_t55, _t55, _t56 * _t56));
        float _t60 = (1.0f / (float) Math.sqrt(_t59));
        float _t64, _t65, _t66;
        if (_t59 > 0.0f) {
            _t64 = _t56 * _t60;
            _t65 = _t55 * _t60;
            _t66 = _t54 * _t60;
        } else {
            _t64 = 0.0f;
            _t65 = 0.0f;
            _t66 = 0.0f;
        }
        float _t85 = Math.fma(pX, _t64, pY * _t65);
        float _t87 = Math.fma(pZ, _t66, -(eyeX * _t64));
        float _t89 = Math.fma(_t0, _t66, -(eyeY * _t65));
        float _t91 = Math.fma(_t46, _t65, -(_t45 * _t66));
        float _t92 = Math.fma(_t44, _t66, -(_t46 * _t64));
        float _t93 = Math.fma(_t45, _t64, -(_t44 * _t65));
        float _t110 = Math.fma(pX, _t91, pY * _t92);
        float _t112 = Math.fma(pZ, _t93, -(eyeX * _t91));
        float _t114 = Math.fma(_t0, _t93, -(eyeY * _t92));
        float _t117 = Math.fma(xX, _t64, Math.fma(xY, _t65, xZ * _t66)) + (_t85 + _t87);
        float _t122 = Math.fma(yX, _t91, Math.fma(yY, _t92, yZ * _t93)) + (_t110 + _t112);
        float _t123 = _t117 + (_t89 + Math.fma(_t1, _t65, -(pX * _t64)) + (Math.fma(eyeX, _t64, -(pZ * _t66)) + Math.fma(eyeY, _t65, eyeZ * _t66)));
        float _t123_inv = 1.0f / _t123;
        float _t125 = _t122 + (_t114 + Math.fma(_t1, _t92, -(pX * _t91)) + (Math.fma(eyeX, _t91, -(pZ * _t93)) + Math.fma(eyeY, _t92, eyeZ * _t93)));
        float _t125_inv = 1.0f / _t125;
        if (_t41 == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -_t42;
        } else {
            if (_t40 == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 1.0f;
                dest[destOffset + 14] = 2.0f * _t41;
            } else {
                dest[destOffset + 10] = Math.fma(_t27, _t34, _t41) * _t53_inv;
                dest[destOffset + 14] = 2.0f * _t41 * _t40 * _t53_inv;
            }
        }
        dest[destOffset + 0] = _t42 * _t123_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t42 * _t125_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = (_t117 + (_t89 + _t85 + (_t87 + _t89))) * _t123_inv;
        dest[destOffset + 9] = (_t122 + (_t114 + _t110 + (_t112 + _t114))) * _t125_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleProj_no(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_no_lh(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist); }
            default -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_no_rh(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist); }
        }
    }

    public static float[] makePerspectiveOffCenterRectangleProj_zo_lh(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        float _t0 = -eyeZ;
        float _t1 = -pY;
        float _t14 = Math.fma(xY, yX, -(xX * yY));
        float _t15 = Math.fma(xZ, yY, -(xY * yZ));
        float _t16 = Math.fma(xX, yZ, -(xZ * yX));
        float _t19 = Math.fma(pZ - eyeZ, _t14, Math.fma(pX - eyeX, _t15, (pY - eyeY) * _t16));
        float _t20 = _t19 >= 0.0f ? 1.0f : -1.0f;
        float _t21 = _t14 * _t20;
        float _t22 = _t16 * _t20;
        float _t23 = _t15 * _t20;
        float _t24 = Math.fma(_t14, _t20, eyeZ - eyeZ);
        float _t25 = Math.fma(_t15, _t20, eyeX - eyeX);
        float _t26 = Math.fma(_t16, _t20, eyeY - eyeY);
        float _t27 = _t19 * _t20;
        float _t34 = (1.0f / (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23))));
        float _t35 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t40 = _t27 * _t34;
        float _t41 = Math.fma(_t27, _t34, nearFarDist);
        float _t42 = 2.0f * _t40;
        float _t44, _t45, _t46;
        if (_t35 > 0.0f) {
            _t44 = _t26 * _t36;
            _t45 = _t25 * _t36;
            _t46 = _t24 * _t36;
        } else {
            _t44 = 0.0f;
            _t45 = 0.0f;
            _t46 = 0.0f;
        }
        float _t53 = Math.fma(_t27, _t34, Math.fma(-_t27, _t34, -nearFarDist));
        float _t53_inv = 1.0f / _t53;
        float _t54 = Math.fma(yX, _t44, -(yY * _t45));
        float _t55 = Math.fma(yY, _t46, -(yZ * _t44));
        float _t56 = Math.fma(yZ, _t45, -(yX * _t46));
        float _t59 = Math.fma(_t54, _t54, Math.fma(_t55, _t55, _t56 * _t56));
        float _t60 = (1.0f / (float) Math.sqrt(_t59));
        float _t64, _t65, _t66;
        if (_t59 > 0.0f) {
            _t64 = _t55 * _t60;
            _t65 = _t56 * _t60;
            _t66 = _t54 * _t60;
        } else {
            _t64 = 0.0f;
            _t65 = 0.0f;
            _t66 = 0.0f;
        }
        float _t85 = Math.fma(pX, _t64, pY * _t65);
        float _t87 = Math.fma(pZ, _t66, -(eyeX * _t64));
        float _t89 = Math.fma(_t0, _t66, -(eyeY * _t65));
        float _t91 = Math.fma(_t44, _t66, -(_t46 * _t65));
        float _t92 = Math.fma(_t46, _t64, -(_t45 * _t66));
        float _t93 = Math.fma(_t45, _t65, -(_t44 * _t64));
        float _t110 = Math.fma(pX, _t91, pY * _t92);
        float _t112 = Math.fma(pZ, _t93, -(eyeX * _t91));
        float _t114 = Math.fma(_t0, _t93, -(eyeY * _t92));
        float _t117 = Math.fma(xX, _t64, Math.fma(xY, _t65, xZ * _t66)) + (_t85 + _t87);
        float _t122 = Math.fma(yX, _t91, Math.fma(yY, _t92, yZ * _t93)) + (_t110 + _t112);
        float _t123 = _t117 + (_t89 + Math.fma(_t1, _t65, -(pX * _t64)) + (Math.fma(eyeX, _t64, -(pZ * _t66)) + Math.fma(eyeY, _t65, eyeZ * _t66)));
        float _t123_inv = 1.0f / _t123;
        float _t125 = _t122 + (_t114 + Math.fma(_t1, _t92, -(pX * _t91)) + (Math.fma(eyeX, _t91, -(pZ * _t93)) + Math.fma(eyeY, _t92, eyeZ * _t93)));
        float _t125_inv = 1.0f / _t125;
        if (_t41 == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -_t40;
        } else {
            if (_t40 == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = _t41;
            } else {
                dest[destOffset + 10] = -(_t41 * _t53_inv);
                dest[destOffset + 14] = _t41 * _t40 * _t53_inv;
            }
        }
        dest[destOffset + 0] = _t42 * _t123_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t42 * _t125_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = -((_t117 + (_t89 + _t85 + (_t87 + _t89))) * _t123_inv);
        dest[destOffset + 9] = -((_t122 + (_t114 + _t110 + (_t112 + _t114))) * _t125_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleProj_zo_rh(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist) {
        float _t0 = -eyeZ;
        float _t1 = -pY;
        float _t14 = Math.fma(xY, yX, -(xX * yY));
        float _t15 = Math.fma(xZ, yY, -(xY * yZ));
        float _t16 = Math.fma(xX, yZ, -(xZ * yX));
        float _t19 = Math.fma(pZ - eyeZ, _t14, Math.fma(pX - eyeX, _t15, (pY - eyeY) * _t16));
        float _t20 = _t19 >= 0.0f ? 1.0f : -1.0f;
        float _t21 = _t14 * _t20;
        float _t22 = _t16 * _t20;
        float _t23 = _t15 * _t20;
        float _t24 = Math.fma(_t14, _t20, eyeZ - eyeZ);
        float _t25 = Math.fma(_t15, _t20, eyeX - eyeX);
        float _t26 = Math.fma(_t16, _t20, eyeY - eyeY);
        float _t27 = _t19 * _t20;
        float _t34 = (1.0f / (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23))));
        float _t35 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t40 = _t27 * _t34;
        float _t41 = Math.fma(_t27, _t34, nearFarDist);
        float _t42 = 2.0f * _t40;
        float _t44, _t45, _t46;
        if (_t35 > 0.0f) {
            _t44 = _t25 * _t36;
            _t45 = _t26 * _t36;
            _t46 = _t24 * _t36;
        } else {
            _t44 = 0.0f;
            _t45 = 0.0f;
            _t46 = 0.0f;
        }
        float _t53 = Math.fma(_t27, _t34, Math.fma(-_t27, _t34, -nearFarDist));
        float _t53_inv = 1.0f / _t53;
        float _t54 = Math.fma(yY, _t44, -(yX * _t45));
        float _t55 = Math.fma(yX, _t46, -(yZ * _t44));
        float _t56 = Math.fma(yZ, _t45, -(yY * _t46));
        float _t59 = Math.fma(_t54, _t54, Math.fma(_t55, _t55, _t56 * _t56));
        float _t60 = (1.0f / (float) Math.sqrt(_t59));
        float _t64, _t65, _t66;
        if (_t59 > 0.0f) {
            _t64 = _t56 * _t60;
            _t65 = _t55 * _t60;
            _t66 = _t54 * _t60;
        } else {
            _t64 = 0.0f;
            _t65 = 0.0f;
            _t66 = 0.0f;
        }
        float _t85 = Math.fma(pX, _t64, pY * _t65);
        float _t87 = Math.fma(pZ, _t66, -(eyeX * _t64));
        float _t89 = Math.fma(_t0, _t66, -(eyeY * _t65));
        float _t91 = Math.fma(_t46, _t65, -(_t45 * _t66));
        float _t92 = Math.fma(_t44, _t66, -(_t46 * _t64));
        float _t93 = Math.fma(_t45, _t64, -(_t44 * _t65));
        float _t110 = Math.fma(pX, _t91, pY * _t92);
        float _t112 = Math.fma(pZ, _t93, -(eyeX * _t91));
        float _t114 = Math.fma(_t0, _t93, -(eyeY * _t92));
        float _t117 = Math.fma(xX, _t64, Math.fma(xY, _t65, xZ * _t66)) + (_t85 + _t87);
        float _t122 = Math.fma(yX, _t91, Math.fma(yY, _t92, yZ * _t93)) + (_t110 + _t112);
        float _t123 = _t117 + (_t89 + Math.fma(_t1, _t65, -(pX * _t64)) + (Math.fma(eyeX, _t64, -(pZ * _t66)) + Math.fma(eyeY, _t65, eyeZ * _t66)));
        float _t123_inv = 1.0f / _t123;
        float _t125 = _t122 + (_t114 + Math.fma(_t1, _t92, -(pX * _t91)) + (Math.fma(eyeX, _t91, -(pZ * _t93)) + Math.fma(eyeY, _t92, eyeZ * _t93)));
        float _t125_inv = 1.0f / _t125;
        if (_t41 == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -_t40;
        } else {
            if (_t40 == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = _t41;
            } else {
                dest[destOffset + 10] = _t41 * _t53_inv;
                dest[destOffset + 14] = _t41 * _t40 * _t53_inv;
            }
        }
        dest[destOffset + 0] = _t42 * _t123_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t42 * _t125_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = (_t117 + (_t89 + _t85 + (_t87 + _t89))) * _t123_inv;
        dest[destOffset + 9] = (_t122 + (_t114 + _t110 + (_t112 + _t114))) * _t125_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleProj_zo(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ, float nearFarDist, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_zo_lh(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist); }
            default -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_zo_rh(dest, destOffset, eyeX, eyeY, eyeZ, pX, pY, pZ, xX, xY, xZ, yX, yY, yZ, nearFarDist); }
        }
    }

    public static float[] makePerspectiveOffCenterRectangleProj_no_lh(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] p, int pOffset, float[] x, int xOffset, float[] y, int yOffset, float nearFarDist) {
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _px = p[pOffset + 0];
        float _py = p[pOffset + 1];
        float _pz = p[pOffset + 2];
        float _xx = x[xOffset + 0];
        float _xy = x[xOffset + 1];
        float _xz = x[xOffset + 2];
        float _yx = y[yOffset + 0];
        float _yy = y[yOffset + 1];
        float _yz = y[yOffset + 2];
        float _t0 = -_eyez;
        float _t1 = -_py;
        float _t14 = Math.fma(_xy, _yx, -(_xx * _yy));
        float _t15 = Math.fma(_xz, _yy, -(_xy * _yz));
        float _t16 = Math.fma(_xx, _yz, -(_xz * _yx));
        float _t19 = Math.fma(_pz - _eyez, _t14, Math.fma(_px - _eyex, _t15, (_py - _eyey) * _t16));
        float _t20 = _t19 >= 0.0f ? 1.0f : -1.0f;
        float _t21 = _t14 * _t20;
        float _t22 = _t16 * _t20;
        float _t23 = _t15 * _t20;
        float _t24 = Math.fma(_t14, _t20, _eyez - _eyez);
        float _t25 = Math.fma(_t15, _t20, _eyex - _eyex);
        float _t26 = Math.fma(_t16, _t20, _eyey - _eyey);
        float _t27 = _t19 * _t20;
        float _t34 = (1.0f / (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23))));
        float _t35 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t40 = _t27 * _t34;
        float _t41 = Math.fma(_t27, _t34, nearFarDist);
        float _t42 = 2.0f * _t40;
        float _t44, _t45, _t46;
        if (_t35 > 0.0f) {
            _t44 = _t26 * _t36;
            _t45 = _t25 * _t36;
            _t46 = _t24 * _t36;
        } else {
            _t44 = 0.0f;
            _t45 = 0.0f;
            _t46 = 0.0f;
        }
        float _t53 = Math.fma(_t27, _t34, Math.fma(-_t27, _t34, -nearFarDist));
        float _t53_inv = 1.0f / _t53;
        float _t54 = Math.fma(_yx, _t44, -(_yy * _t45));
        float _t55 = Math.fma(_yy, _t46, -(_yz * _t44));
        float _t56 = Math.fma(_yz, _t45, -(_yx * _t46));
        float _t59 = Math.fma(_t54, _t54, Math.fma(_t55, _t55, _t56 * _t56));
        float _t60 = (1.0f / (float) Math.sqrt(_t59));
        float _t64, _t65, _t66;
        if (_t59 > 0.0f) {
            _t64 = _t55 * _t60;
            _t65 = _t56 * _t60;
            _t66 = _t54 * _t60;
        } else {
            _t64 = 0.0f;
            _t65 = 0.0f;
            _t66 = 0.0f;
        }
        float _t85 = Math.fma(_px, _t64, _py * _t65);
        float _t87 = Math.fma(_pz, _t66, -(_eyex * _t64));
        float _t89 = Math.fma(_t0, _t66, -(_eyey * _t65));
        float _t91 = Math.fma(_t44, _t66, -(_t46 * _t65));
        float _t92 = Math.fma(_t46, _t64, -(_t45 * _t66));
        float _t93 = Math.fma(_t45, _t65, -(_t44 * _t64));
        float _t110 = Math.fma(_px, _t91, _py * _t92);
        float _t112 = Math.fma(_pz, _t93, -(_eyex * _t91));
        float _t114 = Math.fma(_t0, _t93, -(_eyey * _t92));
        float _t117 = Math.fma(_xx, _t64, Math.fma(_xy, _t65, _xz * _t66)) + (_t85 + _t87);
        float _t122 = Math.fma(_yx, _t91, Math.fma(_yy, _t92, _yz * _t93)) + (_t110 + _t112);
        float _t123 = _t117 + (_t89 + Math.fma(_t1, _t65, -(_px * _t64)) + (Math.fma(_eyex, _t64, -(_pz * _t66)) + Math.fma(_eyey, _t65, _eyez * _t66)));
        float _t123_inv = 1.0f / _t123;
        float _t125 = _t122 + (_t114 + Math.fma(_t1, _t92, -(_px * _t91)) + (Math.fma(_eyex, _t91, -(_pz * _t93)) + Math.fma(_eyey, _t92, _eyez * _t93)));
        float _t125_inv = 1.0f / _t125;
        if (_t41 == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -_t42;
        } else {
            if (_t40 == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = -1.0f;
                dest[destOffset + 14] = 2.0f * _t41;
            } else {
                dest[destOffset + 10] = -(Math.fma(_t27, _t34, _t41) * _t53_inv);
                dest[destOffset + 14] = 2.0f * _t41 * _t40 * _t53_inv;
            }
        }
        dest[destOffset + 0] = _t42 * _t123_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t42 * _t125_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = -((_t117 + (_t89 + _t85 + (_t87 + _t89))) * _t123_inv);
        dest[destOffset + 9] = -((_t122 + (_t114 + _t110 + (_t112 + _t114))) * _t125_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleProj_no_rh(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] p, int pOffset, float[] x, int xOffset, float[] y, int yOffset, float nearFarDist) {
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _px = p[pOffset + 0];
        float _py = p[pOffset + 1];
        float _pz = p[pOffset + 2];
        float _xx = x[xOffset + 0];
        float _xy = x[xOffset + 1];
        float _xz = x[xOffset + 2];
        float _yx = y[yOffset + 0];
        float _yy = y[yOffset + 1];
        float _yz = y[yOffset + 2];
        float _t0 = -_eyez;
        float _t1 = -_py;
        float _t14 = Math.fma(_xy, _yx, -(_xx * _yy));
        float _t15 = Math.fma(_xz, _yy, -(_xy * _yz));
        float _t16 = Math.fma(_xx, _yz, -(_xz * _yx));
        float _t19 = Math.fma(_pz - _eyez, _t14, Math.fma(_px - _eyex, _t15, (_py - _eyey) * _t16));
        float _t20 = _t19 >= 0.0f ? 1.0f : -1.0f;
        float _t21 = _t14 * _t20;
        float _t22 = _t16 * _t20;
        float _t23 = _t15 * _t20;
        float _t24 = Math.fma(_t14, _t20, _eyez - _eyez);
        float _t25 = Math.fma(_t15, _t20, _eyex - _eyex);
        float _t26 = Math.fma(_t16, _t20, _eyey - _eyey);
        float _t27 = _t19 * _t20;
        float _t34 = (1.0f / (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23))));
        float _t35 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t40 = _t27 * _t34;
        float _t41 = Math.fma(_t27, _t34, nearFarDist);
        float _t42 = 2.0f * _t40;
        float _t44, _t45, _t46;
        if (_t35 > 0.0f) {
            _t44 = _t25 * _t36;
            _t45 = _t26 * _t36;
            _t46 = _t24 * _t36;
        } else {
            _t44 = 0.0f;
            _t45 = 0.0f;
            _t46 = 0.0f;
        }
        float _t53 = Math.fma(_t27, _t34, Math.fma(-_t27, _t34, -nearFarDist));
        float _t53_inv = 1.0f / _t53;
        float _t54 = Math.fma(_yy, _t44, -(_yx * _t45));
        float _t55 = Math.fma(_yx, _t46, -(_yz * _t44));
        float _t56 = Math.fma(_yz, _t45, -(_yy * _t46));
        float _t59 = Math.fma(_t54, _t54, Math.fma(_t55, _t55, _t56 * _t56));
        float _t60 = (1.0f / (float) Math.sqrt(_t59));
        float _t64, _t65, _t66;
        if (_t59 > 0.0f) {
            _t64 = _t56 * _t60;
            _t65 = _t55 * _t60;
            _t66 = _t54 * _t60;
        } else {
            _t64 = 0.0f;
            _t65 = 0.0f;
            _t66 = 0.0f;
        }
        float _t85 = Math.fma(_px, _t64, _py * _t65);
        float _t87 = Math.fma(_pz, _t66, -(_eyex * _t64));
        float _t89 = Math.fma(_t0, _t66, -(_eyey * _t65));
        float _t91 = Math.fma(_t46, _t65, -(_t45 * _t66));
        float _t92 = Math.fma(_t44, _t66, -(_t46 * _t64));
        float _t93 = Math.fma(_t45, _t64, -(_t44 * _t65));
        float _t110 = Math.fma(_px, _t91, _py * _t92);
        float _t112 = Math.fma(_pz, _t93, -(_eyex * _t91));
        float _t114 = Math.fma(_t0, _t93, -(_eyey * _t92));
        float _t117 = Math.fma(_xx, _t64, Math.fma(_xy, _t65, _xz * _t66)) + (_t85 + _t87);
        float _t122 = Math.fma(_yx, _t91, Math.fma(_yy, _t92, _yz * _t93)) + (_t110 + _t112);
        float _t123 = _t117 + (_t89 + Math.fma(_t1, _t65, -(_px * _t64)) + (Math.fma(_eyex, _t64, -(_pz * _t66)) + Math.fma(_eyey, _t65, _eyez * _t66)));
        float _t123_inv = 1.0f / _t123;
        float _t125 = _t122 + (_t114 + Math.fma(_t1, _t92, -(_px * _t91)) + (Math.fma(_eyex, _t91, -(_pz * _t93)) + Math.fma(_eyey, _t92, _eyez * _t93)));
        float _t125_inv = 1.0f / _t125;
        if (_t41 == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -_t42;
        } else {
            if (_t40 == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 1.0f;
                dest[destOffset + 14] = 2.0f * _t41;
            } else {
                dest[destOffset + 10] = Math.fma(_t27, _t34, _t41) * _t53_inv;
                dest[destOffset + 14] = 2.0f * _t41 * _t40 * _t53_inv;
            }
        }
        dest[destOffset + 0] = _t42 * _t123_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t42 * _t125_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = (_t117 + (_t89 + _t85 + (_t87 + _t89))) * _t123_inv;
        dest[destOffset + 9] = (_t122 + (_t114 + _t110 + (_t112 + _t114))) * _t125_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleProj_no(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] p, int pOffset, float[] x, int xOffset, float[] y, int yOffset, float nearFarDist, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_no_lh(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist); }
            default -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_no_rh(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist); }
        }
    }

    public static float[] makePerspectiveOffCenterRectangleProj_zo_lh(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] p, int pOffset, float[] x, int xOffset, float[] y, int yOffset, float nearFarDist) {
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _px = p[pOffset + 0];
        float _py = p[pOffset + 1];
        float _pz = p[pOffset + 2];
        float _xx = x[xOffset + 0];
        float _xy = x[xOffset + 1];
        float _xz = x[xOffset + 2];
        float _yx = y[yOffset + 0];
        float _yy = y[yOffset + 1];
        float _yz = y[yOffset + 2];
        float _t0 = -_eyez;
        float _t1 = -_py;
        float _t14 = Math.fma(_xy, _yx, -(_xx * _yy));
        float _t15 = Math.fma(_xz, _yy, -(_xy * _yz));
        float _t16 = Math.fma(_xx, _yz, -(_xz * _yx));
        float _t19 = Math.fma(_pz - _eyez, _t14, Math.fma(_px - _eyex, _t15, (_py - _eyey) * _t16));
        float _t20 = _t19 >= 0.0f ? 1.0f : -1.0f;
        float _t21 = _t14 * _t20;
        float _t22 = _t16 * _t20;
        float _t23 = _t15 * _t20;
        float _t24 = Math.fma(_t14, _t20, _eyez - _eyez);
        float _t25 = Math.fma(_t15, _t20, _eyex - _eyex);
        float _t26 = Math.fma(_t16, _t20, _eyey - _eyey);
        float _t27 = _t19 * _t20;
        float _t34 = (1.0f / (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23))));
        float _t35 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t40 = _t27 * _t34;
        float _t41 = Math.fma(_t27, _t34, nearFarDist);
        float _t42 = 2.0f * _t40;
        float _t44, _t45, _t46;
        if (_t35 > 0.0f) {
            _t44 = _t26 * _t36;
            _t45 = _t25 * _t36;
            _t46 = _t24 * _t36;
        } else {
            _t44 = 0.0f;
            _t45 = 0.0f;
            _t46 = 0.0f;
        }
        float _t53 = Math.fma(_t27, _t34, Math.fma(-_t27, _t34, -nearFarDist));
        float _t53_inv = 1.0f / _t53;
        float _t54 = Math.fma(_yx, _t44, -(_yy * _t45));
        float _t55 = Math.fma(_yy, _t46, -(_yz * _t44));
        float _t56 = Math.fma(_yz, _t45, -(_yx * _t46));
        float _t59 = Math.fma(_t54, _t54, Math.fma(_t55, _t55, _t56 * _t56));
        float _t60 = (1.0f / (float) Math.sqrt(_t59));
        float _t64, _t65, _t66;
        if (_t59 > 0.0f) {
            _t64 = _t55 * _t60;
            _t65 = _t56 * _t60;
            _t66 = _t54 * _t60;
        } else {
            _t64 = 0.0f;
            _t65 = 0.0f;
            _t66 = 0.0f;
        }
        float _t85 = Math.fma(_px, _t64, _py * _t65);
        float _t87 = Math.fma(_pz, _t66, -(_eyex * _t64));
        float _t89 = Math.fma(_t0, _t66, -(_eyey * _t65));
        float _t91 = Math.fma(_t44, _t66, -(_t46 * _t65));
        float _t92 = Math.fma(_t46, _t64, -(_t45 * _t66));
        float _t93 = Math.fma(_t45, _t65, -(_t44 * _t64));
        float _t110 = Math.fma(_px, _t91, _py * _t92);
        float _t112 = Math.fma(_pz, _t93, -(_eyex * _t91));
        float _t114 = Math.fma(_t0, _t93, -(_eyey * _t92));
        float _t117 = Math.fma(_xx, _t64, Math.fma(_xy, _t65, _xz * _t66)) + (_t85 + _t87);
        float _t122 = Math.fma(_yx, _t91, Math.fma(_yy, _t92, _yz * _t93)) + (_t110 + _t112);
        float _t123 = _t117 + (_t89 + Math.fma(_t1, _t65, -(_px * _t64)) + (Math.fma(_eyex, _t64, -(_pz * _t66)) + Math.fma(_eyey, _t65, _eyez * _t66)));
        float _t123_inv = 1.0f / _t123;
        float _t125 = _t122 + (_t114 + Math.fma(_t1, _t92, -(_px * _t91)) + (Math.fma(_eyex, _t91, -(_pz * _t93)) + Math.fma(_eyey, _t92, _eyez * _t93)));
        float _t125_inv = 1.0f / _t125;
        if (_t41 == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -_t40;
        } else {
            if (_t40 == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = _t41;
            } else {
                dest[destOffset + 10] = -(_t41 * _t53_inv);
                dest[destOffset + 14] = _t41 * _t40 * _t53_inv;
            }
        }
        dest[destOffset + 0] = _t42 * _t123_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t42 * _t125_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = -((_t117 + (_t89 + _t85 + (_t87 + _t89))) * _t123_inv);
        dest[destOffset + 9] = -((_t122 + (_t114 + _t110 + (_t112 + _t114))) * _t125_inv);
        dest[destOffset + 11] = 1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleProj_zo_rh(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] p, int pOffset, float[] x, int xOffset, float[] y, int yOffset, float nearFarDist) {
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _px = p[pOffset + 0];
        float _py = p[pOffset + 1];
        float _pz = p[pOffset + 2];
        float _xx = x[xOffset + 0];
        float _xy = x[xOffset + 1];
        float _xz = x[xOffset + 2];
        float _yx = y[yOffset + 0];
        float _yy = y[yOffset + 1];
        float _yz = y[yOffset + 2];
        float _t0 = -_eyez;
        float _t1 = -_py;
        float _t14 = Math.fma(_xy, _yx, -(_xx * _yy));
        float _t15 = Math.fma(_xz, _yy, -(_xy * _yz));
        float _t16 = Math.fma(_xx, _yz, -(_xz * _yx));
        float _t19 = Math.fma(_pz - _eyez, _t14, Math.fma(_px - _eyex, _t15, (_py - _eyey) * _t16));
        float _t20 = _t19 >= 0.0f ? 1.0f : -1.0f;
        float _t21 = _t14 * _t20;
        float _t22 = _t16 * _t20;
        float _t23 = _t15 * _t20;
        float _t24 = Math.fma(_t14, _t20, _eyez - _eyez);
        float _t25 = Math.fma(_t15, _t20, _eyex - _eyex);
        float _t26 = Math.fma(_t16, _t20, _eyey - _eyey);
        float _t27 = _t19 * _t20;
        float _t34 = (1.0f / (float) Math.sqrt(Math.fma(_t21, _t21, Math.fma(_t22, _t22, _t23 * _t23))));
        float _t35 = Math.fma(_t24, _t24, Math.fma(_t25, _t25, _t26 * _t26));
        float _t36 = (1.0f / (float) Math.sqrt(_t35));
        float _t40 = _t27 * _t34;
        float _t41 = Math.fma(_t27, _t34, nearFarDist);
        float _t42 = 2.0f * _t40;
        float _t44, _t45, _t46;
        if (_t35 > 0.0f) {
            _t44 = _t25 * _t36;
            _t45 = _t26 * _t36;
            _t46 = _t24 * _t36;
        } else {
            _t44 = 0.0f;
            _t45 = 0.0f;
            _t46 = 0.0f;
        }
        float _t53 = Math.fma(_t27, _t34, Math.fma(-_t27, _t34, -nearFarDist));
        float _t53_inv = 1.0f / _t53;
        float _t54 = Math.fma(_yy, _t44, -(_yx * _t45));
        float _t55 = Math.fma(_yx, _t46, -(_yz * _t44));
        float _t56 = Math.fma(_yz, _t45, -(_yy * _t46));
        float _t59 = Math.fma(_t54, _t54, Math.fma(_t55, _t55, _t56 * _t56));
        float _t60 = (1.0f / (float) Math.sqrt(_t59));
        float _t64, _t65, _t66;
        if (_t59 > 0.0f) {
            _t64 = _t56 * _t60;
            _t65 = _t55 * _t60;
            _t66 = _t54 * _t60;
        } else {
            _t64 = 0.0f;
            _t65 = 0.0f;
            _t66 = 0.0f;
        }
        float _t85 = Math.fma(_px, _t64, _py * _t65);
        float _t87 = Math.fma(_pz, _t66, -(_eyex * _t64));
        float _t89 = Math.fma(_t0, _t66, -(_eyey * _t65));
        float _t91 = Math.fma(_t46, _t65, -(_t45 * _t66));
        float _t92 = Math.fma(_t44, _t66, -(_t46 * _t64));
        float _t93 = Math.fma(_t45, _t64, -(_t44 * _t65));
        float _t110 = Math.fma(_px, _t91, _py * _t92);
        float _t112 = Math.fma(_pz, _t93, -(_eyex * _t91));
        float _t114 = Math.fma(_t0, _t93, -(_eyey * _t92));
        float _t117 = Math.fma(_xx, _t64, Math.fma(_xy, _t65, _xz * _t66)) + (_t85 + _t87);
        float _t122 = Math.fma(_yx, _t91, Math.fma(_yy, _t92, _yz * _t93)) + (_t110 + _t112);
        float _t123 = _t117 + (_t89 + Math.fma(_t1, _t65, -(_px * _t64)) + (Math.fma(_eyex, _t64, -(_pz * _t66)) + Math.fma(_eyey, _t65, _eyez * _t66)));
        float _t123_inv = 1.0f / _t123;
        float _t125 = _t122 + (_t114 + Math.fma(_t1, _t92, -(_px * _t91)) + (Math.fma(_eyex, _t91, -(_pz * _t93)) + Math.fma(_eyey, _t92, _eyez * _t93)));
        float _t125_inv = 1.0f / _t125;
        if (_t41 == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -_t40;
        } else {
            if (_t40 == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = _t41;
            } else {
                dest[destOffset + 10] = _t41 * _t53_inv;
                dest[destOffset + 14] = _t41 * _t40 * _t53_inv;
            }
        }
        dest[destOffset + 0] = _t42 * _t123_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = _t42 * _t125_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = (_t117 + (_t89 + _t85 + (_t87 + _t89))) * _t123_inv;
        dest[destOffset + 9] = (_t122 + (_t114 + _t110 + (_t112 + _t114))) * _t125_inv;
        dest[destOffset + 11] = -1.0f;
        dest[destOffset + 12] = 0.0f;
        dest[destOffset + 13] = 0.0f;
        dest[destOffset + 15] = 0.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleProj_zo(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] p, int pOffset, float[] x, int xOffset, float[] y, int yOffset, float nearFarDist, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_zo_lh(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist); }
            default -> { return Float4x4OpsKernelsArray.makePerspectiveOffCenterRectangleProj_zo_rh(dest, destOffset, eye, eyeOffset, p, pOffset, x, xOffset, y, yOffset, nearFarDist); }
        }
    }

    public static float[] makePerspectiveOffCenterRectangleView_lh(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ) {
        float _t12 = Math.fma(xY, yX, -(xX * yY));
        float _t13 = Math.fma(xZ, yY, -(xY * yZ));
        float _t14 = Math.fma(xX, yZ, -(xZ * yX));
        float _t18 = Math.fma(pZ - eyeZ, _t12, Math.fma(pX - eyeX, _t13, (pY - eyeY) * _t14)) >= 0.0f ? 1.0f : -1.0f;
        float _t19 = Math.fma(_t12, _t18, eyeZ - eyeZ);
        float _t20 = Math.fma(_t13, _t18, eyeX - eyeX);
        float _t21 = Math.fma(_t14, _t18, eyeY - eyeY);
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t21 * _t25;
            _t30 = _t20 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        float _t38 = Math.fma(yX, _t29, -(yY * _t30));
        float _t39 = Math.fma(yY, _t31, -(yZ * _t29));
        float _t40 = Math.fma(yZ, _t30, -(yX * _t31));
        float _t43 = Math.fma(_t38, _t38, Math.fma(_t39, _t39, _t40 * _t40));
        float _t44 = (1.0f / (float) Math.sqrt(_t43));
        float _t48, _t49, _t50;
        if (_t43 > 0.0f) {
            _t48 = _t39 * _t44;
            _t49 = _t40 * _t44;
            _t50 = _t38 * _t44;
        } else {
            _t48 = 0.0f;
            _t49 = 0.0f;
            _t50 = 0.0f;
        }
        float _t57 = Math.fma(_t29, _t50, -(_t31 * _t49));
        float _t58 = Math.fma(_t31, _t48, -(_t30 * _t50));
        float _t59 = Math.fma(_t30, _t49, -(_t29 * _t48));
        dest[destOffset + 0] = _t48;
        dest[destOffset + 1] = _t57;
        dest[destOffset + 2] = _t30;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _t49;
        dest[destOffset + 5] = _t58;
        dest[destOffset + 6] = _t29;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _t50;
        dest[destOffset + 9] = _t59;
        dest[destOffset + 10] = _t31;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -Math.fma(eyeZ, _t50, Math.fma(eyeX, _t48, eyeY * _t49));
        dest[destOffset + 13] = -Math.fma(eyeZ, _t59, Math.fma(eyeX, _t57, eyeY * _t58));
        dest[destOffset + 14] = -Math.fma(eyeZ, _t31, Math.fma(eyeX, _t30, eyeY * _t29));
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleView_rh(float[] dest, int destOffset, float eyeX, float eyeY, float eyeZ, float pX, float pY, float pZ, float xX, float xY, float xZ, float yX, float yY, float yZ) {
        float _t12 = Math.fma(xY, yX, -(xX * yY));
        float _t13 = Math.fma(xZ, yY, -(xY * yZ));
        float _t14 = Math.fma(xX, yZ, -(xZ * yX));
        float _t18 = Math.fma(pZ - eyeZ, _t12, Math.fma(pX - eyeX, _t13, (pY - eyeY) * _t14)) >= 0.0f ? 1.0f : -1.0f;
        float _t19 = Math.fma(_t12, _t18, eyeZ - eyeZ);
        float _t20 = Math.fma(_t13, _t18, eyeX - eyeX);
        float _t21 = Math.fma(_t14, _t18, eyeY - eyeY);
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t20 * _t25;
            _t30 = _t21 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        float _t38 = Math.fma(yY, _t29, -(yX * _t30));
        float _t39 = Math.fma(yX, _t31, -(yZ * _t29));
        float _t40 = Math.fma(yZ, _t30, -(yY * _t31));
        float _t43 = Math.fma(_t38, _t38, Math.fma(_t39, _t39, _t40 * _t40));
        float _t44 = (1.0f / (float) Math.sqrt(_t43));
        float _t48, _t49, _t50;
        if (_t43 > 0.0f) {
            _t48 = _t40 * _t44;
            _t49 = _t39 * _t44;
            _t50 = _t38 * _t44;
        } else {
            _t48 = 0.0f;
            _t49 = 0.0f;
            _t50 = 0.0f;
        }
        float _t57 = Math.fma(_t31, _t49, -(_t30 * _t50));
        float _t58 = Math.fma(_t29, _t50, -(_t31 * _t48));
        float _t59 = Math.fma(_t30, _t48, -(_t29 * _t49));
        dest[destOffset + 0] = _t48;
        dest[destOffset + 1] = _t57;
        dest[destOffset + 2] = -_t29;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _t49;
        dest[destOffset + 5] = _t58;
        dest[destOffset + 6] = -_t30;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _t50;
        dest[destOffset + 9] = _t59;
        dest[destOffset + 10] = -_t31;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -Math.fma(eyeZ, _t50, Math.fma(eyeX, _t48, eyeY * _t49));
        dest[destOffset + 13] = -Math.fma(eyeZ, _t59, Math.fma(eyeX, _t57, eyeY * _t58));
        dest[destOffset + 14] = Math.fma(eyeZ, _t31, Math.fma(eyeX, _t29, eyeY * _t30));
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleView_lh(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] p, int pOffset, float[] x, int xOffset, float[] y, int yOffset) {
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _px = p[pOffset + 0];
        float _py = p[pOffset + 1];
        float _pz = p[pOffset + 2];
        float _xx = x[xOffset + 0];
        float _xy = x[xOffset + 1];
        float _xz = x[xOffset + 2];
        float _yx = y[yOffset + 0];
        float _yy = y[yOffset + 1];
        float _yz = y[yOffset + 2];
        float _t12 = Math.fma(_xy, _yx, -(_xx * _yy));
        float _t13 = Math.fma(_xz, _yy, -(_xy * _yz));
        float _t14 = Math.fma(_xx, _yz, -(_xz * _yx));
        float _t18 = Math.fma(_pz - _eyez, _t12, Math.fma(_px - _eyex, _t13, (_py - _eyey) * _t14)) >= 0.0f ? 1.0f : -1.0f;
        float _t19 = Math.fma(_t12, _t18, _eyez - _eyez);
        float _t20 = Math.fma(_t13, _t18, _eyex - _eyex);
        float _t21 = Math.fma(_t14, _t18, _eyey - _eyey);
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t21 * _t25;
            _t30 = _t20 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        float _t38 = Math.fma(_yx, _t29, -(_yy * _t30));
        float _t39 = Math.fma(_yy, _t31, -(_yz * _t29));
        float _t40 = Math.fma(_yz, _t30, -(_yx * _t31));
        float _t43 = Math.fma(_t38, _t38, Math.fma(_t39, _t39, _t40 * _t40));
        float _t44 = (1.0f / (float) Math.sqrt(_t43));
        float _t48, _t49, _t50;
        if (_t43 > 0.0f) {
            _t48 = _t39 * _t44;
            _t49 = _t40 * _t44;
            _t50 = _t38 * _t44;
        } else {
            _t48 = 0.0f;
            _t49 = 0.0f;
            _t50 = 0.0f;
        }
        float _t57 = Math.fma(_t29, _t50, -(_t31 * _t49));
        float _t58 = Math.fma(_t31, _t48, -(_t30 * _t50));
        float _t59 = Math.fma(_t30, _t49, -(_t29 * _t48));
        dest[destOffset + 0] = _t48;
        dest[destOffset + 1] = _t57;
        dest[destOffset + 2] = _t30;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _t49;
        dest[destOffset + 5] = _t58;
        dest[destOffset + 6] = _t29;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _t50;
        dest[destOffset + 9] = _t59;
        dest[destOffset + 10] = _t31;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -Math.fma(_eyez, _t50, Math.fma(_eyex, _t48, _eyey * _t49));
        dest[destOffset + 13] = -Math.fma(_eyez, _t59, Math.fma(_eyex, _t57, _eyey * _t58));
        dest[destOffset + 14] = -Math.fma(_eyez, _t31, Math.fma(_eyex, _t30, _eyey * _t29));
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] makePerspectiveOffCenterRectangleView_rh(float[] dest, int destOffset, float[] eye, int eyeOffset, float[] p, int pOffset, float[] x, int xOffset, float[] y, int yOffset) {
        float _eyex = eye[eyeOffset + 0];
        float _eyey = eye[eyeOffset + 1];
        float _eyez = eye[eyeOffset + 2];
        float _px = p[pOffset + 0];
        float _py = p[pOffset + 1];
        float _pz = p[pOffset + 2];
        float _xx = x[xOffset + 0];
        float _xy = x[xOffset + 1];
        float _xz = x[xOffset + 2];
        float _yx = y[yOffset + 0];
        float _yy = y[yOffset + 1];
        float _yz = y[yOffset + 2];
        float _t12 = Math.fma(_xy, _yx, -(_xx * _yy));
        float _t13 = Math.fma(_xz, _yy, -(_xy * _yz));
        float _t14 = Math.fma(_xx, _yz, -(_xz * _yx));
        float _t18 = Math.fma(_pz - _eyez, _t12, Math.fma(_px - _eyex, _t13, (_py - _eyey) * _t14)) >= 0.0f ? 1.0f : -1.0f;
        float _t19 = Math.fma(_t12, _t18, _eyez - _eyez);
        float _t20 = Math.fma(_t13, _t18, _eyex - _eyex);
        float _t21 = Math.fma(_t14, _t18, _eyey - _eyey);
        float _t24 = Math.fma(_t19, _t19, Math.fma(_t20, _t20, _t21 * _t21));
        float _t25 = (1.0f / (float) Math.sqrt(_t24));
        float _t29, _t30, _t31;
        if (_t24 > 0.0f) {
            _t29 = _t20 * _t25;
            _t30 = _t21 * _t25;
            _t31 = _t19 * _t25;
        } else {
            _t29 = 0.0f;
            _t30 = 0.0f;
            _t31 = 0.0f;
        }
        float _t38 = Math.fma(_yy, _t29, -(_yx * _t30));
        float _t39 = Math.fma(_yx, _t31, -(_yz * _t29));
        float _t40 = Math.fma(_yz, _t30, -(_yy * _t31));
        float _t43 = Math.fma(_t38, _t38, Math.fma(_t39, _t39, _t40 * _t40));
        float _t44 = (1.0f / (float) Math.sqrt(_t43));
        float _t48, _t49, _t50;
        if (_t43 > 0.0f) {
            _t48 = _t40 * _t44;
            _t49 = _t39 * _t44;
            _t50 = _t38 * _t44;
        } else {
            _t48 = 0.0f;
            _t49 = 0.0f;
            _t50 = 0.0f;
        }
        float _t57 = Math.fma(_t31, _t49, -(_t30 * _t50));
        float _t58 = Math.fma(_t29, _t50, -(_t31 * _t48));
        float _t59 = Math.fma(_t30, _t48, -(_t29 * _t49));
        dest[destOffset + 0] = _t48;
        dest[destOffset + 1] = _t57;
        dest[destOffset + 2] = -_t29;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = _t49;
        dest[destOffset + 5] = _t58;
        dest[destOffset + 6] = -_t30;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = _t50;
        dest[destOffset + 9] = _t59;
        dest[destOffset + 10] = -_t31;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -Math.fma(_eyez, _t50, Math.fma(_eyex, _t48, _eyey * _t49));
        dest[destOffset + 13] = -Math.fma(_eyez, _t59, Math.fma(_eyex, _t57, _eyey * _t58));
        dest[destOffset + 14] = Math.fma(_eyez, _t31, Math.fma(_eyex, _t29, _eyey * _t30));
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] obliqueZ_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float planeX, float planeY, float planeZ, float planeW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = 2.0f * _self23;
        float _t15 = Math.fma(planeW, 1.0f - _self22, _self23 * (planeZ + (planeX * ((planeX < 0.0f ? -1.0f : planeX > 0.0f ? 1.0f : 0.0f) - _self02) / _self00 + planeY * ((planeY < 0.0f ? -1.0f : planeY > 0.0f ? 1.0f : 0.0f) - _self12) / _self11)));
        float _t15_inv = 1.0f / _t15;
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = planeX * _t0 * _t15_inv - _self30;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = planeY * _t0 * _t15_inv - _self31;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = planeZ * _t0 * _t15_inv - _self32;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = planeW * _t0 * _t15_inv - _self33;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] obliqueZ_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float planeX, float planeY, float planeZ, float planeW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = 2.0f * _self23;
        float _t15 = Math.fma(planeW, 1.0f + _self22, _self23 * (planeX * (_self02 + (planeX < 0.0f ? -1.0f : planeX > 0.0f ? 1.0f : 0.0f)) / _self00 + planeY * (_self12 + (planeY < 0.0f ? -1.0f : planeY > 0.0f ? 1.0f : 0.0f)) / _self11 - planeZ));
        float _t15_inv = 1.0f / _t15;
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = planeX * _t0 * _t15_inv - _self30;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = planeY * _t0 * _t15_inv - _self31;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = planeZ * _t0 * _t15_inv - _self32;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = planeW * _t0 * _t15_inv - _self33;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] obliqueZ_no(float[] dest, int destOffset, float[] src, int srcOffset, float planeX, float planeY, float planeZ, float planeW, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.obliqueZ_no_lh(dest, destOffset, src, srcOffset, planeX, planeY, planeZ, planeW); }
            default -> { return Float4x4OpsKernelsArray.obliqueZ_no_rh(dest, destOffset, src, srcOffset, planeX, planeY, planeZ, planeW); }
        }
    }

    public static float[] obliqueZ_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float planeX, float planeY, float planeZ, float planeW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t14 = Math.fma(planeW, 1.0f - _self22, _self23 * (planeZ + (planeX * ((planeX < 0.0f ? -1.0f : planeX > 0.0f ? 1.0f : 0.0f) - _self02) / _self00 + planeY * ((planeY < 0.0f ? -1.0f : planeY > 0.0f ? 1.0f : 0.0f) - _self12) / _self11)));
        float _t14_inv = 1.0f / _t14;
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = planeX * _self23 * _t14_inv;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = planeY * _self23 * _t14_inv;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = planeZ * _self23 * _t14_inv;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = planeW * _self23 * _t14_inv;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] obliqueZ_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float planeX, float planeY, float planeZ, float planeW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t14 = Math.fma(planeW, 1.0f + _self22, _self23 * (planeX * (_self02 + (planeX < 0.0f ? -1.0f : planeX > 0.0f ? 1.0f : 0.0f)) / _self00 + planeY * (_self12 + (planeY < 0.0f ? -1.0f : planeY > 0.0f ? 1.0f : 0.0f)) / _self11 - planeZ));
        float _t14_inv = 1.0f / _t14;
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = planeX * _self23 * _t14_inv;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = planeY * _self23 * _t14_inv;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = planeZ * _self23 * _t14_inv;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = planeW * _self23 * _t14_inv;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] obliqueZ_zo(float[] dest, int destOffset, float[] src, int srcOffset, float planeX, float planeY, float planeZ, float planeW, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.obliqueZ_zo_lh(dest, destOffset, src, srcOffset, planeX, planeY, planeZ, planeW); }
            default -> { return Float4x4OpsKernelsArray.obliqueZ_zo_rh(dest, destOffset, src, srcOffset, planeX, planeY, planeZ, planeW); }
        }
    }

    public static float[] obliqueZ_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float[] plane, int planeOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _planex = plane[planeOffset + 0];
        float _planey = plane[planeOffset + 1];
        float _planez = plane[planeOffset + 2];
        float _planew = plane[planeOffset + 3];
        float _t0 = 2.0f * _self23;
        float _t15 = Math.fma(_planew, 1.0f - _self22, _self23 * (_planez + (_planex * ((_planex < 0.0f ? -1.0f : _planex > 0.0f ? 1.0f : 0.0f) - _self02) / _self00 + _planey * ((_planey < 0.0f ? -1.0f : _planey > 0.0f ? 1.0f : 0.0f) - _self12) / _self11)));
        float _t15_inv = 1.0f / _t15;
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _planex * _t0 * _t15_inv - _self30;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _planey * _t0 * _t15_inv - _self31;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _planez * _t0 * _t15_inv - _self32;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _planew * _t0 * _t15_inv - _self33;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] obliqueZ_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float[] plane, int planeOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _planex = plane[planeOffset + 0];
        float _planey = plane[planeOffset + 1];
        float _planez = plane[planeOffset + 2];
        float _planew = plane[planeOffset + 3];
        float _t0 = 2.0f * _self23;
        float _t15 = Math.fma(_planew, 1.0f + _self22, _self23 * (_planex * (_self02 + (_planex < 0.0f ? -1.0f : _planex > 0.0f ? 1.0f : 0.0f)) / _self00 + _planey * (_self12 + (_planey < 0.0f ? -1.0f : _planey > 0.0f ? 1.0f : 0.0f)) / _self11 - _planez));
        float _t15_inv = 1.0f / _t15;
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _planex * _t0 * _t15_inv - _self30;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _planey * _t0 * _t15_inv - _self31;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _planez * _t0 * _t15_inv - _self32;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _planew * _t0 * _t15_inv - _self33;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] obliqueZ_no(float[] dest, int destOffset, float[] src, int srcOffset, float[] plane, int planeOffset, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.obliqueZ_no_lh(dest, destOffset, src, srcOffset, plane, planeOffset); }
            default -> { return Float4x4OpsKernelsArray.obliqueZ_no_rh(dest, destOffset, src, srcOffset, plane, planeOffset); }
        }
    }

    public static float[] obliqueZ_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float[] plane, int planeOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _planex = plane[planeOffset + 0];
        float _planey = plane[planeOffset + 1];
        float _planez = plane[planeOffset + 2];
        float _planew = plane[planeOffset + 3];
        float _t14 = Math.fma(_planew, 1.0f - _self22, _self23 * (_planez + (_planex * ((_planex < 0.0f ? -1.0f : _planex > 0.0f ? 1.0f : 0.0f) - _self02) / _self00 + _planey * ((_planey < 0.0f ? -1.0f : _planey > 0.0f ? 1.0f : 0.0f) - _self12) / _self11)));
        float _t14_inv = 1.0f / _t14;
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _planex * _self23 * _t14_inv;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _planey * _self23 * _t14_inv;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _planez * _self23 * _t14_inv;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _planew * _self23 * _t14_inv;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] obliqueZ_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float[] plane, int planeOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _planex = plane[planeOffset + 0];
        float _planey = plane[planeOffset + 1];
        float _planez = plane[planeOffset + 2];
        float _planew = plane[planeOffset + 3];
        float _t14 = Math.fma(_planew, 1.0f + _self22, _self23 * (_planex * (_self02 + (_planex < 0.0f ? -1.0f : _planex > 0.0f ? 1.0f : 0.0f)) / _self00 + _planey * (_self12 + (_planey < 0.0f ? -1.0f : _planey > 0.0f ? 1.0f : 0.0f)) / _self11 - _planez));
        float _t14_inv = 1.0f / _t14;
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _planex * _self23 * _t14_inv;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _planey * _self23 * _t14_inv;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _planez * _self23 * _t14_inv;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 14] = _planew * _self23 * _t14_inv;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] obliqueZ_zo(float[] dest, int destOffset, float[] src, int srcOffset, float[] plane, int planeOffset, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.obliqueZ_zo_lh(dest, destOffset, src, srcOffset, plane, planeOffset); }
            default -> { return Float4x4OpsKernelsArray.obliqueZ_zo_rh(dest, destOffset, src, srcOffset, plane, planeOffset); }
        }
    }

    public static float[] ortho_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        float _t3 = left + right;
        float _t4 = bottom + top;
        float _t5 = zFar + zNear;
        dest[destOffset + 0] = 2.0f * _self00 * _t0_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t0_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t0_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t0_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t1_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t1_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t1_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t1_inv;
        dest[destOffset + 8] = 2.0f * _self02 * _t2_inv;
        dest[destOffset + 9] = 2.0f * _self12 * _t2_inv;
        dest[destOffset + 10] = 2.0f * _self22 * _t2_inv;
        dest[destOffset + 11] = 2.0f * _self32 * _t2_inv;
        dest[destOffset + 12] = _self03 + (-(_self00 * _t3 * _t0_inv) - _self01 * _t4 * _t1_inv - _self02 * _t5 * _t2_inv);
        dest[destOffset + 13] = _self13 + (-(_self10 * _t3 * _t0_inv) - _self11 * _t4 * _t1_inv - _self12 * _t5 * _t2_inv);
        dest[destOffset + 14] = _self23 + (-(_self20 * _t3 * _t0_inv) - _self21 * _t4 * _t1_inv - _self22 * _t5 * _t2_inv);
        dest[destOffset + 15] = _self33 + (-(_self30 * _t3 * _t0_inv) - _self31 * _t4 * _t1_inv - _self32 * _t5 * _t2_inv);
        return dest;
    }

    public static float[] ortho_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        float _t3 = left + right;
        float _t4 = bottom + top;
        float _t5 = zFar + zNear;
        dest[destOffset + 0] = 2.0f * _self00 * _t0_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t0_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t0_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t0_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t1_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t1_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t1_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t1_inv;
        dest[destOffset + 8] = -2.0f * _self02 * _t2_inv;
        dest[destOffset + 9] = -2.0f * _self12 * _t2_inv;
        dest[destOffset + 10] = -2.0f * _self22 * _t2_inv;
        dest[destOffset + 11] = -2.0f * _self32 * _t2_inv;
        dest[destOffset + 12] = _self03 + (-(_self00 * _t3 * _t0_inv) - _self01 * _t4 * _t1_inv - _self02 * _t5 * _t2_inv);
        dest[destOffset + 13] = _self13 + (-(_self10 * _t3 * _t0_inv) - _self11 * _t4 * _t1_inv - _self12 * _t5 * _t2_inv);
        dest[destOffset + 14] = _self23 + (-(_self20 * _t3 * _t0_inv) - _self21 * _t4 * _t1_inv - _self22 * _t5 * _t2_inv);
        dest[destOffset + 15] = _self33 + (-(_self30 * _t3 * _t0_inv) - _self31 * _t4 * _t1_inv - _self32 * _t5 * _t2_inv);
        return dest;
    }

    public static float[] ortho_no(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.ortho_no_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsArray.ortho_no_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static float[] ortho_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        float _t3 = left + right;
        float _t4 = bottom + top;
        dest[destOffset + 0] = 2.0f * _self00 * _t0_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t0_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t0_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t0_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t1_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t1_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t1_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t1_inv;
        dest[destOffset + 8] = _self02 * _t2_inv;
        dest[destOffset + 9] = _self12 * _t2_inv;
        dest[destOffset + 10] = _self22 * _t2_inv;
        dest[destOffset + 11] = _self32 * _t2_inv;
        dest[destOffset + 12] = _self03 + (-(_self00 * _t3 * _t0_inv) - _self01 * _t4 * _t1_inv - zNear * _self02 * _t2_inv);
        dest[destOffset + 13] = _self13 + (-(_self10 * _t3 * _t0_inv) - _self11 * _t4 * _t1_inv - zNear * _self12 * _t2_inv);
        dest[destOffset + 14] = _self23 + (-(_self20 * _t3 * _t0_inv) - _self21 * _t4 * _t1_inv - zNear * _self22 * _t2_inv);
        dest[destOffset + 15] = _self33 + (-(_self30 * _t3 * _t0_inv) - _self31 * _t4 * _t1_inv - zNear * _self32 * _t2_inv);
        return dest;
    }

    public static float[] ortho_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = zFar - zNear;
        float _t2_inv = 1.0f / _t2;
        float _t3 = left + right;
        float _t4 = bottom + top;
        dest[destOffset + 0] = 2.0f * _self00 * _t0_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t0_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t0_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t0_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t1_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t1_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t1_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t1_inv;
        dest[destOffset + 8] = -(_self02 * _t2_inv);
        dest[destOffset + 9] = -(_self12 * _t2_inv);
        dest[destOffset + 10] = -(_self22 * _t2_inv);
        dest[destOffset + 11] = -(_self32 * _t2_inv);
        dest[destOffset + 12] = _self03 + (-(_self00 * _t3 * _t0_inv) - _self01 * _t4 * _t1_inv - zNear * _self02 * _t2_inv);
        dest[destOffset + 13] = _self13 + (-(_self10 * _t3 * _t0_inv) - _self11 * _t4 * _t1_inv - zNear * _self12 * _t2_inv);
        dest[destOffset + 14] = _self23 + (-(_self20 * _t3 * _t0_inv) - _self21 * _t4 * _t1_inv - zNear * _self22 * _t2_inv);
        dest[destOffset + 15] = _self33 + (-(_self30 * _t3 * _t0_inv) - _self31 * _t4 * _t1_inv - zNear * _self32 * _t2_inv);
        return dest;
    }

    public static float[] ortho_zo(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, float zNear, float zFar, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.ortho_zo_lh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
            default -> { return Float4x4OpsKernelsArray.ortho_zo_rh(dest, destOffset, src, srcOffset, left, right, bottom, top, zNear, zFar); }
        }
    }

    public static float[] ortho2D_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        dest[destOffset + 0] = 2.0f * _self00 * _t0_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t0_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t0_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t0_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t1_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t1_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t1_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t1_inv;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 10] = _self22;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03 + (-(_self00 * _t2 * _t0_inv) - _self01 * _t3 * _t1_inv);
        dest[destOffset + 13] = _self13 + (-(_self10 * _t2 * _t0_inv) - _self11 * _t3 * _t1_inv);
        dest[destOffset + 14] = _self23 + (-(_self20 * _t2 * _t0_inv) - _self21 * _t3 * _t1_inv);
        dest[destOffset + 15] = _self33 + (-(_self30 * _t2 * _t0_inv) - _self31 * _t3 * _t1_inv);
        return dest;
    }

    public static float[] ortho2D_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        dest[destOffset + 0] = 2.0f * _self00 * _t0_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t0_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t0_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t0_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t1_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t1_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t1_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t1_inv;
        dest[destOffset + 8] = -_self02;
        dest[destOffset + 9] = -_self12;
        dest[destOffset + 10] = -_self22;
        dest[destOffset + 11] = -_self32;
        dest[destOffset + 12] = _self03 + (-(_self00 * _t2 * _t0_inv) - _self01 * _t3 * _t1_inv);
        dest[destOffset + 13] = _self13 + (-(_self10 * _t2 * _t0_inv) - _self11 * _t3 * _t1_inv);
        dest[destOffset + 14] = _self23 + (-(_self20 * _t2 * _t0_inv) - _self21 * _t3 * _t1_inv);
        dest[destOffset + 15] = _self33 + (-(_self30 * _t2 * _t0_inv) - _self31 * _t3 * _t1_inv);
        return dest;
    }

    public static float[] ortho2D_no(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.ortho2D_no_lh(dest, destOffset, src, srcOffset, left, right, bottom, top); }
            default -> { return Float4x4OpsKernelsArray.ortho2D_no_rh(dest, destOffset, src, srcOffset, left, right, bottom, top); }
        }
    }

    public static float[] ortho2D_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        dest[destOffset + 0] = 2.0f * _self00 * _t0_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t0_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t0_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t0_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t1_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t1_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t1_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t1_inv;
        dest[destOffset + 8] = 0.5f * _self02;
        dest[destOffset + 9] = 0.5f * _self12;
        dest[destOffset + 10] = 0.5f * _self22;
        dest[destOffset + 11] = 0.5f * _self32;
        dest[destOffset + 12] = Math.fma(0.5f, _self02, _self03 - _self00 * _t2 * _t0_inv - _self01 * _t3 * _t1_inv);
        dest[destOffset + 13] = Math.fma(0.5f, _self12, _self13 - _self10 * _t2 * _t0_inv - _self11 * _t3 * _t1_inv);
        dest[destOffset + 14] = Math.fma(0.5f, _self22, _self23 - _self20 * _t2 * _t0_inv - _self21 * _t3 * _t1_inv);
        dest[destOffset + 15] = Math.fma(0.5f, _self32, _self33 - _self30 * _t2 * _t0_inv - _self31 * _t3 * _t1_inv);
        return dest;
    }

    public static float[] ortho2D_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = right - left;
        float _t0_inv = 1.0f / _t0;
        float _t1 = top - bottom;
        float _t1_inv = 1.0f / _t1;
        float _t2 = left + right;
        float _t3 = bottom + top;
        dest[destOffset + 0] = 2.0f * _self00 * _t0_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t0_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t0_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t0_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t1_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t1_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t1_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t1_inv;
        dest[destOffset + 8] = -0.5f * _self02;
        dest[destOffset + 9] = -0.5f * _self12;
        dest[destOffset + 10] = -0.5f * _self22;
        dest[destOffset + 11] = -0.5f * _self32;
        dest[destOffset + 12] = Math.fma(0.5f, _self02, _self03 - _self00 * _t2 * _t0_inv - _self01 * _t3 * _t1_inv);
        dest[destOffset + 13] = Math.fma(0.5f, _self12, _self13 - _self10 * _t2 * _t0_inv - _self11 * _t3 * _t1_inv);
        dest[destOffset + 14] = Math.fma(0.5f, _self22, _self23 - _self20 * _t2 * _t0_inv - _self21 * _t3 * _t1_inv);
        dest[destOffset + 15] = Math.fma(0.5f, _self32, _self33 - _self30 * _t2 * _t0_inv - _self31 * _t3 * _t1_inv);
        return dest;
    }

    public static float[] ortho2D_zo(float[] dest, int destOffset, float[] src, int srcOffset, float left, float right, float bottom, float top, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.ortho2D_zo_lh(dest, destOffset, src, srcOffset, left, right, bottom, top); }
            default -> { return Float4x4OpsKernelsArray.ortho2D_zo_rh(dest, destOffset, src, srcOffset, left, right, bottom, top); }
        }
    }

    public static float[] orthoCrop_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _view00 = view[viewOffset + 0];
        float _view10 = view[viewOffset + 1];
        float _view20 = view[viewOffset + 2];
        float _view01 = view[viewOffset + 4];
        float _view11 = view[viewOffset + 5];
        float _view21 = view[viewOffset + 6];
        float _view02 = view[viewOffset + 8];
        float _view12 = view[viewOffset + 9];
        float _view22 = view[viewOffset + 10];
        float _view03 = view[viewOffset + 12];
        float _view13 = view[viewOffset + 13];
        float _view23 = view[viewOffset + 14];
        float _t4 = _self20 - _self21;
        float _t5 = _self00 - _self01;
        float _t6 = _self10 - _self11;
        float _t7 = _self30 - _self31;
        float _t8 = _self21 - _self20;
        float _t9 = _self01 - _self00;
        float _t10 = _self11 - _self10;
        float _t11 = _self31 - _self30;
        float _t12 = _self20 + _self21;
        float _t13 = _self00 + _self01;
        float _t14 = _self10 + _self11;
        float _t15 = _self30 + _self31;
        float _t16 = -_self20 - _self21;
        float _t17 = -_self00 - _self01;
        float _t18 = -_self10 - _self11;
        float _t19 = -_self30 - _self31;
        float _t52 = _self23 + (_t4 - _self22);
        float _t53 = _self03 + (_t5 - _self02);
        float _t54 = _self13 + (_t6 - _self12);
        float _t55 = _self33 + (_t7 - _self32);
        float _t55_inv = 1.0f / _t55;
        float _t56 = _self23 + (_t8 - _self22);
        float _t57 = _self03 + (_t9 - _self02);
        float _t58 = _self13 + (_t10 - _self12);
        float _t59 = _self33 + (_t11 - _self32);
        float _t59_inv = 1.0f / _t59;
        float _t60 = _self23 + (_t12 - _self22);
        float _t61 = _self03 + (_t13 - _self02);
        float _t62 = _self13 + (_t14 - _self12);
        float _t63 = _self33 + (_t15 - _self32);
        float _t63_inv = 1.0f / _t63;
        float _t64 = _self23 + (_self22 + _t4);
        float _t65 = _self03 + (_self02 + _t5);
        float _t66 = _self13 + (_self12 + _t6);
        float _t67 = _self33 + (_self32 + _t7);
        float _t67_inv = 1.0f / _t67;
        float _t68 = _self23 + (_self22 + _t8);
        float _t69 = _self03 + (_self02 + _t9);
        float _t70 = _self13 + (_self12 + _t10);
        float _t71 = _self33 + (_self32 + _t11);
        float _t71_inv = 1.0f / _t71;
        float _t72 = _self23 + (_self22 + _t12);
        float _t73 = _self03 + (_self02 + _t13);
        float _t74 = _self13 + (_self12 + _t14);
        float _t75 = _self33 + (_self32 + _t15);
        float _t75_inv = 1.0f / _t75;
        float _t76 = _self23 + (_t16 - _self22);
        float _t77 = _self03 + (_t17 - _self02);
        float _t78 = _self13 + (_t18 - _self12);
        float _t79 = _self33 + (_t19 - _self32);
        float _t79_inv = 1.0f / _t79;
        float _t80 = _self23 + (_self22 + _t16);
        float _t81 = _self03 + (_self02 + _t17);
        float _t82 = _self13 + (_self12 + _t18);
        float _t83 = _self33 + (_self32 + _t19);
        float _t83_inv = 1.0f / _t83;
        float _t174 = _view03 + Math.fma(_view02, _t52, Math.fma(_view00, _t53, _view01 * _t54)) * _t55_inv;
        float _t175 = _view03 + Math.fma(_view02, _t56, Math.fma(_view00, _t57, _view01 * _t58)) * _t59_inv;
        float _t176 = _view03 + Math.fma(_view02, _t60, Math.fma(_view00, _t61, _view01 * _t62)) * _t63_inv;
        float _t177 = _view03 + Math.fma(_view02, _t64, Math.fma(_view00, _t65, _view01 * _t66)) * _t67_inv;
        float _t178 = _view03 + Math.fma(_view02, _t68, Math.fma(_view00, _t69, _view01 * _t70)) * _t71_inv;
        float _t179 = _view03 + Math.fma(_view02, _t72, Math.fma(_view00, _t73, _view01 * _t74)) * _t75_inv;
        float _t180 = _view13 + Math.fma(_view12, _t52, Math.fma(_view10, _t53, _view11 * _t54)) * _t55_inv;
        float _t181 = _view13 + Math.fma(_view12, _t56, Math.fma(_view10, _t57, _view11 * _t58)) * _t59_inv;
        float _t182 = _view13 + Math.fma(_view12, _t60, Math.fma(_view10, _t61, _view11 * _t62)) * _t63_inv;
        float _t183 = _view13 + Math.fma(_view12, _t64, Math.fma(_view10, _t65, _view11 * _t66)) * _t67_inv;
        float _t184 = _view13 + Math.fma(_view12, _t68, Math.fma(_view10, _t69, _view11 * _t70)) * _t71_inv;
        float _t185 = _view13 + Math.fma(_view12, _t72, Math.fma(_view10, _t73, _view11 * _t74)) * _t75_inv;
        float _t186 = _view23 + Math.fma(_view22, _t52, Math.fma(_view20, _t53, _view21 * _t54)) * _t55_inv;
        float _t187 = _view23 + Math.fma(_view22, _t56, Math.fma(_view20, _t57, _view21 * _t58)) * _t59_inv;
        float _t188 = _view23 + Math.fma(_view22, _t60, Math.fma(_view20, _t61, _view21 * _t62)) * _t63_inv;
        float _t189 = _view23 + Math.fma(_view22, _t64, Math.fma(_view20, _t65, _view21 * _t66)) * _t67_inv;
        float _t190 = _view23 + Math.fma(_view22, _t68, Math.fma(_view20, _t69, _view21 * _t70)) * _t71_inv;
        float _t191 = _view23 + Math.fma(_view22, _t72, Math.fma(_view20, _t73, _view21 * _t74)) * _t75_inv;
        float _t198 = _view03 + Math.fma(_view02, _t76, Math.fma(_view00, _t77, _view01 * _t78)) * _t79_inv;
        float _t199 = _view03 + Math.fma(_view02, _t80, Math.fma(_view00, _t81, _view01 * _t82)) * _t83_inv;
        float _t200 = _view13 + Math.fma(_view12, _t76, Math.fma(_view10, _t77, _view11 * _t78)) * _t79_inv;
        float _t201 = _view13 + Math.fma(_view12, _t80, Math.fma(_view10, _t81, _view11 * _t82)) * _t83_inv;
        float _t202 = _view23 + Math.fma(_view22, _t76, Math.fma(_view20, _t77, _view21 * _t78)) * _t79_inv;
        float _t203 = _view23 + Math.fma(_view22, _t80, Math.fma(_view20, _t81, _view21 * _t82)) * _t83_inv;
        float _t240 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t198, _t174), _t175), _t176), _t199), _t177), _t178), _t179);
        float _t241 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t198, _t174), _t175), _t176), _t199), _t177), _t178), _t179);
        float _t242 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t200, _t180), _t181), _t182), _t201), _t183), _t184), _t185);
        float _t243 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t200, _t180), _t181), _t182), _t201), _t183), _t184), _t185);
        float _t244 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t202, _t186), _t187), _t188), _t203), _t189), _t190), _t191);
        float _t245 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t202, _t186), _t187), _t188), _t203), _t189), _t190), _t191);
        float _t246 = _t240 - _t241;
        float _t246_inv = 1.0f / _t246;
        float _t247 = _t242 - _t243;
        float _t247_inv = 1.0f / _t247;
        float _t248 = _t244 - _t245;
        float _t248_inv = 1.0f / _t248;
        dest[destOffset + 0] = 2.0f * _t246_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t247_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = 2.0f * _t248_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((_t241 + _t240) * _t246_inv);
        dest[destOffset + 13] = -((_t243 + _t242) * _t247_inv);
        dest[destOffset + 14] = -((_t245 + _t244) * _t248_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] orthoCrop_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _view00 = view[viewOffset + 0];
        float _view10 = view[viewOffset + 1];
        float _view20 = view[viewOffset + 2];
        float _view01 = view[viewOffset + 4];
        float _view11 = view[viewOffset + 5];
        float _view21 = view[viewOffset + 6];
        float _view02 = view[viewOffset + 8];
        float _view12 = view[viewOffset + 9];
        float _view22 = view[viewOffset + 10];
        float _view03 = view[viewOffset + 12];
        float _view13 = view[viewOffset + 13];
        float _view23 = view[viewOffset + 14];
        float _t4 = _self20 - _self21;
        float _t5 = _self00 - _self01;
        float _t6 = _self10 - _self11;
        float _t7 = _self30 - _self31;
        float _t8 = _self21 - _self20;
        float _t9 = _self01 - _self00;
        float _t10 = _self11 - _self10;
        float _t11 = _self31 - _self30;
        float _t12 = _self20 + _self21;
        float _t13 = _self00 + _self01;
        float _t14 = _self10 + _self11;
        float _t15 = _self30 + _self31;
        float _t16 = -_self20 - _self21;
        float _t17 = -_self00 - _self01;
        float _t18 = -_self10 - _self11;
        float _t19 = -_self30 - _self31;
        float _t52 = _self23 + (_t4 - _self22);
        float _t53 = _self03 + (_t5 - _self02);
        float _t54 = _self13 + (_t6 - _self12);
        float _t55 = _self33 + (_t7 - _self32);
        float _t55_inv = 1.0f / _t55;
        float _t56 = _self23 + (_t8 - _self22);
        float _t57 = _self03 + (_t9 - _self02);
        float _t58 = _self13 + (_t10 - _self12);
        float _t59 = _self33 + (_t11 - _self32);
        float _t59_inv = 1.0f / _t59;
        float _t60 = _self23 + (_t12 - _self22);
        float _t61 = _self03 + (_t13 - _self02);
        float _t62 = _self13 + (_t14 - _self12);
        float _t63 = _self33 + (_t15 - _self32);
        float _t63_inv = 1.0f / _t63;
        float _t64 = _self23 + (_self22 + _t4);
        float _t65 = _self03 + (_self02 + _t5);
        float _t66 = _self13 + (_self12 + _t6);
        float _t67 = _self33 + (_self32 + _t7);
        float _t67_inv = 1.0f / _t67;
        float _t68 = _self23 + (_self22 + _t8);
        float _t69 = _self03 + (_self02 + _t9);
        float _t70 = _self13 + (_self12 + _t10);
        float _t71 = _self33 + (_self32 + _t11);
        float _t71_inv = 1.0f / _t71;
        float _t72 = _self23 + (_self22 + _t12);
        float _t73 = _self03 + (_self02 + _t13);
        float _t74 = _self13 + (_self12 + _t14);
        float _t75 = _self33 + (_self32 + _t15);
        float _t75_inv = 1.0f / _t75;
        float _t76 = _self23 + (_t16 - _self22);
        float _t77 = _self03 + (_t17 - _self02);
        float _t78 = _self13 + (_t18 - _self12);
        float _t79 = _self33 + (_t19 - _self32);
        float _t79_inv = 1.0f / _t79;
        float _t80 = _self23 + (_self22 + _t16);
        float _t81 = _self03 + (_self02 + _t17);
        float _t82 = _self13 + (_self12 + _t18);
        float _t83 = _self33 + (_self32 + _t19);
        float _t83_inv = 1.0f / _t83;
        float _t174 = _view03 + Math.fma(_view02, _t52, Math.fma(_view00, _t53, _view01 * _t54)) * _t55_inv;
        float _t175 = _view03 + Math.fma(_view02, _t56, Math.fma(_view00, _t57, _view01 * _t58)) * _t59_inv;
        float _t176 = _view03 + Math.fma(_view02, _t60, Math.fma(_view00, _t61, _view01 * _t62)) * _t63_inv;
        float _t177 = _view03 + Math.fma(_view02, _t64, Math.fma(_view00, _t65, _view01 * _t66)) * _t67_inv;
        float _t178 = _view03 + Math.fma(_view02, _t68, Math.fma(_view00, _t69, _view01 * _t70)) * _t71_inv;
        float _t179 = _view03 + Math.fma(_view02, _t72, Math.fma(_view00, _t73, _view01 * _t74)) * _t75_inv;
        float _t180 = _view13 + Math.fma(_view12, _t52, Math.fma(_view10, _t53, _view11 * _t54)) * _t55_inv;
        float _t181 = _view13 + Math.fma(_view12, _t56, Math.fma(_view10, _t57, _view11 * _t58)) * _t59_inv;
        float _t182 = _view13 + Math.fma(_view12, _t60, Math.fma(_view10, _t61, _view11 * _t62)) * _t63_inv;
        float _t183 = _view13 + Math.fma(_view12, _t64, Math.fma(_view10, _t65, _view11 * _t66)) * _t67_inv;
        float _t184 = _view13 + Math.fma(_view12, _t68, Math.fma(_view10, _t69, _view11 * _t70)) * _t71_inv;
        float _t185 = _view13 + Math.fma(_view12, _t72, Math.fma(_view10, _t73, _view11 * _t74)) * _t75_inv;
        float _t186 = _view23 + Math.fma(_view22, _t52, Math.fma(_view20, _t53, _view21 * _t54)) * _t55_inv;
        float _t187 = _view23 + Math.fma(_view22, _t56, Math.fma(_view20, _t57, _view21 * _t58)) * _t59_inv;
        float _t188 = _view23 + Math.fma(_view22, _t60, Math.fma(_view20, _t61, _view21 * _t62)) * _t63_inv;
        float _t189 = _view23 + Math.fma(_view22, _t64, Math.fma(_view20, _t65, _view21 * _t66)) * _t67_inv;
        float _t190 = _view23 + Math.fma(_view22, _t68, Math.fma(_view20, _t69, _view21 * _t70)) * _t71_inv;
        float _t191 = _view23 + Math.fma(_view22, _t72, Math.fma(_view20, _t73, _view21 * _t74)) * _t75_inv;
        float _t198 = _view03 + Math.fma(_view02, _t76, Math.fma(_view00, _t77, _view01 * _t78)) * _t79_inv;
        float _t199 = _view03 + Math.fma(_view02, _t80, Math.fma(_view00, _t81, _view01 * _t82)) * _t83_inv;
        float _t200 = _view13 + Math.fma(_view12, _t76, Math.fma(_view10, _t77, _view11 * _t78)) * _t79_inv;
        float _t201 = _view13 + Math.fma(_view12, _t80, Math.fma(_view10, _t81, _view11 * _t82)) * _t83_inv;
        float _t202 = _view23 + Math.fma(_view22, _t76, Math.fma(_view20, _t77, _view21 * _t78)) * _t79_inv;
        float _t203 = _view23 + Math.fma(_view22, _t80, Math.fma(_view20, _t81, _view21 * _t82)) * _t83_inv;
        float _t240 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t198, _t174), _t175), _t176), _t199), _t177), _t178), _t179);
        float _t241 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t198, _t174), _t175), _t176), _t199), _t177), _t178), _t179);
        float _t242 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t200, _t180), _t181), _t182), _t201), _t183), _t184), _t185);
        float _t243 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t200, _t180), _t181), _t182), _t201), _t183), _t184), _t185);
        float _t244 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t202, _t186), _t187), _t188), _t203), _t189), _t190), _t191);
        float _t245 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t202, _t186), _t187), _t188), _t203), _t189), _t190), _t191);
        float _t246 = _t240 - _t241;
        float _t246_inv = 1.0f / _t246;
        float _t247 = _t242 - _t243;
        float _t247_inv = 1.0f / _t247;
        float _t248 = _t244 - _t245;
        float _t248_inv = 1.0f / _t248;
        dest[destOffset + 0] = 2.0f * _t246_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t247_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = -2.0f * _t248_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((_t241 + _t240) * _t246_inv);
        dest[destOffset + 13] = -((_t243 + _t242) * _t247_inv);
        dest[destOffset + 14] = -((-_t245 - _t244) * _t248_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] orthoCrop_no(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.orthoCrop_no_lh(dest, destOffset, src, srcOffset, view, viewOffset); }
            default -> { return Float4x4OpsKernelsArray.orthoCrop_no_rh(dest, destOffset, src, srcOffset, view, viewOffset); }
        }
    }

    public static float[] orthoCrop_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _view00 = view[viewOffset + 0];
        float _view10 = view[viewOffset + 1];
        float _view20 = view[viewOffset + 2];
        float _view01 = view[viewOffset + 4];
        float _view11 = view[viewOffset + 5];
        float _view21 = view[viewOffset + 6];
        float _view02 = view[viewOffset + 8];
        float _view12 = view[viewOffset + 9];
        float _view22 = view[viewOffset + 10];
        float _view03 = view[viewOffset + 12];
        float _view13 = view[viewOffset + 13];
        float _view23 = view[viewOffset + 14];
        float _t4 = _self20 - _self21;
        float _t5 = _self00 - _self01;
        float _t6 = _self10 - _self11;
        float _t7 = _self30 - _self31;
        float _t8 = _self21 - _self20;
        float _t9 = _self01 - _self00;
        float _t10 = _self11 - _self10;
        float _t11 = _self31 - _self30;
        float _t12 = _self20 + _self21;
        float _t13 = _self00 + _self01;
        float _t14 = _self10 + _self11;
        float _t15 = _self30 + _self31;
        float _t16 = -_self20 - _self21;
        float _t17 = -_self00 - _self01;
        float _t18 = -_self10 - _self11;
        float _t19 = -_self30 - _self31;
        float _t20 = _self23 + _t4;
        float _t21 = _self03 + _t5;
        float _t22 = _self13 + _t6;
        float _t23 = _self33 + _t7;
        float _t23_inv = 1.0f / _t23;
        float _t24 = _self23 + _t8;
        float _t25 = _self03 + _t9;
        float _t26 = _self13 + _t10;
        float _t27 = _self33 + _t11;
        float _t27_inv = 1.0f / _t27;
        float _t28 = _self23 + _t12;
        float _t29 = _self03 + _t13;
        float _t30 = _self13 + _t14;
        float _t31 = _self33 + _t15;
        float _t31_inv = 1.0f / _t31;
        float _t44 = _self23 + _t16;
        float _t45 = _self03 + _t17;
        float _t46 = _self13 + _t18;
        float _t47 = _self33 + _t19;
        float _t47_inv = 1.0f / _t47;
        float _t55 = _self23 + (_self22 + _t4);
        float _t56 = _self03 + (_self02 + _t5);
        float _t57 = _self13 + (_self12 + _t6);
        float _t58 = _self33 + (_self32 + _t7);
        float _t58_inv = 1.0f / _t58;
        float _t59 = _self23 + (_self22 + _t8);
        float _t60 = _self03 + (_self02 + _t9);
        float _t61 = _self13 + (_self12 + _t10);
        float _t62 = _self33 + (_self32 + _t11);
        float _t62_inv = 1.0f / _t62;
        float _t63 = _self23 + (_self22 + _t12);
        float _t64 = _self03 + (_self02 + _t13);
        float _t65 = _self13 + (_self12 + _t14);
        float _t66 = _self33 + (_self32 + _t15);
        float _t66_inv = 1.0f / _t66;
        float _t74 = _self23 + (_self22 + _t16);
        float _t75 = _self03 + (_self02 + _t17);
        float _t76 = _self13 + (_self12 + _t18);
        float _t77 = _self33 + (_self32 + _t19);
        float _t77_inv = 1.0f / _t77;
        float _t146 = _view03 + Math.fma(_view02, _t20, Math.fma(_view00, _t21, _view01 * _t22)) * _t23_inv;
        float _t147 = _view03 + Math.fma(_view02, _t24, Math.fma(_view00, _t25, _view01 * _t26)) * _t27_inv;
        float _t148 = _view03 + Math.fma(_view02, _t28, Math.fma(_view00, _t29, _view01 * _t30)) * _t31_inv;
        float _t150 = _view13 + Math.fma(_view12, _t20, Math.fma(_view10, _t21, _view11 * _t22)) * _t23_inv;
        float _t151 = _view13 + Math.fma(_view12, _t24, Math.fma(_view10, _t25, _view11 * _t26)) * _t27_inv;
        float _t152 = _view13 + Math.fma(_view12, _t28, Math.fma(_view10, _t29, _view11 * _t30)) * _t31_inv;
        float _t154 = _view23 + Math.fma(_view22, _t20, Math.fma(_view20, _t21, _view21 * _t22)) * _t23_inv;
        float _t155 = _view23 + Math.fma(_view22, _t24, Math.fma(_view20, _t25, _view21 * _t26)) * _t27_inv;
        float _t156 = _view23 + Math.fma(_view22, _t28, Math.fma(_view20, _t29, _view21 * _t30)) * _t31_inv;
        float _t161 = _view03 + Math.fma(_view02, _t44, Math.fma(_view00, _t45, _view01 * _t46)) * _t47_inv;
        float _t162 = _view13 + Math.fma(_view12, _t44, Math.fma(_view10, _t45, _view11 * _t46)) * _t47_inv;
        float _t163 = _view23 + Math.fma(_view22, _t44, Math.fma(_view20, _t45, _view21 * _t46)) * _t47_inv;
        float _t173 = _view03 + Math.fma(_view02, _t55, Math.fma(_view00, _t56, _view01 * _t57)) * _t58_inv;
        float _t174 = _view03 + Math.fma(_view02, _t59, Math.fma(_view00, _t60, _view01 * _t61)) * _t62_inv;
        float _t175 = _view03 + Math.fma(_view02, _t63, Math.fma(_view00, _t64, _view01 * _t65)) * _t66_inv;
        float _t176 = _view13 + Math.fma(_view12, _t55, Math.fma(_view10, _t56, _view11 * _t57)) * _t58_inv;
        float _t177 = _view13 + Math.fma(_view12, _t59, Math.fma(_view10, _t60, _view11 * _t61)) * _t62_inv;
        float _t178 = _view13 + Math.fma(_view12, _t63, Math.fma(_view10, _t64, _view11 * _t65)) * _t66_inv;
        float _t179 = _view23 + Math.fma(_view22, _t55, Math.fma(_view20, _t56, _view21 * _t57)) * _t58_inv;
        float _t180 = _view23 + Math.fma(_view22, _t59, Math.fma(_view20, _t60, _view21 * _t61)) * _t62_inv;
        float _t181 = _view23 + Math.fma(_view22, _t63, Math.fma(_view20, _t64, _view21 * _t65)) * _t66_inv;
        float _t185 = _view03 + Math.fma(_view02, _t74, Math.fma(_view00, _t75, _view01 * _t76)) * _t77_inv;
        float _t186 = _view13 + Math.fma(_view12, _t74, Math.fma(_view10, _t75, _view11 * _t76)) * _t77_inv;
        float _t187 = _view23 + Math.fma(_view22, _t74, Math.fma(_view20, _t75, _view21 * _t76)) * _t77_inv;
        float _t224 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t161, _t146), _t147), _t148), _t185), _t173), _t174), _t175);
        float _t225 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t161, _t146), _t147), _t148), _t185), _t173), _t174), _t175);
        float _t226 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t162, _t150), _t151), _t152), _t186), _t176), _t177), _t178);
        float _t227 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t162, _t150), _t151), _t152), _t186), _t176), _t177), _t178);
        float _t229 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t163, _t154), _t155), _t156), _t187), _t179), _t180), _t181);
        float _t230 = _t224 - _t225;
        float _t230_inv = 1.0f / _t230;
        float _t231 = _t226 - _t227;
        float _t231_inv = 1.0f / _t231;
        float _t232 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t163, _t154), _t155), _t156), _t187), _t179), _t180), _t181) - _t229;
        float _t232_inv = 1.0f / _t232;
        dest[destOffset + 0] = 2.0f * _t230_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t231_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = 1.0f * _t232_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((_t225 + _t224) * _t230_inv);
        dest[destOffset + 13] = -((_t227 + _t226) * _t231_inv);
        dest[destOffset + 14] = -(_t229 * _t232_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] orthoCrop_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _view00 = view[viewOffset + 0];
        float _view10 = view[viewOffset + 1];
        float _view20 = view[viewOffset + 2];
        float _view01 = view[viewOffset + 4];
        float _view11 = view[viewOffset + 5];
        float _view21 = view[viewOffset + 6];
        float _view02 = view[viewOffset + 8];
        float _view12 = view[viewOffset + 9];
        float _view22 = view[viewOffset + 10];
        float _view03 = view[viewOffset + 12];
        float _view13 = view[viewOffset + 13];
        float _view23 = view[viewOffset + 14];
        float _t4 = _self20 - _self21;
        float _t5 = _self00 - _self01;
        float _t6 = _self10 - _self11;
        float _t7 = _self30 - _self31;
        float _t8 = _self21 - _self20;
        float _t9 = _self01 - _self00;
        float _t10 = _self11 - _self10;
        float _t11 = _self31 - _self30;
        float _t12 = _self20 + _self21;
        float _t13 = _self00 + _self01;
        float _t14 = _self10 + _self11;
        float _t15 = _self30 + _self31;
        float _t16 = -_self20 - _self21;
        float _t17 = -_self00 - _self01;
        float _t18 = -_self10 - _self11;
        float _t19 = -_self30 - _self31;
        float _t20 = _self23 + _t4;
        float _t21 = _self03 + _t5;
        float _t22 = _self13 + _t6;
        float _t23 = _self33 + _t7;
        float _t23_inv = 1.0f / _t23;
        float _t24 = _self23 + _t8;
        float _t25 = _self03 + _t9;
        float _t26 = _self13 + _t10;
        float _t27 = _self33 + _t11;
        float _t27_inv = 1.0f / _t27;
        float _t28 = _self23 + _t12;
        float _t29 = _self03 + _t13;
        float _t30 = _self13 + _t14;
        float _t31 = _self33 + _t15;
        float _t31_inv = 1.0f / _t31;
        float _t44 = _self23 + _t16;
        float _t45 = _self03 + _t17;
        float _t46 = _self13 + _t18;
        float _t47 = _self33 + _t19;
        float _t47_inv = 1.0f / _t47;
        float _t55 = _self23 + (_self22 + _t4);
        float _t56 = _self03 + (_self02 + _t5);
        float _t57 = _self13 + (_self12 + _t6);
        float _t58 = _self33 + (_self32 + _t7);
        float _t58_inv = 1.0f / _t58;
        float _t59 = _self23 + (_self22 + _t8);
        float _t60 = _self03 + (_self02 + _t9);
        float _t61 = _self13 + (_self12 + _t10);
        float _t62 = _self33 + (_self32 + _t11);
        float _t62_inv = 1.0f / _t62;
        float _t63 = _self23 + (_self22 + _t12);
        float _t64 = _self03 + (_self02 + _t13);
        float _t65 = _self13 + (_self12 + _t14);
        float _t66 = _self33 + (_self32 + _t15);
        float _t66_inv = 1.0f / _t66;
        float _t74 = _self23 + (_self22 + _t16);
        float _t75 = _self03 + (_self02 + _t17);
        float _t76 = _self13 + (_self12 + _t18);
        float _t77 = _self33 + (_self32 + _t19);
        float _t77_inv = 1.0f / _t77;
        float _t146 = _view03 + Math.fma(_view02, _t20, Math.fma(_view00, _t21, _view01 * _t22)) * _t23_inv;
        float _t147 = _view03 + Math.fma(_view02, _t24, Math.fma(_view00, _t25, _view01 * _t26)) * _t27_inv;
        float _t148 = _view03 + Math.fma(_view02, _t28, Math.fma(_view00, _t29, _view01 * _t30)) * _t31_inv;
        float _t150 = _view13 + Math.fma(_view12, _t20, Math.fma(_view10, _t21, _view11 * _t22)) * _t23_inv;
        float _t151 = _view13 + Math.fma(_view12, _t24, Math.fma(_view10, _t25, _view11 * _t26)) * _t27_inv;
        float _t152 = _view13 + Math.fma(_view12, _t28, Math.fma(_view10, _t29, _view11 * _t30)) * _t31_inv;
        float _t154 = _view23 + Math.fma(_view22, _t20, Math.fma(_view20, _t21, _view21 * _t22)) * _t23_inv;
        float _t155 = _view23 + Math.fma(_view22, _t24, Math.fma(_view20, _t25, _view21 * _t26)) * _t27_inv;
        float _t156 = _view23 + Math.fma(_view22, _t28, Math.fma(_view20, _t29, _view21 * _t30)) * _t31_inv;
        float _t161 = _view03 + Math.fma(_view02, _t44, Math.fma(_view00, _t45, _view01 * _t46)) * _t47_inv;
        float _t162 = _view13 + Math.fma(_view12, _t44, Math.fma(_view10, _t45, _view11 * _t46)) * _t47_inv;
        float _t163 = _view23 + Math.fma(_view22, _t44, Math.fma(_view20, _t45, _view21 * _t46)) * _t47_inv;
        float _t173 = _view03 + Math.fma(_view02, _t55, Math.fma(_view00, _t56, _view01 * _t57)) * _t58_inv;
        float _t174 = _view03 + Math.fma(_view02, _t59, Math.fma(_view00, _t60, _view01 * _t61)) * _t62_inv;
        float _t175 = _view03 + Math.fma(_view02, _t63, Math.fma(_view00, _t64, _view01 * _t65)) * _t66_inv;
        float _t176 = _view13 + Math.fma(_view12, _t55, Math.fma(_view10, _t56, _view11 * _t57)) * _t58_inv;
        float _t177 = _view13 + Math.fma(_view12, _t59, Math.fma(_view10, _t60, _view11 * _t61)) * _t62_inv;
        float _t178 = _view13 + Math.fma(_view12, _t63, Math.fma(_view10, _t64, _view11 * _t65)) * _t66_inv;
        float _t179 = _view23 + Math.fma(_view22, _t55, Math.fma(_view20, _t56, _view21 * _t57)) * _t58_inv;
        float _t180 = _view23 + Math.fma(_view22, _t59, Math.fma(_view20, _t60, _view21 * _t61)) * _t62_inv;
        float _t181 = _view23 + Math.fma(_view22, _t63, Math.fma(_view20, _t64, _view21 * _t65)) * _t66_inv;
        float _t185 = _view03 + Math.fma(_view02, _t74, Math.fma(_view00, _t75, _view01 * _t76)) * _t77_inv;
        float _t186 = _view13 + Math.fma(_view12, _t74, Math.fma(_view10, _t75, _view11 * _t76)) * _t77_inv;
        float _t187 = _view23 + Math.fma(_view22, _t74, Math.fma(_view20, _t75, _view21 * _t76)) * _t77_inv;
        float _t224 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t161, _t146), _t147), _t148), _t185), _t173), _t174), _t175);
        float _t225 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t161, _t146), _t147), _t148), _t185), _t173), _t174), _t175);
        float _t226 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t162, _t150), _t151), _t152), _t186), _t176), _t177), _t178);
        float _t227 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t162, _t150), _t151), _t152), _t186), _t176), _t177), _t178);
        float _t228 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t163, _t154), _t155), _t156), _t187), _t179), _t180), _t181);
        float _t230 = _t224 - _t225;
        float _t230_inv = 1.0f / _t230;
        float _t231 = _t226 - _t227;
        float _t231_inv = 1.0f / _t231;
        float _t232 = _t228 - Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t163, _t154), _t155), _t156), _t187), _t179), _t180), _t181);
        float _t232_inv = 1.0f / _t232;
        dest[destOffset + 0] = 2.0f * _t230_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t231_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = -1.0f * _t232_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((_t225 + _t224) * _t230_inv);
        dest[destOffset + 13] = -((_t227 + _t226) * _t231_inv);
        dest[destOffset + 14] = _t228 * _t232_inv;
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] orthoCrop_zo(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.orthoCrop_zo_lh(dest, destOffset, src, srcOffset, view, viewOffset); }
            default -> { return Float4x4OpsKernelsArray.orthoCrop_zo_rh(dest, destOffset, src, srcOffset, view, viewOffset); }
        }
    }

    public static float[] orthoCrop_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset, float minZ, float maxZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _view00 = view[viewOffset + 0];
        float _view10 = view[viewOffset + 1];
        float _view20 = view[viewOffset + 2];
        float _view01 = view[viewOffset + 4];
        float _view11 = view[viewOffset + 5];
        float _view21 = view[viewOffset + 6];
        float _view02 = view[viewOffset + 8];
        float _view12 = view[viewOffset + 9];
        float _view22 = view[viewOffset + 10];
        float _view03 = view[viewOffset + 12];
        float _view13 = view[viewOffset + 13];
        float _view23 = view[viewOffset + 14];
        float _t4 = _self23 + _self20;
        float _t5 = _self03 + _self00;
        float _t6 = _self13 + _self10;
        float _t7 = _self33 + _self30;
        float _t12 = _self23 - _self20 - _self21;
        float _t13 = _self03 - _self00 - _self01;
        float _t14 = _self13 - _self10 - _self11;
        float _t15 = _self33 - _self30 - _self31;
        float _t16 = _t4 - _self21;
        float _t17 = _t5 - _self01;
        float _t18 = _t6 - _self11;
        float _t19 = _t7 - _self31;
        float _t20 = _self23 + _self21 - _self20;
        float _t21 = _self03 + _self01 - _self00;
        float _t22 = _self13 + _self11 - _self10;
        float _t23 = _self33 + _self31 - _self30;
        float _t24 = _t4 + _self21;
        float _t25 = _t5 + _self01;
        float _t26 = _t6 + _self11;
        float _t27 = _t7 + _self31;
        float _t28 = Math.fma(minZ, _self22, _t12);
        float _t29 = Math.fma(minZ, _self02, _t13);
        float _t30 = Math.fma(minZ, _self12, _t14);
        float _t31 = Math.fma(minZ, _self32, _t15);
        float _t31_inv = 1.0f / _t31;
        float _t32 = Math.fma(minZ, _self22, _t16);
        float _t33 = Math.fma(minZ, _self02, _t17);
        float _t34 = Math.fma(minZ, _self12, _t18);
        float _t35 = Math.fma(minZ, _self32, _t19);
        float _t35_inv = 1.0f / _t35;
        float _t36 = Math.fma(minZ, _self22, _t20);
        float _t37 = Math.fma(minZ, _self02, _t21);
        float _t38 = Math.fma(minZ, _self12, _t22);
        float _t39 = Math.fma(minZ, _self32, _t23);
        float _t39_inv = 1.0f / _t39;
        float _t40 = Math.fma(minZ, _self22, _t24);
        float _t41 = Math.fma(minZ, _self02, _t25);
        float _t42 = Math.fma(minZ, _self12, _t26);
        float _t43 = Math.fma(minZ, _self32, _t27);
        float _t43_inv = 1.0f / _t43;
        float _t44 = Math.fma(maxZ, _self22, _t12);
        float _t45 = Math.fma(maxZ, _self02, _t13);
        float _t46 = Math.fma(maxZ, _self12, _t14);
        float _t47 = Math.fma(maxZ, _self32, _t15);
        float _t47_inv = 1.0f / _t47;
        float _t48 = Math.fma(maxZ, _self22, _t16);
        float _t49 = Math.fma(maxZ, _self02, _t17);
        float _t50 = Math.fma(maxZ, _self12, _t18);
        float _t51 = Math.fma(maxZ, _self32, _t19);
        float _t51_inv = 1.0f / _t51;
        float _t52 = Math.fma(maxZ, _self22, _t20);
        float _t53 = Math.fma(maxZ, _self02, _t21);
        float _t54 = Math.fma(maxZ, _self12, _t22);
        float _t55 = Math.fma(maxZ, _self32, _t23);
        float _t55_inv = 1.0f / _t55;
        float _t56 = Math.fma(maxZ, _self22, _t24);
        float _t57 = Math.fma(maxZ, _self02, _t25);
        float _t58 = Math.fma(maxZ, _self12, _t26);
        float _t59 = Math.fma(maxZ, _self32, _t27);
        float _t59_inv = 1.0f / _t59;
        float _t156 = _view03 + Math.fma(_view02, _t28, Math.fma(_view00, _t29, _view01 * _t30)) * _t31_inv;
        float _t157 = _view03 + Math.fma(_view02, _t32, Math.fma(_view00, _t33, _view01 * _t34)) * _t35_inv;
        float _t158 = _view03 + Math.fma(_view02, _t36, Math.fma(_view00, _t37, _view01 * _t38)) * _t39_inv;
        float _t159 = _view03 + Math.fma(_view02, _t40, Math.fma(_view00, _t41, _view01 * _t42)) * _t43_inv;
        float _t160 = _view03 + Math.fma(_view02, _t44, Math.fma(_view00, _t45, _view01 * _t46)) * _t47_inv;
        float _t161 = _view03 + Math.fma(_view02, _t48, Math.fma(_view00, _t49, _view01 * _t50)) * _t51_inv;
        float _t162 = _view03 + Math.fma(_view02, _t52, Math.fma(_view00, _t53, _view01 * _t54)) * _t55_inv;
        float _t163 = _view03 + Math.fma(_view02, _t56, Math.fma(_view00, _t57, _view01 * _t58)) * _t59_inv;
        float _t164 = _view13 + Math.fma(_view12, _t28, Math.fma(_view10, _t29, _view11 * _t30)) * _t31_inv;
        float _t165 = _view13 + Math.fma(_view12, _t32, Math.fma(_view10, _t33, _view11 * _t34)) * _t35_inv;
        float _t166 = _view13 + Math.fma(_view12, _t36, Math.fma(_view10, _t37, _view11 * _t38)) * _t39_inv;
        float _t167 = _view13 + Math.fma(_view12, _t40, Math.fma(_view10, _t41, _view11 * _t42)) * _t43_inv;
        float _t168 = _view13 + Math.fma(_view12, _t44, Math.fma(_view10, _t45, _view11 * _t46)) * _t47_inv;
        float _t169 = _view13 + Math.fma(_view12, _t48, Math.fma(_view10, _t49, _view11 * _t50)) * _t51_inv;
        float _t170 = _view13 + Math.fma(_view12, _t52, Math.fma(_view10, _t53, _view11 * _t54)) * _t55_inv;
        float _t171 = _view13 + Math.fma(_view12, _t56, Math.fma(_view10, _t57, _view11 * _t58)) * _t59_inv;
        float _t172 = _view23 + Math.fma(_view22, _t28, Math.fma(_view20, _t29, _view21 * _t30)) * _t31_inv;
        float _t173 = _view23 + Math.fma(_view22, _t32, Math.fma(_view20, _t33, _view21 * _t34)) * _t35_inv;
        float _t174 = _view23 + Math.fma(_view22, _t36, Math.fma(_view20, _t37, _view21 * _t38)) * _t39_inv;
        float _t175 = _view23 + Math.fma(_view22, _t40, Math.fma(_view20, _t41, _view21 * _t42)) * _t43_inv;
        float _t176 = _view23 + Math.fma(_view22, _t44, Math.fma(_view20, _t45, _view21 * _t46)) * _t47_inv;
        float _t177 = _view23 + Math.fma(_view22, _t48, Math.fma(_view20, _t49, _view21 * _t50)) * _t51_inv;
        float _t178 = _view23 + Math.fma(_view22, _t52, Math.fma(_view20, _t53, _view21 * _t54)) * _t55_inv;
        float _t179 = _view23 + Math.fma(_view22, _t56, Math.fma(_view20, _t57, _view21 * _t58)) * _t59_inv;
        float _t216 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t156, _t157), _t158), _t159), _t160), _t161), _t162), _t163);
        float _t217 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t156, _t157), _t158), _t159), _t160), _t161), _t162), _t163);
        float _t218 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t164, _t165), _t166), _t167), _t168), _t169), _t170), _t171);
        float _t219 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t164, _t165), _t166), _t167), _t168), _t169), _t170), _t171);
        float _t220 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t172, _t173), _t174), _t175), _t176), _t177), _t178), _t179);
        float _t221 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t172, _t173), _t174), _t175), _t176), _t177), _t178), _t179);
        float _t222 = _t216 - _t217;
        float _t222_inv = 1.0f / _t222;
        float _t223 = _t218 - _t219;
        float _t223_inv = 1.0f / _t223;
        float _t224 = _t220 - _t221;
        float _t224_inv = 1.0f / _t224;
        dest[destOffset + 0] = 2.0f * _t222_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t223_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = 2.0f * _t224_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((_t217 + _t216) * _t222_inv);
        dest[destOffset + 13] = -((_t219 + _t218) * _t223_inv);
        dest[destOffset + 14] = -((_t221 + _t220) * _t224_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] orthoCrop_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset, float minZ, float maxZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _view00 = view[viewOffset + 0];
        float _view10 = view[viewOffset + 1];
        float _view20 = view[viewOffset + 2];
        float _view01 = view[viewOffset + 4];
        float _view11 = view[viewOffset + 5];
        float _view21 = view[viewOffset + 6];
        float _view02 = view[viewOffset + 8];
        float _view12 = view[viewOffset + 9];
        float _view22 = view[viewOffset + 10];
        float _view03 = view[viewOffset + 12];
        float _view13 = view[viewOffset + 13];
        float _view23 = view[viewOffset + 14];
        float _t4 = _self23 + _self20;
        float _t5 = _self03 + _self00;
        float _t6 = _self13 + _self10;
        float _t7 = _self33 + _self30;
        float _t12 = _self23 - _self20 - _self21;
        float _t13 = _self03 - _self00 - _self01;
        float _t14 = _self13 - _self10 - _self11;
        float _t15 = _self33 - _self30 - _self31;
        float _t16 = _t4 - _self21;
        float _t17 = _t5 - _self01;
        float _t18 = _t6 - _self11;
        float _t19 = _t7 - _self31;
        float _t20 = _self23 + _self21 - _self20;
        float _t21 = _self03 + _self01 - _self00;
        float _t22 = _self13 + _self11 - _self10;
        float _t23 = _self33 + _self31 - _self30;
        float _t24 = _t4 + _self21;
        float _t25 = _t5 + _self01;
        float _t26 = _t6 + _self11;
        float _t27 = _t7 + _self31;
        float _t28 = Math.fma(minZ, _self22, _t12);
        float _t29 = Math.fma(minZ, _self02, _t13);
        float _t30 = Math.fma(minZ, _self12, _t14);
        float _t31 = Math.fma(minZ, _self32, _t15);
        float _t31_inv = 1.0f / _t31;
        float _t32 = Math.fma(minZ, _self22, _t16);
        float _t33 = Math.fma(minZ, _self02, _t17);
        float _t34 = Math.fma(minZ, _self12, _t18);
        float _t35 = Math.fma(minZ, _self32, _t19);
        float _t35_inv = 1.0f / _t35;
        float _t36 = Math.fma(minZ, _self22, _t20);
        float _t37 = Math.fma(minZ, _self02, _t21);
        float _t38 = Math.fma(minZ, _self12, _t22);
        float _t39 = Math.fma(minZ, _self32, _t23);
        float _t39_inv = 1.0f / _t39;
        float _t40 = Math.fma(minZ, _self22, _t24);
        float _t41 = Math.fma(minZ, _self02, _t25);
        float _t42 = Math.fma(minZ, _self12, _t26);
        float _t43 = Math.fma(minZ, _self32, _t27);
        float _t43_inv = 1.0f / _t43;
        float _t44 = Math.fma(maxZ, _self22, _t12);
        float _t45 = Math.fma(maxZ, _self02, _t13);
        float _t46 = Math.fma(maxZ, _self12, _t14);
        float _t47 = Math.fma(maxZ, _self32, _t15);
        float _t47_inv = 1.0f / _t47;
        float _t48 = Math.fma(maxZ, _self22, _t16);
        float _t49 = Math.fma(maxZ, _self02, _t17);
        float _t50 = Math.fma(maxZ, _self12, _t18);
        float _t51 = Math.fma(maxZ, _self32, _t19);
        float _t51_inv = 1.0f / _t51;
        float _t52 = Math.fma(maxZ, _self22, _t20);
        float _t53 = Math.fma(maxZ, _self02, _t21);
        float _t54 = Math.fma(maxZ, _self12, _t22);
        float _t55 = Math.fma(maxZ, _self32, _t23);
        float _t55_inv = 1.0f / _t55;
        float _t56 = Math.fma(maxZ, _self22, _t24);
        float _t57 = Math.fma(maxZ, _self02, _t25);
        float _t58 = Math.fma(maxZ, _self12, _t26);
        float _t59 = Math.fma(maxZ, _self32, _t27);
        float _t59_inv = 1.0f / _t59;
        float _t156 = _view03 + Math.fma(_view02, _t28, Math.fma(_view00, _t29, _view01 * _t30)) * _t31_inv;
        float _t157 = _view03 + Math.fma(_view02, _t32, Math.fma(_view00, _t33, _view01 * _t34)) * _t35_inv;
        float _t158 = _view03 + Math.fma(_view02, _t36, Math.fma(_view00, _t37, _view01 * _t38)) * _t39_inv;
        float _t159 = _view03 + Math.fma(_view02, _t40, Math.fma(_view00, _t41, _view01 * _t42)) * _t43_inv;
        float _t160 = _view03 + Math.fma(_view02, _t44, Math.fma(_view00, _t45, _view01 * _t46)) * _t47_inv;
        float _t161 = _view03 + Math.fma(_view02, _t48, Math.fma(_view00, _t49, _view01 * _t50)) * _t51_inv;
        float _t162 = _view03 + Math.fma(_view02, _t52, Math.fma(_view00, _t53, _view01 * _t54)) * _t55_inv;
        float _t163 = _view03 + Math.fma(_view02, _t56, Math.fma(_view00, _t57, _view01 * _t58)) * _t59_inv;
        float _t164 = _view13 + Math.fma(_view12, _t28, Math.fma(_view10, _t29, _view11 * _t30)) * _t31_inv;
        float _t165 = _view13 + Math.fma(_view12, _t32, Math.fma(_view10, _t33, _view11 * _t34)) * _t35_inv;
        float _t166 = _view13 + Math.fma(_view12, _t36, Math.fma(_view10, _t37, _view11 * _t38)) * _t39_inv;
        float _t167 = _view13 + Math.fma(_view12, _t40, Math.fma(_view10, _t41, _view11 * _t42)) * _t43_inv;
        float _t168 = _view13 + Math.fma(_view12, _t44, Math.fma(_view10, _t45, _view11 * _t46)) * _t47_inv;
        float _t169 = _view13 + Math.fma(_view12, _t48, Math.fma(_view10, _t49, _view11 * _t50)) * _t51_inv;
        float _t170 = _view13 + Math.fma(_view12, _t52, Math.fma(_view10, _t53, _view11 * _t54)) * _t55_inv;
        float _t171 = _view13 + Math.fma(_view12, _t56, Math.fma(_view10, _t57, _view11 * _t58)) * _t59_inv;
        float _t172 = _view23 + Math.fma(_view22, _t28, Math.fma(_view20, _t29, _view21 * _t30)) * _t31_inv;
        float _t173 = _view23 + Math.fma(_view22, _t32, Math.fma(_view20, _t33, _view21 * _t34)) * _t35_inv;
        float _t174 = _view23 + Math.fma(_view22, _t36, Math.fma(_view20, _t37, _view21 * _t38)) * _t39_inv;
        float _t175 = _view23 + Math.fma(_view22, _t40, Math.fma(_view20, _t41, _view21 * _t42)) * _t43_inv;
        float _t176 = _view23 + Math.fma(_view22, _t44, Math.fma(_view20, _t45, _view21 * _t46)) * _t47_inv;
        float _t177 = _view23 + Math.fma(_view22, _t48, Math.fma(_view20, _t49, _view21 * _t50)) * _t51_inv;
        float _t178 = _view23 + Math.fma(_view22, _t52, Math.fma(_view20, _t53, _view21 * _t54)) * _t55_inv;
        float _t179 = _view23 + Math.fma(_view22, _t56, Math.fma(_view20, _t57, _view21 * _t58)) * _t59_inv;
        float _t216 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t156, _t157), _t158), _t159), _t160), _t161), _t162), _t163);
        float _t217 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t156, _t157), _t158), _t159), _t160), _t161), _t162), _t163);
        float _t218 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t164, _t165), _t166), _t167), _t168), _t169), _t170), _t171);
        float _t219 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t164, _t165), _t166), _t167), _t168), _t169), _t170), _t171);
        float _t220 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t172, _t173), _t174), _t175), _t176), _t177), _t178), _t179);
        float _t221 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t172, _t173), _t174), _t175), _t176), _t177), _t178), _t179);
        float _t222 = _t216 - _t217;
        float _t222_inv = 1.0f / _t222;
        float _t223 = _t218 - _t219;
        float _t223_inv = 1.0f / _t223;
        float _t224 = _t220 - _t221;
        float _t224_inv = 1.0f / _t224;
        dest[destOffset + 0] = 2.0f * _t222_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t223_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = -2.0f * _t224_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((_t217 + _t216) * _t222_inv);
        dest[destOffset + 13] = -((_t219 + _t218) * _t223_inv);
        dest[destOffset + 14] = -((-_t221 - _t220) * _t224_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] orthoCrop_no(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset, float minZ, float maxZ, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.orthoCrop_no_lh(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ); }
            default -> { return Float4x4OpsKernelsArray.orthoCrop_no_rh(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ); }
        }
    }

    public static float[] orthoCrop_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset, float minZ, float maxZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _view00 = view[viewOffset + 0];
        float _view10 = view[viewOffset + 1];
        float _view20 = view[viewOffset + 2];
        float _view01 = view[viewOffset + 4];
        float _view11 = view[viewOffset + 5];
        float _view21 = view[viewOffset + 6];
        float _view02 = view[viewOffset + 8];
        float _view12 = view[viewOffset + 9];
        float _view22 = view[viewOffset + 10];
        float _view03 = view[viewOffset + 12];
        float _view13 = view[viewOffset + 13];
        float _view23 = view[viewOffset + 14];
        float _t4 = _self23 + _self20;
        float _t5 = _self03 + _self00;
        float _t6 = _self13 + _self10;
        float _t7 = _self33 + _self30;
        float _t12 = _self23 - _self20 - _self21;
        float _t13 = _self03 - _self00 - _self01;
        float _t14 = _self13 - _self10 - _self11;
        float _t15 = _self33 - _self30 - _self31;
        float _t16 = _t4 - _self21;
        float _t17 = _t5 - _self01;
        float _t18 = _t6 - _self11;
        float _t19 = _t7 - _self31;
        float _t20 = _self23 + _self21 - _self20;
        float _t21 = _self03 + _self01 - _self00;
        float _t22 = _self13 + _self11 - _self10;
        float _t23 = _self33 + _self31 - _self30;
        float _t24 = _t4 + _self21;
        float _t25 = _t5 + _self01;
        float _t26 = _t6 + _self11;
        float _t27 = _t7 + _self31;
        float _t28 = Math.fma(minZ, _self22, _t12);
        float _t29 = Math.fma(minZ, _self02, _t13);
        float _t30 = Math.fma(minZ, _self12, _t14);
        float _t31 = Math.fma(minZ, _self32, _t15);
        float _t31_inv = 1.0f / _t31;
        float _t32 = Math.fma(minZ, _self22, _t16);
        float _t33 = Math.fma(minZ, _self02, _t17);
        float _t34 = Math.fma(minZ, _self12, _t18);
        float _t35 = Math.fma(minZ, _self32, _t19);
        float _t35_inv = 1.0f / _t35;
        float _t36 = Math.fma(minZ, _self22, _t20);
        float _t37 = Math.fma(minZ, _self02, _t21);
        float _t38 = Math.fma(minZ, _self12, _t22);
        float _t39 = Math.fma(minZ, _self32, _t23);
        float _t39_inv = 1.0f / _t39;
        float _t40 = Math.fma(minZ, _self22, _t24);
        float _t41 = Math.fma(minZ, _self02, _t25);
        float _t42 = Math.fma(minZ, _self12, _t26);
        float _t43 = Math.fma(minZ, _self32, _t27);
        float _t43_inv = 1.0f / _t43;
        float _t44 = Math.fma(maxZ, _self22, _t12);
        float _t45 = Math.fma(maxZ, _self02, _t13);
        float _t46 = Math.fma(maxZ, _self12, _t14);
        float _t47 = Math.fma(maxZ, _self32, _t15);
        float _t47_inv = 1.0f / _t47;
        float _t48 = Math.fma(maxZ, _self22, _t16);
        float _t49 = Math.fma(maxZ, _self02, _t17);
        float _t50 = Math.fma(maxZ, _self12, _t18);
        float _t51 = Math.fma(maxZ, _self32, _t19);
        float _t51_inv = 1.0f / _t51;
        float _t52 = Math.fma(maxZ, _self22, _t20);
        float _t53 = Math.fma(maxZ, _self02, _t21);
        float _t54 = Math.fma(maxZ, _self12, _t22);
        float _t55 = Math.fma(maxZ, _self32, _t23);
        float _t55_inv = 1.0f / _t55;
        float _t56 = Math.fma(maxZ, _self22, _t24);
        float _t57 = Math.fma(maxZ, _self02, _t25);
        float _t58 = Math.fma(maxZ, _self12, _t26);
        float _t59 = Math.fma(maxZ, _self32, _t27);
        float _t59_inv = 1.0f / _t59;
        float _t156 = _view03 + Math.fma(_view02, _t28, Math.fma(_view00, _t29, _view01 * _t30)) * _t31_inv;
        float _t157 = _view03 + Math.fma(_view02, _t32, Math.fma(_view00, _t33, _view01 * _t34)) * _t35_inv;
        float _t158 = _view03 + Math.fma(_view02, _t36, Math.fma(_view00, _t37, _view01 * _t38)) * _t39_inv;
        float _t159 = _view03 + Math.fma(_view02, _t40, Math.fma(_view00, _t41, _view01 * _t42)) * _t43_inv;
        float _t160 = _view03 + Math.fma(_view02, _t44, Math.fma(_view00, _t45, _view01 * _t46)) * _t47_inv;
        float _t161 = _view03 + Math.fma(_view02, _t48, Math.fma(_view00, _t49, _view01 * _t50)) * _t51_inv;
        float _t162 = _view03 + Math.fma(_view02, _t52, Math.fma(_view00, _t53, _view01 * _t54)) * _t55_inv;
        float _t163 = _view03 + Math.fma(_view02, _t56, Math.fma(_view00, _t57, _view01 * _t58)) * _t59_inv;
        float _t164 = _view13 + Math.fma(_view12, _t28, Math.fma(_view10, _t29, _view11 * _t30)) * _t31_inv;
        float _t165 = _view13 + Math.fma(_view12, _t32, Math.fma(_view10, _t33, _view11 * _t34)) * _t35_inv;
        float _t166 = _view13 + Math.fma(_view12, _t36, Math.fma(_view10, _t37, _view11 * _t38)) * _t39_inv;
        float _t167 = _view13 + Math.fma(_view12, _t40, Math.fma(_view10, _t41, _view11 * _t42)) * _t43_inv;
        float _t168 = _view13 + Math.fma(_view12, _t44, Math.fma(_view10, _t45, _view11 * _t46)) * _t47_inv;
        float _t169 = _view13 + Math.fma(_view12, _t48, Math.fma(_view10, _t49, _view11 * _t50)) * _t51_inv;
        float _t170 = _view13 + Math.fma(_view12, _t52, Math.fma(_view10, _t53, _view11 * _t54)) * _t55_inv;
        float _t171 = _view13 + Math.fma(_view12, _t56, Math.fma(_view10, _t57, _view11 * _t58)) * _t59_inv;
        float _t172 = _view23 + Math.fma(_view22, _t28, Math.fma(_view20, _t29, _view21 * _t30)) * _t31_inv;
        float _t173 = _view23 + Math.fma(_view22, _t32, Math.fma(_view20, _t33, _view21 * _t34)) * _t35_inv;
        float _t174 = _view23 + Math.fma(_view22, _t36, Math.fma(_view20, _t37, _view21 * _t38)) * _t39_inv;
        float _t175 = _view23 + Math.fma(_view22, _t40, Math.fma(_view20, _t41, _view21 * _t42)) * _t43_inv;
        float _t176 = _view23 + Math.fma(_view22, _t44, Math.fma(_view20, _t45, _view21 * _t46)) * _t47_inv;
        float _t177 = _view23 + Math.fma(_view22, _t48, Math.fma(_view20, _t49, _view21 * _t50)) * _t51_inv;
        float _t178 = _view23 + Math.fma(_view22, _t52, Math.fma(_view20, _t53, _view21 * _t54)) * _t55_inv;
        float _t179 = _view23 + Math.fma(_view22, _t56, Math.fma(_view20, _t57, _view21 * _t58)) * _t59_inv;
        float _t216 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t156, _t157), _t158), _t159), _t160), _t161), _t162), _t163);
        float _t217 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t156, _t157), _t158), _t159), _t160), _t161), _t162), _t163);
        float _t218 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t164, _t165), _t166), _t167), _t168), _t169), _t170), _t171);
        float _t219 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t164, _t165), _t166), _t167), _t168), _t169), _t170), _t171);
        float _t221 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t172, _t173), _t174), _t175), _t176), _t177), _t178), _t179);
        float _t222 = _t216 - _t217;
        float _t222_inv = 1.0f / _t222;
        float _t223 = _t218 - _t219;
        float _t223_inv = 1.0f / _t223;
        float _t224 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t172, _t173), _t174), _t175), _t176), _t177), _t178), _t179) - _t221;
        float _t224_inv = 1.0f / _t224;
        dest[destOffset + 0] = 2.0f * _t222_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t223_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = 1.0f * _t224_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((_t217 + _t216) * _t222_inv);
        dest[destOffset + 13] = -((_t219 + _t218) * _t223_inv);
        dest[destOffset + 14] = -(_t221 * _t224_inv);
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] orthoCrop_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset, float minZ, float maxZ) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _view00 = view[viewOffset + 0];
        float _view10 = view[viewOffset + 1];
        float _view20 = view[viewOffset + 2];
        float _view01 = view[viewOffset + 4];
        float _view11 = view[viewOffset + 5];
        float _view21 = view[viewOffset + 6];
        float _view02 = view[viewOffset + 8];
        float _view12 = view[viewOffset + 9];
        float _view22 = view[viewOffset + 10];
        float _view03 = view[viewOffset + 12];
        float _view13 = view[viewOffset + 13];
        float _view23 = view[viewOffset + 14];
        float _t4 = _self23 + _self20;
        float _t5 = _self03 + _self00;
        float _t6 = _self13 + _self10;
        float _t7 = _self33 + _self30;
        float _t12 = _self23 - _self20 - _self21;
        float _t13 = _self03 - _self00 - _self01;
        float _t14 = _self13 - _self10 - _self11;
        float _t15 = _self33 - _self30 - _self31;
        float _t16 = _t4 - _self21;
        float _t17 = _t5 - _self01;
        float _t18 = _t6 - _self11;
        float _t19 = _t7 - _self31;
        float _t20 = _self23 + _self21 - _self20;
        float _t21 = _self03 + _self01 - _self00;
        float _t22 = _self13 + _self11 - _self10;
        float _t23 = _self33 + _self31 - _self30;
        float _t24 = _t4 + _self21;
        float _t25 = _t5 + _self01;
        float _t26 = _t6 + _self11;
        float _t27 = _t7 + _self31;
        float _t28 = Math.fma(minZ, _self22, _t12);
        float _t29 = Math.fma(minZ, _self02, _t13);
        float _t30 = Math.fma(minZ, _self12, _t14);
        float _t31 = Math.fma(minZ, _self32, _t15);
        float _t31_inv = 1.0f / _t31;
        float _t32 = Math.fma(minZ, _self22, _t16);
        float _t33 = Math.fma(minZ, _self02, _t17);
        float _t34 = Math.fma(minZ, _self12, _t18);
        float _t35 = Math.fma(minZ, _self32, _t19);
        float _t35_inv = 1.0f / _t35;
        float _t36 = Math.fma(minZ, _self22, _t20);
        float _t37 = Math.fma(minZ, _self02, _t21);
        float _t38 = Math.fma(minZ, _self12, _t22);
        float _t39 = Math.fma(minZ, _self32, _t23);
        float _t39_inv = 1.0f / _t39;
        float _t40 = Math.fma(minZ, _self22, _t24);
        float _t41 = Math.fma(minZ, _self02, _t25);
        float _t42 = Math.fma(minZ, _self12, _t26);
        float _t43 = Math.fma(minZ, _self32, _t27);
        float _t43_inv = 1.0f / _t43;
        float _t44 = Math.fma(maxZ, _self22, _t12);
        float _t45 = Math.fma(maxZ, _self02, _t13);
        float _t46 = Math.fma(maxZ, _self12, _t14);
        float _t47 = Math.fma(maxZ, _self32, _t15);
        float _t47_inv = 1.0f / _t47;
        float _t48 = Math.fma(maxZ, _self22, _t16);
        float _t49 = Math.fma(maxZ, _self02, _t17);
        float _t50 = Math.fma(maxZ, _self12, _t18);
        float _t51 = Math.fma(maxZ, _self32, _t19);
        float _t51_inv = 1.0f / _t51;
        float _t52 = Math.fma(maxZ, _self22, _t20);
        float _t53 = Math.fma(maxZ, _self02, _t21);
        float _t54 = Math.fma(maxZ, _self12, _t22);
        float _t55 = Math.fma(maxZ, _self32, _t23);
        float _t55_inv = 1.0f / _t55;
        float _t56 = Math.fma(maxZ, _self22, _t24);
        float _t57 = Math.fma(maxZ, _self02, _t25);
        float _t58 = Math.fma(maxZ, _self12, _t26);
        float _t59 = Math.fma(maxZ, _self32, _t27);
        float _t59_inv = 1.0f / _t59;
        float _t156 = _view03 + Math.fma(_view02, _t28, Math.fma(_view00, _t29, _view01 * _t30)) * _t31_inv;
        float _t157 = _view03 + Math.fma(_view02, _t32, Math.fma(_view00, _t33, _view01 * _t34)) * _t35_inv;
        float _t158 = _view03 + Math.fma(_view02, _t36, Math.fma(_view00, _t37, _view01 * _t38)) * _t39_inv;
        float _t159 = _view03 + Math.fma(_view02, _t40, Math.fma(_view00, _t41, _view01 * _t42)) * _t43_inv;
        float _t160 = _view03 + Math.fma(_view02, _t44, Math.fma(_view00, _t45, _view01 * _t46)) * _t47_inv;
        float _t161 = _view03 + Math.fma(_view02, _t48, Math.fma(_view00, _t49, _view01 * _t50)) * _t51_inv;
        float _t162 = _view03 + Math.fma(_view02, _t52, Math.fma(_view00, _t53, _view01 * _t54)) * _t55_inv;
        float _t163 = _view03 + Math.fma(_view02, _t56, Math.fma(_view00, _t57, _view01 * _t58)) * _t59_inv;
        float _t164 = _view13 + Math.fma(_view12, _t28, Math.fma(_view10, _t29, _view11 * _t30)) * _t31_inv;
        float _t165 = _view13 + Math.fma(_view12, _t32, Math.fma(_view10, _t33, _view11 * _t34)) * _t35_inv;
        float _t166 = _view13 + Math.fma(_view12, _t36, Math.fma(_view10, _t37, _view11 * _t38)) * _t39_inv;
        float _t167 = _view13 + Math.fma(_view12, _t40, Math.fma(_view10, _t41, _view11 * _t42)) * _t43_inv;
        float _t168 = _view13 + Math.fma(_view12, _t44, Math.fma(_view10, _t45, _view11 * _t46)) * _t47_inv;
        float _t169 = _view13 + Math.fma(_view12, _t48, Math.fma(_view10, _t49, _view11 * _t50)) * _t51_inv;
        float _t170 = _view13 + Math.fma(_view12, _t52, Math.fma(_view10, _t53, _view11 * _t54)) * _t55_inv;
        float _t171 = _view13 + Math.fma(_view12, _t56, Math.fma(_view10, _t57, _view11 * _t58)) * _t59_inv;
        float _t172 = _view23 + Math.fma(_view22, _t28, Math.fma(_view20, _t29, _view21 * _t30)) * _t31_inv;
        float _t173 = _view23 + Math.fma(_view22, _t32, Math.fma(_view20, _t33, _view21 * _t34)) * _t35_inv;
        float _t174 = _view23 + Math.fma(_view22, _t36, Math.fma(_view20, _t37, _view21 * _t38)) * _t39_inv;
        float _t175 = _view23 + Math.fma(_view22, _t40, Math.fma(_view20, _t41, _view21 * _t42)) * _t43_inv;
        float _t176 = _view23 + Math.fma(_view22, _t44, Math.fma(_view20, _t45, _view21 * _t46)) * _t47_inv;
        float _t177 = _view23 + Math.fma(_view22, _t48, Math.fma(_view20, _t49, _view21 * _t50)) * _t51_inv;
        float _t178 = _view23 + Math.fma(_view22, _t52, Math.fma(_view20, _t53, _view21 * _t54)) * _t55_inv;
        float _t179 = _view23 + Math.fma(_view22, _t56, Math.fma(_view20, _t57, _view21 * _t58)) * _t59_inv;
        float _t216 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t156, _t157), _t158), _t159), _t160), _t161), _t162), _t163);
        float _t217 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t156, _t157), _t158), _t159), _t160), _t161), _t162), _t163);
        float _t218 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t164, _t165), _t166), _t167), _t168), _t169), _t170), _t171);
        float _t219 = Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t164, _t165), _t166), _t167), _t168), _t169), _t170), _t171);
        float _t220 = Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(Math.max(_t172, _t173), _t174), _t175), _t176), _t177), _t178), _t179);
        float _t222 = _t216 - _t217;
        float _t222_inv = 1.0f / _t222;
        float _t223 = _t218 - _t219;
        float _t223_inv = 1.0f / _t223;
        float _t224 = _t220 - Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(_t172, _t173), _t174), _t175), _t176), _t177), _t178), _t179);
        float _t224_inv = 1.0f / _t224;
        dest[destOffset + 0] = 2.0f * _t222_inv;
        dest[destOffset + 1] = 0.0f;
        dest[destOffset + 2] = 0.0f;
        dest[destOffset + 3] = 0.0f;
        dest[destOffset + 4] = 0.0f;
        dest[destOffset + 5] = 2.0f * _t223_inv;
        dest[destOffset + 6] = 0.0f;
        dest[destOffset + 7] = 0.0f;
        dest[destOffset + 8] = 0.0f;
        dest[destOffset + 9] = 0.0f;
        dest[destOffset + 10] = -1.0f * _t224_inv;
        dest[destOffset + 11] = 0.0f;
        dest[destOffset + 12] = -((_t217 + _t216) * _t222_inv);
        dest[destOffset + 13] = -((_t219 + _t218) * _t223_inv);
        dest[destOffset + 14] = _t220 * _t224_inv;
        dest[destOffset + 15] = 1.0f;
        return dest;
    }

    public static float[] orthoCrop_zo(float[] dest, int destOffset, float[] src, int srcOffset, float[] view, int viewOffset, float minZ, float maxZ, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.orthoCrop_zo_lh(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ); }
            default -> { return Float4x4OpsKernelsArray.orthoCrop_zo_rh(dest, destOffset, src, srcOffset, view, viewOffset, minZ, maxZ); }
        }
    }

    public static float[] perspective_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t2 = near - far;
        float _t2_inv = 1.0f / _t2;
        float _t6 = (float) Math.tan(0.5f * fovy);
        float _t6_inv = 1.0f / _t6;
        float _t9 = aspect * _t6;
        float _t9_inv = 1.0f / _t9;
        float _t15, _t16;
        if (far == Float.POSITIVE_INFINITY) {
            _t15 = 1.0f;
            _t16 = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t15 = -1.0f;
                _t16 = 2.0f * far;
            } else {
                _t15 = -((far + near) * _t2_inv);
                _t16 = 2.0f * far * near * _t2_inv;
            }
        }
        dest[destOffset + 0] = _self00 * _t9_inv;
        dest[destOffset + 1] = _self10 * _t9_inv;
        dest[destOffset + 2] = _self20 * _t9_inv;
        dest[destOffset + 3] = _self30 * _t9_inv;
        dest[destOffset + 4] = _self01 * _t6_inv;
        dest[destOffset + 5] = _self11 * _t6_inv;
        dest[destOffset + 6] = _self21 * _t6_inv;
        dest[destOffset + 7] = _self31 * _t6_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t15, _self03);
        dest[destOffset + 9] = Math.fma(_self12, _t15, _self13);
        dest[destOffset + 10] = Math.fma(_self22, _t15, _self23);
        dest[destOffset + 11] = Math.fma(_self32, _t15, _self33);
        dest[destOffset + 12] = _self02 * _t16;
        dest[destOffset + 13] = _self12 * _t16;
        dest[destOffset + 14] = _self22 * _t16;
        dest[destOffset + 15] = _self32 * _t16;
        return dest;
    }

    public static float[] perspective_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t2 = near - far;
        float _t2_inv = 1.0f / _t2;
        float _t6 = (float) Math.tan(0.5f * fovy);
        float _t6_inv = 1.0f / _t6;
        float _t9 = aspect * _t6;
        float _t9_inv = 1.0f / _t9;
        float _t13, _t15;
        if (far == Float.POSITIVE_INFINITY) {
            _t13 = -1.0f;
            _t15 = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t13 = 1.0f;
                _t15 = 2.0f * far;
            } else {
                _t13 = (far + near) * _t2_inv;
                _t15 = 2.0f * far * near * _t2_inv;
            }
        }
        dest[destOffset + 0] = _self00 * _t9_inv;
        dest[destOffset + 1] = _self10 * _t9_inv;
        dest[destOffset + 2] = _self20 * _t9_inv;
        dest[destOffset + 3] = _self30 * _t9_inv;
        dest[destOffset + 4] = _self01 * _t6_inv;
        dest[destOffset + 5] = _self11 * _t6_inv;
        dest[destOffset + 6] = _self21 * _t6_inv;
        dest[destOffset + 7] = _self31 * _t6_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t13, -_self03);
        dest[destOffset + 9] = Math.fma(_self12, _t13, -_self13);
        dest[destOffset + 10] = Math.fma(_self22, _t13, -_self23);
        dest[destOffset + 11] = Math.fma(_self32, _t13, -_self33);
        dest[destOffset + 12] = _self02 * _t15;
        dest[destOffset + 13] = _self12 * _t15;
        dest[destOffset + 14] = _self22 * _t15;
        dest[destOffset + 15] = _self32 * _t15;
        return dest;
    }

    public static float[] perspective_no(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.perspective_no_lh(dest, destOffset, src, srcOffset, fovy, aspect, near, far); }
            default -> { return Float4x4OpsKernelsArray.perspective_no_rh(dest, destOffset, src, srcOffset, fovy, aspect, near, far); }
        }
    }

    public static float[] perspective_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t1 = near - far;
        float _t1_inv = 1.0f / _t1;
        float _t3 = (float) Math.tan(0.5f * fovy);
        float _t3_inv = 1.0f / _t3;
        float _t5 = aspect * _t3;
        float _t5_inv = 1.0f / _t5;
        float _t10, _t11;
        if (far == Float.POSITIVE_INFINITY) {
            _t10 = 1.0f;
            _t11 = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t10 = 0.0f;
                _t11 = far;
            } else {
                _t10 = -(far * _t1_inv);
                _t11 = far * near * _t1_inv;
            }
        }
        dest[destOffset + 0] = _self00 * _t5_inv;
        dest[destOffset + 1] = _self10 * _t5_inv;
        dest[destOffset + 2] = _self20 * _t5_inv;
        dest[destOffset + 3] = _self30 * _t5_inv;
        dest[destOffset + 4] = _self01 * _t3_inv;
        dest[destOffset + 5] = _self11 * _t3_inv;
        dest[destOffset + 6] = _self21 * _t3_inv;
        dest[destOffset + 7] = _self31 * _t3_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t10, _self03);
        dest[destOffset + 9] = Math.fma(_self12, _t10, _self13);
        dest[destOffset + 10] = Math.fma(_self22, _t10, _self23);
        dest[destOffset + 11] = Math.fma(_self32, _t10, _self33);
        dest[destOffset + 12] = _self02 * _t11;
        dest[destOffset + 13] = _self12 * _t11;
        dest[destOffset + 14] = _self22 * _t11;
        dest[destOffset + 15] = _self32 * _t11;
        return dest;
    }

    public static float[] perspective_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t1 = near - far;
        float _t1_inv = 1.0f / _t1;
        float _t3 = (float) Math.tan(0.5f * fovy);
        float _t3_inv = 1.0f / _t3;
        float _t5 = aspect * _t3;
        float _t5_inv = 1.0f / _t5;
        float _t9, _t10;
        if (far == Float.POSITIVE_INFINITY) {
            _t9 = -1.0f;
            _t10 = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t9 = 0.0f;
                _t10 = far;
            } else {
                _t9 = far * _t1_inv;
                _t10 = far * near * _t1_inv;
            }
        }
        dest[destOffset + 0] = _self00 * _t5_inv;
        dest[destOffset + 1] = _self10 * _t5_inv;
        dest[destOffset + 2] = _self20 * _t5_inv;
        dest[destOffset + 3] = _self30 * _t5_inv;
        dest[destOffset + 4] = _self01 * _t3_inv;
        dest[destOffset + 5] = _self11 * _t3_inv;
        dest[destOffset + 6] = _self21 * _t3_inv;
        dest[destOffset + 7] = _self31 * _t3_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t9, -_self03);
        dest[destOffset + 9] = Math.fma(_self12, _t9, -_self13);
        dest[destOffset + 10] = Math.fma(_self22, _t9, -_self23);
        dest[destOffset + 11] = Math.fma(_self32, _t9, -_self33);
        dest[destOffset + 12] = _self02 * _t10;
        dest[destOffset + 13] = _self12 * _t10;
        dest[destOffset + 14] = _self22 * _t10;
        dest[destOffset + 15] = _self32 * _t10;
        return dest;
    }

    public static float[] perspective_zo(float[] dest, int destOffset, float[] src, int srcOffset, float fovy, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.perspective_zo_lh(dest, destOffset, src, srcOffset, fovy, aspect, near, far); }
            default -> { return Float4x4OpsKernelsArray.perspective_zo_rh(dest, destOffset, src, srcOffset, fovy, aspect, near, far); }
        }
    }

    public static float[] perspectiveFovRange_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t3 = near - far;
        float _t3_inv = 1.0f / _t3;
        float _t8 = _t0 - _t1;
        float _t8_inv = 1.0f / _t8;
        float _t9 = _t0 + _t1;
        float _t11 = aspect * _t8;
        float _t11_inv = 1.0f / _t11;
        float _t17, _t18;
        if (far == Float.POSITIVE_INFINITY) {
            _t17 = 1.0f;
            _t18 = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t17 = -1.0f;
                _t18 = 2.0f * far;
            } else {
                _t17 = -((far + near) * _t3_inv);
                _t18 = 2.0f * far * near * _t3_inv;
            }
        }
        dest[destOffset + 0] = 2.0f * _self00 * _t11_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t11_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t11_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t11_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t8_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t8_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t8_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t8_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t17, _self03 - _self01 * _t9 * _t8_inv);
        dest[destOffset + 9] = Math.fma(_self12, _t17, _self13 - _self11 * _t9 * _t8_inv);
        dest[destOffset + 10] = Math.fma(_self22, _t17, _self23 - _self21 * _t9 * _t8_inv);
        dest[destOffset + 11] = Math.fma(_self32, _t17, _self33 - _self31 * _t9 * _t8_inv);
        dest[destOffset + 12] = _self02 * _t18;
        dest[destOffset + 13] = _self12 * _t18;
        dest[destOffset + 14] = _self22 * _t18;
        dest[destOffset + 15] = _self32 * _t18;
        return dest;
    }

    public static float[] perspectiveFovRange_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t3 = near - far;
        float _t3_inv = 1.0f / _t3;
        float _t8 = _t0 - _t1;
        float _t8_inv = 1.0f / _t8;
        float _t9 = _t0 + _t1;
        float _t11 = aspect * _t8;
        float _t11_inv = 1.0f / _t11;
        float _t15, _t17;
        if (far == Float.POSITIVE_INFINITY) {
            _t15 = -1.0f;
            _t17 = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t15 = 1.0f;
                _t17 = 2.0f * far;
            } else {
                _t15 = (far + near) * _t3_inv;
                _t17 = 2.0f * far * near * _t3_inv;
            }
        }
        dest[destOffset + 0] = 2.0f * _self00 * _t11_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t11_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t11_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t11_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t8_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t8_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t8_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t8_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t15, _self01 * _t9 * _t8_inv - _self03);
        dest[destOffset + 9] = Math.fma(_self12, _t15, _self11 * _t9 * _t8_inv - _self13);
        dest[destOffset + 10] = Math.fma(_self22, _t15, _self21 * _t9 * _t8_inv - _self23);
        dest[destOffset + 11] = Math.fma(_self32, _t15, _self31 * _t9 * _t8_inv - _self33);
        dest[destOffset + 12] = _self02 * _t17;
        dest[destOffset + 13] = _self12 * _t17;
        dest[destOffset + 14] = _self22 * _t17;
        dest[destOffset + 15] = _self32 * _t17;
        return dest;
    }

    public static float[] perspectiveFovRange_no(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.perspectiveFovRange_no_lh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far); }
            default -> { return Float4x4OpsKernelsArray.perspectiveFovRange_no_rh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far); }
        }
    }

    public static float[] perspectiveFovRange_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t2 = near - far;
        float _t2_inv = 1.0f / _t2;
        float _t4 = _t0 - _t1;
        float _t4_inv = 1.0f / _t4;
        float _t6 = _t0 + _t1;
        float _t8 = aspect * _t4;
        float _t8_inv = 1.0f / _t8;
        float _t12, _t13;
        if (far == Float.POSITIVE_INFINITY) {
            _t12 = 1.0f;
            _t13 = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t12 = 0.0f;
                _t13 = far;
            } else {
                _t12 = -(far * _t2_inv);
                _t13 = far * near * _t2_inv;
            }
        }
        dest[destOffset + 0] = 2.0f * _self00 * _t8_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t8_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t8_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t8_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t4_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t4_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t4_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t4_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t12, _self03 - _self01 * _t6 * _t4_inv);
        dest[destOffset + 9] = Math.fma(_self12, _t12, _self13 - _self11 * _t6 * _t4_inv);
        dest[destOffset + 10] = Math.fma(_self22, _t12, _self23 - _self21 * _t6 * _t4_inv);
        dest[destOffset + 11] = Math.fma(_self32, _t12, _self33 - _self31 * _t6 * _t4_inv);
        dest[destOffset + 12] = _self02 * _t13;
        dest[destOffset + 13] = _self12 * _t13;
        dest[destOffset + 14] = _self22 * _t13;
        dest[destOffset + 15] = _self32 * _t13;
        return dest;
    }

    public static float[] perspectiveFovRange_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = (float) Math.tan(angleMax);
        float _t1 = (float) Math.tan(angleMin);
        float _t2 = near - far;
        float _t2_inv = 1.0f / _t2;
        float _t4 = _t0 - _t1;
        float _t4_inv = 1.0f / _t4;
        float _t6 = _t0 + _t1;
        float _t7 = aspect * _t4;
        float _t7_inv = 1.0f / _t7;
        float _t11, _t12;
        if (far == Float.POSITIVE_INFINITY) {
            _t11 = -1.0f;
            _t12 = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t11 = 0.0f;
                _t12 = far;
            } else {
                _t11 = far * _t2_inv;
                _t12 = far * near * _t2_inv;
            }
        }
        dest[destOffset + 0] = 2.0f * _self00 * _t7_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t7_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t7_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t7_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t4_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t4_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t4_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t4_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t11, _self01 * _t6 * _t4_inv - _self03);
        dest[destOffset + 9] = Math.fma(_self12, _t11, _self11 * _t6 * _t4_inv - _self13);
        dest[destOffset + 10] = Math.fma(_self22, _t11, _self21 * _t6 * _t4_inv - _self23);
        dest[destOffset + 11] = Math.fma(_self32, _t11, _self31 * _t6 * _t4_inv - _self33);
        dest[destOffset + 12] = _self02 * _t12;
        dest[destOffset + 13] = _self12 * _t12;
        dest[destOffset + 14] = _self22 * _t12;
        dest[destOffset + 15] = _self32 * _t12;
        return dest;
    }

    public static float[] perspectiveFovRange_zo(float[] dest, int destOffset, float[] src, int srcOffset, float angleMin, float angleMax, float aspect, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.perspectiveFovRange_zo_lh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far); }
            default -> { return Float4x4OpsKernelsArray.perspectiveFovRange_zo_rh(dest, destOffset, src, srcOffset, angleMin, angleMax, aspect, near, far); }
        }
    }

    public static float[] perspectiveFrustumSlice_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self33 = src[srcOffset + 15];
        float _t0 = near - far;
        float _t0_inv = 1.0f / _t0;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = -1.0f;
                dest[destOffset + 14] = 2.0f * far;
            } else {
                dest[destOffset + 10] = -((far + near) * _t0_inv);
                dest[destOffset + 14] = 2.0f * far * near * _t0_inv;
            }
        }
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] perspectiveFrustumSlice_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self33 = src[srcOffset + 15];
        float _t0 = near - far;
        float _t0_inv = 1.0f / _t0;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 1.0f;
                dest[destOffset + 14] = 2.0f * far;
            } else {
                dest[destOffset + 10] = (far + near) * _t0_inv;
                dest[destOffset + 14] = 2.0f * far * near * _t0_inv;
            }
        }
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] perspectiveFrustumSlice_no(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.perspectiveFrustumSlice_no_lh(dest, destOffset, src, srcOffset, near, far); }
            default -> { return Float4x4OpsKernelsArray.perspectiveFrustumSlice_no_rh(dest, destOffset, src, srcOffset, near, far); }
        }
    }

    public static float[] perspectiveFrustumSlice_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self33 = src[srcOffset + 15];
        float _t0 = near - far;
        float _t0_inv = 1.0f / _t0;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = 1.0f;
            dest[destOffset + 14] = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = far;
            } else {
                dest[destOffset + 10] = -(far * _t0_inv);
                dest[destOffset + 14] = far * near * _t0_inv;
            }
        }
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] perspectiveFrustumSlice_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self33 = src[srcOffset + 15];
        float _t0 = near - far;
        float _t0_inv = 1.0f / _t0;
        if (far == Float.POSITIVE_INFINITY) {
            dest[destOffset + 10] = -1.0f;
            dest[destOffset + 14] = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                dest[destOffset + 10] = 0.0f;
                dest[destOffset + 14] = far;
            } else {
                dest[destOffset + 10] = far * _t0_inv;
                dest[destOffset + 14] = far * near * _t0_inv;
            }
        }
        dest[destOffset + 0] = _self00;
        dest[destOffset + 1] = _self10;
        dest[destOffset + 2] = _self20;
        dest[destOffset + 3] = _self30;
        dest[destOffset + 4] = _self01;
        dest[destOffset + 5] = _self11;
        dest[destOffset + 6] = _self21;
        dest[destOffset + 7] = _self31;
        dest[destOffset + 8] = _self02;
        dest[destOffset + 9] = _self12;
        dest[destOffset + 11] = _self32;
        dest[destOffset + 12] = _self03;
        dest[destOffset + 13] = _self13;
        dest[destOffset + 15] = _self33;
        return dest;
    }

    public static float[] perspectiveFrustumSlice_zo(float[] dest, int destOffset, float[] src, int srcOffset, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.perspectiveFrustumSlice_zo_lh(dest, destOffset, src, srcOffset, near, far); }
            default -> { return Float4x4OpsKernelsArray.perspectiveFrustumSlice_zo_rh(dest, destOffset, src, srcOffset, near, far); }
        }
    }

    public static float[] perspectiveOffCenterFov_no_lh(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t5 = near - far;
        float _t5_inv = 1.0f / _t5;
        float _t10 = _t0 - _t1;
        float _t10_inv = 1.0f / _t10;
        float _t11 = _t2 - _t3;
        float _t11_inv = 1.0f / _t11;
        float _t12 = _t1 + _t0;
        float _t13 = _t3 + _t2;
        float _t20, _t21;
        if (far == Float.POSITIVE_INFINITY) {
            _t20 = 1.0f;
            _t21 = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t20 = -1.0f;
                _t21 = 2.0f * far;
            } else {
                _t20 = -((far + near) * _t5_inv);
                _t21 = 2.0f * far * near * _t5_inv;
            }
        }
        dest[destOffset + 0] = 2.0f * _self00 * _t10_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t10_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t10_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t10_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t11_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t11_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t11_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t11_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t20, _self03 - _self00 * _t12 * _t10_inv - _self01 * _t13 * _t11_inv);
        dest[destOffset + 9] = Math.fma(_self12, _t20, _self13 - _self10 * _t12 * _t10_inv - _self11 * _t13 * _t11_inv);
        dest[destOffset + 10] = Math.fma(_self22, _t20, _self23 - _self20 * _t12 * _t10_inv - _self21 * _t13 * _t11_inv);
        dest[destOffset + 11] = Math.fma(_self32, _t20, _self33 - _self30 * _t12 * _t10_inv - _self31 * _t13 * _t11_inv);
        dest[destOffset + 12] = _self02 * _t21;
        dest[destOffset + 13] = _self12 * _t21;
        dest[destOffset + 14] = _self22 * _t21;
        dest[destOffset + 15] = _self32 * _t21;
        return dest;
    }

    public static float[] perspectiveOffCenterFov_no_rh(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t5 = near - far;
        float _t5_inv = 1.0f / _t5;
        float _t10 = _t0 - _t1;
        float _t10_inv = 1.0f / _t10;
        float _t11 = _t2 - _t3;
        float _t11_inv = 1.0f / _t11;
        float _t12 = _t1 + _t0;
        float _t13 = _t3 + _t2;
        float _t18, _t20;
        if (far == Float.POSITIVE_INFINITY) {
            _t18 = -1.0f;
            _t20 = -(2.0f * near);
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t18 = 1.0f;
                _t20 = 2.0f * far;
            } else {
                _t18 = (far + near) * _t5_inv;
                _t20 = 2.0f * far * near * _t5_inv;
            }
        }
        dest[destOffset + 0] = 2.0f * _self00 * _t10_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t10_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t10_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t10_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t11_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t11_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t11_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t11_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t18, _self00 * _t12 * _t10_inv + _self01 * _t13 * _t11_inv - _self03);
        dest[destOffset + 9] = Math.fma(_self12, _t18, _self10 * _t12 * _t10_inv + _self11 * _t13 * _t11_inv - _self13);
        dest[destOffset + 10] = Math.fma(_self22, _t18, _self20 * _t12 * _t10_inv + _self21 * _t13 * _t11_inv - _self23);
        dest[destOffset + 11] = Math.fma(_self32, _t18, _self30 * _t12 * _t10_inv + _self31 * _t13 * _t11_inv - _self33);
        dest[destOffset + 12] = _self02 * _t20;
        dest[destOffset + 13] = _self12 * _t20;
        dest[destOffset + 14] = _self22 * _t20;
        dest[destOffset + 15] = _self32 * _t20;
        return dest;
    }

    public static float[] perspectiveOffCenterFov_no(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.perspectiveOffCenterFov_no_lh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
            default -> { return Float4x4OpsKernelsArray.perspectiveOffCenterFov_no_rh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
        }
    }

    public static float[] perspectiveOffCenterFov_zo_lh(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t4 = near - far;
        float _t4_inv = 1.0f / _t4;
        float _t6 = _t0 - _t1;
        float _t6_inv = 1.0f / _t6;
        float _t7 = _t2 - _t3;
        float _t7_inv = 1.0f / _t7;
        float _t9 = _t1 + _t0;
        float _t10 = _t3 + _t2;
        float _t15, _t16;
        if (far == Float.POSITIVE_INFINITY) {
            _t15 = 1.0f;
            _t16 = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t15 = 0.0f;
                _t16 = far;
            } else {
                _t15 = -(far * _t4_inv);
                _t16 = far * near * _t4_inv;
            }
        }
        dest[destOffset + 0] = 2.0f * _self00 * _t6_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t6_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t6_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t6_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t7_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t7_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t7_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t7_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t15, _self03 - _self00 * _t9 * _t6_inv - _self01 * _t10 * _t7_inv);
        dest[destOffset + 9] = Math.fma(_self12, _t15, _self13 - _self10 * _t9 * _t6_inv - _self11 * _t10 * _t7_inv);
        dest[destOffset + 10] = Math.fma(_self22, _t15, _self23 - _self20 * _t9 * _t6_inv - _self21 * _t10 * _t7_inv);
        dest[destOffset + 11] = Math.fma(_self32, _t15, _self33 - _self30 * _t9 * _t6_inv - _self31 * _t10 * _t7_inv);
        dest[destOffset + 12] = _self02 * _t16;
        dest[destOffset + 13] = _self12 * _t16;
        dest[destOffset + 14] = _self22 * _t16;
        dest[destOffset + 15] = _self32 * _t16;
        return dest;
    }

    public static float[] perspectiveOffCenterFov_zo_rh(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = (float) Math.tan(angleRight);
        float _t1 = (float) Math.tan(angleLeft);
        float _t2 = (float) Math.tan(angleUp);
        float _t3 = (float) Math.tan(angleDown);
        float _t4 = near - far;
        float _t4_inv = 1.0f / _t4;
        float _t6 = _t0 - _t1;
        float _t6_inv = 1.0f / _t6;
        float _t7 = _t2 - _t3;
        float _t7_inv = 1.0f / _t7;
        float _t9 = _t1 + _t0;
        float _t10 = _t3 + _t2;
        float _t14, _t15;
        if (far == Float.POSITIVE_INFINITY) {
            _t14 = -1.0f;
            _t15 = -near;
        } else {
            if (near == Float.POSITIVE_INFINITY) {
                _t14 = 0.0f;
                _t15 = far;
            } else {
                _t14 = far * _t4_inv;
                _t15 = far * near * _t4_inv;
            }
        }
        dest[destOffset + 0] = 2.0f * _self00 * _t6_inv;
        dest[destOffset + 1] = 2.0f * _self10 * _t6_inv;
        dest[destOffset + 2] = 2.0f * _self20 * _t6_inv;
        dest[destOffset + 3] = 2.0f * _self30 * _t6_inv;
        dest[destOffset + 4] = 2.0f * _self01 * _t7_inv;
        dest[destOffset + 5] = 2.0f * _self11 * _t7_inv;
        dest[destOffset + 6] = 2.0f * _self21 * _t7_inv;
        dest[destOffset + 7] = 2.0f * _self31 * _t7_inv;
        dest[destOffset + 8] = Math.fma(_self02, _t14, _self00 * _t9 * _t6_inv + _self01 * _t10 * _t7_inv - _self03);
        dest[destOffset + 9] = Math.fma(_self12, _t14, _self10 * _t9 * _t6_inv + _self11 * _t10 * _t7_inv - _self13);
        dest[destOffset + 10] = Math.fma(_self22, _t14, _self20 * _t9 * _t6_inv + _self21 * _t10 * _t7_inv - _self23);
        dest[destOffset + 11] = Math.fma(_self32, _t14, _self30 * _t9 * _t6_inv + _self31 * _t10 * _t7_inv - _self33);
        dest[destOffset + 12] = _self02 * _t15;
        dest[destOffset + 13] = _self12 * _t15;
        dest[destOffset + 14] = _self22 * _t15;
        dest[destOffset + 15] = _self32 * _t15;
        return dest;
    }

    public static float[] perspectiveOffCenterFov_zo(float[] dest, int destOffset, float[] src, int srcOffset, float angleLeft, float angleRight, float angleDown, float angleUp, float near, float far, Handedness handedness) {
        switch (handedness) {
            case LEFT_HANDED -> { return Float4x4OpsKernelsArray.perspectiveOffCenterFov_zo_lh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
            default -> { return Float4x4OpsKernelsArray.perspectiveOffCenterFov_zo_rh(dest, destOffset, src, srcOffset, angleLeft, angleRight, angleDown, angleUp, near, far); }
        }
    }

    public static float[] project_no(float[] dest, int destOffset, float[] src, int srcOffset, float objX, float objY, float objZ, float viewportX, float viewportY, float viewportZ, float viewportW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t2 = Math.fma(objX, _self30, Math.fma(objY, _self31, Math.fma(objZ, _self32, _self33)));
        float _t2_inv = 1.0f / _t2;
        dest[destOffset + 0] = Math.fma(0.5f, viewportZ * (1.0f + Math.fma(objX, _self00, Math.fma(objY, _self01, Math.fma(objZ, _self02, _self03))) * _t2_inv), viewportX);
        dest[destOffset + 1] = Math.fma(0.5f, viewportW * (1.0f + Math.fma(objX, _self10, Math.fma(objY, _self11, Math.fma(objZ, _self12, _self13))) * _t2_inv), viewportY);
        dest[destOffset + 2] = 0.5f * (1.0f + Math.fma(objX, _self20, Math.fma(objY, _self21, Math.fma(objZ, _self22, _self23))) * _t2_inv);
        return dest;
    }

    public static float[] project_zo(float[] dest, int destOffset, float[] src, int srcOffset, float objX, float objY, float objZ, float viewportX, float viewportY, float viewportZ, float viewportW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t2 = Math.fma(objX, _self30, Math.fma(objY, _self31, Math.fma(objZ, _self32, _self33)));
        float _t2_inv = 1.0f / _t2;
        dest[destOffset + 0] = Math.fma(0.5f, viewportZ * (1.0f + Math.fma(objX, _self00, Math.fma(objY, _self01, Math.fma(objZ, _self02, _self03))) * _t2_inv), viewportX);
        dest[destOffset + 1] = Math.fma(0.5f, viewportW * (1.0f + Math.fma(objX, _self10, Math.fma(objY, _self11, Math.fma(objZ, _self12, _self13))) * _t2_inv), viewportY);
        dest[destOffset + 2] = Math.fma(objX, _self20, Math.fma(objY, _self21, Math.fma(objZ, _self22, _self23))) * _t2_inv;
        return dest;
    }

    public static float[] project_no(float[] dest, int destOffset, float[] src, int srcOffset, float[] obj, int objOffset, float[] viewport, int viewportOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _objx = obj[objOffset + 0];
        float _objy = obj[objOffset + 1];
        float _objz = obj[objOffset + 2];
        float _viewportx = viewport[viewportOffset + 0];
        float _viewporty = viewport[viewportOffset + 1];
        float _viewportz = viewport[viewportOffset + 2];
        float _viewportw = viewport[viewportOffset + 3];
        float _t2 = Math.fma(_objx, _self30, Math.fma(_objy, _self31, Math.fma(_objz, _self32, _self33)));
        float _t2_inv = 1.0f / _t2;
        dest[destOffset + 0] = Math.fma(0.5f, _viewportz * (1.0f + Math.fma(_objx, _self00, Math.fma(_objy, _self01, Math.fma(_objz, _self02, _self03))) * _t2_inv), _viewportx);
        dest[destOffset + 1] = Math.fma(0.5f, _viewportw * (1.0f + Math.fma(_objx, _self10, Math.fma(_objy, _self11, Math.fma(_objz, _self12, _self13))) * _t2_inv), _viewporty);
        dest[destOffset + 2] = 0.5f * (1.0f + Math.fma(_objx, _self20, Math.fma(_objy, _self21, Math.fma(_objz, _self22, _self23))) * _t2_inv);
        return dest;
    }

    public static float[] project_zo(float[] dest, int destOffset, float[] src, int srcOffset, float[] obj, int objOffset, float[] viewport, int viewportOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _objx = obj[objOffset + 0];
        float _objy = obj[objOffset + 1];
        float _objz = obj[objOffset + 2];
        float _viewportx = viewport[viewportOffset + 0];
        float _viewporty = viewport[viewportOffset + 1];
        float _viewportz = viewport[viewportOffset + 2];
        float _viewportw = viewport[viewportOffset + 3];
        float _t2 = Math.fma(_objx, _self30, Math.fma(_objy, _self31, Math.fma(_objz, _self32, _self33)));
        float _t2_inv = 1.0f / _t2;
        dest[destOffset + 0] = Math.fma(0.5f, _viewportz * (1.0f + Math.fma(_objx, _self00, Math.fma(_objy, _self01, Math.fma(_objz, _self02, _self03))) * _t2_inv), _viewportx);
        dest[destOffset + 1] = Math.fma(0.5f, _viewportw * (1.0f + Math.fma(_objx, _self10, Math.fma(_objy, _self11, Math.fma(_objz, _self12, _self13))) * _t2_inv), _viewporty);
        dest[destOffset + 2] = Math.fma(_objx, _self20, Math.fma(_objy, _self21, Math.fma(_objz, _self22, _self23))) * _t2_inv;
        return dest;
    }

    public static float[] unproject_no(float[] dest, int destOffset, float[] src, int srcOffset, float winCoordsX, float winCoordsY, float winCoordsZ, float viewportX, float viewportY, float viewportZ, float viewportW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t23 = Math.fma(2.0f, winCoordsZ, -1.0f);
        float _t43 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t44 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t45 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t46 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t47 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t48 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t49 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t50 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t51 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t52 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t53 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t54 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t55 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t56 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t57 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t58 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t59 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t60 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t61 = 2.0f * (winCoordsX - viewportX) / viewportZ - 1.0f;
        float _t62 = 2.0f * (winCoordsY - viewportY) / viewportW - 1.0f;
        float _t84 = Math.fma(_self02, _t52, Math.fma(_self00, _t49, -(_self01 * _t53))) + Math.fma(-Math.fma(_self02, _t54, Math.fma(_self00, _t43, -(_self01 * _t55))), _t23, Math.fma(Math.fma(_self02, _t56, Math.fma(_self00, _t46, -(_self01 * _t57))), _t62, -(Math.fma(_self12, _t56, Math.fma(_self10, _t46, -(_self11 * _t57))) * _t61)));
        float _t84_inv = 1.0f / _t84;
        dest[destOffset + 0] = (Math.fma(Math.fma(_self03, _t43, Math.fma(_self01, _t44, -(_self02 * _t45))), _t23, Math.fma(Math.fma(_self13, _t46, Math.fma(_self11, _t47, -(_self12 * _t48))), _t61, -(Math.fma(_self03, _t46, Math.fma(_self01, _t47, -(_self02 * _t48))) * _t62))) - Math.fma(_self03, _t49, Math.fma(_self01, _t50, -(_self02 * _t51)))) * _t84_inv;
        dest[destOffset + 1] = (Math.fma(_self03, _t53, Math.fma(_self00, _t50, -(_self02 * _t58))) + Math.fma(-Math.fma(_self03, _t55, Math.fma(_self00, _t44, -(_self02 * _t59))), _t23, Math.fma(Math.fma(_self03, _t57, Math.fma(_self00, _t47, -(_self02 * _t60))), _t62, -(Math.fma(_self13, _t57, Math.fma(_self10, _t47, -(_self12 * _t60))) * _t61)))) * _t84_inv;
        dest[destOffset + 2] = (Math.fma(Math.fma(_self03, _t54, Math.fma(_self00, _t45, -(_self01 * _t59))), _t23, Math.fma(Math.fma(_self13, _t56, Math.fma(_self10, _t48, -(_self11 * _t60))), _t61, -(Math.fma(_self03, _t56, Math.fma(_self00, _t48, -(_self01 * _t60))) * _t62))) - Math.fma(_self03, _t52, Math.fma(_self00, _t51, -(_self01 * _t58)))) * _t84_inv;
        return dest;
    }

    public static float[] unproject_zo(float[] dest, int destOffset, float[] src, int srcOffset, float winCoordsX, float winCoordsY, float winCoordsZ, float viewportX, float viewportY, float viewportZ, float viewportW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = -winCoordsZ;
        float _t43 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t44 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t45 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t46 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t47 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t48 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t49 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t50 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t51 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t52 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t53 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t54 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t55 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t56 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t57 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t58 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t59 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t60 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t61 = 2.0f * (winCoordsX - viewportX) / viewportZ - 1.0f;
        float _t62 = 2.0f * (winCoordsY - viewportY) / viewportW - 1.0f;
        float _t83 = Math.fma(_self02, _t52, Math.fma(_self00, _t49, -(_self01 * _t53))) + Math.fma(_t0, Math.fma(_self02, _t54, Math.fma(_self00, _t43, -(_self01 * _t55))), Math.fma(Math.fma(_self02, _t56, Math.fma(_self00, _t46, -(_self01 * _t57))), _t62, -(Math.fma(_self12, _t56, Math.fma(_self10, _t46, -(_self11 * _t57))) * _t61)));
        float _t83_inv = 1.0f / _t83;
        dest[destOffset + 0] = (Math.fma(winCoordsZ, Math.fma(_self03, _t43, Math.fma(_self01, _t44, -(_self02 * _t45))), Math.fma(Math.fma(_self13, _t46, Math.fma(_self11, _t47, -(_self12 * _t48))), _t61, -(Math.fma(_self03, _t46, Math.fma(_self01, _t47, -(_self02 * _t48))) * _t62))) - Math.fma(_self03, _t49, Math.fma(_self01, _t50, -(_self02 * _t51)))) * _t83_inv;
        dest[destOffset + 1] = (Math.fma(_self03, _t53, Math.fma(_self00, _t50, -(_self02 * _t58))) + Math.fma(_t0, Math.fma(_self03, _t55, Math.fma(_self00, _t44, -(_self02 * _t59))), Math.fma(Math.fma(_self03, _t57, Math.fma(_self00, _t47, -(_self02 * _t60))), _t62, -(Math.fma(_self13, _t57, Math.fma(_self10, _t47, -(_self12 * _t60))) * _t61)))) * _t83_inv;
        dest[destOffset + 2] = (Math.fma(winCoordsZ, Math.fma(_self03, _t54, Math.fma(_self00, _t45, -(_self01 * _t59))), Math.fma(Math.fma(_self13, _t56, Math.fma(_self10, _t48, -(_self11 * _t60))), _t61, -(Math.fma(_self03, _t56, Math.fma(_self00, _t48, -(_self01 * _t60))) * _t62))) - Math.fma(_self03, _t52, Math.fma(_self00, _t51, -(_self01 * _t58)))) * _t83_inv;
        return dest;
    }

    public static float[] unproject_no(float[] dest, int destOffset, float[] src, int srcOffset, float[] winCoords, int winCoordsOffset, float[] viewport, int viewportOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _winCoordsx = winCoords[winCoordsOffset + 0];
        float _winCoordsy = winCoords[winCoordsOffset + 1];
        float _winCoordsz = winCoords[winCoordsOffset + 2];
        float _viewportx = viewport[viewportOffset + 0];
        float _viewporty = viewport[viewportOffset + 1];
        float _viewportz = viewport[viewportOffset + 2];
        float _viewportw = viewport[viewportOffset + 3];
        float _t23 = Math.fma(2.0f, _winCoordsz, -1.0f);
        float _t43 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t44 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t45 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t46 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t47 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t48 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t49 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t50 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t51 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t52 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t53 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t54 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t55 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t56 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t57 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t58 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t59 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t60 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t61 = 2.0f * (_winCoordsx - _viewportx) / _viewportz - 1.0f;
        float _t62 = 2.0f * (_winCoordsy - _viewporty) / _viewportw - 1.0f;
        float _t84 = Math.fma(_self02, _t52, Math.fma(_self00, _t49, -(_self01 * _t53))) + Math.fma(-Math.fma(_self02, _t54, Math.fma(_self00, _t43, -(_self01 * _t55))), _t23, Math.fma(Math.fma(_self02, _t56, Math.fma(_self00, _t46, -(_self01 * _t57))), _t62, -(Math.fma(_self12, _t56, Math.fma(_self10, _t46, -(_self11 * _t57))) * _t61)));
        float _t84_inv = 1.0f / _t84;
        dest[destOffset + 0] = (Math.fma(Math.fma(_self03, _t43, Math.fma(_self01, _t44, -(_self02 * _t45))), _t23, Math.fma(Math.fma(_self13, _t46, Math.fma(_self11, _t47, -(_self12 * _t48))), _t61, -(Math.fma(_self03, _t46, Math.fma(_self01, _t47, -(_self02 * _t48))) * _t62))) - Math.fma(_self03, _t49, Math.fma(_self01, _t50, -(_self02 * _t51)))) * _t84_inv;
        dest[destOffset + 1] = (Math.fma(_self03, _t53, Math.fma(_self00, _t50, -(_self02 * _t58))) + Math.fma(-Math.fma(_self03, _t55, Math.fma(_self00, _t44, -(_self02 * _t59))), _t23, Math.fma(Math.fma(_self03, _t57, Math.fma(_self00, _t47, -(_self02 * _t60))), _t62, -(Math.fma(_self13, _t57, Math.fma(_self10, _t47, -(_self12 * _t60))) * _t61)))) * _t84_inv;
        dest[destOffset + 2] = (Math.fma(Math.fma(_self03, _t54, Math.fma(_self00, _t45, -(_self01 * _t59))), _t23, Math.fma(Math.fma(_self13, _t56, Math.fma(_self10, _t48, -(_self11 * _t60))), _t61, -(Math.fma(_self03, _t56, Math.fma(_self00, _t48, -(_self01 * _t60))) * _t62))) - Math.fma(_self03, _t52, Math.fma(_self00, _t51, -(_self01 * _t58)))) * _t84_inv;
        return dest;
    }

    public static float[] unproject_zo(float[] dest, int destOffset, float[] src, int srcOffset, float[] winCoords, int winCoordsOffset, float[] viewport, int viewportOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _winCoordsx = winCoords[winCoordsOffset + 0];
        float _winCoordsy = winCoords[winCoordsOffset + 1];
        float _winCoordsz = winCoords[winCoordsOffset + 2];
        float _viewportx = viewport[viewportOffset + 0];
        float _viewporty = viewport[viewportOffset + 1];
        float _viewportz = viewport[viewportOffset + 2];
        float _viewportw = viewport[viewportOffset + 3];
        float _t0 = -_winCoordsz;
        float _t43 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t44 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t45 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t46 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t47 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t48 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t49 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t50 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t51 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t52 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t53 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t54 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t55 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t56 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t57 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t58 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t59 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t60 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t61 = 2.0f * (_winCoordsx - _viewportx) / _viewportz - 1.0f;
        float _t62 = 2.0f * (_winCoordsy - _viewporty) / _viewportw - 1.0f;
        float _t83 = Math.fma(_self02, _t52, Math.fma(_self00, _t49, -(_self01 * _t53))) + Math.fma(_t0, Math.fma(_self02, _t54, Math.fma(_self00, _t43, -(_self01 * _t55))), Math.fma(Math.fma(_self02, _t56, Math.fma(_self00, _t46, -(_self01 * _t57))), _t62, -(Math.fma(_self12, _t56, Math.fma(_self10, _t46, -(_self11 * _t57))) * _t61)));
        float _t83_inv = 1.0f / _t83;
        dest[destOffset + 0] = (Math.fma(_winCoordsz, Math.fma(_self03, _t43, Math.fma(_self01, _t44, -(_self02 * _t45))), Math.fma(Math.fma(_self13, _t46, Math.fma(_self11, _t47, -(_self12 * _t48))), _t61, -(Math.fma(_self03, _t46, Math.fma(_self01, _t47, -(_self02 * _t48))) * _t62))) - Math.fma(_self03, _t49, Math.fma(_self01, _t50, -(_self02 * _t51)))) * _t83_inv;
        dest[destOffset + 1] = (Math.fma(_self03, _t53, Math.fma(_self00, _t50, -(_self02 * _t58))) + Math.fma(_t0, Math.fma(_self03, _t55, Math.fma(_self00, _t44, -(_self02 * _t59))), Math.fma(Math.fma(_self03, _t57, Math.fma(_self00, _t47, -(_self02 * _t60))), _t62, -(Math.fma(_self13, _t57, Math.fma(_self10, _t47, -(_self12 * _t60))) * _t61)))) * _t83_inv;
        dest[destOffset + 2] = (Math.fma(_winCoordsz, Math.fma(_self03, _t54, Math.fma(_self00, _t45, -(_self01 * _t59))), Math.fma(Math.fma(_self13, _t56, Math.fma(_self10, _t48, -(_self11 * _t60))), _t61, -(Math.fma(_self03, _t56, Math.fma(_self00, _t48, -(_self01 * _t60))) * _t62))) - Math.fma(_self03, _t52, Math.fma(_self00, _t51, -(_self01 * _t58)))) * _t83_inv;
        return dest;
    }

    public static float[] unprojectInv_no(float[] dest, int destOffset, float[] src, int srcOffset, float winCoordsX, float winCoordsY, float winCoordsZ, float viewportX, float viewportY, float viewportZ, float viewportW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t2 = Math.fma(2.0f, winCoordsZ, -1.0f);
        float _t8 = 2.0f * (winCoordsX - viewportX) / viewportZ - 1.0f;
        float _t9 = 2.0f * (winCoordsY - viewportY) / viewportW - 1.0f;
        float _t11 = Math.fma(_self30, _t8, Math.fma(_self31, _t9, Math.fma(_self32, _t2, _self33)));
        float _t11_inv = 1.0f / _t11;
        dest[destOffset + 0] = Math.fma(_self00, _t8, Math.fma(_self01, _t9, Math.fma(_self02, _t2, _self03))) * _t11_inv;
        dest[destOffset + 1] = Math.fma(_self10, _t8, Math.fma(_self11, _t9, Math.fma(_self12, _t2, _self13))) * _t11_inv;
        dest[destOffset + 2] = Math.fma(_self20, _t8, Math.fma(_self21, _t9, Math.fma(_self22, _t2, _self23))) * _t11_inv;
        return dest;
    }

    public static float[] unprojectInv_zo(float[] dest, int destOffset, float[] src, int srcOffset, float winCoordsX, float winCoordsY, float winCoordsZ, float viewportX, float viewportY, float viewportZ, float viewportW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t7 = 2.0f * (winCoordsX - viewportX) / viewportZ - 1.0f;
        float _t8 = 2.0f * (winCoordsY - viewportY) / viewportW - 1.0f;
        float _t10 = Math.fma(_self30, _t7, Math.fma(_self31, _t8, Math.fma(_self32, winCoordsZ, _self33)));
        float _t10_inv = 1.0f / _t10;
        dest[destOffset + 0] = Math.fma(_self00, _t7, Math.fma(_self01, _t8, Math.fma(_self02, winCoordsZ, _self03))) * _t10_inv;
        dest[destOffset + 1] = Math.fma(_self10, _t7, Math.fma(_self11, _t8, Math.fma(_self12, winCoordsZ, _self13))) * _t10_inv;
        dest[destOffset + 2] = Math.fma(_self20, _t7, Math.fma(_self21, _t8, Math.fma(_self22, winCoordsZ, _self23))) * _t10_inv;
        return dest;
    }

    public static float[] unprojectInv_no(float[] dest, int destOffset, float[] src, int srcOffset, float[] winCoords, int winCoordsOffset, float[] viewport, int viewportOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _winCoordsx = winCoords[winCoordsOffset + 0];
        float _winCoordsy = winCoords[winCoordsOffset + 1];
        float _winCoordsz = winCoords[winCoordsOffset + 2];
        float _viewportx = viewport[viewportOffset + 0];
        float _viewporty = viewport[viewportOffset + 1];
        float _viewportz = viewport[viewportOffset + 2];
        float _viewportw = viewport[viewportOffset + 3];
        float _t2 = Math.fma(2.0f, _winCoordsz, -1.0f);
        float _t8 = 2.0f * (_winCoordsx - _viewportx) / _viewportz - 1.0f;
        float _t9 = 2.0f * (_winCoordsy - _viewporty) / _viewportw - 1.0f;
        float _t11 = Math.fma(_self30, _t8, Math.fma(_self31, _t9, Math.fma(_self32, _t2, _self33)));
        float _t11_inv = 1.0f / _t11;
        dest[destOffset + 0] = Math.fma(_self00, _t8, Math.fma(_self01, _t9, Math.fma(_self02, _t2, _self03))) * _t11_inv;
        dest[destOffset + 1] = Math.fma(_self10, _t8, Math.fma(_self11, _t9, Math.fma(_self12, _t2, _self13))) * _t11_inv;
        dest[destOffset + 2] = Math.fma(_self20, _t8, Math.fma(_self21, _t9, Math.fma(_self22, _t2, _self23))) * _t11_inv;
        return dest;
    }

    public static float[] unprojectInv_zo(float[] dest, int destOffset, float[] src, int srcOffset, float[] winCoords, int winCoordsOffset, float[] viewport, int viewportOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _winCoordsx = winCoords[winCoordsOffset + 0];
        float _winCoordsy = winCoords[winCoordsOffset + 1];
        float _winCoordsz = winCoords[winCoordsOffset + 2];
        float _viewportx = viewport[viewportOffset + 0];
        float _viewporty = viewport[viewportOffset + 1];
        float _viewportz = viewport[viewportOffset + 2];
        float _viewportw = viewport[viewportOffset + 3];
        float _t7 = 2.0f * (_winCoordsx - _viewportx) / _viewportz - 1.0f;
        float _t8 = 2.0f * (_winCoordsy - _viewporty) / _viewportw - 1.0f;
        float _t10 = Math.fma(_self30, _t7, Math.fma(_self31, _t8, Math.fma(_self32, _winCoordsz, _self33)));
        float _t10_inv = 1.0f / _t10;
        dest[destOffset + 0] = Math.fma(_self00, _t7, Math.fma(_self01, _t8, Math.fma(_self02, _winCoordsz, _self03))) * _t10_inv;
        dest[destOffset + 1] = Math.fma(_self10, _t7, Math.fma(_self11, _t8, Math.fma(_self12, _winCoordsz, _self13))) * _t10_inv;
        dest[destOffset + 2] = Math.fma(_self20, _t7, Math.fma(_self21, _t8, Math.fma(_self22, _winCoordsz, _self23))) * _t10_inv;
        return dest;
    }

    public static float[] unprojectInvRay_no(float[] rayOrigin, int rayOriginOffset, float[] rayDir, int rayDirOffset, float[] src, int srcOffset, float winCoordsX, float winCoordsY, float viewportX, float viewportY, float viewportZ, float viewportW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t11 = 2.0f * (winCoordsX - viewportX) / viewportZ - 1.0f;
        float _t12 = 2.0f * (winCoordsY - viewportY) / viewportW - 1.0f;
        float _t18 = Math.fma(_self00, _t11, Math.fma(_self01, _t12, _self03 - _self02));
        float _t19 = Math.fma(_self30, _t11, Math.fma(_self31, _t12, _self33 - _self32));
        float _t19_inv = 1.0f / _t19;
        float _t20 = Math.fma(_self10, _t11, Math.fma(_self11, _t12, _self13 - _self12));
        float _t21 = Math.fma(_self20, _t11, Math.fma(_self21, _t12, _self23 - _self22));
        float _t22 = Math.fma(_self30, _t11, Math.fma(_self31, _t12, _self33 + _self32));
        float _t26 = Math.abs(_t22) <= Math.abs(_t19) * 9.536743E-7f ? _t19 : _t22;
        float _t26_inv = 1.0f / _t26;
        rayOrigin[rayOriginOffset + 0] = _t18 * _t19_inv;
        rayOrigin[rayOriginOffset + 1] = _t20 * _t19_inv;
        rayOrigin[rayOriginOffset + 2] = _t21 * _t19_inv;
        rayDir[rayDirOffset + 0] = Math.fma(_self00, _t11, Math.fma(_self01, _t12, _self03 + _self02 - _t18 * _t22 * _t19_inv)) * _t26_inv;
        rayDir[rayDirOffset + 1] = Math.fma(_self10, _t11, Math.fma(_self11, _t12, _self13 + _self12 - _t20 * _t22 * _t19_inv)) * _t26_inv;
        rayDir[rayDirOffset + 2] = Math.fma(_self20, _t11, Math.fma(_self21, _t12, _self23 + _self22 - _t21 * _t22 * _t19_inv)) * _t26_inv;
        return rayOrigin;
    }

    public static float[] unprojectInvRay_zo(float[] rayOrigin, int rayOriginOffset, float[] rayDir, int rayDirOffset, float[] src, int srcOffset, float winCoordsX, float winCoordsY, float viewportX, float viewportY, float viewportZ, float viewportW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t7 = 2.0f * (winCoordsX - viewportX) / viewportZ - 1.0f;
        float _t8 = 2.0f * (winCoordsY - viewportY) / viewportW - 1.0f;
        float _t14 = Math.fma(_self00, _t7, Math.fma(_self01, _t8, _self03));
        float _t15 = Math.fma(_self30, _t7, Math.fma(_self31, _t8, _self33));
        float _t15_inv = 1.0f / _t15;
        float _t16 = Math.fma(_self10, _t7, Math.fma(_self11, _t8, _self13));
        float _t17 = Math.fma(_self20, _t7, Math.fma(_self21, _t8, _self23));
        float _t19 = Math.fma(_self30, _t7, Math.fma(_self31, _t8, _self33 + _self32));
        float _t22 = Math.abs(_t19) <= Math.abs(_t15) * 9.536743E-7f ? _t15 : _t19;
        float _t22_inv = 1.0f / _t22;
        rayOrigin[rayOriginOffset + 0] = _t14 * _t15_inv;
        rayOrigin[rayOriginOffset + 1] = _t16 * _t15_inv;
        rayOrigin[rayOriginOffset + 2] = _t17 * _t15_inv;
        rayDir[rayDirOffset + 0] = Math.fma(_self00, _t7, Math.fma(_self01, _t8, _self03 + _self02 - _t14 * _t19 * _t15_inv)) * _t22_inv;
        rayDir[rayDirOffset + 1] = Math.fma(_self10, _t7, Math.fma(_self11, _t8, _self13 + _self12 - _t16 * _t19 * _t15_inv)) * _t22_inv;
        rayDir[rayDirOffset + 2] = Math.fma(_self20, _t7, Math.fma(_self21, _t8, _self23 + _self22 - _t17 * _t19 * _t15_inv)) * _t22_inv;
        return rayOrigin;
    }

    public static float[] unprojectInvRay_no(float[] rayOrigin, int rayOriginOffset, float[] rayDir, int rayDirOffset, float[] src, int srcOffset, float[] winCoords, int winCoordsOffset, float[] viewport, int viewportOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _winCoordsx = winCoords[winCoordsOffset + 0];
        float _winCoordsy = winCoords[winCoordsOffset + 1];
        float _viewportx = viewport[viewportOffset + 0];
        float _viewporty = viewport[viewportOffset + 1];
        float _viewportz = viewport[viewportOffset + 2];
        float _viewportw = viewport[viewportOffset + 3];
        float _t11 = 2.0f * (_winCoordsx - _viewportx) / _viewportz - 1.0f;
        float _t12 = 2.0f * (_winCoordsy - _viewporty) / _viewportw - 1.0f;
        float _t18 = Math.fma(_self00, _t11, Math.fma(_self01, _t12, _self03 - _self02));
        float _t19 = Math.fma(_self30, _t11, Math.fma(_self31, _t12, _self33 - _self32));
        float _t19_inv = 1.0f / _t19;
        float _t20 = Math.fma(_self10, _t11, Math.fma(_self11, _t12, _self13 - _self12));
        float _t21 = Math.fma(_self20, _t11, Math.fma(_self21, _t12, _self23 - _self22));
        float _t22 = Math.fma(_self30, _t11, Math.fma(_self31, _t12, _self33 + _self32));
        float _t26 = Math.abs(_t22) <= Math.abs(_t19) * 9.536743E-7f ? _t19 : _t22;
        float _t26_inv = 1.0f / _t26;
        rayOrigin[rayOriginOffset + 0] = _t18 * _t19_inv;
        rayOrigin[rayOriginOffset + 1] = _t20 * _t19_inv;
        rayOrigin[rayOriginOffset + 2] = _t21 * _t19_inv;
        rayDir[rayDirOffset + 0] = Math.fma(_self00, _t11, Math.fma(_self01, _t12, _self03 + _self02 - _t18 * _t22 * _t19_inv)) * _t26_inv;
        rayDir[rayDirOffset + 1] = Math.fma(_self10, _t11, Math.fma(_self11, _t12, _self13 + _self12 - _t20 * _t22 * _t19_inv)) * _t26_inv;
        rayDir[rayDirOffset + 2] = Math.fma(_self20, _t11, Math.fma(_self21, _t12, _self23 + _self22 - _t21 * _t22 * _t19_inv)) * _t26_inv;
        return rayOrigin;
    }

    public static float[] unprojectInvRay_zo(float[] rayOrigin, int rayOriginOffset, float[] rayDir, int rayDirOffset, float[] src, int srcOffset, float[] winCoords, int winCoordsOffset, float[] viewport, int viewportOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _winCoordsx = winCoords[winCoordsOffset + 0];
        float _winCoordsy = winCoords[winCoordsOffset + 1];
        float _viewportx = viewport[viewportOffset + 0];
        float _viewporty = viewport[viewportOffset + 1];
        float _viewportz = viewport[viewportOffset + 2];
        float _viewportw = viewport[viewportOffset + 3];
        float _t7 = 2.0f * (_winCoordsx - _viewportx) / _viewportz - 1.0f;
        float _t8 = 2.0f * (_winCoordsy - _viewporty) / _viewportw - 1.0f;
        float _t14 = Math.fma(_self00, _t7, Math.fma(_self01, _t8, _self03));
        float _t15 = Math.fma(_self30, _t7, Math.fma(_self31, _t8, _self33));
        float _t15_inv = 1.0f / _t15;
        float _t16 = Math.fma(_self10, _t7, Math.fma(_self11, _t8, _self13));
        float _t17 = Math.fma(_self20, _t7, Math.fma(_self21, _t8, _self23));
        float _t19 = Math.fma(_self30, _t7, Math.fma(_self31, _t8, _self33 + _self32));
        float _t22 = Math.abs(_t19) <= Math.abs(_t15) * 9.536743E-7f ? _t15 : _t19;
        float _t22_inv = 1.0f / _t22;
        rayOrigin[rayOriginOffset + 0] = _t14 * _t15_inv;
        rayOrigin[rayOriginOffset + 1] = _t16 * _t15_inv;
        rayOrigin[rayOriginOffset + 2] = _t17 * _t15_inv;
        rayDir[rayDirOffset + 0] = Math.fma(_self00, _t7, Math.fma(_self01, _t8, _self03 + _self02 - _t14 * _t19 * _t15_inv)) * _t22_inv;
        rayDir[rayDirOffset + 1] = Math.fma(_self10, _t7, Math.fma(_self11, _t8, _self13 + _self12 - _t16 * _t19 * _t15_inv)) * _t22_inv;
        rayDir[rayDirOffset + 2] = Math.fma(_self20, _t7, Math.fma(_self21, _t8, _self23 + _self22 - _t17 * _t19 * _t15_inv)) * _t22_inv;
        return rayOrigin;
    }

    public static float[] unprojectRay_no(float[] rayOrigin, int rayOriginOffset, float[] rayDir, int rayDirOffset, float[] src, int srcOffset, float winCoordsX, float winCoordsY, float viewportX, float viewportY, float viewportZ, float viewportW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = -_self01;
        float _t1 = -_self00;
        float _t44 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t45 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t46 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t47 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t48 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t49 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t50 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t51 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t52 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t53 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t54 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t55 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t56 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t57 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t58 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t59 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t60 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t61 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t62 = 2.0f * (winCoordsX - viewportX) / viewportZ - 1.0f;
        float _t63 = 2.0f * (winCoordsY - viewportY) / viewportW - 1.0f;
        float _t87 = -(_self03 * _t52);
        float _t91 = -(_self01 * _t58);
        float _t95 = -(_self02 * _t61);
        float _t100 = -(_self03 * _t57);
        float _t122 = Math.fma(_self13, _t44, Math.fma(_self11, _t45, -(_self12 * _t46)));
        float _t128 = Math.fma(_self13, _t55, Math.fma(_self10, _t46, -(_self11 * _t60)));
        float _t131 = Math.fma(_self02, _t55, Math.fma(_self00, _t44, -(_self01 * _t56))) * _t63;
        float _t133 = Math.fma(_self03, _t56, Math.fma(_self00, _t45, -(_self02 * _t60))) * _t63;
        float _t136 = -(Math.fma(_self03, _t44, Math.fma(_self01, _t45, -(_self02 * _t46))) * _t63);
        float _t137 = -(Math.fma(_self12, _t55, Math.fma(_self10, _t44, -(_self11 * _t56))) * _t62);
        float _t138 = -(Math.fma(_self13, _t56, Math.fma(_self10, _t45, -(_self12 * _t60))) * _t62);
        float _t139 = -(Math.fma(_self03, _t55, Math.fma(_self00, _t46, -(_self01 * _t60))) * _t63);
        float _t158 = Math.fma(_self00, _t50, -(_self01 * _t53)) + Math.fma(_self02, _t54, _t131) + (Math.fma(_self00, _t52, _t137) + Math.fma(_self02, _t57, _t91));
        float _t158_inv = 1.0f / _t158;
        float _t159 = Math.fma(_self00, _t48, -(_self02 * _t59)) + Math.fma(_self03, _t53, _t133) + (Math.fma(_self00, _t49, _t138) + Math.fma(_self03, _t58, _t95));
        float _t160 = Math.fma(_self00, _t52, _t91) + Math.fma(_self02, _t57, _t131) + (Math.fma(_t1, _t50, _t137) + Math.fma(_self01, _t53, -(_self02 * _t54)));
        float _t162 = Math.fma(_t122, _t62, _t136) + Math.fma(_self02, _t47, -(_self01 * _t48)) + (Math.fma(_t0, _t49, -(_self03 * _t50)) + Math.fma(_self02, _t51, _t87));
        float _t163 = Math.fma(_t128, _t62, _t139) + Math.fma(_self01, _t59, -(_self00 * _t47)) + (Math.fma(_t1, _t51, -(_self03 * _t54)) + Math.fma(_self01, _t61, _t100));
        float _t166 = Math.abs(_t160) <= Math.abs(_t158) * 9.536743E-7f ? _t158 : _t160;
        float _t166_inv = 1.0f / _t166;
        rayOrigin[rayOriginOffset + 0] = _t162 * _t158_inv;
        rayOrigin[rayOriginOffset + 1] = _t159 * _t158_inv;
        rayOrigin[rayOriginOffset + 2] = _t163 * _t158_inv;
        rayDir[rayDirOffset + 0] = (Math.fma(_self01, _t48, -(_self02 * _t47)) + Math.fma(_self03, _t50, _t122 * _t62) + (Math.fma(_t0, _t49, _t136) + Math.fma(_self02, _t51, _t87 - _t160 * _t162 * _t158_inv))) * _t166_inv;
        rayDir[rayDirOffset + 1] = (Math.fma(_self00, _t49, _t95) + Math.fma(_self03, _t58, _t133) + (Math.fma(_t1, _t48, _t138) + Math.fma(_self02, _t59, -(_self03 * _t53) - _t159 * _t160 * _t158_inv))) * _t166_inv;
        rayDir[rayDirOffset + 2] = (Math.fma(_self00, _t47, -(_self01 * _t59)) + Math.fma(_self03, _t54, _t128 * _t62) + (Math.fma(_t1, _t51, _t139) + Math.fma(_self01, _t61, _t100 - _t160 * _t163 * _t158_inv))) * _t166_inv;
        return rayOrigin;
    }

    public static float[] unprojectRay_zo(float[] rayOrigin, int rayOriginOffset, float[] rayDir, int rayDirOffset, float[] src, int srcOffset, float winCoordsX, float winCoordsY, float viewportX, float viewportY, float viewportZ, float viewportW) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _t0 = -_self00;
        float _t43 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t44 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t45 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t46 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t47 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t48 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t49 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t50 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t51 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t52 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t53 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t54 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t55 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t56 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t57 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t58 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t59 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t60 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t61 = 2.0f * (winCoordsX - viewportX) / viewportZ - 1.0f;
        float _t62 = 2.0f * (winCoordsY - viewportY) / viewportW - 1.0f;
        float _t92 = Math.fma(_self00, _t46, -(_self01 * _t50));
        float _t95 = Math.fma(_self00, _t47, -(_self02 * _t53));
        float _t102 = Math.fma(_self13, _t43, Math.fma(_self11, _t44, -(_self12 * _t45)));
        float _t106 = Math.fma(_self02, _t51, Math.fma(_self00, _t43, -(_self01 * _t52)));
        float _t109 = Math.fma(_self03, _t52, Math.fma(_self00, _t44, -(_self02 * _t54)));
        float _t111 = Math.fma(_self13, _t51, Math.fma(_self10, _t45, -(_self11 * _t54)));
        float _t119 = -(Math.fma(_self03, _t43, Math.fma(_self01, _t44, -(_self02 * _t45))) * _t62);
        float _t120 = -(Math.fma(_self12, _t51, Math.fma(_self10, _t43, -(_self11 * _t52))) * _t61);
        float _t121 = -(Math.fma(_self13, _t52, Math.fma(_self10, _t44, -(_self12 * _t54))) * _t61);
        float _t122 = -(Math.fma(_self03, _t51, Math.fma(_self00, _t45, -(_self01 * _t54))) * _t62);
        float _t131 = Math.fma(_t102, _t61, _t119) - Math.fma(_self03, _t46, Math.fma(_self01, _t47, -(_self02 * _t48)));
        float _t132 = Math.fma(_self02, _t49, _t92) + Math.fma(_t106, _t62, _t120);
        float _t132_inv = 1.0f / _t132;
        float _t133 = Math.fma(_self03, _t50, _t95) + Math.fma(_t109, _t62, _t121);
        float _t134 = Math.fma(_t111, _t61, _t122) - Math.fma(_self03, _t49, Math.fma(_self00, _t48, -(_self01 * _t53)));
        float _t137 = _t92 + Math.fma(_self02, _t49, _t106 * _t62) + (Math.fma(_t0, _t57, _t120) + Math.fma(_self01, _t58, -(_self02 * _t59)));
        float _t139 = Math.abs(_t137) <= Math.abs(_t132) * 9.536743E-7f ? _t132 : _t137;
        float _t139_inv = 1.0f / _t139;
        rayOrigin[rayOriginOffset + 0] = _t131 * _t132_inv;
        rayOrigin[rayOriginOffset + 1] = _t133 * _t132_inv;
        rayOrigin[rayOriginOffset + 2] = _t134 * _t132_inv;
        rayDir[rayDirOffset + 0] = (Math.fma(_self01, _t55, -(_self02 * _t56)) + Math.fma(_self03, _t57, _t102 * _t61) + (Math.fma(-_self01, _t47, _t119) + Math.fma(_self02, _t48, -(_self03 * _t46) - _t137 * _t131 * _t132_inv))) * _t139_inv;
        rayDir[rayDirOffset + 1] = (_t95 + Math.fma(_self03, _t50, _t109 * _t62) + (Math.fma(_t0, _t55, _t121) + Math.fma(_self02, _t60, -(_self03 * _t58) - _t137 * _t133 * _t132_inv))) * _t139_inv;
        rayDir[rayDirOffset + 2] = (Math.fma(_self00, _t56, -(_self01 * _t60)) + Math.fma(_self03, _t59, _t111 * _t61) + (Math.fma(_t0, _t48, _t122) + Math.fma(_self01, _t53, -(_self03 * _t49) - _t137 * _t134 * _t132_inv))) * _t139_inv;
        return rayOrigin;
    }

    public static float[] unprojectRay_no(float[] rayOrigin, int rayOriginOffset, float[] rayDir, int rayDirOffset, float[] src, int srcOffset, float[] winCoords, int winCoordsOffset, float[] viewport, int viewportOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _winCoordsx = winCoords[winCoordsOffset + 0];
        float _winCoordsy = winCoords[winCoordsOffset + 1];
        float _viewportx = viewport[viewportOffset + 0];
        float _viewporty = viewport[viewportOffset + 1];
        float _viewportz = viewport[viewportOffset + 2];
        float _viewportw = viewport[viewportOffset + 3];
        float _t0 = -_self01;
        float _t1 = -_self00;
        float _t44 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t45 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t46 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t47 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t48 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t49 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t50 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t51 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t52 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t53 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t54 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t55 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t56 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t57 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t58 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t59 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t60 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t61 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t62 = 2.0f * (_winCoordsx - _viewportx) / _viewportz - 1.0f;
        float _t63 = 2.0f * (_winCoordsy - _viewporty) / _viewportw - 1.0f;
        float _t87 = -(_self03 * _t52);
        float _t91 = -(_self01 * _t58);
        float _t95 = -(_self02 * _t61);
        float _t100 = -(_self03 * _t57);
        float _t122 = Math.fma(_self13, _t44, Math.fma(_self11, _t45, -(_self12 * _t46)));
        float _t128 = Math.fma(_self13, _t55, Math.fma(_self10, _t46, -(_self11 * _t60)));
        float _t131 = Math.fma(_self02, _t55, Math.fma(_self00, _t44, -(_self01 * _t56))) * _t63;
        float _t133 = Math.fma(_self03, _t56, Math.fma(_self00, _t45, -(_self02 * _t60))) * _t63;
        float _t136 = -(Math.fma(_self03, _t44, Math.fma(_self01, _t45, -(_self02 * _t46))) * _t63);
        float _t137 = -(Math.fma(_self12, _t55, Math.fma(_self10, _t44, -(_self11 * _t56))) * _t62);
        float _t138 = -(Math.fma(_self13, _t56, Math.fma(_self10, _t45, -(_self12 * _t60))) * _t62);
        float _t139 = -(Math.fma(_self03, _t55, Math.fma(_self00, _t46, -(_self01 * _t60))) * _t63);
        float _t158 = Math.fma(_self00, _t50, -(_self01 * _t53)) + Math.fma(_self02, _t54, _t131) + (Math.fma(_self00, _t52, _t137) + Math.fma(_self02, _t57, _t91));
        float _t158_inv = 1.0f / _t158;
        float _t159 = Math.fma(_self00, _t48, -(_self02 * _t59)) + Math.fma(_self03, _t53, _t133) + (Math.fma(_self00, _t49, _t138) + Math.fma(_self03, _t58, _t95));
        float _t160 = Math.fma(_self00, _t52, _t91) + Math.fma(_self02, _t57, _t131) + (Math.fma(_t1, _t50, _t137) + Math.fma(_self01, _t53, -(_self02 * _t54)));
        float _t162 = Math.fma(_t122, _t62, _t136) + Math.fma(_self02, _t47, -(_self01 * _t48)) + (Math.fma(_t0, _t49, -(_self03 * _t50)) + Math.fma(_self02, _t51, _t87));
        float _t163 = Math.fma(_t128, _t62, _t139) + Math.fma(_self01, _t59, -(_self00 * _t47)) + (Math.fma(_t1, _t51, -(_self03 * _t54)) + Math.fma(_self01, _t61, _t100));
        float _t166 = Math.abs(_t160) <= Math.abs(_t158) * 9.536743E-7f ? _t158 : _t160;
        float _t166_inv = 1.0f / _t166;
        rayOrigin[rayOriginOffset + 0] = _t162 * _t158_inv;
        rayOrigin[rayOriginOffset + 1] = _t159 * _t158_inv;
        rayOrigin[rayOriginOffset + 2] = _t163 * _t158_inv;
        rayDir[rayDirOffset + 0] = (Math.fma(_self01, _t48, -(_self02 * _t47)) + Math.fma(_self03, _t50, _t122 * _t62) + (Math.fma(_t0, _t49, _t136) + Math.fma(_self02, _t51, _t87 - _t160 * _t162 * _t158_inv))) * _t166_inv;
        rayDir[rayDirOffset + 1] = (Math.fma(_self00, _t49, _t95) + Math.fma(_self03, _t58, _t133) + (Math.fma(_t1, _t48, _t138) + Math.fma(_self02, _t59, -(_self03 * _t53) - _t159 * _t160 * _t158_inv))) * _t166_inv;
        rayDir[rayDirOffset + 2] = (Math.fma(_self00, _t47, -(_self01 * _t59)) + Math.fma(_self03, _t54, _t128 * _t62) + (Math.fma(_t1, _t51, _t139) + Math.fma(_self01, _t61, _t100 - _t160 * _t163 * _t158_inv))) * _t166_inv;
        return rayOrigin;
    }

    public static float[] unprojectRay_zo(float[] rayOrigin, int rayOriginOffset, float[] rayDir, int rayDirOffset, float[] src, int srcOffset, float[] winCoords, int winCoordsOffset, float[] viewport, int viewportOffset) {
        float _self00 = src[srcOffset + 0];
        float _self10 = src[srcOffset + 1];
        float _self20 = src[srcOffset + 2];
        float _self30 = src[srcOffset + 3];
        float _self01 = src[srcOffset + 4];
        float _self11 = src[srcOffset + 5];
        float _self21 = src[srcOffset + 6];
        float _self31 = src[srcOffset + 7];
        float _self02 = src[srcOffset + 8];
        float _self12 = src[srcOffset + 9];
        float _self22 = src[srcOffset + 10];
        float _self32 = src[srcOffset + 11];
        float _self03 = src[srcOffset + 12];
        float _self13 = src[srcOffset + 13];
        float _self23 = src[srcOffset + 14];
        float _self33 = src[srcOffset + 15];
        float _winCoordsx = winCoords[winCoordsOffset + 0];
        float _winCoordsy = winCoords[winCoordsOffset + 1];
        float _viewportx = viewport[viewportOffset + 0];
        float _viewporty = viewport[viewportOffset + 1];
        float _viewportz = viewport[viewportOffset + 2];
        float _viewportw = viewport[viewportOffset + 3];
        float _t0 = -_self00;
        float _t43 = Math.fma(_self21, _self32, -(_self22 * _self31));
        float _t44 = Math.fma(_self22, _self33, -(_self23 * _self32));
        float _t45 = Math.fma(_self21, _self33, -(_self23 * _self31));
        float _t46 = Math.fma(_self11, _self22, -(_self12 * _self21));
        float _t47 = Math.fma(_self12, _self23, -(_self13 * _self22));
        float _t48 = Math.fma(_self11, _self23, -(_self13 * _self21));
        float _t49 = Math.fma(_self10, _self21, -(_self11 * _self20));
        float _t50 = Math.fma(_self10, _self22, -(_self12 * _self20));
        float _t51 = Math.fma(_self20, _self31, -(_self21 * _self30));
        float _t52 = Math.fma(_self20, _self32, -(_self22 * _self30));
        float _t53 = Math.fma(_self10, _self23, -(_self13 * _self20));
        float _t54 = Math.fma(_self20, _self33, -(_self23 * _self30));
        float _t55 = Math.fma(_self12, _self33, -(_self13 * _self32));
        float _t56 = Math.fma(_self11, _self33, -(_self13 * _self31));
        float _t57 = Math.fma(_self11, _self32, -(_self12 * _self31));
        float _t58 = Math.fma(_self10, _self32, -(_self12 * _self30));
        float _t59 = Math.fma(_self10, _self31, -(_self11 * _self30));
        float _t60 = Math.fma(_self10, _self33, -(_self13 * _self30));
        float _t61 = 2.0f * (_winCoordsx - _viewportx) / _viewportz - 1.0f;
        float _t62 = 2.0f * (_winCoordsy - _viewporty) / _viewportw - 1.0f;
        float _t92 = Math.fma(_self00, _t46, -(_self01 * _t50));
        float _t95 = Math.fma(_self00, _t47, -(_self02 * _t53));
        float _t102 = Math.fma(_self13, _t43, Math.fma(_self11, _t44, -(_self12 * _t45)));
        float _t106 = Math.fma(_self02, _t51, Math.fma(_self00, _t43, -(_self01 * _t52)));
        float _t109 = Math.fma(_self03, _t52, Math.fma(_self00, _t44, -(_self02 * _t54)));
        float _t111 = Math.fma(_self13, _t51, Math.fma(_self10, _t45, -(_self11 * _t54)));
        float _t119 = -(Math.fma(_self03, _t43, Math.fma(_self01, _t44, -(_self02 * _t45))) * _t62);
        float _t120 = -(Math.fma(_self12, _t51, Math.fma(_self10, _t43, -(_self11 * _t52))) * _t61);
        float _t121 = -(Math.fma(_self13, _t52, Math.fma(_self10, _t44, -(_self12 * _t54))) * _t61);
        float _t122 = -(Math.fma(_self03, _t51, Math.fma(_self00, _t45, -(_self01 * _t54))) * _t62);
        float _t131 = Math.fma(_t102, _t61, _t119) - Math.fma(_self03, _t46, Math.fma(_self01, _t47, -(_self02 * _t48)));
        float _t132 = Math.fma(_self02, _t49, _t92) + Math.fma(_t106, _t62, _t120);
        float _t132_inv = 1.0f / _t132;
        float _t133 = Math.fma(_self03, _t50, _t95) + Math.fma(_t109, _t62, _t121);
        float _t134 = Math.fma(_t111, _t61, _t122) - Math.fma(_self03, _t49, Math.fma(_self00, _t48, -(_self01 * _t53)));
        float _t137 = _t92 + Math.fma(_self02, _t49, _t106 * _t62) + (Math.fma(_t0, _t57, _t120) + Math.fma(_self01, _t58, -(_self02 * _t59)));
        float _t139 = Math.abs(_t137) <= Math.abs(_t132) * 9.536743E-7f ? _t132 : _t137;
        float _t139_inv = 1.0f / _t139;
        rayOrigin[rayOriginOffset + 0] = _t131 * _t132_inv;
        rayOrigin[rayOriginOffset + 1] = _t133 * _t132_inv;
        rayOrigin[rayOriginOffset + 2] = _t134 * _t132_inv;
        rayDir[rayDirOffset + 0] = (Math.fma(_self01, _t55, -(_self02 * _t56)) + Math.fma(_self03, _t57, _t102 * _t61) + (Math.fma(-_self01, _t47, _t119) + Math.fma(_self02, _t48, -(_self03 * _t46) - _t137 * _t131 * _t132_inv))) * _t139_inv;
        rayDir[rayDirOffset + 1] = (_t95 + Math.fma(_self03, _t50, _t109 * _t62) + (Math.fma(_t0, _t55, _t121) + Math.fma(_self02, _t60, -(_self03 * _t58) - _t137 * _t133 * _t132_inv))) * _t139_inv;
        rayDir[rayDirOffset + 2] = (Math.fma(_self00, _t56, -(_self01 * _t60)) + Math.fma(_self03, _t59, _t111 * _t61) + (Math.fma(_t0, _t48, _t122) + Math.fma(_self01, _t53, -(_self03 * _t49) - _t137 * _t134 * _t132_inv))) * _t139_inv;
        return rayOrigin;
    }

}
