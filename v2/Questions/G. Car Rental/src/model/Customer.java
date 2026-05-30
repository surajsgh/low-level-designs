package model;

public class Customer {
    private String id;
    private String name;
    private String licenseNumber;
    private String contactNumber;

    public Customer(String id, String name, String licenseNumber, String contactNumber) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
