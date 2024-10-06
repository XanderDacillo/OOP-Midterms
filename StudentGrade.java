import java.util.Scanner;

class Student {

    Scanner sc = new Scanner(System.in);
    
    private int[][] grades;
    private String[] subjectsName;
    private String[] studentNames;
    private int numSubjects;

    //Constructor
    public Student(int numStudents, int numSubjects){
        this.numSubjects = numSubjects;
        this.studentNames = new String[numStudents];
        
        grades = new int[numStudents][numSubjects];
        subjectsName = new String[numSubjects];
        studentNames = new String[numStudents];
    }

    public void enterSubjectNames(){
        for (int i = 0; i < numSubjects; i++ ){
            System.out.println("Enter Subject " + (i+1)+": ");
            subjectsName[i] = sc.nextLine();
        }   
    }

    public void enterNewSubject() {
        System.out.println("Add new subject: ");
        String newSubject = sc.nextLine();
    
        String[] newSubjects = new String[numSubjects + 1];
        System.arraycopy(subjectsName, 0, newSubjects, 0, numSubjects);
        newSubjects[numSubjects] = newSubject;
        subjectsName = newSubjects;
    
        for (int i = 0; i < grades.length; i++) {
            int[] newGrades = new int[numSubjects + 1];
            System.arraycopy(grades[i], 0, newGrades, 0, numSubjects);
            grades[i] = newGrades;
        }
    
        numSubjects++;

            for (int i = 0; i < studentNames.length; i++) {
            System.out.print("Enter grade for " + studentNames[i] + " in " + newSubject + ": ");
            int grade = sc.nextInt();
            setGrades(i, numSubjects - 1, grade);
        }
        sc.nextLine();
    }

    public void enterStudentInfo(int studentIndex) {
        System.out.print("Enter student " + (studentIndex + 1) + " name: ");
        studentNames[studentIndex] = sc.nextLine().trim(); // Store the student name
    
        for (int j = 0; j < numSubjects; j++) {
            System.out.print("Grade for " + subjectsName[j] + ": ");
            int grade = sc.nextInt();
            setGrades(studentIndex, j, grade);
        }
        sc.nextLine(); // Consume newline
    }

    /* 
    public void searchForName(String studentName) {
        studentName = studentName.trim();
        boolean found = false; // Flag to track if the student is found
    
        System.out.println("Searching for: " + studentName); // Debug print
    
        for (String name : studentNames) {
            System.out.println("Checking against: " + name); // Debug print
            if (studentName.equalsIgnoreCase(name)) { // Case insensitive comparison
                System.out.println("Student found!");
                found = true; // Set the flag to true if the student is found
                break; // Exit the loop once the student is found
            }
        }
    
        if (!found) {
            System.out.println("Student does not exist.");
        }
    }
        */
    
        public void searchForName(String studentName, String[] studentNames) {
            boolean found = false; // Flag to track if the student is found
            System.out.print("Enter student name to search: ");
                        studentName = sc.nextLine(); // Read the student name
                        sc.next();

            System.out.println("Searching for: " + studentName); // Debug statement
        
            for (String name : studentNames) {
                System.out.println("Comparing with: " + name); // Debug statement
                if (studentName.equalsIgnoreCase(name.trim())) { // Case insensitive comparison
                    System.out.println("Student found!");
                    found = true; // Set the flag to true if the student is found
                    break; // Exit the loop once the student is found
                }
            }
        
            if (!found) {
                System.out.println("Student does not exist.");
            }
        }
        

    public String[] getStudentNames() {
        return studentNames;
    }
    
    
    
    public void updateGrades(int studentIndex){
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

    public void displayRanking (int studentIndex, int subjectIndex, int[][] grade){
        double[] averages = new double[grades.length];

    for (int i = 0; i < grades.length; i++) {
        averages[i] = calculateAverage(grades[i]);
    }

    for (int i = 0; i < averages.length; i++) {
        int highestIndex = 0;

        for (int j = 1; j < averages.length; j++) {
            if (averages[j] > averages[highestIndex]) {
                highestIndex = j;
            }
        }
        if (i == 0){
        System.out.println((i + 1) + "st: " + studentNames[highestIndex] + " =  (Average: " + averages[highestIndex] + ")");
        }
        else if (i == 1){
        System.out.println((i + 1) + "nd: " + studentNames[highestIndex] + " =  (Average: " + averages[highestIndex] + ")");
        }
        else if (i == 2){
        System.out.println((i + 1) + "rd: " + studentNames[highestIndex] + " =  (Average: " + averages[highestIndex] + ")");
        }
        else if (i > 2){
        System.out.println((i + 1) + "rd: " + studentNames[highestIndex] + " =  (Average: " + averages[highestIndex] + ")");
        }
        else if (i > 3 && i < 21){
        System.out.println((i + 1) + "th: " + studentNames[highestIndex] + " =  (Average: " + averages[highestIndex] + ")");
        }
        averages[highestIndex] = -1;
    }
    }
}
