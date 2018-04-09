package recurringTask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.print.attribute.standard.RequestingUserName;

public class RecurringTask {
	public static void main(String[] args) {
		RecurringTask recurrTask = new RecurringTask();
		Calendar cal1 = recurrTask.getCalendar("01/01/2015");
		Calendar cal2 = recurrTask.getCalendar("05/01/2015");
		
		System.out.println(cal2.getTime().compareTo(cal2.getTime()));
	}
	
	public String[] recurringTask(String firstDate, int k, String[] daysOfTheWeek, int n) {
		String[] resultDates = new String[n];
		
		Calendar[] everyRequiredDay = initializeCalendars(daysOfTheWeek, firstDate);
		final int DAYS_TO_SKIP = k * 7; //Every k-th week multiplied by days in week
		
		Iterator<Calendar> infIter = new InfiniteIterator<>(everyRequiredDay);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		for(int i=0; i<resultDates.length; i++) {
			Calendar current = infIter.next();
			resultDates[i] = sdf.format(current.getTime());
			current.add(Calendar.DAY_OF_YEAR, DAYS_TO_SKIP);
		}
		
		return resultDates;
	}
	
	Calendar[] initializeCalendars(String[] daysOfTheWeek, String firstDate) {
		Map<String, Integer> daysOfTheWeekMapping = getWeekMapping();
		
		Calendar[] everyRequiredDay = new Calendar[daysOfTheWeek.length];
		for(int i=0; i<everyRequiredDay.length; i++) {
			everyRequiredDay[i] = getCalendar(firstDate);
			while(everyRequiredDay[i].get(Calendar.DAY_OF_WEEK) != daysOfTheWeekMapping.get(daysOfTheWeek[i])) {
				everyRequiredDay[i].add(Calendar.DAY_OF_YEAR, 1);
			}
		}
		
		
		return everyRequiredDay;
	}
	
	Calendar getCalendar(String dateString) {
		Calendar result = Calendar.getInstance();
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date.parse(dateString);
			result = date.getCalendar();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	Map<String, Integer> getWeekMapping() {
		Map<String, Integer> daysOfTheWeekMapping = new HashMap<>();
		daysOfTheWeekMapping.put("Sunday", 1);
		daysOfTheWeekMapping.put("Monday", 2);
		daysOfTheWeekMapping.put("Tuesday", 3);
		daysOfTheWeekMapping.put("Wednesday", 4);
		daysOfTheWeekMapping.put("Thursday", 5);
		daysOfTheWeekMapping.put("Friday", 6);
		daysOfTheWeekMapping.put("Saturday", 7);
		
		return daysOfTheWeekMapping;
	}
	
	private class InfiniteIterator<T extends Calendar> implements Iterator<T> {
		T[] elements;
		int cursor;
		public InfiniteIterator(T[] elements) {
			this.elements = elements;
			cursor = determineEatliest();
		}
		
		public boolean hasNext() {
			return true;
		}
		
		public T next() {
			if(cursor == elements.length) cursor=0;
			
			return elements[cursor++];
		}
		
		private int determineEatliest() {
			int indexOfEarliest = 0;
			Calendar earliest = elements[0];
			
			for(int i=0; i<elements.length; i++) {
				Date earlD = earliest.getTime();
				Date currentD = elements[i].getTime();
				
				if(earlD.compareTo(currentD) > 0) {
					indexOfEarliest = i;
					earliest = elements[i];
				}
			}
			
			return indexOfEarliest;
		}
	}
}
