// test
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton; 

public class Quiz {

    private int index;
    private float correctCount = 0; 
    private ArrayList<Question> currentQuizList;

    final Color lightestbrown = Color.decode("#F8F0E5");
    final Color medbrown = Color.decode("#EADBC8");
    final Color warmbrown = Color.decode("#DAC0A3");
    final Color smoothnavy = Color.decode("#102C57");
    final Color softred = Color.decode("#C70039");
    final Color softgreen = Color.decode("#5B9A8B");

    // CHAPTER 7
    private static ArrayList<Question> chapter7Quiz = new ArrayList<Question>(Arrays.asList(
                    new Question("<html><body width='300px'>" +
                                "What is political socialization?" + // QUESTION 1
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "The process by which individuals acquire their political values and outlooks" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Systematic study of a defined population, analyzing a representative sample's view to draw inferences abuot the larger public's views" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Individuals who control significant wealth, status, power, or visibility and consequently have significant influence over public debates" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "A measure of public support for a political figure or insitution" + // ANSWER 4
                                    "</body></html>"), 
                    new Question("<html><body width='300px'>" +
                                "Which is NOT a souce of public opinion?" + // QUESTION 2
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Framing effect" + // ANSWER 1 **CORRECT ANSWER** 
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Elite influence" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Wars and other events" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Party preference" + // ANSWER 4
                                    "</body></html>"), 
                    new Question("<html><body width='300px'>" +
                                "Which is a way to improve polls?" + // QUESTION 3
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Random sampling, timing, and wording" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Random sampling" + // ANSWER 2 
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Timing" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Wording" + // ANSWER 4
                                    "</body></html>"), 
                    new Question("<html><body width='300px'>" +
                                "What is an opinion poll?" + // QUESTION 4
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Systematic study of a defined population, analyzing a representatives sample's views to draw inferences about the larger public's views" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "A poll question designed to get a certain result" + // ANSWER 2 
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "A sample in which everyone in the population has an equal probability of being selected" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "The tendency of poll respondents to misstate their views" + // ANSWER 4
                                    "</body></html>"), 
                    new Question("<html><body width='400px'>" +
                                "The tendency among a small group of decision makers to converge on a shared set of views is defined as:" + // QUESTION 5 
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Groupthink" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Bandwagon effect" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Boomerang effect" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Response bias" + // ANSWER 4
                                    "</body></html>"),
                    new Question("<html><body width='400px'>" +
                                "Which effect describes the discrepancy between candidates' high poll ratings and election performance?" + // QUESTION 6
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Boomerang effect" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Bandwagon effect" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Underdog effect" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Response effect" + // ANSWER 4
                                    "</body></html>"),
                    new Question("<html><body width='400px'>" +
                                "Samples of the population should be what of the population?" + // QUESTION 7
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Representative" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Suggestive" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Independent" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Respectful" + // ANSWER 4
                                    "</body></html>"),
                    new Question("<html><body width='400px'>" +
                                "Which type of poll intercepts voters as they exit a voting location and is performed on Election Day?" + // QUESTION 8
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Exit polls" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Benchmark polls" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Straw polls" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Brushfire polls" + // ANSWER 4
                                    "</body></html>"),
                    new Question("<html><body width='400px'>" +
                                "Which poll is designed to get a certain result and if often a negative form of campaigning?" + // QUESTION 9
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Push poll" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Pull poll" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Survey Research" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Partial poll" + // ANSWER 4
                                    "</body></html>"),
                    new Question("<html><body width='400px'>" +
                                "What is response bias?" + // QUESTION 10
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "The tendency of poll respondents to misstate their views" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "The degree of inaccuracy in any poll, as the poll was taken from a sample of the population" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "A poll question designed to get a certain result" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "A measure of public support for a political figure or institution" + // ANSWER 4
                                    "</body></html>"))); 

    // CHAPTER 8
    private static ArrayList<Question> chapter8Quiz = new ArrayList<Question>(Arrays.asList(
                    new Question("<html><body width='300px'>" +
                                "Which is NOT a way to traditionally participate in politics?" + // QUESTION 1
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Social media" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Voting" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Electoral activities" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Civic voluntarism" + // ANSWER 4
                                    "</body></html>"), 
                    new Question("<html><body width='300px'>" +
                                "What is political mobilization?" + // QUESTION 2
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Efforts to encourage people in the public sphere" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Cues about candidates and policies drawn from everyday life" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Excersising one's public rights" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Citizen participation in public life without government incentives or coercion" + // ANSWER 4
                                    "</body></html>"), 
                    new Question("<html><body width='300px'>" +
                                "Which generation(s) are least likely to get involved in traditional politics?" + // QUESTION 3
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Millennials and Gen Z" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Millennials" + // ANSWER 2 
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Gen Z" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Baby Boomers" + // ANSWER 4
                                    "</body></html>"), 
                    new Question("<html><body width='300px'>" +
                                "Writing a letter to an editor of a newspaper wuold be an example of:" + // QUESTION 4
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Traditional participation" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Civic voluntarism" + // ANSWER 2 
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Direct action" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Institutional participation" + // ANSWER 4
                                    "</body></html>"), 
                    new Question("<html><body width='400px'>" +
                                "Which would be an example of direct action?" + // QUESTION 5 
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Demonstrations, marches, and riots" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Demonstrations" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Marches" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Riots" + // ANSWER 4
                                    "</body></html>"),
                    new Question("<html><body width='400px'>" +
                                "About what percent of the voting age population turns out in presidential elections?" + // QUESTION 6
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "60%" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "20%" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "80%" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "100%" + // ANSWER 4
                                    "</body></html>"),
                    new Question("<html><body width='400px'>" +
                                "Which of the following encourages political participation?" + // QUESTION 7
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Few elections" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Many elections" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Elections on Tuesdays" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "More frequent elections" + // ANSWER 4
                                    "</body></html>"),
                    new Question("<html><body width='400px'>" +
                                "What is issue advocacy?" + // QUESTION 8
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Organized effort to advance (or block) a proposed public policy change" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Efforts to encourage people to engage in the public sphere" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "The idea that the cost of voting outweighs the benefits of voting" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "A measure of which proportion of eligible voters actually cast a vote" + // ANSWER 4
                                    "</body></html>"),
                    new Question("<html><body width='400px'>" +
                                "Which movement appears to be grassroots but is actually mobilized by political professionals?" + // QUESTION 9
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Astroturf" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Grassroots" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Dog whistling" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Actorvist" + // ANSWER 4
                                    "</body></html>"),
                    new Question("<html><body width='400px'>" +
                                "Which person would be most likely to vote?" + // QUESTION 10
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "A person whose parents vote" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "A person whose parents have never voted" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "A person who does not engage in politics" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "A person who is really busy" + // ANSWER 4
                                    "</body></html>")));  

    // CHAPTER 9
    private static ArrayList<Question> chapter9Quiz = new ArrayList<Question>(Arrays.asList(
                    new Question("<html><body width='300px'>" +
                                "Which is NOT one of the government's role in media?" + // QUESTION 1
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Enforce the Fairness Doctrine" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Inform the public" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Act as a political watchdog" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Shape the political agenda" + // ANSWER 4
                                    "</body></html>"), 
                    new Question("<html><body width='300px'>" +
                                "What incident destroyed the relationship between the media and politics?" + // QUESTION 2
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Watergate scandal" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Fairness Doctrine" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Egbert the bunny" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Telecommunications Act of 1996" + // ANSWER 4
                                    "</body></html>"), 
                    new Question("<html><body width='300px'>" +
                                "Which technological advancements listed changed the way that the public consumes entertainment and politics?" + // QUESTION 3
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Television, Radio, and social media" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Television" + // ANSWER 2 
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Radio" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Social media" + // ANSWER 4
                                    "</body></html>"), 
                    new Question("<html><body width='300px'>" +
                                "What type of media market does the U.S. have currently?" + // QUESTION 4
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Public Market" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Private Market" + // ANSWER 2 
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Free Market" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Popular Market" + // ANSWER 4
                                    "</body></html>"), 
                    new Question("<html><body width='400px'>" +
                                "What is net neutrality?" + // QUESTION 5 
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Service providers cannot block or add any restrictions to access to any specific web sites/applications" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Service providers cannot favor a political party over another" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Restricts the amount of campaign ads a politician can run" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Allows service providers to block or add restrictions to access different web sites/applications" + // ANSWER 4
                                    "</body></html>"),
                    new Question("<html><body width='400px'>" +
                                "What is the Telecommunications Act of 1996?" + // QUESTION 6
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Allows anyone to buy any company, no limit on how much you can buy" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Restricts the number of companies a person can buy" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Limits communication between political parties" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Regulates policies through different media outlets (radio, television, etc.)" + // ANSWER 4
                                    "</body></html>"),
                    new Question("<html><body width='400px'>" +
                                "Which source listed do most people go to as a news source? (According to \"By the People\" Textbook)" + // QUESTION 7
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Social media" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Local/Cabel TV" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Network TV" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Radio" + // ANSWER 4
                                    "</body></html>"),
                    new Question("<html><body width='400px'>" +
                                "Which is an example of infotainment?" + // QUESTION 8
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Late night talk shows" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Fox News" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "ABC News" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Reality TV Shows" + // ANSWER 4
                                    "</body></html>"),
                    new Question("<html><body width='400px'>" +
                                "Which institution of media is on an incline?" + // QUESTION 9
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Internet Sources" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Newspapers" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Newsmagazines" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Local television" + // ANSWER 4
                                    "</body></html>"),
                    new Question("<html><body width='400px'>" +
                                "What does FCC stand for?" + // QUESTION 10
                                "</body></html>",
                                    "<html><body width='300px'>" +
                                    "Federal Communications Commission" + // ANSWER 1 **CORRECT ANSWER**
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Fast Communication Center" + // ANSWER 2
                                    "</body></html>", 
                                    "<html><body width='300px'>" +
                                    "Federal Communication Cost" + // ANSWER 3
                                    "</body></html>",
                                    "<html><body width='300px'>" + 
                                    "Frequent Capital Communication" + // ANSWER 4
                                    "</body></html>")));

                                                            

    private static JFrame frame;

    private static JPanel panelCont;
    private static JPanel mainMenuPanel;
    private static JPanel quizPanel;
    private static JPanel endPanel;
    
    private static CardLayout cl;

    private static JLabel title;
    private static JLabel questionNum;
    private static JLabel currentQuestion;
    private static JLabel score;
    private static JLabel errorMsgLabel;
    private static JLabel endScore;
    private static JLabel endLabel;

    private static JButton chapter7Button;
    private static JButton chapter8Button;
    private static JButton chapter9Button;
    private static JButton next;
    private static JButton submit;
    private static JButton takeAgainButton;
    private static JButton toMenuButton;

    private static JRadioButton answer1Radio;
    private static JRadioButton answer2Radio;
    private static JRadioButton answer3Radio;
    private static JRadioButton answer4Radio;

    private static ButtonGroup answerGroup;

    // GUI SETUP
    public Quiz() {

        Font titleFont = new Font("Britannic Bold", Font.BOLD, 50);
        Font defaultFont = new Font("Britannic Bold", Font.PLAIN, 20);
        Font questionFont = new Font("Britannic Bold", Font.BOLD, 25);

        GridBagConstraints c = new GridBagConstraints();

        cl = new CardLayout();
        panelCont = new JPanel();
        panelCont.setLayout(cl);

        frame = new JFrame();
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CONFIGURE mainMenuPanel 
        mainMenuPanel = new JPanel();
        mainMenuPanel.setBackground(warmbrown);
        mainMenuPanel.setLayout(new GridBagLayout());

        title = new JLabel("PAY IT FORWARD QUIZ");
        title.setFont(titleFont);
        title.setForeground(smoothnavy);
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 0, 0, 0);
        mainMenuPanel.add(title, c);

        chapter7Button = new JButton("Chapter 7");
        chapter7Button.setFont(defaultFont);
        chapter7Button.setBackground(lightestbrown);
        chapter7Button.setForeground(smoothnavy);
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 100;
        mainMenuPanel.add(chapter7Button, c);
        chapter7Button.addActionListener(new Chapter7ActionListener());

        chapter8Button = new JButton("Chapter 8");
        chapter8Button.setFont(defaultFont);
        chapter8Button.setBackground(lightestbrown);
        chapter8Button.setForeground(smoothnavy);
        c.gridx = 0;
        c.gridy = 2;
        mainMenuPanel.add(chapter8Button, c);
        chapter8Button.addActionListener(new Chapter8ActionListener());

        chapter9Button = new JButton("Chapter 9");
        chapter9Button.setFont(defaultFont);
        chapter9Button.setBackground(lightestbrown);
        chapter9Button.setForeground(smoothnavy);
        c.gridx = 0;
        c.gridy = 3;
        mainMenuPanel.add(chapter9Button, c);
        chapter9Button.addActionListener(new Chapter9ActionListener());

        c.ipadx = 0;

        // CONFIGURE quizPanel 
        quizPanel = new JPanel();
        quizPanel.setLayout(new GridBagLayout());
        quizPanel.setBackground(warmbrown);

        questionNum = new JLabel(" ");
        questionNum.setFont(questionFont);
        questionNum.setForeground(smoothnavy);
        c.anchor = c.WEST;
        c.gridx = 0;
        c.gridy = 0;
        quizPanel.add(questionNum, c);
        c.anchor = c.CENTER;

        score = new JLabel("Score:");
        score.setFont(questionFont);
        score.setForeground(smoothnavy);
        c.gridx = 1;
        c.gridy = 0;
        quizPanel.add(score, c);

        currentQuestion = new JLabel("Current Question");
        currentQuestion.setFont(questionFont);
        currentQuestion.setForeground(smoothnavy);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        quizPanel.add(currentQuestion, c);

        answer1Radio = new JRadioButton("Answer 1");
        answer1Radio.setBackground(warmbrown);
        answer1Radio.setFont(defaultFont);
        answer1Radio.setForeground(smoothnavy);
        c.anchor = c.WEST;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        quizPanel.add(answer1Radio, c);

        answer2Radio = new JRadioButton("Answer 2");
        answer2Radio.setBackground(warmbrown);
        answer2Radio.setFont(defaultFont);
        answer2Radio.setForeground(smoothnavy);
        c.gridx = 0;
        c.gridy = 3;
        quizPanel.add(answer2Radio, c);

        answer3Radio = new JRadioButton("Answer 3");
        answer3Radio.setBackground(warmbrown);
        answer3Radio.setFont(defaultFont);
        answer3Radio.setForeground(smoothnavy);
        c.gridx = 0;
        c.gridy = 4;
        quizPanel.add(answer3Radio, c);

        answer4Radio = new JRadioButton("Answer 4");
        answer4Radio.setBackground(warmbrown);
        answer4Radio.setFont(defaultFont);
        answer4Radio.setForeground(smoothnavy);
        c.gridx = 0;
        c.gridy = 5;
        quizPanel.add(answer4Radio, c);
        c.anchor = c.CENTER;

        answerGroup = new ButtonGroup();
        answerGroup.add(answer1Radio);
        answerGroup.add(answer2Radio);
        answerGroup.add(answer3Radio);
        answerGroup.add(answer4Radio);

        next = new JButton("Next");
        next.setVisible(false);
        next.setFont(defaultFont);
        next.setBackground(medbrown);
        next.setForeground(smoothnavy);
        c.gridx = 1;
        c.gridy = 5;
        quizPanel.add(next, c);
        next.addActionListener(new NextActionListener());

        submit = new JButton("Submit");
        submit.setFont(defaultFont);
        submit.setBackground(medbrown);
        submit.setForeground(smoothnavy);
        c.gridx = 1;
        c.gridy = 5;
        quizPanel.add(submit, c);
        submit.addActionListener(new SubmitActionListener()); 

        errorMsgLabel = new JLabel("");
        errorMsgLabel.setForeground(Color.RED);
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        quizPanel.add(errorMsgLabel, c);
        c.gridwidth = 1;

        // CONFIGURE endPanel 
        endPanel = new JPanel();
        endPanel.setLayout(new GridBagLayout());
        endPanel.setBackground(warmbrown);

        endLabel = new JLabel("QUIZ COMPLETE!");
        endLabel.setFont(titleFont);
        endLabel.setForeground(smoothnavy);
        c.gridx = 0;
        c.gridy = 0;
        endPanel.add(endLabel, c);

        endScore = new JLabel(score.getText());
        endScore.setFont(questionFont);
        endScore.setForeground(smoothnavy);
        c.gridx = 0;
        c.gridy = 1;
        endPanel.add(endScore, c);

        takeAgainButton = new JButton("Take Again");
        takeAgainButton.setFont(defaultFont);
        takeAgainButton.setBackground(medbrown);
        takeAgainButton.setForeground(smoothnavy);
        c.gridx = 0;
        c.gridy = 2;
        endPanel.add(takeAgainButton, c);
        takeAgainButton.addActionListener(new TakeAgainActionListener());

        toMenuButton = new JButton("Main Menu");
        toMenuButton.setFont(defaultFont);
        toMenuButton.setBackground(medbrown);
        toMenuButton.setForeground(smoothnavy);
        c.gridx = 0;
        c.gridy = 3;
        endPanel.add(toMenuButton, c);
        toMenuButton.addActionListener(new ToMenuActionListener());

        frame.add(mainMenuPanel);
        frame.add(quizPanel);
        frame.add(panelCont);

        panelCont.add(mainMenuPanel, "mainMenuPanel");
        panelCont.add(quizPanel, "quizPanel");
        panelCont.add(endPanel, "endPanel");
        cl.show(panelCont, "mainMenuPanel");

        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new Quiz();
    }

    // Update Swing elements for "every question"
    public void takeQuiz(ArrayList<Question> currentQuizList, int index) {
        questionNum.setText((index + 1) + "/" + currentQuizList.size());
        currentQuestion.setText(currentQuizList.get(index).getQuestion());
        ArrayList<String> answerList = currentQuizList.get(index).getAnswerList();
        Collections.shuffle(answerList);
        answer1Radio.setText(answerList.get(0));
        answer2Radio.setText(answerList.get(1));
        answer3Radio.setText(answerList.get(2));
        answer4Radio.setText(answerList.get(3));
    }
    
    // grade answer selected
    // updates currentCount
    // returns true if correct and false if wrong
    public boolean grade(String answer) {
        if (answer.equals(currentQuizList.get(index).getAnswer())) {
            correctCount++;
            return true;
        }
        return false;
    }

    // set up different quiz elements before quiz starts
    public void quizSetup() {
        cl.show(panelCont, "quizPanel");
        score.setText("Score:");
        errorMsgLabel.setText(" ");
        index = 0;
        correctCount = 0;
        Collections.shuffle(currentQuizList);
        takeQuiz(currentQuizList, index);
    }

    private class Chapter7ActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentQuizList = chapter7Quiz;
            quizSetup();
            takeQuiz(currentQuizList, index);
        }
    }

    private class Chapter8ActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentQuizList = chapter8Quiz;
            quizSetup();
            takeQuiz(currentQuizList, index);
        }
    }

    private class Chapter9ActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            currentQuizList = chapter9Quiz;
            quizSetup();
            takeQuiz(currentQuizList, index);
        }
    }

    private class SubmitActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // find radioButton selected
            // if answer is correct -- set radioButton to GREEN
            // else -- set radioButton to RED
            // -- disable all other buttons
            if (answerGroup.isSelected(null)) { // if NO answer is selected
                errorMsgLabel.setText("You must select an answer to submit.");
            }
            else {
                if (answer1Radio.isSelected()) {
                    if (grade(answer1Radio.getText())) {
                        answer1Radio.setForeground(softgreen);
                        answer2Radio.setEnabled(false);
                        answer3Radio.setEnabled(false);
                        answer4Radio.setEnabled(false);
                    } 
                    else {
                        answer1Radio.setForeground(softred);
                        answer2Radio.setEnabled(false);
                        answer3Radio.setEnabled(false);
                        answer4Radio.setEnabled(false);
                    }
                }
                else if (answer2Radio.isSelected()) {
                    if (grade(answer2Radio.getText())) {
                        answer2Radio.setForeground(softgreen);
                        answer1Radio.setEnabled(false);
                        answer3Radio.setEnabled(false);
                        answer4Radio.setEnabled(false);
                    }
                    else {
                        answer2Radio.setForeground(softred);
                        answer1Radio.setEnabled(false);
                        answer3Radio.setEnabled(false);
                        answer4Radio.setEnabled(false);
                    }
                }
                else if (answer3Radio.isSelected()) {
                    if (grade(answer3Radio.getText())) {
                        answer3Radio.setForeground(softgreen);
                        answer1Radio.setEnabled(false);
                        answer2Radio.setEnabled(false);
                        answer4Radio.setEnabled(false);
                    }
                    else {
                        answer3Radio.setForeground(softred);
                        answer1Radio.setEnabled(false);
                        answer2Radio.setEnabled(false);
                        answer4Radio.setEnabled(false);
                    }
                }
                else if (answer4Radio.isSelected()) {
                    if (grade(answer4Radio.getText())) {
                        answer4Radio.setForeground(softgreen);
                        answer1Radio.setEnabled(false);
                        answer2Radio.setEnabled(false);
                        answer3Radio.setEnabled(false);
                    }
                    else {
                        answer4Radio.setForeground(softred);
                        answer1Radio.setEnabled(false);
                        answer2Radio.setEnabled(false);
                        answer3Radio.setEnabled(false);
                    }
                }
                
                // updates score (displayed as percentage)
                float questionTotal = index + 1;
                score.setText("Score: " + (int)((correctCount * 100.0f) / questionTotal) + "%");
                errorMsgLabel.setText(" ");
                submit.setVisible(false);
                next.setVisible(true);
            }
        }
    }

    private class NextActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            index++;
            errorMsgLabel.setText(" ");
            submit.setVisible(true);
            next.setVisible(false);
            if (index < currentQuizList.size()) {
                takeQuiz(currentQuizList, index);
            }
            else {
                cl.show(panelCont, "endPanel");
                endScore.setText(score.getText());
            } 
            // reset radioButtons
            answerGroup.clearSelection();
            answer1Radio.setForeground(smoothnavy);
            answer1Radio.setEnabled(true);
            answer2Radio.setForeground(smoothnavy);
            answer2Radio.setEnabled(true);
            answer3Radio.setForeground(smoothnavy);
            answer3Radio.setEnabled(true);
            answer4Radio.setForeground(smoothnavy);
            answer4Radio.setEnabled(true);
        }
    }

    private class ToMenuActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            cl.show(panelCont, "mainMenuPanel");
        }
    }

    private class TakeAgainActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            quizSetup();
            takeQuiz(currentQuizList, index);
        }
    }
}