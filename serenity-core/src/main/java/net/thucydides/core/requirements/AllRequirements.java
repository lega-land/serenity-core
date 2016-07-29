package net.thucydides.core.requirements;

import com.google.common.collect.Lists;
import net.thucydides.core.requirements.model.Requirement;

import java.util.Collection;
import java.util.List;

public class AllRequirements {

    public static List<Requirement> in(List<Requirement> requirements) {
        if (requirements == null) {
            return Lists.newArrayList();
        }

        List<Requirement> allRequirements = Lists.newArrayList();
        for (Requirement requirement : requirements) {
            allRequirements.add(requirement);
            allRequirements.addAll(childRequirementsOf(requirement));
        }
        return allRequirements;
    }

    protected static Collection<Requirement> childRequirementsOf(Requirement requirement) {
        List<Requirement> childRequirements = Lists.newArrayList();
        for (Requirement childRequirement : requirement.getChildren()) {
            childRequirements.add(childRequirement);
            childRequirements.addAll(childRequirementsOf(childRequirement));
        }
        return childRequirements;
    }
}