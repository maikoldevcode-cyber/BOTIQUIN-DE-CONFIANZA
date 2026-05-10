public class Lote {

    private int capacidad = 10;
    private int tamaño = 0;
    private Cola[] lote = new Cola[capacidad];

    public int getTamaño() {
        return tamaño;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setTamaño(int tamaño) {
        if (tamaño < 0) {
            throw new IllegalArgumentException("Tamaño no puede ser negativo");
        }
        this.tamaño = tamaño;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("Capacidad debe ser positiva");
        }
        this.capacidad = capacidad;
    }

    private void crecer() {
        Cola[] loteNuevo = new Cola[lote.length * 2];
        for (int i = 0; i < lote.length; i++) {
            loteNuevo[i] = lote[i];
        }
        lote = loteNuevo;
        setCapacidad(lote.length);
        System.out.println("\nEl lote creció. Nueva capacidad: " + capacidad);
    }

    public int crear_NuevaCola() {
        if (tamaño == capacidad) {
            crecer();
        }
        lote[tamaño] = new Cola();
        System.out.println("Se agregó una nueva cola en el índice " + tamaño);
        setTamaño(tamaño + 1);
        return tamaño - 1; // Retorna el índice de la cola creada
    }

    public void agregarMedicamentoACola(int indice, Medicamento medicamento) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice de cola inválido: " + indice);
        }
        if (medicamento == null) {
            throw new IllegalArgumentException("Medicamento no puede ser nulo");
        }
        lote[indice].encolar(medicamento);
        System.out.println("Medicamento agregado a la cola " + indice);
    }

    public void imprimir_Listas() {
        if (tamaño == 0) {
            System.out.println("El lote no tiene colas");
            return;
        }
        for (int i = 0; i < tamaño; i++) {
            System.out.println("Cola " + i + ":");
            lote[i].imprimir();
        }
    }

    public Medicamento eliminarMedicamentoACola(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice de cola inválido: " + indice);
        }
        return lote[indice].desencolar();
    }

    public Cola getCola(int indice) {
        if (indice < 0 || indice >= tamaño) {
            throw new IndexOutOfBoundsException("Índice de cola inválido: " + indice);
        }
        return lote[indice];
    }
}