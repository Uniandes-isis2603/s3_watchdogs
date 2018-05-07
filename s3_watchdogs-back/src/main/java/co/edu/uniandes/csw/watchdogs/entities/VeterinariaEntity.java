/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author js.vacat
 */
@Entity
public class VeterinariaEntity extends LugarEntity implements Serializable {
    
    @PodamExclude
    @OneToMany(mappedBy = "veterinaria", cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<AseoEntity> aseos;
    
    @PodamExclude
    @OneToMany(mappedBy = "veterinaria", cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<PaseoEntity> paseos;
    

     public VeterinariaEntity(){
        
    }
     
     /**
     * @return los aseos
     */
      public List<AseoEntity> getAseos(){
        return aseos;
    }

      /**
     * @param aseos los aseos que entran por parametro
     */
    public void setAseos(List<AseoEntity> aseos) {
        this.aseos= aseos;
    }

    /**
     * @return los paseos
     */
    public List<PaseoEntity> getPaseos() {
        return paseos;
    }

    /**
     * @param paseos los paseos que entran por parametro
     */
    public void setPaseos(List<PaseoEntity> paseos) {
        this.paseos = paseos;
    }
}
