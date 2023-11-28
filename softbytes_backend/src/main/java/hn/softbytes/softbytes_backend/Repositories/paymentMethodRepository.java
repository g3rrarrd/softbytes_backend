package hn.softbytes.softbytes_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hn.softbytes.softbytes_backend.Models.paymentMethod;

public interface paymentMethodRepository extends JpaRepository<paymentMethod, Integer>{
    
}
