/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batalla;

/**
 *
 * @author diogenes
 */
public class Player { // creamos la clase Player para poder hacer la "jugabilidad"
    private Caballero c;
    private BabyDragon d;
    private Orco o;
    private int mes;
    
    public Player() {
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    
    
    public Player(Caballero c,int mes) {
        this.c = c;
        this.mes = mes;
    }

    public Player(BabyDragon d,int mes) {
        this.d = d;
        this.mes = mes;
    }

    public Player(Orco o,int mes) {
        this.o = o;
        this.mes = mes;
    }

    public Caballero getC() {
        return c;
    }

    public void setC(Caballero c) {
        this.c = c;
    }

    public BabyDragon getD() {
        return d;
    }

    public void setD(BabyDragon d) {
        this.d = d;
    }

    public Orco getO() {
        return o;
    }

    public void setO(Orco o) {
        this.o = o;
    }

    
    @Override
    public String toString() {
        if(mes == 1){
            return "Player = " + c.toString(); 
        }if(mes == 2){
            return "Player = " + d.toString();
        }else{
            return "Player = " + o.toString(); 
        }
    }
    
    
    
}
