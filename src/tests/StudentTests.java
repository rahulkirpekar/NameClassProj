package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import sysutilities.Name;

public class StudentTests 
{
	// 1. TestCase--Evaluate default constructor values and object count increment.
	@Test
	public void testDefaultConstructorAndObjectCount() 
	{
		System.out.println("----------START :: Test Default Constructor And ObjectCount ----------");
		int objCount = Name.getNumberOfNameObjects();
		
		Name n = new Name();
		
		if(n != null) 
		{
			System.out.println("Object created : PASS");
		}else 
		{
			System.out.println("Object Not created : FAIL");
		}

		if("NOFIRSTNAME".equals(n.getFirstName())) 
		{
			System.out.println("FirstName  : PASS");
		}else 
		{
			System.out.println("FirstName : FAIL");
		}

		
		if("NOMIDDLENAME".equals(n.getMiddleName())) 
		{
			System.out.println("MiddleName  : PASS");
		}else 
		{
			System.out.println("MiddleName : FAIL");
		}

		if("NOLASTNAME".equals(n.getLastName())) 
		{
			System.out.println("LastName  : PASS");
		}else 
		{
			System.out.println("LastName : FAIL");
		}

		if(n.getSeparator() == '#') 
		{
			System.out.println("Separator  : PASS");
		}else 
		{
			System.out.println("Separator : FAIL");
		}
		
		int newCount = Name.getNumberOfNameObjects();
		
		System.out.println("objCount : "+objCount);
		System.out.println("newCount : "+newCount);
		
		if((objCount+1) == newCount) 
		{
			System.out.println("Object count Incremented : PASS - " + newCount);
		}else 
		{
			System.out.println("Object count Incremented : FAIL - " + newCount);
		}
		System.out.println("----------END :: Test Default Constructor And ObjectCount ----------");
	}
	
	// 2. TestCase--Evalute Two-argument Constructor should be middleName to empty string and separator to ','
	@Test
	public void testTwoArgConstructor() 
	{
		System.out.println("----------START :: Test TWO Argument Constructor----------");

		int objCount = Name.getNumberOfNameObjects();
		
		Name n = new Name("Dhriti","Choksi");
		
		if("Dhriti".equals(n.getFirstName())) 
		{
			System.out.println("FirstName  : PASS");
		}else 
		{
			System.out.println("FirstName  : FAIL");
		}
		
		if("".equals(n.getMiddleName())) 
		{
			System.out.println("MiddleName  : PASS");
		}else 
		{
			System.out.println("MiddleName : FAIL");
		}

		if("Choksi".equals(n.getLastName())) 
		{
			System.out.println("LastName  : PASS");
		}else 
		{
			System.out.println("LastName : FAIL");
		}
		
		if(',' == n.getSeparator())
		{
			System.out.println("Separator : PASS");
		}else 
		{
			System.out.println("Separator : FAIL");
		}
		
		int newCount = Name.getNumberOfNameObjects();
		
		System.out.println("objCount : "+objCount);
		System.out.println("newCount : "+newCount);
		
		if((objCount+1) == newCount) 
		{
			System.out.println("Object count Incremented : PASS - " + newCount);
		}else 
		{
			System.out.println("Object count Incremented : FAIL - " + newCount);
		}
		System.out.println("----------End :: Test TWO Argument Constructor----------");
	}

	// 3. TestCase--Evalute Four-argument Constructor should be middleName to empty string and separator to ','
	@Test
	public void testFourArgConstructorInvalidSeparator() 
	{
		System.out.println("----------START :: Test Four Argument Constructor With Invalid Separator----------");

		int objCount = Name.getNumberOfNameObjects();
		
		Name n = new Name("Dhriti", "Rahul", "Choksi", '*');
		
		
		if(',' == n.getSeparator())
		{
			System.out.println("Separator : PASS");
		}else 
		{
			System.out.println("Separator : FAIL");
		}
		

		int newCount = Name.getNumberOfNameObjects();
		
		System.out.println("objCount : "+objCount);
		System.out.println("newCount : "+newCount);
		
		if((objCount+1) == newCount) 
		{
			System.out.println("Object count Incremented : PASS - " + newCount);
		}else 
		{
			System.out.println("Object count Incremented : FAIL - " + newCount);
		}
		System.out.println("----------END :: Test Four Argument Constructor With Invalid Separator----------");
	}
	
	// 4. TestCase--Evalute setseparator should only accept valid 
	// separators [',' , '-' , '#']
	@Test
	public void testSetSeparatetorValidAndInvalid() 
	{
		System.out.println("----------START :: Test Set Separator for Valid and Invalid ----------");

		Name n = new Name("Dhriti","Choksi");
		
		char original = n.getSeparator();
		
		n.setSeparator('-');
		
		if('-' == n.getSeparator())
		{
			System.out.println("Separator : PASS");
		}else 
		{
			System.out.println("Separator : FAIL");
		}
		
		// check invalid separator , should not change
		n.setSeparator('@');

		if('-' == n.getSeparator())
		{
			System.out.println("Separator : PASS");
		}else 
		{
			System.out.println("Separator : FAIL");
		}
		n.setSeparator(original);
		System.out.println("----------END :: Test Set Separator for Valid and Invalid ----------");
	}
	
	
//
//	@Test
//	public void test() 
//	{
//		fail("Not yet implemented");
//	}
}