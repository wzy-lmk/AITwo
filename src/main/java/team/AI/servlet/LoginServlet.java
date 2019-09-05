package team.AI.servlet;

import com.google.gson.Gson;
import team.AI.bean.UserBean;
import team.AI.serviceIMP.UserServiceIMP;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
    用户登陆
*/
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserBean userBean =new UserBean();
        userBean.setPhone(username);
        userBean.setEmail(username);
        userBean.setPassword(password);


        Gson gson=new Gson();
        Map<String, String> map=new HashMap<String, String>();
        if(!username.equals("")&&!password.equals("")){
            UserServiceIMP loginServiceIMP=new UserServiceIMP();
            UserBean bean = loginServiceIMP.login(userBean);
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
        response.getWriter().println(json);
        System.out.println("end");
    }
}
