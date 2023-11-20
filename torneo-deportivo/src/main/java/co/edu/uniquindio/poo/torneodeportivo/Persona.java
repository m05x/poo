package co.edu.uniquindio.poo.torneodeportivo;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
public class Persona {
    private final String nombre;
    private final String apellido;
    private final String email;
    private final String celular;
    private final Genero genero;
    public Persona(String nombre,String apellido,String email, String celular,Genero genero){
        ASSERTION.assertion( nombre != null && !nombre.isBlank() , "El nombre es requerido");
        ASSERTION.assertion( apellido != null && !apellido.isBlank() , "El apellido es requerido");
        ASSERTION.assertion( celular != null && !celular.isBlank() , "El celular es requerido");
        ASSERTION.assertion( email != null && !email.isBlank() , "El email es requerido");
        ASSERTION.assertion( genero != null , "El género es requerido");    
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
        this.genero=genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getCelular() {
        return celular;
    }
    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        ASSERTION.assertion(genero != null, "El género es requerido");
    }
}
