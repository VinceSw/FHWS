package de.fhws.Programmieren2.Lektion15;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.fhws.Programmieren2.Lektion15.Company;

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
		assertTrue(frw.getDepartment("IT").addEmployee("Korn", "Michél", "6875", "02.07.1990", 2700));
		assertTrue(frw.getDepartment("IT").addEmployee("Swigler", "Vincent", "6816", "10.07.1992", 1251));
		assertTrue(frw.getDepartment("IT").addEmployee("Ehrlinger", "Matthias", "5578", "14.05.1983", 4300));
		assertTrue(frw.getDepartment("PW").addEmployee("Koch", "Daniela", "6655", "29.12.1979", 3900));
		assertTrue(frw.getDepartment("PW").addEmployee("Eidam", "Johanna", "6645", "17.09.2000", 3300));
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
		assertTrue(frw.getDepartment("IT").addHeadOfDepartment("Schuhmann", "Helmut", "8899", "02.02.1977", 7200));
		assertTrue(frw.getDepartment("PW").addHeadOfDepartment("Haupt", "Dirk", "4423", "04.03.1992", 7500));
		assertTrue(frw.getDepartment("HV").addHeadOfDepartment("Baunacher", "Andreas", "9753", "05.06.1989", 6600));
		
		try
		{
			frw.getDepartment("IT").addHeadOfDepartment("Berninger", "Thomas", "8899", "11.09.1983", 6800);
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
		
		frw.getDepartment("IT").addEmployee("Korn", "Michél", "6875", "02.07.1990", 2700);
		frw.getDepartment("IT").addEmployee("Swigler", "Vincent", "6816", "10.07.1992", 1251);
		frw.getDepartment("IT").addEmployee("Ehrlinger", "Matthias", "5578", "14.05.1983", 4300);
		frw.getDepartment("PW").addEmployee("Koch", "Daniela", "6655", "29.12.1979", 3900);
		frw.getDepartment("PW").addEmployee("Eidam", "Johanna", "6645", "17.09.2000", 3300);
		
		return frw;
	}
	
	public Company getFullCompany()
	{
		Company frw = getCompanyWithEmployee();
		
		frw.getDepartment("IT").addHeadOfDepartment("Schuhmann", "Helmut", "8899", "02.02.1977", 7200);
		frw.getDepartment("PW").addHeadOfDepartment("Haupt", "Dirk", "4423", "04.03.1992", 7500);
		frw.getDepartment("HV").addHeadOfDepartment("Baunacher", "Andreas", "9753", "05.06.1989", 6600);
		
		return frw;
	}
}
