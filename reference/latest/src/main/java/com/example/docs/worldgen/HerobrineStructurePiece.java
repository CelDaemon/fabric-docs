package com.example.docs.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.ScatteredFeaturePiece;

public class HerobrineStructurePiece extends ScatteredFeaturePiece {
	public HerobrineStructurePiece(final RandomSource random, final int west, final int north) {
		super(ExampleModStructurePieceTypes.HEROBRINE, west, 64, north, 3, 3, 0, getRandomHorizontalDirection(random));
	}

	public HerobrineStructurePiece(final CompoundTag tag) {
		super(ExampleModStructurePieceTypes.HEROBRINE, tag);
	}

	@Override
	public void postProcess(WorldGenLevel level, StructureManager structureManager, ChunkGenerator generator, RandomSource random, BoundingBox chunkBB, ChunkPos chunkPos, BlockPos referencePos) {
		generateBox(level, chunkBB, 0, 0, 0, 2, 0, 2, Blocks.GOLD_BLOCK.defaultBlockState(), Blocks.GOLD_BLOCK.defaultBlockState(), false);
		placeBlock(level, Blocks.NETHERRACK.defaultBlockState(), 1, 1, 1, chunkBB);
		placeBlock(level, Blocks.FIRE.defaultBlockState(), 1, 2, 1, chunkBB);
		placeBlock(level, Blocks.REDSTONE_TORCH.defaultBlockState(), 1, 1, 0, chunkBB);
		placeBlock(level, Blocks.REDSTONE_TORCH.defaultBlockState(), 0, 1, 1, chunkBB);
		placeBlock(level, Blocks.REDSTONE_TORCH.defaultBlockState(), 2, 1, 1, chunkBB);
		placeBlock(level, Blocks.REDSTONE_TORCH.defaultBlockState(), 1, 1, 2, chunkBB);
	}
}
