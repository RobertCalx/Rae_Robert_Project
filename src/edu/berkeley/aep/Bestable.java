package edu.berkeley.aep;

public interface Bestable<T extends Bestable> {
    boolean betterThan(T other);
}
