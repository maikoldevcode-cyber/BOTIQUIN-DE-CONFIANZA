/**
 * Clase Lote
 * Representa un grupo de colas de medicamentos, agrupados por tipo de medicina.
 * Por ejemplo: un Lote puede contener varias Colas de Dolex (500mg, 250mg, 100mg)
 * 
 * Estructura:
 * Lote = Array dinamico de Colas
 * Cada Cola contiene medicamentos del mismo tipo y dosificacion
 */
public class Lote {

    private int capacidad = 10;     // Capacidad inicial del array de colas
    private int tamaño = 0;         // Cantidad de colas actualmente creadas
    private Cola[] lote = new Cola[capacidad];  // Array dinamico de colas


    /**
     * Getter: obtiene el numero de colas activas en este lote
     * @return el numero de colas creadas (no la capacidad total)
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * Getter: obtiene la capacidad total del lote
     * @return la capacidad actual del array
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Setter: establece el tamaño del lote
     * Valida que no sea negativo
     * 
     * @param tamaño - El nuevo tamaño
     * @throws IllegalArgumentException - Si tamaño < 0
     */
    public void setTamaño(int tamaño) {
        if (tamaño < 0) {
            throw new IllegalArgumentException("Tamaño no puede ser negativo");
        }
        this.tamaño = tamaño;
    }

    /**
     * Setter: establece la capacidad del lote
     * Valida que sea positivo
     * 
     * @param capacidad - La nueva capacidad
     * @throws IllegalArgumentException - Si capacidad <= 0
     */
    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("Capacidad debe ser positiva");
        }
        this.capacidad = capacidad;
    }

    /**
     * CRECER (private) - Duplica la capacidad del array de colas
     * Este metodo es PRIVADO porque solo la clase decide cuando crecer,
     * no el usuario externo
     * 
     * Proceso:
     * 1. Crea un array nuevo con el DOBLE de capacidad
     * 2. Copia todos los elementos del array viejo al nuevo
     * 3. Reemplaza el array viejo por el nuevo
     * 4. Actualiza la variable capacidad
     */
    private void crecer() {
        Cola[] loteNuevo = new Cola[lote.length * 2];  // Duplica capacidad
        // for: itera sobre todos los elementos del array viejo
        for (int i = 0; i < lote.length; i++) {
            loteNuevo[i] = lote[i];  // Copia cada cola al nuevo array
        }
        lote = loteNuevo;  // Reemplaza el array viejo
        setCapacidad(lote.length);  // Actualiza la capacidad
        System.out.println("\nEl lote creció. Nueva capacidad: " + capacidad);
    }

    /**
     * CREAR_NUEVACOLA - Crea una nueva cola en este lote
     * Crece el lote automaticamente si ya esta lleno
     * 
     * @return el indice (posicion) de la cola creada
     */
    public int crear_NuevaCola() {
        // if: verifica si el lote esta LLENO
        // tamaño == capacidad: significa que todos los espacios estan ocupados
        if (tamaño == capacidad) {
            crecer();  // Duplica la capacidad del lote
        }
        lote[tamaño] = new Cola();  // Crea una nueva cola vacía en la posicion 'tamaño'
        System.out.println("Se agregó una nueva cola en el indice " + tamaño);
        setTamaño(tamaño + 1);  // Incrementa el contador de colas
        return tamaño - 1;  // Retorna el indice de la cola que se acaba de crear
    }

    /**
     * AGREGARMEDICAMENTOACOLA - Agrega un medicamento a una cola especifica
     * Valida tanto el indice como el medicamento ANTES de operarlo
     * 
     * @param indice - La posicion de la cola (debe ser 0 <= indice < tamaño)
     * @param medicamento - El medicamento a agregar (NO puede ser null)
     * @throws IndexOutOfBoundsException - Si indice esta fuera de rango
     * @throws IllegalArgumentException - Si medicamento es null
     */
    public void agregarMedicamentoACola(int indice, Medicamento medicamento) {
        // VALIDACION 1: Verificar que el indice sea valido
        // indice < 0: indice negativo es invalido
        // indice >= tamaño: indice mayor o igual al tamaño es invalido (se sale del array)
        // ||: operador OR logico - si CUALQUIERA de las condiciones es true, entra
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Indice de cola invalido: " + indice);
        }
        
        // VALIDACION 2: Verificar que el medicamento no sea null
        if (medicamento == null) {
            throw new IllegalArgumentException("Medicamento no puede ser nulo");
        }
        
        // Si pasamos ambas validaciones, encolamos el medicamento
        lote[indice].encolar(medicamento);
        System.out.println("Medicamento agregado a la cola " + indice);
    }

    /**
     * IMPRIMIR_LISTAS - Imprime todas las colas activas en este lote
     */
    public void imprimir_Listas() {
        if (tamaño == 0) {
            System.out.println("El lote no tiene colas");
            return;
        }
        // for: itera sobre todas las colas ACTIVAS (solo tamaño, no capacidad)
        for (int i = 0; i < tamaño; i++) {
            System.out.println("Cola " + i + ":");
            lote[i].imprimir();  // Imprime el contenido de cada cola
        }
    }

    /**
     * ELIMINARMEDICAMENTOACOLA - Elimina el primer medicamento (mas antiguo) de una cola
     * Valida que el indice sea valido antes de operar
     * 
     * @param indice - La posicion de la cola
     * @return El Medicamento que fue eliminado, o null si la cola esta vacia
     * @throws IndexOutOfBoundsException - Si indice esta fuera de rango
     */
    public Medicamento eliminarMedicamentoACola(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Indice de cola invalido: " + indice);
        }
        return lote[indice].desencolar();
    }

    /**
     * GETCOLA - Obtiene una cola especifica del lote
     * 
     * @param indice - La posicion de la cola
     * @return La Cola en esa posicion
     * @throws IndexOutOfBoundsException - Si indice esta fuera de rango
     */
    public Cola getCola(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Indice de cola invalido: " + indice);
        }
        return lote[indice];
    }
}