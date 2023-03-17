package com.formacion.citasMedicasJava.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PACIENTE")
@Data
public class Paciente extends Usuario {
    @Column(length = 11,
            nullable = false,
            unique = true)
    private String NSS;
    @Column(length = 25,
            nullable = false,
            unique = true)
    private String numTarjeta;
    @Column(length = 12)
    private String telefono;
    @Column(length = 50)
    private String direccion;
    @ManyToMany(mappedBy = "pacientes")
    private Set<Medico> medicos;

    public Paciente() {
        super();
        medicos = new HashSet<>();
    }
}
