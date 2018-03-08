package farmer;

import aima.core.agent.Action;
import aima.core.agent.impl.DynamicAction;


public class FarmerState {
	public static Action FARMER_MOVE_ALONE = new DynamicAction("FARMER_MOVE_ALONE");
	public static Action FARMER_MOVE_TIGER = new DynamicAction("FARMER_MOVE_TIGER");
	public static Action FARMER_MOVE_BUFFALO = new DynamicAction("FARMER_MOVE_BUFFALO");
	public static Action FARMER_MOVE_GRASS = new DynamicAction("FARMER_MOVE_GRASS");
	
	/*
	 I. value in m_state:
	 	= 0: on the west side of the river
	 	= 1: on the east side of the river
	 II. The order in array:
	 	[Location of Farmer (LoFarmer), LoTiger, LoBuffalo, LoGrass]
	 */
	public static final int WEST = 0;
	public static final int EAST = 1;
	public int m_state[] = {WEST, WEST, WEST, WEST};
	public FarmerState(){

	}
	public FarmerState(int state[]){
		this.m_state = new int[state.length];
		System.arraycopy(state, 0, m_state, 0, state.length);
	}
	public FarmerState(FarmerState copy) {
		this(copy.getState());
	}

	public int[] getState() {
		return m_state;
	}
	boolean isValidState(int[] state){
		boolean case1, case2, case3;
		//1. Farmer, Tiger, Buffalo: on the same side
		case1 = (state[0] == state[1]) && (state[0] == state[2]);
		//2. Farmer, Buffalo, Grass: on the same side
		case2 = (state[0] == state[2]) && (state[0] == state[3]);
		//3. Dont care LoFarmer: LoTiger <> LoBuffalo, and LoBuffalo <> LoGrass
		case3 = (state[1] != state[2]) && (state[2] != state[3]);
		return case1 || case2 || case3;
	}
	int move(int side){
		if (side == WEST) return EAST;
		else return WEST;
	}
	
	public boolean canFamerMoveAlone(){
		int newState[] = {move(m_state[0]), m_state[1], m_state[2], m_state[3]};
		boolean cond1 = isValidState(newState);
		
		if(cond1)return true;
		else return false;
	}
	public boolean canFamerMoveWithTiger(){
		int newState[] = {move(m_state[0]), move(m_state[1]), m_state[2], m_state[3]};
		boolean cond1 = (m_state[0] == m_state[1]);
		boolean cond2 = isValidState(newState);
		
		if(cond1 && cond2)return true;
		else return false;
	}
	public boolean canFamerMoveWithBuffalo(){
		int newState[] = {move(m_state[0]), m_state[1], move(m_state[2]), m_state[3]};
		boolean cond1 = (m_state[0] == m_state[2]);
		boolean cond2 = isValidState(newState);
		
		if(cond1 && cond2)return true;
		else return false;
	}
	public boolean canFamerMoveWithGrass(){
		int newState[] = {move(m_state[0]), m_state[1], m_state[2], move(m_state[3])};
		boolean cond1 = (m_state[0] == m_state[3]);
		boolean cond2 = isValidState(newState);
		
		if(cond1 && cond2)return true;
		else return false;
	}
	FarmerState moveAlone(){
		int newState[] = {move(m_state[0]), m_state[1], m_state[2], m_state[3]};
		return new FarmerState(newState);
	}
	FarmerState moveWithTiger(){
		int newState[] = {move(m_state[0]), move(m_state[1]), m_state[2], m_state[3]};
		return new FarmerState(newState);
	}
	FarmerState moveWithBuffalo(){
		int newState[] = {move(m_state[0]), m_state[1], move(m_state[2]), m_state[3]};
		return new FarmerState(newState);
	}
	FarmerState moveWithGrass(){
		int newState[] = {move(m_state[0]), m_state[1], m_state[2], move(m_state[3])};
		return new FarmerState(newState);
	}
	//---------------------------------
	private String num2String(int side){
		if (side == WEST) return "WEST";
		else return "EAST";
	}
	public String toString(){
		String result = "";
		result = "[ FAMER=" + num2String(m_state[0]) + "," +
					"TIGER=" + num2String(m_state[1]) + "," +
					"BUFFALO=" + num2String(m_state[2]) + "," +
					"GRASS=" + num2String(m_state[3]) + " ]";
		return result;
	}
	@Override 
	public boolean equals(Object o) 
	{
	    if (o instanceof FarmerState) 
	    {
	      FarmerState c = (FarmerState) o;
	      if ( c.m_state[0] == this.m_state[0] && c.m_state[1] == this.m_state[1] && c.m_state[2] == this.m_state[2] && c.m_state[3] == this.m_state[3]) //whatever here
	         return true;
	    }
	    return false;
	}
}
