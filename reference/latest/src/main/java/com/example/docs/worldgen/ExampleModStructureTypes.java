package com.example.docs.worldgen;

import com.example.docs.ExampleMod;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

public class ExampleModStructureTypes {
	public static final StructureType<HerobrineStructure> HEROBRINE = register("herobrine", HerobrineStructure.CODEC);
	private static <S extends Structure> StructureType<S> register(String path, MapCodec<S> codec) {
		return Registry.register(BuiltInRegistries.STRUCTURE_TYPE, Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, path), () -> codec);
	}

	public static void init() {

	}
}
