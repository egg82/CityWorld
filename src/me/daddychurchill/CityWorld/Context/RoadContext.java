package me.daddychurchill.CityWorld.Context;

import me.daddychurchill.CityWorld.WorldGenerator;
import me.daddychurchill.CityWorld.Clipboard.Clipboard;
import me.daddychurchill.CityWorld.Clipboard.ClipboardRoundaboutLot;
import me.daddychurchill.CityWorld.Clipboard.PasteProvider.SchematicFamily;
import me.daddychurchill.CityWorld.Maps.PlatMap;
import me.daddychurchill.CityWorld.Plats.PlatLot;
import me.daddychurchill.CityWorld.Plats.RoadLot;
import me.daddychurchill.CityWorld.Plats.RoundaboutStatueLot;
import me.daddychurchill.CityWorld.Support.Direction;
import me.daddychurchill.CityWorld.Support.Odds;

public class RoadContext extends DataContext {

	public RoadContext(WorldGenerator generator) {
		super(generator);
		
		//TODO do I need to do anything here?
	}

	@Override
	protected void initialize() {
		schematicFamily = SchematicFamily.ROUNDABOUT;
		schematicMaxX = 1;
		schematicMaxZ = 1;
	}

	@Override
	public void populateMap(WorldGenerator generator, PlatMap platmap) {
		// TODO Auto-generated method stub

	}

	public PlatLot createRoadLot(WorldGenerator generator, PlatMap platmap, int x, int z, boolean roundaboutPart) {
		return new RoadLot(platmap, platmap.originX + x, platmap.originZ + z, generator.connectedKeyForPavedRoads, roundaboutPart);
	}

	public PlatLot createRoundaboutStatueLot(WorldGenerator generator, PlatMap platmap, int x, int z) {

		// grab potential platlot's random
		Odds odds = platmap.getChunkOddsGenerator(platmap.originX + x, platmap.originZ + z);
		
		// what way are we facing?
		Direction.Facing facing = odds.getFacing();
		
		// see if there is a schematic out there that fits
		Clipboard clip = getSingleSchematicLot(generator, platmap, odds, x, z);
		if (clip != null) {
			
			// create it then
			return new ClipboardRoundaboutLot(platmap, platmap.originX + x, platmap.originZ + z, clip, facing, 0, 0);
			
		} else
			return new RoundaboutStatueLot(platmap, platmap.originX + x, platmap.originZ + z);
	}

}