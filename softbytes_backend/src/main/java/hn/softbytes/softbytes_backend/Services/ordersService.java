package hn.softbytes.softbytes_backend.Services;

import hn.softbytes.softbytes_backend.Models.orderStatus;
import hn.softbytes.softbytes_backend.Models.orders;
import hn.softbytes.softbytes_backend.Models.paymentMethod;

public interface ordersService {
    
    /*
     * Obtendra el pedido por medio de una id
     * @param id idPedido
     * @return orders
     */
    public orders obtenerPedido(int id);

    /*
     * Creara un pedido en la base de datos
     * @param orders orders:Json
     * @return boolean
     */
    public boolean crearPedido(orders orders);

    /*
     * Obtendra el estado del pedido buscado por la id
     * @param id idPedido
     * @return orderStatus
     */
    public orderStatus obtenerEstado(int id);

    /*
     * Obtendra el metodo de pago del pedido buscado por la id
     * @param id idPedido
     * @return paymentMethod
     */
    public paymentMethod obtenerMetodoPago(int id);

}
