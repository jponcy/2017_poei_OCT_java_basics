package com.tactfactory.generic;

public class MathValue <K extends Number> extends Number {
    private static final long serialVersionUID = 4617099566927855706L;

    private K value;

    public MathValue(K value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof MathValue && Math.equals(this, obj);
    }

    public MathValue<K> min(MathValue<K> a) {
        return Math.min(this, a);
    }
    public MathValue<K> max(MathValue<K> a) {
        return Math.max(this, a);
    }

    @Override
    public double doubleValue() {
        return this.value.doubleValue();
    }

    @Override
    public float floatValue() {
        return this.value.floatValue();
    }

    @Override
    public int intValue() {
        return this.value.intValue();
    }

    @Override
    public long longValue() {
        return this.value.longValue();
    }
}
