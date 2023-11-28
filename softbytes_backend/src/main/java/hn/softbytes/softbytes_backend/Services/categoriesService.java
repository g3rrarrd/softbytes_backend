package hn.softbytes.softbytes_backend.Services;

import java.util.List;

import hn.softbytes.softbytes_backend.Models.categories;

public interface categoriesService {
    
    /*
     * Se creara categoria en la base de datos categoria
     * @param catrgories categories:Json
     * @retun boolean
     */
    public boolean crearCategoria(categories categories);

    /*
     * buscara la categoria por medio de la id
     * @param id idCategorie
     * @return categories
     */
    public categories buscarCategoria(int id);

    /*
     * Retornara todas las categorias de la base de datos
     * @return Lsit<categories>
     */
    public List<categories> obtenerTodasCategorias();
}
