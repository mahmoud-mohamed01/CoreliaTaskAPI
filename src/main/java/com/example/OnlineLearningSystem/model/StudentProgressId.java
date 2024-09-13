package com.example.OnlineLearningSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProgressId  implements Serializable {

    private int studentId;
    private int lessonId;
}
