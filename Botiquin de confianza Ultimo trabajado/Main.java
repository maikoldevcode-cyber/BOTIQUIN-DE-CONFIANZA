import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Contenedor botiquin = new Contenedor();
        System.out.println("que desea hacer? :");
        System.out.println("1.agregar lote");
        System.out.println("2.agregar medicamento");
        System.out.println("3.eleiminar medicamento");
        int elegir = sc.nextInt();
        while (true) {
            
        
        switch (elegir) {
            case 1:
                System.out.print("ingrese el nombre de este lote :");
                String var = sc.nextLine();
                System.out.println("ingrese el nombre");
                botiquin.crear_y_crecer_si_es_necesario("");
                
                System.out.println("lote agregado correctamente");
                break;
        
            default:
                break;
        }
    
    }

    }}