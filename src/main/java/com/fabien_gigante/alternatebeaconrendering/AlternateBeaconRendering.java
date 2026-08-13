package com.fabien_gigante.alternatebeaconrendering;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlternateBeaconRendering implements ModInitializer {

	public static final String MOD_ID = "alternatebeaconrendering";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("[Alternate Beacon Rendering] initialized");
	}
}