package org.paulholiday;

import lombok.Builder;
import lombok.Getter;

@Builder
public class PasswordPolicy {
    @Getter
    private int minimumNumberOfOccurrences;
    @Getter
    private int maximumNumberOfOccurrences;
    @Getter
    private char letter;
    @Getter
    private String password;
}
