package week4;
import java.util.ArrayList;
import java.util.Scanner;

public class Week4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many courses would you like to create(at least 3): ");
        int courseNumber = scanner.nextInt();
        while(courseNumber < 3){
            System.out.println("Course number must be at least 3!");
            System.out.println("How many courses would you like to create(at least 3): ");
            courseNumber = scanner.nextInt();
        }
        System.out.println("");

        ArrayList<Course> courses = new ArrayList<>();
        for(int i = 1; i <= courseNumber; i++){
            System.out.println("-----Setting Up Course "+i+"-----");
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter the course name: ");
            String courseName = scanner1.nextLine();
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Enter the course capacity: ");
            int courseCapacity = scanner2.nextInt();

            Course course = new Course(courseName, courseCapacity);
            courses.add(course);
            System.out.println("");
        }

        System.out.println("------Courses------");
        for(int i = 1; i <= courseNumber; i++){
            System.out.println("- " + courses.get(i-1).getCourseName());
        }

        int option;
        do{
            System.out.println("------MENU------");
            System.out.println("1- Register a student");
            System.out.println("2- View all courses");
            System.out.println("3- Exit");
            System.out.println("Choose an option: ");
            option = scanner.nextInt();

            switch(option){
                case 1:
                    System.out.println("Enter the student ID: ");
                    Scanner scanner1 = new Scanner(System.in);
                    int studentID = scanner1.nextInt();
                    System.out.println("Enter the student name: ");
                    Scanner scanner2 = new Scanner(System.in);
                    String studentName = scanner2.nextLine();
                    System.out.println("Enter the course name: ");
                    Scanner scanner3 = new Scanner(System.in);
                    String courseName = scanner3.nextLine();

                    Course found = null;
                    for(int i = 1; i <= courseNumber; i++){
                        if(courses.get(i-1).getCourseName().equals(courseName)){
                            found = courses.get(i-1);
                        }
                    }

                    if(found == null){
                        System.out.println("No course found with that name.");
                    }
                    else if(found.getEnrolledStudents().size() >= found.getCapacity()){
                        System.out.println("This course is full. Registration failed.");
                    }
                    else{
                        boolean alreadyRegistered = false;
                        for(Student ss : found.getEnrolledStudents()){
                            if(ss.getStudentID() == studentID){
                                alreadyRegistered = true;
                            }
                        }
                        if(alreadyRegistered){
                            System.out.println("This student is already registered for this course.");
                        }
                        else{
                            Student student = new Student(studentID, studentName);
                            found.getEnrolledStudents().add(student);
                            System.out.println("Registration successful.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("------Courses------");
                    for(int i = 1; i <= courseNumber; i++){
                        courses.get(i-1).displayCourseInfo();
                        System.out.println("");
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
            }
        }while(option != 3);
    }

}