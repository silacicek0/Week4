 
package week4;
import java.util.ArrayList;

public class Course {
    private String courseName;
    private int capacity;
    private ArrayList<Student> enrolledStudents;
    
    public Course(String courseName, int capacity){
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    
    public String getCourseName() {
        return courseName;
    }
 
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
 
    public int getCapacity() {
        return capacity;
    }
 
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
 
    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
 
    public void setEnrolledStudents(ArrayList<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
    
    
    public void displayCourseInfo(){
        System.out.println("Course Name : " + courseName);
        System.out.println("Capacity    : " + capacity);
        System.out.println("Enrolled    : " + enrolledStudents.size());
        System.out.println("Students    :");
        if(enrolledStudents.isEmpty()){
            System.out.println("  (no students registered)");
        }else{
            for(Student s : enrolledStudents){
                System.out.println("  - " + s.getName() + " (ID: " + s.getStudentID() + ")");
            }
        }
    }
}
