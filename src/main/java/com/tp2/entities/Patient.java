package com.tp2.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id @GeneratedValue
    private Long id ;
    @NotNull
    @Size(min = 5 , max = 10)

    @NotBlank
    @Column(length = 20)
    private String nom ;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthDate ;
    private int score ;
    private boolean malade ;
}
