package com.example.docs.worldgen;

import com.example.docs.ExampleMod;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;

public class ExampleModStructurePieceTypes {
	public static final StructurePieceType HEROBRINE = register("herobrine", HerobrineStructurePiece::new);

	private static StructurePieceType register(String path, StructurePieceType.ContextlessType type) {
		return Registry.register(BuiltInRegistries.STRUCTURE_PIECE, Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, path), type);
	}

	public static void init() {

	}
}
