package farmer;

import java.util.ArrayList;
import java.util.List;


import aima.core.agent.Action;
import aima.core.search.framework.problem.GeneralProblem;
import aima.core.search.framework.problem.Problem;


public class FarmerFunction {
	
	public static Problem<FarmerState, Action> createProblem() {
        return new GeneralProblem<>(new FarmerState(), FarmerFunction::getActions, FarmerFunction::getResult, FarmerFunction::testGoal);
    }
	
	public static List<Action> getActions(FarmerState state) {
		List<Action> actions = new ArrayList<>();
		
		if(state.canFamerMoveAlone()) actions.add(FarmerState.FARMER_MOVE_ALONE);
		if(state.canFamerMoveWithTiger()) actions.add(FarmerState.FARMER_MOVE_TIGER);
		if(state.canFamerMoveWithBuffalo()) actions.add(FarmerState.FARMER_MOVE_BUFFALO);
		if(state.canFamerMoveWithGrass()) actions.add(FarmerState.FARMER_MOVE_GRASS);
		
		return actions;
	}
	
	public static FarmerState getResult(FarmerState state, Action action) {
		FarmerState result = null;
		if (FarmerState.FARMER_MOVE_ALONE.equals(action))
			result = state.moveAlone();
		if (FarmerState.FARMER_MOVE_TIGER.equals(action))
			result = state.moveWithTiger();
		if (FarmerState.FARMER_MOVE_BUFFALO.equals(action))
			result = state.moveWithBuffalo();
		if (FarmerState.FARMER_MOVE_GRASS.equals(action))
			result = state.moveWithGrass();
		return result;
	}
	
	public static boolean testGoal(FarmerState state) {
		int goalState[] = {1, 1, 1, 1};
		boolean flag = true;
		for(int i=0; i< 4; i++){
			if(state.m_state[i] != goalState[i]){
				flag = false;
				break;
			}
		}
		return flag;
    }
}
