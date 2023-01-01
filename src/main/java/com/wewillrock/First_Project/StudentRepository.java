package com.wewillrock.First_Project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

// Add @Repository
@Repository
public class StudentRepository {

    HashMap<Integer , Student> studentDb = new HashMap<>();

    String addStudentToDB(Student student){
        int key = student.id;

        studentDb.put(key , student);
        return "Student added successfully";
    }
    Student getStudentFromDB(Integer id){
        return studentDb.getOrDefault(id, null);
        // other way
//        if( studentDb.containsKey(id)){
//            return studentDb.get(id);
//        }
//        else {
//            return null;
//        }

    }

    Student getStudentNameFromDB(String searchName){
        for( Student s : studentDb.values()){
            if(s.name.equals(searchName)){
                return s;
            }
        }
        return null;
    }

    Student updateStudentFromDB(Student student){
        int key = student.id;
        studentDb.put(key , student);
        return  student;
    }

    String deleteStudentFromDB( Integer student){
        studentDb.remove(student);
      return "The student has been successfully removed";
    }

}
