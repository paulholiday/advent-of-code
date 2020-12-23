package org.paulholiday;

import lombok.Builder;
import lombok.Getter;

@Builder
public class PasswordPolicy {
    @Getter
    private int policyDigit1;
    @Getter
    private int policyDigit2;
    @Getter
    private char letter;
    @Getter
    private String password;
}
