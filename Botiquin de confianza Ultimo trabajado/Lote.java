
public class Lote {
    int indixe;
    Cola lote [] = new Cola[10];
   
    

    public int Crear_NuevaCola(){
        lote[indixe] = new Cola ();
        System.out.println("se agrego la nueva cola "+lote[indixe]+"en el indixe "+indixe);
        indixe++;
         
        return indixe;
       
         
    }

    public Medicamento Agregar_Medicamento_A_Cola (int indixe,Medicamento medicamento_nuevo){
        lote[indixe].encolar(medicamento_nuevo);
        lote[indixe].imprimir();
        return medicamento_nuevo;
    }

    public void imprimir_listas(){
        for(int i = 0;i<indixe;){
            lote[i].imprimir();
            i++;
        }
    }
    
public void Eliminar_Medicamento_A_Cola(int indixe){
        lote[indixe].desencolar();
}

}
