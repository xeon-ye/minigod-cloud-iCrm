package com.minigod.mail.demo.mail;

import java.io.IOException;

import com.minigod.mail.builder.SendCloudBuilder;
import com.minigod.mail.core.SendCloud;
import com.minigod.mail.exception.VoiceException;
import com.minigod.mail.util.ResponseData;
import org.apache.http.ParseException;

import com.minigod.mail.model.SendCloudVoice;

public class SendVoice {

	public static void send() throws ParseException, IOException, VoiceException {
		SendCloudVoice voice = new SendCloudVoice();
		voice.setCode("123456");
		voice.setPhone("12345678910;12345678911");

		SendCloud sc = SendCloudBuilder.build();
		ResponseData res = sc.sendVoice(voice);

		System.out.println(res.getResult());
		System.out.println(res.getStatusCode());
		System.out.println(res.getMessage());
		System.out.println(res.getInfo());
	}

	public static void main(String[] args) throws Throwable {
		send();
	}
}
