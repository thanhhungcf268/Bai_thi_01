import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Manage {
    private Scanner sc = new Scanner(System.in);
    private Nguoi nguoi = new Nguoi();
    private List<Nguoi> list = new ArrayList<>();

    public void showList() {
        if (list.isEmpty()) {
            System.out.println(" danh bạ trống");
            return;
        }
        for (Nguoi n : list) {
            System.out.println(n.toString());
        }
    }

    public void addNguoi() {
        list.add(enterInFormation());
    }

    private Nguoi enterInFormation() {
        System.out.println(" Nhập số điện thoại ");
        String sdt = checkSdt();
        String[] array = editInFormation();
        return new Nguoi(sdt, array[0], array[1], array[2], array[3], array[4], array[5]);
    }

    private String getGioi_Tinh() {
        System.out.println(" 1. Nam");
        System.out.println(" 2. Nữ");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            return "nam";
        } else if (choice.equals("2")) {
            return "nữ";
        } else {
            System.out.println(" cho chọn lại ");
            return getGioi_Tinh();
        }
    }

    private String checkSdt() {
        String sdt = sc.nextLine();
        String regex = "^[0]+\\d{9}$";
        if (Pattern.matches(regex, sdt)) {
            return sdt;
        } else {
            System.out.println(" sai cú pháp");
            return checkSdt();
        }
    }

    private String checkEmail() {
        String email = sc.nextLine();
        String regex = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        if (Pattern.matches(regex, email)) {
            return email;
        } else {
            System.out.println(" sai cú pháp");
            return checkEmail();
        }
    }

    private String checkNgay_sinh() {
        String ngay_sinh = sc.nextLine();
        String regex = "^\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}$";
        if (Pattern.matches(regex, ngay_sinh)) {
            return ngay_sinh;
        } else {
            System.out.println(" định dạng dd/mm/yyyy");
            return checkNgay_sinh();
        }
    }

    public void capNhat(String ter) {
        String str;
        if (ter == null) {
            System.out.println(" Nhập SDT cần sửa");
            str = sc.nextLine();
        } else {
            str = ter;
        }

        int check = isCheck(str);

        if (check == -1) {
            String enter = lam_lai();
            if (!enter.equals("")) {
                capNhat(enter);
            }
        } else {
            editInFormation(check);
        }
    }

    private String lam_lai() {
        System.out.println(" không tìm thấy sdt ");
        System.out.println("enter nếu muốn thoát or nhập lại sdt");
        String enter = sc.nextLine();
        if (!enter.equals("")) {
            return enter;
        } else {
            return "";
        }
    }

    private int isCheck(String str) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSdt().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void delete(String str) {
        int check = isCheck(str);
        if (check != -1) {
            list.remove(check);
        } else {
            String enter = lam_lai();
            if (!enter.equals("")) {
                delete(enter);
            }
        }
    }

    private void editInFormation(int i) {
        String[] array = editInFormation();
        list.get(i).setGroup(array[0]);
        list.get(i).setName(array[1]);
        list.get(i).setGioi_tinh(array[2]);
        list.get(i).setDia_chi(array[3]);
        list.get(i).setNgay_sinh(array[4]);
        list.get(i).setEmail(array[5]);
    }

    private String[] editInFormation() {
        System.out.println(" Nhập nhóm ");
        String group = sc.nextLine();
        System.out.println(" Nhập tên ");
        String name = sc.nextLine();
        System.out.println(" Chọn giới tính  ");
        String gioi_tinh = getGioi_Tinh();
        System.out.println(" Nhập địa chỉ ");
        String dia_chi = sc.nextLine();
        System.out.println(" Nhập ngày sinh ");
        String ngay_sinh = checkNgay_sinh();
        System.out.println(" Nhập Email ");
        String email = checkEmail();
        return new String[]{group, name, gioi_tinh, dia_chi, ngay_sinh, email};
    }
    public void findNameOrSdt(String str){

        for (Nguoi value : list) {
            if (str.equals(value.getSdt()) || str.equals(value.getName())) {
                System.out.println(value);
            }
        }
    }
    public void addFileCsv(){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/contacts.csv"));
            String[] str;
            for (Nguoi value : list) {
                str = value.ghiFileCSV().split(",");
                for (String s : str) {
                    bufferedWriter.write(s + ",");
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (Exception e){
            System.err.println(" ghi file lỗi ");
        }
    }
    public void updateFileCsv(){
        try {
            File f = new File("D:/contacts.csv");
            if (!f.isFile() || f.length()==0){
                System.out.println(" file trống");
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            String str;
            List<Nguoi> l = new ArrayList<>();
            while ((str = bufferedReader.readLine()) != null){
                String[] k = str.split(",");
                l.add(new Nguoi(k[0],k[1],k[2],k[3],k[4],k[5],k[6]));
            }
            list = l;
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
