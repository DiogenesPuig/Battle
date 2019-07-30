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
public class Raza { // se creo la clase padre
    protected int salud;
    protected int ataque;
    protected int defensa;
    protected int xp;

    public Raza(int salud, int ataque, int defensa, int xp) {
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
        this.xp = xp;
    }

    public Raza() {
        salud = 0;
        ataque = 0;
        defensa = 0;
        xp = 0;
    }
    

    public void atacarCaba(Caballero cb){
        
    }
    public void atacarOrco(Orco oc){
        
    }
    public void atacarDrag(BabyDragon bd){
        
    }
    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
    public void curarse(){ // cree una funcion para curarse que se hereda y es igual para todos.
        if(salud < 1000){
            salud += 165;
        }else{
            System.out.println("Estas al maximo de vida! has perdido una posion :c");
        }
    }
    
    public void escapar(){
        
    }

    @Override
    public String toString() {
        return "Raza{" + "salud=" + salud + ", ataque=" + ataque + ", defensa=" + defensa + ", xp=" + xp + '}';
    }
    
    
    
    
    
}
