package org.iit.sp.msb.utility;

import java.util.Random;

public class utility {
	
	static Random rand;
	
	/**
	 * This will choose a random state
	 * @return - state 
	 */

	public static String getRandomState(){

		String state = "";

		String[] sArray = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
				"Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine","Maryland", "Massachusetts", "Michigan",
				"Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
				"North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
				"Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" };

		int num = rand.nextInt(49);
		state = sArray[num];
		System.out.println(state);		
		return state;
	}

}
