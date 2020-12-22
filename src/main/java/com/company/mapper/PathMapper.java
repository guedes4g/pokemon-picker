package com.company.mapper;

import com.company.model.Direction;

import java.util.List;
import java.util.stream.Collectors;

public class PathMapper {
    public List<Direction> map(String path) {
        return path
                .chars()
                .mapToObj(c -> (char) c)
                .map(Direction::getDirection)
                .collect(Collectors.toList());
    }
}