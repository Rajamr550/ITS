package com.zensar.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class InterviewEntityTest {

	@Test
	public void testConstructor() {
		
		InterviewEntity test=new InterviewEntity();
		LocalDate date=LocalDate.now();
		test.setCandidateId(123);
		test.setFinalStatus("done");
		test.setHrRating(3);
		test.setInterviewDate(date);
		test.setInterviewId(7788);
		test.setTechRating(4);
		assertEquals(123, test.getCandidateId());
		assertEquals("done", test.getFinalStatus());
		assertEquals(3 ,test.getHrRating());
		assertEquals(date, test.getInterviewDate());
		assertEquals(7788, test.getInterviewId());
		assertEquals(4, test.getTechRating());
		test.toString();
	}
	
	@Test
	public void testConstructor2() {
		InterviewEntity test1=new InterviewEntity(123, 23, 6, 89, "Rejected",
				LocalDate.now());
		
		test1.setCandidateId(12344);
	}


}
