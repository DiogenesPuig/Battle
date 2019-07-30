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
public class BabyDragon extends Raza {

    private Dado dado;
    private String nombre;

    public BabyDragon(Dado dado, String nombre, int salud, int ataque, int defensa, int xp) {
        super(salud, ataque, defensa, xp);
        this.dado = dado;
        this.nombre = nombre;
    }

    public BabyDragon(int salud, int ataque, int defensa, int xp) {
        super(salud, ataque, defensa, xp);
    }

    public BabyDragon(Dado dado, String nombre) {
        this.dado = dado;
        this.nombre = nombre;
    }
    
    
    public BabyDragon() {
    }

    
    

    public Dado getDado() {
        return dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean estaSaludable() {
        if (salud > 0) {
            return true;
        } else {
            return false;
        }
    }
    /*
    public void atacar(Orco o) {
        System.out.println(nombre + " ataca!");
        int critico = dado.tirarDado();
        int daño;
        if (critico > 8) {
            System.out.println("Daño crítico!");
            daño = super.ataque * 2;
        } else {
            daño = ataque * dado.tirarDado();
        }
        o.recibirDaño(daño);
        xp += 10;
    }
    
    public void atacarCaba(Caballero o) {
        System.out.println(nombre + " ataca!");
        int daño = ataque * dado.tirarDado();
        o.recibirDaño(daño);;
        xp += 10;
    }
*/
    public void recibirDaño(int daño) {
        int golpe = daño - defensa;
        salud -= golpe;
        System.out.println(nombre + " recibe " + golpe + " de daño.");
    }

    @Override
    public String toString() {
        return nombre + " tiene " + xp + " puntos de experiencia.";
    }

    @Override
    public void atacarDrag(BabyDragon bd) {
        System.out.println(nombre + " ataca!");
        int daño = ataque * dado.tirarDado();
        bd.recibirDaño(daño);
        xp += 10;
    }

    @Override
    public void atacarOrco(Orco oc){
        System.out.println(nombre + " ataca!");
        int daño = ataque *dado.tirarDado();
        oc.recibirDaño(daño);
        xp += 10;
    }

    @Override
    public void atacarCaba(Caballero cb) {
        System.out.println(nombre + " ataca!");
        int daño = ataque *dado.tirarDado();
        cb.recibirDaño(daño);
        xp += 10;
    }

    
}
