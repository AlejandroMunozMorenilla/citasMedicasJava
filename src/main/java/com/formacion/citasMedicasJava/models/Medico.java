package com.formacion.citasMedicasJava.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MEDICO")
@Data
public class Medico extends Usuario {
    @Column(name = "numColegiado", nullable = false, length = 11, unique = true)
    private String numColegiado;
    @ManyToMany
    @JoinTable(name = "medico_paciente",
            joinColumns = @JoinColumn(name = "medico_id"),
            inverseJoinColumns = @JoinColumn(name = "paciente_id"))
    private Set<Paciente> pacientes;

    public Medico() {
        super();
        pacientes = new HashSet<>();
    }
}
