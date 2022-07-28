package com.Vtiger_generic;

import java.util.Random;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

/**
 * @author Hp
 * @return 
 * @description:This class  is going to create Fake data which s required for TestExecution
 */
public class Fakedata {
Faker fake=new Faker();
/**
 * @author Hp
 * description: This method is going to generate  a random name 
 * @return String Random name 
 */

public String firstName() {
return fake.name().firstName();	

/**
 * @author Hp
 * description: This method is going to generate  a random name 
 * @return String Random name 
 */
}
public String lastName() {
return fake.name().lastName();	

/**
 * @author Hp
 * Description: This method returns random organization names
 * @return String Random name 
 */
}
public String orgname() {
	return fake.name().name();
}
/**
 * @author Hp
 * Description : This method returns random numbers 
 * @return int Random number
 */
static Random number=new Random();
public int randomNumber() {
	
	int  rnumber = number.nextInt(1000);
	return rnumber;
}
/**
 * @author Hp
 * Description: This method returns Random Campaign names
 * @return 
 * @return String Random name 
 */
public String campName() {
	return fake.name().name();
}

}








