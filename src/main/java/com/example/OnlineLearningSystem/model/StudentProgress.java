package com.example.OnlineLearningSystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StudentProgressId.class)
public class StudentProgress {
    @Id
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private User studentId;

    @Id
    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    private Lesson lessonId;

    @CreationTimestamp
    @CreatedDate
    @Temporal(TemporalType.DATE)
    private Date finishedDate;

}
