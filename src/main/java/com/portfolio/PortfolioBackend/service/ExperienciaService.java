package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.ExperienciaDTO;
import com.portfolio.PortfolioBackend.exceptions.ResourceNotFoundException;
import com.portfolio.PortfolioBackend.model.Experiencia;
import com.portfolio.PortfolioBackend.security.entities.Usuario;
import com.portfolio.PortfolioBackend.security.repositories.UsuarioRepository;
import com.portfolio.PortfolioBackend.repository.ExperienciaRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService {
    @Autowired
    ExperienciaRepository expRepo;
    @Autowired
    UsuarioRepository userRepo;

    private ExperienciaDTO mapearDTO(Experiencia exp) {
        ExperienciaDTO expDTO = new ExperienciaDTO();
        expDTO.setId_exp(exp.getId_exp());
        expDTO.setEmpresa(exp.getEmpresa());
        expDTO.setTarea(exp.getTarea());
        expDTO.setTiempo(exp.getTiempo());
        expDTO.setDescripcion(exp.getDescripcion());
        expDTO.setImg_empresa(exp.getImg_empresa());
        return expDTO;
    }

    private Experiencia mapearEntidad(ExperienciaDTO expDto) {
        Experiencia exp = new Experiencia();
        exp.setId_exp(expDto.getId_exp());
        exp.setEmpresa(expDto.getEmpresa());
        exp.setImg_empresa(expDto.getImg_empresa());
        exp.setTarea(expDto.getTarea());
        exp.setTiempo(expDto.getTiempo());
        exp.setDescripcion(expDto.getDescripcion());
        return exp;
    }

    @Override
    public ExperienciaDTO crearExperiencia(ExperienciaDTO expDto, Long user_id) {
        Experiencia exp = mapearEntidad(expDto);
        Usuario user = userRepo.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", user_id));
        exp.setUsuario(user);
        Experiencia newExp = expRepo.save(exp);
        return mapearDTO(newExp);
    }

    @Override
    public void borrarExperiencia(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public List<ExperienciaDTO> obtenerExperienciaPorUsuarioEmail(String user_email) {
        List<Experiencia> experiencias = expRepo.findByUsuarioEmail(user_email);
        return experiencias.stream().map(exp -> mapearDTO(exp)).collect(Collectors.toList());
    }

    @Override
    public ExperienciaDTO actualizarExperiencia(ExperienciaDTO expDto, Long user_id, Long exp_id) {
        Experiencia exp = expRepo.findByUsuarioId(user_id).stream()
                .filter(e -> Objects.equals(e.getId_exp(), exp_id))
                .findFirst()
                .orElse(null);

        exp.setTarea(expDto.getTarea());
        exp.setEmpresa(expDto.getEmpresa());
        exp.setImg_empresa(expDto.getImg_empresa());
        exp.setTiempo(expDto.getTiempo());
        exp.setDescripcion(expDto.getDescripcion());

        Experiencia expActualizada = expRepo.save(exp);

        return mapearDTO(expActualizada);

    }

}
