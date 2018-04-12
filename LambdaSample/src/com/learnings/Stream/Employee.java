package com.learnings.Stream;

public class Employee {

	private long id;
	private String name;
	private String address;
	private String desigination;
	private int salary;
	private int phoneNumber;
	private String projectName;
	
	public Employee(long id, String name, String address, String desigination, int salary, int phoneNumber,
			String projectName) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.desigination = desigination;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.projectName = projectName;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesigination() {
		return desigination;
	}
	public void setDesigination(String desigination) {
		this.desigination = desigination;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "Employee [ id=" + id + ", " +"\n"
				+ "name=" + name + ", "  +"\n"
				+ "address=" + address + ", "  +"\n"
				+ "desigination=" + desigination  +"\n"
				+ ", salary=" + salary + ", "  +"\n"
				+ "phoneNumber=" + phoneNumber + ", "  +"\n"
				+ "projectName=" + projectName + "]"  +"\n";
	}
	
	 @Override
	    public boolean equals(Object obj) {
	        Employee compareEmployee = (Employee) obj;
	        if(this.name != null && compareEmployee != null){
	            return this.name.equalsIgnoreCase(compareEmployee.getName());
	        }else{
	            return false;
	        }
	    }

	    @Override
	    public int hashCode() {
	        if(this.name != null && !this.name.trim().isEmpty()){
	            return this.name.hashCode();
	        }else{
	            return -1;
	        }
	    } 
}
