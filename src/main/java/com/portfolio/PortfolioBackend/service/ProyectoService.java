package com.portfolio.PortfolioBackend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.PortfolioBackend.dto.ProyectoDTO;
import com.portfolio.PortfolioBackend.exceptions.ResourceNotFoundException;
import com.portfolio.PortfolioBackend.model.Proyecto;
import com.portfolio.PortfolioBackend.repository.ProyectoRepository;
import com.portfolio.PortfolioBackend.security.entities.Usuario;
import com.portfolio.PortfolioBackend.security.repositories.UsuarioRepository;

@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    ProyectoRepository proyectRepo;
    @Autowired
    UsuarioRepository userRepo;

    private ProyectoDTO mapearDTO(Proyecto proyecto) {
        ProyectoDTO proyectoDTO = new ProyectoDTO();
        proyectoDTO.setId_proyecto(proyecto.getId_proyecto());
        proyectoDTO.setNombre(proyecto.getNombre());
        proyectoDTO.setImg_proyecto(proyecto.getImg_proyecto());
        proyectoDTO.setDescripcion(proyecto.getDescripcion());
        proyectoDTO.setTecnologias(proyecto.getTecnologias());
        proyectoDTO.setLink_sitio(proyecto.getLink_sitio());
        proyectoDTO.setLink_repo(proyecto.getLink_repo());
        return proyectoDTO;
    }

    private Proyecto mapearEntidad(ProyectoDTO proyectoDTO) {
        Proyecto proyecto = new Proyecto();
        proyecto.setId_proyecto(proyectoDTO.getId_proyecto());
        proyecto.setNombre(proyectoDTO.getNombre());
        proyecto.setImg_proyecto(proyectoDTO.getImg_proyecto());
        proyecto.setDescripcion(proyectoDTO.getDescripcion());
        proyecto.setTecnologias(proyectoDTO.getTecnologias());
        proyecto.setLink_sitio(proyectoDTO.getLink_sitio());
        proyecto.setLink_repo(proyectoDTO.getLink_repo());
        return proyecto;
    }

    @Override
    public ProyectoDTO crearProyecto(ProyectoDTO proyectoDTO, Long user_id) {
        Proyecto proyecto = mapearEntidad(proyectoDTO);
        Usuario user = userRepo.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", user_id));
        proyecto.setUsuario(user);
        Proyecto newProyect = proyectRepo.save(proyecto);
        return mapearDTO(newProyect);
    }

    @Override
    public void borrarProyecto(Long id) {
        proyectRepo.deleteById(id);

    }

    @Override
    public List<ProyectoDTO> obtenerProyectoPorUsuarioEmail(String user_email) {
        List<Proyecto> proyectos = proyectRepo.findByUsuarioEmail(user_email);
        return proyectos.stream().map(proyecto -> mapearDTO(proyecto)).collect(Collectors.toList());
    }

    @Override
    public ProyectoDTO actualizarProyecto(ProyectoDTO proyectoDTO, Long user_id, Long exp_id) {
        Usuario user = userRepo.findById(user_id).get();
        Proyecto proyecto = mapearEntidad(proyectoDTO);
        proyecto.setUsuario(user);

        Proyecto proyectoActualizado = proyectRepo.save(proyecto);

        return mapearDTO(proyectoActualizado);
    }

}
