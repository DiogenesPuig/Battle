package batalla;
// se arreglo errores de identacion
public class Dado {

    private int cantidadDeLados;

    public Dado(int cantidadDeLados) {
        this.cantidadDeLados = cantidadDeLados;
    }

    int tirarDado() {
        return (int) Math.floor(Math.random() * cantidadDeLados) + 1;
    }
    // se agregaron los getters,setters y toString que faltaban
    public int getCantidadDeLados() {
        return cantidadDeLados;
    }

    public void setCantidadDeLados(int cantidadDeLados) {
        this.cantidadDeLados = cantidadDeLados;
    }

    @Override 
    public String toString() {
        return "Dado{" + "cantidadDeLados=" + cantidadDeLados + '}';
    }
    
    
}
