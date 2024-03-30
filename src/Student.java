import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    private int grade;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGrade() {
        return grade;
    }

    public Student(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
