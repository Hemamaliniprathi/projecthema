package com.omrbranch.stepdefinition;

import org.junit.Assert;

import com.omrbranch.manager.PageObjectManager;
import com.omrbranch.utility.BaseClass;

import io.cucumber.java.en.*;

public class TC001_LoginStep extends BaseClass {
	private final PageObjectManager pom = new PageObjectManager();

	@Given("User is on the OMR Branch hotel page")
	public void userIsOnTheOMRBranchHotelPage() {
	}

	@When("User enters {string} and {string}")
	public void userEntersAnd(String UserName, String Password) {
		pom.getLoginPage().login(UserName, Password);
	}

	@Then("User should verify success message after login {string}")
	public void userShouldVerifySuccessMessageAfterLogin(String expectedLoginMessage) {
		String actLoginMessageText = pom.getExploreHotelPage().getLoginMessageText();
		Assert.assertEquals("verify after Login", expectedLoginMessage, actLoginMessageText);
	}

	@When("User enters {string} and {string} with enter key")
	public void userEntersAndWithEnterKey(String UserName, String Password) {

	}

	@Then("User should verify error message after login {string}")
	public void userShouldVerifyErrorMessageAfterLogin(String ErrorMessage) {
	}

}