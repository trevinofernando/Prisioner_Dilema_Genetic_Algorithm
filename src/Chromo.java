
/******************************************************************************
*  A Teaching GA					  Developed by Hal Stringer & Annie Wu, UCF
*  Version 2, January 18, 2004
*******************************************************************************/

import java.io.*;
import java.util.*;
import java.text.*;

public class Chromo implements Comparable<Chromo> {
	/*******************************************************************************
	 * INSTANCE VARIABLES *
	 *******************************************************************************/

	public List<Double> chromo;
	public double rawFitness; // evaluated
	public double sclFitness; // scaled
	public double proFitness; // proportionalized

	/*******************************************************************************
	 * INSTANCE VARIABLES *
	 *******************************************************************************/

	private static double randnum;

	/*******************************************************************************
	 * CONSTRUCTORS *
	 *******************************************************************************/

	public Chromo() {

		// Set gene values to a randnum sequence of 1's and 0's
		chromo = new ArrayList<Double>(Parameters.numGenes);
		for (int i = 0; i < Parameters.numGenes; i++) {
			chromo.add(Search.r.nextDouble());
		}

		this.rawFitness = -1; // Fitness not yet evaluated
		this.sclFitness = -1; // Fitness not yet scaled
		this.proFitness = -1; // Fitness not yet proportionalized
	}

	/*******************************************************************************
	 * MEMBER METHODS *
	 *******************************************************************************/

	@Override
	public int compareTo(Chromo other) {
		if (this.proFitness > other.proFitness) {
			return 1;
		} else if (this.proFitness < other.proFitness) {
			return -1;
		}
		return 0;
	}

	// Mutate a Chromosome Based on Mutation Type *****************************

	public void doMutation() {

		switch (Parameters.mutationType) {

			case 1: // add/sub 1% and keep number in range 0-1
				double min = 0.0;
				double max = 1.0;
				for (int i = 0; i < (Parameters.geneSize * Parameters.numGenes); i++) {
					if (Search.r.nextDouble() < Parameters.mutationRate) {
						// 50-50 chance of adding/subtracting 1%
						if (Search.r.nextDouble() < 0.5) {
							chromo.set(i, Math.min(Math.max(chromo.get((i)) + 0.01, min), max));
						} else {
							chromo.set(i, Math.min(Math.max(chromo.get((i)) - 0.01, min), max));
						}
					}
				}
				break;

			default:
				System.out.println("ERROR - No mutation method selected");
		}
	}

	/*******************************************************************************
	 * STATIC METHODS *
	 *******************************************************************************/

	// Select a parent for crossover ******************************************

	public static int selectParent() {

		double rWheel = 0;
		int j = 0;

		switch (Parameters.selectType) {

			case 1: // Proportional Selection
				randnum = Search.r.nextDouble();
				for (j = 0; j < Parameters.popSize; j++) {
					rWheel = rWheel + Search.member[j].proFitness;
					if (randnum < rWheel)
						return (j);
				}
				break;

			case 2: // Tournament Selection
				int temp;
				int tournamentSize = 4;
				int candidate[] = new int[tournamentSize];
				for (int i = 0; i < tournamentSize; ++i)
					candidate[i] = (int) (Search.r.nextDouble() * Parameters.popSize);
				for (int i = tournamentSize - 1; i > 0; i--) {
					for (j = 0; j < i; j++) {
						if (Search.member[candidate[j]].proFitness > Search.member[candidate[j + 1]].proFitness) {
							temp = candidate[j];
							candidate[j] = candidate[j + 1];
							candidate[j + 1] = temp;
						}
					}
				}
				for (int i = tournamentSize - 1; i > 0; i--)
					if (Search.r.nextDouble() < 0.6)
						return candidate[i];
				return candidate[0];

			case 3: // Random Selection
				randnum = Search.r.nextDouble();
				j = (int) (randnum * Parameters.popSize);
				return (j);

			default:
				System.out.println("ERROR - No selection method selected");
		}
		return (-1);
	}

	// Produce a new child from two parents **********************************

	public static void mateParents(int pnum1, int pnum2, Chromo parent1, Chromo parent2, Chromo child1, Chromo child2) {

		int xoverPoint1;
		int xoverPoint2;
		double avg;

		switch (Parameters.xoverType) {

			case 1: // Single Point Crossover

				xoverPoint1 = Search.r.nextInt(Parameters.numGenes - 1);

				for (int i = 0; i < Parameters.numGenes; i++) {
					if (i <= xoverPoint1) {
						child1.chromo.set(i, parent1.chromo.get(i));
						child2.chromo.set(i, parent2.chromo.get(i));
					} else {
						child1.chromo.set(i, parent2.chromo.get(i));
						child2.chromo.set(i, parent1.chromo.get(i));
					}
				}

				break;

			case 2: // Two Point Crossover

				do {
					xoverPoint1 = Search.r.nextInt(Parameters.numGenes - 1);
					xoverPoint2 = Search.r.nextInt(Parameters.numGenes - 1);
				} while (xoverPoint1 == xoverPoint2);

				for (int i = 0; i < Parameters.numGenes; i++) {
					if (i <= xoverPoint1 || i >= xoverPoint2) {
						child1.chromo.set(i, parent1.chromo.get(i));
						child2.chromo.set(i, parent2.chromo.get(i));
					} else {
						child1.chromo.set(i, parent2.chromo.get(i));
						child2.chromo.set(i, parent1.chromo.get(i));
					}
				}
				break;

			case 3: // Uniform Crossover

				for (int i = 0; i < Parameters.numGenes; i++) {
					if (Parameters.xoverRate > Search.r.nextDouble()) {
						child1.chromo.set(i, parent1.chromo.get(i));
						child2.chromo.set(i, parent2.chromo.get(i));
					} else {
						child1.chromo.set(i, parent2.chromo.get(i));
						child2.chromo.set(i, parent1.chromo.get(i));
					}
				}
				break;

			case 4: // Uniform Average Crossover

				for (int i = 0; i < Parameters.numGenes; i++) {
					if (Parameters.xoverRate > Search.r.nextDouble()) {
						child1.chromo.set(i, parent1.chromo.get(i));
						child2.chromo.set(i, parent2.chromo.get(i));
					} else {
						avg = (parent1.chromo.get(i) + parent2.chromo.get(i)) / 2;
						child1.chromo.set(i, avg);
						child2.chromo.set(i, avg);
					}
				}

				break;
			case 5: // Uniform Weighted Average Crossover

				for (int i = 0; i < Parameters.numGenes; i++) {
					if (Parameters.xoverRate > Search.r.nextDouble()) {
						child1.chromo.set(i, parent1.chromo.get(i));
						child2.chromo.set(i, parent2.chromo.get(i));
					} else {
						avg = (parent1.chromo.get(i) * parent1.proFitness + parent2.chromo.get(i) * parent2.proFitness)
								/ (parent1.proFitness + parent2.proFitness);
						child1.chromo.set(i, avg);
						child2.chromo.set(i, avg);
					}
				}

				break;
			default:
				System.out.println("ERROR - Bad crossover method selected");
		}

		// Set fitness values back to zero
		child1.rawFitness = -1; // Fitness not yet evaluated
		child1.sclFitness = -1; // Fitness not yet scaled
		child1.proFitness = -1; // Fitness not yet proportionalized
		child2.rawFitness = -1; // Fitness not yet evaluated
		child2.sclFitness = -1; // Fitness not yet scaled
		child2.proFitness = -1; // Fitness not yet proportionalized
	}

	// Get Alpha Represenation of a Gene **************************************

	public Double getGeneAlpha(int geneID) {
		return this.chromo.get(geneID);
	}

	// Get Integer Value of a Gene (Positive or Negative, 2's Compliment) ****

	// Get Integer Value of a Gene (Positive only) ****************************

	public int getPosIntGeneValue(int geneID) {
		return 0;
	}

	// Produce a new child from a single parent ******************************

	public static void mateParents(int pnum, Chromo parent, Chromo child) {

		// Create child chromosome from parental material
		child.chromo = parent.chromo;

		// Set fitness values back to zero
		child.rawFitness = -1; // Fitness not yet evaluated
		child.sclFitness = -1; // Fitness not yet scaled
		child.proFitness = -1; // Fitness not yet proportionalized
	}

	// Copy one chromosome to another ***************************************

	public static void copyB2A(Chromo targetA, Chromo sourceB) {

		targetA.chromo = sourceB.chromo;

		targetA.rawFitness = sourceB.rawFitness;
		targetA.sclFitness = sourceB.sclFitness;
		targetA.proFitness = sourceB.proFitness;
		return;
	}

} // End of Chromo.java ******************************************************
