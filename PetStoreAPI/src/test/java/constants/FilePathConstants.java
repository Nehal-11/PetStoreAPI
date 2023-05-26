package constants;

import java.io.File;

public class FilePathConstants {
    public static String configPath ="C:\\Users\\nehal.ruparel\\IdeaProjects\\PetStoreAPI\\src\\test\\resources\\config.properties";
    public static String imagePath ="C:\\Users\\nehal.ruparel\\IdeaProjects\\PetStoreAPI\\src\\test\\resources\\img\\dog2.jpg";
    public static File file = new File(imagePath);
    public static String base = "C:\\Users\\nehal.ruparel\\IdeaProjects\\PetStoreAPI\\src\\test\\resources\\jsonSchema";

    public static String postjsonPath = base + "\\postSchema.json";
    public static String getIdjsonPath = base+ "\\getByIdSchema.json";
    public static String soldStatusjsonPath = base + "\\soldSchema.json";
    public static String pendingStatusjsonPath = base + "\\pendingSchema.json";


}
