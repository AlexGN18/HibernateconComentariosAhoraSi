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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author RigoBono
 */

@Entity
@Table(name="Persona",catalog="generationHibernate") //Aqui se obtienen los datos de la tabla llamada "Persona" y se obtienen los datos del catalogo llamado "generationHibernate"
public class Persona {
    
    @Id @GeneratedValue //id se inicializa para obtener los valores en conjunto en la condicion y generatedvalue para generar los valores en hilo
    @Column(name="idPersona") //aqui se obtienen los valores de la base en la columna llamada "idPersona"
    private int idPersona; //se declara la variable idPersona en la clase
    
    @Column(name="Nombre",nullable=true) //aqui se obtiene los valores de la base de datos en la columna llamada "Nombre" y se hace null cuando sea true
    private String Nombre; //inicia el constructor de la variable "Nombre"
    
    @Column(name="Paterno") //aqui se obtienen los valores de la base en la columna llamada "Paterno"
    private String Paterno; //inicia el constructor de la variable "Paterno"
    
     @Column(name="Materno") //aqui se obtienen los valores de la base en la columna llamada "Materno"
    private String Materno; //inicia el constructor de la variable "Materno"
     
     @Column(name="Telefono") //aqui se obtienen los valores de la base en la columna llamada "Telefono"
    private String Telefono; //inicia el constructor de la variable "Telefono"
    
     @ManyToOne
     @JoinColumn(name="idTipoPersona") //aqui se obtienen los valores de la base en la columna llamada "idTipoPersona"
    private TipoPersona tipoPersona; //inicia el constructor de la variable "tipoPersona"

    /**
     * @return the idPersona
     */
    public int getIdPersona() { //se inicializa el getter de idPersona
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) { //se inicializa el setter de idPersona
        this.idPersona = idPersona;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() { //se inicializa el getter de Nombre
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) { //se inicializa el setter de Nombre
        this.Nombre = Nombre;
    }

    /**
     * @return the Paterno
     */
    public String getPaterno() { //se inicializa el getter de Paterno
        return Paterno;
    }

    /**
     * @param Paterno the Paterno to set
     */
    public void setPaterno(String Paterno) { //se inicializa el setter de Paterno
        this.Paterno = Paterno;
    }

    /**
     * @return the Materno
     */
    public String getMaterno() { //se inicializa el getter de Materno
        return Materno;
    }

    /**
     * @param Materno the Materno to set
     */
    public void setMaterno(String Materno) { ////se inicializa el setter de Materno
        this.Materno = Materno;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() { //se inicializa el getter de Telefono
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) { //se inicializa el setter de Telefono
        this.Telefono = Telefono;
    }

    /**
     * @return the tipoPersona
     */
    public TipoPersona getTipoPersona() { //se inicializa el getter de TipoPersona
        return tipoPersona;
    }

    /**
     * @param tipoPersona the tipoPersona to set
     */
    public void setTipoPersona(TipoPersona tipoPersona) { //se inicializa el setter de TipoPersona
        this.tipoPersona = tipoPersona;
    }
     
     
    
}
