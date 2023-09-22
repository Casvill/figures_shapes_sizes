package Controller;
/**
 *
 * @author Daniel Casvill
 */


import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

//------------------------------------------------------------------------------------------------

public class GameLogic 
{
    private final String url;
    private static int tries = 0;
    private static int fails = 0;

    //--------------------------------------------------------------------------------------------
    
    public GameLogic() 
    {
         url = "src/Images/Figures";
    }
    
    //--------------------------------------------------------------------------------------------
    
    private String getElementRandomly(List<String> list)
    {
        int max = list.size();
        
        int rand = (int)(Math.random() * max);
        
        String element = list.get(rand);
        
        
        return element;
    }
    
    //--------------------------------------------------------------------------------------------
    
    private List<String> listFilesInFolder(String url) 
    {
        // Specify the path of the folder you want to list
        String folder = url;
        //System.out.println("Folder: " + url);

        // Create a File object to represent the folder
        File directory = new File(folder);

        // Initialize a list to store file names
        List<String> fileNames = new ArrayList<>();

        // Check if the folder exists
        if (directory.exists() && directory.isDirectory()) 
        {
            // List the files inside the folder
            File[] files = directory.listFiles();

            // Iterate over the files and add their names to the list
            for (File file : files) 
            {
                fileNames.add(url+"/"+file.getName());
            }
        } 
        
        else 
        {
            System.out.println("The folder does not exist or is not a valid folder.");
        }

        // Return the list of file names
        return fileNames;
    }
    
    //--------------------------------------------------------------------------------------------
    
    public List<String> getFigures(String url)
    {
        List<String> figures;
        String figure;
        
        figure = getElementRandomly(listFilesInFolder(url));
        figure = getElementRandomly(listFilesInFolder(figure));
        figures = listFilesInFolder(figure);
        Collections.shuffle(figures);
        
        return figures;
    }
    
    //--------------------------------------------------------------------------------------------
    
    public List<String> getFigures()
    {
        List<String> figures;
        String figure;
        
        figure = getElementRandomly(listFilesInFolder(url));
        figure = getElementRandomly(listFilesInFolder(figure));
        figures = listFilesInFolder(figure);
        Collections.shuffle(figures);
        
        return figures;
    }
    
    //--------------------------------------------------------------------------------------------
    public static int getTries() {
        return tries;
    }

    //--------------------------------------------------------------------------------------------
    
    public static void setTries(int tries) {
        GameLogic.tries = tries;
    }

    //--------------------------------------------------------------------------------------------
    
    public static int getFails() {
        return fails;
    }

    //--------------------------------------------------------------------------------------------
    
    public static void setFails(int fails) {
        GameLogic.fails = fails;
    }

    //--------------------------------------------------------------------------------------------
    /*
    public static void main(String args[]) 
    {
        String url = "src/Images/Figures";
        GameLogic gl = new GameLogic();
        System.out.println("Figures:"+gl.getFigures(url));
    }
    */
    //--------------------------------------------------------------------------------------------
}
//------------------------------------------------------------------------------------------------
