public class Nodo {
    private Nodo anterior;
    private Nodo siguiente;
    private Medicamento medicamento;

    public Nodo(){
        this.medicamento = new Medicamento(null, null, 0);
        this.anterior = null;
        this.siguiente = null;
    }

    public Nodo (Medicamento medicamento){
        this.medicamento = medicamento;
        this.anterior = null;
        this.siguiente = null;
    }
    //si tengo nullpoiner entonces agrgar
    //  el constructor que espere un parametro

    public void Info(){
      System.out.println("es aqui"+medicamento.toString());  
    }
    
   

    public Nodo getAnterior() {
        return anterior;
    }
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    public Nodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    public Medicamento getMedicamento() {
        return medicamento;
    }
    
    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

}
