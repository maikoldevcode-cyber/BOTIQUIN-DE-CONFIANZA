public class Cola {
    private Nodo frente;
    private Nodo final_;


    public Cola() {
        this.frente = null;
        this.final_ = null;
    }

  

    public void encolar(Medicamento medicamneto_nuevo) {
        Nodo nuevo = new Nodo(medicamneto_nuevo);
        if (this.frente == null && this.final_ == null) {
            this.frente = nuevo;
            this.final_ = nuevo;
        } else {
          
            final_.setSiguiente(nuevo);
            nuevo.setAnterior(final_);
            final_ = nuevo;

        }

        

    }

    public Nodo desencolar (){
        Nodo iterador = frente;
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
            Nodo iterador = frente;

            if (iterador == null) {
                System.out.println("la lista esta vacia");
            }else{
                while (iterador != null) {
                    iterador.Info();
                    
                    iterador = iterador.getSiguiente();
                    
                }
            }

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