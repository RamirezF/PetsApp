package app.android.frisco.petsapp.clases;

public class Pet {
    private long id;
    private String nombre;
    private String raza;
    private String edad;
    private String imagen;

    public Pet() {
    }

    public Pet(String nombre, String raza, String edad, String imagen) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.imagen = imagen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
