package com.example.demo.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "Weather")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int weatherId;
    private String temp;
    private String  description;
    private String cityName;


}
