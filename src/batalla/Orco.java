package batalla;
// se arreglo la identacion
public class Orco extends Raza{
    private Dado dado;
    private String nombre;

    public Orco(Dado dado, String nombre, int salud, int ataque, int defensa, int xp) { // se contruyo un constructor nuevo
        super(salud, ataque, defensa, xp);
        this.dado = dado;
        this.nombre = nombre;
    }

    // se agregaron los Getters y Setters, se borraron metodos que no se usan
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
        if (super.salud > 0) {
            return true;
        } else {
            return false;
        }
    }

    
    
    public void recibirDaño(int daño) {
        int golpe = daño - defensa;
        if(defensa >= golpe){
            System.out.println("El golpe fue ineficaz");
        }else{
            salud -= golpe;
        System.out.println(nombre + " recibe " + golpe + " de daño.");
        }
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
        int daño = ataque * dado.tirarDado();
        oc.recibirDaño(daño);
        xp += 10;
    }

    @Override
    public void atacarCaba(Caballero cb) {
        System.out.println(nombre + " ataca!");
        int daño = ataque * dado.tirarDado();
        cb.recibirDaño(daño);
        xp += 10;
    }
    
}
