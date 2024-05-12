/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyetoparqueadero;

/**
 *
 * @author UrbanAgent
 */
public class Vehiculo {
    private String placa;
    private String modelo;
    private String propietario;
    
    //Contructor
    public Vehiculo (String placa, String modelo, String propietario) {
        this.modelo = modelo;
        this.placa = placa;
        this.propietario = propietario;
    }
     // Getters
    public String getModelo() {
        return modelo;
    }
    
    public String getPlaca () {
        return placa;
    }
    
    public String getPropietario () {
        return propietario;
    }
    
    //Setters
    public void  setModelo (String modelo) {
        this.modelo = modelo;
    }
    
    public void setPlaca (String placa) {
        this.placa = placa;
    }
    
    public void setPropietario (String propietario) {
        this.propietario = propietario;
    }
}
