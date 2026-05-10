public class Medicamento {
    private String nombre;
    private String fecha_vencimiento;
    private int miligramos;

    public Medicamento(String nombre, String fecha_vencimiento, int miligramos) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede ser nulo o vacío");
        }
        if (fecha_vencimiento == null) {
            throw new IllegalArgumentException("Fecha de vencimiento no puede ser nula");
        }
        if (miligramos <= 0) {
            throw new IllegalArgumentException("Miligramos deben ser positivos");
        }
        this.nombre = nombre;
        this.fecha_vencimiento = fecha_vencimiento;
        this.miligramos = miligramos;
    }

    @Override
    public String toString() {
        return "Medicamento [nombre=" + nombre + ", fecha_vencimiento=" + fecha_vencimiento + ", miligramos=" + miligramos + "]";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        if (fecha_vencimiento == null) {
            throw new IllegalArgumentException("Fecha de vencimiento no puede ser nula");
        }
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getMiligramos() {
        return miligramos;
    }

    public void setMiligramos(int miligramos) {
        if (miligramos <= 0) {
            throw new IllegalArgumentException("Miligramos deben ser positivos");
        }
        this.miligramos = miligramos;
    }
}