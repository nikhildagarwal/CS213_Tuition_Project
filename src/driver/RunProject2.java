/**
 * holds driver class to run project
 */
package driver;

import process.TuitionManager;

/**
 * Driver class for project.
 * Run this class to interact with program in command line.
 * @author Nikhil Agarwal
 */
public class RunProject2 {
    public static void main(String[] args){
        new TuitionManager().run();
    }
}

