package Main;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Utils {

    public Utils(){}

    private final Path currentDirectoryPath = FileSystems.getDefault().getPath("");
    private final String path = currentDirectoryPath.toAbsolutePath().toString();

    /**
    Devuelve la ruta desde la que se esta ejecutando el programa.
     */
    public String getPath(){return path;}

}
