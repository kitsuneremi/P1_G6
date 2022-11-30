/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class Xe {
    private String id;
    private String ma;
    private String tenXe;

    public Xe() {
    }

    public Xe(String id, String ma, String tenXe) {
        this.id = id;
        this.ma = ma;
        this.tenXe = tenXe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    @Override
    public String toString() {
        return "Xe{" + "id=" + id + ", ma=" + ma + ", tenXe=" + tenXe + '}';
    }
    
    public Object[] toRowData(){
        return new Object[]{id,ma,tenXe};
    }
}
