import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Manage m = new Manage();
        swCase(m);
    }

    static void swCase(Manage manage) {
        String choice;
        do {
            System.out.println(" nhập lựa chon !");
            menu();
            choice = sc.nextLine();
            switch (choice) {
                case "1" -> manage.showList();
                case "2" -> manage.addNguoi();
                case "3" -> {
                    System.out.println(" nhập sđt cần sửa");
                    String str = sc.nextLine();
                    manage.capNhat(str);
                }
                case "4" -> {
                    System.out.println(" nhập sđt cần xóa");
                    String str = sc.nextLine();
                    manage.delete(str);
                }
                case "5" -> {
                    System.out.println(" nhập tên or số điện thoại");
                    String str = sc.nextLine();
                    manage.findNameOrSdt(str);
                }
                case "6" -> {
                    System.out.println(" việc đọc file sẽ xóa toàn bộ danh bạ đang có trong bộ nhớ 1.đồng ý phím bất kì nấu muốn thoát ");
                    String str = sc.nextLine();
                    if (str.equals("1")) {
                        manage.addFileCsv();
                    }
                }
                case "7" -> manage.updateFileCsv();

            }
        } while (!choice.equals("8"));
    }

    static void menu() {
        System.out.println(" 1. xem danh sách");
        System.out.println(" 2. thêm mới");
        System.out.println(" 3. cập nhật");
        System.out.println(" 4. xóa");
        System.out.println(" 5. tìm kiếm");
        System.out.println(" 6. đọc tư file ");
        System.out.println(" 7. ghi vào file");
        System.out.println(" 8. thoát");
    }
}
