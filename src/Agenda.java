import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Agenda
{
    private LinkedList<Contacto> contactos;

    public Agenda()
    {
        contactos = new LinkedList<Contacto>();
    }

    public void agregaContacto(Contacto nuevo)
    {
        contactos.add(nuevo);
    }

    public void imprimeTodo()
    {
        /* for-tradicional
        int i;
        for(i = 0; i < contactos.size() ; i++);
        {
            System.out.println(contactos.get(i));
        }
        */

        //for-each
        //Sintaxis
        //for(Tipo var : coleccion)
        //{
        // acciones con la viable var
        //}
        for (Contacto c : contactos)
        {
            System.out.println(c);
        }
    }

    public void guardar(String s) throws IOException
    {
        FileWriter archivo = new FileWriter(s);
        for(Contacto c : contactos)
        {
            archivo.write(c.toString() + "\n");
        }
        archivo.close();
    }

    public void cargar(String nomArch) throws FileNotFoundException
    {
        Scanner archivo = new Scanner(new File(nomArch));
        while (archivo.hasNextLine())
        {
            String linea = archivo.nextLine();
            String[] arreglo = linea.split(",");
            long tel = Long.parseLong(arreglo[2].trim());
            Contacto nuevo = new Contacto(arreglo[0],arreglo[1],tel);
            contactos.add(nuevo);
        }
    }

    public void eliminarContacto(long telEliminar)
    {
        /*for (Contacto c: contactos)
        {
            if(telEliminar == dimeTel())
            {
                contactos.remove(c);
                break;
            }
        }*/

        //Un iterador es un objeto que permite accedar a los
        //elementos de una coleccion uno por uno

        Iterator<Contacto> it;

        //El iterador se inicializa por medio del metodo iterator()
        //de la coleccion

        it = contactos.iterator();

        //El iterador tiene tres metodos:
        //1.- next() - Regresa el siguiente elemento de la coleccion
        //2.- hasnext() - Verifica si todavia hay elementos en la coleccion
        //3.- remove() - elimina el elemento actual de la coleccion

        while (it.hasNext())
        {
            Contacto c =it.next();
            if(telEliminar == c.dimeTel())
            {
                it.remove();
            }
        }
    }
}
