import java.util.Scanner;

import org.apache.log4j.Logger;

public class Input{
    static Logger log = Logger.getLogger(Input.class.getName());
    public static int inputInt(Scanner sc, String message) {
        while(true) {
            try{
            System.out.println(message);
            int input = Integer.parseInt(sc.nextLine());
            if(input < 0){
                log.warn("Ban da nhap so am, vui long nhap lai");
            }else{
                return input;
            }
            } catch (Exception e) {
                log.warn("Vui long nhap dung so nguyen",e);
            }
        }
    }

    public static double inputDouble(Scanner sc, String message) {
        while(true) {
            try{
                System.out.println(message);
                double input = Double.parseDouble(sc.nextLine());
                if(input < 0 || input > 10){
                    log.warn("Nhap tu 0 den 10");
                }else{
                    return input;
                }
            }catch (Exception e) {
                log.warn("Vui long nhap dung dinh dang", e);
            }
        }
    }
}