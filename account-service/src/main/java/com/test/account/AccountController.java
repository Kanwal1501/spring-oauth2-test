package com.test.account;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AccountController {

	@PreAuthorize("#oauth2.hasScope('ui')") // denies access without CustomUserInfoTokenServices
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(Principal principal) {
		return "hello, " + principal.getName();
	}
}
