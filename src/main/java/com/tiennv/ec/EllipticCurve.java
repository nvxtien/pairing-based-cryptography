package com.tiennv.ec;

import java.math.BigInteger;

/**
 * An elliptic curve over a prime field is a set of points (x,y) on the curve defined by
 * the equation y^2 ≡ x^3 + ax + b (mod p), where x, y, a, and b are elements of GF(p) for some prime p ≠ 3.
 * The points (x,y) along with point at infinity O form an Abelian group
 * with point addition operator + if 4a^3+27b^2 ≠ 0.
 */
public final class EllipticCurve {

    private final BigInteger p;
    private final BigInteger a;
    private final BigInteger b;

    public EllipticCurve(final BigInteger p, final BigInteger a, final BigInteger b) {

        BigInteger delta = BigInteger.valueOf(4).multiply(a.pow(3)).add(BigInteger.valueOf(27).multiply(b.pow(2))).mod(p);
        assert delta.compareTo(BigInteger.ZERO) != 0  : "invalid elliptic curve";

        this.p = p;
        this.a = a;
        this.b = b;
    }

    public BigInteger getP() {
        return this.p;
    }

    public BigInteger getA() {
        return this.a;
    }

    public BigInteger getB() {
        return this.b;
    }

    @Override
    public String toString() {
        return "EllipticCurve{" +
                "p=" + p +
                ", a=" + a +
                ", b=" + b +
                '}';
    }
}
