package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenPositionToException() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(Cell.C1).isEqualTo(bishopBlack.position());
    }

    @Test
    void whenToDest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure figure = bishopBlack.copy(Cell.A3);
        assertThat(figure.position()).isEqualTo(Cell.A3);
    }

    @Test
    void whenWayTo() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] figure = bishopBlack.way(Cell.G5);
        Cell[] exception = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(exception).isEqualTo(figure);
    }

}