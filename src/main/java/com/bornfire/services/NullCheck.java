package com.bornfire.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NullCheck {
	private static final Logger logger = LoggerFactory.getLogger(NullCheck.class);

	public static String isNotNull(String txt) {
		if (logger.isDebugEnabled()) {
			logger.debug("isNotNull()!");
		}

		return txt != null && txt.trim().length() > 0 ? txt.trim() : "";
	}

	public static String isEmpty(String txt) {
		if (logger.isDebugEnabled()) {
			logger.debug("isNotNull()!");
		}

		return txt != "" && txt.trim().length() > 0 ? txt.trim() : "";
	}

	public static String isEmptyForNone(String txt) {
		if (logger.isDebugEnabled()) {
			logger.debug("isNotNull()!");
		}

		return txt != "" && txt.trim().length() > 0 ? txt.trim() : " ";
	}

	public static Boolean isBooleanNull(String txt) {
		if (logger.isDebugEnabled()) {
			logger.debug("isBooleanNull()!");
		}
		return txt != null && txt.trim().length() > 0 ? true : false;

	}

	public static String isNotNullForExcel(String txt) {
		if (logger.isDebugEnabled()) {
			logger.debug("isNotNull()!");
		}

		return txt != null && txt.trim().length() > 0 ? txt.trim() : "N/A";
	}
}
