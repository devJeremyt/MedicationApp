package com.westga.cs3211.prescription_app.test.sideeffect;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.SideEffect;


class GettersandSetters {

	@Test
	void testSetDescriptionNull() {
		LocalDateTime time = LocalDateTime.of(2019, 12, 5, 2, 50);
		assertThrows(IllegalArgumentException.class, ()-> new SideEffect(null, time));	
	}
	
	@Test
	void testSetDescriptionEmpty() {
		LocalDateTime time = LocalDateTime.of(2019, 12, 5, 2, 50);
		assertThrows(IllegalArgumentException.class, ()-> new SideEffect("", time));	
	}
	
	@Test
	void testSetDescriptionSuccessfully() {
		LocalDateTime time = LocalDateTime.of(2019, 12, 5, 2, 50);
		SideEffect effect = new SideEffect("Mad", time);
		
		assertEquals("Mad", effect.getDescription());
	}
	
	@Test
	void testSetTimeNull() {
		assertThrows(IllegalArgumentException.class, ()-> new SideEffect("Mad", null));	
	}
	
	@Test
	void testSetTimeSuccessfully() {
		LocalDateTime time = LocalDateTime.of(2019, 12, 5, 2, 50);
		SideEffect effect = new SideEffect("Mad", time);
		
		assertEquals(time.getMonth(), effect.getDate().getMonth());
		assertEquals(time.getDayOfMonth(), effect.getDate().getDayOfMonth());
		assertEquals(time.getYear(), effect.getDate().getYear());
		assertEquals(time.getHour(), effect.getTime().getHour());
		assertEquals(time.getMinute(), effect.getTime().getMinute());
	}



}
