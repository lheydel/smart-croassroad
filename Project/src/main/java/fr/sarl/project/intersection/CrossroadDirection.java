package fr.sarl.project.intersection;

import org.eclipse.xtend.lib.annotations.Accessors;

public enum CrossroadDirection {

	NORTH(0) {

		@Override
		public int[] toNorth(int nw, int ne, int se, int sw) {
			int[] path = {nw, ne}; 
			return path;
		}
		
		@Override
		public int[] toSouth(int nw, int ne, int se, int sw) {
			int[] path = {nw, sw}; // I got an error when doing "return {nw, sw}"
			return path;
		}

		@Override
		public int[] toEast(int nw, int ne, int se, int sw) {
			int[] path = {nw, sw, se}; 
			return path;
		}

		@Override
		public int[] toWest(int nw, int ne, int se, int sw) {
			int[] path = {nw};
			return path;
		}
	},
	
	SOUTH(3) {
		
		@Override
		public int[] toNorth(int nw, int ne, int se, int sw) {
			int[] path = {se, ne};
			return path;
		}

		@Override
		public int[] toSouth(int nw, int ne, int se, int sw) {
			int[] path = {se, sw}; 
			return path;
		}
		
		@Override
		public int[] toEast(int nw, int ne, int se, int sw) {
			int[] path = {se};
			return path;
		}

		@Override
		public int[] toWest(int nw, int ne, int se, int sw) {
			int[] path = {se, ne, nw}; 
			return path;
		}
	},
	
	EAST(2) {

		@Override
		public int[] toNorth(int nw, int ne, int se, int sw) {
			int[] path = {ne};
			return path;
		}

		@Override
		public int[] toSouth(int nw, int ne, int se, int sw) {
			int[] path = {ne, nw, sw}; 
			return path;
		}

		@Override
		public int[] toEast(int nw, int ne, int se, int sw) {
			int[] path = {ne, se}; 
			return path;
		}
		
		@Override
		public int[] toWest(int nw, int ne, int se, int sw) {
			int[] path = {ne, nw};
			return path;
		}
	},
	
	WEST(1) {

		@Override
		public int[] toNorth(int nw, int ne, int se, int sw) {
			int[] path = {sw, se, ne}; 
			return path;
		}

		@Override
		public int[] toSouth(int nw, int ne, int se, int sw) {
			int[] path = {sw};
			return path;
		}
		
		@Override
		public int[] toEast(int nw, int ne, int se, int sw) {
			int[] path = {sw, se};
			return path;
		}

		@Override
		public int[] toWest(int nw, int ne, int se, int sw) {
			int[] path = {sw, nw}; 
			return path;
		}
	};
	
	@Accessors
	private int position;

	/**
	 * Find the path needed to go to a given direction in an intersection
	 * We assume that the cars drive on their right of the road
	 * Each param represents an id for a given square that will be returned in the resulting path
	 * @return the path from the first needed square to the last one (so an array of length from 1 to 3)
	 */
	public int[] findPath(CrossroadDirection target, int nw, int ne, int se, int sw) {
		int[] path;
		
		switch (target) {
		case NORTH: 
			path = toNorth(nw, ne, se, sw);
			break;

		case SOUTH: 
			path = toSouth(nw, ne, se, sw);
			break;

		case EAST: 
			path = toEast(nw, ne, se, sw);
			break;

		case WEST: 
			path = toWest(nw, ne, se, sw);
			break;
			
		default:
			path = null;
		}
		
		return path;
	}
	
	/**
	 * Find the path needed to go to the north from a given CrossroadDirection
	 * Each param represents an id for a given square that will be returned in the resulting path
	 * @return the path from the first needed square to the last one
	 */
	public abstract int[] toNorth(int nw, int ne, int se, int sw);
	
	/**
	 * Find the path needed to go to the south from a given CrossroadDirection
	 * Each param represents an id for a given square that will be returned in the resulting path
	 * @return the path from the first needed square to the last one
	 */
	public abstract int[] toSouth(int nw, int ne, int se, int sw);
	
	/**
	 * Find the path needed to go to the east from a given CrossroadDirection
	 * Each param represents an id for a given square that will be returned in the resulting path
	 * @return the path from the first needed square to the last one
	 */
	public abstract int[] toEast(int nw, int ne, int se, int sw);
	
	/**
	 * Find the path needed to go to the west from a given CrossroadDirection
	 * Each param represents an id for a given square that will be returned in the resulting path
	 * @return the path from the first needed square to the last one
	 */
	public abstract int[] toWest(int nw, int ne, int se, int sw);
	
	private CrossroadDirection(int pos) {
		position = pos;
	}
}
