# temp2019-07-25

Required: these four sources aggregated in order to produce stats for each project. Think along the lines of a SQL Join. 
It downloads the zip file containing the CSV files (from here) and parses them;
It aggregates the given data;
It outputs the project list containing the following fields:

Definition Of Done
==============

- Unit Test with high test coverage
- OOP
- Code Documentation
- Clean Code
- No Code Smells


expected result:
=============

    [
      {
        "id": "1",
        "name": "Project 1",
        "numberOfOrders": 4,
        "numberOfPendingTypes": {
          "WriterTask": 1,
          "WebSearchTask": 1,
          "PublisherTask": 1
        },
        "numberOfParticipantTypes": {
          "writer": 3,
          "editor": 1,
          "publisher": 1
        },
        "numberOfActivityTypes": {
          "WriterTask": 4,
          "WebSearchTask": 3,
          "EditorTask": 1,
          "PublisherTask": 1
        }
      },
      {
        "id": "3",
        "name": "Project 3",
        "numberOfOrders": 0,
        "numberOfPendingTypes": null,
        "numberOfParticipantTypes": 0,
        "numberOfActivityTypes": null
      }
    ]


Data to parse
============

    projects
    ------
    Id,Name
    1,Project 1
    2,Project 2
    3,Project 3
    4,Project 4
    5,Project 5

    orders
    ----
    Id,Project Id,Keyword,Pending Task,State
    1,1,Black Shoes,null,approved
    2,1,Tie,WriterTask,pending
    3,2,Shirt,WriterTask,pending
    4,1,Election,WebSearchTask,pending
    5,5,Buy Ticket,null,approved
    6,2,Home,EditorTask,pending
    7,5,Istanbul Fish,ManagerTask,pending
    8,1,Chair,PublisherTask,pending

    participants
    ----
    id,Project Id,User Id,role
    1,1,24,writer
    2,2,24,writer
    3,5,4,writer
    4,5,3,editor
    5,1,3,writer
    6,1,122,editor
    7,1,126,publisher
    8,1,134,writer
    9,2,141,editor
    10,5,178,publisher
    11,5,271,manager
    12,5,834,writer

    activits
    ----
    Id,Order Id,type
    1,5,WriterTask
    2,1,WriterTask
    3,1,WriterTask
    4,8,EditorTask
    5,1,WriterTask
    6,1,WebSearchTask
    7,1,WebSearchTask
    8,5,WebSearchTask
    9,8,PublisherTask
    10,1,WriterTask
    11,5,EditorTask
    12,5,WriterTask
    13,1,WebSearchTask
    14,5,PublisherTask
    15,2,WriterTask
    16,3,WriterTask
    17,4,WriterTask
    18,4,WebSearchTask
    19,6,WriterTask
    20,6,WebSearchTask
    21,6,EditorTask
    22,7,ManagerTask
    23,8,WriterTask
    24,8,WebSearchTask
    25,1,EditorTask
    26,1,PublisherTask
