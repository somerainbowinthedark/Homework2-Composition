class Department{

/* The basic feature of a department */
private String deptName;
private int numMajors;
private Professor[] faculty; 
private Professor[] chair;
private Course[] courses;

/* Construct a department object (at least TWO constructors) */
public Department(String deptName, int numMajors ) {
    this.deptName = deptName;
    this.numMajors = numMajors;
    this.chair = new Professor[1];
    this.faculty = new Professor[10];
    this.courses = new Course[6];
}
public Department(Department department) {
    if(department == null) {
        System.out.println("this department does not exist");
        System.exit(0);
    }
    this.deptName = department.deptName;
    this.numMajors = department.numMajors;
    this.chair = department.chair;
    this.faculty = department.faculty;
    this.courses = department.courses;
}
/* Accessors and mutators (one pair per each feature) */

public String getDeptName() {
    return deptName;
}

public void setDeptName(String deptName) {
    this.deptName = deptName;
}

public int getNumMajors() {
    return numMajors;
}

public void setNumMajors(int numMajors) {
    this.numMajors = numMajors;
}

public void setCourses(Course[] listCourses) {
    this.courses = new Course[listCourses.length];
    for (int i = 0; i < listCourses.length; i++) {
        this.courses[i] = listCourses[i];
    }
}
public Course[] getCourses() {
    Course[] temp = new Course[this.courses.length];
    for(int i = 0; i < this.courses.length; i++) {
        temp[i] = this.courses[i];
    }
    return temp;
}
public void setFaculty(Professor[] faculty) {
    this.faculty = new Professor[faculty.length];
    for (int i = 0; i < faculty.length; i++) {
        this.faculty[i] = faculty[i];
    }
}
public Professor[] getFaculty() {
    Professor[] temp = new Professor[this.faculty.length];
    for(int i = 0; i < this.faculty.length; i++) {
        temp[i] = this.faculty[i];
    }
    return temp;
}
public void setChair(Professor[] chair) {
    this.chair = new Professor[chair.length];
    for (int i = 0; i < chair.length; i++) {
        this.chair[i] = chair[i];
    }
}
public Professor[] getChair() {
    Professor[] temp = new Professor[this.chair.length];
    for(int i = 0; i < this.chair.length; i++) {
        temp[i] = this.chair[i];
    }
    return temp;
}
/* toString method */
@Override
public String toString() {
   String s = "";
   s += "Department: " + deptName + ", Number of Majors: " + numMajors;
   s += "\nTeachers:"; 
   for (int i = 0; i < this.faculty.length; i++) {
       if (this.faculty[i] != null) {
           s += "\n - " + this.faculty[i].toString();
       }
   }
   s += "\nCourses:"; 
   for (int i = 0; i < this.courses.length; i++) {
       if (this.courses[i] != null) {
           s += "\n - " + this.courses[i].toString();
       }
   }
   return s;
}

public static void main(String args[]) {
    Department dept = new Department("Engineering and Computer Science", 3);
    Department dept2 = new Department("Humanities", 2);
    Professor professor1 = new Professor("Dr. Yoshikazu Saito", 50, "234-56-7890", true, "123-456", 75000, 15, "Mechanical Engineering", "Associate Professor", "Computer Architecture");
    Professor professor2 = new Professor("Dr. Wenjia Li", 45, "345-67-8901", true, "234-567", 70000, 12, "Computer Science", "Assistant Professor", "Cybersecurity");
    Professor professor3 = new Professor("Dr. Elaine Brown", 55, "456-78-9012", true, "345-678", 80000, 20, "Technical Communication", "Associate Professor", "Technical Writing");
    professor1.setTenured(true);
    professor3.setTenured(true);
    professor2.setTenured(true);
    Course course1 = new Course("Programming 185", professor2);
    Course course2 = new Course("English 101", professor3);
    course1.setStudents(new CollegeStudent[]{new CollegeStudent("Jaylynn Vargas", true, 20, "123-45-6789", "S1001", 3.5, "Computer Science", "Sophomore"),
            new CollegeStudent("Bethany Mayers", true, 19, "987-65-4321", "S1002", 3.8, "Engineering", "Sophmore")});
    course2.setStudents(new CollegeStudent[]{new CollegeStudent("John Doe", true, 18, "111-22-3333", "S1003", 3.2, "Liberal Arts", "Freshman"),
            new CollegeStudent("Jane Doe", true, 22, "444-55-6666", "S1004", 3.6, "Liberal Arts", "Senior")});
    dept.setFaculty(new Professor[]{professor1, professor2});
    dept2.setFaculty(new Professor[]{professor3});
    dept.setCourses(new Course[]{course1});
    dept2.setCourses(new Course[]{course2});
    dept.setChair(new Professor[]{professor1});
    dept2.setChair(new Professor[]{professor3});
        System.out.println(dept.toString());
    }
}

class Course {
    private String courseName;
    private Professor instructorName;
    private CollegeStudent[] students;
    
public Course( String courseName,  Professor instructorName ) {
    this.courseName = courseName;
    this.instructorName = instructorName;
    this.students = new CollegeStudent[10];
}

public Course(Course course) {
    if(course == null) {
        System.out.println("this course does not exist");
        System.exit(0);
    }
    this.courseName = course.courseName;
    this.instructorName = course.instructorName;
    this.students = course.students;
}
/* Accessors and mutators (one pair per each feature) */

public String getCourseName() {
    return courseName;
}

public void setCourseName(String courseName) {
    this.courseName = courseName;
}

public Professor getInstructorName() {
    return instructorName;
}
public void setInstructorName(Professor instructorName) {
    this.instructorName = instructorName;
}
public void setStudents(CollegeStudent[] students) {
    this.students = new CollegeStudent[students.length];
    for (int i = 0; i < students.length; i++) {
        this.students[i] = students[i];
    } 
}  
    public CollegeStudent[] getStudents() {
    CollegeStudent[] temp = new CollegeStudent[this.students.length];
    for(int i = 0; i < this.students.length; i++) {
        temp[i] = this.students[i];
    }
    return temp;

}


/* toString method */
@Override
public String toString() {
   String out = "";
   out += "Course info: " + courseName + ", Instructor: " + instructorName;
   out += "\nStudents enrolled:"; 
    for (int i = 0; i < this.students.length; i++) {
         if (this.students[i] != null) {
              out += "\n - " + this.students[i].toString();
         }
    }
   return out;
}
}



class Teacher extends Person{
   private String id;
   private int annual_salary;
   private int year_in_profession;

public Teacher(String name, int age, String SSN, boolean alive, String id, int annual_salary, int year_in_profession) {
       super(name, alive,age, SSN);
       this.id = id;
       this.annual_salary = annual_salary;
       this.year_in_profession = year_in_profession;
   }

   public void setID(String i1){
       this.id = i1;
   }
   public String getID(){
       return this.id;
   }
   public void setAnnual_salary(int s){
       this.annual_salary = s;
   }
   public double getAnnual_salary(){
       return this.annual_salary;
   }
   public void setYear_in_profession(int y){
       this.year_in_profession = y;
   }
   public int getYear_in_profession(){
       return this.year_in_profession;
   }

   
    @Override
   public String toString(){
       String s = super.toString();
       s += "\n Professor Information: \n\n";
       s += "ID: " + this.id + "\n";
       s += "Annual salary: " + this.annual_salary + "\n";
       s += "Years in profession: " + this.year_in_profession + "\n";
       return s;
   }
    public static void main(String[] args) {
        Teacher doe = new Teacher ("Mr. Doe", 56, "123-45-678", true, "123-456-7899", 5400, 5);
        System.out.print(doe.toString());
    }
}

class Professor extends Teacher{
    private String specialty;
    private String rank;
    private String research_area;
    private boolean tenured;

     public Professor(String name, int age, String SSN, boolean alive, String id, int annual_salary, int year_in_profession, String specialty, String rank, String research_area) {
        super(name, age, SSN, alive, id, annual_salary, year_in_profession);
        this.specialty = specialty;
        this.rank = rank;
        this.research_area = research_area;
        this.tenured = false;
    }
    public void setSpecialty(String s){
        this.specialty = s;
    }
    public String getSpecialty(){
        return this.specialty;
    }
    public void setRank(String r){
        this.rank = r;
    }
    public String getRank(){
        return this.rank;
    }
    public void setResearch_area(String ra){
        this.research_area = ra;
    }
    public String getResearch_area(){
        return this.research_area;
    }
    public void setTenured(boolean t){
        this.tenured = t;
    }
    public boolean getTenured(){
        return this.tenured;
    }

    @Override
    public String toString(){
        String s = super.toString();
        s += "Professor Rank: " + this.rank + "\n";
        s += "Professor Research Area: " + this.research_area + "\n";
        s += "Professor Tenured: " + this.tenured + "\n";
        return s;
    }
}

class Person {
    private String name;
    private boolean alive;
    private int age;
    private String SSN;

    // No-argument constructor
    public Person() {
        this.name = "";
        this.alive = true;
        this.age = 0;
        this.SSN = "";
    }

    // Fully loaded constructor
    public Person(String name, boolean alive, int age, String SSN) {
        this.name = name;
        this.alive = alive;
        this.age = age;
        this.SSN = SSN;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    @Override
    public String toString() {
        return "Name: " + name
                + ", Alive: " + alive
                + ", Age: " + age
                + ", SSN: " + SSN;
    }
}

class Student extends Person {
    private String stu_id;
    private double gpa;

    // No-argument constructor
    public Student() {
        super();
        this.stu_id = "";
        this.gpa = 0.0;
    }

    // Fully loaded constructor
    public Student(String name, boolean alive, int age, String SSN,
                   String stu_id, double gpa) {
        super(name, alive, age, SSN);
        this.stu_id = stu_id;
        this.gpa = gpa;
    }

    // Getters and setters
    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Student ID: " + stu_id
                + ", GPA: " + gpa;
    }
}

class CollegeStudent extends Student {
    private String major;
    private String grade;

    // No-argument constructor
    public CollegeStudent() {
        super();
        this.major = "";
        this.grade = "";
    }

    // Fully loaded constructor
    public CollegeStudent(String name, boolean alive, int age, String SSN,
                          String stu_id, double gpa,
                          String major, String grade) {
        super(name, alive, age, SSN, stu_id, gpa);
        this.major = major;
        this.grade = grade;
    }

    // Getters and setters
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Major: " + major
                + ", Grade: " + grade;
    }
    public static void main(String[] args) {
        Person person = new Person(
                "Alex Smith", true, 40, "111-22-3333");

        Student student = new Student(
                "Jordan Lee", true, 20, "222-33-4444",
                "S1001", 3.5);

        CollegeStudent collegeStudent = new CollegeStudent(
                "Taylor Brown", true, 21, "333-44-5555",
                "S1002", 3.8, "Computer Science", "Junior");

        System.out.println("Person Information:");
        System.out.println(person);

        System.out.println("\nStudent Information:");
        System.out.println(student);

        System.out.println("\nCollege Student Information:");
        System.out.println(collegeStudent);
    }
}


