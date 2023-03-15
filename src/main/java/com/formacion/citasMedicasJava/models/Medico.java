package com.formacion.citasMedicasJava.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MEDICO")
@Getter
@Setter
public class Medico extends Usuario {
    @Column(name = "numColegiado", nullable = false, length = 11, unique = true)
    private String numColegiado;
    @ManyToMany
    private Set<Paciente> pacientes;

    public Medico() {
        pacientes = new HashSet<>();
    }

}
