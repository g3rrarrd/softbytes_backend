package hn.softbytes.softbytes_backend.Models;

import java.time.LocalDate;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class users{
    
    @Id
    @Column(name = "idusuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "contrasenia")
    private String password;

    @Column(name = "telefono")
    private String telephone;

    @Column(name = "correo")
    private String email;

    @Column(name = "fechanacimiento")
    private LocalDate dateofBirth;

    @Column(name = "informacioncontacto")
    private String contactInformation;

    @Column(name = "preferenciaenvio")
    private String shippingPreference;

    @ManyToOne
    @JoinColumn(name = "idtipousuario", referencedColumnName = "idtipousuario")
    private userType usertype;

    @OneToMany(mappedBy = "idUsers", cascade = CascadeType.ALL)
    private List<address> addresses;

    @ManyToMany(mappedBy = "idUsers", cascade = CascadeType.ALL)
    private List<orders> iOrders;
}
