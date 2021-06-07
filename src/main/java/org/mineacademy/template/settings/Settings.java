package org.mineacademy.template.settings;

import java.util.Arrays;
import java.util.List;

import org.mineacademy.fo.settings.SimpleSettings;
import org.mineacademy.fo.settings.YamlStaticConfig;

/**
 * A sample settings class, utilizing {@link YamlStaticConfig} with prebuilt settings.yml handler
 * with a bunch of preconfigured keys, see resources/settings.yml
 */
@SuppressWarnings("unused")
public final class Settings extends SimpleSettings {

	/**
	 * @see org.mineacademy.fo.settings.SimpleSettings#getConfigVersion()
	 */
	@Override
	protected int getConfigVersion() {
		return 1;
	}

	/**
	 * Attempt to save comments and symlink settings.yml
	 *
	 * @return
	 */
	@Override
	protected boolean saveComments() {
		return true;
	}

	/**
	 * Place the sections where user can create new "key: value" pairs
	 * here so that they are not removed while adding comments.
	 * 
	 * Example use in ChatControl: user can add new channels in "Channels.List" 
	 * section so we place "Channels.List" here.
	 *
	 * @return the ignored sections
	 */
	@Override
	protected List<String> getUncommentedSections() {
		return Arrays.asList(
				"Example.Uncommented_Section");
	}

	/**
	 * A sample settings section
	 */
	public static class SampleSection {

		/**
		 * A sample flag
		 */
		public static Boolean SAMPLE_FLAG;

		/*
		 * Automatically called method when we load settings.yml to load values in this subclass
		 */
		private static void init() {

			// A convenience method to instruct the loader to prepend all paths with Example so you
			// do not have to call "Example.Key1", "Example.Key2" all the time, only "Key1" and "Key2".
			pathPrefix("Example");

			SAMPLE_FLAG = getBoolean("Sample_Flag");
		}
	}

	/*
	 * Automatically called method when we load settings.yml to load values in this class
	 */
	private static void init() {
		pathPrefix(null);
	}
}
