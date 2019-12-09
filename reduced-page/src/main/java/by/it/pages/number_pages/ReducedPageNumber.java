package by.it.pages.number_pages;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ReducedPageNumber {

	public static String reducedPageNumbers(String str) throws NumberFormatException {
		boolean isSequence = true;
		Set<Integer> set = new TreeSet<Integer>();
		StringBuilder sb = new StringBuilder();
		try {
			String[] arr = str.replaceAll(" ", "").split(",");
			for (String el : arr) {
				Integer key = Integer.parseInt(el);
				if (key <= 0) {
					throw new NumberFormatException();
				}
				set.add(key);
			}
		} catch (NumberFormatException e) {
			throw new NumberFormatException("incorrect format");
		}
		Iterator<Integer> iterator = set.iterator();
		Integer first = iterator.next();
		while (iterator.hasNext()) {
			Integer last = iterator.next();
			if (last - first == 1 && isSequence) {
				sb.append(first.toString());
				sb.append("-");
				isSequence = false;
			} else if (!isSequence) {
				if ((last - first) != 1) {
					isSequence = true;
					sb.append(first.toString());
					sb.append(",");
				}
			} else {
				sb.append(first.toString());
				sb.append(",");
			}
			first = last;
		}
		sb.append(first.toString());
		String res = sb.toString();
		return res;
	}
}
