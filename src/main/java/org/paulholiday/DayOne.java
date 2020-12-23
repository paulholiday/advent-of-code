package org.paulholiday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DayOne {

    List<Integer> convertToIntegerList(List<String> stringList) {
        List<Integer> integers = new ArrayList<>();

        for (String string : stringList) {
            integers.add(Integer.parseInt(string));
        }

        return integers;
    }

    List<Integer> getTwoEntriesThatSumTo2020(List<Integer> inputList) {

        for (Integer iterator : inputList) {
            for (Integer secondIterator : inputList) {
                if (!iterator.equals(secondIterator)) {
                    if ((iterator + secondIterator) == 2020) {
                        System.out.println(iterator + " and " + secondIterator + " sum to 2020");
                        return Arrays.asList(iterator, secondIterator);
                    }
                }
            }
        }

        System.out.println("None of the entries sum together to make 2020");
        return Collections.emptyList();
    }

    List<Integer> getThreeEntriesThatSumTo2020(List<Integer> inputList) {

        for (Integer iterator : inputList) {
            for (Integer secondIterator : inputList) {
                for (Integer thirdIterator : inputList) {
                    if (!iterator.equals(secondIterator) && !iterator.equals(thirdIterator) && !secondIterator.equals(thirdIterator)) {
                        if ((iterator + secondIterator + thirdIterator) == 2020) {
                            System.out.println(iterator + " and " + secondIterator + " and " + thirdIterator + " sum to 2020");
                            return Arrays.asList(iterator, secondIterator, thirdIterator);
                        }
                    }
                }
            }
        }

        System.out.println("None of the entries sum together to make 2020");
        return Collections.emptyList();
    }

    Integer multiplyTwoAnswers(Integer answer1, Integer answer2) {
        return answer1 * answer2;
    }

    Integer multiplyThreeAnswers(Integer answer1, Integer answer2, Integer answer3) {
        return answer1 * answer2 * answer3;
    }
}
