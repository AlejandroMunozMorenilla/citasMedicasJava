package com.formacion.citasMedicasJava.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDate;

@Entity
@Table(name = "CITA")
@Data
@NoArgsConstructor
public class Cita extends AbstractPersistable<Long> {
    private LocalDate fechaHora;
    private String motivoCita;
    private int attribute11;

    @ManyToOne
    private Paciente paciente;
    @ManyToOne
    private Medico medico;
    @ManyToOne
    private Diagnostico diagnostico;
}
