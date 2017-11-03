/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  #Pray4Tanque
 * @author RigoBono
 */
@Entity
@Table(name="TipoPersona", catalog="generationHibernate") //Aqui se obtienen de la tabla "TipoPersona" y se obtienen del catalogo "generationHibernate" los datos
public class TipoPersona {
    
    @Id @GeneratedValue //id se inicializa para obtener los valores en conjunto en la condicion y generatedvalue para generar los valores en hilo
    @Column(name="idTipoPersona") //aqui se obtienen los valores de la base en la columna llamada "idTipoPersona"
    private int idTipoPersona; //se declara la variable int de "idTipoPersona"
    
     @Column(name="TipoPersonacol") //aqui se obtienen los valores de la base en la columna llamada "TipoPersonacol"
    private String TipoPersona; //se inicializa la variable TipoPersona
     
     public TipoPersona(){
         
     }
     

    /**
     * @return the idTipoPersona
     */
    public int getIdTipoPersona() { //se inicializa el getter de idTipoPersona
        return idTipoPersona;
    }

    /**
     * @param idTipoPersona the idTipoPersona to set
     */
    public void setIdTipoPersona(int idTipoPersona) { //se inicializa el setter de idTipoPersona
        this.idTipoPersona = idTipoPersona;
    }

    /**
     * @return the TipoPersona
     */
    public String getTipoPersona() { //se inicializa el getter de TipoPersona
        return TipoPersona;
    }

    /**
     * @param TipoPersona the TipoPersona to set
     */
    public void setTipoPersona(String TipoPersona) { //se inicializa el setter de TipoPersona
        this.TipoPersona = TipoPersona;
    }
     
     
     
     
    
}
