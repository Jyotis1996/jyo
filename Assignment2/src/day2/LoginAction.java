package day2;

import java.util.*;

import javax.servlet.http.*;

import org.apache.struts.action.*;

import day2.FetchUserDataAction;
import day2.UserDataBean;

/**
 * LoginAction class will extends LogicBean class and accss he properties of it.
 * LoginAction class has a method called execute() which will validate the user
 * and give message accordingly
 *
 * @author Jyoti
 * Date-2019/09/02
 *
 */
public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginBean loginForm = null;
		LoginLogic objLoginLogic = null;
		ActionErrors errors = null;
		ActionForward actionValue = null;
		try {
			loginForm = (LoginBean) form;
			objLoginLogic = new LoginLogic();
			errors = new ActionErrors();
			// checks that forms filed are not null
			if (loginForm != null)
				if (objLoginLogic.validateUser(loginForm.getUserName(),
						loginForm.getPassword())) {
					// if username and password are correct
					FetchUserDataAction objFetchUserDataAction = new FetchUserDataAction();
					List<UserDataBean> userData = new ArrayList<>();
					userData = objFetchUserDataAction.fetchUserData(
							loginForm.getUserName(), loginForm.getPassword());
					request.setAttribute("userData", userData);
					request.setAttribute("userName", loginForm.getUserName());
					// for (int i = 0; i < userData.size(); i++) {
					// System.out.println(userData.get(i).getUserId());
					// }
					actionValue = mapping.findForward("success");
				} else {
					// if username and passwords are wrong
					errors.add("err_invalid", new ActionMessage("error.invalid.required"));
					saveErrors(request, errors);
					actionValue = mapping.findForward("invalid");
				}
			else
				actionValue = mapping.findForward("failure");
		} catch (Exception ex) {
			// if exception occurs than it will redirect user to login page
			actionValue = mapping.findForward("failure");
		} finally {
			// releasing resourcs
			loginForm = null;
			objLoginLogic = null;
		}
		return actionValue;
	}

}
