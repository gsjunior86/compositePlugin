package br.geraldo.composite;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class CompositePlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "br.geraldo.compositeLaunch"; //$NON-NLS-1$
	
	public static final String COMPOSITE_CONFIGURATIONS = "compositeConfigurations";
	
	public static final String NO_CONFIGURATIONS_MESSAGE = "No Configurations were detected, please create new Configurations";

	// The shared instance
	private static CompositePlugin plugin;
	private static List<ILaunchConfiguration> launchConfigurations = new ArrayList<ILaunchConfiguration>();
	
	
	/**
	 * The constructor
	 */
	public CompositePlugin() {
	}
	

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static CompositePlugin getDefault() {
		return plugin;
	}
	
	public static void setConfigurations(List<ILaunchConfiguration> listConfigurations){
		launchConfigurations = listConfigurations;
	}
	
	public static List<ILaunchConfiguration> getConfigurations(){
		return launchConfigurations;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
