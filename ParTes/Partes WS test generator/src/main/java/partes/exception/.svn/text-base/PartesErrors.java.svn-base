package partes.exception;

public class PartesErrors {

	// the choreography starts with an element that is not a start event (green round)
	public static final String WRONG_STARTING_NODE = "ERROR start element is not a FlowNode";
	
	// the choreography uses an element not covered by Partes
	public static final String BPMN_ELEMENT_NOT_MATCHED = "ERROR matching not found in the Workflow Graph for ";
	
	// a sub choreography has not a start event (green round)
	public static final String SUB_CHOREOGRAPHY_WITHOUT_START =  "ERROR subChoreography has not a StartEvent";
	
	// starting gateways should be named "start_gatewayName" and ending "end_gatewayName". Each start must have an end with the same gatewayName
	public static final String WRONG_SESE ="ERROR SESE fragment should be in the form   <start_gatewayName> --> <end_gatewayName>\n The following gateway doesn't have the closing gateway. Check that it has the right name: \n";
	
	
	// the repeat-until construct must have a start with 1 outcome and 2 incomes, while the end has 1 income and 2 outcomes
	/*                           
	 *            /  \         /  \
	 *      --->  \  /-------> \  /------>
	 *              ^           |
	 *              |-----------|
	 */
	public static final String WRONG_REPEAT_UNTIL = "ERROR  found wired ending gateway repeat_until. It should have just 1 repeated flow !!";

	
	//
	
}
