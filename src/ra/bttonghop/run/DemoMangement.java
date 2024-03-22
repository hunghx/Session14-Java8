package ra.bttonghop.run;

import ra.bttonghop.bussiness.entity.Department;
import ra.bttonghop.bussiness.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemoMangement {
    private static List<Department> departmentList = new ArrayList<>();
    private static List<Employee> employeeList = new ArrayList<>();
    static {

    }
    public static void main(String[] args) {
        while (true){
            System.out.println("================MENU===================");
            System.out.println("1- Quản trị phòng ban : \n" +
                    "2- Hiển thị danh sách phòng ban\n" +
                    "3- Thêm mới phòng ban\n" +
                    "4- Chỉnh sửa tên phòng ban\n" +
                    "5- Hiển thị danh sách nhân viên của phòng ban theo mã phòng\n" +
                    "6- Xóa phòng ban (chỉ xóa khi ko có nhân viên nào)\n" +
                    "7- Quản trị nhân viên\n" +
                    "8- HIển thị danh sách thông tin tất cả nhân viên(mã nhân viên và tên)\n" +
                    "9- Xem chi tiết thông tin nhân viên theo mã nhân viên (toàn bộ thông tin)\n" +
                    "10- Thêm mới nhân viên\n" +
                    "11- Chỉnh sửa thông tin nhân viên\n" +
                    "12- Xóa nhân viên \n" +
                    "13- Thống kê số lượng nhân viên trung bình của mỗi phòng \n" +
                    "14- Tìm ra 5 phòng có số lượng nhân viên đông nhất\n" +
                    "15- Tìm ra người quản lý nhiều  nhân viên nhất\n" +
                    "16- Tìm ra 5 nhân viên có tuổi cao nhất công ty\n" +
                    "17- Tìm ra 5 nhân viên hưởng lương cao nhất");

            System.out.println("Nhập lựa chọn");
            byte choice = new Scanner(System.in).nextByte();
            switch (choice){
                case 2:
                    displayDepartment();
                    break;
                case 3:
                    addDepartment();
                    break;
                case 8:
                    addEmployee();
                    break;
                case 10:
                    displayEmployee();
                    break;
            }
        }
    }
    private  static void displayDepartment(){
        if (departmentList.isEmpty()){
            System.err.println("Danh sach trống");
        }else {
            departmentList.forEach(Department::displayData);
        }
    } private  static void addDepartment(){
        System.out.println("Nhap so luong phong ban muon them");
        byte count  =new Scanner(System.in).nextByte();
        for (int i = 1; i <=count ; i++) {
            System.out.println("Nhap thong tin cho phong ban thư "+i);
            Department department = new Department();
            department.inputData(departmentList);
            departmentList.add(department);
        }
        System.out.println("Đã them moi thanh cong ");
    }
    private  static void displayEmployee(){
        if (employeeList.isEmpty()){
            System.err.println("Danh sach trống");
        }else {
            employeeList.forEach(Employee::displayData);
        }
    }
    private static void addEmployee(){
        if (departmentList.isEmpty()){
            System.err.println("chưa có phong ban, them phong ban trươc");
            return;
        }
        System.out.println("Nhap so luong nhan vien muon them");
        byte count  =new Scanner(System.in).nextByte();
        for (int i = 1; i <=count ; i++) {
            System.out.println("Nhap thong tin cho nhan vien thư "+i);
            Employee employee = new Employee();
            employee.inputData(employeeList,departmentList);
            employeeList.add(employee);
        }
        System.out.println("Đã them moi thanh cong ");
    }
}
