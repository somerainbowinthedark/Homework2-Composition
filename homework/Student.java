
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

