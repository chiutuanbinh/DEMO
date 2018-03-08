package farmer;

import java.util.List;
import java.util.Properties;

import aima.core.agent.Action;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.SearchForActions;
import aima.core.search.agent.SearchAgent;

import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.framework.qsearch.TreeSearch;
import aima.core.search.framework.qsearch.BidirectionalSearch;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;
import aima.core.search.uninformed.IterativeDeepeningSearch;
import aima.core.search.uninformed.UniformCostSearch;
import sun.java2d.pipe.AATileGenerator;


public class FarmerApp {
	public static void main(String args[]) {
			FarmerWithBreadthFirstSearch();
			FarmerWithUniformCostSearch();
			FarmerWithDepthLimitedSearch(8);
			FarmerWithIterativeDeepeningSearch();
			FarmerWithDepthFirstSearch();
			///dd
	}
	private static void FarmerWithBreadthFirstSearch() {
		try {
			System.out.println("\nFarmerAppDemo BFS -->");
			Problem<FarmerState, Action> problem = FarmerFunction.createProblem();
			SearchForActions<FarmerState, Action> search = new BreadthFirstSearch<>(new TreeSearch<>());
			SearchAgent<FarmerState, Action> agent = new SearchAgent<>(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void FarmerWithDepthFirstSearch() {
		try {
			System.out.println("\nFarmerAppDemo DFS -->");
			Problem<FarmerState, Action> problem = FarmerFunction.createProblem();
			SearchForActions<FarmerState, Action> search = new DepthFirstSearch<>(new GraphSearch<>());
			SearchAgent<FarmerState, Action> agent = new SearchAgent<>(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void FarmerWithUniformCostSearch() {
		try {
			System.out.println("\nFarmerAppDemo UniformCostSearch -->");
			Problem<FarmerState, Action> problem = FarmerFunction.createProblem();
			SearchForActions<FarmerState, Action> search = new UniformCostSearch<>(new TreeSearch<>());
			SearchAgent<FarmerState, Action> agent = new SearchAgent<>(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void FarmerWithDepthLimitedSearch(int depth) {
		try {
			System.out.println("\nFarmerAppDemo DepthLimitedSearch -->");
			Problem<FarmerState, Action> problem = FarmerFunction.createProblem();
			SearchForActions<FarmerState, Action> search = new DepthLimitedSearch<>(depth);
			SearchAgent<FarmerState, Action> agent = new SearchAgent<>(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void FarmerWithIterativeDeepeningSearch() {
		try {
			System.out.println("\nFarmerAppDemo IterativeDeepeningSearch -->");
			Problem<FarmerState, Action> problem = FarmerFunction.createProblem();
			SearchForActions<FarmerState, Action> search = new IterativeDeepeningSearch<>();
			SearchAgent<FarmerState, Action> agent = new SearchAgent<>(problem, search);
			printActions(agent.getActions());
			printInstrumentation(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void printInstrumentation(Properties properties) {
		for (Object o : properties.keySet()) {
			String key = (String) o;
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}

	}

	private static void printActions(List<Action> actions) {
		actions.forEach(System.out::println);
	}
}
