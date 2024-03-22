package ra.bttonghop.bussiness.design;

import ra.bttonghop.bussiness.entity.Department;
import ra.bttonghop.bussiness.entity.Employee;

import java.util.List;

public interface IEmployeeDesign  extends IGenericDesign<Employee,String> {
    void detailInfo();
    void getListEmployeeByDepartment();
    void getAvgEmployeesPerDepartment();
    void findMostManager();
    void find5OldestEmployee();
    void find5HighestSalary();
    void find5DepartmentCrowded();
}
