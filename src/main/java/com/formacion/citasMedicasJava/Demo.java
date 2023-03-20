package com.formacion.citasMedicasJava;

import com.formacion.citasMedicasJava.controllers.MedicoController;
import com.formacion.citasMedicasJava.controllers.PacienteController;
import com.formacion.citasMedicasJava.controllers.UsuarioController;
import com.formacion.citasMedicasJava.models.Cita;
import com.formacion.citasMedicasJava.models.Diagnostico;
import com.formacion.citasMedicasJava.models.Medico;
import com.formacion.citasMedicasJava.models.Paciente;
import com.formacion.citasMedicasJava.repositories.CitaRepository;
import com.formacion.citasMedicasJava.repositories.DiagnosticoRepository;
import com.formacion.citasMedicasJava.repositories.MedicoRepository;
import com.formacion.citasMedicasJava.repositories.PacienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Demo implements CommandLineRunner {
    private final UsuarioController usuarioController;
    private final MedicoController medicoController;
    private final PacienteController pacienteController;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;
    private final CitaRepository citaRepository;
    private final DiagnosticoRepository diagnosticoRepository;

    public Demo(UsuarioController usuarioController, MedicoController medicoController, PacienteController pacienteController,
                PacienteRepository pacienteRepository,
                MedicoRepository medicoRepository,
                CitaRepository citaRepository,
                DiagnosticoRepository diagnosticoRepository) {
        this.usuarioController = usuarioController;
        this.medicoController = medicoController;
        this.pacienteController = pacienteController;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
        this.citaRepository = citaRepository;
        this.diagnosticoRepository = diagnosticoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Medico medico = new Medico();
        medico.setUsuario("antonio");
        medico.setNombre("Antonio");
        medico.setApellidos("Perez");
        medico.setClave("123");
        medico.setNumColegiado("123");

        Paciente paciente = new Paciente();
        paciente.setUsuario("pepe");
        paciente.setNombre("Pepe");
        paciente.setApellidos("Martinez");
        paciente.setClave("123");
        paciente.setNSS("123");
        paciente.setTelefono("123");
        paciente.setNumTarjeta("123");
        paciente.setDireccion("asd");

        medico.getPacientes().add(paciente);
        pacienteRepository.save(paciente);
        medicoRepository.save(medico);

        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setEnfermedad("Resfriado común");
        diagnostico.setValoracionEspecialista("Ibuprofeno");
        diagnosticoRepository.save(diagnostico);

        Cita cita = new Cita();
        cita.setMotivoCita("Dolor de cabeza");
        cita.setFechaHora(LocalDate.now());
        cita.setAttribute11(1);
        cita.setMedico(medico);
        cita.setPaciente(paciente);
        cita.setDiagnostico(diagnostico);

        citaRepository.save(cita);

        Medico medico2 = medicoRepository.findById(2L).orElse(null);
        if (medico2 != null) {

        }
    }
}
