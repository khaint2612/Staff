import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("----------------------------------------------");
            System.out.println("-------Cac chuc nang co trong menu------------");
            System.out.println("1.Nhap danh sach nhan vien");
            System.out.println("2.Xuat danh sach nhan vien");
            System.out.println("3.Tim nhan vien theo ten");
            System.out.println("4.Tim nhan vien theo khoang thu nhap");
            System.out.println("5.Sap xep nhan vien theo ten");
            System.out.println("6.Sap xep nhan vien theo thu nhap");
            System.out.println("7.Top 5 nhan vien co thu nhap cao nhat");
            System.out.println("0.Exit");
            System.out.println("----------------------------------------------");
            int choose = Input.inputInt(sc, "Chon 1 chuc nang");
            switch (choose) {
                case 1:
                    controller.validateInput(sc);
                    break;
                case 2:
                    controller.output();
                    break;
                case 3:
                    controller.findByName(sc);
                    break;
                case 4:
                    controller.findByRangeIncome(sc);
                    break;
                case 5:
                    controller.SortByName();
                    break;
                case 6:
                    controller.SortByIncome();
                    break;
                case 7:
                    controller.top5();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui long chon 1 chuc nang");
                    break;
            }
        } while (true);
    }
}