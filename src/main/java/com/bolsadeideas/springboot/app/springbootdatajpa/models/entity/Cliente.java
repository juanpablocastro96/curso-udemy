package com.bolsadeideas.springboot.app.springbootdatajpa.models.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="clientes")
@Data
public class Cliente implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Column(name="create_at")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createAt;

    //diferencia entre not null y notempty. con not empty valida que venga ese string pero con contenido con un largo mayor a cero
    // y not null que no sea null importante string con not empty
    /*
    metodo que se ejecuta solo y nos da la fecha de cracion del registro
    @PrePersist
    public void prePersist(){
        createAt = new Date();
    }*/

}
