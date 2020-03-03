package com.minigod.api.user.utils;

import java.util.UUID;

public class IdentitiesUtil {

	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}
}
