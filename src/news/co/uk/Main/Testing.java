package news.co.uk.Main;

import news.co.uk.Enum.TemplateSlice;

public class Testing {

	public static void main(String[] args) {
		System.out.println(TemplateSlice.COMMENT_1_AND_CARTOON);
		String te = test(TemplateSlice.COMMENT_2_AND_NOTEBOOK);
		System.out.println(te);
		
	}
	
	public static String test(TemplateSlice name) {
		int col = 0;
		switch(name) {
		
		case COMMENT_1_AND_CARTOON:
			col = 1;
			break;
		case COMMENT_2_AND_NOTEBOOK:
			col =5;
			break;
		}
		
		return getStep(col);
	}
	
	public static String getStep(int step) {
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

}
