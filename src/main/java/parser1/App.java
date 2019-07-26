

package parser1;

import Pojos.Project;
import Pojos.NumberOfActivityTypes;
import Pojos.NumberOfParticipantTypes;
import Pojos.NumberOfPendingTypes;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main( String[] args ) throws Exception{
        Parse.parseCsv();
    }
}
