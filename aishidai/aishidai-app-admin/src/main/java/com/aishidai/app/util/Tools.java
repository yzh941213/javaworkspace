package com.aishidai.app.util;

import java.util.UUID;


public class Tools {

	public static String getGuid() {

		UUID uuid = UUID.randomUUID();

		return uuid.toString();
	}

}
