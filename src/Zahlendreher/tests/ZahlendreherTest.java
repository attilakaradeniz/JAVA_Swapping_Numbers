package Zahlendreher.tests;

import static org.testng.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import at.technikum_wien.javacourse.util.TestNGSupport;

public class ZahlendreherTest {

	// dynamically read class to test including pckge
	private String className = this.getClass().getPackage().getName() + "."
			+ this.getClass().getPackage().getName().replace(".tests", "") + "Runner";

	// dynamically create file path of test files
	private String dirName = System.getProperty("user.dir");
	private TestNGSupport supporter = new TestNGSupport(className, dirName);

	// create output Stream
	private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	// use supporter class for common methods

	@Test(dataProvider = "inout", description = "tests the output of main against the expected output")
	public void testMain(String input, String expOutput) {
		System.out.println("[" + this.getClass().getSimpleName() + "] dirName = " + dirName);
		System.out.println("[" + this.getClass().getSimpleName() + "] className =  " + className);

		/*
		 * System.out.println("[" + this.getClass().getSimpleName() + "] input =  " +
		 * input); System.out.println("[" + this.getClass().getSimpleName() +
		 * "] expOutput =  " + expOutput);
		 */
		outContent.reset();
		System.setOut(new PrintStream(outContent));

		System.setIn(null);
		System.setIn(new ByteArrayInputStream(input.getBytes()));

		// System.err.println("[" + this.getClass().getSimpleName() + "] System.in = " +
		// System.in);

		try {

			Class<?> cls = Class.forName(className);
			// System.err.println("[" + this.getClass().getSimpleName() + "] cls = " + cls);

			Method meth = cls.getMethod("main", String[].class);
			// System.err.println("[" + this.getClass().getSimpleName() + "] meth = " +
			// meth);
			
			String[] params = null; // init params accordingly
			// System.err.println("[" + this.getClass().getSimpleName() + "] params = " +
			// params);

			meth.invoke(null, (Object) params); // static method doesn't have an instance

		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {

			e.printStackTrace();
		}

		// exact comparison, ignoring \r
		assertEquals(outContent.toString().replace("\r", ""), expOutput.replace("\r", ""));
	}

	@DataProvider
	private Object[][] inout() {
		return supporter.getDataProvider();
	}

}
