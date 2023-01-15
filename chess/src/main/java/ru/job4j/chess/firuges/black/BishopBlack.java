package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = dest.getX() - position.getX();
        Cell[] steps = new Cell[size];
        int deltaX = 1;
        int deltaY = -1;
        int x = position().getX() + deltaX;
        int y = position().getY() + deltaY;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(x, y);
            x = x + deltaX;
            y = y + deltaY;
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int first = source.getX() - dest.getX();
        int second = source.getY() - dest.getY();
        if (first < 0) {
            first = first * -1;
        }
        if (second < 0) {
            second = second * -1;
        }
        return (first) == (second);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }

}
