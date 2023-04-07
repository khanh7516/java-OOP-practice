package handle;

import entity.Student;
import java.util.Scanner;

public class StudentHandle {
    //hàm khởi tạo đối tượng Student từ giá trị nhập vào bàn phím
    public Student createStudent(Scanner scanner, int i) {
        InputHandle inputHandle = new InputHandle(); //tạo đối tượng InputHandle để sự dụng các phương thức trong này

        System.out.println("Mời nhập tên student thứ " + (i + 1)); //yêu cầu nhập tên
        String name = scanner.nextLine();
        System.out.println("Nhập điểm toán: ");                     //yêu cầu nhập điểm toán
        double mathScore = inputHandle.inputSubjectScore(scanner); //dùng method inputSubjectScore của inputHandle để kiểm tra giá trị nhập vào (0 -10)
        System.out.println("Nhập điểm lý: ");                       //yêu cầu nhập điểm lý
        double physicScore = inputHandle.inputSubjectScore(scanner);
        System.out.println("Nhập điểm hóa: ");                      //yêu cầu nhập điểm hóa
        double chemisScore = inputHandle.inputPositiveInt(scanner);

        return new Student(name, mathScore, physicScore, chemisScore);//hàm khởi tạo có tham số Student được gọi, truyển các tham số tương ứng, trả về đối tượng mới được tạo
    }
    //method in thông tin tất cả các sinh viên trong mảng được truyền vào
    public void displayAllStudent( Student[] students) {
        for ( Student student : students) {
            System.out.println(student);
        }
    }
    //method nhận vào 1 mảng các đối tượng Student --> tính tỷ lệ phần trăm dựa theo xếp loại A, B, C --> in ra kết quả
    public void calculateRank( Student[] students) {
        double rankA = 0;
        double rankB = 0;
        double rankC = 0;
        //đếm số lượng sinh viên từng loại
        for ( Student student : students) {
            switch (student.xepLoai()) {  //method inputSubjectScore đã kiểm tra điểm nhập vào (0 -10)
                case "A" -> rankA++;      //--> điểm trung bình trong khoảng 0- 10
                case "B" -> rankB++;      //--> chỉ có 3 loại xếp loại A, B, C và không còn trường hợp nào khác
                case "C" -> rankC++;      //--> không cần default
            }
        }
        //tính tỷ lệ phần trăm các sinh viên theo xếp loại (số lượng xếp loại / tổng số sinh viên) * 100
        double percentOfA = (rankA / students.length) * 100;
        double percentOfB = (rankB / students.length) * 100;
        double percentOfC = (rankC / students.length) * 100;
        //in ra màn hình chi tiết tỷ lệ từng xếp loại
        System.out.printf(  "Tỷ lệ sinh viên xếp loại A: %.2f%%%n" +
                            "Tỷ lệ sinh viên xếp loại B: %.2f%%%n" +
                            "Tỷ lệ sinh viên xếp loại C: %.2f%%%n", percentOfA, percentOfB, percentOfC);

        //Output
        //Tỷ lệ sinh viên xếp loại A: 33.33%
        //Tỷ lệ sinh viên xếp loại B: 33.33%
        //Tỷ lệ sinh viên xếp loại C: 33.33%
    }
}



