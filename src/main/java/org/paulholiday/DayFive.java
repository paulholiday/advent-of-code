package org.paulholiday;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DayFive {

    int getHighestSeatId(List<String> boardingPasses) {
        return boardingPasses.stream().collect(Collectors.summarizingInt(this::getSeatId)).getMax();
    }

    int getSeatId(String seatLocation) {
        List<Character> column = new ArrayList<>();
        List<Character> row = new ArrayList<>();

        for (int i = 0; i < seatLocation.length(); i++) {
            if (i < 7) {
                row.add(seatLocation.charAt(i));
            }
            else {
                column.add(seatLocation.charAt(i));
            }
        }

        int columnNumber = getColumn(column);
        int rowNumber = getRow(row);

        return rowNumber * 8 + columnNumber;
    }

    int getColumn(List<Character> column) {
        return reduceColumn(column, 0, 0, 7);
    }

    int reduceColumn(List<Character> column, int columnPointer, int lowerBound, int upperBound) {
        if (column.get(columnPointer) == 'L') {
            if (columnPointer == 2) {
                return lowerBound;
            }
            return reduceColumn(column, columnPointer + 1, lowerBound, calculateUpperBound(lowerBound, upperBound));
        }
        else if (column.get(columnPointer) == 'R') {
            if (columnPointer == 2) {
                return upperBound;
            }
            return reduceColumn(column, columnPointer + 1, calculateLowerBound(lowerBound, upperBound), upperBound);
        }

        return -1;
    }

    int getRow(List<Character> row) {
        return reduceRow(row, 0, 0, 127);
    }

    int reduceRow(List<Character> row, int rowPointer, int lowerBound, int upperBound) {
        if (row.get(rowPointer) == 'F') {
            if (rowPointer == 6) {
                return lowerBound;
            }
            return reduceRow(row, rowPointer + 1, lowerBound, calculateUpperBound(lowerBound, upperBound));
        }
        else if (row.get(rowPointer) == 'B') {
            if (rowPointer == 6) {
                return upperBound;
            }
            return reduceRow(row, rowPointer + 1, calculateLowerBound(lowerBound, upperBound), upperBound);
        }

        return -1;
    }

    int calculateLowerBound(int lowerBound, int upperBound) {
        if (lowerBound == 0) {
            return Math.floorDiv(upperBound, 2) + 1;
        }
        int boundDifference = upperBound - lowerBound;

        return (lowerBound + Math.floorDiv(boundDifference, 2)) + 1;
    }

    int calculateUpperBound(int lowerBound, int upperBound) {
        if (lowerBound == 0) {
            return Math.floorDiv(upperBound + lowerBound, 2);
        }

        int boundDifference = upperBound - lowerBound;

        return (upperBound - Math.floorDiv(boundDifference, 2)) - 1;
    }

    List<Integer> getOrderListOfSeatIds(List<String> boardingPasses) {
        return boardingPasses.stream().sorted(Comparator.comparing(this::getSeatId)).map(this::getSeatId).collect(Collectors.toList());
    }

    int getMySeatId(List<String> boardingPasses) {

        List<Integer> seatIdList = getOrderListOfSeatIds(boardingPasses);
        int iterator = 13;

        for (Integer seatId : seatIdList) {
            if (iterator != seatId) {
                return seatId - 1;
            }
            iterator++;
        }

        return -1;
    }
}
