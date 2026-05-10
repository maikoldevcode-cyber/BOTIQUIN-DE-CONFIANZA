/**
 * Clase Medicamento
 * Representa un medicamento individual con sus atributos: nombre, fecha de vencimiento y dosificación.
 * Esta clase valida todos los datos de entrada para garantizar consistencia.
 */
public class Medicamento {
    // Atributos encapsulados (privados) para cumplir con el principio de encapsulamiento
    private String nombre;                  // Nombre del medicamento (ej: "Dolex", "Amoxicilina")
    private String fecha_vencimiento;       // Fecha de vencimiento (formato: "YYYY-MM")
    private int miligramos;                 // Dosificación en miligramos (ej: 500, 250, 100)

    /**
     * Constructor de Medicamento
     * Valida todos los parámetros ANTES de asignarlos (constructor defensivo)
     * 
     * @param nombre - El nombre del medicamento. NO puede ser nulo ni vacío (ni espacios en blanco)
     * @param fecha_vencimiento - La fecha de vencimiento. NO puede ser nula
     * @param miligramos - La dosificación en mg. DEBE ser positivo (> 0)
     * 
     * @throws IllegalArgumentException - Si algún parámetro no cumple las validaciones
     */
    public Medicamento(String nombre, String fecha_vencimiento, int miligramos) {
        // === VALIDACIÓN 1: Verificar que el nombre no sea null ni vacío ===
        // nombre == null: comprueba si la variable es null (referencia vacía)
        // nombre.trim().isEmpty(): 
        //   - trim() ELIMINA espacios en blanco al inicio y final de un String
        //     Ejemplo: "  Dolex  " se convierte en "Dolex"
        //   - isEmpty() devuelve TRUE si el String tiene longitud 0
        //     Ejemplo: "".isEmpty() = true,  "Dolex".isEmpty() = false
        // Esto impide nombres vacíos, null o solo espacios
        if (nombre == null || nombre.trim().isEmpty()) {
            // throw: lanza (dispara) una excepción que DETIENE la ejecución
            // IllegalArgumentException: excepción de Java que indica un argumento inválido
            // Se usa cuando un parámetro recibido no cumple las restricciones de la función
            throw new IllegalArgumentException("Nombre no puede ser nulo o vacío");
        }
        
        // === VALIDACIÓN 2: Verificar que la fecha no sea null ===
        if (fecha_vencimiento == null) {
            throw new IllegalArgumentException("Fecha de vencimiento no puede ser nula");
        }
        
        // === VALIDACIÓN 3: Verificar que miligramos sea positivo ===
        // miligramos <= 0: rechaza ceros y números negativos
        if (miligramos <= 0) {
            throw new IllegalArgumentException("Miligramos deben ser positivos");
        }
        
        // Solo si TODAS las validaciones pasaron, se asignan los valores
        this.nombre = nombre;
        this.fecha_vencimiento = fecha_vencimiento;
        this.miligramos = miligramos;
    }

    /**
     * toString() - Convierte el objeto Medicamento a una representación String
     * @Override: anotación que indica que se está reemplazando el método de la clase Object
     * Útil para imprimir información legible del medicamento
     * 
     * @return Un String con formato: "Medicamento [nombre=..., fecha_vencimiento=..., miligramos=...]"
     */
    @Override
    public String toString() {
        return "Medicamento [nombre=" + nombre + ", fecha_vencimiento=" + fecha_vencimiento + ", miligramos=" + miligramos + "]";
    }

    /**
     * Getter (obtener) para el nombre
     * Los getters permiten LEER el atributo privado sin modificarlo
     * @return el nombre del medicamento
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter (establecer) para el nombre
     * Los setters permiten MODIFICAR atributos privados, pero con validaciones
     * Esto es más seguro que permitir acceso directo al atributo
     * 
     * @param nombre - El nuevo nombre (debe pasar las mismas validaciones del constructor)
     * @throws IllegalArgumentException - Si el nombre es null, vacío o solo espacios
     */
    public void setNombre(String nombre) {
        // Misma validación que en el constructor: no null, no vacío, no espacios
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    /**
     * Getter para la fecha de vencimiento
     * @return la fecha de vencimiento del medicamento
     */
    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    /**
     * Setter para la fecha de vencimiento
     * @param fecha_vencimiento - La nueva fecha (no puede ser null)
     * @throws IllegalArgumentException - Si la fecha es null
     */
    public void setFecha_vencimiento(String fecha_vencimiento) {
        if (fecha_vencimiento == null) {
            throw new IllegalArgumentException("Fecha de vencimiento no puede ser nula");
        }
        this.fecha_vencimiento = fecha_vencimiento;
    }

    /**
     * Getter para los miligramos
     * @return la dosificación en miligramos
     */
    public int getMiligramos() {
        return miligramos;
    }

    /**
     * Setter para los miligramos
     * @param miligramos - La nueva dosificación (debe ser positiva, > 0)
     * @throws IllegalArgumentException - Si miligramos es <= 0
     */
    public void setMiligramos(int miligramos) {
        if (miligramos <= 0) {
            throw new IllegalArgumentException("Miligramos deben ser positivos");
        }
        this.miligramos = miligramos;
    }
}