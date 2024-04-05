import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class Student implements Comparable<Student>{

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name); // thu tu tang dan
    }

    String name;

    public Student(String name) {
        this.name = name;
        List<Student> students = new ArrayList<>();
        Collections.sort(students);
        Collections.sort(students,(o1, o2) -> -1);

    }
}
