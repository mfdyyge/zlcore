package com.zl.core.jdbc.apche.dbutils.pojo;

public class Fw_notify {
  private String id;
  private String title;
  private String source;
  private String target;
  private String content;
  private String create_id;
  private String create_name;
  private java.sql.Date create_date;
  private String state;
  private java.sql.Date expire_date;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCreate_id() {
    return create_id;
  }

  public void setCreate_id(String create_id) {
    this.create_id = create_id;
  }

  public String getCreate_name() {
    return create_name;
  }

  public void setCreate_name(String create_name) {
    this.create_name = create_name;
  }

  public java.sql.Date getCreate_date() {
    return create_date;
  }

  public void setCreate_date(java.sql.Date create_date) {
    this.create_date = create_date;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public java.sql.Date getExpire_date() {
    return expire_date;
  }

  public void setExpire_date(java.sql.Date expire_date) {
    this.expire_date = expire_date;
  }
}
