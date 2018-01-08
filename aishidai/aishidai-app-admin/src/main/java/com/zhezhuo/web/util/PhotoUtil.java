package com.zhezhuo.web.util;

public class PhotoUtil {
	
	public static String addPhoto(String str) {
		String images[] = str.split(";");
		String image = "";
		for (int i = 0; i < images.length; i++) {
			if (images[i].contains("?imageMogr2/thumbnail/!30p")) {
				if (!(i == images.length - 1)) {
					image += images[i] + ";";
				} else {
					image += images[i];
				}

			} else {
				if (!(i == images.length - 1)) {
					image += images[i] + "?imageMogr2/thumbnail/!30p;";
				} else {
					image += images[i] + "?imageMogr2/thumbnail/!30p";
				}
			}

		}
		return image;

	}
}
