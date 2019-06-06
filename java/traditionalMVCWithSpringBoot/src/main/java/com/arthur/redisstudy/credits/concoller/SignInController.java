package com.arthur.redisstudy.credits.concoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arthur.redisstudy.credits.model.SignInResponse;
import com.arthur.redisstudy.credits.service.SignInService;

@RestController
@RequestMapping("/userSignIns")
public class SignInController {
	
	
	
	@Autowired
	private SignInService signInService;
//	@Autowired
//	private RestTemplate restTemplate;
	
	
	public void setSignInService(SignInService signInService) {
		this.signInService = signInService;
	}
	
//	public void setRestTemplate(RestTemplate restTemplate) {
//		this.restTemplate = restTemplate;
//	}


	@RequestMapping(value = "/{userId}",method = RequestMethod.POST, headers={"Content-Type=application/json"})
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<SignInResponse> doSignIn(@PathVariable("userId") Long userId) {
		SignInResponse response = new SignInResponse();
		HttpStatus respStatus;
		
		Long signInPoint = signInService.signIn(userId);
		
		
		if (signInPoint.equals(0l)){
			/* User has signed today */
			respStatus = HttpStatus.OK;
			response.setMessage("You have signed in aleard today.");
		}else{
			/*TODO  */
//			Content-Type=application/json
			
//			HttpEntity<?> requestEntity = new HttpEntity<>();
//			restTemplate.exchange("", RequestMethod.POST, null, UserCreditsResponse.class, null);
			respStatus = HttpStatus.CREATED;
		}

		return new ResponseEntity<SignInResponse>(response, respStatus);

	}

}
