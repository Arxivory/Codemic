package com.project.codemic.Codemic.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "testcases")
public class Testcase implements Serializable {

    @Serial
    private static final long serialVersionUID = -2137365102577942207L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "input", nullable = false)
    private String input;

    @Column(name = "output", nullable = false)
    private String output;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;
}
