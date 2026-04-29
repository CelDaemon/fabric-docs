package com.example.docs.datagen;

import com.example.docs.worldgen.ExampleModStructureSets;

import com.example.docs.worldgen.ExampleModStructures;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

import java.util.concurrent.CompletableFuture;

public class ExampleModStructureSetProvider extends FabricDynamicRegistryProvider {
	public ExampleModStructureSetProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(HolderLookup.Provider registries, Entries entries) {
		entries.addAll(registries.lookupOrThrow(Registries.STRUCTURE_SET));
	}

	public static void bootstrap(BootstrapContext<StructureSet> context) {
		final var structureLookup = context.lookup(Registries.STRUCTURE);
		context.register(
						ExampleModStructureSets.CREEPY,
						new StructureSet(
										structureLookup.getOrThrow(ExampleModStructures.HEROBRINE),
										new RandomSpreadStructurePlacement(32, 8, RandomSpreadType.LINEAR, 0x6b8b4567)
						)
		);
	}

	@Override
	public String getName() {
		return "Structure Sets";
	}
}
