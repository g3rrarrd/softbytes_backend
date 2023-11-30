package hn.softbytes.softbytes_backend.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.orderStatus;
import hn.softbytes.softbytes_backend.Models.orders;
import hn.softbytes.softbytes_backend.Repositories.ordersRepository;
import hn.softbytes.softbytes_backend.Services.ordersService;

@Service
public class ordersServiceImpl implements ordersService{

    @Autowired
    private ordersRepository ordersRepository;

    @Override
    public orders obtenerPedido(int id) {
        
        if(this.ordersRepository.existsById(id)){
            return this.ordersRepository.findById(id).get();
        }

        return null;
    }

    @Override
    public boolean crearPedido(orders orders) {
        
        if(orders != null){
            this.ordersRepository.save(orders);
            return true;
        }

        return false;

    }

    @Override
    public orderStatus obtenerEstado(int id) {
        
        if(this.ordersRepository.existsById(id)){
            return this.ordersRepository.findById(id).get().getIdOrderStatus();
        }
        return null;
    }

    @Override
    public boolean eliminarPedido(int id) {
        
        if(this.ordersRepository.existsById(id)){
            this.ordersRepository.deleteById(id);
            return true;
        }

        return false;
    }

    
}
