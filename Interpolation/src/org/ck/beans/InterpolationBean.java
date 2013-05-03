package org.ck.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This bean stores information about requested values and results of calculations 
 * @author samiriff
 *
 */
public class InterpolationBean implements Serializable
{	
	private static final long serialVersionUID = -8676918565788849188L;	
	
	
	private String algorithmType = "";
	private String taskType = "";
	private List<String> pointsData = new ArrayList<String>();
	private String params = "";		//Required for processing user-defined queries
	private String mapData = "";
	private String result = "TBD";
	
	//This List of objects can be used to store and send custom data structures of any type to JSP Pages 
	// IMPORTANT - REMEMBER TO ALWAYS TYPECAST THIS OBJECT PROPERLY IN THE RESPECTIVE JSP PAGE
	private List<Object> resultObjects = new ArrayList<Object>();		
	
	private double pred = 0;
	
	public void addPoint(String point_data)
	{
		this.pointsData.add(point_data);
	}
	public void convertPointDataToMapData()
	{
		this.mapData = "[";
		for(int i=0;i<this.pointsData.size();++i)
			this.mapData += "["+this.pointsData.get(i)+"],";
		this.mapData = this.mapData.substring(0, mapData.length()-1);
	}
	public void setPredictedValue(double pred)
	{
		this.pred= pred; 
	}
	public double getPredictedValue()
	{
		return pred;
	}
	
	public void setTaskType(String task)
	{
		this.taskType = task;
	}
	public String getTaskType()
	{
		return this.taskType;
	}
	public void setAlgorithmType(String algo)
	{
		this.algorithmType = algo;
	}
	public String getAlgorithmType()
	{
		return this.algorithmType;
	}
	
	
	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}	
	
	public String getParams()
	{
		return params;
	}

	public void setParams(String params)
	{
		this.params = params;
	}
	
		/**
	 * @return List of Objects
	 */
	public Object getResultObjects()
	{
		return resultObjects;
	}
	
	/**
	 * Sets the list of result objects
	 * @param resultObjects
	 */
	public void setResultObjects(List<Object> resultObjects)
	{
		this.resultObjects.clear();
		this.resultObjects = resultObjects;
	}
	
	/**
	 * Clears the current list of result objects and adds resultObject to the cleared list
	 * @param resultObject
	 */
	public void setResultObject(Object resultObject)
	{
		this.resultObjects.clear();
		addResultObject(resultObject);
	}
	
	/**
	 * Appends resultObject to the current list of result objects
	 * @param resultObject
	 */
	public void addResultObject(Object resultObject)
	{
		this.resultObjects.add(resultObject);
	}
	
	
	public void setMapData(String mapData) {
		this.mapData = mapData;
		
	}
	public String getMapData()
	{
		return this.mapData;
	}
	public void clearPointData() {
		this.pointsData.clear();
		
	}
}
