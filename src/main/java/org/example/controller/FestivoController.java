package org.example.controller;

import org.example.entity.Festivo;
import org.example.repository.FestivoRepository;
import org.example.service.FestivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/festivos")
public class FestivoController {

    @Autowired
    private FestivoRepository festivoRepository;


    @Autowired
    private FestivoService festivoService;

    @GetMapping("/verificar/{year}/{month}/{day}")
    public ResponseEntity<String> verificarFecha(
            @PathVariable String year,
            @PathVariable String month,
            @PathVariable String day) {
        try {
            // Convertir los parámetros a LocalDate
            String fechaStr = year + "-" + month + "-" + day;
            LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-M-d"));

            // Llamar al servicio para verificar si es festivo
            String resultado = festivoService.verificarFechaFestiva(fecha);

            return ResponseEntity.ok(resultado);

        } catch (DateTimeParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fecha no válida");
        }
    }


    @GetMapping("/listar/{year}")
    public ResponseEntity<List<Festivo>> listarFestivosPorAño(@PathVariable int year) {
        List<Festivo> festivos = festivoService.obtenerFestivosPorAño(year);
        return ResponseEntity.ok(festivos);
    }

}
