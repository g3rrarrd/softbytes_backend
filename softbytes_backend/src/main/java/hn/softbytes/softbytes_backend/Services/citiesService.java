package hn.softbytes.softbytes_backend.Services;

import hn.softbytes.softbytes_backend.Models.cities;
import hn.softbytes.softbytes_backend.Models.countries;
import hn.softbytes.softbytes_backend.Models.departments;

public interface citiesService {
    
    /*
     * Retornara la ciudad por medio de su id
     * @param id idCities
     * @return cities
     */
    public cities obtenerCiudad(int id);

    /*
     * Se creara la ciudad en la tabla ciudades
     * @param cities cities:Json
     * @return boolean
     */
    public boolean crearCiudad(cities cities);

    /*
     * Obtendra el departamento de la ciudad
     * @param id idCities
     * @return departments
     */
    public departments obtenerDepartamentoCiudad(int id);

    /*
     * obtendra el pais de la ciudad
     * @param id idCities
     * @return countries
     */
    public countries obtenerPaisCiudad(int id);


}
