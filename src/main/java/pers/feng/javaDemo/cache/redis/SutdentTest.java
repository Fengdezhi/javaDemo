package pers.feng.javaDemo.cache.redis;

import java.io.Serializable;

public class SutdentTest implements Serializable{

	private static final long serialVersionUID = 4978108026967139054L;
	private String  name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
