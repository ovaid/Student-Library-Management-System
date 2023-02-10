package com.example.Student_Library_Management_System.Services;


import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Student;
import com.example.Student_Library_Management_System.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public String createStudent(Student student){


        //card should be autogenerated when create student function is called.
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);//card status is being set.
        card.setStudentVariableName(student);//foreign key attribute.


        //lets go to the student
        student.setCard(card);

        //if there was a unidirectional mapping: we hve to save both of them
        //but we are super advance and are using bidirectional: child will automtically saved.

        studentRepository.save(student);
        //by cascading effect, child will always automatically saved.

        return "Student and Card added";
    }
}