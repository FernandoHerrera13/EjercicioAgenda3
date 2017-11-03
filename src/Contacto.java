public class Contacto
{
    private String nombre;
    private String direccion;
    private long telefono;

    public Contacto(String nombre, String direccion, long telefono)
    {
        if(nombre.isEmpty())
        {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if (nombre.charAt(0) >= 'a' && nombre.charAt(0) <= 'z'
                || nombre.charAt(0) >= 'A' && nombre.charAt(0) <= 'Z')
        {
            this.nombre = nombre;
        }
        else
        {
            throw new IllegalArgumentException("El nombre debe iniciar con una cadena");
        }
        if (direccion.isEmpty())
        {
            throw new IllegalArgumentException("La direccion no debe estar vacioa");
        }
        else
        {
            this.direccion = direccion;
        }

        String cadTel = Long.toString(telefono);
        if(cadTel.length() == 10)
        {
            this.telefono = telefono;
        }
        else
        {
            throw new IllegalArgumentException("El telefono debe tener 10 digitos");
        }
    }
    @Override
    public String toString()
    {
        return "NOMBRE: " + nombre + ", DIRECCION: " + direccion + ", TELEFONO: " + telefono;

    }

    public long dimeTel()
    {
        return telefono;
    }
}