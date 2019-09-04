package team.AI.DaoIMP;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import team.AI.Dao.LoginDao;
import team.AI.bean.LoginBean;
import team.AI.utils.DBUtiles;

import java.sql.SQLException;
import java.util.List;

public class LoginIMP implements LoginDao {
    /*
        判断数据库中是否有此用户
    */
    public LoginBean login(LoginBean loginBean) {
        QueryRunner runner = new QueryRunner(DBUtiles.getDataSource());
        String sql = "select * from user where (phone='" + loginBean.getPhone() + "' and password='" + loginBean.getPassword() + "') or (email='" + loginBean.getEmail() + " 'and password='" + loginBean.getPassword() + "') ";
        //or email="+loginBean.getEmail()+" and password="+loginBean.getPassword()+"
        try {
            List<LoginBean> list = runner.query(sql, new BeanListHandler<LoginBean>(LoginBean.class));
           if(!list.isEmpty()){
               return list.get(0);
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        LoginBean loginBean = new LoginBean();
        loginBean.setPhone("17856002909");
        loginBean.setEmail("319732708@qq.com");
        loginBean.setPassword("123456");

        LoginIMP loginIMP = new LoginIMP();
        LoginBean bean = loginIMP.login(loginBean);
        System.out.println(bean);
    }
}
