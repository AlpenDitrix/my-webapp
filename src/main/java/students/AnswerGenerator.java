package students;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generates reply based on random selection from the initial list of replies
 *
 * @author Anna Khasanova
 */
public class AnswerGenerator {

    private static final List<String> answers = new ArrayList<String>() {
        {
            answers.add(Messages.getString("DefaultReplyGenerator.answer_chaotic_good"));
            answers.add(Messages.getString("DefaultReplyGenerator.answer_neutral_good"));
            answers.add(Messages.getString("DefaultReplyGenerator.answer_true_neutral"));
            answers.add(Messages.getString("DefaultReplyGenerator.answer_lawful_good"));
            answers.add(Messages.getString("DefaultReplyGenerator.answer_lawful_evil"));
            answers.add(Messages.getString("DefaultReplyGenerator.answer_chaotic_evil"));
        }
    };

    public static String printQuestion(final String question) {
        String questionOut = Messages.getString("App.can_u").concat(" ").concat(question);
        if (!questionOut.endsWith("?")) {
            questionOut += "?";
        }
        return questionOut;
    }

    public static String generateReply() {
        final Random random = new Random();
        final int selected = random.nextInt(answers.size());
        return answers.get(selected);
    }
}
