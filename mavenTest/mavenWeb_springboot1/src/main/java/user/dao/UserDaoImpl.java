package user.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void addUser() {

        System.out.println("数据库添加用户");
    }
}
