import java.util.Random;
import java.util.Scanner;

public class Love {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name1 = scanner.nextLine();

        System.out.println("Enter your partner's name: ");
        String name2 = scanner.nextLine();

        int loveScore = calculateLoveScore(name1, name2);

        System.out.println("Love Score: " + loveScore);
        System.out.println(getLoveMessage(loveScore));

        scanner.close();
    }

    public static int calculateLoveScore(String name1, String name2) {
        String combinedNames = name1.toLowerCase() + name2.toLowerCase();
        int loveScore = 0;
        Random random = new Random(combinedNames.hashCode());

        for (int i = 0; i < combinedNames.length(); i++) {
            loveScore += random.nextInt(10);
        }

        return loveScore;
    }

    public static String getLoveMessage(int loveScore) {
        if (loveScore >= 90) {
            return "You are a perfect match!";
        } else if (loveScore >= 70) {
            return "You are meant for each other!";
        } else if (loveScore >= 50) {
            return "You have a good chance!";
        } else {
            return "It might not work out...";
        }
    }
}
