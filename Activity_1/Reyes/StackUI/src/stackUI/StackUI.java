package stackUI;

	import javax.swing.*;
	import java.awt.*;
	import java.util.ArrayDeque;
	import java.util.Deque;

	public class StackUI extends JFrame {

	    // 1. Data State using Java's ArrayDeque (preferred Stack structure)
	    private final Deque<String> backStack = new ArrayDeque<>();
	    private final Deque<String> forwardStack = new ArrayDeque<>();
	    private String currentPage = "home.com";

	    // UI Components
	    private final JTextField urlInput1 = new JTextField(15);
	    private final JButton backBtn = new JButton("← Back");
	    private final JButton forwardBtn = new JButton("Forward →");
	    private final JButton visitBtn = new JButton("Visit URL");
	    
	    private final JLabel currentLabel = new JLabel("home.com", SwingConstants.CENTER);
	    private final DefaultListModel<String> backListModel = new DefaultListModel<>();
	    private final DefaultListModel<String> forwardListModel = new DefaultListModel<>();

	    public StackUI() {
	        setTitle("Browser History Visualizer (Java Swing)");
	        setSize(600, 400);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new BorderLayout(10, 10));

	        // Top Controls Panel
	        JPanel controlsPanel = new JPanel();
	        controlsPanel.add(urlInput1);
	        controlsPanel.add(visitBtn);
	        controlsPanel.add(backBtn);
	        controlsPanel.add(forwardBtn);
	        add(controlsPanel, BorderLayout.NORTH);

	        // Center Simulation Display Panel
	        JPanel centerPanel = new JPanel(new GridLayout(1, 3, 10, 10));

	        // Back Stack Panel
	        JList<String> backUIList = new JList<>(backListModel);
	        JPanel backPanel = createStackPanel("Back Stack", backUIList);

	        // Current Page Panel
	        JPanel currentPanel = new JPanel(new BorderLayout());
	        currentPanel.setBorder(BorderFactory.createTitledBorder("Current Page"));
	        currentLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
	        currentLabel.setForeground(new Color(37, 99, 235));
	        currentPanel.add(currentLabel, BorderLayout.CENTER);

	        // Forward Stack Panel
	        JList<String> forwardUIList = new JList<>(forwardListModel);
	        JPanel forwardPanel = createStackPanel("Forward Stack", forwardUIList);

	        centerPanel.add(backPanel);
	        centerPanel.add(currentPanel);
	        centerPanel.add(forwardPanel);
	        add(centerPanel, BorderLayout.CENTER);

	        // Event Listeners
	        visitBtn.addActionListener(e -> visitPage());
	        backBtn.addActionListener(e -> goBack());
	        forwardBtn.addActionListener(e -> goForward());

	        updateUIState();
	    }

	    private JPanel createStackPanel(String title, JList<String> list) {
	        JPanel panel = new JPanel(new BorderLayout());
	        panel.setBorder(BorderFactory.createTitledBorder(title));
	        panel.add(new JScrollPane(list), BorderLayout.CENTER);
	        return panel;
	    }

	    // 2. State Mutators & Logic
	    private void visitPage() {
	        String newUrl = urlInput1.getText().trim();
	        if (!newUrl.isEmpty()) {
	            backStack.push(currentPage);
	            currentPage = newUrl;
	            forwardStack.clear(); // Visiting a new page resets forward history
	            urlInput1.setText("");
	            updateUIState();
	        }
	    }

	    private void goBack() {
	        if (!backStack.isEmpty()) {
	            forwardStack.push(currentPage);
	            currentPage = backStack.pop();
	            updateUIState();
	        }
	    }

	    private void goForward() {
	        if (!forwardStack.isEmpty()) {
	            backStack.push(currentPage);
	            currentPage = forwardStack.pop();
	            updateUIState();
	        }
	    }

	    // 3. Sync Swing UI with Stack Data
	    private void updateUIState() {
	        currentLabel.setText(currentPage);

	        // Update Back Stack UI
	        backListModel.clear();
	        for (String url : backStack) {
	            backListModel.addElement(url);
	        }

	        // Update Forward Stack UI
	        forwardListModel.clear();
	        for (String url : forwardStack) {
	            forwardListModel.addElement(url);
	        }

	        // Enable/Disable navigation buttons based on stack contents
	        backBtn.setEnabled(!backStack.isEmpty());
	        forwardBtn.setEnabled(!forwardStack.isEmpty());
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new StackUI().setVisible(true));
	    }
	}
