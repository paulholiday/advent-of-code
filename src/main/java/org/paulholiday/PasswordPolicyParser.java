package org.paulholiday;

public class PasswordPolicyParser {

    PasswordPolicy parse(String policy) {

        String[] splitOnSpace = policy.split("\\s");
        String[] minAndMax = splitOnSpace[0].split("-");

        int policyDigit1 = Integer.parseInt(minAndMax[0]);
        int policyDigit2 = Integer.parseInt(minAndMax[1]);

        char letter = splitOnSpace[1].charAt(0);

        String password = splitOnSpace[2];

        return PasswordPolicy.builder()
                .policyDigit1(policyDigit1)
                .policyDigit2(policyDigit2)
                .letter(letter)
                .password(password)
                .build();
    }
}
