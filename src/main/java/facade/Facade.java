/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Car;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rasmus
 */
public class Facade {
    
    EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Car> getCars(){
        EntityManager em = getEntityManager();

        try {
            List<Car> cars = em.createQuery("Select c from car c").getResultList();
            return cars;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        } finally {
            em.close();
        }
    }
    
    public void addCar(Car car){
        
    }
    
    public void deleteCar(int id){
        
    }
    
    public void editCar(Car car){
        
    }
    
}
