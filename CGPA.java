public class CGPA {

    public static void main(String[] args) {
        System.out.println("WELCOME TO MY CGPA CALCULATOR APPLICATION USING JAVA");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("KINDLY ENTER YOUR NAME :=>");
        String name = scanner.nextLine();
        System.out.println("KINDLY ENTER YOUR DEPARTMENT :=>");
        String className = scanner.nextLine();
        System.out.println("Enter the number of courses:");
        int numCourses = scanner.nextInt();
        double[] courseScores = new double[numCourses];
        for (int i = 0; i < numCourses; i++) {
            System.out.println("Enter score for Course " + (i + 1) + ":");
            courseScores[i] = scanner.nextDouble();
        }
        double cgpa = calculateCGPA(courseScores);
        System.out.println("Hello " + name + "!");
        System.out.println("Class: " + className);
        System.out.println("Your CGPA is: " + cgpa);
        scanner.close();
    }

    public static double calculateCGPA(double[] scores) {
        double totalGradePoints = 0;
        for (double score : scores) {
            totalGradePoints += convertToGradePoint(score);
        }
        double cgpa = totalGradePoints / scores.length;
        return cgpa;
    }

    public static double convertToGradePoint(double score) {
        if (score >= 70) {
            return 5.0;
        } else if (score >= 60) {
            return 4.0;
        } else if (score >= 50) {
            return 3.0;
        } else if (score >= 45) {
            return 2.0;
        } else if (score >= 40) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

}
