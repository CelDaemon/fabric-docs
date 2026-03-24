package com.example.docs.fog;

import net.minecraft.world.level.material.FogType;

import com.example.docs.mixin.FogTypeInvoker;

public class ExampleModFogTypes {
	public static FogType ACID = FogTypeInvoker.init("ACID", -1);
}
