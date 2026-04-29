package com.example.docs.worldgen;

import com.mojang.serialization.MapCodec;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

import java.util.Optional;

public class HerobrineStructure extends Structure {
	public static final MapCodec<HerobrineStructure> CODEC = simpleCodec(HerobrineStructure::new);
	public HerobrineStructure(StructureSettings settings) {
		super(settings);
	}

	@Override
	protected Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
		return onTopOfChunkCenter(
						context,
						Heightmap.Types.WORLD_SURFACE_WG,
						builder -> generatePieces(builder, context)
		);
	}

	private static void generatePieces(StructurePiecesBuilder builder, GenerationContext context) {
		final var chunkPos = context.chunkPos();
		builder.addPiece(
						new HerobrineStructurePiece(
										context.random(),
										chunkPos.getMinBlockX(),
										chunkPos.getMinBlockZ()
						)
		);
	}

	@Override
	public StructureType<HerobrineStructure> type() {
		return ExampleModStructureTypes.HEROBRINE;
	}
}
