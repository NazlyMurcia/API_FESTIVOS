package org.example.controller;

import org.example.entity.Festivo;
import org.example.repository.FestivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/festivos")
public class FestivoController {

    @Autowired
    private FestivoRepository festivoRepository;

    @GetMapping("/verificar/{year}/{month}/{day}")
    public ResponseEntity<String> verificarFecha(
            @PathVariable String year,
            @PathVariable String month,
            @PathVariable String day) {
        try {
            // Convertir los parámetros a LocalDate
            String fechaStr = year + "-" + month + "-" + day;
            LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-M-d"));

            // Buscar festivos en la base de datos
            List<Festivo> festivos = festivoRepository.findByDiaAndMes(fecha.getDayOfMonth(), fecha.getMonthValue());

            // Verificar si hay algún resultado
            if (!festivos.isEmpty()) {
                return ResponseEntity.ok("Es Festivo: " + festivos.get(0).getNombre());
            } else {
                return ResponseEntity.ok("No es Festivo");
            }
        } catch (DateTimeParseException e) {
            // Manejar fechas no válidas
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fecha no válida");
        }
    }
}
