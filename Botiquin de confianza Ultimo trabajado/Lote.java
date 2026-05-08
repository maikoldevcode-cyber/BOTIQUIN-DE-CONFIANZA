public class Lote {

    private int capacidad = 10;
    private int tamaño = 0;          // cantidad de colas activas (antes "indixe" y "longitud")
    private Cola[] lote = new Cola[capacidad];

    // --- Getters informativos ---
    public int getTamaño() {
        return tamaño;
    }

    public int getCapacidad() {
        return capacidad;
    }

    // --- Setters ---
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    // --- Privado: solo la clase decide cuándo crecer ---
    private void crecer() {
        Cola[] loteNuevo = new Cola[lote.length * 2];
        for (int i = 0; i < lote.length; i++) {
            loteNuevo[i] = lote[i];
        }
        lote = loteNuevo;
        setCapacidad(lote.length);
        System.out.println("\nEl lote creció. Nueva capacidad: " + capacidad);
    }

    // --- Crea una nueva Cola. Crece solo si está lleno ---
    public int crear_NuevaCola() {
        if (tamaño == capacidad) {   // ← condición correcta: lleno cuando tamaño llega a capacidad
            crecer();
        }
        lote[tamaño] = new Cola();
        System.out.println("Se agregó una nueva cola en el índice " + tamaño);
        setTamaño(tamaño + 1);
        return tamaño;
    }

    // --- Agrega un medicamento a una cola específica ---
    public Medicamento agregarMedicamentoACola(int indice, Medicamento medicamento) {
        lote[indice].encolar(medicamento);
        lote[indice].imprimir();
        return medicamento;
    }

    // --- Imprime todas las colas activas ---
    public void imprimir_Listas() {
        for (int i = 0; i < tamaño; i++) {   // ← usa tamaño, no capacidad
            lote[i].imprimir();
        }
    }

    // --- Elimina el primer medicamento de una cola específica ---
    public void eliminarMedicamentoACola(int indice) {
        lote[indice].desencolar();
    }
}