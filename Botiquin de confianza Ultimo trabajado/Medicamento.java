public class Medicamento {
    private String nombre;
    private String fecha_vencimiento;
    private int miligramos;
    private Medicamento anterior;
    private Medicamento siguiente;

    public Medicamento(String nombre, String fecha_vecimiento, int miligramos) {
        this.anterior = null;
        this.siguiente = null;
        this.nombre = nombre;
        this.miligramos = miligramos;
        this.fecha_vencimiento = "no es importante aun";
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

    public Medicamento getAnterior() {
        return anterior;
    }

    public void setAnterior(Medicamento anterior) {
        this.anterior = anterior;
    }

    public Medicamento getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Medicamento siguiente) {
        this.siguiente = siguiente;
    }

}