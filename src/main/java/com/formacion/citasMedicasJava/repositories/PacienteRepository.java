package com.formacion.citasMedicasJava.repositories;

import com.formacion.citasMedicasJava.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    @Query("select p from Paciente p inner join p.medicos medicos where medicos.id = ?1")
    Set<Paciente> findAllByMedico_Id(Long id);
}
