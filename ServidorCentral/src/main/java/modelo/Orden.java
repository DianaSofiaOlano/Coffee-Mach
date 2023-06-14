import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Orden implements Serializable {
  private int id;
  private int idMaquinaCafe;
  private int idOperador;
  private Date fecha;
  private String ubicacion;
  private List<int> itemsOrden;

  // Constructor
  public Orden() {
  }

  // Getters y setters
  public int getId(){
    return id;
  }

  public void setId(int id){
    this.id = id;
  }

  public int getIdMaquinaCafe() {
      return idMaquinaCafe;
  }

  public void setIdMaquinaCafe(int idMaquinaCafe) {
      this.idMaquinaCafe = idMaquinaCafe;
  }

  public int getIdOperador() {
      return idOperador;
  }

  public void setIdOperador(int idOperador) {
      this.idOperador = idOperador;
  }

  public Date getFecha() {
      return fecha;
  }

  public void setFecha(Date fecha) {
      this.fecha = fecha;
  }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<String> getItemsOrden() {
        return itemsOrden;
    }

    public void setItemsOrden(List<String> itemsOrden) {
        this.itemsOrden = itemsOrden;
    }
}
