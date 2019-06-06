package com.arthur.ms.usercredit.concoller;

import static com.arthur.ms.usercredit.utils.CreditsConstant.CREDITS_CHANGETYPE_CONSUMINGS;
import static com.arthur.ms.usercredit.utils.CreditsConstant.CREDITS_CHANGETYPE_EARNINGS;

import org.apache.commons.lang.StringUtils;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.arthur.ms.usercredit.model.UserCredits;
import com.arthur.ms.usercredit.model.UserCreditsRequest;
import com.arthur.ms.usercredit.model.UserCreditsResponse;
import com.arthur.ms.usercredit.service.CreditsService;

@RestController
@RequestMapping("/userCredits")
public class CreditsRestController {

    private final Logger logger = Logger.getLogger(CreditsRestController.class);

    @Autowired
    private CreditsService creditsService;

//	@Autowired
//	private DiscoveryClient client;

//	public void setCreditsService(CreditsService creditsService) {
//		this.creditsService = creditsService;
//	}

    @RequestMapping(value = {"/{userId}/{creditsChangeType}", "/{userId}"}, method = RequestMethod.GET)
    public ResponseEntity<UserCredits> getUserCredits(@PathVariable("userId") Long userId,
                                                      @PathVariable(value = "creditsChangeType", required = false) String creditsChangeType) {
        UserCredits userCredits = new UserCredits();

        userCredits.setUserId(userId);
        userCredits.setBalance(creditsService.getUserCreditsBalance(userId));
        userCredits.setEarningsOfToday(creditsService.getEarningsOfToday(userId));
        if (StringUtils.isEmpty(creditsChangeType)) {
            userCredits.setEarningRecords(creditsService.getEarningLines(userId));
            userCredits.setConsumingRecords(creditsService.getConsumingLines(userId));
        } else if (CREDITS_CHANGETYPE_EARNINGS.equalsIgnoreCase(creditsChangeType)) {
            userCredits.setEarningRecords(creditsService.getEarningLines(userId));
        } else if (CREDITS_CHANGETYPE_CONSUMINGS.equalsIgnoreCase(creditsChangeType)) {
            userCredits.setConsumingRecords(creditsService.getConsumingLines(userId));
        }


//		ServiceInstance instance = (ServiceInstance) client.getInstances("UserCredits");
//		logger.info(""+ instance.getHost()+" " + "-----" + instance.getServiceId());


        return new ResponseEntity<UserCredits>(userCredits, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, headers = {"Content-Type=application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserCreditsResponse> createCreditLine(@RequestBody UserCreditsRequest request) {
        UserCreditsResponse response = new UserCreditsResponse();

        return new ResponseEntity<UserCreditsResponse>(response, HttpStatus.OK);

    }

}
