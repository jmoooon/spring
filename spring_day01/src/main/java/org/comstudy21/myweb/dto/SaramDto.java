package org.comstudy21.myweb.dto;
/**
 * 
 * Model �̴�.
 *
 */
public class SaramDto {
	private String id = null;
	private String name = null;
	private int age = 0;
	
	public SaramDto() {
	}
	public SaramDto(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SaramDto [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
