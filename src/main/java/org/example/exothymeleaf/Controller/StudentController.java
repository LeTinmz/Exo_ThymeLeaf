package org.example.exothymeleaf.Controller;

import org.example.exothymeleaf.Model.Student;
import org.example.exothymeleaf.Services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;
@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/list")
    public String getContacts(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "studentList";
    }

    @GetMapping("/detail/{id}")
    public String getContactDetails(@PathVariable("id") UUID id, Model model) {
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "studentDetails";
    }

    @GetMapping("/add")
    public String addContact(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "studentForm";
    }

    @PostMapping("/add")
    public String addContact(Student student) {
        studentService.addStudent(student);
        return "redirect:/list";
    }

        @GetMapping("/search")
    public String showSearchForm() {
        return "studentSearch";
    }

    @PostMapping("/search")
    public String searchStudent(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                Model model) {
        Student student = studentService.getStudentByName(firstName, lastName);
        if (student != null) {
            model.addAttribute("student", student);
        } else {
            model.addAttribute("notFound", true);
        }
        return "studentSearch";
    }
}
