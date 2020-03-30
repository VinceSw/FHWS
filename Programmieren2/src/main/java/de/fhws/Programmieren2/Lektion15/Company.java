package de.fhws.Programmieren2.Lektion15;

public class Company
{
	protected String name;
	private Department deptList;
	
	public Company(String name)
	{
		this.name = name;
	}
	
	public boolean addDepartment(String departmentName, String departmentDescr)
	{
		Department temp = deptList;
		Department newDept = new Department(this, departmentName, departmentDescr);
		
		if(deptList == null)
		{
			deptList = newDept;
			return true;
		}
		else
		{
			while(temp != null)
			{
				if(temp.nextDept != null)
				{
					temp = temp.nextDept;
				}
				else
				{
					temp.nextDept = newDept;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public Department getDepartment(String deptID)
	{
		Department temp = deptList;
		boolean deptFound = false;
		
		while(temp != null)
		{
			if(temp.deptID == deptID)
			{
				deptFound = true;
				break;
			}
			else
			{
				temp = temp.nextDept;
			}
		}
		
		if(!deptFound) throw new RuntimeException("No such department in List.");
		return temp;
	}
}
