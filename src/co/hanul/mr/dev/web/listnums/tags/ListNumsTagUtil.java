package co.hanul.mr.dev.web.listnums.tags;

/**
 * 리스트 넘버 태그 유틸리티
 */
public class ListNumsTagUtil {
	public static String replaceListNumber(String str, int number) {
		StringBuffer sb = new StringBuffer(str);
		String numberStr = Integer.toString(number);
		boolean isEscape = false;
		for (int j = 0; j < sb.length() - 1; j++) {
			switch (sb.charAt(j)) {
			case '\\':
				if (!isEscape) {
					sb.delete(j, j + 1);
					j--;
				}
				isEscape = !isEscape;
				break;
			case '*':
				if (!isEscape) {
					switch (sb.charAt(j + 1)) {
					case 'n':
						sb.replace(j, j + 2, numberStr);
						break;
					}
				}
			default:
				isEscape = false;
			}
		}
		return sb.toString();
	}
}
