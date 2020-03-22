package de.fhws.Programmieren2.Lektion15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompanyTest
{
	@Test
	void testAddDepartment()
	{
		Company frw = new Company("Fränkische Rohrwerke gebr. Kirchner GmbH & Co. KG");
		assertTrue(frw.addDepartment("IT", "Informationstechnologie"));
		assertTrue(frw.addDepartment("PW", "Personalwirtschaft"));
		assertTrue(frw.addDepartment("GF", "Geschäftsführung"));
		assertTrue(frw.addDepartment("EV", "Elektro Vertrieb"));
		assertTrue(frw.addDepartment("HV", "Haustechnik Vertrieb"));
	}
	
	@Test
	void testGetDepartment()
	{
		Company frw = getCompany();
		frw.addDepartment("IT", "Informationstechnologie");
		frw.addDepartment("PW", "Personalwirtschaft");
		frw.addDepartment("GF", "Geschäftsführung");
		frw.addDepartment("EV", "Elektro Vertrieb");
		frw.addDepartment("HV", "Haustechnik Vertrieb");
		assertEquals("IT", frw.getDepartment("IT").deptID);
		assertEquals("GF", frw.getDepartment("GF").deptID);
		assertEquals("HV", frw.getDepartment("HV").deptID);
	}
	
	@Test
	void testAddEmployee()
	{
		Company frw = getCompany();
		assertTrue(frw.getDepartment("IT").addEmployee("Swigler", "Michél", "6875", 2700));
		assertTrue(frw.getDepartment("IT").addEmployee("Korn", "Vincent", "6816", 1251));
		assertTrue(frw.getDepartment("IT").addEmployee("Ehrlinger", "Matthias", "5578", 4300));
		assertTrue(frw.getDepartment("PW").addEmployee("Koch", "Daniela", "6655", 3900));
		assertTrue(frw.getDepartment("PW").addEmployee("Eidam", "Johanna", "6645", 3300));
	}
	
	@Test
	void testCalculateSalaryEmployee()
	{
		Company frw = getCompanyWithEmployee();
		
		assertEquals(2700d, frw.getDepartment("IT").getEmployee("6875").getSalary());
		assertEquals(1251d, frw.getDepartment("IT").getEmployee("6816").getSalary());
		assertEquals(4300d, frw.getDepartment("IT").getEmployee("5578").getSalary());
		assertEquals(3300d, frw.getDepartment("PW").getEmployee("6645").getSalary());
		assertEquals(3900d, frw.getDepartment("PW").getEmployee("6655").getSalary());
	}
	
	@Test
	void testCalculateSalaryHOD()
	{
		Company frw = getFullCompany();
		
		assertEquals(7200d, frw.getDepartment("IT").getHOD().getSalary());
		assertEquals(7500d, frw.getDepartment("PW").getHOD().getSalary());
		assertEquals(6600d, frw.getDepartment("HV").getHOD().getSalary());
	}
	
	@Test
	void testAddHeadOfDepartment()
	{
		Company frw = getCompany();
		assertTrue(frw.getDepartment("IT").addHeadOfDepartment("Schuhmann", "Helmut", "8899", 7200));
		assertTrue(frw.getDepartment("PW").addHeadOfDepartment("Haupt", "Dirk", "4423", 7500));
		assertTrue(frw.getDepartment("HV").addHeadOfDepartment("Baunacher", "Andreas", "9753", 6600));
		
		try
		{
			frw.getDepartment("IT").addHeadOfDepartment("Berninger", "Thomas", "8899", 6800);
			fail("RuntimeException expected");
		}
		catch(RuntimeException e)
		{
			String errorMessage = e.getMessage();
			assertEquals("Invalid Arguement", errorMessage);
		}
	}
	
	@Test
	void testPromoteEmployee()
	{
		Company frw = getFullCompany();
		
		frw.getDepartment("IT").getHOD().promoteEmployee("6875");
		assertEquals(2970, frw.getDepartment("IT").getEmployee("6875").getSalary(), 0.01);
		
		frw.getDepartment("IT").getHOD().promoteEmployee("6816");
		assertEquals(1376.1, frw.getDepartment("IT").getEmployee("6816").getSalary(), 0.01);
		
		frw.getDepartment("PW").getHOD().promoteEmployee("6655");
		assertEquals(4290, frw.getDepartment("PW").getEmployee("6655").getSalary(), 0.01);
		
		frw.getDepartment("IT").getHOD().promoteEmployee("6816");
		assertEquals(1513.71, frw.getDepartment("IT").getEmployee("6816").getSalary(), 0.01);
	}
	
//===========================================================================================================
//                Methods used to generate objects that meet the requirements for tests	
//===========================================================================================================	
	public Company getCompany()
	{
		Company frw = new Company("Fränkische Rohrwerke gebr. Kirchner GmbH & Co. KG");
		
		frw.addDepartment("IT", "Informationstechnologie");
		frw.addDepartment("PW", "Personalwirtschaft");
		frw.addDepartment("GF", "Geschäftsführung");
		frw.addDepartment("EV", "Elektro Vertrieb");
		frw.addDepartment("HV", "Haustechnik Vertrieb");
		
		return frw;
	}
	
	public Company getCompanyWithEmployee()
	{
		Company frw = getCompany();
		
		frw.getDepartment("IT").addEmployee("Eidam", "Michél", "6875", 2700);
		frw.getDepartment("IT").addEmployee("Swigler", "Vincent", "6816", 1251);
		frw.getDepartment("IT").addEmployee("Koch", "Matthias", "5578", 4300);
		frw.getDepartment("PW").addEmployee("Ehrlinger", "Daniela", "6655", 3900);
		frw.getDepartment("PW").addEmployee("Korn", "Johanna", "6645", 3300);
		
		return frw;
	}
	
	public Company getFullCompany()
	{
		Company frw = getCompanyWithEmployee();
		
		frw.getDepartment("IT").addHeadOfDepartment("Schuhmann", "Helmut", "8899", 7200);
		frw.getDepartment("PW").addHeadOfDepartment("Haupt", "Dirk", "8899", 7500);
		frw.getDepartment("HV").addHeadOfDepartment("Baunacher", "Andreas", "8899", 6600);
		
		return frw;
	}
}
