package team.AI.serviceIMP;

import team.AI.DaoIMP.LoginIMP;
import team.AI.bean.LoginBean;
import team.AI.service.LoginService;

public class LoginServiceIMP implements LoginService {
    LoginIMP loginIMP=new LoginIMP();
    @Override
    public LoginBean login(LoginBean loginBean) {
        LoginBean bean = loginIMP.login(loginBean);
        return bean;
    }
}
