package com.zl.jdbc.apche.dbutils.domain;

public class Jpa_persons {
  private String id;
  private String add_id;
  private java.sql.Timestamp birth;
  private String email;
  private String last_name;
  private String address_id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAdd_id() {
    return add_id;
  }

  public void setAdd_id(String add_id) {
    this.add_id = add_id;
  }

  public java.sql.Timestamp getBirth() {
    return birth;
  }

  public void setBirth(java.sql.Timestamp birth) {
    this.birth = birth;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getAddress_id() {
    return address_id;
  }

  public void setAddress_id(String address_id) {
    this.address_id = address_id;
  }
}
