// Sally Xiao
//Input: the user is only required to click buttons according to their desired choices throughout the game
//Output: Throughout the game, the output depends on the user's choices
//        At the very end, when all the questions have been answered, the user is able to view his/her total score earned

//////////////////////THE FOLLOWING IMPORTS ALL NECESSARILY ELEMENTS////////////////////////////////
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Jeopardy
{
    /////////////////////////////VARIABLE DECLARATIONS FOR THE CLASS/////////////////////////////////////////
    //variable declarations with "public static" so they can be accessed anywhere throughout the class
    public static int score = 0; //this variable holds the user's score starting from 0
    public static final String[] [] QUESTIONS = new String[] []  //this is an array of questions arranged in the same positions as the buttons
    {
	{
	    "Which city is the capital of Hungary?", "Who wrote The Great Gatsby?", "When did WW1 start?", "[1+(2 x 3)+5]/6=?", "How old is Rihanna in June 2016?", "What's the normal body temperature?"
	}
	,
	{
	    "What is the smallest country by area?", "When was Shakespeare born?", "Which country was invaded by Japan?", "1/2+ 1/4 + 1/5 +1/20=?", "What's Natalie Portman's last name?", "Which is a biological domain?"
	}
	,
	{
	    "Which country's flag does not have red?", "What did Charles Dickens not write?", "Who tested out the first atomic bomb?", "(Round to the nearest integer) tan 45=?", "What year did Taylor Swift debut?", "What is the 20th element in the periodic table?"
	}
	,
	{
	    "Which is not a Scandinavian country?", "Which book is not yet made into a movie?", "Who was Germany's leader in WW1?", "What digit repeats in the decimal of 12/99?", "Which actress married Brad Pitt?", "What degree Celcius is Mercury's boiling point?"
	}
	,
	{
	    "Which country has the tallest mountain?", "In what was \"Nevermore\" a famous line?", "Who was third Canadian Prime Minister?", "The period of y=sin 3x is?", "Lily-Rose is the daughter of?", "Who invented alternating current?"
	}

    }


    ;
    public static final String[] [] ANSWERS = new String[] []   //this is an array of the answers for each question
    {
	{
	    "Budapest", "F.S.Fitzgerald", "1914", "2", "28", "37C"
	}
	,
	{
	    "Vatican City", "1564", "China", "1", "Hershlag", "Bacteria"
	}
	,
	{
	    "Brazil", "Clarrissa", "USA", "2", "2006", "Calcium"
	}
	,
	{
	    "Poland", "Capital", "Wilhelm II", "12", "A.Jolie", "357"
	}
	,
	{
	    "Nepal", "The Raven", "J.Abbott", "2pi/3", "J.Depp", "N.Tesla"
	}

    }


    ;

    public static final String[] [] CHOICES = new String[] []  //this is the array used to list the choices for all the question
    {
	{
	    "Paris", "New York", "Budapest", "Milan"
	}
	,
	{
	    "F.S.Fitzgerald", "S.King", "J.K.Rowling", "J.Austen"
	}
	,
	{
	    "1912", "1914", "1945", "1943"
	}
	,
	{
	    "3", "4", "2", "1"
	}
	,
	{
	    "21", "28", "26", "20"
	}
	,
	{
	    "37C", "36C", "23C", "25C"
	}
	,
	{
	    "Grenada", "Malta", "Nauru", "Vatican City"
	}
	,
	{
	    "1456", "1465", "1564", "1546"
	}
	,
	{
	    "China", "England", "Spain", "Canada"
	}
	,
	{
	    "2", "1", "-1", "-2"
	}
	,
	{
	    "Portman", "Hershlag", "Hershmaig", "Portmein"
	}
	,
	{
	    "Bacteria", "Animalia", "Plantae", "Protista"
	}
	,
	{
	    "France", "China", "Russia", "Brazil"
	}
	,
	{
	    "Clarrissa", "The Goblins", "Oliver Twist", "N.Nickleby"
	}
	,
	{
	    "Russia", "N.Korea", "USA", "Japan"
	}
	,
	{
	    "2", "1", "-1", "-2"
	}
	,
	{
	    "2006", "2007", "2008", "2009"
	}
	,
	{
	    "Potassium", "Calcium", "Magnesium", "Copper"
	}
	,
	{
	    "Sweden", "Iceland", "Finland", "Poland"
	}
	,
	{
	    "Twilight", "Divergent", "Capital", "The Giver"
	}
	,
	{
	    "Hitler", "Wilhelm I", "Wilhelm II", "Hitler IV"
	}
	,
	{
	    "1", "2", "12", "21"
	}
	,
	{
	    "R.Witherspoon", "A.Jolie", "A.Grande", "M.Ciccone"
	}
	,
	{
	    "100", "120", "367", "357"
	}
	,
	{
	    "China", "Nepal", "Japan", "Malaysia"
	}
	,
	{
	    "The Raven", "Paper Towns", "Hamlet", "The Host"
	}
	,
	{
	    "J.Abbott", "P.E.Trudeau", "S.Harper", "K.Campbell"
	}
	,
	{
	    "2pi", "pi/3", "2pi/3", "3pi/2"
	}
	,
	{
	    "J.Depp", "B.Pitt", "W.Smith", "T.Cruise"
	}
	,
	{
	    "T.Edison", "M.Curry", "A.G.Bell", "N.Tesla"
	}
    }


    ;
    public static final String[] QTITLE = {"Geography", "Literature", "History", "Mathematics", "Celebrity", "Science"}; //this is the array holding the amount for each row of questions
    public static final int[] SCORES = {100, 200, 400, 800, 1000};  //this is the array holding the amount for each row of questions

    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%START OF ALL METHODS%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//
    //////////////////////////////MAIN METHOD/////////////////////////////////////////////
    public static void main (String[] args)
    {
	startMenu (); //display the start menu and start the program
    } // main method


    /////////////////////THIS IS SIMPLY A METHOD THAT INITIALIZES A PANEL TO ALLOW A SIMPLER DECLARATION PROCESS//////////////////////////////////
    public static void panelDeclare (JPanel p, int length, int width)  //declares and initializes all the necessary elements for a panel
    {
	p.setLayout (null);
	p.setBounds (0, 0, length, width);
	p.setBackground (Color.white);   // refer to awt colors - you can change the panel color
	p.setVisible (true);

    }


    ///////////////////THE FOLLOWING METHOD IS CONCERNED WITH THE DISPLAY OF THE MENU OF THE GAME/////////////////////////////////////////
    public static void startMenu ()
    {
	//variable declaration for the menu
	final JFrame menu; //the menu frame
	menu = new JFrame ("Start Menu");
	menu.setBounds (100, 100, 400, 400);
	menu.dispatchEvent (new WindowEvent (menu, WindowEvent.WINDOW_CLOSING));  //when the menu frame is closed the whole program closes
	menu.getContentPane ().setLayout (null);
	//the panel containing all elements on the menu
	JPanel menuPanel = new JPanel (new FlowLayout ()); //the panel for the menu
	panelDeclare (menuPanel, 400, 400); //call the method that declares a panel

	JLabel introMessage = new JLabel ("Welcome to Jeopardy!"); //the introduction message for the user is displayed on this panel
	introMessage.setFont (new Font ("Arial", Font.PLAIN, 20));
	introMessage.setBounds (100, 40, 250, 25);

	JLabel instruction = new JLabel ("Choose your options from below:"); //this is the instruction for the user to click a button
	instruction.setFont (new Font ("Arial", Font.PLAIN, 14));
	instruction.setBounds (100, 80, 250, 25);

	//Button to view rules
	JButton rules = new JButton ("View Rules");
	rules.setFont (new Font ("Times New Roman", Font.PLAIN, 12));
	rules.setBounds (120, 130, 150, 30);
	//Button to start the game
	JButton start = new JButton ("Start Game");
	start.setFont (new Font ("Times New Roman", Font.PLAIN, 12));
	start.setBounds (120, 180, 150, 30);
	//Button to exit the game
	JButton exit = new JButton ("Exit");
	exit.setFont (new Font ("Times New Roman", Font.PLAIN, 12));
	exit.setBounds (120, 230, 150, 30);

	//what happens when you press the rules button
	rules.addActionListener (new ActionListener ()  //what you do when u click the button
	{
	    public void actionPerformed (ActionEvent arg0)
	    {
		showRules (); //call the method to display the rules for the user when the rules button is pressed
	    }
	}
	);

	//what happens when you press the start button
	start.addActionListener (new ActionListener ()  //when you click the start button
	{
	    public void actionPerformed (ActionEvent arg0)
	    {
		displayGame (); //call the method that pops up the gameboard for the user
	    }
	}
	);


	//what happens when you press the exit button
	exit.addActionListener (new ActionListener ()  //when you click the exit button
	{
	    public void actionPerformed (ActionEvent arg0)
	    {
		System.exit (0); //the whole program exits
	    }
	}
	);

	//the following adds everything appearing on the menu paanel to the menu panel
	menuPanel.add (introMessage);
	menuPanel.add (instruction);
	menuPanel.add (rules);
	menuPanel.add (start);
	menuPanel.add (exit);
	menu.getContentPane ().add (menuPanel); //adding the menu panel to the menu frame
	menu.setResizable (false);  //prevent the user from resizing the panel
	menu.setVisible (true);   //make the panel and its related elements visible

    }


    /////////////////////////THE FOLLOWING METHODS ARE CONCERNED WITH THE RULES OF THE GAME//////////////////////////////////////////
    public static void writeRules ()  //this method creates a file named "rules.txt" and writes the rules of the game into it
    {
	try
	{
	    FileWriter dw = new FileWriter ("rules.txt"); //creating the file
	    PrintWriter pw = new PrintWriter (dw);
	    pw.println ("WELCOME TO JEOPARDY!");
	    pw.println ("Please CAREFULLY read the following:");
	    pw.println ("1. To start the game, click the start button below");
	    pw.println ("2. Once the game starts, one question can only be answered once");
	    pw.println ("3. Choose your answers carefully, a misclick will not be tolerated");
	    pw.println ("4. A correct answer will earn the number of points corresponded to the question");
	    pw.println ("5. An incorrect answer will not earn the user any points");
	    pw.close ();
	}
	catch (IOException e)
	{
	}
    }


    public static void addRules (JPanel p)  //this reads each line and changing each line into a JLabel
    {
	writeRules ();
	try
	{

	    FileReader dr = new FileReader ("rules.txt");
	    BufferedReader br = new BufferedReader (dr);
	    String line;
	    line = br.readLine (); //line is the variable for each line read
	    int lineSpace = 0; //declared for the line spacing of each line of rule
	    while (line != null) //read until the end of the file
	    {

		JLabel eachRule = new JLabel (line);
		if (lineSpace == 0)
		{ //the first line of the rules board is formatted differently than the rest
		    eachRule.setFont (new Font ("Arial", Font.BOLD, 20)); //making each line a JLabel
		    eachRule.setBounds (200, 50 + lineSpace * 50, 700, 25);
		}
		else if (lineSpace == 1)
		{ //the second line of the rules board is also formatted differently than the rest
		    eachRule.setFont (new Font ("Arial", Font.ITALIC, 16)); //making each line a JLabel
		    eachRule.setBounds (20, 50 + lineSpace * 50, 700, 25);
		}
		else
		{
		    eachRule.setFont (new Font ("Arial", Font.PLAIN, 14));  //making each line a JLabel
		    eachRule.setBounds (50, 50 + lineSpace * 50, 700, 25);
		}
		p.add (eachRule); //adding each line of rule to the rule panel
		line = br.readLine ();
		lineSpace = lineSpace + 1;

	    }
	    br.close ();
	}

	catch (IOException e)
	{
	}
    }


    public static void showRules ()  //this method shows a new frame with the rules when called
    {

	final JFrame RULES;
	RULES = new JFrame ("Rules");
	RULES.setBounds (100, 100, 600, 700);
	RULES.dispatchEvent (new WindowEvent (RULES, WindowEvent.WINDOW_CLOSING));
	RULES.getContentPane ().setLayout (null);
	//this is the panel on which the message will be displayed
	JPanel rulePanel = new JPanel (new FlowLayout ());
	panelDeclare (rulePanel, 600, 700);
	addRules (rulePanel);
	//Button to start the game
	JButton start = new JButton ("Start Game");
	start.setFont (new Font ("Times New Roman", Font.BOLD, 20));
	start.setBounds (180, 550, 200, 60);
	//what happens when you press the start button
	start.addActionListener (new ActionListener ()  //when you click the start button
	{
	    public void actionPerformed (ActionEvent arg0)
	    {
		displayGame (); //call the method that pops up the gameboard for the user
		RULES.setVisible (false); //the rules fram disappear when game starts
	    }
	}
	);
	rulePanel.add (start);
	//making the frame visible
	RULES.getContentPane ().add (rulePanel);
	RULES.setResizable (false);
	RULES.setVisible (true);
    }


    //////////////////////////////////THE FOLLOWING METHODS ARE CONCERNED WITH THE GAMEBOARDS OF THE GAME/////////////////////////////////////////////////////
    public static void categories (JPanel p)
    {
	//this is the method used to label all game categories
	String[] categoryTitles = {"GEOGRAPHY", "LITERATURE", "HISTORY", "MATHEMATICS", "CELEBRITY", "SCIENCE"}; //this is the array storing all game categories
	for (int i = 0 ; i < 6 ; i++)
	{
	    JLabel category = new JLabel (categoryTitles [i]);
	    category.setFont (new Font ("Arial", Font.PLAIN, 14));
	    if (i == 2)
	    { //this categoty has a shorter word length, therefore the position needs to be manually adjusted
		category.setBounds (250, 50, 250, 25);
	    }
	    else if (i == 3)
	    { //this category has a longer word length, therefore the position needs to be manually adjusted
		category.setBounds (340, 50, 250, 25);
	    }
	    else //the other categories can be indented 110 x values apart
	    {
		category.setBounds (20 + i * 110, 50, 250, 25);
	    }
	    p.add (category); //adding each category to the game panel to make them visible
	}
    }


    public static void questionButtons (JPanel p)
    { //method that declares and adds buttons for questions on the game board
	//variable declarations
	final JButton[] [] QBUTTONS = new JButton [5] [6]; //this is a button array holding all the buttons

	int prevNum = 0; //this keeps tract of the question number
	//this loop goes through all the buttons and tell them what they should do
	for (int m = 0 ; m < 5 ; m++)
	{
	    for (int n = 0 ; n < 6 ; n++)
	    {
		final int QNUM = prevNum;
		final int I = m;
		final int J = n;

		QBUTTONS [I] [J] = new JButton (Integer.toString (SCORES [I]));
		QBUTTONS [I] [J].addActionListener (new ActionListener ()  //what you do when u click the button
		{
		    public void actionPerformed (ActionEvent arg0)
		    {
			final JFrame QFRAME = new JFrame (QTITLE [J] + " " + Integer.toString (SCORES [I])); //frame name for each question is the category name plus its amount
			QFRAME.setBounds (100, 100, 400, 200);
			QFRAME.dispatchEvent (new WindowEvent (QFRAME, WindowEvent.WINDOW_CLOSING)); //only closes one frame
			QFRAME.getContentPane ().setLayout (null);
			//declaring the panel
			JPanel qPanel = new JPanel (new FlowLayout ());
			panelDeclare (qPanel, 400, 400);
			//adding the question
			JLabel eachQuestion = new JLabel (QUESTIONS [I] [J]);
			eachQuestion.setFont (new Font ("Arial", Font.PLAIN, 15));
			eachQuestion.setBounds (10, 5, 320, 25);
			qPanel.add (eachQuestion);

			for (int i = 0 ; i < 4 ; i++) //this loop adds the 4 choices for each question
			{

			    final JButton SELECT = new JButton (CHOICES [QNUM] [i]); //the names of the 4 choices of each question are declared in the CHOICES array

			    SELECT.setFont (new Font ("Times New Roman", Font.PLAIN, 12));
			    SELECT.setBounds (120, 30 + i * 25, 120, 20);
			    SELECT.addActionListener (new ActionListener ()
			    {
				public void actionPerformed (ActionEvent arg0)
				{

				    if (SELECT.getText ().compareTo (ANSWERS [I] [J]) == 0) //if this button is the right answer and it is clicked
				    { //increases the user's total score by the amount of the question
					resultFrame ("Congradulations!", I, J, ANSWERS); //a new frame will pop up telling the user his/her answer is correct
					QFRAME.setVisible (false); //the question frame is closed immediately after the user answers it
					score = score + SCORES [I]; //score earned will change value if the user answered the question correctly

				    }
				    else //if this button clicked is not the right answer
				    {
					QFRAME.setVisible (false); //the question window will close
					resultFrame ("Wrong Answer!", I, J, ANSWERS); //a new frame will pop up telling the user his/her answer is incorrect
				    }
				    //once a question is answered(correctly or incorrectly), the question is no longer answerable
				    //the following 4 lines make the button invisible and unclickable

				    QBUTTONS [I] [J].setOpaque (false);
				    QBUTTONS [I] [J].setContentAreaFilled (false);
				    QBUTTONS [I] [J].setBorderPainted (false);
				    QBUTTONS [I] [J].setEnabled (false);

				}
			    }
			    );
			    qPanel.add (SELECT); //adding each selection button to the panel
			}

			//making everything visible
			QFRAME.getContentPane ().add (qPanel);
			QFRAME.setResizable (false);
			QFRAME.setVisible (true);
		    }
		}
		);
		QBUTTONS [I] [J].setFont (new Font ("Times New Roman", Font.PLAIN, 12));
		QBUTTONS [I] [J].setBounds (20 + J * 106, 100 + I * 100, 100, 40);
		p.add (QBUTTONS [I] [J]);
		prevNum = prevNum + 1; //move on to add elements for the next question

	    }
	}



    }


    public static void resultFrame (String s, int i, int j, String[] [] answers)
    { //this codes for the frame to tell if the users' choice is correct
	final JFrame RESULTFRAME = new JFrame (s);
	RESULTFRAME.setBounds (200, 200, 400, 100);
	RESULTFRAME.dispatchEvent (new WindowEvent (RESULTFRAME, WindowEvent.WINDOW_CLOSING));
	RESULTFRAME.getContentPane ().setLayout (null);
	//this is the panel on which the message will be displayed
	JPanel resultPanel = new JPanel (new FlowLayout ());
	panelDeclare (resultPanel, 400, 100);
	//this label tells user the correct answer
	JLabel coAns = new JLabel ("The correct answer is " + answers [i] [j]); //displays the right answer for the corresponding question/button
	coAns.setFont (new Font ("Arial", Font.PLAIN, 15));
	coAns.setBounds (100, 5, 250, 25);
	resultPanel.add (coAns);
	//making the frame visible
	RESULTFRAME.getContentPane ().add (resultPanel);
	RESULTFRAME.setResizable (false);
	RESULTFRAME.setVisible (true);
    }


    public static void viewScoreButton (JPanel p)
    { //this creates the button for the user to view current score
	JButton viewScore = new JButton ("View Score"); //this is the button that shows the user's score at any point of the game
	viewScore.setFont (new Font ("Times New Roman", Font.BOLD, 12));
	viewScore.setBounds (20, 565, 100, 30);
	viewScore.addActionListener (new ActionListener ()  //this is what happens when the view score button is pressed
	{
	    public void actionPerformed (ActionEvent arg0)
	    {
		final JFrame SCOREFRAME = new JFrame ("Current Score");
		SCOREFRAME.setBounds (200, 200, 400, 100);
		SCOREFRAME.dispatchEvent (new WindowEvent (SCOREFRAME, WindowEvent.WINDOW_CLOSING));
		SCOREFRAME.getContentPane ().setLayout (null);
		//this is the panel on which the message will be displayed
		JPanel scorePanel = new JPanel (new FlowLayout ());
		panelDeclare (scorePanel, 400, 100);
		JLabel scoreMessage = new JLabel ("You've earned $" + Integer.toString (score) + " so far"); //displays the right answer for the corresponding question/button
		scoreMessage.setFont (new Font ("Arial", Font.PLAIN, 16));
		scoreMessage.setBounds (100, 10, 250, 25);
		scorePanel.add (scoreMessage);
		//making the frame visible
		SCOREFRAME.getContentPane ().add (scorePanel);
		SCOREFRAME.setResizable (false);
		SCOREFRAME.setVisible (true);
	    }
	}
	);
	p.add (viewScore); //adding this button to the panel

    }



    public static void addExitButton (JPanel p)
    { //this is the method that codes for an exit button that appears on the game board
	JButton exit = new JButton ("Exit");
	exit.setFont (new Font ("Times New Roman", Font.BOLD, 12));
	exit.setBounds (550, 565, 100, 30);
	exit.addActionListener (new ActionListener ()  //when you click the exit button
	{
	    public void actionPerformed (ActionEvent arg0)
	    {
		System.exit (0); //the whole program exits
	    }
	}
	);
	p.add (exit);
    }


    public static void displayGame ()
    { //this is the method that displays the game baord for the user
	final JFrame GAMEBOARD = new JFrame ("Jeopardy Board");
	GAMEBOARD.setBounds (100, 100, 700, 650);
	GAMEBOARD.dispatchEvent (new WindowEvent (GAMEBOARD, WindowEvent.WINDOW_CLOSING)); //only closes one frame
	GAMEBOARD.getContentPane ().setLayout (null);

	JPanel gamePanel = new JPanel (new FlowLayout ());
	panelDeclare (gamePanel, 700, 650);

	JLabel introMessage = new JLabel ("J E O P A R D Y");
	introMessage.setFont (new Font ("Arial", Font.PLAIN, 20));
	introMessage.setBounds (290, 10, 250, 25);

	categories (gamePanel); //calls the method that declares and labels the game categories
	questionButtons (gamePanel); //calls the method that adds the buttons for all the questions to the game board
	viewScoreButton (gamePanel); //calls the method that adds the view score button to the game board
	addExitButton (gamePanel); //calls the method that adds the exit button to the game panel
	gamePanel.add (introMessage); //calls the method that displays the title message for user
	//gamePanel.add()
	GAMEBOARD.getContentPane ().add (gamePanel);
	GAMEBOARD.setResizable (false);
	GAMEBOARD.setVisible (true);

    }



}

