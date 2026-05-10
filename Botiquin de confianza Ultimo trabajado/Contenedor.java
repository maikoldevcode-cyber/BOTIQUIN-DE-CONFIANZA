public class Contenedor {
    private int capacidad ;
    private int longitud;
    private int num;
    Lote contenedor[] = new Lote[capacidad];

    public int crecer_contenedor() {

        Lote[] contenedor_nuevo = new Lote[contenedor.length * 2];
        for (int i = 0; i < contenedor.length; i++) {
            contenedor_nuevo[i] = contenedor[i];
        }

        contenedor = contenedor_nuevo;
        setCapacidad(contenedor.length);
        System.out.println("el lote creció y su capacidad es de: " + getCapacidad());
        setLongitud(num);
        return getLongitud();
    }

    public int Crear_Nuevo_Lote() {

        contenedor[num] = new Lote();
        System.out.println("se creo un nuevo lote " + contenedor[num]);
        num++;
        setLongitud(num);

        return num;

    }

    public int crear_y_crecer_si_es_necesario() {

        if (num == capacidad) {
            System.out.println("el lote esta lleno hagamoslo crecer");
            crecer_contenedor();
        }
        Crear_Nuevo_Lote();
        return capacidad;
    }

    public void agregar_cola_a_lote(int posicion) {
        contenedor[posicion].crear_NuevaCola();
    }

    public void Agregar_Medicamento_A_Cola_Desde_Contenedor(int posicion, int indix, Medicamento medicamento_nuevo) {
        contenedor[posicion].agregarMedicamentoACola(indix, medicamento_nuevo);
    }

    public void imprimir_contenedor() {
        for (int i = 0; i < num; i++) {
            System.out.println("--- Lote " + i + " ---");
            contenedor[i].imprimir_Listas();
        }
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

}
