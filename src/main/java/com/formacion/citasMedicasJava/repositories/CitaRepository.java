package com.formacion.citasMedicasJava.repositories;

import com.formacion.citasMedicasJava.models.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    @Query("select c from Cita c where c.paciente.id = ?1")
    Set<Cita> findByPaciente_Id(Long id);

    @Query("select c from Cita c where c.medico.id = ?1")
    Set<Cita> findByMedico_Id(Long id);

}
