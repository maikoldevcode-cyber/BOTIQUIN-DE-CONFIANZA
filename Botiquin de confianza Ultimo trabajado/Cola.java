public class Cola {
    private Medicamento frente;
    private Medicamento final_;
    // final Lote lote = new Lote();

    public Cola() {
        this.frente = null;
        this.final_ = null;
    }

  

    public void encolar(Medicamento nuevo) {
        if (this.frente == null && this.final_ == null) {
            this.frente = nuevo;
            this.final_ = nuevo;
        } else {
            while (final_.getSiguiente() != null) {
                final_ = final_.getSiguiente();

            }
            final_.setSiguiente(nuevo);
            nuevo.setAnterior(final_);
            final_ = nuevo;

        }

        

    }

    public Medicamento desencolar (){
        Medicamento iterador = frente;
        if (this.frente == null && this.final_ == null) {
            System.out.println("no hay nada que eliminar");
        }else{
            if (frente== final_) {
                frente = null;
                final_ =null;
                
            }
            else{
                frente = frente.getSiguiente();
                iterador.setSiguiente(null);
                frente.setAnterior(null);
            }
        }
        return iterador;
    }

        public void imprimir(){
            Medicamento iterador = frente;

            if (iterador == null) {
                System.out.println("la lista esta vacia");
            }else{
                while (iterador != null) {
                    System.out.println(iterador.getNombre()+iterador.getMiligramos());
                    iterador = iterador.getSiguiente();
                    
                }
            }

        }

    public Medicamento getFrente() {
        return frente;
    }

    public void setFrente(Medicamento frente) {
        this.frente = frente;
    }

    public Medicamento getFinal_() {
        return final_;
    }

    public void setFinal_(Medicamento final_) {
        this.final_ = final_;
    }
}