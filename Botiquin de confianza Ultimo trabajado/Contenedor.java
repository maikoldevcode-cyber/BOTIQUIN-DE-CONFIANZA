public class Contenedor {
    int num;
    Lote contenedor[] =  new Lote[20];

    public int Crear_Nuevo_Lote(){
        contenedor[num] = new Lote ();
        System.out.println("se creo un nuevo lote "+contenedor[num]);
        num++;
         
        return num;

    }

    public void agregar_cola_a_lote(int posicion){
        contenedor[posicion].Crear_NuevaCola();

    }

    public void Agregar_Medicamento_A_Cola_Desde_Contenedor(int posicion,int indix,Medicamento medicamento_nuevo){
        contenedor[posicion].Agregar_Medicamento_A_Cola( indix,medicamento_nuevo);
    }



    public void imprimir_contenedor(){
        for(int i = 0; i < num; i++){
            System.out.println("--- Lote " + i + " ---");
            contenedor[i].imprimir_listas();
        }
    }

}
