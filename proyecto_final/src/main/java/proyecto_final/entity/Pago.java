package proyecto_final.entity;

import javax.persistence.*;

@Entity
@Table(name = "pago", schema = "modulo4")
public class Pago {
    @Id //indicar que la propiedad es una llave
    @Column(name = "id") //descripcion de la columna
    @GeneratedValue(strategy = GenerationType.IDENTITY) //estrategia de manejo de llave
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idMetodoPago")
    private MetodoPago metodoPago;

    @Column(name = "emisor", columnDefinition = "varchar(50)", nullable = false)
    private String emisor;

    @Column(name = "numeroCuenta", columnDefinition = "varchar(20)", nullable = false)
    private String numeroCuenta;

    @Column(name = "fechaExpiracion", columnDefinition = "varchar(10)", nullable = false)
    private String fechaExpiracion;

    @Column(name = "cvv", columnDefinition = "char(3)", nullable = false)
    private String cvv;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "id=" + id +
                ", idMetodoPago=" + metodoPago +
                ", emisor='" + emisor + '\'' +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", fechaExpiracion='" + fechaExpiracion + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
