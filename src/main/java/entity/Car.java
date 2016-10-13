/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rasmus
 */
@Entity
@Table(name = "car")
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findById", query = "SELECT c FROM Car c WHERE c.id = :id"),
    @NamedQuery(name = "Car.findByModelYear", query = "SELECT c FROM Car c WHERE c.modelYear = :modelYear"),
    @NamedQuery(name = "Car.findByRegistered", query = "SELECT c FROM Car c WHERE c.registered = :registered"),
    @NamedQuery(name = "Car.findByMake", query = "SELECT c FROM Car c WHERE c.make = :make"),
    @NamedQuery(name = "Car.findByModel", query = "SELECT c FROM Car c WHERE c.model = :model"),
    @NamedQuery(name = "Car.findByDescription", query = "SELECT c FROM Car c WHERE c.description = :description"),
    @NamedQuery(name = "Car.findByPrice", query = "SELECT c FROM Car c WHERE c.price = :price")})
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "model_year")
    private Integer modelYear;
    @Size(max = 45)
    @Column(name = "registered")
    private String registered;
    @Size(max = 45)
    @Column(name = "make")
    private String make;
    @Size(max = 45)
    @Column(name = "model")
    private String model;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @Size(max = 45)
    @Column(name = "price")
    private String price;

    public Car() {
    }

    public Car(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
