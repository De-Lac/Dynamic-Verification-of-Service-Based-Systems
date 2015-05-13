package unicam.refactorWorkflowgraph;

import java.util.ArrayList;

import org.jbpt.pm.FlowNode;

import unicam.utils.ExtendedActivity;



/**
 * It's an ArrayList of ChoreographyTask (see {@link unicam.utils.ExtendedActivity ExtendedActivity}).
 * It is a branch of the XOR gateway after the refactoring of a Workflow Graph. It's usually associated
 * to a condition.
 * @author DeLac
 *
 */
public class PartesTrace extends ArrayList<ExtendedActivity> 
{
 
	/**
	 * it accepts an array of {@link org.jbpt.pm.FlowNode FlowNode}, that will be casted to {@link unicam.utils.ExtendedActivity ExtendedActivity}
	 * @param nodes
	 */
	public PartesTrace(ArrayList<FlowNode> nodes)
		{
		 super();
		 for (int i=0; i<nodes.size(); i++)
		 	{
			 FlowNode ct = nodes.get(i);
			 add((ExtendedActivity)ct);
		 	}
		}
	
	
	
	
}
