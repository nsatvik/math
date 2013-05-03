package org.ck.servlets;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ck.beans.InterpolationBean;

/**
 * Servlet implementation class MainController
 * This is the main controller that gets requests from JSP pages, generates results through beans 
 * 		and forwards them to other jsp pages
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{				
		InterpolationBean tsBean = initTimesSeriesBean(request);
		//GraphBean graphBean = initGraphBean(request, tsBean);
		
		doTask(tsBean, request, response);	
		
		//If control comes here, that means no forwarding took place
		response.getWriter().println("NOT FORWARDED");
	}

	/**
	 * Categorizes tsBean based on Task
	 * @param tsBean
	 * @param response 
	 * @param request 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void doTask(InterpolationBean tsBean, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String address = "";
		
		switch(tsBean.getTaskType())
		{
		case "ADD_POINT":
			tsBean.addPoint(request.getParameter("point_data"));
			address = "";			
			break;
		case "CLEAR_POINT":
			tsBean.convertPointDataToMapData();
			tsBean.clearPointData();
			address = "";
			
			break;
		case "DRAW_GRAPH":
			tsBean.convertPointDataToMapData();
			address = "./jsp/error_page.jsp";
			break;
	/*	case ANOMALY_DETECTIVE:			
			address = runAnomalyDetectorAlgorithm(tsBean,Double.parseDouble(request.getParameter("anomalyThreshold")));
			break;
		case TEMPORAL_PATTERN_MINER:
			address = runTemporalMinerAlgorithm(tsBean);
			break;
		default:
			//Forward to errorPage.jsp ---- to be created
			address = PATH_PREFIX + "../error_page.jsp";*/
		}
		
		request.getSession().setAttribute("tsBean", tsBean);
		
		if(!address.isEmpty())
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * Runs a Fortune Telling algorithm, to predict your future and help YOU decide
	 * 		how to go about your life. Pay me Rs. 100
	 * @param tsBean
	 */
	private String runFortuneTellingAlgorithm(InterpolationBean tsBean) 
	{
		return "";
	}


	/**
	 * Runs a similarity algorithm 
	 * @param tsBean
	 */
	private String runSimilarityAlgorithm(InterpolationBean tsBean)
	{
		return "";
	}
	
	/**
	 * Runs the TSDM Framework algorithm for temporal pattern detection
	 * @param tsBean
	 * @return
	 */
	private String runTemporalMinerAlgorithm(InterpolationBean tsBean)
	{
		return "";
	}
	
	
	/**
	 * This method initializes a time series bean from request parameters.
	 * The bean has scope = session
	 * @param request
	 * @return
	 */
	private InterpolationBean initTimesSeriesBean(HttpServletRequest request)
	{
		InterpolationBean tsBean = (InterpolationBean) request.getSession().getAttribute("tsBean");
		
		if(tsBean == null)
			tsBean = new InterpolationBean();
		
		
		tsBean.setParams(request.getParameter("params"));
		tsBean.setAlgorithmType(request.getParameter("algorithmType"));
		tsBean.setTaskType(request.getParameter("taskType"));
		
		
		return tsBean;
	}
	/**
	 * Run the Anomaly Detection algorithm and return the address of the page!
	 * @param tsBean
	 * @param threshold 
	 * @return
	 */
	private String runAnomalyDetectorAlgorithm(InterpolationBean tsBean, double threshold) {
//		switch(tsBean.getAlgorithmType())
//		{
//		case CUSUM:
//			return AlgorithmUtils.runCusumAnomalyDetAlgo(tsBean,threshold);
//			
//		case MARKOV_MODEL_TECHNIQUE: return PATH_PREFIX+"error_page.jsp";
//		case STATISTICAL_APPROACH: return AlgorithmUtils.runStatisticalAnomalyDetetorAlgo(tsBean,threshold);
//			
//		default:
//			return PATH_PREFIX+"error_page.jsp";
//		}
		return "";
		
	}
}
