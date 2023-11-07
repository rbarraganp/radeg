package com.rbp.radeg.utils.constans;

public class ExceptionConstants {


	private ExceptionConstants() {
		throw new IllegalStateException("Utility Class");
	}

	public static final String ERROR = "ERROR";

	public static final String INTERNAL_SERVER_ERROR = "INTERNAL_SERVER_ERROR - An internal server error has ocurred";


	/** * DEFAULT USER */
	public static final String MESSAGE_NOT_FOUND_DEFAULT_USER = "NOT_FOUND_DEFAULT_USER -The main user is not found";

	/** * USER */
	public static final String MESSAGE_ALREADY_EXIST_NICK_USER = "ALREADY_EXIST_NICK_USER- This user´s nick is already registered";
	public static final String MESSAGE_ALREADY_EXIST_EMAIL_USER = "ALREADY_EXIST_EMAIL_USER- This user´s email is already registered";
	public static final String MESSAGE_INEXISTENT_USER = "INEXISTENT_USER- This user not registered ";

	/** * ROLE_USER */
	public static final String MESSAGE_INEXISTENT_ROLE_USER = "INEXISTENT_ROLE_USER This RoleUser not registered ";
	public static final String MESSAGE_ALREADY_EXIT_ROLE_USER = "ALREADY_EXIST_ROLE_USER This TypeRole is already registered ";


	/** * WEIGHT */
	public static final String MESSAGE_INEXISTENT_WEIGHT = "INEXISTENT_WEIGHT- This user´s weight not exist";


	/** * MUSCLE GROUP */
	public static final String MESSAGE_ALREADY_EXIST_MUSCLE_GROUP_NAME = "ALREADY_EXIST_MUSCLE_GROUP_NAME- This name is already in use ";
	public static final String MESSAGE_INEXISTENT_MUSCLE_GROUP = "INEXISTENT_MUSCLE_GROUP- This muscle group not exist";


	/** * MUSCLE SUBGROUP */
	public static final String MESSAGE_ALREADY_EXIST_MUSCLE_SUBGROUP_NAME = "ALREADY_EXIST_MUSCLE_SUBGROUP_NAME- This name is already in use ";
	public static final String MESSAGE_INEXISTENT_SUBMUSCLE_GROUP = "INEXISTENT_MUSCLE_SUBGROUP- This muscle subgroup not exist";

	/** * TRAINING  */
	public static final String MESSAGE_INEXISTENT_TRAINING = "INEXISTENT_TRAINING- This training not exist";

	/** * EXERCISE  */
	public static final String MESSAGE_INEXISTENT_EXERCISE = "INEXISTENT_EXERCISE- This exercise not exist";

}
