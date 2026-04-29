package com.example.docs.datagen;

import com.example.docs.worldgen.ExampleModStructures;

import com.example.docs.worldgen.HerobrineStructure;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;

import java.util.concurrent.CompletableFuture;

public class ExampleModStructureProvider extends FabricDynamicRegistryProvider {
	public ExampleModStructureProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(HolderLookup.Provider registries, Entries entries) {
		entries.addAll(registries.lookupOrThrow(Registries.STRUCTURE));
	}

	public static void bootstrap(BootstrapContext<Structure> context) {
		final var biomeLookup = context.lookup(Registries.BIOME);
		context.register(
						ExampleModStructures.HEROBRINE,
						new HerobrineStructure(
										new Structure.StructureSettings.Builder(
														HolderSet.direct(biomeLookup.getOrThrow(Biomes.OLD_GROWTH_BIRCH_FOREST))
										)
														.terrainAdapation(TerrainAdjustment.BEARD_THIN)
														.generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
														.build()
						)
		);
	}

	@Override
	public String getName() {
		return "Structures";
	}
}
