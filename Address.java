/**
 * This class represents an address. It includes the street,city, province, and
 * postal code.
 * 
 * @author Ellen Dalton
 */
public class Address {
    private String street;
    private String city;
    private String province;
    private String postalCode;

    /**
     * Constructs a new Address object.
     * 
     * @param street
     * @param city
     * @param province
     * @param postalCode
     */
    public Address(String street, String city, String province, String postalCode) {
        this.street = street;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    /**
     * Returns a string representation of an address. This includes the street
     * address, the city, the province, and the postal code.
     * 
     */
    public String toString() {
        return (street + "\n" + city + ", " + province + "\n" + postalCode);
    }
}
