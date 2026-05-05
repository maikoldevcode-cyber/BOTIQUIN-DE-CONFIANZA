public class Principal {
    public static void main(String[] args) {

        // Crear contenedor principal del botiquín
        Contenedor botiquin = new Contenedor();
        
        // ===== LOTE 1: DOLEX (Medicamento Dolex en diferentes presentaciones) =====
        botiquin.Crear_Nuevo_Lote();
        System.out.println("///");
        // Cola para presentación 500mg
        System.out.println("cola de dolex 500mg");
        botiquin.agregar_cola_a_lote(0);
        botiquin.Agregar_Medicamento_A_Cola_Desde_Contenedor(0, 0, new Medicamento("dolex", "2026-01", 500));
        botiquin.Agregar_Medicamento_A_Cola_Desde_Contenedor(0, 0, new Medicamento("dolex", "2026-02", 500));
        System.out.println("///");
        // Cola para presentación 250mg
        System.out.println("cola nueva dolex 250mg");
        botiquin.agregar_cola_a_lote(0);
        botiquin.Agregar_Medicamento_A_Cola_Desde_Contenedor(0, 1, new Medicamento("dolex", "2025-11", 250));
        botiquin.Agregar_Medicamento_A_Cola_Desde_Contenedor(0, 1, new Medicamento("dolex", "2025-12", 250));
        System.out.println("///");
        // Cola para presentación 100mg
        System.out.println("cola nueva 100miligramos");
        botiquin.agregar_cola_a_lote(0);
        botiquin.Agregar_Medicamento_A_Cola_Desde_Contenedor(0, 2, new Medicamento("dolex", "2025-10", 100));
        
        System.out.println("///");
        // ===== LOTE 2: AMOXICILINA (Medicamento Amoxicilina en diferentes presentaciones) =====
       System.out.println("///");
       System.out.println(" ");
        botiquin.Crear_Nuevo_Lote();
        
        // Cola para presentación 500mg
        System.out.println("cola moxicilina 500 miligramos");
        botiquin.agregar_cola_a_lote(1);
        botiquin.Agregar_Medicamento_A_Cola_Desde_Contenedor(1, 0, new Medicamento("amoxicilina", "2025-09", 500));
        botiquin.Agregar_Medicamento_A_Cola_Desde_Contenedor(1, 0, new Medicamento("amoxicilina", "2025-10", 500));
        System.out.println("///");
        // Cola para presentación 250mg
        System.out.println("cola moxicilina 250 miligramos");
        botiquin.agregar_cola_a_lote(1);
        botiquin.Agregar_Medicamento_A_Cola_Desde_Contenedor(1, 1, new Medicamento("amoxicilina", "2025-08", 250));
        botiquin.Agregar_Medicamento_A_Cola_Desde_Contenedor(1, 1, new Medicamento("amoxicilina", "2025-09", 250));
        botiquin.Agregar_Medicamento_A_Cola_Desde_Contenedor(1, 1, new Medicamento("amoxicilina", "2025-10", 250));
        
        
        // ===== MOSTRAR CONTENIDO DEL BOTIQUÍN =====
        System.out.println("\n========== CONTENIDO DEL BOTIQUÍN ==========\n");
        botiquin.imprimir_contenedor();

/*
Contenedor obj = new Contenedor();
obj.Crear_Nuevo_Lote();
obj.agregar_cola_a_lote(0);
obj.Agregar_Medicamento_A_Cola_Desde_Contenedor(0, 0, new Medicamento("dolex", null, 0));
*/

//vector referenciando cada lista o cola = grupo de cada presentacion en mg
/*

Lote obj = new Lote();
obj.Crear_NuevaCola();
//presentacion 500mg
obj.Agregar_Medicamento_A_Cola(new Medicamento("dolex", "5", 500), 0);
obj.Agregar_Medicamento_A_Cola(new Medicamento("dolex", "10", 500),0);
obj.Crear_NuevaCola();
//presentacion 100mg
obj.Agregar_Medicamento_A_Cola(new Medicamento("dolex", "10", 150),1);
obj.Agregar_Medicamento_A_Cola(new Medicamento("dolex", "10", 100),1);
System.out.println("///");
obj.imprimir_listas();
 */


 //colas simples
/*
Cola obj = new Cola();
obj.encolar(new Medicamento("dolex", "nose", 100));
obj.encolar(new Medicamento("amoxicilina1", "tampoco se", 0));
obj.encolar(new Medicamento("amoxicilina2", "tampoco se", 0));
obj.encolar(new Medicamento("amoxicilina3", "tampoco se", 0));
obj.encolar(new Medicamento("amoxicilina4", "tampoco se", 0));
obj.encolar(new Medicamento("amoxicilina5", "tampoco se", 0));
obj.imprimir();
System.out.println("la primera medicina que se agrego es :" +
        obj.getFrente().getNombre());
System.out.println("has sacado la medicina que lleva mas tiempo guardada en el botiquin:"
        + obj.desencolar().getNombre());
 */


}
}