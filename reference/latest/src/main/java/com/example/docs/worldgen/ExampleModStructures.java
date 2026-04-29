package com.example.docs.worldgen;

import com.example.docs.ExampleMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public class ExampleModStructures {
	public static ResourceKey<Structure> HEROBRINE = key("herobrine");

	private static ResourceKey<Structure> key(String path) {
		return ResourceKey.create(Registries.STRUCTURE, Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, path));
	}
}
