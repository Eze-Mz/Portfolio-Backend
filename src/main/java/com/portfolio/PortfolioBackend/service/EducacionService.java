package com.portfolio.PortfolioBackend.service;

import com.portfolio.PortfolioBackend.dto.EducacionDTO;
import com.portfolio.PortfolioBackend.exceptions.ResourceNotFoundException;
import com.portfolio.PortfolioBackend.model.Educacion;
import com.portfolio.PortfolioBackend.security.entities.Usuario;
import com.portfolio.PortfolioBackend.security.repositories.UsuarioRepository;
import com.portfolio.PortfolioBackend.repository.EducacionRepository;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService {

    @Autowired
    EducacionRepository eduRepo;
    @Autowired
    UsuarioRepository userRepo;

    private EducacionDTO mapearDTO(Educacion edu) {
        EducacionDTO eduDTO = new EducacionDTO();
        eduDTO.setId_ed(edu.getId_ed());
        eduDTO.setTitulo(edu.getTitulo());
        eduDTO.setInstitucion(edu.getInstitucion());
        eduDTO.setImg_inst(edu.getImg_inst());
        eduDTO.setFechas(edu.getFechas());
        eduDTO.setDescripcion(edu.getDescripcion());
        return eduDTO;
    }

    private Educacion mapearEntidad(EducacionDTO eduDto) {
        Educacion edu = new Educacion();
        edu.setId_ed(eduDto.getId_ed());
        edu.setTitulo(eduDto.getTitulo());
        edu.setInstitucion(eduDto.getInstitucion());
        edu.setImg_inst(eduDto.getImg_inst());
        edu.setFechas(eduDto.getFechas());
        edu.setDescripcion(eduDto.getDescripcion());

        return edu;
    }

    @Override
    public EducacionDTO crearEducacion(EducacionDTO eduDto, Long user_id) {
        Educacion edu = mapearEntidad(eduDto);
        Usuario user = userRepo.findById(user_id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", user_id));
        edu.setUsuario(user);
        // ? save retorna la fila después de guardar la info no?
        Educacion newEdu = eduRepo.save(edu);
        return mapearDTO(newEdu);
    }

    @Override
    public void borrarEducacion(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public List<EducacionDTO> obtenerEducacionPorUsuarioId(Long userId) {
        List<Educacion> educacion = eduRepo.findByUsuarioId(userId);
        // List<Experiencia> experiencias = expRepo.findByUsuarioId(userId);
        return educacion.stream().map(exp -> mapearDTO(exp)).collect(Collectors.toList());
    }

    @Override
    public List<EducacionDTO> obtenerEducacionPorUsuarioEmail(String user_email) {
        List<Educacion> educacionList = eduRepo.findByUsuarioEmail(user_email);
        return educacionList.stream().map(exp -> mapearDTO(exp)).collect(Collectors.toList());
    }

    @Override
    public EducacionDTO actualizarEducacion(EducacionDTO eduDto, Long user_id, Long id) {
        /*
         * Educacion edu = eduRepo.findByUsuarioId(user_id).stream()
         * .filter(e -> Objects.equals(e.getId_ed(), id))
         * .findFirst()
         * .orElse(null);
         * 
         * edu.setTitulo(eduDto.getTitulo());
         * edu.setInstitucion(eduDto.getInstitucion());
         * edu.setImg_inst(eduDto.getImg_inst());
         * edu.setFechas(eduDto.getFechas());
         * edu.setDescripcion(eduDto.getDescripcion());
         */
        // ! comparar las dos formas de agregar el usuario, en un momento no me dejaba
        // ! actualizar porque puse la restricción de que el usuario no puede ser null
        Usuario user = userRepo.findById(user_id).get();
        Educacion educacion = mapearEntidad(eduDto);
        educacion.setUsuario(user);

        Educacion eduActualizada = eduRepo.save(educacion);

        return mapearDTO(eduActualizada);
    }

}
