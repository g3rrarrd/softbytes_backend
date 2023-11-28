package hn.softbytes.softbytes_backend.Services;

import java.util.List;

import hn.softbytes.softbytes_backend.Models.sales;

public interface salesService {
    
    /*
     * Crea una venta en la base
     * @param sales:Json
     * @return sales
     */
    public sales crearVenta(sales sales);

    /*
     * Obtiene la venta del pedido
     * @param id idPedido
     * @return sales
     */
    public sales idPedido(int id);

    /*
     * Obtiene las ventas por su id
     * @param id idVentas
     * @return sales
     */
    public sales idVenta(int id);

    /*
     * Obtiene una lista de todas las ventas
     * @return Lista<sales>
     */
    public List<sales> obtenerVentas();


}
