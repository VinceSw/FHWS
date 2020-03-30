package de.fhws.Programmieren2.Lektion15;

public class HeadOfDepartment extends Employee
{
	public HeadOfDepartment(Department dept, String name, 
			String firstname, String employeeID, String birthday, int salary)
	{
		super(dept, name, firstname, employeeID, birthday, salary);
		salaryFactor = 2;
	}
	
	public void promoteEmployee(String employeeID)
	{
		Employee emp = dept.getEmployee(employeeID);

		emp.salaryFactor *= 1.1d;
		emp.calculateSalary();
	}
}
