package org.paulholiday;

import org.apache.commons.lang3.StringUtils;

public class DayTwo {

    boolean validatePassword(PasswordPolicy policy) {

        int numberOfLetterOccurrences = StringUtils.countMatches(policy.getPassword(), policy.getLetter());

        return withinMinimumNumberOfOccurrences(policy.getMinimumNumberOfOccurrences(), numberOfLetterOccurrences)
                && withinMaximumNumberOfOccurrences(policy.getMaximumNumberOfOccurrences(), numberOfLetterOccurrences);
    }

    boolean withinMinimumNumberOfOccurrences(int minimumNumberOfOccurrences, int numberOfLetterOccurrences) {
        return numberOfLetterOccurrences >= minimumNumberOfOccurrences;
    }

    boolean withinMaximumNumberOfOccurrences(int maximumNumberOfOccurrences, int numberOfLetterOccurrences) {
        return numberOfLetterOccurrences <= maximumNumberOfOccurrences;
    }
}
