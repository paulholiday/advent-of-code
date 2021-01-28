package org.paulholiday;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DaySix {

    int getNumberOfUniqueQuestionsAnswerYes(String answers) {
        return getSetOfUniqueAnswers(answers).size();
    }

    int getNumberOfUniqueQuestionsAnsweredYesFromInput(List<String> answersList) {
        return answersList.stream().mapToInt(this::getNumberOfUniqueQuestionsAnswerYes).sum();
    }

    Set<Character> getSetOfUniqueAnswers(String answers) {
        Set<Character> uniqueAnswers = new HashSet<>();

        for (int i = 0; i < answers.length(); i++) {
            char answer = answers.charAt(i);

            if (answer != ' ') {
                uniqueAnswers.add(answer);
            }
        }

        return uniqueAnswers;
    }

    int getCombinedNumberOfAnswersWhereEveryoneAnsweredYes(List<String> answersList) {
        return answersList.stream().mapToInt(this::getNumberOfAnswersWhereEveryoneAnsweredYes).sum();
    }

    int getNumberOfAnswersWhereEveryoneAnsweredYes(String answers) {

        Set<Character> uniqueAnswers = getSetOfUniqueAnswers(answers);
        int numberOfMultipleAnswers = 0;

        String[] answersArray = answers.split(" ");

        if (answersArray.length > 1) {

            for (char uniqueAnswer : uniqueAnswers) {
                int count = StringUtils.countMatches(answers, uniqueAnswer);

                if (count > 1 && count == answersArray.length) {
                    numberOfMultipleAnswers++;
                }
            }

        }
        else {
            numberOfMultipleAnswers += answersArray[0].length();
        }

        return numberOfMultipleAnswers;
    }
}
