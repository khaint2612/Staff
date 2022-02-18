import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Controller {
    List<Staff> list = new ArrayList<Staff>();

    public void input(Scanner sc) {
        System.out.printf("1.Nhan vien\n2.Tiep thi\n3.Truong phong\n");
        int choose = Input.inputInt(sc, "Chon nhan vien:");
        switch (choose) {
            case 1:
                Office office = new Office();
                office.inputOffice(sc);
                Integer officeId = office.getId();
                if (!list.stream().map(Staff::getId).anyMatch(officeId::equals)) {
                    list.add(office);
                } else {
                    System.out.println("Nhan vien nay da ton tai");
                }
                break;
            case 2:
                Sale sale = new Sale();
                sale.inputSale(sc);
                Integer saleId = sale.getId();
                if (!list.stream().map(Staff::getId).anyMatch(saleId::equals)) {
                    list.add(sale);
                } else {
                    System.out.println("Nhan vien nay da ton tai");
                }
                break;
            case 3:
                Manager manager = new Manager();
                manager.inputManager(sc);
                Integer managerId = manager.getId();
                if (!list.stream().map(Staff::getId).anyMatch(managerId::equals)) {
                    list.add(manager);
                } else {
                    System.out.println("Nhan vien nay da ton tai");
                }
                break;
            default:
                System.out.println("Vui long chon nhan vien can nhap.");
                break;
        }
    }

    public void validateInput(Scanner sc) {
        while (true) {
            if (list.isEmpty()) {
                input(sc);
            } else {
                System.out.println("Ban muon tiep tuc khong?(y/n)");
                String answer = sc.nextLine();
                if (answer.equals("y") || answer.equals("yes")) {
                    input(sc);
                } else {
                    break;
                }
            }
        }
    }

    public void output() {
        for (Staff staff : list) {
            if (staff instanceof Manager) {
                ((Manager) staff).outputManager();
            } else if (staff instanceof Sale) {
                ((Sale) staff).outputSales();
            } else if (staff instanceof Office) {
                ((Office) staff).outputOffice();
            }
        }
    }

    public void findByName(Scanner sc) {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong");
        } else {
            System.out.println("Nhap ten can tim");
            String nameFound = sc.nextLine();
            boolean found = false;
            for (Staff staff : list) {
                if (nameFound.equals(staff.getName())) {
                    if (staff instanceof Manager) {
                        ((Manager) staff).outputManager();
                    } else if (staff instanceof Sale) {
                        ((Sale) staff).outputSales();
                    } else if (staff instanceof Office) {
                        ((Office) staff).outputOffice();
                    }
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Khong co nhan vien co ten " + nameFound + " trong danh sach");
            }
        }
    }

    public void findByRangeIncome(Scanner sc) {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong");
        } else {
            double min = Input.inputDouble(sc, "Nhap thu nhap thap nhat:");
            double max = Input.inputDouble(sc, "Nhap thu nhap cao nhat:");
            if (max < min) {
                System.err.println("Max nho hon min");
            } else {
                boolean found = false;
                for (Staff staff : list) {
                    if (staff.getIncome() >= min && staff.getIncome() <= max) {
                        if (staff instanceof Manager) {
                            ((Manager) staff).outputManager();
                        } else if (staff instanceof Sale) {
                            ((Sale) staff).outputSales();
                        } else if (staff instanceof Office) {
                            ((Office) staff).outputOffice();
                        }
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Khong co nhan vien trong khoang " + min + " - " + max);
                }
            }
        }
    }

    public void SortByName(){
        Collections.sort(list, (a, b) -> a.getName().compareTo(b.getName()) );
        output();
    }
    public void SortByIncome(){
        Collections.sort(list, (a, b) -> (int) (b.getIncome() - a.getIncome()));
        output();
    }

    public void top5(){
        Collections.sort(list, (a, b) -> (int) (b.getIncome() - a.getIncome()));
        for(int i = 0; i < 5; i++){
            if (list.get(i) instanceof Manager) {
                ((Manager) list.get(i)).outputManager();
            } else if (list.get(i) instanceof Sale) {
                ((Sale)list.get(i)).outputSales();
            } else if (list.get(i) instanceof Office) {
                ((Office)list.get(i)).outputOffice();
            }
        }
    }
}
