package com.example.Student_Library_Management_System.Models;

import com.example.Student_Library_Management_System.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "card")
public class Card {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @CreationTimestamp//Auto timestamp when ever we make any entry
    private Date createOn;


    @UpdateTimestamp   //time is updated when ever entry is updated
    private Date updatedOn;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;


    @OneToOne
    @JoinColumn
    private Student studentVariableName;


    public Card(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Student getStudentVariableName() {
        return studentVariableName;
    }

    public void setStudentVariableName(Student studentVariableName) {
        this.studentVariableName = studentVariableName;
    }
}
