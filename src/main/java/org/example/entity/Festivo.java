package org.example.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

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


    // Constructor por defecto (necesario para Hibernate)
    public Festivo() {
    }

    // Constructor personalizado
    public Festivo(String nombre, int dia, int mes, int diasPascua, int idTipo) {
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.diasPascua = diasPascua;
        this.idTipo = idTipo;
    }


    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setDiasPascua(int diasPascua) {
        this.diasPascua = diasPascua;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getDiasPascua() {
        return diasPascua;
    }

    public int getIdTipo() {
        return idTipo;
    }


}
