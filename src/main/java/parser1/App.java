/**
 * @author Masood Ahmad
 * @version 1.0
 *
 * This is class parses the csv data and converts it to JSON data
 * in a predetermined format. The aggregation is achieved by making
 * index/cursor based data structure for few items like projects and
 * orders as there needs to be a join type relation of these two with
 * each other and other items.
 *
 * Copyright (c) 2019, Masood Ahmad. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 */

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
