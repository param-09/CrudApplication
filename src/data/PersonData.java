package data;

import java.util.*;
import bean.Person;
import java.sql.*;  
  
public class PersonData 
{  
  
    private static ArrayList<Person> personList = new ArrayList<>();
    private static int idGenerator = 0;
    
    public static boolean save(Person person)
    {  
    	boolean status = false;  
        idGenerator++;
        try
        {  
        	person.setId(idGenerator);
            status = personList.add(person); 
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }  
        return status;  
    }  
    
    public static void update(Person person)
    {  
        try
        {  
        	for (Person person1 : personList) 
        	{
				if(person.getId() == person1.getId())
				{
					person1.setName(person.getName());
					person1.setAddress(person.getAddress());
					person1.setEmail(person.getEmail());
					person1.setContact(person.getContact());
				}
			}
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
    	}  
    }  
    
    public static boolean delete(int id)
    {
    	boolean deleted = false;
    	try
        {  
        	for (Person person : personList) 
        	{
				if(person.getId() == id)
				{
					personList.remove(person);
					deleted = true;
					break;
				}
			}
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
    	}
    	return deleted;
    }  
    
    public static Person getPersonById(int id)
    {  
        Person tempPerson = null;
    	try
        {
    		for (Person person : personList) 
    		{
				if(person.getId() == id)
				{
					tempPerson = person;
					break;
				}
			}
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }  
        return tempPerson;
    }  
    
    public static List<Person> getAllPersons()
    {  
        return personList;  
    }
    
    public static List<Person> searchPersons(String searchString)
    {  
    	ArrayList<Person> searchedList = new ArrayList<>();
    	for (Person person : personList) 
    	{
			if(person.getName().contains(searchString))
			{
				searchedList.add(person);
			}
			else if(person.getAddress().contains(searchString))
			{
				searchedList.add(person);
			}
			else if(person.getEmail().contains(searchString))
			{
				searchedList.add(person);
			}
			else if(person.getContact().contains(searchString))
			{
				searchedList.add(person);
			}
		}
        return searchedList;  
    }
}