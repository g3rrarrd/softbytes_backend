package hn.softbytes.softbytes_backend.Services.Impl;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.softbytes.softbytes_backend.Models.orderDetail;
import hn.softbytes.softbytes_backend.Models.sales;
import hn.softbytes.softbytes_backend.Repositories.orderDetailsRepository;
import hn.softbytes.softbytes_backend.Repositories.ordersRepository;
import hn.softbytes.softbytes_backend.Repositories.salesRepository;
import hn.softbytes.softbytes_backend.Services.salesService;

@Service
public class salesServiceImpl implements salesService{

    @Autowired
    private salesRepository salesRepository;

    @Autowired
    private orderDetailsRepository orderDetailRepository;

    @Override
    public boolean crearVenta(sales sales) {
        
        double subTotal = 0;

        if(isSalesValidate(sales)){
            sales.setIsv(0.15);
            
            subTotal = calcularSubTotal(sales.getIdOrder().getIdOrders());

            sales.setSubTotal(subTotal);
            sales.setTotal(subTotal + (subTotal * sales.getIsv()));
            sales.setDate(LocalDate.now());
            this.salesRepository.save(sales);
            return true;
        }

        return false;
    }

    private double calcularSubTotal(int id){
        
        double subTotal = 0;

        for (orderDetail orderDetail : this.orderDetailRepository.findAll()) {
            
            if(orderDetail.getIdOrders().getIdOrders() == id){
                subTotal += (orderDetail.getUnityPrice() * orderDetail.getQuantity());
            }

        }

        return subTotal;

    }

    private boolean isSalesValidate(sales sales){

        if(sales.getIdOrder() != null){
            return true;
        }

        return false;

    }

    @Override
    public sales buscarVentaPedido(int id) {
        
        for (sales sales : this.salesRepository.findAll()) {
            if(sales.getIdOrder().getIdOrders() == id){
                return sales;
            }
        }

        return null;
    }

    @Override
    public sales buscarVenta(int id) {
        return this.salesRepository.findById(id).get();
    }

    @Override
    public List<sales> obtenerVentas() {
        
        List<sales> salesList = new LinkedList<sales>();

        salesList = this.salesRepository.findAll();

        return salesList;

    }
    
}
