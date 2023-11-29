package hn.softbytes.softbytes_backend.Services.Impl;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.users;
import hn.softbytes.softbytes_backend.Repositories.userTypeRepository;
import hn.softbytes.softbytes_backend.Repositories.usersRepository;
import hn.softbytes.softbytes_backend.Services.usersService;

@Service
public class usersServiceImpl implements usersService{

    @Autowired
    private usersRepository usersRepository;

    @Autowired
    private userTypeRepository userTypeRepository;

    @Override
    public boolean crearCliente(users users) {
        
        if(isValidateUser(users)){
            for (users user : this.usersRepository.findAll()) {
                if (user.getEmail().equals(users.getEmail())) {
                    return false;
                }
            }
            users.setUsertype(this.userTypeRepository.findById(0).get());
            this.usersRepository.save(users);
            return true;
        }

        return false;
    }

    private boolean isValidateUser(users users){
        if(users.getDateofBirth() != null 
        && users.getEmail() != null 
        && users.getName() != null 
        && users.getLastName() != null 
        && users.getAddresses() != null 
        && users.getPassword() != null 
        && users.getTelephone() != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean modificarCliente(int id, users users) {
       
        users oldUser = new users();

        oldUser.setAddresses(users.getAddresses() != null ? users.getAddresses() : oldUser.getAddresses());
        oldUser.setPassword(users.getPassword() != null ? users.getPassword() : oldUser.getPassword());
        oldUser.setShippingPreference(users.getShippingPreference() != null ? users.getShippingPreference() : oldUser.getShippingPreference());
        oldUser.setContactInformation(users.getContactInformation() != null ? users.getContactInformation() : oldUser.getContactInformation());

        this.usersRepository.save(oldUser);
        return true;

        }

    @Override
    public int idCliente(String correo) {
        
        for (users user : this.usersRepository.findAll()) {
            
            if(user.getEmail().equals(correo)){
                return user.getIdUser();
            }

        }

        return -1;

    }

    @Override
    public boolean eliminarCliente(int id) {
       

        if(this.usersRepository.existsById(id)){

            try {
                this.usersRepository.deleteById(id);
                return true;
            } catch (Exception e) {
                e.printStackTrace(); 
                return false;
            }
            

        }

        return false;
    }

    @Override
    public users buscarCliente(int id) {
        
        users user = new users();

        if(this.usersRepository.existsById(id)){
            user = this.usersRepository.findById(id).get();
            return user;
        }

        return user;
    }

    @Override
    public List<users> obtenerTodosClientes() {
        
        return this.usersRepository.findAll();

    }

    @Override
    public List<users> obtenerClientePorTipo(int id) {
        
        List<users> usersByType = new LinkedList<users>();

        for (users user : this.usersRepository.findAll()) {
            
            if(user.getUsertype().getIdUserType() == id){
                usersByType.add(user);
            }

        }

        return usersByType;

    }

    @Override
    public List<users> clientePorFecha(LocalDate fechaInicio, LocalDate fechaFinal) {
       
        List<users> usersByDate = new LinkedList<users>();

        for (users user : this.usersRepository.findAll()) {
            
            if(user.getDateofBirth().isAfter(fechaInicio) && user.getDateofBirth().isBefore(fechaFinal)){
                usersByDate.add(user);
            }

        }

        return usersByDate;

    }
    
}
