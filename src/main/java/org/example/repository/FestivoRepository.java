package org.example.repository;

import org.example.entity.Festivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FestivoRepository extends JpaRepository<Festivo, Long> {

    List<Festivo> findByDiaAndMes(int dia, int mes);

}
