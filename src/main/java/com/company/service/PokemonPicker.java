package com.company.service;

import com.company.exception.IllegalDirectionInputException;
import com.company.mapper.PathMapper;
import com.company.model.Direction;
import com.company.model.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class PokemonPicker {
    PathMapper pathMapper;

    public PokemonPicker() {
        this.pathMapper = new PathMapper();
    }

    public int pickPokemons(String path) {
        path = path.toLowerCase();
        validatePath(path);
        List<Direction> directions = this.pathMapper.map(path);
        return getVisitedPoints(directions).size();
    }

    private void validatePath(String path) {
        String regexPattern = "[^" + Direction.getValidDirectionsString() + "]";
        Pattern pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(path).find()) {
            throw new IllegalDirectionInputException();
        }
    }

    private Set<Point> getVisitedPoints(List<Direction> directions) {
        Set<Point> visited = new HashSet<>();
        Point currentPosition = new Point(0,0);
        visited.add(currentPosition);
        for(Direction direction: directions) {
            currentPosition = currentPosition.translate(direction.getPoint());
            visited.add(currentPosition);
        }
        return visited;
    }
}
