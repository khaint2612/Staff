import java.util.Scanner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Manager extends Staff {
    private double repository;

    @Override
    public double getIncome(){
        return repository+ super.getSalary();
    }

    public void inputManager(Scanner sc){
        super.inputStaff(sc);
        super.setLevel("Manager");
        repository = Input.inputDouble(sc, "Nhap luong trach nhiem:");
    }
    
    public void outputManager(){
        super.outputStaff();
        System.out.printf("\nrepository: " + repository+"\n================");
    }
}
