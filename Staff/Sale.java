import java.util.Scanner;

public class Sale extends Staff {
    private double commission;
    private double sales;

    @Override
    public double getIncome() {
        return super.getSalary()+ commission * sales/100;
    }

    public void inputSale(Scanner sc){
        super.inputStaff(sc);
        commission = Input.inputDouble(sc, "Nhap hoa hong");
        sales = Input.inputDouble(sc, "nhap doanh thu");
    }

    public void outputSales() {
        super.outputStaff();
        System.out.print(" - commission: " + commission +" - sales: " + sales);
    }
}
