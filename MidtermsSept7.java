import java.util.Scanner;

public class MidtermsSept7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numStudents = 0;
        int numSubjects = 0;
        boolean exit = false;

        GradingSystem studdGrade = new GradingSystem(numStudents, numSubjects);

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

                    studdGrade = new GradingSystem(numStudents, numSubjects);
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
                        System.out.println();
                    } else {
                        System.out.println("Please input grades first.");
                    }
                    break;
                case 3:
                System.out.println();
                    if (studdGrade != null) {
                        studdGrade.enterNewSubject();
                        System.out.println();
                    } else {
                        System.out.println("Please input grades first.");
                    }
                    break;
                case 4:
                System.out.println();
                /* 
                    if (studdGrade != null) {
                        System.out.println("****Grades Averages****");
                        studdGrade.displayGrades();

                    } else {
                        System.out.println("NO GRADES FOUND. Please input grades first.");
                    }
                    break;
                */
                    if (studdGrade != null) {
                        System.out.println("****Grades Averages and Subject Stats****");
                        studdGrade.displayGrades();
                        studdGrade.displayHILOGrades();
                    } else {
                        System.out.println("NO GRADES FOUND. Please input grades first.");
                    }
                    break;

                case 5:
                System.out.println();
                    if (studdGrade != null) {
                        System.out.println("****Ranking*****");        
                        System.out.println("***********************************************");
                        studdGrade.displayRanking(numStudents, numSubjects, null);
                        System.out.println();
                    } else {
                        System.out.println("NO GRADES FOUND. Please input grades first.");
                    }
                    break;
                case 6:
                    System.out.println();
                    if (studdGrade != null) {
                        studdGrade.searchForName(null, studdGrade.getStudentNames());
                    }
                    break;
                
                case 7:
                System.out.println();
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
