package com.krishna;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	@GetMapping(value="/{notificationId}")
	public Notification getNotification(@PathVariable("notificationId") String notificationId) {
		Notification notificationOne=new Notification(notificationId,"Notification Description for "+notificationId);
		return notificationOne;
	}

}
