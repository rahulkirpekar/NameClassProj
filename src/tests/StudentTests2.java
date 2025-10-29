package tests;

import org.junit.Test;

import sysutilities.Name;

public class StudentTests2 
{
	// 5. check Nickname getters/setters behaviour and effect on toString
	@Test
	public void testNicknameAndToString() 
	{
		System.out.println("----------START :: Test test Nickname And ToString----------");
	
		Name n = new Name("Dhriti", "Rahul", "Choksi");
		
		
		// no nickname initially : getNickname should  return "" per impl
		
		if("".equals(n.getNickname())) 
		{
			System.out.println("NICKNAME :  PASS");
		}else 
		{
			System.out.println("NICKNAME :  FAIL");
		}
		
		// toString without nickname  last,first,middle
		String profile = n.toString();
		
		
		if(profile.contains("Choksi")) 
		{
			System.out.println("LASTNAME : PASS");
		}else 
		{
			System.out.println("LASTNAME : FAIL");
		}
		
		if(profile.contains("Rahul")) 
		{
			System.out.println("MIDDLENAME : PASS");
		}else 
		{
			System.out.println("MIDDLENAME : FAIL");
		}
		
		
		if(profile.contains("Dhriti")) 
		{
			System.out.println("FIRSTNAME : PASS");
		}else 
		{
			System.out.println("FIRSTNAME : FAIL");
		}
		
		// set NickName and evalute toString includes it in parentheses
		n.setNickname("dhriti");
		
		String withNickname = n.toString();
		
		if(withNickname.contains("("+"dhriti"+")")) 
		{
			System.out.println("WITH NICKNAME : PASS");
		}else 
		{
			System.out.println("WITH NICKNAME : FAIL");
		}
		System.out.println("----------END :: Test test Nickname And ToString----------");
	}
	
	// 6. test normalize method
	@Test
	public void testNormalizeUpperAndLowerAndNewObjectWithCommaSeparator() 
	{
		System.out.println("----------START :: Test Normalize UpperAndLower AndNewObject With CommaSeparator ----------");

		// check get null obj or not when we pass Person Null obj in normalize method
		Name newNameObj = null;
		
		Name objResponse = Name.normalize(newNameObj, true);
		
		if (objResponse == null)
		{
			System.out.println("Name Obj PASS : " + objResponse);
		} else 
		{
			System.out.println("Name Obj FAIL : " + objResponse);
		}
		
		Name obj = new Name("dhriti", "rahul", "choksi");

		
		// check Capital for true value pass
		Name newResponse1 = Name.normalize(obj, true);
		
		System.out.println("newResponse1 : " + newResponse1 );
		
		if(	
				newResponse1.getFirstName().equals("DHRITI") 
				&& 
				newResponse1.getMiddleName().equals("RAHUL")  
				&&
				newResponse1.getLastName().equals("CHOKSI") 
		  ) 
		{
			System.out.println("FirstName , MiddleName , Lastname : PASS");
		}else 
		{
			System.out.println("FirstName , MiddleName , Lastname : FAIL");
		}
		
		
		// check Capital for false value pass
		Name newResponse2 = Name.normalize(obj, false);
		
		System.out.println("newResponse2 : " + newResponse2 );
		
		if(	
				newResponse2.getFirstName().equals("dhriti") 
				&& 
				newResponse2.getMiddleName().equals("rahul")  
				&&
				newResponse2.getLastName().equals("choksi") 
		  ) 
		{
			System.out.println("FirstName , MiddleName , Lastname : PASS");
		}else 
		{
			System.out.println("FirstName , MiddleName , Lastname : FAIL");
		}

		System.out.println("----------END :: Test Normalize UpperAndLower AndNewObject With CommaSeparator ----------\n");
	}
}
