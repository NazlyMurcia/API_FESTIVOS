package org.example.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "festivo")
public class Festivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int dia;
    private int mes;
    private int diasPascua;
    private int idTipo;

    public String getNombre() {
        return nombre;
    }


}
