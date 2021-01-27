package org.paulholiday;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayFiveTest {

    private List<String> boardingPasses;
    private DayFive dayFive;

    @BeforeEach
    void setup() {

        Utils utils = new Utils();

        boardingPasses = utils.getFileContentsByLine("src/main/resources/DayFiveInput.txt");
        dayFive = new DayFive();
    }

    @Test
    void getColumn() {

        assertEquals(7, dayFive.getColumn(Arrays.asList('R', 'R', 'R')));
        assertEquals(0, dayFive.getColumn(Arrays.asList('L', 'L', 'L')));
        assertEquals(4, dayFive.getColumn(Arrays.asList('R', 'L', 'L')));

    }

    @Test
    void getRow() {

        assertEquals(70, dayFive.getRow(Arrays.asList('B', 'F', 'F', 'F', 'B', 'B', 'F')));
        assertEquals(14, dayFive.getRow(Arrays.asList('F', 'F', 'F', 'B', 'B', 'B', 'F')));
        assertEquals(102, dayFive.getRow(Arrays.asList('B', 'B', 'F', 'F', 'B', 'B', 'F')));
    }

    @Test
    void getSeatId() {

        assertEquals(567, dayFive.getSeatId("BFFFBBFRRR"));
        assertEquals(119, dayFive.getSeatId("FFFBBBFRRR"));
        assertEquals(820, dayFive.getSeatId("BBFFBBFRLL"));
    }

    @Test
    void highestSeatId() {

        System.out.println(dayFive.getHighestSeatId(boardingPasses));
    }

    @Test
    void getOrderedListOfSeatIds() {

        List<Integer> listOfSeatIds = dayFive.getOrderListOfSeatIds(boardingPasses);

        System.out.println(listOfSeatIds);
        assertEquals(13, listOfSeatIds.get(0));
        assertEquals(978, listOfSeatIds.get(listOfSeatIds.size()-1));
    }

    @Test
    void getMySeatId() {

        System.out.println(dayFive.getMySeatId(boardingPasses));
        assertEquals(727, dayFive.getMySeatId(boardingPasses));

    }
}
