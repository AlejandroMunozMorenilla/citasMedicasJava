package com.formacion.citasMedicasJava.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre",
            length = 25,
            nullable = false
    )
    private String nombre;
    @Column(name = "apellidos",
            length = 30,
            nullable = false
    )
    private String apellidos;
    @Column(name = "usuario", length = 25,
            nullable = false, unique = true
    )
    private String usuario;
    @Column(name = "clave",
            nullable = false
    )
    private String clave;
}