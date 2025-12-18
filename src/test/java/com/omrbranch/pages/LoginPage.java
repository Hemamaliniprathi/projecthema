package com.omrbranch.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.utility.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	public WebElement txtUserName;
	@FindBy(id = "pass")
	public WebElement txtPassWord;
	@FindBy(xpath = "//button[@value='login']")
	public WebElement btnLogin;
	@FindBy(id = "errorMessage")
	public WebElement errLoginMessage;

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassWord;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement geterrLoginPage() {
		return errLoginMessage;
	}

//1. Login
	public void login(String userName, String Password) {
		elementSendKeys(txtUserName, userName);
		elementSendKeys(txtPassWord, Password);
		elementClick(btnLogin);
	}

//		2.Login With Enter Key
	public void loginWithEnterKey(String userName, String password) throws AWTException {
		elementSendKeys(txtUserName, userName);
		elementSendKeys(txtPassWord, password);
		enterKey();
	}

//		3.Insert invalid Credentials and Get Error Message
	public String getErrorMessageText(String username, String password) {
		elementSendKeys(txtUserName, username);
		elementSendKeys(txtPassWord, password);
		elementClick(btnLogin);
		String textLogin = getElementText(errLoginMessage);
		return textLogin;
	}

}
