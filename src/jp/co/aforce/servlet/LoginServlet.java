package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.LoginBean;
import jp.co.aforce.models.LoginModel;

//親クラスにHttpServletを指定する

public class LoginServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{

//		GETリクエストはありえないので、無条件でログイン画面に飛ばす
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/views/login.jsp");
		rDispatcher.forward(request, response);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {





//		文字のエンコードをUTF-8とする。これがないと文字化け。
		request.setCharacterEncoding("UTF-8");

//		ユーザによって入力された情報を取り出す
		String username = request.getParameter("username");
		String password = request.getParameter("password");

//		取り出した情報をLoginBeanに格納する
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);

//		モデルををインスタンス化する
		LoginModel loginModel = new LoginModel();
		String forword_jsp = "/views/login.jsp";



//		入力された情報がDBに存在するか調べる
		if(loginModel.loginCheck(username, password)) {

//			TODO ここはオリジナル処理を考える↓↓
//			例）ログインしたユーザの情報を表示する
//			DB上にある全てのユーザ情報を取得
//			UserModel userModel = new UserModel();
//			List<UserBean>users = userModel.getAllUsers();
//			TODO ここはオリジナル処理を考える↑↑

//			リクエストオブジェクト設定
//			request.setAttribute("users",users);

//			ログインに成功した先の JSP を指定
			forword_jsp = "/views/success.jsp";

//		ログインが失敗したときの処理
		}else {
//			エラーメッセージを設定

			request.setAttribute("Emsg", "ユーザー名またはパスワードが違います");


		}
//		forward_jspに設定されているJSPへディスパッチ
		RequestDispatcher rDispatcher = request.getRequestDispatcher(forword_jsp);


		rDispatcher.forward(request,  response);
	}
}
