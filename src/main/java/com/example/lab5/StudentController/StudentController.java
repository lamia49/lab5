package com.example.lab5.StudentController;

import com.example.lab5.ApiResponse.ApiResponse;
import com.example.lab5.Model.Students;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    ArrayList<Students> students = new ArrayList<>();

    @PostMapping("/add")
    public ApiResponse add(@RequestBody Students student) {
        students.add(student);
        return new ApiResponse("added");
    }

    @PutMapping("/updat/{index}")
    public ApiResponse updat(@PathVariable int index,@RequestBody Students student){
        students.set(index,student);
        return new ApiResponse("updated");
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable int id) {
        for (Students student:students){
            if(student.getId()==id)
                students.remove(student);
        }

        return new ApiResponse("student deleted");

    }


    @GetMapping("/{name}")
    public Students getname(@PathVariable String name) {
        for (Students student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    @GetMapping("/age/{id}")
    public int getage(@PathVariable int id) {
        for (Students student : students) {
            if (student.getId() == id) {
                return student.getAge();
            }
        }
        return 0;
    }


    @GetMapping("/college/dgree/{id}")
    public String getcollege(@PathVariable int id) {
        for (Students student : students) {
            if (student.getId() == id) {
                return student.getCollegeDgree();
            }
        }
        return "Not Found";
    }

    @GetMapping("/study/statue/{id}")

    public boolean getstatus(@PathVariable int id) {
        for (Students student : students) {
            if (student.getId() == id) {
                return student.isStatus();
            }
        }

        return false;
    }

@GetMapping("students")
    public ArrayList getStudets(){

        return students;
    }





}
