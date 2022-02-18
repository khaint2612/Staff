import java.util.Scanner;

public class Office extends Staff {

    @Override
    public double getIncome(){
        return super.getSalary();
    }

    public void inputOffice(Scanner sc){
        super.inputStaff(sc);
        super.setLevel("Office");
    }

    public void outputOffice(){
        super.outputStaff();
        System.out.println("\n================================");
    }
}
