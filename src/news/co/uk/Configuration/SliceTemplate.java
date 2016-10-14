package news.co.uk.Configuration;

import java.sql.Array;
import java.util.HashMap;

public class SliceTemplate {
	
	public static String getTemplate(news.co.uk.Enum.TemplateSlice name) {
		return getKeyStroke(getTemplatePosition(name));
	}
	
	public static int getTemplatePosition(news.co.uk.Enum.TemplateSlice name) {
		
		int down = 0;
		
		switch(name) {
			case COMMENT_1_AND_CARTOON:
				down = 1;
				break;
			case COMMENT_2_AND_NOTEBOOK:
				down = 2;
				break;
			case COMMENT_LETTERS_THUNDER_AND_1:
				down = 3;
				break;
			case FOCUS:
				down = 4;
				break;
			case GROUPED_PUFF_1_LARGE_4:
				down = 5;
				break;
			case GROUPED_PUFFS_2_LARGE_2_SMALL:
				down = 6;
				break;
			case GROUPED_PUFFS_3_LARGE:
				down = 7;
				break;
			case GROUPED_PUFFS_6_SMALL:
				down = 8;
				break;
			case IN_THE_NEWS:
				down = 9;
				break;
			case LEAD_1_AND_1:
				down = 10;
				break;
			case LEAD_1_FULL_WIDTH_PIC:
				down = 11;
				break;
			case LEAD_2_NO_PIC_AND_1_AND_PORTRAIT:
				down = 12;
				break;
			case LEADERS:
				down = 13;
				break;
			case LIST_2_AND_6_NO_PIC:
				down = 14;
				break;
			case MAGAZINE:
				down = 15;
				break;
			case OBITUARIES_LEAD_AND_2:
				down = 16;
				break;
			case REGISTER_LEAD_4:
				down = 17;
				break;
			case RELATED_LINKS_LEAD_AND_2:
				down = 18;
				break;
			case RELATED_LINKS_OPINION_AND_2:
				down = 19;
				break;
			case RELATED_LINKS:
				down = 20;
				break;
			case SECONDARY_1_AND_COLUMNIST:
				down = 21;
				break;
			case SECONDAY_1_LANDSCAPE:
				down = 22;
				break;
			case SECONDARY_2_AND_2:
				down = 23;
				break;
			case SECONDARY_2_NO_PIC_AND_2:
				down = 24;
				break;
			case SECONDARY_4:
				down = 25;
				break;
			case SINGLE_PUFF:
				down = 26;
				break;
			case SUPPLEMENT_LEAD_AND_4_STACK:
				down = 27;
				break;
			case SUPPLEMENT_SECONDARY_1_AND_4:
				down = 28;
				break;
			default:
				break;
		}
		
		return down;
	}
	
	public static String getKeyStroke(int step) {
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
