package com.company.model;


import com.company.exception.IllegalDirectionInputException;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Direction {
    NORTH(new Point(1,0), 'n'),
    SOUTH(new Point(-1,0), 's'),
    EAST(new Point(0, 1), 'e'),
    WEST(new Point(0, -1), 'o');

    private Point point;
    private Character charValue;

    Direction(Point point, char charValue) {
        this.point = point;
        this.charValue = charValue;
    }

    public Point getPoint() {
        return point;
    }

    public Character getCharValue() {
        return charValue;
    }

    public static String getValidDirectionsString() {
        return getValidDirectionsString("");
    }

    public static String getValidDirectionsString(String delimiter) {
        return Stream.of(Direction.values()).map(Direction::getCharValue).map(Object::toString).collect(Collectors.joining(delimiter));
    }

    public static Direction getDirection(Character character) {
        for(Direction direction: Direction.values()) {
            if(direction.getCharValue().equals(character)) {
                return direction;
            }
        }
        throw new IllegalDirectionInputException();
    }
}
