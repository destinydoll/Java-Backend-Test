package com.example.test.DTO;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @JsonView({View.Register.class,View.Login.class,View.userShownData.class})
    private String userName;
    @JsonView({View.Register.class,View.Login.class})
    private String password;
    @JsonView({View.Register.class,View.userShownData.class})
    private String email;
    private String memberType;
    @JsonView({View.Register.class,View.userShownData.class})
    private Integer salary;
    @JsonView(View.userShownData.class)
    private String Refcode;
    @JsonView({View.Register.class,View.userShownData.class})
    private String phone;
    @JsonView(View.userShownData.class)
    private Date registerDate;




    @JsonIgnore
    public boolean isReject(){
        return this.salary <= 15000;
    }



    public User() {
    }

    public User(Long id, String userName, String password, String email, Integer salary, String phone) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.salary = salary;
        this.phone = phone;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMemberType() {
        return this.memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public Integer getSalary() {
        return this.salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getRefcode() {
        return this.Refcode;
    }

    public void setRefcode(String Refcode) {
        this.Refcode = Refcode;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegisterDate() {
        return this.registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public User id(Long id) {
        this.id = id;
        return this;
    }

    public User userName(String userName) {
        this.userName = userName;
        return this;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public User memberType(String memberType) {
        this.memberType = memberType;
        return this;
    }

    public User salary(Integer salary) {
        this.salary = salary;
        return this;
    }

    public User Refcode(String Refcode) {
        this.Refcode = Refcode;
        return this;
    }

    public User phone(String phone) {
        this.phone = phone;
        return this;
    }

    public User registerDate(Date registerDate) {
        this.registerDate = registerDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(memberType, user.memberType) && Objects.equals(salary, user.salary) && Objects.equals(Refcode, user.Refcode) && Objects.equals(phone, user.phone) && Objects.equals(registerDate, user.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, email, memberType, salary, Refcode, phone, registerDate);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userName='" + getUserName() + "'" +
            ", password='" + getPassword() + "'" +
            ", email='" + getEmail() + "'" +
            ", memberType='" + getMemberType() + "'" +
            ", salary='" + getSalary() + "'" +
            ", Refcode='" + getRefcode() + "'" +
            ", phone='" + getPhone() + "'" +
            ", registerDate='" + getRegisterDate() + "'" +
            "}";
    }


}