# Personal Finance management app

## What will the application do?

- Allow the user to input transactions and classify them as either incomes or expenses.
- Allow the user to categorise expenses (Food, Utilities, Grocery, Leisure, etc.)
- Be able to produce the greatest expense, greatest income
- Be able to produce category of the highest spending
- Give pre-written pieces of advice

## Who will use it?

- People who want to track their spending and save money

## Why is this project of interest to you?

I have always been very passionate about personal finance. Usually I track
my finances using a spreadsheet, but while talking to my peers I have
realised that it is quite tedious for people to create a spreadsheet
and constantly update it. An app would make it much easier for
data entry and also to get insights from that data as to how
a person's finances have improved from a previous time frame.

## User Stories

- As a user, I want to be able to add a transaction to my transaction summary.
- As a user, I want to be able to view a list of transactions in my transaction summary.
- As a user, I want to be able to remove a transaction from my transaction summary.
- As a user, I want to be able to categorise each transaction.
- As a user, I want to be able to see my greatest expense for the month.
- As a user, I want to be able to save my transaction summary to file (if I so choose)
- As a user, I want to be able to be able to load my transaction summary from file (if I so choose)

#### Stretch Goals: Not Implemented Yet
- As a user, I want to be able to add a new category if it does not exist.
- As a user, I want to be able to see the category that I spend the most on.

## Instructions for Grader
### Adding a transaction to the transaction summary:
- Press the button labeled "Add", found in the bottom panel.
- A new window will come up prompting the user for input for the Date, Details, Amount, and Category fields.
- Make sure the data is in the format yyyy-mm-dd
- Make sure to input only numerical values in the amount Field
- Any String can be put into the Detail and Category fields

### Removing a transaction
- Press the button labeled "Remove", found in the bottom panel.
- A new window comes up prompting the user for the Detail of the transaction to be removed.
- Any String value is accepted in this field.
- You will be alerted if no such transaction exists
- Note that all transactions with the given detail will be removed from the summary.

### Visual Component
The visual component can be found by pressing any of the buttons in the bottom panel.
Icons can be found on the left side of the window. 

### Saving and Loading data
- To save what is currently displayed on the transaction summary, press the button
labeled "Save", found in the bottom panel. 
  - A successful save can be verified by a pop-up window.
- To load a saved state of the program from a file, press the button labeled
"Load", found in the bottom panel.
  - After this a pop-up window will show up to confirm that you want to load the state.
  - Press the button labeled "OK" and the transaction summary from the last saved file
    will be loaded.

## Phase 4: Task 2
Note: When a program state is loaded from the saved file, the log will display the events in the saved file as being
added to the TransactionSummary.

Event Log:  
Added Transaction: 2023-04-01; Fools Day; 4001.0  
Added Transaction: 2023-04-07; Hackathon; 20.0  
Removed Transaction with Detail: Fools Day

## Phase 4: Task 3
After careful analysis of my program I would consider refactoring my TransactionSummary class
to use the Singleton pattern, because only 1 instance of the class is passed throughout the program.
Therefore, it would be more efficient to have only 1 instance accessible by all classes. Furthermore, I 
would implement an Observer design to make it easier to add more functionality in the future. I would have an
observer class that would notify every class that was associated with the TransactionSummary class when an instance 
of TransactionSummary is changed. This means the current TransactionSummary will not need to be passed in through 
multiple classes. Adding an Observer class would 
take time and not be worth it for the number of features I have right now. However, if I wanted to add additional 
panels to the app then having all screens be updated with what the current state of the TransactionSummary will 
eliminate the need to repetitively pass the current TransactionSummary as a parameter to all panels.