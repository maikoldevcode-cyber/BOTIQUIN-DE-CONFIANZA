import java.util.Scanner;
/**
 * Clase Contenedor
 * Representa el contenedor principal del botiquin que agrupa todos los Lotes.
 * Es el nivel mas alto de la estructura jerarquica.
 * 
 * Estructura:
 * Contenedor = Array dinamico de Lotes
 * Cada Lote agrupa Colas de medicamentos del mismo tipo
 * Cada Cola contiene medicamentos de la misma dosificacion
 */
public class Contenedor {
      Scanner sc  = new Scanner(System.in);

    private int capacidad = 1;          // Capacidad inicial del array de lotes
    private int longitud;               // Variable auxiliar para longitud
    private int num;                    // Contador de lotes actualmente creados
    private Lote[] contenedor = new Lote[capacidad];  // Array dinamico de lotes

    /**
     * CRECER_CONTENEDOR - Duplica la capacidad del array de lotes
     * Parecido a crecer() de Lote, pero para el contenedor principal
     * 
     * Proceso:
     * 1. Verifica que la capacidad sea valida (>0)
     * 2. Crea un array nuevo con el doble de capacidad
     * 3. Copia todos los lotes al nuevo array
     * 4. Reemplaza el array viejo por el nuevo
     * 
     * @return el tamaño actualizado (numero de lotes)
     * @throws IllegalStateException - Si la capacidad es invalida
     */
    public int crecer_contenedor() {
            
            if (capacidad <= 0) {
            // IllegalStateException: se lanza cuando el objeto esta en un estado invalido
            throw new IllegalStateException("Capacidad invalida");
        }
        Lote[] contenedor_nuevo = new Lote[contenedor.length * 2];  // Duplica
        for (int i = 0; i < contenedor.length; i++) {
            contenedor_nuevo[i] = contenedor[i];  // Copia cada lote
        }
        contenedor = contenedor_nuevo;
        setCapacidad(contenedor.length);
        System.out.println("El contenedor creció y su capacidad es de: " + getCapacidad());
        setLongitud(num);
        return getLongitud();
    }

    /**
     * CREAR_NUEVO_LOTE - Crea un nuevo lote vacío
     * Verifica que haya espacio antes de crear
     * 
     * @return el indice del lote creado
     * @throws IllegalStateException - Si no hay espacio (el contenedor esta lleno)
     */
    public int Crear_Nuevo_Lote() {
        if (num >= capacidad) {
            throw new IllegalStateException("No hay espacio para crear nuevo lote");
        }
        
        contenedor[num] = new Lote(sc.nextLine());

        System.out.println("Se creó un nuevo lote en posición " + num);
        System.out.println("Su nombre es: " + contenedor[num].getNombre());
        
        num++;
        setLongitud(num);
        return num - 1;  // Retorna el indice del lote creado
    }

    /**
     * CREAR_Y_CRECER_SI_ES_NECESARIO - Crea un lote nuevo, creciendo primero si necesario
     * Este es el metodo RECOMENDADO para usar cuando se necesita crear lotes
     * porque maneja automaticamente el crecimiento
     * 
     * @return el indice del nuevo lote creado
     */
    public int crear_y_crecer_si_es_necesario(String nombre) {
        if (num == capacidad) {
            System.out.println("El contenedor esta lleno, hagamoslo crecer");
            crecer_contenedor();
        }
        return Crear_Nuevo_Lote(nombre);
    }

    /**
     * AGREGAR_COLA_A_LOTE - Agrega una nueva cola a un lote especifico
     * Delega el trabajo al Lote (delega responsabilidades)
     * 
     * @param posicion - El indice del lote donde crear la cola
     * @throws IndexOutOfBoundsException - Si la posicion es invalida
     */
    public void agregar_cola_a_lote(int posicion) {
        if (posicion < 0 || posicion >= num) {
            throw new IndexOutOfBoundsException("Posición de lote invalida: " + posicion);
        }
        contenedor[posicion].crear_NuevaCola();
    }

    /**
     * AGREGAR_MEDICAMENTO_A_COLA_DESDE_CONTENEDOR - Agrega un medicamento a una cola especifica
     * Valida posicion e indice antes de operar
     * 
     * @param posicion - El indice del lote
     * @param indice - El indice de la cola dentro del lote
     * @param medicamento_nuevo - El medicamento a agregar
     * @throws IndexOutOfBoundsException - Si posicion es invalida
     * @throws IllegalArgumentException - Si medicamento es null
     */
    public void Agregar_Medicamento_A_Cola_Desde_Contenedor(int posicion, int indice, Medicamento medicamento_nuevo) {
        if (posicion < 0 || posicion >= num) {
            throw new IndexOutOfBoundsException("Posición de lote invalida: " + posicion);
        }
        if (medicamento_nuevo == null) {
            throw new IllegalArgumentException("Medicamento no puede ser nulo");
        }
        contenedor[posicion].agregarMedicamentoACola(indice, medicamento_nuevo);
    }

    /**
     * IMPRIMIR_CONTENEDOR - Imprime toda la estructura del botiquin
     * Muestra todos los lotes, colas y medicamentos
     */
    public void imprimir_contenedor() {
        if (num == 0) {
            System.out.println("El contenedor esta vacio");
            return;
        }
        for (int i = 0; i < num; i++) {
            System.out.println("--- Lote " + i + " ---");
            contenedor[i].imprimir_Listas();
        }
    }

    /**
     * GETLOTE - Obtiene un lote especifico
     * @param posicion - El indice del lote
     * @return el Lote en esa posicion
     * @throws IndexOutOfBoundsException - Si posicion es invalida
     */
    public Lote getLote(int posicion) {
        if (posicion < 0 || posicion >= num) {
            throw new IndexOutOfBoundsException("Posición de lote invalida: " + posicion);
        }
        return contenedor[posicion];
    }

    /**
     * GETNUMLOTES - Obtiene el numero de lotes creados
     * @return cantidad de lotes actualmente en el contenedor
     */
    public int getNumLotes() {
        return num;
    }

    /**
     * GETCAPACIDAD - Obtiene la capacidad total del contenedor
     * @return la capacidad del array (no el numero de lotes)
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * SETCAPACIDAD - Establece la capacidad del contenedor
     * @param capacidad - La nueva capacidad (debe ser > 0)
     * @throws IllegalArgumentException - Si capacidad <= 0
     */
    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("Capacidad debe ser positiva");
        }
        this.capacidad = capacidad;
    }

    /**
     * GETLONGITUD - Obtiene la longitud (variable auxiliar)
     * @return el valor de longitud
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * SETLONGITUD - Establece la longitud (variable auxiliar)
     * @param longitud - El nuevo valor de longitud
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
}
