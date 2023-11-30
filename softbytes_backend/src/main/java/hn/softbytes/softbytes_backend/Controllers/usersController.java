package hn.softbytes.softbytes_backend.Controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.softbytes.softbytes_backend.Models.users;
import hn.softbytes.softbytes_backend.Services.Impl.usersServiceImpl;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth/user")
@RequiredArgsConstructor
public class usersController {
    
    @Autowired
    private usersServiceImpl usersServiceImpl;

    @PostMapping(value = "registrar")
    public users registrarCliente(@RequestBody users user){
       return this.usersServiceImpl.crearCliente(user);
    }

    @PutMapping("/actualizar")
    public String actualizarCliente(@RequestParam(name = "idCliente")int idCliente, @RequestBody users user){
        if(this.usersServiceImpl.modificarCliente(idCliente, user)){
            return "Se ha actualizado el cliente";
        }
        return "No ha podido ser actualizado";
    }    

    @GetMapping("/buscar")
    public users buscarCliente(@RequestParam(name = "id")int id){
        users users = new users();
        users = this.usersServiceImpl.buscarCliente(id);
        return users;
    }

    @GetMapping("/buscar/correo")
    public int buscarClienteCorreo(@RequestParam(name = "email")String email){
        return this.usersServiceImpl.idCliente(email);
    }

    @DeleteMapping("/eliminar")
    public boolean eliminarCliente(@RequestParam(name = "id")int id){
        return this.usersServiceImpl.eliminarCliente(id);
    }

    @GetMapping("/obtener")
    public List<users> obtenerClientes(){
        return this.usersServiceImpl.obtenerTodosClientes();
    }

    @GetMapping("/obtener/tipo")
    public List<users> obtenerTiposClientes(@RequestParam(name = "id")int id){
        return this.usersServiceImpl.obtenerClientePorTipo(id);
    }

    @GetMapping("/obtener/fecha")
    public List<users> obtenerTiposClientes(@RequestParam(name = "fechaInicio")LocalDate fechaInicio, @RequestParam(name = "fechaFinal")LocalDate fechaFinal){
        return this.usersServiceImpl.clientePorFecha(fechaInicio, fechaFinal);
    }

    @GetMapping("/validar")
    public boolean validarCliente(@RequestParam(name = "email")String email, @RequestParam(name = "password")String password){
        return this.usersServiceImpl.isClientValidate(email, password);
    }

    @PutMapping("/cambiarTipo")
    public String cambiarTipoCliente(@RequestParam(name = "id")int id, @RequestParam(name = "tipo") int tipo){
        if(this.usersServiceImpl.cambiarTipo(id, tipo)){
            return "Tipo de cliente cambiado";
        }
        return "Error en el cambio";
    }
}
