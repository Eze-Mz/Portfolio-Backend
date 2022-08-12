package com.portfolio.PortfolioBackend.Controller;

import com.portfolio.PortfolioBackend.dto.EducacionDTO;
import com.portfolio.PortfolioBackend.dto.ExperienciaDTO;
import com.portfolio.PortfolioBackend.dto.GenericDTO;
import com.portfolio.PortfolioBackend.dto.HabilidadDTO;
import com.portfolio.PortfolioBackend.dto.PortfolioDTO;
import com.portfolio.PortfolioBackend.dto.ProyectoDTO;
import com.portfolio.PortfolioBackend.dto.UsuarioDTO;

import java.util.List;
import com.portfolio.PortfolioBackend.security.entities.Usuario;
import com.portfolio.PortfolioBackend.security.services.IUsuarioService;
import com.portfolio.PortfolioBackend.service.IEducacionService;
import com.portfolio.PortfolioBackend.service.IExperienciaService;
import com.portfolio.PortfolioBackend.service.IHabilidadService;
import com.portfolio.PortfolioBackend.service.IProyectoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Controller {
    private final static Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private IUsuarioService userService;
    @Autowired
    private IExperienciaService expService;
    @Autowired
    private IEducacionService eduService;
    @Autowired
    private IProyectoService proyectService;
    @Autowired
    private IHabilidadService skillService;

    // USER ENDPOINTS
    @PostMapping("/user")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario user) {
        return new ResponseEntity<>(userService.crearUsuario(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    public void borrarUsuario(@PathVariable Long id) {
        userService.borrarUsuario(id);
    }

    @GetMapping("user/list")
    public List<PortfolioDTO> buscarUsuarios() {
        return userService.buscarUsuarios();
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorEmail(@PathVariable String email) {
        Usuario usuario = userService.getByEmail(email).get();
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getId(), usuario.getNombre(), usuario.getEmail(),
                usuario.getImg_hero(), usuario.getImg_perfil(), usuario.getPuesto(), usuario.getSobre_mi(),
                usuario.getLink_1(), usuario.getLink_2());
        return new ResponseEntity<UsuarioDTO>(usuarioDTO, HttpStatus.OK);
    }

    @GetMapping("/user/exists/{email}")
    public ResponseEntity<Boolean> usuarioExistePorEmail(@PathVariable String email) {
        return new ResponseEntity<Boolean>(userService.existsByEmail(email), HttpStatus.OK);
    }

    // esta acción solo va a ser permitida si se trata de un usuario
    @PutMapping("/user/{id}")
    public ResponseEntity<?> actualizarDatosUsuario(@PathVariable("id") Long id, @RequestBody UsuarioDTO usuarioDTO) {
        if (!userService.existsById(id)) {
            return new ResponseEntity<>("el usuario no existe", HttpStatus.NOT_FOUND);
        }
        Usuario usuario = userService.buscarUsuario(id);
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setPuesto(usuarioDTO.getPuesto());
        usuario.setSobre_mi(usuarioDTO.getSobre_mi());
        usuario.setImg_hero(usuarioDTO.getImg_hero());
        usuario.setImg_perfil(usuarioDTO.getImg_perfil());
        usuario.setLink_1(usuarioDTO.getLink_1());
        usuario.setLink_2(usuarioDTO.getLink_2());

        userService.actualizarUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // USER DATA ENDPOINTS
    @GetMapping("/data/{user_email}/{data_id}")
    @ResponseBody
    public List<?> getData(@PathVariable String user_email, @PathVariable String data_id) {

        if ("experiences".equals(data_id)) {
            return expService.obtenerExperienciaPorUsuarioEmail(user_email);
        }

        if ("education".equals(data_id)) {
            return eduService.obtenerEducacionPorUsuarioEmail(user_email);
        }
        if ("proyects".equals(data_id)) {
            return proyectService.obtenerProyectoPorUsuarioEmail(user_email);
        }
        if ("skills".equals(data_id)) {
            return skillService.obtenerHabilidadPorUsuarioEmail(user_email);
        }

        return null;
    }

    @PostMapping("/data/{user_id}/{data_id}")
    public ResponseEntity<GenericDTO> addData(@RequestBody GenericDTO data, @PathVariable Long user_id,
            @PathVariable String data_id) {

        if ("experiences".equals(data_id)) {
            return new ResponseEntity<>(expService.crearExperiencia((ExperienciaDTO) data, user_id),
                    HttpStatus.CREATED);
        }
        if ("education".equals(data_id)) {
            return new ResponseEntity<>(eduService.crearEducacion((EducacionDTO) data, user_id), HttpStatus.CREATED);
        }
        if ("proyects".equals(data_id)) {
            return new ResponseEntity<>(proyectService.crearProyecto((ProyectoDTO) data, user_id), HttpStatus.CREATED);
        }
        if ("skills".equals(data_id)) {
            return new ResponseEntity<>(skillService.crearHabilidad((HabilidadDTO) data, user_id), HttpStatus.CREATED);
        }
        return null;
    }

    // ? El elemento se envía con el id, por lo tanto en principio no me hace falta
    // ? el id en la dirección, ¿qué conviene más?
    @PutMapping("/data/{user_id}/{data_id}/{id}")
    public ResponseEntity<GenericDTO> updateData(@RequestBody GenericDTO data, @PathVariable Long user_id,
            @PathVariable String data_id, @PathVariable Long id) {
        if ("experiences".equals(data_id)) {
            return new ResponseEntity<>(expService.actualizarExperiencia((ExperienciaDTO) data, user_id, id),
                    HttpStatus.OK);
        }
        if ("education".equals(data_id)) {
            return new ResponseEntity<>(eduService.actualizarEducacion((EducacionDTO) data, user_id, id),
                    HttpStatus.OK);
        }
        if ("proyects".equals(data_id)) {
            return new ResponseEntity<>(proyectService.actualizarProyecto((ProyectoDTO) data, user_id, id),
                    HttpStatus.OK);
        }
        if ("skills".equals(data_id)) {
            return new ResponseEntity<>(skillService.actualizarHabilidad((HabilidadDTO) data, user_id, id),
                    HttpStatus.OK);
        }
        return null;
    }

    @DeleteMapping("/data/{data_id}/{id}")
    public void borrarExp(@PathVariable String data_id, @PathVariable Long id) {
        if ("experiences".equals(data_id)) {
            expService.borrarExperiencia(id);
        }
        if ("education".equals(data_id)) {
            eduService.borrarEducacion(id);
        }
        if ("proyects".equals(data_id)) {
            proyectService.borrarProyecto(id);
        }
        if ("skills".equals(data_id)) {
            skillService.borrarHabilidad(id);
        }
    }

}
