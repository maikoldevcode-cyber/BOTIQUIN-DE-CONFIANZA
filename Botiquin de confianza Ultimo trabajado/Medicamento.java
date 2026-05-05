public class Medicamento {
    private String nombre;
    private String fecha_vencimiento;
    private int miligramos;
 

    public Medicamento(String nombre, String fecha_vecimiento, int miligramos) {

        this.nombre = nombre;
        this.miligramos = miligramos;
        this.fecha_vencimiento =fecha_vecimiento;
    }

    



    @Override
    public String toString() {
        return "Medicamento [getNombre()=" + getNombre() + ", getFecha_vecimiento()=" + getFecha_vecimiento()
                + ", getMiligramos()=" + getMiligramos() + "]";
    }





    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public String getFecha_vecimiento() {

        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getMiligramos() {
        return miligramos;
    }

    public void setMiligramos(int miligramos) {
        this.miligramos = miligramos;
    }


}