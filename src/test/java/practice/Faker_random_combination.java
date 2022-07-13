package practice;

import java.util.Random;

import com.github.javafaker.Faker;

public class Faker_random_combination {

	public static void main(String[] args) {
		Faker fake=new Faker();
		Random r=new Random();
		int random=r.nextInt(1000);
		 String id=fake.name().firstName();
		String suffix="@gmail.com";
		String mailId = id+random+suffix;
		System.out.println(mailId);

	}

}
