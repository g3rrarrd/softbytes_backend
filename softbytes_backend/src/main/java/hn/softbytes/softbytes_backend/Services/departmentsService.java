package hn.softbytes.softbytes_backend.Services;

import java.util.List;

import hn.softbytes.softbytes_backend.Models.departments;

public interface departmentsService {
    
    /*
     * Se creara en la base de datos departamentos
     * @param departments departments:Json
     * @return departments
     */
    public departments crearDepartamento(departments departments);

    /*
     * Obetendra el departamento por medio de la id
     * @param id idDepartments
     * @return departments
     */
    public departments obtenerDepartamento(int id);

    /*
     * Obtendra todos los departamentos en la tabla de dato
     * @return List<departaments>
     */
    public List<departments> obtenerTodosDepartamentos();

    /*
     * Obtendra el pais de departamento por id
     * @param id idDepartaments
     * @return String
     */
    public String obtenerPaisDepartamento(int id);

}
