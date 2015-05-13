/**
 * <copyright>
 * This file is part of Partes project.
 *
 * This program and the accompanying materials are made available under 
 * the terms of the  GPL license (the "GNU PUBLIC LICENSE") which 
 * accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * </copyright>
 *
 * $Id: PartesTestGenerator.java 21-giu-2012 18.55.05 francesco $
 */
package org.ow2.choreos.partes;

import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.xml.bind.JAXBException;

import partes.exception.BPMNmalformedException;
import partes.exception.TestGenerationException;
import partes.projection.TreeProjection;
import partes.refactorRunner.InteractionTreeBuilder;
import partes.refactorRunner.PartesInfo;
import partes.testbuilder.TestBuilder;

/**
 * The Class PartesTestGenerator.
 */
public abstract class PartesTestGenerator {

	/**
	 * Generate test suite. 
	 * 
	 * @return the HashMap{condition, list o HashMap{PartesInfo, xmlTest}}
	 * @throws BPMNmalformedException 
	 * @throws TestGenerationException 
	 * @throws JAXBException 
	 * @throws FileNotFoundException 
	 */
	public abstract HashMap<String, HashMap<PartesInfo, String>> generateTestSuite() throws BPMNmalformedException, TestGenerationException, FileNotFoundException, JAXBException;

	/** The c tree generator. */
	private ChoreographyInteractionTreeGenerator cTreeGenerator;

	/** The p projection generator. */
	private ParticipantInteractionTreeGenerator pProjectionGenerator;

	/** The p test builder. */
	private ParticipantTestBuilder pTestBuilder;

	/**
	 * Instantiates a new partes test generator.
	 * 
	 * @param cTreeGenerator
	 *            the c tree generator
	 * @param pProjectionGenerator
	 *            the projection generator
	 * @param pTestBuilder
	 *            the test builder
	 */
	public PartesTestGenerator(
			ChoreographyInteractionTreeGenerator cTreeGenerator,
			ParticipantInteractionTreeGenerator pProjectionGenerator,
			ParticipantTestBuilder pTestBuilder) {
		this.cTreeGenerator = cTreeGenerator;
		this.pProjectionGenerator = pProjectionGenerator;
		this.pTestBuilder = pTestBuilder;
	}

	/**
	 * Instantiates a new partes test generator.
	 */
	public PartesTestGenerator() {
		//this.cTreeGenerator = new JPFRunner();
		this.cTreeGenerator = new InteractionTreeBuilder();
		this.pProjectionGenerator = new TreeProjection();
		this.pTestBuilder = new TestBuilder();
	}

	/**
	 * Gets the c tree generator.
	 * 
	 * @return the cTreeGenerator
	 */
	public ChoreographyInteractionTreeGenerator getcTreeGenerator() {
		return cTreeGenerator;
	}

	/**
	 * Sets the c tree generator.
	 * 
	 * @param cTreeGenerator
	 *            the cTreeGenerator to set
	 */
	public void setcTreeGenerator(
			ChoreographyInteractionTreeGenerator cTreeGenerator) {
		this.cTreeGenerator = cTreeGenerator;
	}

	/**
	 * Gets the p projection generator.
	 * 
	 * @return the pProjectionGenerator
	 */
	public ParticipantInteractionTreeGenerator getpProjectionGenerator() {
		return pProjectionGenerator;
	}

	/**
	 * Sets the p projection generator.
	 * 
	 * @param pProjectionGenerator
	 *            the pProjectionGenerator to set
	 */
	public void setpProjectionGenerator(
			ParticipantInteractionTreeGenerator pProjectionGenerator) {
		this.pProjectionGenerator = pProjectionGenerator;
	}

	/**
	 * Gets the p test builder.
	 * 
	 * @return the pTestBuilder
	 */
	public ParticipantTestBuilder getpTestBuilder() {
		return pTestBuilder;
	}

	/**
	 * Sets the p test builder.
	 * 
	 * @param pTestBuilder
	 *            the pTestBuilder to set
	 */
	public void setpTestBuilder(ParticipantTestBuilder pTestBuilder) {
		this.pTestBuilder = pTestBuilder;
	}

}