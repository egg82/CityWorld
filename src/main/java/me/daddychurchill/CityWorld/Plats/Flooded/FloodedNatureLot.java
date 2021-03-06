package me.daddychurchill.CityWorld.Plats.Flooded;

import me.daddychurchill.CityWorld.CityWorldGenerator;
import me.daddychurchill.CityWorld.Context.DataContext;
import me.daddychurchill.CityWorld.Plats.NatureLot;
import me.daddychurchill.CityWorld.Plats.PlatLot;
import me.daddychurchill.CityWorld.Support.InitialBlocks;
import me.daddychurchill.CityWorld.Support.PlatMap;
import me.daddychurchill.CityWorld.Support.RealBlocks;
import org.bukkit.generator.ChunkGenerator.BiomeGrid;

public class FloodedNatureLot extends NatureLot {

    public FloodedNatureLot(PlatMap platmap, int chunkX, int chunkZ) {
        super(platmap, chunkX, chunkZ);
        // TODO Auto-generated constructor stub
    }

    @Override
    public PlatLot newLike(PlatMap platmap, int chunkX, int chunkZ) {
        return new FloodedNatureLot(platmap, chunkX, chunkZ);
    }

    @Override
    protected void generateActualChunk(CityWorldGenerator generator, PlatMap platmap, InitialBlocks chunk,
                                       BiomeGrid biomes, DataContext context, int platX, int platZ) {
        // TODO Auto-generated method stub

    }

    @Override
    protected void generateActualBlocks(CityWorldGenerator generator, PlatMap platmap, RealBlocks chunk,
                                        DataContext context, int platX, int platZ) {
        generateSurface(generator, chunk, true);

        generateEntities(generator, chunk);
    }

}
