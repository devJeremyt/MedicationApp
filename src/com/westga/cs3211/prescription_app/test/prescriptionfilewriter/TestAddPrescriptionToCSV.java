//package com.westga.cs3211.prescription_app.test.prescriptionfilewriter;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.io.PrintWriter;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//
//import com.westga.cs3211.prescription_app.datatier.PrescriptionFileReader;
//import com.westga.cs3211.prescription_app.datatier.PrescriptionFileWriter;
//import com.westga.cs3211.prescription_app.model.Prescription;
//
//class TestAddPrescriptionToCSV {
//
//	@Test
//	void testNullPrescription() {
//		assertThrows(IllegalArgumentException.class, ()->{
//			PrescriptionFileWriter.addPrescriptionToCSV(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilewriter\\NotCreated.csv", null);
//		});
//	}
//	
//	@Test
//	void testNullFilePath() {
//		assertThrows(IllegalArgumentException.class, ()->{
//			PrescriptionFileWriter.addPrescriptionToCSV(null, new Prescription("Gatorade", false, false, true, 1, 1, 1,"Take"));
//		});
//	}
//	
//	@Test
//	void testAddingToEmptyFile() {
//		
//		PrescriptionFileWriter.addPrescriptionToCSV(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilewriter\\testInitiallyEmpty.csv", new Prescription("Gatorade", false, false, true, 1, 1, 1, "Take it!"));
//		
//		List<Prescription> prescriptions = PrescriptionFileReader.readPrescriptionCSV(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilewriter\\testInitiallyEmpty.csv");
//		
//		assertEquals("Gatorade", prescriptions.get(0).getName());
//		assertEquals(false, prescriptions.get(0).getAvoidDriving());
//		assertEquals(false, prescriptions.get(0).getWithoutAlcohol());
//		assertEquals(true, prescriptions.get(0).getWithFood());
//		assertEquals(1, prescriptions.get(0).getRenewFrequency());
//		assertEquals(1, prescriptions.get(0).getDosageCount());
//		assertEquals(1, prescriptions.get(0).getRefillDosageCount());
//		assertEquals("Take it!", prescriptions.get(0).getInstructions());
//		
//		// Rewrites the test file to be blank.
//		try {
//			PrintWriter eraser = new PrintWriter(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilewriter\\testInitiallyEmpty.csv");
//			eraser.write("");
//			eraser.close();
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}
//		
//	}
//
//	@Test
//	void testAddingToNonEmptyFile() {
//		
//		PrescriptionFileWriter.addPrescriptionToCSV(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilewriter\\NonEmptyDataSet.csv", new Prescription("Gatorade", false, false, true, 1, 1, 1, "blah"));
//		
//		List<Prescription> prescriptions = PrescriptionFileReader.readPrescriptionCSV(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilewriter\\NonEmptyDataSet.csv");
//		
//		assertEquals("Gatorade", prescriptions.get(prescriptions.size()-1).getName());
//		assertEquals(false, prescriptions.get(prescriptions.size()-1).getAvoidDriving());
//		assertEquals(false, prescriptions.get(prescriptions.size()-1).getWithoutAlcohol());
//		assertEquals(true, prescriptions.get(prescriptions.size()-1).getWithFood());
//		assertEquals(1, prescriptions.get(prescriptions.size()-1).getRenewFrequency());
//		assertEquals(1, prescriptions.get(prescriptions.size()-1).getDosageCount());
//		assertEquals(1, prescriptions.get(prescriptions.size()-1).getRefillDosageCount());
//		assertEquals("blah", prescriptions.get(prescriptions.size()-1).getInstructions());
//		
//	}
//	
//	@Test
//	public void testIOExceptionThrown() {
//		ByteArrayOutputStream errContent = new ByteArrayOutputStream();
//		PrintStream originalOut = System.err;
//		System.setErr(new PrintStream(errContent));
//		
//		PrescriptionFileWriter.addPrescriptionToCSV(".\\src\\com\\westga\\cs3211\\prescription_app\\test\\prescriptionfilewriter\\LockedFile.csv", new Prescription("Gatorade", false, false, true, 1, 1, 1, "Take Meds"));
//
//		assertEquals("asdf", errContent.toString());
//		
//		System.setErr(originalOut);
//	}
//}
