package hn.softbytes.softbytes_backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hn.softbytes.softbytes_backend.Models.sales;
import hn.softbytes.softbytes_backend.Services.Impl.salesServiceImpl;

@RestController
@RequestMapping("/auth/sales")
public class salesController {
    
    @Autowired
    private salesServiceImpl salesServiceImpl;

    @PostMapping("/crear")
    public String crearVenta(@RequestBody sales sales){
        if(this.salesServiceImpl.crearVenta(sales)){
            return "Venta Creada";
        }
        return "No se ha podido realizar la venta";
    }

    @GetMapping("/buscar/pedido")
    public sales buscarVentaPedido(@RequestParam(name = "id")int id){
        return this.salesServiceImpl.buscarVentaPedido(id);
    }

    @GetMapping("/buscar")
    public sales buscarVenta(@RequestParam(name = "id")int id){
        return this.salesServiceImpl.buscarVenta(id);
    }

    @GetMapping("/obtener")
    public List<sales> obtenerVenta(@RequestParam(name = "id")int id){
        return this.salesServiceImpl.obtenerVentas();
    }

}
