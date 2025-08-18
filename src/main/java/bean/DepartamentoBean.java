package bean;

public class DepartamentoBean {
    private int idDepartamento;
    private String nombreDepartamento;
    private String descripcionDepartamento;


    public DepartamentoBean() {
    }

    public DepartamentoBean(int idDepartamento, String nombreDepartamento, String descripcionDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.descripcionDepartamento = descripcionDepartamento;
    }

    public DepartamentoBean(String nombreDepartamento, String descripcionDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
        this.descripcionDepartamento = descripcionDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getDescripcionDepartamento() {
        return descripcionDepartamento;
    }

    public void setDescripcionDepartamento(String descripcionDepartamento) {
        this.descripcionDepartamento = descripcionDepartamento;
    }
}
