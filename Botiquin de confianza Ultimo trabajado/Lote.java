
public class Lote {
    int indixe;
    Cola lote [] = new Cola[10];
   
    

    public int Crear_NuevaCola(){
        lote[indixe] = new Cola ();
        System.out.println("se agrego la nueva cola "+lote[indixe]+"en el indixe "+indixe);
        indixe++;
         
        return indixe;
       
         
    }

    public Medicamento Agregar_Medicamento_A_Cola (Medicamento nuevo,int indixe){
        lote[indixe].encolar(nuevo);
        System.out.println("la medicina es "+lote[indixe].getFrente().getNombre());
        return nuevo;
    }

    public void imprimir_listas(){
        for(int i = 0;i<indixe;){
            lote[i].imprimir();
            i++;
        }
    }
    


}
