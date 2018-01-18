package BeetlSQL.pojo;

import java.math.*;
import java.util.Date;

/*
*
* gen by beetlsql 2016-01-06
*/
public class User  {

    private Integer id ; //主键需要通过注解来说明，如@AutoID，或者@AssignID等，但如果是自增主键，且属性是名字是id，则不需要注解，自动认为是自增主键
    private Integer age ;
    //用户角色
    private Integer roleId ;
    private String name ;
    //用户名称
    public  Integer getId() {
        return id;
    }public void    setId(Integer id) {
        this.id = id;
    }public Integer getAge() {
        return age;
    }public void    setAge(Integer age) {
        this.age = age;
    }public Integer getRoleId() {
        return roleId;
    }public void    setRoleId(Integer roleId) {
        this.roleId = roleId;
    }public String  getName() {
        return name;
    }public void    setName(String name) {
        this.name = name;
    }public String  getUserName() {
        return userName;
    }public void    setUserName(String userName) {
        this.userName = userName;
    }public Date    getCreateDate() {
        return createDate;
    }public void    setCreateDate(Date createDate) {
        this.createDate = createDate;
    }private String userName ;
    private Date createDate ;

}
