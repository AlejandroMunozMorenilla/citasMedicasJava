package com.formacion.citasMedicasJava.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CitaDTO implements Serializable {
    private Long id;
    private LocalDate fechaHora;
    private String motivoCita;
    private int attribute11;

    private PacienteDTO paciente;
    private PacienteDTO medico;
    private PacienteDTO diagnostico;
}
