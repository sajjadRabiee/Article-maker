package Service.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_info" , catalog = "schema1" , schema = "schema1")
public class UserInfo implements EntityInterface {
    @Id
    private long id;
    @Column(name = "username" , unique = true)
    private String username;
    @Column(name = "national_code" , unique = true)
    private String nationalCode;
    @Column(name = "address")
    private Address address;
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
