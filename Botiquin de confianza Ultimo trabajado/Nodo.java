public class Nodo {
    private Nodo anterior;
    private Nodo siguiente;
    private Medicamento medicamento;

    public Nodo() {
        this.medicamento = null;
        this.anterior = null;
        this.siguiente = null;
    }

    public Nodo(Medicamento medicamento) {
        if (medicamento == null) {
            throw new IllegalArgumentException("Medicamento no puede ser nulo");
        }
        this.medicamento = medicamento;
        this.anterior = null;
        this.siguiente = null;
    }

    public void Info() {
        if (medicamento != null) {
            System.out.println(medicamento.toString());
        } else {
            System.out.println("Nodo vacío");
        }
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
        if (medicamento == null) {
            throw new IllegalArgumentException("Medicamento no puede ser nulo");
        }
        this.medicamento = medicamento;
    }
}
