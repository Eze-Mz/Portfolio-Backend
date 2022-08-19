package com.portfolio.PortfolioBackend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.PortfolioBackend.dto.HabilidadDTO;
import com.portfolio.PortfolioBackend.exceptions.ResourceNotFoundException;
import com.portfolio.PortfolioBackend.model.Habilidad;
import com.portfolio.PortfolioBackend.repository.HabilidadRepository;
import com.portfolio.PortfolioBackend.security.entities.Usuario;
import com.portfolio.PortfolioBackend.security.repositories.UsuarioRepository;

@Service
public class HabilidadService implements IHabilidadService {

    @Autowired
    HabilidadRepository skillRepo;

    @Autowired
    UsuarioRepository userRepo;

    private HabilidadDTO mapearDTO(Habilidad skill) {
        HabilidadDTO skillDTO = new HabilidadDTO();
        skillDTO.setId_skill(skill.getId_skill());
        skillDTO.setHabilidad(skill.getHabilidad());
        skillDTO.setPorcentaje(skill.getPorcentaje());
        return skillDTO;
    }

    private Habilidad mapearEntidad(HabilidadDTO skillDTO) {
        Habilidad skill = new Habilidad();
        skill.setId_skill(skillDTO.getId_skill());
        skill.setHabilidad(skillDTO.getHabilidad());
        skill.setPorcentaje(skillDTO.getPorcentaje());
        return skill;
    }

    @Override
    public HabilidadDTO crearHabilidad(HabilidadDTO skillDto, Long user_id) {
        Habilidad skill = mapearEntidad(skillDto);
        Usuario user = userRepo.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", user_id));
        skill.setUsuario(user);
        Habilidad newSkill = skillRepo.save(skill);
        return mapearDTO(newSkill);
    }

    @Override
    public void borrarHabilidad(Long id) {
        skillRepo.deleteById(id);

    }

    @Override
    public List<HabilidadDTO> obtenerHabilidadPorUsuarioEmail(String user_email) {
        List<Habilidad> skills = skillRepo.findByUsuarioEmail(user_email);
        return skills.stream().map(skill -> mapearDTO(skill)).collect(Collectors.toList());
    }

    @Override
    public HabilidadDTO actualizarHabilidad(HabilidadDTO skillDto, Long user_id, Long id) {
        Usuario user = userRepo.findById(user_id).get();
        Habilidad skill = mapearEntidad(skillDto);
        skill.setUsuario(user);

        Habilidad skillActualizada = skillRepo.save(skill);

        return mapearDTO(skillActualizada);
    }

}
