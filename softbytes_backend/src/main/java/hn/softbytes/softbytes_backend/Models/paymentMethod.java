package hn.softbytes.softbytes_backend.Models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "metodopago")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class paymentMethod {

    @Id
    @Column(name = "idmetodopago")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaymentMethod;

    @Column(name = "descripcion")
    private String description;

    @OneToMany(mappedBy = "idPaymentMethod", cascade = CascadeType.ALL)
    private List<orders> orders;

}
