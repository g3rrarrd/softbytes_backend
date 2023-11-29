package hn.softbytes.softbytes_backend.Services.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.products;
import hn.softbytes.softbytes_backend.Services.productsService;

@Service
public class productsServiceImpl implements productsService{

    @Override
    public boolean crearProducto(products products) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearProducto'");
    }

    @Override
    public boolean actualizarProductoPrecio(int id, double price) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarProductoPrecio'");
    }

    @Override
    public boolean eliminarProducto(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarProducto'");
    }

    @Override
    public products obtenerProducto(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerProducto'");
    }

    @Override
    public List<products> obtenerTodosProductos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerTodosProductos'");
    }

    @Override
    public List<products> ordenarPrecio(double price) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ordenarPrecio'");
    }

    @Override
    public List<products> obtenerProductosSubCategoria(String subcategoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerProductosSubCategoria'");
    }

    @Override
    public List<products> obtenerProductosCategoria(String categoria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerProductosCategoria'");
    }
    
}
