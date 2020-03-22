package de.fhws.Programmieren2.Lektion15;

public class Department
{
	String deptID, description;
	Company comp;
	Department nextDept;
	Employee empList;
	HeadOfDepartment empHD;
	
	public Department(Company comp, String deptID, String description)
	{
		this.comp = comp;
		this.deptID = deptID;
		this.description = description;
	}	
	
	public boolean addEmployee(String name, String firstname, String employeeID, int salary)
	{
		Employee temp = empList;
		Employee newEmployee = new Employee(this, name, firstname, employeeID, salary);
		
		if(empList == null)
		{
			empList = newEmployee;
			return true;
		}
		else
		{
			while(temp != null)
			{
				if(temp.nextEmployee != null)
				{
					temp = temp.nextEmployee;
				}
				else
				{
					temp.nextEmployee = newEmployee;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean addHeadOfDepartment(String name, String firstname, String employeeID, int salary)
	{
		if(empHD != null ) throw new RuntimeException("Invalid Arguement");
		empHD = new HeadOfDepartment(this, name, firstname, employeeID, salary);
		return true;
	}
	
	public Employee getEmployee(String employeeID)
	{
		Employee temp = empList;
		boolean empFound = false;
		
		while(temp != null)
		{
			if(temp.employeeID == employeeID)
			{
				empFound = true;
				break;
			}
			else
			{
				temp = temp.nextEmployee;
			}
		}
		
		if(!empFound) throw new RuntimeException("No such Employee in list");
		return temp;
	}

	public HeadOfDepartment getHOD()
	{
		return this.empHD;
	}
}
