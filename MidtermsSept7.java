import java.util.Scanner;

public class MidtermsSept7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numStudents = 0;
        int numSubjects = 0;
        boolean exit = false;
        Student studdGrade = new Student(numStudents, numSubjects);

        while (!exit) {
            System.out.println("*******GRADING SYSTEM********");
            System.out.println("1 - Input Grades");
            System.out.println("2 - Update Grades");
            System.out.println("3 - Add new Subject");
            System.out.println("4 - Check Average");
            System.out.println("5 - Leaderboard");
            System.out.println("6 - Search student");
            System.out.println("7 - Exit");
            System.out.print("Enter: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of students: ");
                    numStudents = sc.nextInt();

                    System.out.print("Enter number of subjects: ");
                    numSubjects = sc.nextInt();
                    sc.nextLine();

                    studdGrade = new Student(numStudents, numSubjects);
                    studdGrade.enterSubjectNames();

                    for (int i = 0; i < numStudents; i++) {
                        System.out.println();
                        studdGrade.enterStudentInfo(i);
                    }
                    System.out.println("Grade inputted successfully!!");
                    System.out.println();
                    break;
                case 2:
                    if (studdGrade != null) {
                        int studentIndex = 0;
                        studdGrade.updateGrades(studentIndex);
                    } else {
                        System.out.println("Please input grades first.");
                    }
                    break;
                case 3:
                    if (studdGrade != null) {
                        studdGrade.enterNewSubject();
                    } else {
                        System.out.println("Please input grades first.");
                    }
                    break;
                case 4:
                    if (studdGrade != null) {
                        System.out.println("****Grades Averages****");
                        studdGrade.displayGrades();
                    } else {
                        System.out.println("NO GRADES FOUND. Please input grades first.");
                    }
                    break;
                case 5:
                    if (studdGrade != null) {
                        System.out.println("****Ranking*****");
                        studdGrade.displayRanking(numStudents, numSubjects, null);
                        System.out.println();
                    } else {
                        System.out.println("NO GRADES FOUND. Please input grades first.");
                    }
                    break;
                case 6:
                    studdGrade.searchForName(null, args);
                    break;
                case 7:
                    System.out.println("EXITING......");
                    exit = true;
                    break;
                default:
                    System.out.println("You have entered an invalid input, please try again.");
                    break;
            }
        }
        sc.close();
    }
}
