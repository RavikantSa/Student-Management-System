package com.wewillrock.First_Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController // Telling the java app --> this class will contains API endpoint
//@RequestMapping("students")
public class StudentController {


    // Datatype
    HashMap<Integer , Student>   studentDb = new HashMap<>();

    // Add a Student
  @PostMapping( "/add_student")
    public  String addStudent(@RequestBody() Student student){
      //Add it to our DB
      int key = student.id;

      studentDb.put(key , student);
      return "Student added successfully";
  }

//    http://localhost:8076/add_student
//{
//    "name": "SHIV",
//        "course": "A",
//        "id": 1,
//        "age": 22
//}


// get student by id
  @GetMapping("get_student_by_id")
    public  Student getStudentById(@RequestParam("id") Integer id){

      return studentDb.get(id);
  }
//    http://localhost:8076/get_student_by_id?id=1

  // get by path
    @GetMapping("get_by_path/{id}")
    public Student getBypath(@PathVariable("id") Integer id){
      Student student = studentDb.get(id);
      return student;
    }
    //  http://localhost:8076/get_by_path/1


  // Get student y name
    //1ST
  @GetMapping("get_student_by_name")
  public  Student getStudentByName(@RequestParam("name") String searchName){
      for( Student s : studentDb.values()){
//         if(s.name == searchName){
//             return s;
//         }
          if(s.name.equals(searchName)){
              return s;
          }
      }
      return null;
  }

//    http://localhost:8076/get_student_by_name?name=Shiv

    //2ND
//  public  ResponseEntity<Student> getStudentByName(@RequestParam("name") String searchName){
//      for( Student s : studentDb.values()){
//
//          if(s.name.equals(searchName)){
//              return new ResponseEntity<>(s , HttpStatus.FOUND);
//          }
//      }
//      return new ResponseEntity<>(null , HttpStatus.NOT_FOUND);
//  }



    // UPDATE A STUDENT
    @PutMapping("/update_student")
    //1st
//    public Student updateStudent(@RequestBody()Student student){
//      // Get key
//        int key = student.id;
//        studentDb.put(key , student);
//        return  student;
//    }
////    http://localhost:8076/update_student

    //2nd
    public ResponseEntity<Student> updateStudent(@RequestBody()Student student){
        int key = student.id;
        studentDb.put(key , student);
        return  new ResponseEntity<>(student , HttpStatus.ACCEPTED);
    }



    // DELETE STUDENT
    // 1st

//    @DeleteMapping("delete_student")
//    public String deleteStudent(@RequestParam("id") Integer id){
//      studentDb.remove(id);
//      return "The student has been successfully removed";
//    }
    //  http://localhost:8076/delete_student?id=1


    @DeleteMapping("/delete_student")
    public ResponseEntity<String> deleteStudent(@RequestParam ("id") Integer id){
      studentDb.remove(id);
      return new ResponseEntity<>("The student has been removed"  , HttpStatus.OK);
    }
}
