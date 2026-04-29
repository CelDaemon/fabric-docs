package com.example.docs.worldgen;

import com.example.docs.ExampleMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.StructureSet;

public class ExampleModStructureSets {
	public static final ResourceKey<StructureSet> CREEPY = key("creepy");

	private static ResourceKey<StructureSet> key(String path) {
		return ResourceKey.create(Registries.STRUCTURE_SET, Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, path));
	}
}
