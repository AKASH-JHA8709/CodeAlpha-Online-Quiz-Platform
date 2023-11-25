import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private List<String> options;
    private int correctOption;

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Quiz {
    private List<Question> questions;

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}

class QuizRunner {
    private Quiz quiz;
    private int score;

    public QuizRunner(Quiz quiz) {
        this.quiz = quiz;
        this.score = 0;
    }

    public void runQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < quiz.getQuestions().size(); i++) {
            Question currentQuestion = quiz.getQuestions().get(i);

            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestionText());
            List<String> options = currentQuestion.getOptions();

            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("Your answer: ");
            int userAnswer = scanner.nextInt();

            if (userAnswer == currentQuestion.getCorrectOption()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " +
                        currentQuestion.getOptions().get(currentQuestion.getCorrectOption() - 1) + "\n");
            }
        }

        System.out.println("Quiz completed! Your score: " + score + "/" + quiz.getQuestions().size());
    }
}

public class OQP1 {
    public static void main(String[] args) {
        // Create sample questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                List.of("Berlin", "Paris", "Madrid", "Rome"), 2));
        questions.add(new Question("Which planet is known as the Red Planet?",
                List.of("Earth", "Mars", "Venus", "Jupiter"), 2));
        questions.add(new Question("Who wrote 'Romeo and Juliet'?",
                List.of("William Shakespeare", "Charles Dickens", "Jane Austen", "Homer"), 1));

        // Create a quiz
        Quiz quiz = new Quiz(questions);

        // Run the quiz
        QuizRunner quizRunner = new QuizRunner(quiz);
        quizRunner.runQuiz();
    }
}

