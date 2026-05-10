/**
 * Clase Nodo - Representa un nodo en una lista doblemente enlazada.
 * Cada nodo contiene: un medicamento, referencia al nodo anterior y al siguiente.
 */
public class Nodo {
    // ATRIBUTOS QUE DEFINEN LA ESTRUCTURA DE LISTA DOBLEMENTE ENLAZADA
    private Nodo anterior;                  // Referencia al nodo anterior en la lista
    private Nodo siguiente;                 // Referencia al nodo siguiente en la lista
    private Medicamento medicamento;        // El medicamento almacenado en este nodo

    /**
     * Constructor 1: Nodo vacio
     * Crea un nodo sin medicamento (usado en casos especiales)
     */
    public Nodo() {
        this.medicamento = null;    // No hay medicamento
        this.anterior = null;       // No hay nodo anterior
        this.siguiente = null;      // No hay nodo siguiente
    }

    /**
     * Constructor 2: Nodo con medicamento (el mas usado)
     * Crea un nodo que contiene un medicamento especifico
     * 
     * @param medicamento - El medicamento a almacenar (NO puede ser null)
     * @throws IllegalArgumentException - Si el medicamento es null
     */
    public Nodo(Medicamento medicamento) {
        // Validacion: el medicamento recibido NO puede ser null
        // Si es null, lanzamos una excepcion que DETIENE la creacion del nodo
        // throw: dispara una excepcion que fuerza al codigo que llama a manejarla o fallar
        if (medicamento == null) {
            throw new IllegalArgumentException("Medicamento no puede ser nulo");
        }
        this.medicamento = medicamento;
        this.anterior = null;       // Al crear, no hay otros nodos conectados
        this.siguiente = null;      // Al crear, no hay otros nodos conectados
    }

    /**
     * Info() - Metodo para imprimir informacion del nodo
     * Verifica si hay medicamento y lo imprime, o muestra que el nodo esta vacio
     * if != null: comprueba si el medicamento NO es null
     */
    public void Info() {
        if (medicamento != null) {
            // Si existe medicamento, llama a toString() para imprimir su informacion
            System.out.println(medicamento.toString());
        } else {
            // Si NO existe medicamento, imprime un mensaje indicando nodo vacio
            System.out.println("Nodo vacío");
        }
    }

    // ========== GETTERS (Lectores) - Permiten acceder a los atributos privados ==========

    /**
     * Getter del nodo anterior
     * @return el Nodo anterior en la lista, o null si este es el primer nodo
     */
    public Nodo getAnterior() {
        return anterior;
    }

    /**
     * Setter del nodo anterior
     * Conecta este nodo con otro nodo que ira ANTES de el en la lista
     * @param anterior - El nodo que sera anterior a este
     */
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    /**
     * Getter del nodo siguiente
     * @return el Nodo siguiente en la lista, o null si este es el ultimo nodo
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * Setter del nodo siguiente
     * Conecta este nodo con otro nodo que ira DESPUES de el en la lista
     * @param siguiente - El nodo que sera siguiente a este
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Getter del medicamento
     * @return el Medicamento almacenado en este nodo
     */
    public Medicamento getMedicamento() {
        return medicamento;
    }

    /**
     * Setter del medicamento
     * Reemplaza el medicamento de este nodo por otro
     * 
     * @param medicamento - El nuevo medicamento (NO puede ser null)
     * @throws IllegalArgumentException - Si el medicamento es null
     */
    public void setMedicamento(Medicamento medicamento) {
        if (medicamento == null) {
            throw new IllegalArgumentException("Medicamento no puede ser nulo");
        }
        this.medicamento = medicamento;
    }
}
