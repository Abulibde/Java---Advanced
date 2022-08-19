package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;

public class ControllerImpl implements Controller {

    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;
    private int exploreStateCount;

    public ControllerImpl() {
        explorerRepository = new ExplorerRepository();
        stateRepository = new StateRepository();
        exploreStateCount = 0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {

        Explorer explorer;

        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException("Explorer type doesn't exists.");
        }

        explorerRepository.add(explorer);

        return "Added " + type + ": " + explorerName + ".";
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State entity = new StateImpl(stateName);
        for (String exhibit : exhibits) {
            entity.getExhibits().add(exhibit);
        }

        stateRepository.add(entity);
        return "Added state: " + stateName + ".";
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.byName(explorerName);

        if (null == explorer) {
            throw new IllegalArgumentException("Explorer " + explorerName + " doesn't exists.");
        }

        explorerRepository.remove(explorer);

        return "Explorer " + explorerName + " has retired!";
    }

    @Override
    public String exploreState(String stateName) {
        //•	You call each of the explorers and pick only the ones that have energy above 50 units.

        //•	If you don't have any suitable explorers,
        // throw an IllegalArgumentException with the following message:
        // "You must have at least one explorer to explore the state."

        //•	After a mission, you must return the following message with
        // the name of the explored state and the count of the explorers that had retired on the mission:
        //"The state {stateName} was explored. {retiredExplorers} researchers have retired on this mission."

        List<Explorer> explorers = explorerRepository.getCollection().stream().filter(s -> s.getEnergy() > 50).collect(Collectors.toList());

        if (explorers.isEmpty()) {
            throw new IllegalArgumentException("You must have at least one explorer to explore the state.");
        }

        State state = stateRepository.byName(stateName);
        Mission mission = new MissionImpl();
        mission.explore(state, explorers);

        long retiredExplorers = explorers.stream().filter(e -> !e.canSearch()).count();

        exploreStateCount++;

        return "The state " + stateName + " was explored. " + retiredExplorers + " researchers have retired on this mission.";
    }

    @Override
    public String finalResult() {
      /*  // String  = String.format("Name: %s",)

        String finalResult = String.format("%d states were explored.\n" +
                "Information for the explorers:\n" +
                "%s", exploreStateCount, explorerRepository.getInfo());
        //"{exploredStatesCount} states were explored.
        //Information for the explorers:
        //Name: {explorerName}
        //Energy: {explorerName}
        //Suitcase exhibits: {suitcaseExhibits1, suitcaseExhibits2, suitcaseExhibits3, …, suitcaseExhibits n}"
        return finalResult;
    }*/


        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%d states were explored.\n", exploreStateCount));
        sb.append("Information for the explorers:\n");

        for (Explorer explorer : this.explorerRepository.getCollection()) {
            sb.append(String.format("Name: %s\n", explorer.getName()));
            sb.append(String.format("Energy: %.0f\n", explorer.getEnergy()));

            String suitable = explorer.getSuitcase().getExhibits().size() == 0
                    ? "None"
                    : String.join(", ", explorer.getSuitcase().getExhibits());

             sb.append(String.format("Suitcase exhibits: %s\n", suitable));
        }

        return sb.toString().trim();
    }
}
