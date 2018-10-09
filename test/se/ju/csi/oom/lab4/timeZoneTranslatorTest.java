package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class timeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		DateTime test = new DateTime(2016,01,01,06,00);
		test = TimeZoneTranslator.shiftTimeZone(test, 1, -8);
		System.out.println(test.toString());   
		assertEquals("2015-12-31 21:00", test.toString());
	
				
	}

	@Test
	public void testShiftEventTimeZone() {
		DateTime start = new DateTime(2018,10,3,11,00);
		DateTime end = new DateTime(2018,10,3,12,00);
		DateTime birth = new DateTime(1996,12,06, 00,00);
		Person Alex = new Person("Alex",birth);
		Place j = new Place("j", 1.0, 1.0 ,1.0);
					
		Event event = new Event("test",
				start,
				end,
				new HashSet<>(Arrays.asList(Alex)),
				j);
		
		assertEquals(new String("2018-10-03 11:00"), event.getStartDate().toString());
		assertEquals(new String("2018-10-03 12:00"), event.getEndDate().toString());
		
	}

}
