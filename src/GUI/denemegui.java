package GUI;
import javax.swing.*;


public class denemegui{
    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("Dropdown Menu Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null); // Using absolute layout for flexibility

        // Create a JComboBox (dropdown menu)
        String[] options = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> dropdown = new JComboBox<>(options);
        dropdown.setBounds(50, 50, 150, 30); // Set position and size

        // Create a JLabel to show the selected option
        JLabel label = new JLabel("Selected: ");
        label.setBounds(50, 100, 300, 30);

        // Add an ActionListener to the dropdown
        dropdown.addActionListener(e -> {
            String selectedOption = (String) dropdown.getSelectedItem();
            label.setText("Selected: " + selectedOption);
        });

        // Add components to the frame
        frame.add(dropdown);
        frame.add(label);

        // Make the frame visible
        frame.setVisible(true);
    }
}
