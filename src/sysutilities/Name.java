package sysutilities;

import java.util.Objects;

public class Name 
{
	String firstName,middleName,lastName,nickname;
	char separator;
	
	// will keep track of the number of instances created 
	// by using a  private static field
	private static int nameObjsCount ;

	// static properties initialise by static block
	static 
	{
		nameObjsCount = 0;
	}
	
	// Default Constructor 
	public Name() 
	{
		firstName = "NOFIRSTNAME";
		middleName = "NOMIDDLENAME";
		lastName = "NOLASTNAME";
		this.separator = '#';
		nameObjsCount++;
	}
	// 	Consructor with Two Parameters and separator = ','
	public Name(String firstName, String lastName) 
	{
		this.firstName = firstName;
		middleName = "";
		this.lastName = lastName;
		this.separator = ',';
		nameObjsCount++;
	}
	// 	Consructor with Three Parameters and separator = ','
	public Name(String firstName, String middleName, String lastName) 
	{
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.separator = ',';
		
		nameObjsCount++;
	}
	// 	Consructor with Four Parameters and separator = ','
	public Name(String firstName, String middleName, String lastName,char separator) 
	{
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		
		if(validSeparator(separator)) 
		{
			this.separator = separator;
		}else 
		{
			this.separator = ',';
		}
		nameObjsCount++;
	}
	
	public String getNickname() 
	{
		if(nickname == null) 
		{
			return "";
		}
		return nickname;
	}
	public void setNickname(String nickname) 
	{
		this.nickname = nickname;
	}
	public char getSeparator() 
	{
		return separator;
	}
	public void setSeparator(char separator) 
	{
		if (validSeparator(separator)) 
		{
			this.separator = separator;
		}
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public String getMiddleName() 
	{
		return middleName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public static int getNumberOfNameObjects() 
	{
		return nameObjsCount;
	}
	// We can use this method when you need to validate a separator
	private boolean validSeparator(char separator) 
	{
		if(separator == ',' || separator=='-' || separator == '#') 
		{
			return true;
		}
		return false;
	}
	// two names are considered equal if they have the same first,middle and last names.
	// The nickname is ignored.
	@Override
	public boolean equals(Object obj) 
	{
		// 1. cast the obj to Name Type to compare the fields.
		Name otherName = (Name)obj;

		// 2. compare the significant fields : 
		// firstName , middleName,  lastName 
		
//		boolean firstNameFlag = Objects.equals(firstName, otherName.firstName);
//		boolean lastNameFlag = Objects.equals(lastName, otherName.lastName);

		boolean firstNameFlag;
		boolean lastNameFlag;
		
		if(firstName == null) 
		{
			if(otherName.firstName == null) 
			{
				firstNameFlag = true;
			}else 
			{
				firstNameFlag = false;				
			}
			
		}else 
		{
			firstNameFlag = firstName.equals(otherName.firstName);
		}
		
		
		if(lastName == null) 
		{
			if(otherName.lastName == null) 
			{
				lastNameFlag = true;
			}else 
			{
				lastNameFlag = false;				
			}
			
		}else 
		{
			lastNameFlag = lastName.equals(otherName.lastName);
		}
		
		boolean middleNameFlag;
		
		if(middleName == null || middleName.isEmpty()) 
		{
			middleNameFlag = (otherName.middleName==null) || otherName.middleName.isEmpty();
		}else 
		{
			middleNameFlag = middleName.equals(otherName.middleName);
		}
		
		return firstNameFlag && lastNameFlag && middleNameFlag;
	}
	
	@Override
	public String toString() 
	{
		if(getMiddleName() == null) 
		{
			return getLastName() + separator + getFirstName();
		}else 
		{
			if(getNickname() == null || getNickname().trim().length() == 0) 
			{
				return getLastName() + separator + getFirstName() + separator + getMiddleName();
			}else 
			{
				return getLastName() + separator + getFirstName() + separator + getMiddleName() +"("+getNickname()+")";
			}
		}
	}
	
	public int compareTo(Name n) 
	{
		int result;
		
		// First Compare LastName
		result  = this.lastName.compareToIgnoreCase(n.lastName);
		
		if(result != 0) 
		{
			return result; 
		}
		
		// if LastName are same then comapre Firstname
		result  = this.firstName.compareToIgnoreCase(n.firstName);
		
		if(result != 0) 
		{
			return result; 
		}

		// If LastName and Firstname are same then, compare middleName
		result  = this.middleName.compareToIgnoreCase(n.middleName);
		return result; 
	}
	
	
	public static Name normalize(Name obj, boolean flag) 
	{
		if(obj == null) 
		{
			return null;
		}
		Name newNameObj = new Name();

		if(flag) 
		{
			if(obj.firstName != null) 
			{
				newNameObj.firstName = obj.firstName.toUpperCase();
			}else 
			{
				newNameObj.firstName = null;
			}
			
			if(obj.lastName != null) 
			{
				newNameObj.lastName = obj.lastName.toUpperCase();
			}else 
			{
				newNameObj.lastName = null;
			}
			
			if(obj.middleName != null) 
			{
				newNameObj.middleName = obj.middleName.toUpperCase();
			}else 
			{
				newNameObj.middleName = null;
			}
		}else 
		{
			if(obj.firstName != null) 
			{
				newNameObj.firstName = obj.firstName.toLowerCase();
			}else 
			{
				newNameObj.firstName = null;
			}
			
			if(obj.lastName != null) 
			{
				newNameObj.lastName = obj.lastName.toLowerCase();
			}else 
			{
				newNameObj.lastName = null;
			}
			
			if(obj.middleName != null) 
			{
				newNameObj.middleName = obj.middleName.toLowerCase();
			}else 
			{
				newNameObj.middleName = null;
			}
		}
		newNameObj.separator = ',';
				
		return newNameObj;
	}
	
}