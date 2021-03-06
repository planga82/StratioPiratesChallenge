package com.challenge.pirates.util;

public class GeneralConstants {
	
	private GeneralConstants() {}

	public static final String VERSION_BASE = "/v1";
	public static final String URL_BASE = "/pirates/challenge/api" + VERSION_BASE;
	
	public static final String CODE_10000 = "10000";
	public static final String CODE_10001 = "10001";
	public static final String CODE_10002 = "10002";
	public static final String CODE_10003 = "10003";
	public static final String CODE_10004 = "10004";
	
	
	public static final String EVENT_ARRIVAL = "A";
	public static final String EVENT_DEPARTURE = "D";
	public static final String EVENT_ALL = "ALL";
	
	
	public static final String SUCCESS_CREATED = "Successfully created";
	public static final String INTERNAL_SERVER_ERROR = "Internal server error";
	
	public static final int replicaRetries=3;
}
