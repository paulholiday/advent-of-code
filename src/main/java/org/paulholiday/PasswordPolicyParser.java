package org.paulholiday;

public class PasswordPolicyParser {

    PasswordPolicy parse(String policy) {

        String[] splitOnSpace = policy.split("\\s");
        String[] minAndMax = splitOnSpace[0].split("-");

        int min = Integer.parseInt(minAndMax[0]);
        int max = Integer.parseInt(minAndMax[1]);

        char letter = splitOnSpace[1].charAt(0);

        String password = splitOnSpace[2];

        return PasswordPolicy.builder()
                .minimumNumberOfOccurrences(min)
                .maximumNumberOfOccurrences(max)
                .letter(letter)
                .password(password)
                .build();
    }
}
