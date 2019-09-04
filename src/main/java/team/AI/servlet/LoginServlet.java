package team.AI.servlet;

import com.google.gson.Gson;
import team.AI.DaoIMP.LoginIMP;
import team.AI.bean.LoginBean;
import team.AI.serviceIMP.LoginServiceIMP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean=new LoginBean();
        loginBean.setPhone(username);
        loginBean.setEmail(username);
        loginBean.setPassword(password);


        Gson gson=new Gson();
        Map<String, String> map=new HashMap<String, String>();
        if(!username.equals("")&&!password.equals("")){
            LoginServiceIMP loginServiceIMP=new LoginServiceIMP();
            LoginBean bean = loginServiceIMP.login(loginBean);
            if(bean!=null){
                HttpSession session = request.getSession();
                session.setAttribute("userinfo",bean);
            }else{
                map.put("2","账号或者密码错误");
            }
        }else{
            map.put("1","账号或者密码不能为空");
        }
        String json = gson.toJson(map);
        System.out.println(json.toString());
    }
}
