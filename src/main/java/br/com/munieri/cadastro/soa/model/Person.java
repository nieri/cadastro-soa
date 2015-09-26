package br.com.munieri.cadastro.soa.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
@JsonAutoDetect
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String name;
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Calendar dateBirth;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String mobile;
    //private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDateBirth() {
        return dateBirth;
    }

    public String getDateBirthFormatted() {

        if (dateBirth != null){
            return new SimpleDateFormat("dd/MM/yyyy").format(dateBirth.getTime());
        }
        return "";
    }

    public void setDateBirth(Calendar dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }
}
