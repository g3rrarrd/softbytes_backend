package hn.softbytes.softbytes_backend.Services.Impl;

import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.orderStatus;
import hn.softbytes.softbytes_backend.Models.orders;
import hn.softbytes.softbytes_backend.Services.ordersService;

@Service
public class ordersServiceImpl implements ordersService{

    @Override
    public orders obtenerPedido(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPedido'");
    }

    @Override
    public boolean crearPedido(orders orders) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearPedido'");
    }

    @Override
    public orderStatus obtenerEstado(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerEstado'");
    }

    
}
