/**
 * @author 许彬
 */
package com.lt.action.main;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 许彬
 *
 */
public class LoginAction extends ActionSupport {
	
	private String email;
	private String password;

	/**
	 * @author 许彬
	 */
	private static final long serialVersionUID = 1L;
	
	public String execute() throws Exception{
		/*ActionContext ac = ActionContext.getContext();
		Map<String, Object> para = ac.getParameters();
		String userName = ((String[])MapUtils.getObject(para, "email"))[0];
		String passWord = ((String[])MapUtils.getObject(para, "password"))[0];*/
		
		if("lt".equals(this.getEmail()) && "fy".equals(this.getPassword())){
			return SUCCESS;
		}
		return ERROR;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
