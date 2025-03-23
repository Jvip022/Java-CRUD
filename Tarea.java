//package logica;

//Clase  Objeto Tarea
    public class Tarea{
        private String nombre;
        private boolean estado;

        //sets an gets

        public void setNombre(String pnombre){
            nombre=pnombre;
        }
        public String getNombre(){
            return nombre;
        }

        public void setEstado(boolean pestado){
            estado=pestado;
        }
        public boolean getEstado(){
            return estado;
        }


        public Tarea(){
            String nombre="";
            boolean estado=false;
        }

        public Tarea(String pnombre,boolean pestado){
            String nombre=pnombre;
            boolean estado=pestado;
        }
    }