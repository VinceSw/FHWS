package de.fhws.Programmieren2.Lektion15;

public class Employee
{
	protected String name, firstname, employeeID, birthday;
	protected double baseSalary, salaryFactor, salary;
	protected Department dept;
	Employee nextEmployee;
	
	public Employee(Department dept, String name, String firstname, 
			String employeeID, String birthday, double baseSalary)
	{
		this.dept = dept;
		this.name = name;
		this.firstname = firstname;
		this.employeeID = employeeID;
		this.birthday = birthday;
		this.baseSalary = baseSalary;
		this.salaryFactor = 1d;
		this.salary = baseSalary * salaryFactor;
	}	
	
		/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setBaseSalary(double baseSalary)
	{
		this.baseSalary = baseSalary;
	}

	public void setSalaryFactor(double salaryFactor)
	{
		this.salaryFactor = salaryFactor;
	}

	public void setSalary()
	{
		this.salary = this.baseSalary * this.salaryFactor;
	}

	public void setDept(Department dept)
	{
		this.dept = dept;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname()
	{
		return firstname;
	}
	
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	/**
	 * @return the employeeID
	 */
	public String getEmployeeID()
	{
		return employeeID;
	}

	/**
	 * @return the baseSalary
	 */
	public double getBaseSalary()
	{
		return baseSalary;
	}
	
	/**
	 * @return the salaryFactor
	 */
	public double getSalaryFactor()
	{
		return salaryFactor;
	}	

	/**
	 * @return the salary
	 */
	public double getSalary()
	{
		return salary;
	}

	/**
	 * @return the dept
	 */
	public Department getDept()
	{
		return dept;
	}
}
