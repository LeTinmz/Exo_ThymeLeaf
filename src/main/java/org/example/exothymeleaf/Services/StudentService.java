package org.example.exothymeleaf.Services;

import org.example.exothymeleaf.Model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@Service
public class StudentService {
    private final Map<UUID, Student> students;

    public StudentService() {
        students = new HashMap<>();
        Student contact = new Student(UUID.randomUUID(), "Toto","truc",20, "toto@toto.toto");
        Student contact2 = new Student(UUID.randomUUID(), "Tata","machin",20, "toto@toto.toto");
        Student contact3 = new Student(UUID.randomUUID(), "Titi","bidule",20, "toto@toto.toto");

        students.put(contact.getId(), contact);
        students.put(contact2.getId(), contact2);
        students.put(contact3.getId(), contact3);
    }

    public List<Student> getStudents() {
        return students.values().stream().toList();
    }

    public Student getStudent(UUID id) {
        return students.get(id);
    }

    public void addStudent(Student contact) {
        UUID id = UUID.randomUUID();
        contact.setId(id);
        students.put(id, contact);
    }

    public void updateStudent(Student contact) {
        students.put(contact.getId(), contact);
    }

    public void removeStudent(UUID id) {
        students.remove(id);
    }
}
