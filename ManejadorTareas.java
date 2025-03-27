import java.util.Iterator;

import javax.print.DocFlavor.STRING;
import javax.swing.JOptionPane;

import java.util.ArrayList;

public class ManejadorTareas {

    private ArrayList<Tarea> lista;
    private Tarea tarea;

    // sets and gets

    public void setLista(ArrayList<Tarea> plista) {
        this.lista = plista;
    }

    public ArrayList<Tarea> getLista() {
        return lista;
    }

    public void setTarea(Tarea ptarea) {
        this.tarea = ptarea;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public ManejadorTareas() {
        this.lista = new ArrayList<Tarea>();
    }

    // Metodos CRUD

    public String agregarTarea(String nombre, boolean estado) {
        
        tarea = new Tarea();
        
        tarea.setEstado(estado);
        tarea.setNombre(nombre);
        this.lista.add(tarea);
        if (this.lista.isEmpty()==false)return "SE Agrego EXITOSAMENTE";

        return "Error";
    }

    public String borrarTarea(String nombreTarea) {
        Iterator<Tarea> tareaIterator = lista.iterator();
        while (tareaIterator.hasNext()) {
            Tarea tarea = tareaIterator.next();
             if(tarea.getNombre().equals(nombreTarea)) {
                tareaIterator.remove(); // Esto eliminará elemento correctamente
                return "SE BORRO EXITOSAMENTE";
            } else {
                return "No SE BORRO El Elemento";
            }
        }
        return "Error";
    }

    public String editarTarea(ArrayList<Tarea> plista, String buscar, String nuevoNombre, boolean nuevoEstado) {
        
        if (plista.isEmpty() == true) {
            return "La lista esta Vacia";
        } else {
            try {
                Iterator<Tarea> tareaIterator = plista.iterator();
                while (tareaIterator.hasNext()) {
                    Tarea tarea = tareaIterator.next();
                    if (tarea.getNombre().equals(buscar)) {
                        int indice = plista.indexOf(tarea);
                        if (indice != -1) {
                            plista.set(indice, (new Tarea(nuevoNombre, nuevoEstado)));
                            return "El elemento se Actualizo";
                        } else if (!tareaIterator.hasNext()) {
                            return "El elemento no se encontró en la lista.";
                        }
                    }
                }

            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return "Error";
    }

    public String mostrarTareaTerminada() {
        Iterator<Tarea> tareaIterator = lista.iterator();
        ArrayList<Tarea> auxT = new ArrayList<Tarea>();
        ArrayList<Tarea> auxP = new ArrayList<Tarea>();
        while (tareaIterator.hasNext()) {
            Tarea tarea = tareaIterator.next();
            if (tarea.getEstado() == true) {
                auxT.add(tarea);
            } else {
                auxP.add(tarea);
            }
        }

        // iterar
        Iterator<Tarea> auxTIterator = auxT.iterator();
        Iterator<Tarea> auxPIterator = auxP.iterator();
        while (auxTIterator.hasNext() || auxPIterator.hasNext()) {

            if (auxTIterator.hasNext()) {
                Tarea tarea = auxTIterator.next();
                return "El nombre de la tarea es " + tarea.getNombre() + " esta tarea esta Terminada\n";
            }
            if (auxPIterator.hasNext()) {
                Tarea tarea = auxPIterator.next();
                return "El nombre de la tarea es " + tarea.getNombre() + " esta tarea esta sin Terminar\n";
            }

        }
        return "Error";
    }
}