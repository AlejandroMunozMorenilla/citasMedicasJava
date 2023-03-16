package com.formacion.citasMedicasJava.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Component
public class CitaDTO {
    private Long id;
    private LocalDate fechaHora;
    private String motivoCita;
    private int attribute11;

    private PacienteDTO paciente;
    private PacienteDTO medico;
    private PacienteDTO diagnostico;
}
