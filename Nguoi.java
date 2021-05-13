public class Nguoi {
    private String sdt;
    private String group;
    private String name;
    private String gioi_tinh;
    private String dia_chi;
    private String ngay_sinh;
    private String email;

    public Nguoi() {
    }

    public Nguoi(String sdt, String group, String name, String gioi_tinh, String dia_chi,String ngay_sinh,String email) {
        this.sdt = sdt;
        this.group = group;
        this.name = name;
        this.gioi_tinh = gioi_tinh;
        this.dia_chi = dia_chi;
        this.ngay_sinh = ngay_sinh;
        this.email = email;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }
    public String ghiFileCSV(){
        return sdt +","+group+","+name+","+gioi_tinh+","+dia_chi+","+ngay_sinh+","+email;
    }

    @Override
    public String toString() {
        return "Nguoi{" +
                "sdt='" + sdt + '\'' +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", gioi_tinh='" + gioi_tinh + '\'' +
                ", dia_chi='" + dia_chi + '\'' +
                ", ngay_sinh='" + ngay_sinh + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
