package org.paulholiday;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DaySix {

    int getNumberOfUniqueQuestionsAnswerYes(String answers) {

        Set<Character> uniqueAnswers = new HashSet<>();

        for (int i = 0; i < answers.length(); i++) {
            char answer = answers.charAt(i);

            if (answer != ' ') {
                uniqueAnswers.add(answer);
            }
        }

        return uniqueAnswers.size();
    }

    int getNumberOfUniqueQuestionsAnsweredYesFromInput(List<String> answersList) {
        return answersList.stream().mapToInt(this::getNumberOfUniqueQuestionsAnswerYes).sum();
    }
}
