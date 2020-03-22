package de.fhws.Programmieren2.Lektion15;

public class Employee
{
	protected String name, firstname, employeeID;
	protected double baseSalary, salaryFactor, salary;
	Department dept;
	Employee nextEmployee;
	
	public Employee(Department dept, String name, String firstname, 
			String employeeID, double baseSalary)
	{
		this.dept = dept;
		this.name = name;
		this.firstname = firstname;
		this.employeeID = employeeID;
		this.baseSalary = baseSalary;
		this.salaryFactor = 1d;
		calculateSalary();
	}	
	
	public void calculateSalary()
	{
		this.salary = baseSalary * salaryFactor;
	}

	
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	

	/**
	 * @return the firstname
	 */
	public String getFirstname()
	{
		return firstname;
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
