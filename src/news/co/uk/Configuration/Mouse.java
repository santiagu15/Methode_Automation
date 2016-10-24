package news.co.uk.Configuration;

public class Mouse {
	public static String RIGHT_CLICK = "right";
	public static String LEFT_CLICK = "left";
	public static int SINGLE_CLICK = 1;
	public static int DOUBLE_CLICK = 2;
	public static String ENTER ="{ENTER}"; 
	public static String UP_DOWN = "{UP}{DOWN}";
	public static String DOWN_ENTER = "{DOWN}{DOWN}{ENTER}";
	
	public static String getDown(int step) {
		StringBuilder name = new StringBuilder();
		int count = 0;
		for(;;) {
			if (count == step) {
				break;
			}
			name.append("{DOWN}");
			count++;
		}
		return name.toString();
	}
	/*public static String DOWN = "{DOWN}";
	public static String DOWN_2X = "{DOWN}{DOWN}";
	public static String DOWN_3X = "{DOWN}{DOWN}{DOWN}";
	public static String DOWN_4X = "{DOWN}{DOWN}{DOWN}{DOWN}";
	public static String DOWN_5X = "{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}";
	public static String DOWN_6X = "{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}";
	public static String ENTER ="{ENTER}"; 
	public static String UP_DOWN = "{UP}{DOWN}";
	public static String DOWN_ENTER = "{DOWN}{DOWN}{ENTER}";
	public static String DOWN_12X = "{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}";
	public static String DOWN_15X = "{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}{DOWN}";*/
	
}
