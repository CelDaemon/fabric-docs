package com.example.docs.entity;

import com.example.docs.ExampleMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

// #region ids
public class ModEntityTypeIds {
	public static ResourceKey<EntityType<?>> MINI_GOLEM = create("mini_golem");
	// #endregion ids
	// #region hot_tater
	public static ResourceKey<EntityType<?>> HOT_TATER = create("hot_tater");
	// #endregion hot_tater
	// #region ids

	private static ResourceKey<EntityType<?>> create(String name) {
		return ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, name));
	}
}
// #endregion ids
