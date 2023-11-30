package hn.softbytes.softbytes_backend.Services.Impl;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.address;
import hn.softbytes.softbytes_backend.Models.users;
import hn.softbytes.softbytes_backend.Repositories.addressRepository;
import hn.softbytes.softbytes_backend.Repositories.citiesRepository;
import hn.softbytes.softbytes_backend.Repositories.countriesRepository;
import hn.softbytes.softbytes_backend.Repositories.departmentsRepository;
import hn.softbytes.softbytes_backend.Repositories.userTypeRepository;
import hn.softbytes.softbytes_backend.Repositories.usersRepository;
import hn.softbytes.softbytes_backend.Services.usersService;

@Service
public class usersServiceImpl implements usersService{

    @Autowired
    private usersRepository usersRepository;

    @Autowired
    private userTypeRepository userTypeRepository;
    @Autowired 
    private addressRepository addressRepository;
    @Autowired
    private citiesRepository citiesRepository;
    @Autowired 
    private departmentsRepository departmentsRepository;
    @Autowired
    private countriesRepository countriesRepository;

    @Override
    public users crearCliente(users users) {
        
        address address;

        if(isValidateUser(users)){
           if(!this.usersRepository.findAll().isEmpty()){
             for (users user : this.usersRepository.findAll()) {
                if (user.getEmail().equals(users.getEmail())) {
                    return users;
                }
            }
           }

            this.countriesRepository.save(users.getAddresses().get(0).getIdCity().getDepartments().getIdCountry());
            this.departmentsRepository.save(users.getAddresses().get(0).getIdCity().getDepartments());
            this.citiesRepository.save(users.getAddresses().get(0).getIdCity());
            address = this.addressRepository.save(users.getAddresses().get(0));
            users.getAddresses().get(users.getIdUser()).setIdUsers(users);;
            users.setUsertype(this.userTypeRepository.findById(1).get());
            users.setUsername(users.getEmail());
            this.usersRepository.save(users);
            return this.usersRepository.findById(users.getIdUser()).get();
        }

        return users;
    }

    private boolean isValidateUser(users users){
        if(users.getDateofBirth() != null 
        && !users.getEmail().isEmpty() 
        && !users.getName().isEmpty() 
        && !users.getLastName().isEmpty()
        && !users.getAddresses().isEmpty()
        && !users.getPassword().isEmpty()
        && !users.getTelephone().isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public boolean modificarCliente(int id, users users) {
       
        users oldUser = new users();

        oldUser = this.usersRepository.findById(id).get();
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
        
        users users = new users();

        if(this.usersRepository.findById(id)!=null){
            users = this.usersRepository.findById(id).get();
        }

        return users;
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

    @Override
    public boolean isClientValidate(String email, String password) {
        
        for (users user : this.usersRepository.findAll()) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return true;
            }
        }

        return false;

    }

    public boolean cambiarTipo(int id, int tipo) {
        
        users users = new users();

        if(this.usersRepository.findById(id) != null){

           if(this.userTypeRepository.findById(id) != null){
             users = this.usersRepository.findById(id).get();
             users.setUsertype(this.userTypeRepository.findById(tipo).get());
             this.usersRepository.save(users);
             return true;
           }
            
        }

        return false;
    }
    
}
