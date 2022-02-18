import java.util.Scanner;

import org.apache.log4j.Logger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Staff {
    private int id;
    private String name;
    private String level;
    private double salary;
    Logger logger = Logger.getLogger(Staff.class.getName());
    public void inputStaff(Scanner sc){
        id = Input.inputInt(sc, "Nhap ma so");
        System.out.println("Nhap ten");
        name = sc.nextLine();
        salary = Input.inputDouble(sc, "Nhap luong");
    }

    public double getIncome(){
        return salary;
    }
    public void outputStaff(){
        System.out.println("id: " + id + " - name: " + name + " - level: " + level + " - salary: " + salary +" - income: " + getIncome());
    }
}
