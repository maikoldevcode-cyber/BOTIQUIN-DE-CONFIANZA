public class Principal {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO PRUEBAS DEL BOTIQUÍN ===\n");

        // Crear contenedor principal del botiquín
        Contenedor botiquin = new Contenedor();

        // ===== PRUEBA 1: CREACIÓN DE LOTES Y COLAS =====
        System.out.println("PRUEBA 1: Creación de lotes y colas");
        int lote0 = botiquin.crear_y_crecer_si_es_necesario(); // Lote 0
        botiquin.agregar_cola_a_lote(lote0); // Cola 0 en lote 0
        botiquin.agregar_cola_a_lote(lote0); // Cola 1 en lote 0

        int lote1 = botiquin.crear_y_crecer_si_es_necesario(); // Lote 1
        botiquin.agregar_cola_a_lote(lote1); // Cola 0 en lote 1

        System.out.println("Lotes creados: " + botiquin.getNumLotes());
        System.out.println();

        // ===== PRUEBA 2: AGREGAR MEDICAMENTOS =====
        System.out.println("PRUEBA 2: Agregar medicamentos");
        try {
            botiquin.Agregar_Medicamento_A_Cola_Desde_Contenedor(0, 0, new Medicamento("Dolex", "2026-01", 500));
            botiquin.Agregar_Medicamento_A_Cola_Desde_Contenedor(0, 0, new Medicamento("Dolex", "2026-02", 500));
            botiquin.Agregar_Medicamento_A_Cola_Desde_Contenedor(0, 1, new Medicamento("Dolex", "2025-12", 250));
            botiquin.Agregar_Medicamento_A_Cola_Desde_Contenedor(1, 0, new Medicamento("Amoxicilina", "2025-10", 500));
        } catch (Exception e) {
            System.out.println("Error al agregar medicamento: " + e.getMessage());
        }
        System.out.println();

        // ===== PRUEBA 3: IMPRIMIR CONTENIDO =====
        System.out.println("PRUEBA 3: Imprimir contenido del botiquín");
        botiquin.imprimir_contenedor();
        System.out.println();

        // ===== PRUEBA 4: ELIMINAR MEDICAMENTOS =====
        System.out.println("PRUEBA 4: Eliminar medicamentos (FIFO)");
        Medicamento eliminado = botiquin.getLote(0).eliminarMedicamentoACola(0);
        if (eliminado != null) {
            System.out.println("Eliminado: " + eliminado.getNombre() + " " + eliminado.getMiligramos() + "mg");
        }
        System.out.println("Contenido después de eliminar:");
        botiquin.imprimir_contenedor();
        System.out.println();

        // ===== PRUEBA 5: CRECER LOTE (MÁS DE 10 COLAS) =====
        System.out.println("PRUEBA 5: Crecer lote con más de 10 colas");
        int lote2 = botiquin.crear_y_crecer_si_es_necesario(); // Lote 2
        for (int i = 0; i < 12; i++) {
            botiquin.agregar_cola_a_lote(lote2);
            botiquin.Agregar_Medicamento_A_Cola_Desde_Contenedor(lote2, i, new Medicamento("TestMed", "2026-05", 100 + i));
        }
        System.out.println("Lote 2 después de crecer:");
        botiquin.getLote(lote2).imprimir_Listas();
        System.out.println();

        // ===== PRUEBA 6: CASOS EDGE - COLA VACÍA =====
        System.out.println("PRUEBA 6: Intentar desencolar de cola vacía");
        Cola colaVacia = new Cola();
        Medicamento vacio = colaVacia.desencolar();
        if (vacio == null) {
            System.out.println("Correcto: desencolar de cola vacía retorna null");
        }
        System.out.println();

        // ===== PRUEBA 7: VALIDACIONES - MEDICAMENTO INVÁLIDO =====
        System.out.println("PRUEBA 7: Validaciones de Medicamento");
        try {
            new Medicamento("", "2026-01", 500); // Nombre vacío
        } catch (IllegalArgumentException e) {
            System.out.println("Correcto: " + e.getMessage());
        }
        try {
            new Medicamento("Test", null, 500); // Fecha null
        } catch (IllegalArgumentException e) {
            System.out.println("Correcto: " + e.getMessage());
        }
        try {
            new Medicamento("Test", "2026-01", 0); // Miligramos <=0
        } catch (IllegalArgumentException e) {
            System.out.println("Correcto: " + e.getMessage());
        }
        System.out.println();

        // ===== PRUEBA 8: ÍNDICES INVÁLIDOS =====
        System.out.println("PRUEBA 8: Índices inválidos");
        try {
            botiquin.agregar_cola_a_lote(10); // Lote inexistente
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Correcto: " + e.getMessage());
        }
        try {
            botiquin.getLote(0).agregarMedicamentoACola(10, new Medicamento("Test", "2026-01", 100)); // Cola inexistente
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Correcto: " + e.getMessage());
        }
        System.out.println();

        // ===== PRUEBA 9: CONTENEDOR VACÍO =====
        System.out.println("PRUEBA 9: Contenedor vacío");
        Contenedor contenedorVacio = new Contenedor();
        contenedorVacio.imprimir_contenedor();
        System.out.println();

        System.out.println("=== FIN DE PRUEBAS ===");
    }
}