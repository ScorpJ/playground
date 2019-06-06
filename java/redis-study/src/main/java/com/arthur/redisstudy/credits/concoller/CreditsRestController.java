package com.arthur.redisstudy.credits.concoller;

import static com.arthur.redisstudy.credits.utils.CreditsConstant.CREDITS_CHANGETYPE_CONSUMINGS;
import static com.arthur.redisstudy.credits.utils.CreditsConstant.CREDITS_CHANGETYPE_EARNINGS;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.arthur.redisstudy.credits.domain.CreditLine;
import com.arthur.redisstudy.credits.model.UserCredits;
import com.arthur.redisstudy.credits.model.UserCreditsRequest;
import com.arthur.redisstudy.credits.model.UserCreditsResponse;
import com.arthur.redisstudy.credits.service.CreditsService;

@RestController
@RequestMapping("/userCredits")
public class CreditsRestController {

	@Autowired
	private CreditsService creditsService;

	public void setCreditsService(CreditsService creditsService) {
		this.creditsService = creditsService;
	}

	@RequestMapping(value = "/{userId}/{creditsChangeType}", method = RequestMethod.GET)
	public ResponseEntity<UserCredits> getUserCredits(@PathVariable("userId") Long userId,
			@PathVariable("creditsChangeType") String creditsChangeType) {
		UserCredits userCredits = new UserCredits();

		userCredits.setUserId(userId);
		userCredits.setBalance(creditsService.getUserCreditsBalance(userId));
		userCredits.setEarningsOfToday(creditsService.getEarningsOfToday(userId));
		if (StringUtils.isEmpty(creditsChangeType)) {
			userCredits.setEarningRecores(creditsService.getEarningLines(userId));
			userCredits.setConsumingRecores(creditsService.getConsumingLines(userId));
		} else if (CREDITS_CHANGETYPE_EARNINGS.equalsIgnoreCase(creditsChangeType)) {
			userCredits.setEarningRecores(creditsService.getEarningLines(userId));
		} else if (CREDITS_CHANGETYPE_CONSUMINGS.equalsIgnoreCase(creditsChangeType)) {
			userCredits.setConsumingRecores(creditsService.getConsumingLines(userId));
		}

		return new ResponseEntity<UserCredits>(userCredits, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, headers={"Content-Type=application/json"})
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UserCreditsResponse> createCreditLine(@RequestBody UserCreditsRequest request) {
		UserCreditsResponse response = new UserCreditsResponse();

		return new ResponseEntity<UserCreditsResponse>(response, HttpStatus.OK);

	}

}
