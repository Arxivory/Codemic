package com.project.codemic.Codemic.model.entity;

import com.project.codemic.Codemic.model.enums.TimeComplexity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "submissions")
public class Submission implements Serializable {

    @Serial
    private static final long serialVersionUID = -1669912362468399435L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false)
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "time_complexity", nullable = false)
    private TimeComplexity timeComplexity;

    @Column(name = "grade", nullable = false)
    private double grade;

    @Column(name = "datetime", nullable = false)
    private LocalDateTime datetime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;

    @PrePersist
    protected void onCreate() {
        this.datetime = LocalDateTime.now();
    }
}
