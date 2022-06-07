package Drivers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import org.testng.IReporter;
import org.testng.annotations.Test;

public class CustomTestNGReport implements IReporter {
	
	private PrintWriter writer;
	private int m_row;
	private Integer m_testIndex;
	private int m_methodIndex;
	private String reportTitle= "TestNG Customized Report";
	private String reportFileName = "custom-report.html";
	
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outdir) {
		try {
			writer = createWriter(outdir);
		} catch (IOException e) {
			System.err.println("Unable to create output file");
			e.printStackTrace();
			return;
		}

		startHtml(writer);
		writeReportTitle(reportTitle);
		generateSuiteSummaryReport(suites);
		//generateMethodSummaryReport(suites);
		//generateMethodDetailReport(suites);
		endHtml(writer);
		writer.flush();
		writer.close();
	}
	
	protected PrintWriter createWriter(String outdir) throws IOException {
		new File(outdir).mkdirs();
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(outdir, reportFileName))));
	}
	
	/** Starts HTML stream */
	protected void startHtml(PrintWriter out) {
		//out.println("<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">");
		//out.println("<html xmlns="http://www.w3.org/1999/xhtml">");
		out.println("<head>");
		out.println("<title>TestNG Report</title>");
		out.println("<style type='text/css'>");
		out.println("table {margin-bottom:10px;border-collapse:collapse;empty-cells:show}");
		out.println("td,th {border:1px solid #009;padding:.25em .5em}");
		out.println(".result th {vertical-align:bottom}");
		out.println(".param th {padding-left:1em;padding-right:1em}");
		out.println(".param td {padding-left:.5em;padding-right:2em}");
		out.println(".stripe td,.stripe th {background-color: #E6EBF9}");
		out.println(".numi,.numi_attn {text-align:right}");
		out.println(".total td {font-weight:bold}");
		out.println(".passedodd td {background-color: #0A0}");
		out.println(".passedeven td {background-color: #3F3}");
		out.println(".skippedodd td {background-color: #CCC}");
		out.println(".skippedodd td {background-color: #DDD}");
		out.println(".failedodd td,.numi_attn {background-color: #F33}");
		out.println(".failedeven td,.stripe .numi_attn {background-color: #D00}");
		out.println(".stacktrace {white-space:pre;font-family:monospace}");
		out.println(".totop {font-size:85%;text-align:center;border-bottom:2px solid #000}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		
	}
	
	public void generateSuiteSummaryReport(List<ISuite> suites) {
		tableStart("testOverview", null);
		writer.print("<tr>");
		tableColumnStart("Test");
		tableColumnStart("# Passed");
		//tableColumnStart("# Skipped");
		tableColumnStart("# Failed");
		tableColumnStart("Browser");
		tableColumnStart("Start<br/>Time");
		tableColumnStart("End<br/>Time");
		tableColumnStart("Total<br/>Time(hh:mm:ss)");
	}
    	
	private void tableStart(String cssclass, String id) {
		writer.println("<table>");
		m_row = 0;
	}

	private void tableColumnStart(String label) {
		writer.print("<th>" + label + "</th>");
	}
	
	
	/** Finishes HTML stream */
	protected void endHtml(PrintWriter out) {
		out.println("<center> TestNG Report </center>");
		out.println("</body></html>");
	}
	
	protected void writeReportTitle(String title) {
		writer.print("<center><h1>" + title + " - " + getDateAsString() + "</h1></center>");
	}
	
	
	// Method to get Date as String
	 
	private String getDateAsString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
