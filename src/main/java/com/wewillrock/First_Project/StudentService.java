package com.wewillrock.First_Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Add @service
@Service
public class StudentService {

    // option 1 : we creat obj myself
//    StudentRepository onj = new StudentRepository();

    // optiom 2 :  By @autowired take care obj creation automatically , so we don't need to do this
    @Autowired // use to connect the different class by object
    StudentRepository studentRepository;   // Asume as its ibj is already created   {studentRepository} as obj name

    String addStudent(Student student){
        // this is the service layer
        String result = studentRepository.addStudentToDB(student);
        // repository layer got connect to service layer
        return  result;
    }

    Student getStudentById(Integer id) {
        // this will  further call the repository layer
        return studentRepository.getStudentFromDB(id);

        //other way
//        Student stu = studentRepository.getStudentFromDB(id);
//        return stu;
    }

    Student getStudentByName( String name){
        return  studentRepository.getStudentNameFromDB(name);
    }

    Student updateStudent( Student student){
        return  studentRepository.updateStudentFromDB(student);
    }
    String deleteStudent( Integer id){
        return  studentRepository.deleteStudentFromDB(id);
    }

}
