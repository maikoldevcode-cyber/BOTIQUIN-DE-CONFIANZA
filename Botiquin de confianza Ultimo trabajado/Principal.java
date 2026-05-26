
 
import java.util.Scanner;

/**
 * Clase Principal - Menu Interactivo del Botiquin
 * Permite al usuario interactuar con el botiquin a traves de un menu
 * en consola donde puede crear lotes, agregar/eliminar medicamentos, etc.
 */

public class Principal {/*
    
    */
   // Atributos globales del programa
   private static Contenedor botiquin;         // El botiquin principal
   private static Scanner scanner;             // Para leer entrada del usuario
   
   /**
    * main() - Punto de entrada del programa
    */
   public static void main(String[] args) {
       botiquin = new Contenedor();
       scanner = new Scanner(System.in);
       
       mostrarBienvenida();
       menuPrincipal();
       
       scanner.close();  // Cierra el Scanner para liberar recursos
   }
   
   /**
    * mostrarBienvenida() - Muestra un mensaje de bienvenida
    */
   private static void mostrarBienvenida() {
       System.out.println("\n");
       System.out.println("╔════════════════════════════════════════════════════════╗");
       System.out.println("║        BIENVENIDO AL BOTIQUIN DE CONFIANZA             ║");
       System.out.println("║     Sistema de Gestion de Medicamentos Inteligente      ║");
       System.out.println("╚════════════════════════════════════════════════════════╝");
       System.out.println();
   }
   
   /**
    * menuPrincipal() - Muestra y controla el menu principal
    * Mantiene un bucle indefinido hasta que el usuario seleccione salir
    */
   private static void menuPrincipal() {
       boolean ejecutando = true;  // Bandera para controlar el bucle
       
       while (ejecutando) {
           mostrarMenu();
           System.out.print("Ingrese su opcion: ");
           
           // try-catch: maneja errores al leer entrada del usuario
           try {
               int opcion = leerEntero();
               System.out.println();
               
               // switch: selecciona que hacer segun la opcion del usuario
               // case: rama para cada opcion
               switch (opcion) {
                   case 1:
                       crearLote();
                       break;
                   case 2:
                       agregarMedicamento();
                       break;
                   case 3:
                       eliminarMedicamento();
                       break;
                   case 4:
                       verContenido();
                       break;
                   case 5:
                       System.out.println("¡Gracias por usar el Botiquin de Confianza!");
                       ejecutando = false;  // Termina el bucle
                       break;
                   default:
                       System.out.println("❌ Opcion invalida. Ingrese un numero del 1 al 5.");
               }
           } catch (Exception e) {
               System.out.println("❌ Error: " + e.getMessage());
               scanner.nextLine();  // Limpia el buffer del scanner
           }
           
           if (ejecutando) {
               presionarEnter();  // Pausa para que el usuario lea el resultado
           }
       }
   }
   
   /**
    * mostrarMenu() - Imprime las opciones del menu
    */
   private static void mostrarMenu() {
       System.out.println("\n┌──────────────────────────────────────┐");
       System.out.println("│          MENU PRINCIPAL              │");
       System.out.println("├──────────────────────────────────────┤");
       System.out.println("│  1. Crear un nuevo lote              │");
       System.out.println("│  2. Agregar medicamento              │");
       System.out.println("│  3. Eliminar medicamento             │");
       System.out.println("│  4. Ver contenido del botiquin       │");
       System.out.println("│  5. Salir                            │");
       System.out.println("└──────────────────────────────────────┘");
   }
   
   /**
    * crearLote() - Crea un nuevo lote en el botiquin
    * Maneja el crecimiento automatico del contenedor si es necesario
    */
   private static void crearLote() {
       try {
            System.out.print("Ingrese el nombre del lote: ");
            String nombreLote = scanner.nextLine().trim();
            if (nombreLote.isEmpty()) {
                System.out.println("❌ Nombre de lote invalido. Intente de nuevo.");
                return;
            }

            int indice = botiquin.crear_y_crecer_si_es_necesario(nombreLote);
            System.out.println("✓ Lote creado exitosamente en posicion " + indice);
            System.out.println("✓ Total de lotes: " + botiquin.getNumLotes());
       } catch (Exception e) {
           System.out.println("❌ Error al crear lote: " + e.getMessage());
       }
   }
   
   /**
    * agregarMedicamento() - Agrega un medicamento a una cola especifica
    * Pide al usuario: numero de lote, numero de cola, nombre, fecha y miligramos
    */
   private static void agregarMedicamento() {
       try {
           // Verifica que haya lotes creados
           if (botiquin.getNumLotes() == 0) {
               System.out.println("❌ No hay lotes creados. Cree un lote primero.");
               return;
           }
           
           System.out.println("\n--- Agregar Medicamento ---");
           
           // Pedir numero de lote
           System.out.print("Ingrese el numero de lote (0 a " + (botiquin.getNumLotes() - 1) + "): ");
           int numLote = leerEntero();
           
           // Validar que el lote exista
           if (numLote < 0 || numLote >= botiquin.getNumLotes()) {
               System.out.println("❌ Lote invalido.");
               return;
           }
           
           // Pedir numero de cola (puede crear nueva si no existe)
           System.out.print("Ingrese el numero de cola en el lote: ");
           int numCola = leerEntero();
           
           if (numCola < 0) {
               System.out.println("❌ Cola invalida.");
               return;
           }
           
           // Si la cola no existe, ofrecemos crearla
           if (numCola >= botiquin.getLote(numLote).getTamaño()) {
               System.out.print("La cola no existe. ¿Desea crearla? (s/n): ");
               String respuesta = scanner.nextLine().trim().toLowerCase();
               if (respuesta.equals("s")) {
                   // Crear las colas necesarias
                   while (botiquin.getLote(numLote).getTamaño() <= numCola) {
                       botiquin.agregar_cola_a_lote(numLote);
                   }
               } else {
                   System.out.println("❌ Operacion cancelada.");
                   return;
               }
           }
           
           // Pedir datos del medicamento
           System.out.print("Ingrese el nombre del medicamento: ");
           String nombre = scanner.nextLine().trim();
           
           System.out.print("Ingrese la fecha de vencimiento (ej: 2026-12): ");
           String fecha = scanner.nextLine().trim();
           
           System.out.print("Ingrese los miligramos: ");
           int miligramos = leerEntero();
           
           // Crear y agregar el medicamento
           Medicamento nuevoMedicamento = new Medicamento(nombre, fecha, miligramos);
           botiquin.Agregar_Medicamento_A_Cola_Desde_Contenedor(numLote, numCola, nuevoMedicamento);
           
           System.out.println("✓ Medicamento agregado exitosamente!");
       } catch (IllegalArgumentException e) {
           System.out.println("❌ Datos invalidos: " + e.getMessage());
       } catch (Exception e) {
           System.out.println("❌ Error: " + e.getMessage());
       }
   }
   
   /**
    * eliminarMedicamento() - Elimina un medicamento (el mas antiguo de una cola)
    * Sigue el principio FIFO de la cola
    */
   private static void eliminarMedicamento() {
       try {
           if (botiquin.getNumLotes() == 0) {
               System.out.println("❌ No hay lotes. Nada que eliminar.");
               return;
           }
           
           System.out.println("\n--- Eliminar Medicamento ---");
           
           // Pedir numero de lote
           System.out.print("Ingrese el numero de lote (0 a " + (botiquin.getNumLotes() - 1) + "): ");
           int numLote = leerEntero();
           
           if (numLote < 0 || numLote >= botiquin.getNumLotes()) {
               System.out.println("❌ Lote invalido.");
               return;
           }
           
           // Pedir numero de cola
           System.out.print("Ingrese el numero de cola: ");
           int numCola = leerEntero();
           
           if (numCola < 0 || numCola >= botiquin.getLote(numLote).getTamaño()) {
               System.out.println("❌ Cola invalida.");
               return;
           }
           
           // Eliminar medicamento (retorna el que se elimino)
           Medicamento eliminado = botiquin.getLote(numLote).eliminarMedicamentoACola(numCola);
           
           if (eliminado != null) {
               System.out.println("✓ Medicamento eliminado: " + eliminado.getNombre());
           } else {
               System.out.println("⚠ La cola esta vacia.");
           }
       } catch (Exception e) {
           System.out.println("❌ Error: " + e.getMessage());
       }
   }
   
   /**
    * verContenido() - Muestra todo el contenido del botiquin
    */
   private static void verContenido() {
       System.out.println("\n╔════════════════════════════════════════╗");
       System.out.println("║    CONTENIDO ACTUAL DEL BOTIQUIN        ║");
       System.out.println("╚════════════════════════════════════════╝\n");
       
       if (botiquin.getNumLotes() == 0) {
           System.out.println("El botiquin esta vacio (sin lotes)");
       } else {
           System.out.println("Total de lotes: " + botiquin.getNumLotes());
           System.out.println("Capacidad total del contenedor: " + botiquin.getCapacidad());
           System.out.println();
           botiquin.imprimir_contenedor();
       }
   }
   
   /**
    * leerEntero() - Lee un numero entero del usuario
    * Maneja excepciones si el usuario ingresa algo que no es un numero
    * 
    * @return el numero entero ingresado
    * @throws NumberFormatException si no es un numero valido
    */
   private static int leerEntero() {
       // try: intenta leer un entero
       // scanner.nextInt(): lee el siguiente entero del teclado
       try {
           int numero = scanner.nextInt();
           scanner.nextLine();  // Limpia el salto de linea restante
           return numero;
       } catch (java.util.InputMismatchException e) {
           scanner.nextLine();  // Limpia el buffer
           throw new NumberFormatException("Por favor ingrese un numero valido");
       }
   }
   
   /**
    * presionarEnter() - Pausa el programa esperando que el usuario presione Enter
    * Permite que el usuario vea los resultados antes de que se limpie la pantalla
    */
   private static void presionarEnter() {
       System.out.print("\nPresione Enter para continuar...");
       scanner.nextLine();
       limpiarPantalla();
   }
   
   /**
    * limpiarPantalla() - Limpia la pantalla de la consola
    * Imprime lineas en blanco para simular limpiar la pantalla
    */
   private static void limpiarPantalla() {
       for (int i = 0; i < 50; i++) {
           System.out.println();
       }
   }
}

