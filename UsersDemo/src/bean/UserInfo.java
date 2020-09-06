package bean;

import java.sql.*;

public class UserInfo {

    int id;
    String phone;
    String nickname;
    String password;
    int sex;
    Date birthday;
    Timestamp createTime;

    public UserInfo (){};

    public UserInfo(String phone,String password){

        this.phone = phone;
        this.password = password;
    };

    @Override
    public String toString() {
        return "bean.UserInfo{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", createTime=" + createTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public int getSex() {
        return sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
