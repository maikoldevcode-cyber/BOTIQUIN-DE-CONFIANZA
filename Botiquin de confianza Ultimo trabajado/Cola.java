public class Cola {
    private Nodo frente;
    private Nodo final_;

    public Cola() {
        this.frente = null;
        this.final_ = null;
    }

    public void encolar(Medicamento medicamento_nuevo) {
        if (medicamento_nuevo == null) {
            throw new IllegalArgumentException("No se puede encolar un medicamento nulo");
        }
        Nodo nuevo = new Nodo(medicamento_nuevo);
        if (this.frente == null && this.final_ == null) {
            this.frente = nuevo;
            this.final_ = nuevo;
        } else {
            final_.setSiguiente(nuevo);
            nuevo.setAnterior(final_);
            final_ = nuevo;
        }
    }

    public Medicamento desencolar() {
        if (this.frente == null && this.final_ == null) {
            System.out.println("La cola está vacía, no hay nada que eliminar");
            return null;
        }
        Nodo nodoRemovido = frente;
        if (frente == final_) {
            frente = null;
            final_ = null;
        } else {
            frente = frente.getSiguiente();
            frente.setAnterior(null);
        }
        return nodoRemovido.getMedicamento();
    }

    public void imprimir() {
        Nodo iterador = frente;
        if (iterador == null) {
            System.out.println("La cola está vacía");
        } else {
            System.out.println("Contenido de la cola:");
            while (iterador != null) {
                System.out.println(iterador.getMedicamento().toString());
                iterador = iterador.getSiguiente();
            }
        }
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public Nodo getFrente() {
        return frente;
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    public Nodo getFinal_() {
        return final_;
    }

    public void setFinal_(Nodo final_) {
        this.final_ = final_;
    }
}