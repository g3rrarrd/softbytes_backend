package hn.softbytes.softbytes_backend.Services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.orderDetail;
import hn.softbytes.softbytes_backend.Services.orderDetailsService;

@Service
public class orderDetailsServiceImpl implements orderDetailsService{

    @Override
    public boolean crearOrderDetail(orderDetail orderDetail) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearOrderDetail'");
    }

    @Override
    public List<orderDetail> obtenerDetallesPedido(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerDetallesPedido'");
    }

    @Override
    public boolean actualizarCantidad(int id, int cantidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarCantidad'");
    }
    
}
