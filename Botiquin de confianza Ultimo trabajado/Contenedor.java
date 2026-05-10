public class Contenedor {
    private int capacidad = 1;
    private int longitud;
    private int num;
    private Lote[] contenedor = new Lote[capacidad];

    public int crecer_contenedor() {
        if (capacidad <= 0) {
            throw new IllegalStateException("Capacidad inválida");
        }
        Lote[] contenedor_nuevo = new Lote[contenedor.length * 2];
        for (int i = 0; i < contenedor.length; i++) {
            contenedor_nuevo[i] = contenedor[i];
        }
        contenedor = contenedor_nuevo;
        setCapacidad(contenedor.length);
        System.out.println("El contenedor creció y su capacidad es de: " + getCapacidad());
        setLongitud(num);
        return getLongitud();
    }

    public int Crear_Nuevo_Lote() {
        if (num >= capacidad) {
            throw new IllegalStateException("No hay espacio para crear nuevo lote");
        }
        contenedor[num] = new Lote();
        System.out.println("Se creó un nuevo lote en posición " + num);
        num++;
        setLongitud(num);
        return num - 1; // Retorna el índice del lote creado
    }

    public int crear_y_crecer_si_es_necesario() {
        if (num == capacidad) {
            System.out.println("El contenedor está lleno, hagámoslo crecer");
            crecer_contenedor();
        }
        return Crear_Nuevo_Lote();
    }

    public void agregar_cola_a_lote(int posicion) {
        if (posicion < 0 || posicion >= num) {
            throw new IndexOutOfBoundsException("Posición de lote inválida: " + posicion);
        }
        contenedor[posicion].crear_NuevaCola();
    }

    public void Agregar_Medicamento_A_Cola_Desde_Contenedor(int posicion, int indice, Medicamento medicamento_nuevo) {
        if (posicion < 0 || posicion >= num) {
            throw new IndexOutOfBoundsException("Posición de lote inválida: " + posicion);
        }
        if (medicamento_nuevo == null) {
            throw new IllegalArgumentException("Medicamento no puede ser nulo");
        }
        contenedor[posicion].agregarMedicamentoACola(indice, medicamento_nuevo);
    }

    public void imprimir_contenedor() {
        if (num == 0) {
            System.out.println("El contenedor está vacío");
            return;
        }
        for (int i = 0; i < num; i++) {
            System.out.println("--- Lote " + i + " ---");
            contenedor[i].imprimir_Listas();
        }
    }

    public Lote getLote(int posicion) {
        if (posicion < 0 || posicion >= num) {
            throw new IndexOutOfBoundsException("Posición de lote inválida: " + posicion);
        }
        return contenedor[posicion];
    }

    public int getNumLotes() {
        return num;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("Capacidad debe ser positiva");
        }
        this.capacidad = capacidad;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
}
