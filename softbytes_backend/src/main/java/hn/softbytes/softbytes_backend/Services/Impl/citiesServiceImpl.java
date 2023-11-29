package hn.softbytes.softbytes_backend.Services.Impl;

import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.cities;
import hn.softbytes.softbytes_backend.Models.countries;
import hn.softbytes.softbytes_backend.Models.departments;
import hn.softbytes.softbytes_backend.Services.citiesService;

@Service
public class citiesServiceImpl implements citiesService{

    @Override
    public cities obtenerCiudad(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerCiudad'");
    }

    @Override
    public boolean crearCiudad(cities cities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearCiudad'");
    }

    @Override
    public departments obtenerDepartamentoCiudad(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerDepartamentoCiudad'");
    }

    @Override
    public countries obtenerPaisCiudad(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPaisCiudad'");
    }
    
}
