import entity.Student;
import handle.InputHandle;
import handle.StudentHandle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);            //tạo đối tượng Scanner để nhận dữ liệu đầu vào
        InputHandle inputHandle = new InputHandle();        //tạo đối tượng InputHandle để kiểm tra các dữ liệu nhập vào
        StudentHandle studentHandle = new StudentHandle(); //tạo đối tượng StudentHandle để thao tác với các sinh viên

        System.out.println("Nhập số lượng student");     //yêu cầu người dùng nhập số lượng sinh viên
        int numberOfStudent = inputHandle.inputPositiveInt(scanner);//dùng method inputPositiveInt của inputHandle để kiểm tra giả trị nhập vào (> 0)

        Student[] students = new Student[numberOfStudent];//tạo mảng Student với kích thước là số lượng sinh viên vừa nhập
        for (int i = 0; i < numberOfStudent; i++) {   //dùng forloop khởi tạo các đối tượng Student qua method createStudent rồi gán cho các biến của mảng
            students[i] = studentHandle.createStudent(scanner, i);
        }

        studentHandle.displayAllStudent(students); //hiển thị thông tin tất cả các sinh viên trong mảng
        studentHandle.calculateRank(students);    //tính tỷ lệ phần trăm dựa theo xếp loại, rổi hiển thị kết quả vừa tính
    }
}
