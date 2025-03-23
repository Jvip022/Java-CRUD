import logica.*;
import java.util.Scanner;
public class Inicio{

    public static void main(String[] args) {

        /*CrearCSV file=new CrearCSV();

        System.out.println("Inserte un nombre\n");
        Scanner in=new Scanner(System.in);
        String naombre=in.nextLine();
        String valor=in.nextLine();
        file.crearArchivoCSV("./files/archivo.csv",naombre,valor);


        
        
        
        //Scanner on=new Scanner(System.in);
        //boolean estado=true;//on.nextBoolean();
        //on.close();
        */
        
        String nombre="Comer";boolean estado=true;
        ManejadorTareas LMT=new ManejadorTareas();
        LMT.agregarTarea(nombre,estado);
        

        Tarea td=new Tarea();
        td.setNombre("Guitarra");td.setEstado(false);
        //LMT.getLista().add(td);
        LMT.agregarTarea(td.getNombre(),td.getEstado());
        System.out.println("Antes de Editar");
        LMT.mostrarTareaTerminada();
        Tarea tG=new Tarea();
        tG.setNombre("Formir");tG.setEstado(true);
        System.out.println("Despues de Editar");
        LMT.editarTarea(LMT.getLista(), LMT.getTarea(), tG);
        LMT.mostrarTareaTerminada();

        System.out.println("Despues de Borrar");
        LMT.borrarTarea("Formir");


        
        LMT.mostrarTareaTerminada();
        
        System.out.println("funciona");
        //in.close();
    }
}