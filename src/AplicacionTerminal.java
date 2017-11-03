import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class AplicacionTerminal
{
    private Agenda agenda;
    public AplicacionTerminal()
    {
        agenda = new Agenda();
    }

    public void demo()
    {
        Contacto c1 = new Contacto("Fernando", "UASLP Ingenieria", 4443165534L);
        Contacto c2 = new Contacto("Malena", "UASLP", 4442245609L);
        Contacto c3 = new Contacto("Victor", "Ingenieria", 4443219076L);
        //Agenda agenda = new Agenda();
        agenda.agregaContacto(c1);
        agenda.agregaContacto(c2);
        agenda.agregaContacto(c3);
        agenda.imprimeTodo();
    }
    public void entradaUsuario()
    {
        Scanner entrada = new Scanner(System.in);
        String opcion = "";
        do
        {
            try{
                System.out.println("Opciones: Agregar// Eliminar //Imprimir // //Guardar //Cargar // Terminar");
                opcion = entrada.nextLine();
                switch(opcion)
                {
                    case "Agregar":
                        agregar(entrada);
                        opcion ="";
                        break;
                    case "Imprimir":
                        agenda.imprimeTodo();
                        break;
                    case "Guardar":
                        guardar(entrada);
                        break;
                    case "Cargar":
                        cargar(entrada);
                        break;
                    case "Eliminar":
                        eliminar(entrada);
                        break;
                }
            }
            catch (IllegalArgumentException ex)
            {
                System.out.println(ex.getMessage());
                opcion = "";
            }
            catch (InputMismatchException ex)
            {
                System.out.println("El numero telefoico debe tener digitos unicamente");
                opcion = "";
            }
            catch (FileNotFoundException ex)
            {
                System.out.println("El archivo no existe");
                opcion = "";
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
                opcion = "";

            }
        }while(!opcion.equals("Terminar"));
    }

    private void guardar(Scanner entrada) throws IOException
    {
        System.out.println("Nombre del archivo: ");
        String nomArch = entrada.nextLine();
        agenda.guardar(nomArch);
    }

    private void eliminar(Scanner entrada)
    {
        System.out.print("Dame el telefono del contacto a elimiar: ");
        long telEliminar = entrada.nextLong();
        agenda.eliminarContacto(telEliminar);
    }

    private void cargar(Scanner entrada) throws FileNotFoundException
    {
        System.out.println("Nombre del archvio");
        String nomArch = entrada.nextLine();
        agenda.cargar(nomArch);
    }

    private void agregar(Scanner entrada)
    {
        System.out.println("Agregar un nuevo contacto");
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Direccion: ");
        String direccion = entrada.nextLine();
        System.out.print("Telefono: ");
        long telefono = entrada.nextLong();
        Contacto nuevo = new  Contacto(nombre,direccion,telefono);
        agenda.agregaContacto(nuevo);
    }
    public static void main(String[] args)
    {
        AplicacionTerminal aplicacion = new AplicacionTerminal();
        aplicacion.demo();
        aplicacion.entradaUsuario();
    }
}