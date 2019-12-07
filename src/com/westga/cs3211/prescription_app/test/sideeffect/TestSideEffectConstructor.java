package com.westga.cs3211.prescription_app.test.sideeffect;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.westga.cs3211.prescription_app.model.SideEffect;

class TestSideEffectConstructor {

	@Test
	void testSuccessfulConstruction() {
		SideEffect sideEffect = new SideEffect("Numb body", LocalDateTime.of(2019, 12, 1, 17, 50));
		
		assertEquals("12/01/2019 05:50 PM", sideEffect.getFormattedDateTime());
		assertEquals("Numb body", sideEffect.getDescription());
		assertEquals("12/01/2019 05:50 PM - Numb body", sideEffect.toString());
	}
	
	@Test
	void testNullTime() {
		
		assertThrows(IllegalArgumentException.class, ()-> new SideEffect("Numb body", null));
	
	}

	@Test
	void testNullDescription() {
		
		assertThrows(IllegalArgumentException.class, ()-> new SideEffect(null, LocalDateTime.of(2019, 12, 1, 17, 50)));
	
	}
	
	@Test
	void testEmptyDescription() {
		
		assertThrows(IllegalArgumentException.class, ()-> new SideEffect("", LocalDateTime.of(2019, 12, 1, 17, 50)));
	
	}
}
