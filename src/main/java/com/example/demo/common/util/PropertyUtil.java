package com.example.demo.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

@SuppressWarnings("rawtypes")
public class PropertyUtil {
	private static PropertyUtil manager = null;
	private static Object managerLock = new Object();
	private static String propsName = "/config.properties";

	public static String getProperty(String name) {
		if (manager == null) {
			synchronized (managerLock) {
				if (manager == null) {
					manager = new PropertyUtil(propsName);
				}
			}
		}
		return manager.getProp(name);
	}

	public static void setProperty(String name, String value) {
		if (manager == null) {
			synchronized (managerLock) {
				if (manager == null) {
					manager = new PropertyUtil(propsName);
				}
			}
		}
		manager.setProp(name, value);
	}

	public static void deleteProperty(String name) {
		if (manager == null) {
			synchronized (managerLock) {
				if (manager == null) {
					manager = new PropertyUtil(propsName);
				}
			}
		}
		manager.deleteProp(name);
	}

	public static Enumeration propertyNames() {
		if (manager == null) {
			synchronized (managerLock) {
				if (manager == null) {
					manager = new PropertyUtil(propsName);
				}
			}
		}
		return manager.propNames();
	}

	public static boolean propertyFileIsReadable() {
		if (manager == null) {
			synchronized (managerLock) {
				if (manager == null) {
					manager = new PropertyUtil(propsName);
				}
			}
		}
		return manager.propFileIsReadable();
	}

	public static boolean propertyFileIsWritable() {
		if (manager == null) {
			synchronized (managerLock) {
				if (manager == null) {
					manager = new PropertyUtil(propsName);
				}
			}
		}
		return manager.propFileIsWritable();
	}

	public static boolean propertyFileExists() {
		if (manager == null) {
			synchronized (managerLock) {
				if (manager == null) {
					manager = new PropertyUtil(propsName);
				}
			}
		}
		return manager.propFileExists();
	}

	private Properties properties = null;
	private Object propertiesLock = new Object();
	private String resourceURI;

	private PropertyUtil(String resourceURI) {
		this.resourceURI = resourceURI;
	}

	protected String getProp(String name) {
		if (properties == null) {
			synchronized (propertiesLock) {
				if (properties == null) {
					loadProps();
				}
			}
		}
		String property = properties.getProperty(name);
		if (property == null) {
			return null;
		} else {
			return property.trim();
		}
	}

	protected void setProp(String name, String value) {
		synchronized (propertiesLock) {
			if (properties == null) {
				loadProps();
			}
			properties.setProperty(name, value);
			saveProps();
		}
	}

	protected void deleteProp(String name) {
		synchronized (propertiesLock) {
			if (properties == null) {
				loadProps();
			}
			properties.remove(name);
			saveProps();
		}
	}

	protected Enumeration propNames() {
		if (properties == null) {
			synchronized (propertiesLock) {
				if (properties == null) {
					loadProps();
				}
			}
		}
		return properties.propertyNames();
	}

	private void loadProps() {
		properties = new Properties();
//		InputStream in = null;
		try {
//			in = getClass().getResourceAsStream(resourceURI);
//			properties.load(in);
			properties.load(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("config.properties"), "UTF-8"));
		} catch (Exception e) {
			System.err.println("Error reading properties file " + this.resourceURI +":"+ e);
			e.printStackTrace();
		} finally {
			try {
//				in.close();
			} catch (Exception e) {
			}
		}
	}

	private void saveProps() {
		String path = properties.getProperty("path").trim();
		OutputStream out = null;
		try {
			out = new FileOutputStream(path);
			properties.store(out, "Config.properties -- " + (new java.util.Date()));
		} catch (Exception ioe) {
			System.err.println("There was an error writing "+propsName+" to "
							+ path+ ". "
							+ "Ensure that the path exists and that the Config process has permission "
							+ "to write to it -- " + ioe);
			ioe.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Exception e) {
			}
		}
	}

	public boolean propFileIsReadable() {
		try {
			getClass().getResourceAsStream(resourceURI);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean propFileExists() {
		String path = getProp("path");
		if (path == null) {
			return false;
		}
		File file = new File(path);
		if (file.isFile()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean propFileIsWritable() {
		String path = getProp("path");
		File file = new File(path);
		if (file.isFile()) {
			if (file.canWrite()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}