package com.big_Xplosion.blazeInstaller.util;

import java.io.File;

public class FileUtil
{
	public static void createDirStructureForFile(File file)
	{
		if (!file.exists())
		{
			String[] dirs = file.getAbsolutePath().split(File.separator);
			String newFile = "";

			for (int index = 0; index < dirs.length - 1; index++)
				newFile += "/" + dirs[index];

			File currFile = new File(newFile);

			if (!currFile.exists())
				if (!currFile.mkdirs())
					throw new RuntimeException("Could not create directory: " + currFile.getAbsolutePath());
		}
	}

	@SuppressWarnings("unused")
	private static String arrayToString(String[] array)
	{
		StringBuilder builder = new StringBuilder((array.length * 2) + 1);
		int numProcessed = 0;
		builder.append("[");

		for (String str : array)
		{
			numProcessed++;
			builder.append(str);
			if (numProcessed < array.length)
				builder.append(",");
		}

		builder.append("]");

		return builder.toString();
	}
}
