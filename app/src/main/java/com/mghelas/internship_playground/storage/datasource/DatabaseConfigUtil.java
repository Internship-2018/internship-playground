package com.mghelas.internship_playground.storage.datasource;


import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.File;

public class DatabaseConfigUtil extends OrmLiteConfigUtil {
    public static void main(String[] args) throws Exception {
        File configFile = new File(new File("").getAbsolutePath()
                .split("app" + File.separator + "build")[0] + File.separator +
                "app" + File.separator +
                "src" + File.separator +
                "main" + File.separator +
                "res" + File.separator +
                "raw" + File.separator +
                "ormlite_config.txt");
        writeConfigFile(configFile);
    }
}
