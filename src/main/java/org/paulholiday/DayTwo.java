package org.paulholiday;

import org.apache.commons.lang3.StringUtils;

public class DayTwo {

    boolean validatePasswordWithNumberOfLetterOccurrences(PasswordPolicy policy) {

        int numberOfLetterOccurrences = StringUtils.countMatches(policy.getPassword(), policy.getLetter());

        return withinMinimumNumberOfOccurrences(policy.getPolicyDigit1(), numberOfLetterOccurrences)
                && withinMaximumNumberOfOccurrences(policy.getPolicyDigit2(), numberOfLetterOccurrences);
    }

    boolean withinMinimumNumberOfOccurrences(int minimumNumberOfOccurrences, int numberOfLetterOccurrences) {
        return numberOfLetterOccurrences >= minimumNumberOfOccurrences;
    }

    boolean withinMaximumNumberOfOccurrences(int maximumNumberOfOccurrences, int numberOfLetterOccurrences) {
        return numberOfLetterOccurrences <= maximumNumberOfOccurrences;
    }

    boolean validatePasswordWithOneCorrectLetterPosition(PasswordPolicy policy) {
        char letter = policy.getLetter();
        String password = policy.getPassword();
        int position1 = policy.getPolicyDigit1();
        int position2 = policy.getPolicyDigit2();

        if (letter == password.charAt(position1 - 1)) {
            if (policy.getPassword().length() >= position2) {
                return letter != password.charAt(position2 - 1);
            }
            return true;
        }

        if (letter != password.charAt(position1 - 1)) {
            if (policy.getPassword().length() >= position2) {
                return letter == password.charAt(position2 - 1);
            }
        }

        return false;
    }
}
