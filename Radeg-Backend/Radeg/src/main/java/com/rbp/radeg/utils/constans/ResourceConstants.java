package com.rbp.radeg.utils.constans;

public class ResourceConstants {

	public static final String APPLICATION_NAME = "/flea-market";
	public static final String API_VERSION_1 = "/v1";
	public static final String SUCCESS = "Success";


	/*User*/
	public static final String RESOURCE_USER = "/user";
	public static final String RESOURCE_NEW_USER = "/new_user";
	public static final String RESOURCE_USER_LOGIN = "/user/login";
	public static final String RESOURCE_USER_ID = "/{idUser}";


	/*RoleUser*/
	public static final String RESOURCE_ROLE_USER = "/roleUser";
	public static final String RESOURCE_ID_ROLE_USER = "/{idRoleUser}";


	/*Weight*/
	public static final String RESOURCE_WEIGHT = "/weight";
	public static final String RESOURCE_NEW_WEIGHT = "/{idUser}/{weight}";
	public static final String RESOURCE_NEW_ALL_WEIGHT = "/{idUser}";
	public static final String RESOURCE_DELETE_WEIGHT = "/{idUser}/{idWeight}";


	/*Muscle Group*/
	public static final String RESOURCE_MUSCLE_GROUP = "/muscleGroup";

	/*Muscle SubGroup*/
	public static final String RESOURCE_MUSCLE_SUBGROUP = "/muscleSubGroup";


	/*Training*/
	public static final String RESOURCE_TRAINING = "/training";


	/*Exercise*/
	public static final String RESOURCE_EXERCISE = "/exercise";


}
