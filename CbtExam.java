import java.util.Scanner;

public class CbtExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("CBT EXAM");
        System.out.println("Number of students to write the exam:");
        int noOfStudent = scanner.nextInt();
        scanner.nextLine();

        String[] first_name = new String[noOfStudent];
        String[] last_name = new String[noOfStudent];
        String[] matricNo = new String[noOfStudent];

        createStudent(scanner, noOfStudent, first_name, last_name, matricNo);

        System.out.println("____ CBT EXAM ____");

        int[] answers = {1, 2, 3, 4, 1, 2, 3, 4, 1, 2};
        String[] questions = {"1 + 0", "1 + 1", "6 - 3", "8 - 4", "5 - 4", "2 * 1", "7 - 4", "2 + 2", "2 - 1", "8 / 4"};

        int[] scores = conductExam(scanner, noOfStudent, first_name, last_name, questions, answers);

        displayWinner(first_name, last_name, matricNo, scores);

        scanner.close();
    }

    public static void createStudent(Scanner scanner, int noOfStudent, String[] first_name, String[] last_name, String[] matricNo) {
        for (int i = 0; i < noOfStudent; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.println("Enter first name:");
            first_name[i] = scanner.nextLine();
            System.out.println("Enter last name:");
            last_name[i] = scanner.nextLine();
            System.out.println("Enter matriculation number:");
            matricNo[i] = scanner.nextLine();
        }
    }

    public static int[] conductExam(Scanner scanner, int noOfStudent, String[] first_name, String[] last_name, String[] questions, int[] answers) {
        int[] scores = new int[noOfStudent];

        for (int s = 0; s < noOfStudent; s++) {
            System.out.println("Student " + (s + 1) + ": " + first_name[s] + " " + last_name[s]);
            int score = 0;
            for (int q = 0; q < 10; q++) {
                System.out.println("Question " + (q + 1) + ": " + questions[q]);
                int studentAns = scanner.nextInt();
                if (studentAns == answers[q]) {
                    score++;
                }
            }
            scores[s] = score;
            System.out.println("Score: " + score + "/10\n");
        }

        return scores;
    }

    public static void displayWinner(String[] first_name, String[] last_name, String[] matricNo, int[] scores) {
        int highestScore = scores[0];
        int winnerIndex = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > highestScore) {
                highestScore = scores[i];
                winnerIndex = i;
            }
        }
        System.out.println("\n--- Winner ---");
        System.out.println("Congratulations to the winner:");
        System.out.println("Name: " + first_name[winnerIndex] + " " + last_name[winnerIndex]);
        System.out.println("Matriculation Number: " + matricNo[winnerIndex]);
        System.out.println("Score: " + highestScore);
    }
}
