package com.company.model;

import java.beans.Transient;
import java.util.Objects;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Transient
    public Point getLocation() {
        return new Point(this.x, this.y);
    }

    public Point translate(Point point) {
        Point p = this.getLocation();
        p.x += point.getX();
        p.y += point.getY();
        return p;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return super.equals(obj);
        } else {
            Point pt = (Point) obj;
            return this.x == pt.x && this.y == pt.y;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        String className = this.getClass().getName();
        return className + "[x=" + this.x + ",y=" + this.y + "]";
    }
}
