/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyetoparqueadero;

/**
 *
 * @author UrbanAgent
 */
public class Moto extends Vehiculo{
    private int maxVel;
    
    public Moto(String placa, String modelo, String propietario) {
        super(placa, modelo, propietario);
    }
    
    public int getMaxVel () {
        return maxVel;
    }
    
    public void setMaxVel (int maxVel) {
        this.maxVel = maxVel;
    }
    
}
