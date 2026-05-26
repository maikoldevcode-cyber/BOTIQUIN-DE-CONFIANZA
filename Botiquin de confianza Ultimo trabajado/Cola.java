/**
 * Clase Cola
 * Implementa una cola FIFO (First In First Out)
 * usando una lista doblemente enlazada con Nodos.
 */
public class Cola {
    private Nodo frente;    // Puntero al primer nodo (donde se SACAN medicamentos)
    private Nodo final_;    // Puntero al ultimo nodo (donde se AGREGAN medicamentos)

    /**
     * Constructor: Crea una cola vacia
     */
    public Cola() {
        this.frente = null;     // No hay primer medicamento
        this.final_ = null;     // No hay ultimo medicamento
    }

    /**
     * ENCOLAR - Agrega un medicamento al final de la cola
     * Este es el proceso de ENTRADA a la cola (por el final)
     * 
     * Pasos:
     * 1. Valida que el medicamento NO sea null
     * 2. Crea un nuevo Nodo con el medicamento
     * 3. Si la cola esta vacia, el nuevo nodo es frente Y final simultaneamente
     * 4. Si la cola tiene elementos, lo agrega al final y actualiza punteros
     * 
     * @param medicamento_nuevo - El medicamento a agregar (NO puede ser null)
     * @throws IllegalArgumentException - Si el medicamento es null
     */
    public void encolar(Medicamento medicamento_nuevo) {
        // throw: lanza una excepcion que DETIENE la ejecucion
        // IllegalArgumentException: indica que un argumento pasado es invalido
        if (medicamento_nuevo == null) {
            throw new IllegalArgumentException("No se puede encolar un medicamento nulo");
        }
        
        Nodo nuevo = new Nodo(medicamento_nuevo);
        
        // if (A && B): verifica si AMBAS condiciones A y B son verdaderas
        // && es el operador AND logico en Java
        if (this.frente == null && this.final_ == null) {
            // CASO 1: Cola vacia - el nuevo nodo sera el unico elemento
            this.frente = nuevo;
            this.final_ = nuevo;
        } else {
            // CASO 2: Cola tiene elementos - agregamos al final
            final_.setSiguiente(nuevo);
            nuevo.setAnterior(final_);
            final_ = nuevo;
        }
    }

    /**
     * DESENCOLAR - Saca el primer medicamento de la cola (el mas antiguo)
     * Este es el proceso de SALIDA de la cola (por el frente)
     * FIFO: El que entro primero sale primero
     * 
     * @return El Medicamento que estaba en el frente, o null si la cola esta vacia
     */
    public Medicamento desencolar() {
        // Verifica si la cola esta vacia
        if (this.frente == null && this.final_ == null) {
            System.out.println("La cola esta vacia, no hay nada que eliminar");
            return null;    // Retorna null para indicar que no habia nada
        }
        
        // Guarda el nodo que vamos a eliminar (para retornar su medicamento despues)
        Nodo nodoRemovido = frente;
        
        // Verifica si el nodo a eliminar es el UNICO en la cola
        // frente == final_: significa que hay solo un nodo
        if (frente == final_) {
            frente = null;
            final_ = null;
        } else {
            // Hay multiples nodos: avanza el frente al siguiente
            frente = frente.getSiguiente();
            frente.setAnterior(null);
        }
        
        // Retorna el medicamento del nodo que fue removido
        return nodoRemovido.getMedicamento();
    }

    /**
     * IMPRIMIR - Muestra todos los medicamentos en la cola
     * Recorre la lista desde el frente hasta el final imprimiendo cada uno
     */
    public void imprimir() {
        Nodo iterador = frente;     // Comenzamos en el frente
        
        if (iterador == null) {
            System.out.println("La cola esta vacia");
        } else {
            System.out.println("Contenido de la cola:");
            // while: se repite mientras la condicion sea verdadera
            // iterador != null: itera MIENTRAS no hayamos llegado al final
            while (iterador != null) {
                System.out.println(iterador.getMedicamento().toString());
                iterador = iterador.getSiguiente();  // Avanza al siguiente nodo
            }
        }
    }

    /**
     * ESTAVLJACIA - Verifica si la cola no tiene elementos
     * @return true si la cola esta vacia (frente es null), false si tiene elementos
     */
    public boolean estaVacia() {
        return frente == null;
    }

    // ========== GETTERS Y SETTERS PARA ACCESO CONTROLADO ==========

    /**
     * Getter: obtiene el nodo del frente
     * @return el Nodo que esta al frente de la cola
     */
    public Nodo getFrente() {
        return frente;
    }

    /**
     * Setter: establece el nodo del frente (uso interno)
     * @param frente - El nodo que sera el nuevo frente
     */
    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    /**
     * Getter: obtiene el nodo del final
     * @return el Nodo que esta al final de la cola
     */
    public Nodo getFinal_() {
        return final_;
    }

    /**
     * Setter: establece el nodo del final (uso interno)
     * @param final_ - El nodo que sera el nuevo final
     */
    public void setFinal_(Nodo final_) {
        this.final_ = final_;
    }
}