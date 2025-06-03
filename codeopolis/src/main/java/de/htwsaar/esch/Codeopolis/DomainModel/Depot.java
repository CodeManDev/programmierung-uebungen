package de.htwsaar.esch.Codeopolis.DomainModel;

import de.htwsaar.esch.Codeopolis.DomainModel.Harvest.*;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class Depot {
    private final LinkedList<Silo> silos;

    /**
     * Constructs a Depot object with the specified number of silos and capacity per silo.
     *
     * @param numberOfSilos    The number of silos in the depot.
     * @param capacityPerSilo  The capacity per silo.
     */
    public Depot(int numberOfSilos, int capacityPerSilo) {
        this.silos = new LinkedList<>();
        for (int i = 0; i < numberOfSilos; i++) {
            this.silos.addLast(new Silo(capacityPerSilo));
        }
    }

    /**
     * Constructs a Depot object with the specified array of silos.
     * Each silo in the array is deeply copied to ensure that the Depot has its own separate instances.
     *
     * @param silosArray The array of Silo objects to be copied into the depot.
     */
    public Depot(LinkedList<Silo> fromSilos) {
        this.silos = new LinkedList<>();
        this.silos.addAll(fromSilos);
    }

    /**
     * Retrieves the current fill level of the depot for a specific grain type.
     *
     * @param grainType The grain type for which to retrieve the fill level.
     * @return The total amount of grain stored in the depot for the specified grain type.
     */
    public int getFillLevel(Game.GrainType grainType) {
        int fillLevel = 0;
        Iterator<Silo.Status> iterator = iterator(grainType);

        while (iterator.hasNext()) {
            Silo.Status siloStatus = iterator.next();
            fillLevel += siloStatus.getFillLevel();
        }

        return fillLevel;
    }

    /**
     * Creates and returns a copy of the silos array.
     * This method creates a new array and populates it with copies of the Silo objects,
     * ensuring that modifications to the returned array do not affect the original silos.
     *
     * @return A copy of the silos array.
     */
    public LinkedList<Silo> getSilos() {
        LinkedList<Silo> silosCopy = new LinkedList<>();
        silosCopy.addAll(this.silos);
        return silosCopy;
    }

    /**
     * Gets the total amount of bushels (grain) stored in the depot.
     *
     * @return The total amount of bushels stored in the depot.
     */
    public int getTotalFillLevel() {
        int totalBushels = 0;

        for (Silo silo : this.silos)
            totalBushels += silo.getFillLevel();

        return totalBushels;
    }

    /**
     * Retrieves the capacity of the depot for a specific grain type.
     *
     * @param grainType The grain type for which to retrieve the capacity.
     * @return The total capacity of the depot for the specified grain type.
     */
    public int getCapacity(Game.GrainType grainType) {
        int capacity = 0;
        Iterator<Silo.Status> iterator = iterator(grainType);

        while (iterator.hasNext()) {
            Silo.Status siloStatus = iterator.next();
            capacity += siloStatus.getCapacity();
        }

        return capacity;
    }

    /**
     * Stores a harvest in the depot.
     *
     * @param harvest The harvest to be stored in the depot.
     * @return True if the harvest was successfully stored, false otherwise.
     */
    public boolean store(Harvest harvest) {

        if (this.storeHarvest(harvest))
            return true;

        defragment();

        if (this.storeHarvest(harvest))
            return true;

        return false;
    }

    private boolean storeHarvest(Harvest harvest) {
        Game.GrainType grainType = harvest.getGrainType();

        LinkedList<Silo> filtered = this.silos.filter(silo -> silo.getGrainType() == grainType || silo.getFillLevel() == 0);

        for (Silo silo : filtered) {
            harvest = silo.store(harvest);
            if (harvest == null)
                return true;
        }

        return false;
    }

    /**
     * Takes out a specified amount of grain from the depot for a specific grain type.
     *
     * @param amount    The amount of grain to be taken out.
     * @param grainType The grain type for which to take out the grain.
     * @return The actual amount of grain taken out from the depot.
     */
    public int takeOut(int amount, Game.GrainType grainType) {
        LinkedList<Silo> filteredSilos = this.silos.filter(silo -> silo.getGrainType() == grainType);
        int takenAmount = 0;

        for (Silo silo : filteredSilos) {
            int amountTaken = silo.takeOut(amount);
            amount -= amountTaken;
            takenAmount += amountTaken;
            if (amount <= 0)
                break;
        }

        return takenAmount;
    }

    /**
     * Takes out the specified amount of grain from the silo, distributing it evenly among the stored bushels.
     * If the specified amount exceeds the total amount of grain in the silo, all grain is removed and returned.
     * If the specified amount is less than the total amount of grain, the grain is taken out evenly from each bushel,
     * with any remaining grain distributed among the bushels in a round-robin fashion.
     *
     * @param amount The amount of grain to be taken out from the silo.
     * @return The actual amount of grain taken out from the silo.
     */
    public int takeOut(int amount) {
        if (amount >= this.getTotalFillLevel()) {
            int totalAmountOfBushels = this.getTotalFillLevel();
            for (Silo silo : this.silos)
                silo.emptySilo();

            // mit Methodenreferenz: (Instanzmethode eines beliebigen Silos)
            // this.silos.forEach(Silo::emptySilo);

            return totalAmountOfBushels;
        }
        int partion = amount / this.silos.size();
        int remainder = amount % this.silos.size();

        for (Silo silo : this.silos) {
            if (silo.getFillLevel() < partion) {
                remainder += partion - silo.getFillLevel();
                silo.emptySilo();
            } else {
                silo.takeOut(partion);
            }
        }

        int j = 0;
        while(remainder > 0) {
            Silo silo = this.silos.get(j);
            if(silo.getFillLevel() > 0) {
                silo.takeOut(1);
                remainder--;
            }
            j = (j+1)%Game.GrainType.values().length;
        }
        return amount;
    }

    /**
     * Expands the depot by adding more silos with the specified capacity per silo.
     *
     * @param numberOfSilos    The number of silos to add.
     * @param capacityPerSilo  The capacity per silo.
     */
    public void expand(int numberOfSilos, int capacityPerSilo) {
        for (int i = numberOfSilos; i > 0; i--)
            this.silos.addLast(new Silo(capacityPerSilo));

        this.takeOut((int) (numberOfSilos * GameConfig.DEPOT_EXPANSION_COST)); //#Issue42
    }

    /**
     * Performs defragmentation on the depot to redistribute grain across silos.
     */
    public void defragment() {
        LinkedList<Harvest> allHarvests = new LinkedList<>();

        for (Silo silo : this.silos) {
            LinkedList<Harvest> siloHarvests = silo.emptySilo();
            if (siloHarvests != null)
                allHarvests.addAll(siloHarvests);
        }

        // Add all harvests back. Store method takes care that silos are not fragmented.
        for (Harvest harvest : allHarvests) {
            if (harvest != null)
                store(harvest);
        }
    }

    /**
     * Retrieves the total count of harvests across all silos.
     *
     * @return The total count of harvests stored in all silos combined.
     */
    private int getTotalHarvestCount() {
        int totalCount = 0;
        for (Silo silo : this.silos)
            totalCount += silo.getHarvestCount();

        return totalCount;
    }

    /**
     * Simulates the decay of grain in the depot over time.
     *
     * @return The total amount of grain that decayed in the depot.
     */
    public int decay(int currentYear) {
        int totalDecayedAmount = 0;
        for (Silo silo : this.silos)
            totalDecayedAmount += silo.decay(currentYear);

        return totalDecayedAmount;
    }

    /**
     * Checks if the depot is fully occupied with grain.
     *
     * @return {@code true} if the total fill level of all silos equals or exceeds the total capacity of the storage system, {@code false} otherwise.
     */
    public boolean full() {
        return this.getTotalFillLevel() >= this.totalCapacity();
    }

    /**
     * Calculates the total capacity of the depot by summing the capacities of all silos.
     *
     * @return The total capacity of the storage system.
     */
    public int totalCapacity() {
        int totalCapacity = 0;
        for (Silo silo : this.silos)
            totalCapacity += silo.getCapacity();

        return totalCapacity;
    }

    /**
     * Retrieves the total amount of grain categorized by grain type.
     *
     * @return An array containing the total amount of grain for each grain type, indexed by the grain type constants defined in the {@code GameConfig} class.
     */
    public int[] getBushelsCategorizedByGrainType() {
        int[] result = new int[Game.GrainType.values().length];
        for (Game.GrainType grainType : Game.GrainType.values())
            result[grainType.ordinal()] = getFillLevel(grainType);

        return result;
    }

    /**
     * Returns a string representation of the depot, including information about each silo's grain type, fill level, capacity, and absolute amount of grain.
     *
     * @return A string containing information about the depot, including each silo's grain type, fill level, capacity, and absolute amount of grain.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.00");

        this.silos.sort();

        int index = 0;
        for (Silo silo : this.silos) {
            builder.append("Silo ").append((index++) + 1).append(": ");

            String grainName;

            if (silo.getGrainType() != null)
                grainName = silo.getGrainType().toString();
            else
                grainName = "EMPTY";

            builder.append(grainName).append("\n");

            int fillLevel = silo.getFillLevel();
            int capacity = silo.getCapacity();

            double fillPercentage = (double) fillLevel / capacity * 100;
            double emptyPercentage = 100 - fillPercentage;

            // Absolute amount of grain
            builder.append("Amount of Grain: ").append(fillLevel).append(" units\n");

            // ASCI-ART representation of the fill level
            int fillBarLength = 20;
            int filledBars = (int) (fillPercentage / 100 * fillBarLength);
            int emptyBars = fillBarLength - filledBars;

            builder.append("|");
            builder.append("=".repeat(Math.max(0, filledBars)));
            builder.append("-".repeat(Math.max(0, emptyBars)));
            builder.append("| ").append(df.format(fillPercentage)).append("% filled\n");

            builder.append("Capacity: ").append(capacity).append(" units\n\n");
        }

        return builder.toString();
    }

    public Iterator<Silo.Status> iterator(Game.GrainType grainType) {
        return new DepotIterator(grainType);
    }

    private class DepotIterator implements Iterator<Silo.Status> {

        private final Game.GrainType grainType;
        private int currentIndex;
        private Silo.Status nextStatus;

        public DepotIterator(Game.GrainType grainType) {
            this.grainType = grainType;
            this.currentIndex = 0;
            this.nextStatus = null;
        }

        @Override
        public boolean hasNext() {
            this.nextStatus = null;
            while (this.currentIndex < silos.size()) {
                Silo silo = silos.get(this.currentIndex++);
                if (silo.getGrainType() == this.grainType || silo.getGrainType() == null) {
                    this.nextStatus = silo.getStatus();
                    break;
                }
            }
            return this.nextStatus != null;
        }

        @Override
        public Silo.Status next() {
            return this.nextStatus;
        }
    }

}
