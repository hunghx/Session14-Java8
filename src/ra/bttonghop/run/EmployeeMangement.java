package ra.bttonghop.run;

import ra.bttonghop.bussiness.entity.Department;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMangement {
    public static List<Department> departmentList = new ArrayList<>();
    static {
        departmentList.add(new Department("D001","Marketing",0));
        departmentList.add(new Department("D002","Vận Hành",0));
        departmentList.add(new Department("D003","Sales",0));
        departmentList.add(new Department("D004","Kho Hàng",0));
    }
    public static void main(String[] args) {
        Department department = new Department();
        department.inputData(departmentList);
    }
}
