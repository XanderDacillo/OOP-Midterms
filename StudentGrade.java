import java.util.Scanner;
class StudentGrade {

    Scanner sc = new Scanner(System.in);
    
    private int[][] grades;
    private String[] subjectsName;
    private String[] studentNames;

    private int numSubjects;

    //Constructor
    public StudentGrade(int numStudents, int numSubjects){
        this.numSubjects = numSubjects;
        
        grades = new int[numStudents][numSubjects];
        subjectsName = new String[numSubjects];
        studentNames = new String[numStudents];
    }

    public void enterSubjectNames(){
        for (int i = 0; i < numSubjects; i++ ){
            System.out.println("Subject " + (i + 1) + ": ");
            subjectsName[i] = sc.nextLine();
        }
    }

    public void enterStudentInfo(int studentIndex) {
        System.out.print("Enter student " + (studentIndex + 1) + " name: ");
        studentNames[studentIndex] = sc.nextLine();

        for (int j = 0; j < numSubjects; j++) {
            System.out.print("Grade for " + subjectsName[j] + ": ");
            int grade = sc.nextInt();
            setGrades(studentIndex, j, grade);
        }
        sc.nextLine();
    }

    public void setGrades(int studentIndex, int subjectIndex, int grade) {
        if (grade >= 0 && grade <= 100) {
            grades[studentIndex][subjectIndex] = grade;
        } else {
            System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
        }
    }

    public void displayGrades() {
        for (int i = 0; i < grades.length; i++) {
            System.out.println(studentNames[i] + "'s grades:");
            for (int j = 0; j < grades[i].length; j++) {
                System.out.println(subjectsName[j] + ": " + grades[i][j]);
            }
            System.out.println("Average "+ calculateAverage(grades[i]));
            System.out.println();
        }
    }

    public double calculateAverage(int[] studentGrades){
        int sum = 0;
        for (int grade : studentGrades){
            sum += grade;   
        }
        return (double) sum / numSubjects;
    }
}




