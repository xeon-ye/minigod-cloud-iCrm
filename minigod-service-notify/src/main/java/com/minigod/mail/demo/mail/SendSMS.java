package com.minigod.mail.demo.mail;

import java.io.IOException;

import com.minigod.mail.builder.SendCloudBuilder;
import org.apache.http.client.ClientProtocolException;

import com.minigod.mail.core.SendCloud;
import com.minigod.mail.exception.SmsException;
import com.minigod.mail.model.SendCloudSms;
import com.minigod.mail.util.ResponseData;

public class SendSMS {

	public static void send() throws ClientProtocolException, IOException, SmsException {
		SendCloudSms sms = new SendCloudSms();
		sms.setMsgType(0);
		sms.setTemplateId(948);
		sms.addPhone("12345678911,12345678910");
		sms.addVars("company", "爱发信");
		sms.addVars("date", "2016.04.02");

		SendCloud sc = SendCloudBuilder.build();
		ResponseData res = sc.sendSms(sms);

		System.out.println(res.getResult());
		System.out.println(res.getStatusCode());
		System.out.println(res.getMessage());
		System.out.println(res.getInfo());
	}

	public static void main(String[] args) throws Throwable {
		send();
	}
}
