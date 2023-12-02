package hn.softbytes.softbytes_backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.softbytes.softbytes_backend.Models.products;
import hn.softbytes.softbytes_backend.Services.Impl.productsServiceImpl;

@RestController
@RequestMapping("/auth/products/")
public class productsController {
    
    
    @Autowired
    productsServiceImpl productsServiceImpl;

    @PostMapping("/crear")
    public String crearProducto(@RequestParam(name = "id")int id,@RequestBody products products, @RequestParam(name = "idSubCategory")int idSubCategory, @RequestParam(name = "idCategory")int idCategory){
        if(this.productsServiceImpl.crearProducto(id ,products, idSubCategory, idCategory)){
            return "Producto Creado";
        }
        return "No ha podido crearse";
    }

    @PutMapping("/actualizar")
    public String actualizarPrecio(@RequestParam(name = "id")int id, @RequestParam(name = "price")double price){
        if(this.productsServiceImpl.actualizarProductoPrecio(id, price)){
            return "Producto Actualizado";
        }
        return "No se ha podido actualizar";
    }

    @DeleteMapping("/eliminar")
    public boolean eliminarProducto(@RequestParam(name = "id")int id){
        return this.productsServiceImpl.eliminarProducto(id);
    }

    @GetMapping("/obtener")
    public List<products> obtenerProductos(){
        return this.productsServiceImpl.obtenerTodosProductos();
    }

    @GetMapping("/buscar")
    public products buscarProductos(@RequestParam(name = "id")int id){
        return this.productsServiceImpl.obtenerProducto(id);
    }

    @GetMapping("/obtener/subCategoria")
    public List<products> obtenerProductosTipos(@RequestParam(name = "subCategory")String subCategory){
        return this.productsServiceImpl.obtenerProductosSubCategoria(subCategory);
    }

    @GetMapping("/obtener/categoria")
    public List<products> obtenerProductosCategoria(@RequestParam(name = "Category")String Category){
        return this.productsServiceImpl.obtenerProductosCategoria(Category);
    }

    @PutMapping("/actualizar/review")
    public boolean actualizarProductoReview(@RequestParam(name = "id")int id, @RequestParam(name = "review")String review){
        return this.productsServiceImpl.actualizarProdcutoReviews(id, review);
    }
}
