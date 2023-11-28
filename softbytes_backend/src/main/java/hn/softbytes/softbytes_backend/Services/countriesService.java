package hn.softbytes.softbytes_backend.Services;

import java.util.List;

import hn.softbytes.softbytes_backend.Models.countries;

public interface countriesService {
    
    /*
     * Se regresara el pais determinado por su id
     * @param id idCountries
     * @return countries
     */
    public countries obtenerPais(int id);

    /*
     * Retornara todos los paises de la base de datos
     * @return List<countries>
     */
    public List<countries> obtenerTodosPaises();

}
