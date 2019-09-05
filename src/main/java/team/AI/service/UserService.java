package team.AI.service;

import team.AI.bean.UserBean;

public interface UserService {
    /*
        用户登陆
    */
    public abstract UserBean login(UserBean userBean);

    /*
        用户注册
    */
    public abstract Boolean reg(UserBean userBean);

    /*
        判断手机号和邮箱是否存在
    */
    public abstract Boolean isExistPhoneAndEmail(UserBean userBean);
}
