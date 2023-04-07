package handle;
import java.util.Scanner;

public class InputHandle {
    //method kiểm tra giá trị nhập vào phải là số trong khoảng 0- 10 kiểu dữ liệu là double
    public double inputSubjectScore(Scanner scanner) {
        double result = 0;
        do {
            try {
                result = Double.parseDouble(scanner.nextLine());

                if (result < 0 || result > 10) { //điều kiện biến result > 10 hoặc < 0
                    throw new IllegalArgumentException("Phải nhập số lớn hơn 0 và nhỏ hơn 10"); //ném ra ngoại lệ khi điều kiện đúng
                }
                break; //không có ngoại lệ --> thoát vòng lặp
            } catch (NumberFormatException e) {        //bắt ngoại lệ nếu dữ liệu nhập vào là chuỗi không phải số
                System.out.println("Phải nhập một số!");
                System.out.println("Nhập lại");
            } catch (IllegalArgumentException e) {    //bắt ngoại lệ nếu dữ liệu nhập vào lớn hơn 10 hoặc nhỏ hơn 0
                System.out.println(e.getMessage());
                System.out.println("Nhập lại!");
            }
        }while(true); //tiếp tục vòng lặp cho đến khi không gặp ngoại lệ
        return result;
    }
    //method kiểm tra giá trị nhập vào phải là số dương kiểu dữ liệu int
    public int inputPositiveInt(Scanner scanner) {
        int result = 0;
        do {
            try {
                result = Integer.parseInt(scanner.nextLine());

                if (result <= 0) {
                    throw new IllegalArgumentException("Phải nhập số lớn hơn 0"); //ném ra ngoại lệ khi điều kiện result <= 0 đúng
                }
                break; //không có ngoại lệ --> thoát vòng lặp
            } catch (NumberFormatException e) {  //bắt ngoại lệ dữ liệu nhập vào là chuỗi không phải số
                System.out.println("Phải nhập một số!");
                System.out.println("Nhập lại");
            } catch (IllegalArgumentException e) { //bắt ngoại lệ dữ liệu nhập vào <= 0
                System.out.println(e.getMessage());
                System.out.println("Nhập lại!");
            }
        }while(true); //tiếp tục vòng lặp cho đến khi không gặp ngoại lệ
        return result;
    }
}
