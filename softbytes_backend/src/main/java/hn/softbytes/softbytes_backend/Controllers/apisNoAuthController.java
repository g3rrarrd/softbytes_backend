package hn.softbytes.softbytes_backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.softbytes.softbytes_backend.Models.products;
import hn.softbytes.softbytes_backend.Services.Impl.productsServiceImpl;

@RestController
@RequestMapping("v1/")
public class apisNoAuthController {

    @Autowired
    productsServiceImpl productsServiceImpl;

    @PostMapping("/crear")
    public String crearProducto(@RequestParam(name = "id")int id,@RequestBody products products, @RequestParam(name = "idSubCategory")int idSubCategory, @RequestParam(name = "idCategory")int idCategory){
        if(this.productsServiceImpl.crearProducto(id ,products, idSubCategory, idCategory)){
            return "Producto Creado";
        }
        return "No ha podido crearse";
    }
    
}
