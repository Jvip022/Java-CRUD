import java.util.Iterator;
import java.util.ArrayList;
public class ManejadorTareas {

    private ArrayList<Tarea> lista;
    private Tarea tarea;


    //sets and gets 

    public void setLista(ArrayList<Tarea> plista){
            lista=plista;
        }
    public ArrayList<Tarea> getLista(){
        return lista;
    }

    public void setTarea(Tarea ptarea){
            tarea=ptarea;
        }
    public Tarea getTarea(){
        return tarea;
    }



    public ManejadorTareas(){
       lista = new ArrayList<Tarea>();
    }

    // Metodos CRUD

    public void agregarTarea(String nombre,boolean estado){
        tarea = new Tarea();
        tarea.setEstado(estado);tarea.setNombre(nombre);
        lista.add(tarea);
    }

    public void borrarTarea(String nombreTarea){
        Iterator<Tarea> tareaIterator = lista.iterator();
        while (tareaIterator.hasNext()) {
            Tarea tarea = tareaIterator.next();
            if (tarea.getNombre().equals(nombreTarea)) {
                tareaIterator.remove(); // Esto eliminará el gato correctamente
                System.out.println("SE BORRO EXITOSAMENTE");
            }
        }
    }
    
    public void editarTarea(ArrayList<Tarea> lista, Tarea buscar, Tarea tareaActualizada) {
        int indice = lista.indexOf(buscar);
        if (indice != -1) {
            lista.set(indice, tareaActualizada);
        } else {
            System.out.println("El elemento no se encontró en la lista.");
        }
    }  

    public void mostrarTareaTerminada (){
        Iterator<Tarea> tareaIterator = lista.iterator();
        ArrayList<Tarea> auxT= new ArrayList<Tarea>();
        ArrayList<Tarea> auxP= new ArrayList<Tarea>();
        while (tareaIterator.hasNext()) {
            Tarea tarea = tareaIterator.next();
            if (tarea.getEstado()==true) {
                auxT.add(tarea);
            }else{
                auxP.add(tarea);
            }
        }


        //iterar
        Iterator<Tarea> auxTIterator = auxT.iterator();
        Iterator<Tarea> auxPIterator = auxP.iterator();
        while (auxTIterator.hasNext()||auxPIterator.hasNext()) {

            if(auxTIterator.hasNext()){
                Tarea tarea = auxTIterator.next();
                System.out.print("El nombre de la tarea es "+tarea.getNombre()+" esta tarea esta Terminada\n");
            }
            if(auxPIterator.hasNext()){
                Tarea tarea = auxPIterator.next();
                System.out.print("El nombre de la tarea es "+tarea.getNombre()+" esta tarea esta sin Terminar\n");
            }
            
        }
    }
}